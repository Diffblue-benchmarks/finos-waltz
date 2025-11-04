package org.finos.waltz.service.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.command.DateFieldChange;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionInfo;
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

class MeasurableRatingPlannedDecommissionServiceDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForEntityRef(EntityReference)}
   */
  @Test
  void testFindForEntityRef() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    HashSet<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionSet = new HashSet<>();
    when(measurableRatingPlannedDecommissionDao.findByEntityRef(Mockito.<EntityReference>any()))
        .thenReturn(measurableRatingPlannedDecommissionSet);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act
    Collection<MeasurableRatingPlannedDecommission> actualFindForEntityRefResult = (new MeasurableRatingPlannedDecommissionService(
        measurableRatingPlannedDecommissionDao, measurableRatingReplacementDao, measurableRatingService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForEntityRef(null);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).findByEntityRef(isNull());
    assertTrue(actualFindForEntityRefResult instanceof Set);
    assertTrue(actualFindForEntityRefResult.isEmpty());
    assertSame(measurableRatingPlannedDecommissionSet, actualFindForEntityRefResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForEntityRef(EntityReference)}
   */
  @Test
  void testFindForEntityRef2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.findByEntityRef(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao, measurableRatingService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findForEntityRef(null));
    verify(measurableRatingPlannedDecommissionDao).findByEntityRef(isNull());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndSubjectIdSelector() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    HashSet<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionSet = new HashSet<>();
    when(measurableRatingPlannedDecommissionDao.findForCategoryAndSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenReturn(measurableRatingPlannedDecommissionSet);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act
    Collection<MeasurableRatingPlannedDecommission> actualFindForCategoryAndSubjectIdSelectorResult = (new MeasurableRatingPlannedDecommissionService(
        measurableRatingPlannedDecommissionDao, measurableRatingReplacementDao, measurableRatingService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForCategoryAndSubjectIdSelector(mock(Select.class), 1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).findForCategoryAndSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult instanceof Set);
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult.isEmpty());
    assertSame(measurableRatingPlannedDecommissionSet, actualFindForCategoryAndSubjectIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndSubjectIdSelector2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.findForCategoryAndSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao, measurableRatingService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findForCategoryAndSubjectIdSelector(mock(Select.class), 1L));
    verify(measurableRatingPlannedDecommissionDao).findForCategoryAndSelector(isA(Select.class), eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndMeasurableRatingIdSelector() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    HashSet<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionSet = new HashSet<>();
    when(measurableRatingPlannedDecommissionDao
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(measurableRatingPlannedDecommissionSet);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act
    Collection<MeasurableRatingPlannedDecommission> actualFindForCategoryAndMeasurableRatingIdSelectorResult = (new MeasurableRatingPlannedDecommissionService(
        measurableRatingPlannedDecommissionDao, measurableRatingReplacementDao, measurableRatingService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForCategoryAndMeasurableRatingIdSelector(mock(Select.class), 1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class),
        eq(1L));
    assertTrue(actualFindForCategoryAndMeasurableRatingIdSelectorResult instanceof Set);
    assertTrue(actualFindForCategoryAndMeasurableRatingIdSelectorResult.isEmpty());
    assertSame(measurableRatingPlannedDecommissionSet, actualFindForCategoryAndMeasurableRatingIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndMeasurableRatingIdSelector2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao, measurableRatingService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findForCategoryAndMeasurableRatingIdSelector(mock(Select.class), 1L));
    verify(measurableRatingPlannedDecommissionDao).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class),
        eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForReplacingEntityRef(EntityReference)}
   */
  @Test
  void testFindForReplacingEntityRef() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    ArrayList<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoList = new ArrayList<>();
    when(measurableRatingPlannedDecommissionDao.findByReplacingEntityRef(Mockito.<EntityReference>any()))
        .thenReturn(measurableRatingPlannedDecommissionInfoList);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act
    Collection<MeasurableRatingPlannedDecommissionInfo> actualFindForReplacingEntityRefResult = (new MeasurableRatingPlannedDecommissionService(
        measurableRatingPlannedDecommissionDao, measurableRatingReplacementDao, measurableRatingService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForReplacingEntityRef(null);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).findByReplacingEntityRef(isNull());
    assertTrue(actualFindForReplacingEntityRefResult instanceof List);
    assertTrue(actualFindForReplacingEntityRefResult.isEmpty());
    assertSame(measurableRatingPlannedDecommissionInfoList, actualFindForReplacingEntityRefResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForReplacingEntityRef(EntityReference)}
   */
  @Test
  void testFindForReplacingEntityRef2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.findByReplacingEntityRef(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao, measurableRatingService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findForReplacingEntityRef(null));
    verify(measurableRatingPlannedDecommissionDao).findByReplacingEntityRef(isNull());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForReplacingSubjectIdSelectorAndCategory(GenericSelector, long)}
   */
  @Test
  void testFindForReplacingSubjectIdSelectorAndCategory() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    ArrayList<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoList = new ArrayList<>();
    when(measurableRatingPlannedDecommissionDao
        .findForReplacingSubjectIdSelectorAndCategory(Mockito.<GenericSelector>any(), Mockito.<Long>any()))
            .thenReturn(measurableRatingPlannedDecommissionInfoList);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act
    Collection<MeasurableRatingPlannedDecommissionInfo> actualFindForReplacingSubjectIdSelectorAndCategoryResult = (new MeasurableRatingPlannedDecommissionService(
        measurableRatingPlannedDecommissionDao, measurableRatingReplacementDao, measurableRatingService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForReplacingSubjectIdSelectorAndCategory(null, 1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).findForReplacingSubjectIdSelectorAndCategory(isNull(), eq(1L));
    assertTrue(actualFindForReplacingSubjectIdSelectorAndCategoryResult instanceof List);
    assertTrue(actualFindForReplacingSubjectIdSelectorAndCategoryResult.isEmpty());
    assertSame(measurableRatingPlannedDecommissionInfoList, actualFindForReplacingSubjectIdSelectorAndCategoryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#findForReplacingSubjectIdSelectorAndCategory(GenericSelector, long)}
   */
  @Test
  void testFindForReplacingSubjectIdSelectorAndCategory2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao
        .findForReplacingSubjectIdSelectorAndCategory(Mockito.<GenericSelector>any(), Mockito.<Long>any()))
            .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao, measurableRatingService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findForReplacingSubjectIdSelectorAndCategory(null, 1L));
    verify(measurableRatingPlannedDecommissionDao).findForReplacingSubjectIdSelectorAndCategory(isNull(), eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#save(long, DateFieldChange, String)}
   */
  @Test
  void testSave() {
    // Arrange
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.plannedDecommissionDate()).thenReturn(LocalDate.of(1970, 1, 1));
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(measurableRatingPlannedDecommission);
    when(measurableRatingPlannedDecommissionDao.save(anyLong(), Mockito.<DateFieldChange>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);
    when(measurableRating.entityReference()).thenReturn(null);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<MeasurableRatingPlannedDecommission>any(), Mockito.<String>any(),
            Mockito.<String>any(), Mockito.<Operation>any());

    // Act
    (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
        mock(MeasurableRatingReplacementDao.class), measurableRatingService, changeLogService)).save(1L, null,
            "janedoe");

    // Assert
    verify(measurableRatingPlannedDecommissionDao).getByEntityAndMeasurable(isNull(), eq(1L));
    verify(measurableRatingPlannedDecommissionDao).save(eq(1L), isNull(), eq("janedoe"));
    verify(measurableRating).entityReference();
    verify(measurableRating).measurableId();
    verify(measurableRatingPlannedDecommission).plannedDecommissionDate();
    verify(changeLogService).writeChangeLogEntries(isA(MeasurableRatingPlannedDecommission.class), eq("janedoe"),
        eq("Added planned decommission date:1970-01-01"), eq(Operation.ADD));
    verify(measurableRatingService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}
   */
  @Test
  void testRemove() {
    // Arrange
    MeasurableRatingReplacement measurableRatingReplacement = mock(MeasurableRatingReplacement.class);
    when(measurableRatingReplacement.entityReference())
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    measurableRatingReplacementSet.add(measurableRatingReplacement);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao, measurableRatingService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .remove(1L, "janedoe"));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(eq(1L));
    verify(measurableRatingReplacement).entityReference();
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#getRequiredRatingEditRole(EntityReference)}
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

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);

    // Act
    String actualRequiredRatingEditRole = (new MeasurableRatingPlannedDecommissionService(
        measurableRatingPlannedDecommissionDao, measurableRatingReplacementDao, measurableRatingService,
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
   * {@link MeasurableRatingPlannedDecommissionService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  void testGetRequiredRatingEditRole2() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenReturn("Required Rating Edit Role");
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);

    // Act
    String actualRequiredRatingEditRole = (new MeasurableRatingPlannedDecommissionService(
        measurableRatingPlannedDecommissionDao, measurableRatingReplacementDao, measurableRatingService,
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
   * {@link MeasurableRatingPlannedDecommissionService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  void testGetRequiredRatingEditRole3() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao, measurableRatingService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .getRequiredRatingEditRole(null));
    verify(measurableRatingService).getRequiredRatingEditRole(isNull());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#getById(Long)}
   */
  @Test
  void testGetById() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any())).thenReturn(null);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act
    MeasurableRatingPlannedDecommission actualById = (new MeasurableRatingPlannedDecommissionService(
        measurableRatingPlannedDecommissionDao, measurableRatingReplacementDao, measurableRatingService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).getById(1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#getById(Long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao, measurableRatingService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .getById(1L));
    verify(measurableRatingPlannedDecommissionDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#getByMeasurableRatingId(Long)}
   */
  @Test
  void testGetByMeasurableRatingId() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Mockito.<Long>any())).thenReturn(null);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act
    MeasurableRatingPlannedDecommission actualByMeasurableRatingId = (new MeasurableRatingPlannedDecommissionService(
        measurableRatingPlannedDecommissionDao, measurableRatingReplacementDao, measurableRatingService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getByMeasurableRatingId(1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).getByMeasurableRatingId(eq(1L));
    assertNull(actualByMeasurableRatingId);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPlannedDecommissionService#getByMeasurableRatingId(Long)}
   */
  @Test
  void testGetByMeasurableRatingId2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
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

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new MeasurableRatingPlannedDecommissionService(measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao, measurableRatingService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .getByMeasurableRatingId(1L));
    verify(measurableRatingPlannedDecommissionDao).getByMeasurableRatingId(eq(1L));
  }
}
