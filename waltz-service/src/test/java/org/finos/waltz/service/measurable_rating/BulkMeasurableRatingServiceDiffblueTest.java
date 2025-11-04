package org.finos.waltz.service.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.allocation_scheme.AllocationSchemeDao;
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
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingValidationResult;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingValidationResult;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BulkMeasurableRatingServiceDiffblueTest {
  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    Optional<String> ofResult = Optional.of("foo");
    when(measurable.externalId()).thenReturn(ofResult);
    Measurable measurable2 = mock(Measurable.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(measurable2.externalId()).thenReturn(ofResult2);
    Measurable measurable3 = mock(Measurable.class);
    when(measurable3.externalId()).thenThrow(new IllegalStateException("Input Str"));

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(measurable3);
    measurableList.add(measurable2);
    measurableList.add(measurable);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    BulkMeasurableRatingService bulkMeasurableRatingService = new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        measurableService, mock(ChangeLogService.class), measurableCategoryService, mock(ApplicationDao.class),
        mock(AllocationSchemeDao.class), mock(DSLContext.class));
    EntityReference categoryRef = mock(EntityReference.class);
    when(categoryRef.id()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> bulkMeasurableRatingService.bulkPreview(categoryRef, "Input Str",
        BulkMeasurableItemParser.InputFormat.CSV, BulkUpdateMode.ADD_ONLY));
    verify(categoryRef, atLeast(1)).id();
    verify(measurable3).externalId();
    verify(measurableService).findByCategoryId(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview2() {
    // Arrange and Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult = (new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        mock(MeasurableService.class), mock(ChangeLogService.class), mock(MeasurableCategoryService.class),
        mock(ApplicationDao.class), mock(AllocationSchemeDao.class), mock(DSLContext.class))).bulkPreview(
            mock(EntityReference.class), "(\n|\r|\r\n)", BulkMeasurableItemParser.InputFormat.CSV,
            BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasu"
        + "rableRatingItem`, problem: Cannot build BulkMeasurableRatingItem, some of required attributes are not"
        + " set [assetCode, taxonomyExternalId, ratingCode, scheme]\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview3() {
    // Arrange and Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult = (new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        mock(MeasurableService.class), mock(ChangeLogService.class), mock(MeasurableCategoryService.class),
        mock(ApplicationDao.class), mock(AllocationSchemeDao.class), mock(DSLContext.class))).bulkPreview(
            mock(EntityReference.class), "\n", BulkMeasurableItemParser.InputFormat.CSV, BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview4() {
    // Arrange and Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult = (new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        mock(MeasurableService.class), mock(ChangeLogService.class), mock(MeasurableCategoryService.class),
        mock(ApplicationDao.class), mock(AllocationSchemeDao.class), mock(DSLContext.class))).bulkPreview(
            mock(EntityReference.class), "#", BulkMeasurableItemParser.InputFormat.CSV, BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview5() {
    // Arrange and Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult = (new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        mock(MeasurableService.class), mock(ChangeLogService.class), mock(MeasurableCategoryService.class),
        mock(ApplicationDao.class), mock(AllocationSchemeDao.class), mock(DSLContext.class))).bulkPreview(
            mock(EntityReference.class), null, BulkMeasurableItemParser.InputFormat.CSV, BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview6() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    Optional<String> ofResult = Optional.of("foo");
    when(measurable.externalId()).thenReturn(ofResult);
    Measurable measurable2 = mock(Measurable.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(measurable2.externalId()).thenReturn(ofResult2);
    Measurable measurable3 = mock(Measurable.class);
    when(measurable3.externalId()).thenThrow(new IllegalStateException("Input Str"));

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(measurable3);
    measurableList.add(measurable2);
    measurableList.add(measurable);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    BulkMeasurableRatingService bulkMeasurableRatingService = new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        measurableService, mock(ChangeLogService.class), measurableCategoryService, mock(ApplicationDao.class),
        mock(AllocationSchemeDao.class), mock(DSLContext.class));
    EntityReference categoryRef = mock(EntityReference.class);
    when(categoryRef.id()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> bulkMeasurableRatingService.bulkPreview(categoryRef, "Input Str",
        BulkMeasurableItemParser.InputFormat.TSV, BulkUpdateMode.ADD_ONLY));
    verify(categoryRef, atLeast(1)).id();
    verify(measurable3).externalId();
    verify(measurableService).findByCategoryId(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview7() {
    // Arrange and Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult = (new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        mock(MeasurableService.class), mock(ChangeLogService.class), mock(MeasurableCategoryService.class),
        mock(ApplicationDao.class), mock(AllocationSchemeDao.class), mock(DSLContext.class))).bulkPreview(
            mock(EntityReference.class), "Input Str", BulkMeasurableItemParser.InputFormat.JSON,
            BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals("Unrecognized token 'Input': was expecting (JSON String, Number, Array, Object or token 'null', 'true'"
        + " or 'false')\n" + " at [Source: (String)\"Input Str\"; line: 1, column: 6]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview8() {
    // Arrange and Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult = (new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        mock(MeasurableService.class), mock(ChangeLogService.class), mock(MeasurableCategoryService.class),
        mock(ApplicationDao.class), mock(AllocationSchemeDao.class), mock(DSLContext.class))).bulkPreview(
            mock(EntityReference.class), "(\n|\r|\r\n)", BulkMeasurableItemParser.InputFormat.TSV,
            BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasu"
        + "rableRatingItem`, problem: Cannot build BulkMeasurableRatingItem, some of required attributes are not"
        + " set [assetCode, taxonomyExternalId, ratingCode, scheme]\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview9() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    Optional<String> ofResult = Optional.of("foo");
    when(measurable.externalId()).thenReturn(ofResult);
    Measurable measurable2 = mock(Measurable.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(measurable2.externalId()).thenReturn(ofResult2);
    Measurable measurable3 = mock(Measurable.class);
    when(measurable3.externalId()).thenThrow(new IllegalStateException("Input Str"));

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(measurable3);
    measurableList.add(measurable2);
    measurableList.add(measurable);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    BulkMeasurableRatingService bulkMeasurableRatingService = new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        measurableService, mock(ChangeLogService.class), measurableCategoryService, mock(ApplicationDao.class),
        mock(AllocationSchemeDao.class), mock(DSLContext.class));
    EntityReference categoryRef = mock(EntityReference.class);
    when(categoryRef.id()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> bulkMeasurableRatingService.bulkPreview(categoryRef, "#",
        BulkMeasurableItemParser.InputFormat.JSON, BulkUpdateMode.ADD_ONLY));
    verify(categoryRef, atLeast(1)).id();
    verify(measurable3).externalId();
    verify(measurableService).findByCategoryId(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, BulkMeasurableItemParser.InputFormat, BulkUpdateMode)}
   */
  @Test
  void testBulkPreview10() {
    // Arrange and Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult = (new BulkMeasurableRatingService(
        mock(UserRoleService.class), mock(MeasurableRatingDao.class), mock(RatingSchemeService.class),
        mock(MeasurableService.class), mock(ChangeLogService.class), mock(MeasurableCategoryService.class),
        mock(ApplicationDao.class), mock(AllocationSchemeDao.class), mock(DSLContext.class))).bulkPreview(
            mock(EntityReference.class), "42", BulkMeasurableItemParser.InputFormat.JSON, BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals(
        "Cannot construct instance of `org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasu"
            + "rableRatingItem$Json` (although at least one Creator exists): no int/Int-argument constructor/factory"
            + " method to deserialize from Number value (42)\n" + " at [Source: (String)\"42\"; line: 1, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}
   */
  @Test
  void testApply() {
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
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    UserRoleService userRoleService2 = new UserRoleService(userRoleDao2, roleDao2, personDao2, changeLogService3,
        personService2, new SettingsService(settingsDao2, new ArrayList<>()));

    ChangeLogService changeLogService4 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao2, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao3 = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService2, changeLogService4, measurableService2, new SettingsService(settingsDao3, new ArrayList<>()));

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> (new BulkMeasurableRatingService(userRoleService, measurableRatingDao, ratingSchemeService,
            measurableService, changeLogService2, measurableCategoryService, applicationDao, allocationSchemeDao,
            new DefaultDSLContext(SQLDialect.SQL99))).apply(null, mock(BulkMeasurableRatingValidationResult.class),
                BulkUpdateMode.ADD_ONLY, "42"));
    verify(userRoleDao).getUserRoles(eq("42"));
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}
   */
  @Test
  void testApply2() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService2 = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao2, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService2, changeLogService3, measurableService2, new SettingsService(settingsDao2, new ArrayList<>()));

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    BulkMeasurableRatingService bulkMeasurableRatingService = new BulkMeasurableRatingService(userRoleService,
        measurableRatingDao, ratingSchemeService, measurableService, changeLogService, measurableCategoryService,
        applicationDao, allocationSchemeDao, new DefaultDSLContext(SQLDialect.SQL99));
    BulkMeasurableRatingValidationResult preview = mock(BulkMeasurableRatingValidationResult.class);
    when(preview.error()).thenReturn(mock(BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError.class));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> bulkMeasurableRatingService.apply(null, preview, BulkUpdateMode.ADD_ONLY, "42"));
    verify(preview).error();
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableRatingService#apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}
   */
  @Test
  void testApply3() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService2 = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao2, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService2, changeLogService3, measurableService2, new SettingsService(settingsDao2, new ArrayList<>()));

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    BulkMeasurableRatingService bulkMeasurableRatingService = new BulkMeasurableRatingService(userRoleService,
        measurableRatingDao, ratingSchemeService, measurableService, changeLogService, measurableCategoryService,
        applicationDao, allocationSchemeDao, new DefaultDSLContext(SQLDialect.SQL99));
    BulkMeasurableRatingValidationResult preview = mock(BulkMeasurableRatingValidationResult.class);
    when(preview.error()).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> bulkMeasurableRatingService.apply(null, preview, BulkUpdateMode.ADD_ONLY, "42"));
    verify(preview).error();
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
  }
}
