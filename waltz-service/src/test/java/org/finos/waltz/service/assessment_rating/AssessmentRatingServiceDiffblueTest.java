package org.finos.waltz.service.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.assessment_definition.AssessmentRipplerJobConfiguration;
import org.finos.waltz.model.assessment_rating.AssessmentDefinitionRatingOperations;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.BulkAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.UpdateRatingCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.involvement.EntityInvolvementChangeCommand;
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
import org.jooq.TransactionalCallable;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingServiceDiffblueTest {
  /**
   * Method under test:
   * {@link AssessmentRatingService#findForEntity(EntityReference)}
   */
  @Test
  void testFindForEntity() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any())).thenReturn(assessmentRatingList);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act
    List<AssessmentRating> actualFindForEntityResult = (new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
            .findForEntity(null);

    // Assert
    verify(assessmentRatingDao).findForEntity(isNull());
    assertTrue(actualFindForEntityResult.isEmpty());
    assertSame(assessmentRatingList, actualFindForEntityResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#findForEntity(EntityReference)}
   */
  @Test
  void testFindForEntity2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .findForEntity(null));
    verify(assessmentRatingDao).findForEntity(isNull());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#findByEntityKind(EntityKind)}
   */
  @Test
  void testFindByEntityKind() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();
    when(assessmentRatingDao.findByEntityKind(Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentRatingList);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act
    List<AssessmentRating> actualFindByEntityKindResult = (new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
            .findByEntityKind(EntityKind.ALL);

    // Assert
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.ALL), isA(Optional.class));
    assertTrue(actualFindByEntityKindResult.isEmpty());
    assertSame(assessmentRatingList, actualFindByEntityKindResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#findByEntityKind(EntityKind)}
   */
  @Test
  void testFindByEntityKind2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .findByEntityKind(EntityKind.ALL));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.ALL), isA(Optional.class));
  }

  /**
   * Method under test: {@link AssessmentRatingService#findByDefinitionId(long)}
   */
  @Test
  void testFindByDefinitionId() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();
    when(assessmentRatingDao.findByDefinitionId(anyLong())).thenReturn(assessmentRatingList);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act
    List<AssessmentRating> actualFindByDefinitionIdResult = (new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
            .findByDefinitionId(1L);

    // Assert
    verify(assessmentRatingDao).findByDefinitionId(eq(1L));
    assertTrue(actualFindByDefinitionIdResult.isEmpty());
    assertSame(assessmentRatingList, actualFindByDefinitionIdResult);
  }

  /**
   * Method under test: {@link AssessmentRatingService#findByDefinitionId(long)}
   */
  @Test
  void testFindByDefinitionId2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByDefinitionId(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .findByDefinitionId(1L));
    verify(assessmentRatingDao).findByDefinitionId(eq(1L));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#lock(EntityReference, long, long, String)}
   */
  @Test
  void testLock() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(Mockito.<EntityReference>any(), anyLong(),
        Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class)))).lock(null,
                1L, 1L, "janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#unlock(EntityReference, long, long, String)}
   */
  @Test
  void testUnlock() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(Mockito.<EntityReference>any(), anyLong(),
        Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class)))).unlock(null,
                1L, 1L, "janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}
   */
  @Test
  void testBulkStore() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.getById(anyLong())).thenReturn(null);
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    RatingSchemeItem ratingSchemeItem2 = mock(RatingSchemeItem.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(ratingSchemeItem2.id()).thenReturn(ofResult2);
    RatingSchemeItem ratingSchemeItem3 = mock(RatingSchemeItem.class);
    when(ratingSchemeItem3.id()).thenThrow(new IllegalArgumentException("Added"));

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(ratingSchemeItem3);
    ratingSchemeItemList.add(ratingSchemeItem2);
    ratingSchemeItemList.add(ratingSchemeItem);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .bulkStore(new BulkAssessmentRatingCommand[]{}, 1L, "janedoe"));
    verify(assessmentDefinitionDao, atLeast(1)).getById(eq(1L));
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(eq(1L));
    verify(ratingSchemeItem3).id();
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}
   */
  @Test
  void testBulkDelete() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(1);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.getById(anyLong())).thenReturn(null);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act
    boolean actualBulkDeleteResult = (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao,
        ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
            .bulkDelete(new BulkAssessmentRatingCommand[]{}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(eq(1L));
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(eq(1L));
    assertFalse(actualBulkDeleteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}
   */
  @Test
  void testBulkDelete2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(1);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.getById(anyLong())).thenReturn(null);
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(ratingSchemeItem);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act
    boolean actualBulkDeleteResult = (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao,
        ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
            .bulkDelete(new BulkAssessmentRatingCommand[]{}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(eq(1L));
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(eq(1L));
    verify(ratingSchemeItem).id();
    assertFalse(actualBulkDeleteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}
   */
  @Test
  void testBulkDelete3() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(1);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.getById(anyLong())).thenReturn(null);
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    RatingSchemeItem ratingSchemeItem2 = mock(RatingSchemeItem.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(ratingSchemeItem2.id()).thenReturn(ofResult2);

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(ratingSchemeItem2);
    ratingSchemeItemList.add(ratingSchemeItem);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act
    boolean actualBulkDeleteResult = (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao,
        ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
            .bulkDelete(new BulkAssessmentRatingCommand[]{}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(eq(1L));
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(eq(1L));
    verify(ratingSchemeItem2).id();
    verify(ratingSchemeItem).id();
    assertFalse(actualBulkDeleteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}
   */
  @Test
  void testBulkDelete4() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.getById(anyLong())).thenReturn(null);
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    RatingSchemeItem ratingSchemeItem2 = mock(RatingSchemeItem.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(ratingSchemeItem2.id()).thenReturn(ofResult2);
    RatingSchemeItem ratingSchemeItem3 = mock(RatingSchemeItem.class);
    when(ratingSchemeItem3.id()).thenThrow(new IllegalArgumentException("Removed"));

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(ratingSchemeItem3);
    ratingSchemeItemList.add(ratingSchemeItem2);
    ratingSchemeItemList.add(ratingSchemeItem);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .bulkDelete(new BulkAssessmentRatingCommand[]{}, 1L, "janedoe"));
    verify(assessmentDefinitionDao).getById(eq(1L));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(eq(1L));
    verify(ratingSchemeItem3).id();
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions() {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(Mockito.<EntityReference>any(), anyLong(),
        Mockito.<String>any())).thenReturn(null);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act
    AssessmentDefinitionRatingOperations actualRatingPermissions = (new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
            .getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    assertNull(actualRatingPermissions);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions2() {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(Mockito.<EntityReference>any(), anyLong(),
        Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .getRatingPermissions(null, 1L, "janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#updateComment(long, String, String)}
   */
  @Test
  void testUpdateComment() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .updateComment(1L, "Comment", "janedoe"));
    verify(assessmentRatingDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand, String)}
   */
  @Test
  void testUpdateRating() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .updateRating(1L, null, "janedoe"));
    verify(assessmentRatingDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#hasMultiValuedAssessments(long)}
   */
  @Test
  void testHasMultiValuedAssessments() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.hasMultiValuedAssessments(anyLong())).thenReturn(true);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act
    boolean actualHasMultiValuedAssessmentsResult = (new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
            .hasMultiValuedAssessments(1L);

    // Assert
    verify(assessmentRatingDao).hasMultiValuedAssessments(eq(1L));
    assertTrue(actualHasMultiValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#hasMultiValuedAssessments(long)}
   */
  @Test
  void testHasMultiValuedAssessments2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.hasMultiValuedAssessments(anyLong())).thenReturn(false);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act
    boolean actualHasMultiValuedAssessmentsResult = (new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
            .hasMultiValuedAssessments(1L);

    // Assert
    verify(assessmentRatingDao).hasMultiValuedAssessments(eq(1L));
    assertFalse(actualHasMultiValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#hasMultiValuedAssessments(long)}
   */
  @Test
  void testHasMultiValuedAssessments3() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.hasMultiValuedAssessments(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .hasMultiValuedAssessments(1L));
    verify(assessmentRatingDao).hasMultiValuedAssessments(eq(1L));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}
   */
  @Test
  void testFindBySelectorForDefinitions() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    when(assessmentRatingDao.findBySelectorForDefinitions(Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentRatingSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.addEntityInvolvement(Mockito.<String>any(), Mockito.<EntityReference>any(),
        Mockito.<EntityInvolvementChangeCommand>any())).thenReturn(true);
    involvementService.addEntityInvolvement("42", mock(EntityReference.class),
        mock(EntityInvolvementChangeCommand.class));
    AssessmentRatingDao assessmentRatingDao2 = mock(AssessmentRatingDao.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)), mock(PermissionGroupDao.class), null);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = new AssessmentRatingPermissionChecker(
        assessmentRatingDao2, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())));

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingService assessmentRatingService = new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService2, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class)));

    // Act
    Set<AssessmentRating> actualFindBySelectorForDefinitionsResult = assessmentRatingService
        .findBySelectorForDefinitions(null, new HashSet<>());

    // Assert
    verify(assessmentRatingDao).findBySelectorForDefinitions(isNull(), isA(Set.class));
    verify(involvementService).addEntityInvolvement(eq("42"), isA(EntityReference.class),
        isA(EntityInvolvementChangeCommand.class));
    assertTrue(actualFindBySelectorForDefinitionsResult.isEmpty());
    assertSame(assessmentRatingSet, actualFindBySelectorForDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}
   */
  @Test
  void testFindBySelectorForDefinitions2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    when(assessmentRatingDao.findBySelectorForDefinitions(Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentRatingSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.addEntityInvolvement(Mockito.<String>any(), Mockito.<EntityReference>any(),
        Mockito.<EntityInvolvementChangeCommand>any())).thenReturn(true);
    involvementService.addEntityInvolvement("42", mock(EntityReference.class),
        mock(EntityInvolvementChangeCommand.class));
    AssessmentRatingDao assessmentRatingDao2 = mock(AssessmentRatingDao.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)), mock(PermissionGroupDao.class), null);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = new AssessmentRatingPermissionChecker(
        assessmentRatingDao2, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())));

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingService assessmentRatingService = new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService2, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class)));

    HashSet<Long> defIds = new HashSet<>();
    defIds.add(2L);

    // Act
    Set<AssessmentRating> actualFindBySelectorForDefinitionsResult = assessmentRatingService
        .findBySelectorForDefinitions(null, defIds);

    // Assert
    verify(assessmentRatingDao).findBySelectorForDefinitions(isNull(), isA(Set.class));
    verify(involvementService).addEntityInvolvement(eq("42"), isA(EntityReference.class),
        isA(EntityInvolvementChangeCommand.class));
    assertTrue(actualFindBySelectorForDefinitionsResult.isEmpty());
    assertSame(assessmentRatingSet, actualFindBySelectorForDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}
   */
  @Test
  void testFindBySelectorForDefinitions3() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    when(assessmentRatingDao.findBySelectorForDefinitions(Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentRatingSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.addEntityInvolvement(Mockito.<String>any(), Mockito.<EntityReference>any(),
        Mockito.<EntityInvolvementChangeCommand>any())).thenReturn(true);
    involvementService.addEntityInvolvement("42", mock(EntityReference.class),
        mock(EntityInvolvementChangeCommand.class));
    AssessmentRatingDao assessmentRatingDao2 = mock(AssessmentRatingDao.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)), mock(PermissionGroupDao.class), null);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = new AssessmentRatingPermissionChecker(
        assessmentRatingDao2, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())));

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingService assessmentRatingService = new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService2, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class)));

    HashSet<Long> defIds = new HashSet<>();
    defIds.add(1L);
    defIds.add(2L);

    // Act
    Set<AssessmentRating> actualFindBySelectorForDefinitionsResult = assessmentRatingService
        .findBySelectorForDefinitions(null, defIds);

    // Assert
    verify(assessmentRatingDao).findBySelectorForDefinitions(isNull(), isA(Set.class));
    verify(involvementService).addEntityInvolvement(eq("42"), isA(EntityReference.class),
        isA(EntityInvolvementChangeCommand.class));
    assertTrue(actualFindBySelectorForDefinitionsResult.isEmpty());
    assertSame(assessmentRatingSet, actualFindBySelectorForDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}
   */
  @Test
  void testFindBySelectorForDefinitions4() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findBySelectorForDefinitions(Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.addEntityInvolvement(Mockito.<String>any(), Mockito.<EntityReference>any(),
        Mockito.<EntityInvolvementChangeCommand>any())).thenReturn(true);
    involvementService.addEntityInvolvement("42", mock(EntityReference.class),
        mock(EntityInvolvementChangeCommand.class));
    AssessmentRatingDao assessmentRatingDao2 = mock(AssessmentRatingDao.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)), mock(PermissionGroupDao.class), null);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = new AssessmentRatingPermissionChecker(
        assessmentRatingDao2, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())));

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingService assessmentRatingService = new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService2, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> assessmentRatingService.findBySelectorForDefinitions(null, new HashSet<>()));
    verify(assessmentRatingDao).findBySelectorForDefinitions(isNull(), isA(Set.class));
    verify(involvementService).addEntityInvolvement(eq("42"), isA(EntityReference.class),
        isA(EntityInvolvementChangeCommand.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testGetPrimaryAssessmentsViewForKindAndSelector() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(Mockito.<EntityKind>any(),
        Mockito.<Optional<EntityReference>>any())).thenThrow(new IllegalArgumentException("targetKind cannot be null"));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            changeLogService, assessmentRatingPermissionChecker,
            new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class))))
                .getPrimaryAssessmentsViewForKindAndSelector(EntityKind.ALL, null));
    verify(assessmentDefinitionDao).findPrimaryDefinitionsForKind(eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR),
        isA(Optional.class));
  }

  /**
   * Method under test: {@link AssessmentRatingService#rippleAll()}
   */
  @Test
  void testRippleAll() throws SQLException {
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

    // Act
    Long actualRippleAllResult = (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao,
        ratingSchemeDAO,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(AssessmentRatingPermissionChecker.class), rippler)).rippleAll();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertEquals(0L, actualRippleAllResult.longValue());
  }

  /**
   * Method under test: {@link AssessmentRatingService#rippleAll()}
   */
  @Test
  void testRippleAll2() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1L);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    AssessmentRatingRippler rippler = new AssessmentRatingRippler(dsl, settingsDao);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    // Act
    Long actualRippleAllResult = (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao,
        ratingSchemeDAO,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(AssessmentRatingPermissionChecker.class), rippler)).rippleAll();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1L, actualRippleAllResult.longValue());
  }

  /**
   * Method under test: {@link AssessmentRatingService#rippleAll()}
   */
  @Test
  void testRippleAll3() {
    // Arrange
    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenThrow(new IllegalArgumentException("foo"));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            mock(AssessmentRatingPermissionChecker.class), rippler)).rippleAll());
    verify(rippler).findRippleConfig();
  }

  /**
   * Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    AssessmentRatingRippler rippler = new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingService(
        assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(AssessmentRatingPermissionChecker.class), rippler)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig2() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler = new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingService(
        assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(AssessmentRatingPermissionChecker.class), rippler)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig3() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler = new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingService(
        assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(AssessmentRatingPermissionChecker.class), rippler)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig4() {
    // Arrange
    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    HashSet<AssessmentRipplerJobConfiguration> assessmentRipplerJobConfigurationSet = new HashSet<>();
    when(rippler.findRippleConfig()).thenReturn(assessmentRipplerJobConfigurationSet);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingService(
        assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(AssessmentRatingPermissionChecker.class), rippler)).findRippleConfig();

    // Assert
    verify(rippler).findRippleConfig();
    assertTrue(actualFindRippleConfigResult.isEmpty());
    assertSame(assessmentRipplerJobConfigurationSet, actualFindRippleConfigResult);
  }

  /**
   * Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig5() {
    // Arrange
    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenThrow(new IllegalArgumentException("foo"));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AssessmentRatingService(assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            mock(AssessmentRatingPermissionChecker.class), rippler)).findRippleConfig());
    verify(rippler).findRippleConfig();
  }

  /**
   * Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig6() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler = new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingService(
        assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(AssessmentRatingPermissionChecker.class), rippler)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig7() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("jobURIPPLE_ASSESSMENTSU", "jobURIPPLE_ASSESSMENTSU");
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler = new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingService(
        assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDAO,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(AssessmentRatingPermissionChecker.class), rippler)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }
}
