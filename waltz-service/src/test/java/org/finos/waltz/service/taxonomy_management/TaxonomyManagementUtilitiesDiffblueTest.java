package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
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
import org.finos.waltz.model.IdProvider;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TaxonomyManagementUtilitiesDiffblueTest {
  /**
   * Test {@link TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)}.
   * <ul>
   *   <li>Then calls {@link MeasurableDao#getById(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand); then calls getById(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Measurable TaxonomyManagementUtilities.validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)"})
  void testValidatePrimaryMeasurable_thenCallsGetById() {
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
   * Test {@link TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Measurable TaxonomyManagementUtilities.validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)"})
  void testValidatePrimaryMeasurable_thenThrowNotAuthorizedException() {
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
   * Test {@link TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long, long)}.
   * <ul>
   *   <li>Then calls {@link MeasurableDao#getById(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long, long)}
   */
  @Test
  @DisplayName("Test validateMeasurableInCategory(MeasurableService, long, long); then calls getById(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Measurable TaxonomyManagementUtilities.validateMeasurableInCategory(MeasurableService, long, long)"})
  void testValidateMeasurableInCategory_thenCallsGetById() {
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
   * Test {@link TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long, long)}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long, long)}
   */
  @Test
  @DisplayName("Test validateMeasurableInCategory(MeasurableService, long, long); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Measurable TaxonomyManagementUtilities.validateMeasurableInCategory(MeasurableService, long, long)"})
  void testValidateMeasurableInCategory_thenThrowNotAuthorizedException() {
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
   * Test {@link TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable, Measurable)}.
   * <ul>
   *   <li>Given {@link EntityReference}.</li>
   *   <li>Then calls {@link IdProvider#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable, Measurable)}
   */
  @Test
  @DisplayName("Test validateTargetNotChild(MeasurableService, Measurable, Measurable); given EntityReference; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void TaxonomyManagementUtilities.validateTargetNotChild(MeasurableService, Measurable, Measurable)"})
  void testValidateTargetNotChild_givenEntityReference_thenCallsId() {
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
   * Test {@link TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable, Measurable)}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable, Measurable)}
   */
  @Test
  @DisplayName("Test validateTargetNotChild(MeasurableService, Measurable, Measurable); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void TaxonomyManagementUtilities.validateTargetNotChild(MeasurableService, Measurable, Measurable)"})
  void testValidateTargetNotChild_thenThrowNotAuthorizedException() {
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
   * Test {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}.
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}
   */
  @Test
  @DisplayName("Test validateConcreteMergeAllowed(Measurable, Measurable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TaxonomyManagementUtilities.validateConcreteMergeAllowed(Measurable, Measurable)"})
  void testValidateConcreteMergeAllowed() {
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
   * Test {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link IdProvider#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}
   */
  @Test
  @DisplayName("Test validateConcreteMergeAllowed(Measurable, Measurable); given 'false'; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TaxonomyManagementUtilities.validateConcreteMergeAllowed(Measurable, Measurable)"})
  void testValidateConcreteMergeAllowed_givenFalse_thenCallsId() {
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
   * Test {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link IdProvider#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}
   */
  @Test
  @DisplayName("Test validateConcreteMergeAllowed(Measurable, Measurable); given 'true'; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TaxonomyManagementUtilities.validateConcreteMergeAllowed(Measurable, Measurable)"})
  void testValidateConcreteMergeAllowed_givenTrue_thenCallsId() {
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
   * Test {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#validateConcreteMergeAllowed(Measurable, Measurable)}
   */
  @Test
  @DisplayName("Test validateConcreteMergeAllowed(Measurable, Measurable); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TaxonomyManagementUtilities.validateConcreteMergeAllowed(Measurable, Measurable)"})
  void testValidateConcreteMergeAllowed_thenThrowNotAuthorizedException() {
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
   * Test {@link TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand); given ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Set TaxonomyManagementUtilities.findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand)"})
  void testFindCurrentRatingMappings_givenArrayList_thenReturnEmpty() {
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
   * Test {@link TaxonomyManagementUtilities#getNameParam(TaxonomyChangeCommand)}.
   * <ul>
   *   <li>Given {@code Param}.</li>
   *   <li>Then return {@code Param}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#getNameParam(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test getNameParam(TaxonomyChangeCommand); given 'Param'; then return 'Param'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TaxonomyManagementUtilities.getNameParam(TaxonomyChangeCommand)"})
  void testGetNameParam_givenParam_thenReturnParam() {
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
   * Test {@link TaxonomyManagementUtilities#getNameParam(TaxonomyChangeCommand)}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#getNameParam(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test getNameParam(TaxonomyChangeCommand); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TaxonomyManagementUtilities.getNameParam(TaxonomyChangeCommand)"})
  void testGetNameParam_thenThrowNotAuthorizedException() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.param(Mockito.<String>any())).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> TaxonomyManagementUtilities.getNameParam(cmd));
    verify(cmd).param(eq("name"));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#getDescriptionParam(TaxonomyChangeCommand)}.
   * <ul>
   *   <li>Given {@code Param}.</li>
   *   <li>Then return {@code Param}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#getDescriptionParam(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test getDescriptionParam(TaxonomyChangeCommand); given 'Param'; then return 'Param'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TaxonomyManagementUtilities.getDescriptionParam(TaxonomyChangeCommand)"})
  void testGetDescriptionParam_givenParam_thenReturnParam() {
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
   * Test {@link TaxonomyManagementUtilities#getDescriptionParam(TaxonomyChangeCommand)}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#getDescriptionParam(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test getDescriptionParam(TaxonomyChangeCommand); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TaxonomyManagementUtilities.getDescriptionParam(TaxonomyChangeCommand)"})
  void testGetDescriptionParam_thenThrowNotAuthorizedException() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.param(Mockito.<String>any())).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> TaxonomyManagementUtilities.getDescriptionParam(cmd));
    verify(cmd).param(eq("description"));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#getExternalIdParam(TaxonomyChangeCommand)}.
   * <ul>
   *   <li>Given {@code Param}.</li>
   *   <li>Then return {@code Param}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#getExternalIdParam(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test getExternalIdParam(TaxonomyChangeCommand); given 'Param'; then return 'Param'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TaxonomyManagementUtilities.getExternalIdParam(TaxonomyChangeCommand)"})
  void testGetExternalIdParam_givenParam_thenReturnParam() {
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
   * Test {@link TaxonomyManagementUtilities#getExternalIdParam(TaxonomyChangeCommand)}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#getExternalIdParam(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test getExternalIdParam(TaxonomyChangeCommand); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TaxonomyManagementUtilities.getExternalIdParam(TaxonomyChangeCommand)"})
  void testGetExternalIdParam_thenThrowNotAuthorizedException() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.param(Mockito.<String>any())).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> TaxonomyManagementUtilities.getExternalIdParam(cmd));
    verify(cmd).param(eq("externalId"));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}
   */
  @Test
  @DisplayName("Test getConcreteParam(TaxonomyChangeCommand, boolean); given 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TaxonomyManagementUtilities.getConcreteParam(TaxonomyChangeCommand, boolean)"})
  void testGetConcreteParam_givenFalse_thenReturnFalse() {
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
   * Test {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}
   */
  @Test
  @DisplayName("Test getConcreteParam(TaxonomyChangeCommand, boolean); given 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TaxonomyManagementUtilities.getConcreteParam(TaxonomyChangeCommand, boolean)"})
  void testGetConcreteParam_givenTrue_thenReturnTrue() {
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
   * Test {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}
   */
  @Test
  @DisplayName("Test getConcreteParam(TaxonomyChangeCommand, boolean); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TaxonomyManagementUtilities.getConcreteParam(TaxonomyChangeCommand, boolean)"})
  void testGetConcreteParam_thenThrowNotAuthorizedException() {
    // Arrange
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.paramAsBoolean(Mockito.<String>any(), anyBoolean()))
        .thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> TaxonomyManagementUtilities.getConcreteParam(cmd, true));
    verify(cmd).paramAsBoolean(eq("concrete"), eq(true));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)} with {@code measurableCategoryService}, {@code userRoleService}, {@code userId}, {@code changeDomain}.
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)}
   */
  @Test
  @DisplayName("Test verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference) with 'measurableCategoryService', 'userRoleService', 'userId', 'changeDomain'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void TaxonomyManagementUtilities.verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)"})
  void testVerifyUserHasPermissionsWithMeasurableCategoryServiceUserRoleServiceUserIdChangeDomain() {
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
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)} with {@code measurableCategoryService}, {@code userRoleService}, {@code userId}, {@code changeDomain}.
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)}
   */
  @Test
  @DisplayName("Test verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference) with 'measurableCategoryService', 'userRoleService', 'userId', 'changeDomain'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void TaxonomyManagementUtilities.verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)"})
  void testVerifyUserHasPermissionsWithMeasurableCategoryServiceUserRoleServiceUserIdChangeDomain2() {
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
    when(userRoleService2.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    EntityReference changeDomain = mock(EntityReference.class);
    when(changeDomain.kind()).thenReturn(EntityKind.ALL);

    // Act
    TaxonomyManagementUtilities.verifyUserHasPermissions(measurableCategoryService, userRoleService2, "42",
        changeDomain);

    // Assert
    verify(changeDomain).kind();
    verify(userRoleService2).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)} with {@code userRoleService}, {@code userId}.
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)}
   */
  @Test
  @DisplayName("Test verifyUserHasPermissions(UserRoleService, String) with 'userRoleService', 'userId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TaxonomyManagementUtilities.verifyUserHasPermissions(UserRoleService, String)"})
  void testVerifyUserHasPermissionsWithUserRoleServiceUserId() {
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
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)} with {@code userRoleService}, {@code userId}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link UserRoleService#hasRole(String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)}
   */
  @Test
  @DisplayName("Test verifyUserHasPermissions(UserRoleService, String) with 'userRoleService', 'userId'; given 'true'; then calls hasRole(String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TaxonomyManagementUtilities.verifyUserHasPermissions(UserRoleService, String)"})
  void testVerifyUserHasPermissionsWithUserRoleServiceUserId_givenTrue_thenCallsHasRole() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    // Act
    TaxonomyManagementUtilities.verifyUserHasPermissions(userRoleService, "42");

    // Assert
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }
}
