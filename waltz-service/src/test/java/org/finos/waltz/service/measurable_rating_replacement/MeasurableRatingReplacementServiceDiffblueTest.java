package org.finos.waltz.service.measurable_rating_replacement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingReplacementServiceDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#findForEntityRef(EntityReference)}
   */
  @Test
  void testFindForEntityRef() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.fetchByEntityRef(Mockito.<EntityReference>any()))
        .thenReturn(measurableRatingReplacementSet);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, new ApplicationService(appDao,
            new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        null, mock(ApplicationDao.class));

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);

    // Act
    Collection<MeasurableRatingReplacement> actualFindForEntityRefResult = (new MeasurableRatingReplacementService(
        measurableRatingReplacementDao, measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForEntityRef(null);

    // Assert
    verify(measurableRatingReplacementDao).fetchByEntityRef(isNull());
    assertTrue(actualFindForEntityRefResult instanceof Set);
    assertTrue(actualFindForEntityRefResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualFindForEntityRefResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#findForEntityRef(EntityReference)}
   */
  @Test
  void testFindForEntityRef2() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByEntityRef(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, new ApplicationService(appDao,
            new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        null, mock(ApplicationDao.class));

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingReplacementService(measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver2,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findForEntityRef(null));
    verify(measurableRatingReplacementDao).fetchByEntityRef(isNull());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndSubjectIdSelector() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.findForCategoryAndSubjectIdSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenReturn(measurableRatingReplacementSet);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, new ApplicationService(appDao,
            new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        null, mock(ApplicationDao.class));

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);

    // Act
    Collection<MeasurableRatingReplacement> actualFindForCategoryAndSubjectIdSelectorResult = (new MeasurableRatingReplacementService(
        measurableRatingReplacementDao, measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForCategoryAndSubjectIdSelector(mock(Select.class), 1L);

    // Assert
    verify(measurableRatingReplacementDao).findForCategoryAndSubjectIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult instanceof Set);
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualFindForCategoryAndSubjectIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndSubjectIdSelector2() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.findForCategoryAndSubjectIdSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, new ApplicationService(appDao,
            new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        null, mock(ApplicationDao.class));

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingReplacementService(measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver2,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findForCategoryAndSubjectIdSelector(mock(Select.class), 1L));
    verify(measurableRatingReplacementDao).findForCategoryAndSubjectIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndMeasurableRatingIdSelector() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(measurableRatingReplacementSet);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, new ApplicationService(appDao,
            new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        null, mock(ApplicationDao.class));

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);

    // Act
    Set<MeasurableRatingReplacement> actualFindForCategoryAndMeasurableRatingIdSelectorResult = (new MeasurableRatingReplacementService(
        measurableRatingReplacementDao, measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForCategoryAndMeasurableRatingIdSelector(mock(Select.class), 1L);

    // Assert
    verify(measurableRatingReplacementDao).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndMeasurableRatingIdSelectorResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualFindForCategoryAndMeasurableRatingIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndMeasurableRatingIdSelector2() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, new ApplicationService(appDao,
            new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        null, mock(ApplicationDao.class));

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingReplacementService(measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver2,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findForCategoryAndMeasurableRatingIdSelector(mock(Select.class), 1L));
    verify(measurableRatingReplacementDao).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}
   */
  @Test
  void testSave() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    when(measurableRatingReplacementDao.fetchByDecommissionIdAndEntityRef(Mockito.<Long>any(),
        Mockito.<EntityReference>any())).thenReturn(null);
    when(measurableRatingReplacementDao.save(anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(),
        Mockito.<String>any())).thenReturn(new Tuple2<>(Operation.ADD, true));
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getByDecommId(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<MeasurableRatingReplacement>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    MeasurableRatingReplacementService measurableRatingReplacementService = new MeasurableRatingReplacementService(
        measurableRatingReplacementDao, mock(MeasurableRatingPlannedDecommissionDao.class), measurableRatingService,
        mock(EntityReferenceNameResolver.class), changeLogService);

    // Act
    Set<MeasurableRatingReplacement> actualSaveResult = measurableRatingReplacementService.save(1L, null,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), "janedoe");

    // Assert
    verify(measurableRatingReplacementDao).fetchByDecommissionId(eq(1L));
    verify(measurableRatingReplacementDao).fetchByDecommissionIdAndEntityRef(eq(1L), isNull());
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
    verify(changeLogService).writeChangeLogEntries((MeasurableRatingReplacement) isNull(), eq("janedoe"),
        eq("Added with planned commission date: Thu Jan 01 00:00:00 UTC 1970"), eq(Operation.ADD));
    verify(measurableRatingService).getByDecommId(eq(1L));
    assertTrue(actualSaveResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualSaveResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}
   */
  @Test
  void testSave2() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    when(measurableRatingReplacementDao.fetchByDecommissionIdAndEntityRef(Mockito.<Long>any(),
        Mockito.<EntityReference>any())).thenReturn(null);
    when(measurableRatingReplacementDao.save(anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(),
        Mockito.<String>any())).thenReturn(new Tuple2<>(Operation.ATTEST, true));
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getByDecommId(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<MeasurableRatingReplacement>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    MeasurableRatingReplacementService measurableRatingReplacementService = new MeasurableRatingReplacementService(
        measurableRatingReplacementDao, mock(MeasurableRatingPlannedDecommissionDao.class), measurableRatingService,
        mock(EntityReferenceNameResolver.class), changeLogService);

    // Act
    Set<MeasurableRatingReplacement> actualSaveResult = measurableRatingReplacementService.save(1L, null,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), "janedoe");

    // Assert
    verify(measurableRatingReplacementDao).fetchByDecommissionId(eq(1L));
    verify(measurableRatingReplacementDao).fetchByDecommissionIdAndEntityRef(eq(1L), isNull());
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
    verify(changeLogService).writeChangeLogEntries((MeasurableRatingReplacement) isNull(), eq("janedoe"),
        eq("Updated with planned commission date: Thu Jan 01 00:00:00 UTC 1970"), eq(Operation.ATTEST));
    verify(measurableRatingService).getByDecommId(eq(1L));
    assertTrue(actualSaveResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualSaveResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#remove(long, long, String)}
   */
  @Test
  void testRemove() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.remove(anyLong(), anyLong())).thenReturn(true);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);

    // Act
    Collection<MeasurableRatingReplacement> actualRemoveResult = (new MeasurableRatingReplacementService(
        measurableRatingReplacementDao, measurableRatingPlannedDecommissionDao,
        new MeasurableRatingService(measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService2,
            ratingSchemeService, entityReferenceNameResolver, measurableService,
            new ApplicationService(appDao, new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class),
                mock(ApplicationSearchDao.class)),
            null, mock(ApplicationDao.class)),
        mock(EntityReferenceNameResolver.class), changeLogService)).remove(1L, 1L, "janedoe");

    // Assert
    verify(measurableRatingReplacementDao).fetchByDecommissionId(eq(1L));
    verify(measurableRatingReplacementDao).remove(eq(1L), eq(1L));
    verify(changeLogService).writeChangeLogEntries(isA(EntityReference.class), eq("janedoe"), eq("Removed"),
        eq(Operation.REMOVE));
    assertTrue(actualRemoveResult instanceof Set);
    assertTrue(actualRemoveResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  void testGetRequiredRatingEditRole() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenReturn("Required Rating Edit Role");
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, new ApplicationService(appDao,
            new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        null, mock(ApplicationDao.class));

    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);

    // Act
    String actualRequiredRatingEditRole = (new MeasurableRatingReplacementService(measurableRatingReplacementDao,
        measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getRequiredRatingEditRole(null);

    // Assert
    verify(measurableDao).getRequiredRatingEditRole(isNull());
    assertEquals("Required Rating Edit Role", actualRequiredRatingEditRole);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  void testGetRequiredRatingEditRole2() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenReturn("Required Rating Edit Role");
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    String actualRequiredRatingEditRole = (new MeasurableRatingReplacementService(measurableRatingReplacementDao,
        measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getRequiredRatingEditRole(null);

    // Assert
    verify(measurableRatingService).getRequiredRatingEditRole(isNull());
    assertEquals("Required Rating Edit Role", actualRequiredRatingEditRole);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#findByDecommId(Long)}
   */
  @Test
  void testFindByDecommId() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, new ApplicationService(appDao,
            new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        null, mock(ApplicationDao.class));

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);

    // Act
    Set<MeasurableRatingReplacement> actualFindByDecommIdResult = (new MeasurableRatingReplacementService(
        measurableRatingReplacementDao, measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByDecommId(1L);

    // Assert
    verify(measurableRatingReplacementDao).fetchByDecommissionId(eq(1L));
    assertTrue(actualFindByDecommIdResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualFindByDecommIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingReplacementService#findByDecommId(Long)}
   */
  @Test
  void testFindByDecommId2() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, new ApplicationService(appDao,
            new TagService(mock(TagDao.class), null), mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        null, mock(ApplicationDao.class));

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingReplacementService(measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao, measurableRatingService, nameResolver2,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findByDecommId(1L));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(eq(1L));
  }
}
