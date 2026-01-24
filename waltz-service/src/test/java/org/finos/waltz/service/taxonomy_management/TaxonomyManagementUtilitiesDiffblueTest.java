package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand.Builder;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeCommand;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeLifecycleStatus;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeType;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.measurable_rating.MeasurableRatingService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.tag.TagService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TaxonomyManagementUtilitiesDiffblueTest {
  /**
   * Test {@link TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService,
   * TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService,
   * TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Measurable TaxonomyManagementUtilities.validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)"
  })
  void testValidatePrimaryMeasurable_thenCallsGetById() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    Measurable actualValidatePrimaryMeasurableResult =
        TaxonomyManagementUtilities.validatePrimaryMeasurable(measurableService, cmd);

    // Assert
    verify(measurableDao).getById(1L);
    assertTrue(actualValidatePrimaryMeasurableResult instanceof ImmutableMeasurable);
    assertEquals("2020-03-01", actualValidatePrimaryMeasurableResult.lastUpdatedBy());
    assertEquals("Name", actualValidatePrimaryMeasurableResult.name());
    assertEquals("Provenance", actualValidatePrimaryMeasurableResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualValidatePrimaryMeasurableResult.description());
    assertEquals(0, actualValidatePrimaryMeasurableResult.position());
    assertEquals(1L, actualValidatePrimaryMeasurableResult.organisationalUnitId().longValue());
    assertEquals(1L, actualValidatePrimaryMeasurableResult.categoryId());
    assertEquals(EntityKind.ALL, actualValidatePrimaryMeasurableResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualValidatePrimaryMeasurableResult.entityLifecycleStatus());
    assertTrue(actualValidatePrimaryMeasurableResult.concrete());
    assertSame(ofResult, actualValidatePrimaryMeasurableResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService,
   * TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableService#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validatePrimaryMeasurable(MeasurableService,
   * TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Measurable TaxonomyManagementUtilities.validatePrimaryMeasurable(MeasurableService, TaxonomyChangeCommand)"
  })
  void testValidatePrimaryMeasurable_thenCallsGetById2() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(measurableService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    Measurable actualValidatePrimaryMeasurableResult =
        TaxonomyManagementUtilities.validatePrimaryMeasurable(measurableService, cmd);

    // Assert
    verify(measurableService).getById(1L);
    assertTrue(actualValidatePrimaryMeasurableResult instanceof ImmutableMeasurable);
    assertEquals("2020-03-01", actualValidatePrimaryMeasurableResult.lastUpdatedBy());
    assertEquals("Name", actualValidatePrimaryMeasurableResult.name());
    assertEquals("Provenance", actualValidatePrimaryMeasurableResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualValidatePrimaryMeasurableResult.description());
    assertEquals(0, actualValidatePrimaryMeasurableResult.position());
    assertEquals(1L, actualValidatePrimaryMeasurableResult.organisationalUnitId().longValue());
    assertEquals(1L, actualValidatePrimaryMeasurableResult.categoryId());
    assertEquals(EntityKind.ALL, actualValidatePrimaryMeasurableResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualValidatePrimaryMeasurableResult.entityLifecycleStatus());
    assertTrue(actualValidatePrimaryMeasurableResult.concrete());
    assertSame(ofResult, actualValidatePrimaryMeasurableResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List,
   * long)}.
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List, long)}
   */
  @Test
  @DisplayName("Test validateMeasurablesInCategory(MeasurableService, List, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.validateMeasurablesInCategory(MeasurableService, List, long)"
  })
  void testValidateMeasurablesInCategory() {
    // Arrange
    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    TaxonomyManagementUtilities.validateMeasurablesInCategory(
        measurableService, new ArrayList<>(), 1L);

    // Assert
    verify(measurableDao).findByCategoryId(1L);
  }

  /**
   * Test {@link TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List,
   * long)}.
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List, long)}
   */
  @Test
  @DisplayName("Test validateMeasurablesInCategory(MeasurableService, List, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.validateMeasurablesInCategory(MeasurableService, List, long)"
  })
  void testValidateMeasurablesInCategory2() {
    // Arrange
    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    TaxonomyManagementUtilities.validateMeasurablesInCategory(
        measurableService, new ArrayList<>(), 1L);

    // Assert
    verify(measurableDao).findByCategoryId(1L);
  }

  /**
   * Test {@link TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List,
   * long)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link MeasurableDao#findByCategoryId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List, long)}
   */
  @Test
  @DisplayName(
      "Test validateMeasurablesInCategory(MeasurableService, List, long); given ArrayList(); then calls findByCategoryId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.validateMeasurablesInCategory(MeasurableService, List, long)"
  })
  void testValidateMeasurablesInCategory_givenArrayList_thenCallsFindByCategoryId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    TaxonomyManagementUtilities.validateMeasurablesInCategory(
        measurableService, new ArrayList<>(), 1L);

    // Assert
    verify(measurableDao).findByCategoryId(1L);
  }

  /**
   * Test {@link TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List,
   * long)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableService#findByCategoryId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validateMeasurablesInCategory(MeasurableService, List, long)}
   */
  @Test
  @DisplayName(
      "Test validateMeasurablesInCategory(MeasurableService, List, long); then calls findByCategoryId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.validateMeasurablesInCategory(MeasurableService, List, long)"
  })
  void testValidateMeasurablesInCategory_thenCallsFindByCategoryId() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    TaxonomyManagementUtilities.validateMeasurablesInCategory(
        measurableService, new ArrayList<>(), 1L);

    // Assert
    verify(measurableService).findByCategoryId(1L);
  }

  /**
   * Test {@link TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long,
   * long)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long, long)}
   */
  @Test
  @DisplayName(
      "Test validateMeasurableInCategory(MeasurableService, long, long); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Measurable TaxonomyManagementUtilities.validateMeasurableInCategory(MeasurableService, long, long)"
  })
  void testValidateMeasurableInCategory_thenCallsGetById() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    Measurable actualValidateMeasurableInCategoryResult =
        TaxonomyManagementUtilities.validateMeasurableInCategory(measurableService, 1L, 1L);

    // Assert
    verify(measurableDao).getById(1L);
    assertTrue(actualValidateMeasurableInCategoryResult instanceof ImmutableMeasurable);
    assertEquals("2020-03-01", actualValidateMeasurableInCategoryResult.lastUpdatedBy());
    assertEquals("Name", actualValidateMeasurableInCategoryResult.name());
    assertEquals("Provenance", actualValidateMeasurableInCategoryResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualValidateMeasurableInCategoryResult.description());
    assertEquals(0, actualValidateMeasurableInCategoryResult.position());
    assertEquals(1L, actualValidateMeasurableInCategoryResult.organisationalUnitId().longValue());
    assertEquals(1L, actualValidateMeasurableInCategoryResult.categoryId());
    assertEquals(EntityKind.ALL, actualValidateMeasurableInCategoryResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualValidateMeasurableInCategoryResult.entityLifecycleStatus());
    assertTrue(actualValidateMeasurableInCategoryResult.concrete());
    assertSame(ofResult, actualValidateMeasurableInCategoryResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long,
   * long)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableService#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validateMeasurableInCategory(MeasurableService, long, long)}
   */
  @Test
  @DisplayName(
      "Test validateMeasurableInCategory(MeasurableService, long, long); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Measurable TaxonomyManagementUtilities.validateMeasurableInCategory(MeasurableService, long, long)"
  })
  void testValidateMeasurableInCategory_thenCallsGetById2() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(measurableService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Act
    Measurable actualValidateMeasurableInCategoryResult =
        TaxonomyManagementUtilities.validateMeasurableInCategory(measurableService, 1L, 1L);

    // Assert
    verify(measurableService).getById(1L);
    assertTrue(actualValidateMeasurableInCategoryResult instanceof ImmutableMeasurable);
    assertEquals("2020-03-01", actualValidateMeasurableInCategoryResult.lastUpdatedBy());
    assertEquals("Name", actualValidateMeasurableInCategoryResult.name());
    assertEquals("Provenance", actualValidateMeasurableInCategoryResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualValidateMeasurableInCategoryResult.description());
    assertEquals(0, actualValidateMeasurableInCategoryResult.position());
    assertEquals(1L, actualValidateMeasurableInCategoryResult.organisationalUnitId().longValue());
    assertEquals(1L, actualValidateMeasurableInCategoryResult.categoryId());
    assertEquals(EntityKind.ALL, actualValidateMeasurableInCategoryResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualValidateMeasurableInCategoryResult.entityLifecycleStatus());
    assertTrue(actualValidateMeasurableInCategoryResult.concrete());
    assertSame(ofResult, actualValidateMeasurableInCategoryResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable,
   * Measurable)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link MeasurableDao#findByMeasurableIdSelector(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable, Measurable)}
   */
  @Test
  @DisplayName(
      "Test validateTargetNotChild(MeasurableService, Measurable, Measurable); given ArrayList(); then calls findByMeasurableIdSelector(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.validateTargetNotChild(MeasurableService, Measurable, Measurable)"
  })
  void testValidateTargetNotChild_givenArrayList_thenCallsFindByMeasurableIdSelector() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);
    ImmutableMeasurable measurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    ImmutableMeasurable targetMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    TaxonomyManagementUtilities.validateTargetNotChild(
        measurableService, measurable, targetMeasurable);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable,
   * Measurable)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#validateTargetNotChild(MeasurableService, Measurable, Measurable)}
   */
  @Test
  @DisplayName(
      "Test validateTargetNotChild(MeasurableService, Measurable, Measurable); then calls findByMeasurableIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.validateTargetNotChild(MeasurableService, Measurable, Measurable)"
  })
  void testValidateTargetNotChild_thenCallsFindByMeasurableIdSelector() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    ImmutableMeasurable measurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    ImmutableMeasurable targetMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    TaxonomyManagementUtilities.validateTargetNotChild(
        measurableService, measurable, targetMeasurable);

    // Assert
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService,
   * TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService,
   * TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand); given ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set TaxonomyManagementUtilities.findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand)"
  })
  void testFindCurrentRatingMappings_givenArrayList_thenReturnEmpty() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.findByMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
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
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService3);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService4, personService, settingsService);
    ChangeLogService changeLogService5 =
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
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService6 =
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

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao3, measurableSearchDao2, nameResolver2, changeLogService6);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao2,
            userRoleService,
            changeLogService5,
            measurableService2,
            settingsService2);

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
            measurableCategoryService,
            mock(ApplicationDao.class));

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    Set<EntityReference> actualFindCurrentRatingMappingsResult =
        TaxonomyManagementUtilities.findCurrentRatingMappings(measurableRatingService, cmd);

    // Assert
    verify(measurableRatingDao)
        .findByMeasurableIdSelector(isA(Select.class), isA(IdSelectionOptions.class));
    assertTrue(actualFindCurrentRatingMappingsResult.isEmpty());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService,
   * TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       MeasurableRatingService#findByMeasurableIdSelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService,
   * TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand); then calls findByMeasurableIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set TaxonomyManagementUtilities.findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand)"
  })
  void testFindCurrentRatingMappings_thenCallsFindByMeasurableIdSelector() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    Set<EntityReference> actualFindCurrentRatingMappingsResult =
        TaxonomyManagementUtilities.findCurrentRatingMappings(measurableRatingService, cmd);

    // Assert
    verify(measurableRatingService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
    assertTrue(actualFindCurrentRatingMappingsResult.isEmpty());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService,
   * TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService,
   * TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set TaxonomyManagementUtilities.findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand)"
  })
  void testFindCurrentRatingMappings_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
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

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.findByMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableRatingList);
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
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService3);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService4, personService, settingsService);
    ChangeLogService changeLogService5 =
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
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService6 =
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

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao3, measurableSearchDao2, nameResolver2, changeLogService6);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao2,
            userRoleService,
            changeLogService5,
            measurableService2,
            settingsService2);

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
            measurableCategoryService,
            mock(ApplicationDao.class));

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    Set<EntityReference> actualFindCurrentRatingMappingsResult =
        TaxonomyManagementUtilities.findCurrentRatingMappings(measurableRatingService, cmd);

    // Assert
    verify(measurableRatingDao)
        .findByMeasurableIdSelector(isA(Select.class), isA(IdSelectionOptions.class));
    assertEquals(1, actualFindCurrentRatingMappingsResult.size());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService,
   * TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#findCurrentRatingMappings(MeasurableRatingService,
   * TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set TaxonomyManagementUtilities.findCurrentRatingMappings(MeasurableRatingService, TaxonomyChangeCommand)"
  })
  void testFindCurrentRatingMappings_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
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

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
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

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.findByMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableRatingList);
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
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService3);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService4, personService, settingsService);
    ChangeLogService changeLogService5 =
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
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService6 =
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

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao3, measurableSearchDao2, nameResolver2, changeLogService6);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao2,
            userRoleService,
            changeLogService5,
            measurableService2,
            settingsService2);

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
            measurableCategoryService,
            mock(ApplicationDao.class));

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    Set<EntityReference> actualFindCurrentRatingMappingsResult =
        TaxonomyManagementUtilities.findCurrentRatingMappings(measurableRatingService, cmd);

    // Assert
    verify(measurableRatingDao)
        .findByMeasurableIdSelector(isA(Select.class), isA(IdSelectionOptions.class));
    assertEquals(1, actualFindCurrentRatingMappingsResult.size());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#getNameParam(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementUtilities#getNameParam(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test getNameParam(TaxonomyChangeCommand); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TaxonomyManagementUtilities.getNameParam(TaxonomyChangeCommand)"})
  void testGetNameParam_thenReturnNull() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNull(TaxonomyManagementUtilities.getNameParam(cmd));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#getDescriptionParam(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#getDescriptionParam(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test getDescriptionParam(TaxonomyChangeCommand); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TaxonomyManagementUtilities.getDescriptionParam(TaxonomyChangeCommand)"
  })
  void testGetDescriptionParam_thenReturnNull() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNull(TaxonomyManagementUtilities.getDescriptionParam(cmd));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#getExternalIdParam(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#getExternalIdParam(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test getExternalIdParam(TaxonomyChangeCommand); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TaxonomyManagementUtilities.getExternalIdParam(TaxonomyChangeCommand)"
  })
  void testGetExternalIdParam_thenReturnNull() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertNull(TaxonomyManagementUtilities.getExternalIdParam(cmd));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}.
   *
   * <ul>
   *   <li>Given {@code concrete}.
   *   <li>When {@link HashMap#HashMap()} {@code concrete} is {@code concrete}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}
   */
  @Test
  @DisplayName(
      "Test getConcreteParam(TaxonomyChangeCommand, boolean); given 'concrete'; when HashMap() 'concrete' is 'concrete'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaxonomyManagementUtilities.getConcreteParam(TaxonomyChangeCommand, boolean)"
  })
  void testGetConcreteParam_givenConcrete_whenHashMapConcreteIsConcrete_thenReturnFalse() {
    // Arrange
    HashMap<String, String> entries = new HashMap<>();
    entries.put("concrete", "concrete");

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder paramsResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .params(entries);
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertFalse(TaxonomyManagementUtilities.getConcreteParam(cmd, true));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#getConcreteParam(TaxonomyChangeCommand, boolean)}
   */
  @Test
  @DisplayName("Test getConcreteParam(TaxonomyChangeCommand, boolean); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaxonomyManagementUtilities.getConcreteParam(TaxonomyChangeCommand, boolean)"
  })
  void testGetConcreteParam_thenReturnTrue() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertTrue(TaxonomyManagementUtilities.getConcreteParam(cmd, true));
  }

  /**
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService,
   * UserRoleService, String, EntityReference)} with {@code measurableCategoryService}, {@code
   * userRoleService}, {@code userId}, {@code changeDomain}.
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService,
   * UserRoleService, String, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference) with 'measurableCategoryService', 'userRoleService', 'userId', 'changeDomain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)"
  })
  void
      testVerifyUserHasPermissionsWithMeasurableCategoryServiceUserRoleServiceUserIdChangeDomain() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
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
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    when(userRoleDao2.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
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
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao3 = mock(SettingsDao.class);
    SettingsService settingsService3 = new SettingsService(settingsDao3, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao2,
            changeLogService4,
            personService2,
            settingsService3);
    ImmutableEntityReference changeDomain =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            TaxonomyManagementUtilities.verifyUserHasPermissions(
                measurableCategoryService, userRoleService2, "42", changeDomain));
    verify(userRoleDao2).getUserRoles("42");
  }

  /**
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService,
   * UserRoleService, String, EntityReference)} with {@code measurableCategoryService}, {@code
   * userRoleService}, {@code userId}, {@code changeDomain}.
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService,
   * UserRoleService, String, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference) with 'measurableCategoryService', 'userRoleService', 'userId', 'changeDomain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)"
  })
  void
      testVerifyUserHasPermissionsWithMeasurableCategoryServiceUserRoleServiceUserIdChangeDomain2() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
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
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    UserRoleService userRoleService2 = mock(UserRoleService.class);
    when(userRoleService2.hasRole(Mockito.<String>any(), (String[]) Mockito.any()))
        .thenReturn(false);
    ImmutableEntityReference changeDomain =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            TaxonomyManagementUtilities.verifyUserHasPermissions(
                measurableCategoryService, userRoleService2, "42", changeDomain));
    verify(userRoleService2).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService,
   * UserRoleService, String, EntityReference)} with {@code measurableCategoryService}, {@code
   * userRoleService}, {@code userId}, {@code changeDomain}.
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService,
   * UserRoleService, String, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference) with 'measurableCategoryService', 'userRoleService', 'userId', 'changeDomain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)"
  })
  void
      testVerifyUserHasPermissionsWithMeasurableCategoryServiceUserRoleServiceUserIdChangeDomain3() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
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
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    UserRoleService userRoleService2 = mock(UserRoleService.class);
    when(userRoleService2.hasRole(Mockito.<String>any(), (String[]) Mockito.any()))
        .thenReturn(true);
    ImmutableEntityReference changeDomain =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    TaxonomyManagementUtilities.verifyUserHasPermissions(
        measurableCategoryService, userRoleService2, "42", changeDomain);

    // Assert
    verify(userRoleService2).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService,
   * UserRoleService, String, EntityReference)} with {@code measurableCategoryService}, {@code
   * userRoleService}, {@code userId}, {@code changeDomain}.
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#verifyUserHasPermissions(MeasurableCategoryService,
   * UserRoleService, String, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference) with 'measurableCategoryService', 'userRoleService', 'userId', 'changeDomain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.verifyUserHasPermissions(MeasurableCategoryService, UserRoleService, String, EntityReference)"
  })
  void
      testVerifyUserHasPermissionsWithMeasurableCategoryServiceUserRoleServiceUserIdChangeDomain4() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
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
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    UserRoleService userRoleService2 = mock(UserRoleService.class);
    when(userRoleService2.hasRole(Mockito.<String>any(), (String[]) Mockito.any()))
        .thenReturn(true);
    ImmutableAppGroupEntry changeDomain =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    TaxonomyManagementUtilities.verifyUserHasPermissions(
        measurableCategoryService, userRoleService2, "42", changeDomain);

    // Assert
    verify(userRoleService2).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)} with
   * {@code userRoleService}, {@code userId}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)}
   */
  @Test
  @DisplayName(
      "Test verifyUserHasPermissions(UserRoleService, String) with 'userRoleService', 'userId'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.verifyUserHasPermissions(UserRoleService, String)"
  })
  void testVerifyUserHasPermissionsWithUserRoleServiceUserId_givenFalse() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> TaxonomyManagementUtilities.verifyUserHasPermissions(userRoleService, "42"));
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)} with
   * {@code userRoleService}, {@code userId}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)}
   */
  @Test
  @DisplayName(
      "Test verifyUserHasPermissions(UserRoleService, String) with 'userRoleService', 'userId'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.verifyUserHasPermissions(UserRoleService, String)"
  })
  void testVerifyUserHasPermissionsWithUserRoleServiceUserId_givenTrue() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    // Act
    TaxonomyManagementUtilities.verifyUserHasPermissions(userRoleService, "42");

    // Assert
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)} with
   * {@code userRoleService}, {@code userId}.
   *
   * <ul>
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TaxonomyManagementUtilities#verifyUserHasPermissions(UserRoleService, String)}
   */
  @Test
  @DisplayName(
      "Test verifyUserHasPermissions(UserRoleService, String) with 'userRoleService', 'userId'; then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementUtilities.verifyUserHasPermissions(UserRoleService, String)"
  })
  void testVerifyUserHasPermissionsWithUserRoleServiceUserId_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> TaxonomyManagementUtilities.verifyUserHasPermissions(userRoleService, "42"));
    verify(userRoleDao).getUserRoles("42");
  }
}
