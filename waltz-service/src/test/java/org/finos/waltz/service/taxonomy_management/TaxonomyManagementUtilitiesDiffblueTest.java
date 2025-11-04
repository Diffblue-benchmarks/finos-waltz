package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
import org.finos.waltz.data.measurable_category.MeasurableCategoryDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.measurable_rating.MeasurableRatingService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TaxonomyManagementUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)}
   */
  @Test
  void testValidatePrimaryMeasurable() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurable.id()).thenReturn(ofResult);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.getById(anyLong())).thenReturn(measurable);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.changeDomain()).thenReturn(entityReference2);
    when(cmd.primaryReference()).thenReturn(entityReference);

    // Act
    TaxonomyManagementUtilities.validatePrimaryMeasurable(measurableService, cmd);

    // Assert
    verify(measurableDao).getById(eq(1L));
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(measurable).id();
    verify(measurable).name();
    verify(measurable, atLeast(1)).categoryId();
    verify(cmd).changeDomain();
    verify(cmd).primaryReference();
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)}
   */
  @Test
  void testValidatePrimaryMeasurable2() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenThrow(new NotAuthorizedException("An error occurred"));
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.changeDomain()).thenReturn(entityReference2);
    when(cmd.primaryReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> TaxonomyManagementUtilities.validatePrimaryMeasurable(measurableService, cmd));
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(measurable).categoryId();
    verify(cmd).changeDomain();
    verify(cmd).primaryReference();
    verify(measurableService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List, long)}
   */
  @Test
  void testValidateMeasurablesInCategory() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    TaxonomyManagementUtilities.validateMeasurablesInCategory(measurableService, new ArrayList<>(), 1L);

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List, long)}
   */
  @Test
  void testValidateMeasurablesInCategory2() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurable.id()).thenReturn(ofResult);

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(measurable);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    TaxonomyManagementUtilities.validateMeasurablesInCategory(measurableService, new ArrayList<>(), 1L);

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L));
    verify(measurable).id();
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List, long)}
   */
  @Test
  void testValidateMeasurablesInCategory3() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurable.id()).thenReturn(ofResult);
    Measurable measurable2 = mock(Measurable.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(measurable2.id()).thenReturn(ofResult2);

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(measurable2);
    measurableList.add(measurable);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    TaxonomyManagementUtilities.validateMeasurablesInCategory(measurableService, new ArrayList<>(), 1L);

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L));
    verify(measurable2).id();
    verify(measurable).id();
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long, long)}
   */
  @Test
  void testValidateMeasurableInCategory() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurable.id()).thenReturn(ofResult);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.getById(anyLong())).thenReturn(measurable);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    TaxonomyManagementUtilities
        .validateMeasurableInCategory(new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
            1L, 1L);

    // Assert
    verify(measurableDao).getById(eq(1L));
    verify(measurable).id();
    verify(measurable).name();
    verify(measurable, atLeast(1)).categoryId();
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long, long)}
   */
  @Test
  void testValidateMeasurableInCategory2() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenThrow(new NotAuthorizedException("An error occurred"));
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> TaxonomyManagementUtilities.validateMeasurableInCategory(measurableService, 1L, 1L));
    verify(measurable).categoryId();
    verify(measurableService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable, Measurable)}
   */
  @Test
  void testValidateTargetNotChild() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(new ArrayList<>());
    Measurable measurable = mock(Measurable.class);
    when(measurable.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurable.id()).thenReturn(ofResult);
    when(measurable.entityReference()).thenReturn(mock(EntityReference.class));
    Measurable targetMeasurable = mock(Measurable.class);
    when(targetMeasurable.name()).thenReturn("Name");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(targetMeasurable.id()).thenReturn(ofResult2);

    // Act
    TaxonomyManagementUtilities.validateTargetNotChild(measurableService, measurable, targetMeasurable);

    // Assert
    verify(measurable).id();
    verify(targetMeasurable).id();
    verify(measurable).name();
    verify(targetMeasurable).name();
    verify(measurable).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable, Measurable)}
   */
  @Test
  void testValidateTargetNotChild2() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(new ArrayList<>());
    Measurable measurable = mock(Measurable.class);
    when(measurable.name()).thenThrow(new NotAuthorizedException("An error occurred"));
    when(measurable.id()).thenThrow(new NotAuthorizedException("An error occurred"));
    when(measurable.entityReference()).thenReturn(mock(EntityReference.class));
    Measurable targetMeasurable = mock(Measurable.class);
    when(targetMeasurable.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(targetMeasurable.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> TaxonomyManagementUtilities.validateTargetNotChild(measurableService, measurable, targetMeasurable));
    verify(targetMeasurable).id();
    verify(measurable).name();
    verify(targetMeasurable).name();
    verify(measurable).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}
   */
  @Test
  void testValidateConcreteMergeAllowed() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.concrete()).thenReturn(true);
    when(measurable.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurable.id()).thenReturn(ofResult);
    Measurable targetMeasurable = mock(Measurable.class);
    when(targetMeasurable.concrete()).thenReturn(true);
    when(targetMeasurable.name()).thenReturn("Name");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(targetMeasurable.id()).thenReturn(ofResult2);

    // Act
    TaxonomyManagementUtilities.validateConcreteMergeAllowed(measurable, targetMeasurable);

    // Assert
    verify(measurable).id();
    verify(targetMeasurable).id();
    verify(measurable).name();
    verify(targetMeasurable).name();
    verify(measurable).concrete();
    verify(targetMeasurable).concrete();
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}
   */
  @Test
  void testValidateConcreteMergeAllowed2() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.concrete()).thenReturn(true);
    Measurable targetMeasurable = mock(Measurable.class);
    when(targetMeasurable.concrete()).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> TaxonomyManagementUtilities.validateConcreteMergeAllowed(measurable, targetMeasurable));
    verify(measurable).concrete();
    verify(targetMeasurable).concrete();
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}
   */
  @Test
  void testValidateConcreteMergeAllowed3() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.concrete()).thenReturn(false);
    when(measurable.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurable.id()).thenReturn(ofResult);
    Measurable targetMeasurable = mock(Measurable.class);
    when(targetMeasurable.concrete()).thenReturn(true);
    when(targetMeasurable.name()).thenReturn("Name");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(targetMeasurable.id()).thenReturn(ofResult2);

    // Act
    TaxonomyManagementUtilities.validateConcreteMergeAllowed(measurable, targetMeasurable);

    // Assert
    verify(measurable).id();
    verify(targetMeasurable).id();
    verify(measurable).name();
    verify(targetMeasurable).name();
    verify(measurable).concrete();
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}
   */
  @Test
  void testValidateConcreteMergeAllowed4() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.concrete()).thenReturn(false);
    when(measurable.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurable.id()).thenReturn(ofResult);
    Measurable targetMeasurable = mock(Measurable.class);
    when(targetMeasurable.concrete()).thenThrow(new NotAuthorizedException("An error occurred"));
    when(targetMeasurable.name()).thenThrow(new NotAuthorizedException("An error occurred"));
    when(targetMeasurable.id()).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> TaxonomyManagementUtilities.validateConcreteMergeAllowed(measurable, targetMeasurable));
    verify(measurable).id();
    verify(measurable).name();
    verify(targetMeasurable).name();
    verify(measurable).concrete();
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand)}
   */
  @Test
  void testFindCurrentRatingMappings() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.primaryReference()).thenReturn(mock(EntityReference.class));

    // Act
    Set<EntityReference> actualFindCurrentRatingMappingsResult = TaxonomyManagementUtilities
        .findCurrentRatingMappings(measurableRatingService, cmd);

    // Assert
    verify(cmd).primaryReference();
    verify(measurableRatingService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
    assertTrue(actualFindCurrentRatingMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#getNameParam(TaxonomyChangeCommand)}
   */
  @Test
  void testGetNameParam() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.param(Mockito.<String>any())).thenReturn("Param");

    // Act
    String actualNameParam = TaxonomyManagementUtilities.getNameParam(cmd);

    // Assert
    verify(cmd).param(eq("name"));
    assertEquals("Param", actualNameParam);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#getNameParam(TaxonomyChangeCommand)}
   */
  @Test
  void testGetNameParam2() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.param(Mockito.<String>any())).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> TaxonomyManagementUtilities.getNameParam(cmd));
    verify(cmd).param(eq("name"));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#getDescriptionParam(TaxonomyChangeCommand)}
   */
  @Test
  void testGetDescriptionParam() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.param(Mockito.<String>any())).thenReturn("Param");

    // Act
    String actualDescriptionParam = TaxonomyManagementUtilities.getDescriptionParam(cmd);

    // Assert
    verify(cmd).param(eq("description"));
    assertEquals("Param", actualDescriptionParam);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#getDescriptionParam(TaxonomyChangeCommand)}
   */
  @Test
  void testGetDescriptionParam2() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.param(Mockito.<String>any())).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> TaxonomyManagementUtilities.getDescriptionParam(cmd));
    verify(cmd).param(eq("description"));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#getExternalIdParam(TaxonomyChangeCommand)}
   */
  @Test
  void testGetExternalIdParam() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.param(Mockito.<String>any())).thenReturn("Param");

    // Act
    String actualExternalIdParam = TaxonomyManagementUtilities.getExternalIdParam(cmd);

    // Assert
    verify(cmd).param(eq("externalId"));
    assertEquals("Param", actualExternalIdParam);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#getExternalIdParam(TaxonomyChangeCommand)}
   */
  @Test
  void testGetExternalIdParam2() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.param(Mockito.<String>any())).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> TaxonomyManagementUtilities.getExternalIdParam(cmd));
    verify(cmd).param(eq("externalId"));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}
   */
  @Test
  void testGetConcreteParam() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.paramAsBoolean(Mockito.<String>any(), anyBoolean())).thenReturn(true);

    // Act
    boolean actualConcreteParam = TaxonomyManagementUtilities.getConcreteParam(cmd, true);

    // Assert
    verify(cmd).paramAsBoolean(eq("concrete"), eq(true));
    assertTrue(actualConcreteParam);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}
   */
  @Test
  void testGetConcreteParam2() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.paramAsBoolean(Mockito.<String>any(), anyBoolean())).thenReturn(false);

    // Act
    boolean actualConcreteParam = TaxonomyManagementUtilities.getConcreteParam(cmd, true);

    // Assert
    verify(cmd).paramAsBoolean(eq("concrete"), eq(true));
    assertFalse(actualConcreteParam);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}
   */
  @Test
  void testGetConcreteParam3() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.paramAsBoolean(Mockito.<String>any(), anyBoolean()))
        .thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> TaxonomyManagementUtilities.getConcreteParam(cmd, true));
    verify(cmd).paramAsBoolean(eq("concrete"), eq(true));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)}
   */
  @Test
  void testVerifyUserHasPermissions() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService2, measurableService, new SettingsService(settingsDao2, new ArrayList<>()));

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    when(userRoleDao2.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao3 = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> TaxonomyManagementUtilities.verifyUserHasPermissions(measurableCategoryService,
            new UserRoleService(userRoleDao2, roleDao2, personDao2, changeLogService3, personService2,
                new SettingsService(settingsDao3, new ArrayList<>())),
            "42", null));
    verify(userRoleDao2).getUserRoles(eq("42"));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)}
   */
  @Test
  void testVerifyUserHasPermissions2() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService2, measurableService, new SettingsService(settingsDao2, new ArrayList<>()));

    UserRoleService userRoleService2 = mock(UserRoleService.class);
    when(userRoleService2.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    EntityReference changeDomain = mock(EntityReference.class);
    when(changeDomain.kind()).thenReturn(EntityKind.ALL);

    // Act
    TaxonomyManagementUtilities.verifyUserHasPermissions(measurableCategoryService, userRoleService2, "42",
        changeDomain);

    // Assert
    verify(changeDomain).kind();
    verify(userRoleService2).hasRole(eq("42"), (String[]) any());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)}
   */
  @Test
  void testVerifyUserHasPermissions3() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> TaxonomyManagementUtilities.verifyUserHasPermissions(new UserRoleService(userRoleDao, roleDao, personDao,
            changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())), "42"));
    verify(userRoleDao).getUserRoles(eq("42"));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)}
   */
  @Test
  void testVerifyUserHasPermissions4() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);

    // Act
    TaxonomyManagementUtilities.verifyUserHasPermissions(userRoleService, "42");

    // Assert
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
  }
}
