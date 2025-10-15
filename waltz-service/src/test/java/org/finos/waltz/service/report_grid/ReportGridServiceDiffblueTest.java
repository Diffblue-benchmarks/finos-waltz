package org.finos.waltz.service.report_grid;

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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.common.exception.NotFoundException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.report_grid.ReportGridDao;
import org.finos.waltz.data.report_grid.ReportGridMemberDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.report_grid.AdditionalColumnOptions;
import org.finos.waltz.model.report_grid.ImmutableReportGrid;
import org.finos.waltz.model.report_grid.ImmutableReportGridCell;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridInfo;
import org.finos.waltz.model.report_grid.ImmutableReportGridInstance;
import org.finos.waltz.model.report_grid.ImmutableReportGridMember;
import org.finos.waltz.model.report_grid.ImmutableReportGridUpdateCommand;
import org.finos.waltz.model.report_grid.ReportGrid;
import org.finos.waltz.model.report_grid.ReportGridCell;
import org.finos.waltz.model.report_grid.ReportGridColumnDefinitionsUpdateCommand;
import org.finos.waltz.model.report_grid.ReportGridCreateCommand;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridInfo;
import org.finos.waltz.model.report_grid.ReportGridInstance;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.finos.waltz.model.report_grid.ReportGridMember;
import org.finos.waltz.model.report_grid.ReportGridMemberRole;
import org.finos.waltz.model.report_grid.ReportGridUpdateCommand;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReportGridServiceDiffblueTest {
  @Mock private ApplicationDao applicationDao;

  @Mock private RatingSchemeService ratingSchemeService;

  @Mock private ReportGridDao reportGridDao;

  @Mock private ReportGridMemberService reportGridMemberService;

  @InjectMocks private ReportGridService reportGridService;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link ReportGridService#findAllDefinitions()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findAllDefinitions()}
   */
  @Test
  @DisplayName("Test findAllDefinitions(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findAllDefinitions()"})
  void testFindAllDefinitions_thenReturnEmpty() {
    // Arrange
    when(reportGridDao.findAllDefinitions()).thenReturn(new HashSet<>());

    // Act
    Set<ReportGridDefinition> actualFindAllDefinitionsResult =
        reportGridService.findAllDefinitions();

    // Assert
    verify(reportGridDao).findAllDefinitions();
    assertTrue(actualFindAllDefinitionsResult.isEmpty());
  }

  /**
   * Test {@link ReportGridService#findAllDefinitions()}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findAllDefinitions()}
   */
  @Test
  @DisplayName("Test findAllDefinitions(); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findAllDefinitions()"})
  void testFindAllDefinitions_thenThrowNotFoundException() {
    // Arrange
    when(reportGridDao.findAllDefinitions())
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.findAllDefinitions());
    verify(reportGridDao).findAllDefinitions();
  }

  /**
   * Test {@link ReportGridService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} return {@link ImmutableReportGridDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then get() return ImmutableReportGridDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ReportGridService.findByExternalId(String)"})
  void testFindByExternalId_thenGetReturnImmutableReportGridDefinition() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridDefinitionByExternalId(Mockito.<String>any()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    // Act
    Optional<ReportGridDefinition> actualFindByExternalIdResult =
        reportGridService.findByExternalId("42");

    // Assert
    verify(reportGridDao).getGridDefinitionByExternalId("42");
    ReportGridDefinition getResult = actualFindByExternalIdResult.get();
    assertTrue(getResult instanceof ImmutableReportGridDefinition);
    assertEquals("2020-03-01", getResult.lastUpdatedBy());
    assertEquals("Name", getResult.name());
    assertEquals("Provenance", getResult.provenance());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(EntityKind.ALL, getResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, getResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        getResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertTrue(actualFindByExternalIdResult.isPresent());
    assertSame(derivedColumnDefinitionsResult, getResult.fixedColumnDefinitions());
    assertSame(ofResult, getResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ReportGridService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ReportGridService.findByExternalId(String)"})
  void testFindByExternalId_thenThrowNotFoundException() {
    // Arrange
    when(reportGridDao.getGridDefinitionByExternalId(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.findByExternalId("42"));
    verify(reportGridDao).getGridDefinitionByExternalId("42");
  }

  /**
   * Test {@link ReportGridService#findGridDefinitionsForUser(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findGridDefinitionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGridDefinitionsForUser(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findGridDefinitionsForUser(String)"})
  void testFindGridDefinitionsForUser_thenReturnEmpty() {
    // Arrange
    when(reportGridDao.findGridDefinitionsForUser(Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<ReportGridDefinition> actualFindGridDefinitionsForUserResult =
        reportGridService.findGridDefinitionsForUser("janedoe");

    // Assert
    verify(reportGridDao).findGridDefinitionsForUser("janedoe");
    assertTrue(actualFindGridDefinitionsForUserResult.isEmpty());
  }

  /**
   * Test {@link ReportGridService#findGridDefinitionsForUser(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findGridDefinitionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGridDefinitionsForUser(String); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findGridDefinitionsForUser(String)"})
  void testFindGridDefinitionsForUser_thenThrowNotFoundException() {
    // Arrange
    when(reportGridDao.findGridDefinitionsForUser(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> reportGridService.findGridDefinitionsForUser("janedoe"));
    verify(reportGridDao).findGridDefinitionsForUser("janedoe");
  }

  /**
   * Test {@link ReportGridService#findGridInfoForUser(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findGridInfoForUser(String)}
   */
  @Test
  @DisplayName("Test findGridInfoForUser(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findGridInfoForUser(String)"})
  void testFindGridInfoForUser_thenReturnEmpty() {
    // Arrange
    when(reportGridDao.findGridInfoForUser(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act
    Set<ReportGridInfo> actualFindGridInfoForUserResult =
        reportGridService.findGridInfoForUser("janedoe");

    // Assert
    verify(reportGridDao).findGridInfoForUser("janedoe");
    assertTrue(actualFindGridInfoForUserResult.isEmpty());
  }

  /**
   * Test {@link ReportGridService#findGridInfoForUser(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findGridInfoForUser(String)}
   */
  @Test
  @DisplayName("Test findGridInfoForUser(String); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findGridInfoForUser(String)"})
  void testFindGridInfoForUser_thenThrowNotFoundException() {
    // Arrange
    when(reportGridDao.findGridInfoForUser(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.findGridInfoForUser("janedoe"));
    verify(reportGridDao).findGridInfoForUser("janedoe");
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions() {
    // Arrange
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenThrow(
            new NotFoundException(
                "ReportGrid - getting by ID={} SelectionOptions={}", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> reportGridService.getByIdAndSelectionOptions(1L, null, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions2() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    assertTrue(getResult.definition() instanceof ImmutableReportGridDefinition);
    assertTrue(getResult.instance() instanceof ImmutableReportGridInstance);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions3() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenThrow(
            new NotFoundException(
                "ReportGrid - getting by ID={} SelectionOptions={}", "An error occurred"));
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.getByIdAndSelectionOptions(
                1L,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                "janedoe"));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions4() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any()))
        .thenThrow(
            new NotFoundException(
                "ReportGrid - getting by ID={} SelectionOptions={}", "An error occurred"));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.getByIdAndSelectionOptions(
                1L,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                "janedoe"));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions5() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    builderResult.addDerivedColumnDefinitions(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    ImmutableReportGridDefinition immutableReportGridDefinition =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.APPLICATION)
            .build();
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(immutableReportGridDefinition);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    ReportGridDefinition definitionResult = getResult.definition();
    assertTrue(definitionResult instanceof ImmutableReportGridDefinition);
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        definitionResult.derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    ReportGridDerivedColumnDefinition getResult2 = derivedColumnDefinitionsResult.get(0);
    assertTrue(getResult2 instanceof ImmutableReportGridDerivedColumnDefinition);
    assertEquals("Column Description", getResult2.columnDescription());
    assertEquals("Derivation Script", getResult2.derivationScript());
    assertEquals("Display Name", getResult2.displayName());
    assertEquals(1, getResult2.position());
    assertEquals(1L, getResult2.gridColumnId().longValue());
    assertEquals(1L, getResult2.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, getResult2.kind());
    assertTrue(definitionResult.fixedColumnDefinitions().isEmpty());
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions6() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    assertTrue(getResult.definition() instanceof ImmutableReportGridDefinition);
    assertTrue(getResult.instance() instanceof ImmutableReportGridInstance);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions7() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenThrow(
            new NotFoundException(
                "ReportGrid - getting by ID={} SelectionOptions={}", "An error occurred"));
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.getByIdAndSelectionOptions(
                1L,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                "janedoe"));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions8() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(
            new NotFoundException(
                "ReportGrid - getting by ID={} SelectionOptions={}", "An error occurred"));
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.getByIdAndSelectionOptions(
                1L,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                "janedoe"));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions_givenActive() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    assertTrue(getResult.definition() instanceof ImmutableReportGridDefinition);
    assertTrue(getResult.instance() instanceof ImmutableReportGridInstance);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName(
      "Test getByIdAndSelectionOptions(long, IdSelectionOptions, String); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions_givenInHouse() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    assertTrue(getResult.definition() instanceof ImmutableReportGridDefinition);
    assertTrue(getResult.instance() instanceof ImmutableReportGridInstance);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName("Test getByIdAndSelectionOptions(long, IdSelectionOptions, String); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions_givenPending() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    assertTrue(getResult.definition() instanceof ImmutableReportGridDefinition);
    assertTrue(getResult.instance() instanceof ImmutableReportGridInstance);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <ul>
   *   <li>Then calls {@link RatingSchemeDAO#findRatingSchemeItemsByIds(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName(
      "Test getByIdAndSelectionOptions(long, IdSelectionOptions, String); then calls findRatingSchemeItemsByIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions_thenCallsFindRatingSchemeItemsByIds() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridMemberDao).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    assertTrue(getResult.definition() instanceof ImmutableReportGridDefinition);
    assertTrue(getResult.instance() instanceof ImmutableReportGridInstance);
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} instance cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName(
      "Test getByIdAndSelectionOptions(long, IdSelectionOptions, String); then return get() instance cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions_thenReturnGetInstanceCellDataSizeIsOne() {
    // Arrange
    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();

    ImmutableReportGridCell.Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    ImmutableReportGridCell.Builder numberValueResult =
        errorValueResult.numberValue(new BigDecimal("2.3"));
    reportGridCellSet.add(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(reportGridCellSet);
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    ReportGridInstance instanceResult = getResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance);
    assertEquals(1, instanceResult.cellData().size());
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} instance ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName(
      "Test getByIdAndSelectionOptions(long, IdSelectionOptions, String); then return get() instance ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions_thenReturnGetInstanceRatingSchemeItemsSizeIsOne() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    ReportGridInstance instanceResult = getResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance);
    assertEquals(1, instanceResult.ratingSchemeItems().size());
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} instance subjects size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName(
      "Test getByIdAndSelectionOptions(long, IdSelectionOptions, String); then return get() instance subjects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions_thenReturnGetInstanceSubjectsSizeIsOne() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    assertTrue(getResult.definition() instanceof ImmutableReportGridDefinition);
    ReportGridInstance instanceResult = getResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance);
    assertEquals(1, instanceResult.subjects().size());
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} instance subjects size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName(
      "Test getByIdAndSelectionOptions(long, IdSelectionOptions, String); then return get() instance subjects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions_thenReturnGetInstanceSubjectsSizeIsOne2() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    assertTrue(getResult.definition() instanceof ImmutableReportGridDefinition);
    ReportGridInstance instanceResult = getResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance);
    assertEquals(1, instanceResult.subjects().size());
  }

  /**
   * Test {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} members size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getByIdAndSelectionOptions(long,
   * IdSelectionOptions, String)}
   */
  @Test
  @DisplayName(
      "Test getByIdAndSelectionOptions(long, IdSelectionOptions, String); then return get() members size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ReportGridService.getByIdAndSelectionOptions(long, IdSelectionOptions, String)"
  })
  void testGetByIdAndSelectionOptions_thenReturnGetMembersSizeIsOne() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.APPLICATION)
                .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    HashSet<ReportGridMember> reportGridMemberSet = new HashSet<>();

    ImmutableReportGridMember.Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);
    reportGridMemberSet.add(
        roleResult
            .user(
                ImmutablePerson.builder()
                    .departmentName("Department Name")
                    .displayName("Display Name")
                    .email("jane.doe@example.org")
                    .employeeId("42")
                    .id(1L)
                    .isRemoved(true)
                    .kind(EntityKind.ALL)
                    .managerEmployeeId("42")
                    .mobilePhone("6625550144")
                    .officePhone("6625550144")
                    .organisationalUnitId(1L)
                    .personKind(PersonKind.EMPLOYEE)
                    .title("Dr")
                    .userId("42")
                    .userPrincipalName("User Principal Name")
                    .build())
            .build());
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(reportGridMemberSet);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions =
        reportGridService.getByIdAndSelectionOptions(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            "janedoe");

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridMemberService).findByGridId(1L);
    ReportGrid getResult = actualByIdAndSelectionOptions.get();
    assertTrue(getResult instanceof ImmutableReportGrid);
    ReportGridInstance instanceResult = getResult.instance();
    assertTrue(instanceResult instanceof ImmutableReportGridInstance);
    assertEquals(1, getResult.members().size());
    Set<ReportGridCell> cellDataResult = instanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, instanceResult.ratingSchemeItems());
    assertSame(cellDataResult, instanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test mkInstance(long, IdSelectionOptions, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenThrow(new NotFoundException("targetKind cannot be null", "An error occurred"));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.mkInstance(
                1L,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                EntityKind.APPLICATION));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test mkInstance(long, IdSelectionOptions, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance2() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenThrow(new NotFoundException("targetKind cannot be null", "An error occurred"));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.mkInstance(
                1L,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                EntityKind.APPLICATION));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test mkInstance(long, IdSelectionOptions, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance3() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test mkInstance(long, IdSelectionOptions, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance4() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test mkInstance(long, IdSelectionOptions, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance5() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test mkInstance(long, IdSelectionOptions, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance6() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new NotFoundException("targetKind cannot be null", "An error occurred"));
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.mkInstance(
                1L,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                EntityKind.APPLICATION));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test mkInstance(long, IdSelectionOptions, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance7() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_givenActive_whenBuilderAddEntityLifecycleStatusesActive() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_givenPending_whenBuilderAddEntityLifecycleStatusesPending() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Then calls {@link RatingSchemeDAO#findRatingSchemeItemsByIds(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); then calls findRatingSchemeItemsByIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_thenCallsFindRatingSchemeItemsByIds() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_thenReturnCellDataSizeIsOne() {
    // Arrange
    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();

    ImmutableReportGridCell.Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    ImmutableReportGridCell.Builder numberValueResult =
        errorValueResult.numberValue(new BigDecimal("2.3"));
    reportGridCellSet.add(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(reportGridCellSet);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    assertEquals(1, actualMkInstanceResult.cellData().size());
    Set<RatingSchemeItem> ratingSchemeItemsResult = actualMkInstanceResult.ratingSchemeItems();
    assertTrue(ratingSchemeItemsResult.isEmpty());
    assertSame(ratingSchemeItemsResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); then return ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_thenReturnRatingSchemeItemsSizeIsOne() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    assertEquals(1, actualMkInstanceResult.ratingSchemeItems().size());
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Then return subjects is cellData.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); then return subjects is cellData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_thenReturnSubjectsIsCellData() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
    assertSame(cellDataResult, actualMkInstanceResult.subjects());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Then return subjects size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); then return subjects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_thenReturnSubjectsSizeIsOne() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    assertEquals(1, actualMkInstanceResult.subjects().size());
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Then return subjects size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); then return subjects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_thenReturnSubjectsSizeIsOne2() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    assertEquals(1, actualMkInstanceResult.subjects().size());
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
  }

  /**
   * Test {@link ReportGridService#mkInstance(long, IdSelectionOptions, EntityKind)}.
   *
   * <ul>
   *   <li>Then return subjects size is two.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#mkInstance(long, IdSelectionOptions,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkInstance(long, IdSelectionOptions, EntityKind); then return subjects size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInstance ReportGridService.mkInstance(long, IdSelectionOptions, EntityKind)"
  })
  void testMkInstance_thenReturnSubjectsSizeIsTwo() {
    // Arrange
    when(reportGridDao.findCellDataByGridId(anyLong(), Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(2L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ReportGridInstance actualMkInstanceResult =
        reportGridService.mkInstance(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(reportGridDao).findCellDataByGridId(eq(1L), isA(GenericSelector.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualMkInstanceResult instanceof ImmutableReportGridInstance);
    assertEquals(2, actualMkInstanceResult.subjects().size());
    Set<ReportGridCell> cellDataResult = actualMkInstanceResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualMkInstanceResult.ratingSchemeItems());
  }

  /**
   * Test {@link ReportGridService#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridService#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridDefinition ReportGridService.updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String)"
  })
  void testUpdateColumnDefinitions() throws InsufficientPrivelegeException {
    // Arrange
    doThrow(new NotFoundException("Code", "An error occurred"))
        .when(reportGridDao)
        .updateColumnDefinitions(
            anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> reportGridService.updateColumnDefinitions(1L, null, "janedoe"));
    verify(reportGridDao).updateColumnDefinitions(eq(1L), isNull());
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridService#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridDao}.
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String); given ReportGridDao; then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridDefinition ReportGridService.updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String)"
  })
  void testUpdateColumnDefinitions_givenReportGridDao_thenThrowNotFoundException()
      throws InsufficientPrivelegeException {
    // Arrange
    doThrow(new NotFoundException("Code", "An error occurred"))
        .when(reportGridMemberService)
        .checkIsOwner(anyLong(), Mockito.<String>any());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> reportGridService.updateColumnDefinitions(1L, null, "janedoe"));
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridService#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ReportGridMemberDao#canUpdate(long, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String); then calls canUpdate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridDefinition ReportGridService.updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String)"
  })
  void testUpdateColumnDefinitions_thenCallsCanUpdate() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    doNothing()
        .when(reportGridDao)
        .updateColumnDefinitions(
            anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());

    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    // Act
    ReportGridDefinition actualUpdateColumnDefinitionsResult =
        reportGridService.updateColumnDefinitions(1L, null, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).updateColumnDefinitions(eq(1L), isNull());
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
    assertTrue(actualUpdateColumnDefinitionsResult instanceof ImmutableReportGridDefinition);
    LocalDateTime lastUpdatedAtResult = actualUpdateColumnDefinitionsResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualUpdateColumnDefinitionsResult.lastUpdatedBy());
    assertEquals("Name", actualUpdateColumnDefinitionsResult.name());
    assertEquals("Provenance", actualUpdateColumnDefinitionsResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualUpdateColumnDefinitionsResult.description());
    assertEquals(EntityKind.ALL, actualUpdateColumnDefinitionsResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualUpdateColumnDefinitionsResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualUpdateColumnDefinitionsResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(
        derivedColumnDefinitionsResult,
        actualUpdateColumnDefinitionsResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableReportGridDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String); then return ImmutableReportGridDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridDefinition ReportGridService.updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String)"
  })
  void testUpdateColumnDefinitions_thenReturnImmutableReportGridDefinition()
      throws InsufficientPrivelegeException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    doNothing()
        .when(reportGridDao)
        .updateColumnDefinitions(
            anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());

    // Act
    ReportGridDefinition actualUpdateColumnDefinitionsResult =
        reportGridService.updateColumnDefinitions(1L, null, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).updateColumnDefinitions(eq(1L), isNull());
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
    assertTrue(actualUpdateColumnDefinitionsResult instanceof ImmutableReportGridDefinition);
    LocalDateTime lastUpdatedAtResult = actualUpdateColumnDefinitionsResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualUpdateColumnDefinitionsResult.lastUpdatedBy());
    assertEquals("Name", actualUpdateColumnDefinitionsResult.name());
    assertEquals("Provenance", actualUpdateColumnDefinitionsResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualUpdateColumnDefinitionsResult.description());
    assertEquals(EntityKind.ALL, actualUpdateColumnDefinitionsResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualUpdateColumnDefinitionsResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualUpdateColumnDefinitionsResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(
        derivedColumnDefinitionsResult,
        actualUpdateColumnDefinitionsResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid_thenReturnEmpty() {
    // Arrange
    when(reportGridDao.findCommentSupportingColumnIdsForGrid(anyLong()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Long> actualFindCommentSupportingColumnIdsForGridResult =
        reportGridService.findCommentSupportingColumnIdsForGrid(1L);

    // Assert
    verify(reportGridDao).findCommentSupportingColumnIdsForGrid(1L);
    assertTrue(actualFindCommentSupportingColumnIdsForGridResult.isEmpty());
  }

  /**
   * Test {@link ReportGridService#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid_thenThrowNotFoundException() {
    // Arrange
    when(reportGridDao.findCommentSupportingColumnIdsForGrid(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> reportGridService.findCommentSupportingColumnIdsForGrid(1L));
    verify(reportGridDao).findCommentSupportingColumnIdsForGrid(1L);
  }

  /**
   * Test {@link ReportGridService#create(ReportGridCreateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridService#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ReportGridCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridService.create(ReportGridCreateCommand, String)"})
  void testCreate() {
    // Arrange
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.create(null, "janedoe"));
    verify(reportGridDao).create(isNull(), eq("janedoe"));
  }

  /**
   * Test {@link ReportGridService#create(ReportGridCreateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridService#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ReportGridCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridService.create(ReportGridCreateCommand, String)"})
  void testCreate2() {
    // Arrange
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(reportGridMemberService.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.create(null, "janedoe"));
    verify(reportGridDao).create(isNull(), eq("janedoe"));
    verify(reportGridMemberService).register(1L, "janedoe", ReportGridMemberRole.OWNER);
  }

  /**
   * Test {@link ReportGridService#create(ReportGridCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link ReportGridMemberDao#register(long, String,
   *       ReportGridMemberRole)} return one.
   *   <li>Then calls {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(ReportGridCreateCommand, String); given ReportGridMemberDao register(long, String, ReportGridMemberRole) return one; then calls register(long, String, ReportGridMemberRole)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridService.create(ReportGridCreateCommand, String)"})
  void testCreate_givenReportGridMemberDaoRegisterReturnOne_thenCallsRegister() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());

    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    // Act
    ReportGridInfo actualCreateResult = reportGridService.create(null, "janedoe");

    // Assert
    verify(reportGridDao).create(isNull(), eq("janedoe"));
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridMemberDao).register(1L, "janedoe", ReportGridMemberRole.OWNER);
    assertTrue(actualCreateResult instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualCreateResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCreateResult.lastUpdatedBy());
    assertEquals("Name", actualCreateResult.name());
    assertEquals("Provenance", actualCreateResult.provenance());
    assertEquals("The characteristics of someone or something", actualCreateResult.description());
    assertEquals(1L, actualCreateResult.gridId());
    assertEquals(EntityKind.ALL, actualCreateResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCreateResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#create(ReportGridCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberService} {@link ReportGridMemberService#register(long,
   *       String, ReportGridMemberRole)} return one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(ReportGridCreateCommand, String); given ReportGridMemberService register(long, String, ReportGridMemberRole) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridService.create(ReportGridCreateCommand, String)"})
  void testCreate_givenReportGridMemberServiceRegisterReturnOne() {
    // Arrange
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());
    when(reportGridMemberService.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);

    // Act
    ReportGridInfo actualCreateResult = reportGridService.create(null, "janedoe");

    // Assert
    verify(reportGridDao).create(isNull(), eq("janedoe"));
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridMemberService).register(1L, "janedoe", ReportGridMemberRole.OWNER);
    assertTrue(actualCreateResult instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualCreateResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCreateResult.lastUpdatedBy());
    assertEquals("Name", actualCreateResult.name());
    assertEquals("Provenance", actualCreateResult.provenance());
    assertEquals("The characteristics of someone or something", actualCreateResult.description());
    assertEquals(1L, actualCreateResult.gridId());
    assertEquals(EntityKind.ALL, actualCreateResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCreateResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(long, ReportGridUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.update(long, ReportGridUpdateCommand, String)"
  })
  void testUpdate() throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.update(1L, null, "janedoe"));
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(long, ReportGridUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.update(long, ReportGridUpdateCommand, String)"
  })
  void testUpdate2() throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.update(
            anyLong(), Mockito.<ReportGridUpdateCommand>any(), Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.update(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridDao).update(eq(1L), isA(ReportGridUpdateCommand.class), eq("janedoe"));
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(long, ReportGridUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.update(long, ReportGridUpdateCommand, String)"
  })
  void testUpdate3() throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PRIVATE)
                .build());
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenThrow(
            new NotFoundException(
                "You do not have permission to change the kind of a report grid",
                "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.update(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridDao} {@link ReportGridDao#update(long, ReportGridUpdateCommand,
   *       String)} return one.
   *   <li>Then return visibilityKind is {@code PUBLIC}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given ReportGridDao update(long, ReportGridUpdateCommand, String) return one; then return visibilityKind is 'PUBLIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.update(long, ReportGridUpdateCommand, String)"
  })
  void testUpdate_givenReportGridDaoUpdateReturnOne_thenReturnVisibilityKindIsPublic()
      throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.update(
            anyLong(), Mockito.<ReportGridUpdateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());

    // Act
    ReportGridInfo actualUpdateResult =
        reportGridService.update(
            1L,
            ImmutableReportGridUpdateCommand.builder()
                .description("The characteristics of someone or something")
                .kind(ReportGridKind.PUBLIC)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(reportGridDao, atLeast(1)).getGridInfoById(1L);
    verify(reportGridDao).update(eq(1L), isA(ReportGridUpdateCommand.class), eq("janedoe"));
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
    assertTrue(actualUpdateResult instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualUpdateResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualUpdateResult.lastUpdatedBy());
    assertEquals("Name", actualUpdateResult.name());
    assertEquals("Provenance", actualUpdateResult.provenance());
    assertEquals("The characteristics of someone or something", actualUpdateResult.description());
    assertEquals(1L, actualUpdateResult.gridId());
    assertEquals(EntityKind.ALL, actualUpdateResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualUpdateResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given ReportGridDao; when 'null'; then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.update(long, ReportGridUpdateCommand, String)"
  })
  void testUpdate_givenReportGridDao_whenNull_thenThrowNotFoundException()
      throws InsufficientPrivelegeException {
    // Arrange
    doThrow(new NotFoundException("Code", "An error occurred"))
        .when(reportGridMemberService)
        .checkIsOwner(anyLong(), Mockito.<String>any());

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.update(1L, null, "janedoe"));
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link ReportGridMemberDao#canUpdate(long, String)}
   *       return {@code true}.
   *   <li>Then calls {@link ReportGridMemberDao#canUpdate(long, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given ReportGridMemberDao canUpdate(long, String) return 'true'; then calls canUpdate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.update(long, ReportGridUpdateCommand, String)"
  })
  void testUpdate_givenReportGridMemberDaoCanUpdateReturnTrue_thenCallsCanUpdate()
      throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.update(1L, null, "janedoe"));
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Then return visibilityKind is {@code PRIVATE}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); then return visibilityKind is 'PRIVATE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.update(long, ReportGridUpdateCommand, String)"
  })
  void testUpdate_thenReturnVisibilityKindIsPrivate() throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.update(
            anyLong(), Mockito.<ReportGridUpdateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PRIVATE)
                .build());
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    // Act
    ReportGridInfo actualUpdateResult =
        reportGridService.update(
            1L,
            ImmutableReportGridUpdateCommand.builder()
                .description("The characteristics of someone or something")
                .kind(ReportGridKind.PUBLIC)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(reportGridDao, atLeast(1)).getGridInfoById(1L);
    verify(reportGridDao).update(eq(1L), isA(ReportGridUpdateCommand.class), eq("janedoe"));
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertTrue(actualUpdateResult instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualUpdateResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualUpdateResult.lastUpdatedBy());
    assertEquals("Name", actualUpdateResult.name());
    assertEquals("Provenance", actualUpdateResult.provenance());
    assertEquals("The characteristics of someone or something", actualUpdateResult.description());
    assertEquals(1L, actualUpdateResult.gridId());
    assertEquals(EntityKind.ALL, actualUpdateResult.subjectKind());
    assertEquals(ReportGridKind.PRIVATE, actualUpdateResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#findDefinitionsForOwner(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findDefinitionsForOwner(String)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwner(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findDefinitionsForOwner(String)"})
  void testFindDefinitionsForOwner_thenReturnEmpty() {
    // Arrange
    when(reportGridDao.findDefinitionsForOwner(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act
    Set<ReportGridDefinition> actualFindDefinitionsForOwnerResult =
        reportGridService.findDefinitionsForOwner("janedoe");

    // Assert
    verify(reportGridDao).findDefinitionsForOwner("janedoe");
    assertTrue(actualFindDefinitionsForOwnerResult.isEmpty());
  }

  /**
   * Test {@link ReportGridService#findDefinitionsForOwner(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#findDefinitionsForOwner(String)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwner(String); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findDefinitionsForOwner(String)"})
  void testFindDefinitionsForOwner_thenThrowNotFoundException() {
    // Arrange
    when(reportGridDao.findDefinitionsForOwner(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> reportGridService.findDefinitionsForOwner("janedoe"));
    verify(reportGridDao).findDefinitionsForOwner("janedoe");
  }

  /**
   * Test {@link ReportGridService#remove(long, String)}.
   *
   * <p>Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  @DisplayName("Test remove(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridService.remove(long, String)"})
  void testRemove() throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenThrow(new NotFoundException("REPORT_GRID_NOT_FOUND", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.remove(1L, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
  }

  /**
   * Test {@link ReportGridService#remove(long, String)}.
   *
   * <p>Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  @DisplayName("Test remove(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridService.remove(long, String)"})
  void testRemove2() throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    doThrow(new NotFoundException("Code", "An error occurred"))
        .when(reportGridMemberService)
        .checkIsOwner(anyLong(), Mockito.<String>any());

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.remove(1L, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridService#remove(long, String)}.
   *
   * <p>Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  @DisplayName("Test remove(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridService.remove(long, String)"})
  void testRemove3() throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.remove(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.remove(1L, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).remove(1L);
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridService#remove(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridDao} {@link ReportGridDao#remove(long)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(long, String); given ReportGridDao remove(long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridService.remove(long, String)"})
  void testRemove_givenReportGridDaoRemoveReturnFalse_thenReturnFalse()
      throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.remove(anyLong())).thenReturn(false);
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());

    // Act
    boolean actualRemoveResult = reportGridService.remove(1L, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).remove(1L);
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ReportGridService#remove(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridDao} {@link ReportGridDao#remove(long)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(long, String); given ReportGridDao remove(long) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridService.remove(long, String)"})
  void testRemove_givenReportGridDaoRemoveReturnTrue_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    when(reportGridDao.remove(anyLong())).thenReturn(true);
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());

    // Act
    boolean actualRemoveResult = reportGridService.remove(1L, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).remove(1L);
    verify(reportGridMemberService).checkIsOwner(1L, "janedoe");
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ReportGridService#remove(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link ReportGridMemberDao#canUpdate(long, String)}
   *       return {@code true}.
   *   <li>Then calls {@link ReportGridMemberDao#canUpdate(long, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(long, String); given ReportGridMemberDao canUpdate(long, String) return 'true'; then calls canUpdate(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridService.remove(long, String)"})
  void testRemove_givenReportGridMemberDaoCanUpdateReturnTrue_thenCallsCanUpdate()
      throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.remove(anyLong())).thenReturn(true);
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    // Act
    boolean actualRemoveResult = reportGridService.remove(1L, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).remove(1L);
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ReportGridService#getGridDefinitionById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableReportGridDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getGridDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getGridDefinitionById(long); then return ImmutableReportGridDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridService.getGridDefinitionById(long)"})
  void testGetGridDefinitionById_thenReturnImmutableReportGridDefinition() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    // Act
    ReportGridDefinition actualGridDefinitionById = reportGridService.getGridDefinitionById(1L);

    // Assert
    verify(reportGridDao).getGridDefinitionById(1L);
    assertTrue(actualGridDefinitionById instanceof ImmutableReportGridDefinition);
    LocalDateTime lastUpdatedAtResult = actualGridDefinitionById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualGridDefinitionById.lastUpdatedBy());
    assertEquals("Name", actualGridDefinitionById.name());
    assertEquals("Provenance", actualGridDefinitionById.provenance());
    assertEquals(
        "The characteristics of someone or something", actualGridDefinitionById.description());
    assertEquals(EntityKind.ALL, actualGridDefinitionById.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualGridDefinitionById.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualGridDefinitionById.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualGridDefinitionById.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#getGridDefinitionById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getGridDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getGridDefinitionById(long); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridService.getGridDefinitionById(long)"})
  void testGetGridDefinitionById_thenThrowNotFoundException() {
    // Arrange
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.getGridDefinitionById(1L));
    verify(reportGridDao).getGridDefinitionById(1L);
  }

  /**
   * Test {@link ReportGridService#findAdditionalColumnOptionsForKind(EntityKind)}.
   *
   * <p>Method under test: {@link ReportGridService#findAdditionalColumnOptionsForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findAdditionalColumnOptionsForKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridService.findAdditionalColumnOptionsForKind(EntityKind)"})
  void testFindAdditionalColumnOptionsForKind() {
    // Arrange and Act
    Set<AdditionalColumnOptions> actualFindAdditionalColumnOptionsForKindResult =
        reportGridService.findAdditionalColumnOptionsForKind(EntityKind.ALL);

    // Assert
    assertEquals(1, actualFindAdditionalColumnOptionsForKindResult.size());
    assertTrue(
        actualFindAdditionalColumnOptionsForKindResult.contains(AdditionalColumnOptions.NONE));
  }

  /**
   * Test {@link ReportGridService#getGridDefinitionByExtId(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableReportGridDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getGridDefinitionByExtId(String)}
   */
  @Test
  @DisplayName("Test getGridDefinitionByExtId(String); then return ImmutableReportGridDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridService.getGridDefinitionByExtId(String)"})
  void testGetGridDefinitionByExtId_thenReturnImmutableReportGridDefinition() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridDefinitionByExternalId(Mockito.<String>any()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    // Act
    ReportGridDefinition actualGridDefinitionByExtId =
        reportGridService.getGridDefinitionByExtId("42");

    // Assert
    verify(reportGridDao).getGridDefinitionByExternalId("42");
    assertTrue(actualGridDefinitionByExtId instanceof ImmutableReportGridDefinition);
    LocalDateTime lastUpdatedAtResult = actualGridDefinitionByExtId.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualGridDefinitionByExtId.lastUpdatedBy());
    assertEquals("Name", actualGridDefinitionByExtId.name());
    assertEquals("Provenance", actualGridDefinitionByExtId.provenance());
    assertEquals(
        "The characteristics of someone or something", actualGridDefinitionByExtId.description());
    assertEquals(EntityKind.ALL, actualGridDefinitionByExtId.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualGridDefinitionByExtId.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualGridDefinitionByExtId.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(
        derivedColumnDefinitionsResult, actualGridDefinitionByExtId.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#getGridDefinitionByExtId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#getGridDefinitionByExtId(String)}
   */
  @Test
  @DisplayName("Test getGridDefinitionByExtId(String); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridService.getGridDefinitionByExtId(String)"})
  void testGetGridDefinitionByExtId_thenThrowNotFoundException() {
    // Arrange
    when(reportGridDao.getGridDefinitionByExternalId(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.getGridDefinitionByExtId("42"));
    verify(reportGridDao).getGridDefinitionByExternalId("42");
  }

  /**
   * Test {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)} with {@code long},
   * {@code ReportGridUpdateCommand}, {@code String}.
   *
   * <p>Method under test: {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, ReportGridUpdateCommand, String) with 'long', 'ReportGridUpdateCommand', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.clone(long, ReportGridUpdateCommand, String)"
  })
  void testCloneWithLongReportGridUpdateCommandString() {
    // Arrange
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenThrow(new NotFoundException("REPORT_GRID_NOT_FOUND", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.clone(1L, null, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
  }

  /**
   * Test {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)} with {@code long},
   * {@code ReportGridUpdateCommand}, {@code String}.
   *
   * <p>Method under test: {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, ReportGridUpdateCommand, String) with 'long', 'ReportGridUpdateCommand', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.clone(long, ReportGridUpdateCommand, String)"
  })
  void testCloneWithLongReportGridUpdateCommandString2() {
    // Arrange
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenThrow(new NotFoundException("name", "An error occurred"));
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.clone(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(reportGridDao).create(isA(ReportGridCreateCommand.class), eq("janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
  }

  /**
   * Test {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)} with {@code long},
   * {@code ReportGridUpdateCommand}, {@code String}.
   *
   * <p>Method under test: {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, ReportGridUpdateCommand, String) with 'long', 'ReportGridUpdateCommand', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.clone(long, ReportGridUpdateCommand, String)"
  })
  void testCloneWithLongReportGridUpdateCommandString3() {
    // Arrange
    doThrow(new NotFoundException("name", "An error occurred"))
        .when(reportGridDao)
        .updateColumnDefinitions(
            anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    when(reportGridMemberService.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            reportGridService.clone(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(reportGridDao).create(isA(ReportGridCreateCommand.class), eq("janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridDao)
        .updateColumnDefinitions(eq(1L), isA(ReportGridColumnDefinitionsUpdateCommand.class));
    verify(reportGridMemberService).register(1L, "janedoe", ReportGridMemberRole.OWNER);
  }

  /**
   * Test {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)} with {@code long},
   * {@code ReportGridUpdateCommand}, {@code String}.
   *
   * <p>Method under test: {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, ReportGridUpdateCommand, String) with 'long', 'ReportGridUpdateCommand', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.clone(long, ReportGridUpdateCommand, String)"
  })
  void testCloneWithLongReportGridUpdateCommandString4() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    builderResult.addFixedColumnDefinitions(
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    ImmutableReportGridDefinition immutableReportGridDefinition =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();
    doNothing()
        .when(reportGridDao)
        .updateColumnDefinitions(
            anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(immutableReportGridDefinition);
    when(reportGridMemberService.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);

    // Act
    ReportGridInfo actualCloneResult =
        reportGridService.clone(
            1L,
            ImmutableReportGridUpdateCommand.builder()
                .description("The characteristics of someone or something")
                .kind(ReportGridKind.PUBLIC)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(reportGridDao).create(isA(ReportGridCreateCommand.class), eq("janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridDao)
        .updateColumnDefinitions(eq(1L), isA(ReportGridColumnDefinitionsUpdateCommand.class));
    verify(reportGridMemberService).register(1L, "janedoe", ReportGridMemberRole.OWNER);
    assertTrue(actualCloneResult instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualCloneResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCloneResult.lastUpdatedBy());
    assertEquals("Name", actualCloneResult.name());
    assertEquals("Provenance", actualCloneResult.provenance());
    assertEquals("The characteristics of someone or something", actualCloneResult.description());
    assertEquals(1L, actualCloneResult.gridId());
    assertEquals(EntityKind.ALL, actualCloneResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCloneResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)} with {@code long},
   * {@code ReportGridUpdateCommand}, {@code String}.
   *
   * <p>Method under test: {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, ReportGridUpdateCommand, String) with 'long', 'ReportGridUpdateCommand', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.clone(long, ReportGridUpdateCommand, String)"
  })
  void testCloneWithLongReportGridUpdateCommandString5() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    builderResult.addDerivedColumnDefinitions(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    ImmutableReportGridDefinition immutableReportGridDefinition =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();
    doNothing()
        .when(reportGridDao)
        .updateColumnDefinitions(
            anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(immutableReportGridDefinition);
    when(reportGridMemberService.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);

    // Act
    ReportGridInfo actualCloneResult =
        reportGridService.clone(
            1L,
            ImmutableReportGridUpdateCommand.builder()
                .description("The characteristics of someone or something")
                .kind(ReportGridKind.PUBLIC)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(reportGridDao).create(isA(ReportGridCreateCommand.class), eq("janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridDao)
        .updateColumnDefinitions(eq(1L), isA(ReportGridColumnDefinitionsUpdateCommand.class));
    verify(reportGridMemberService).register(1L, "janedoe", ReportGridMemberRole.OWNER);
    assertTrue(actualCloneResult instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualCloneResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCloneResult.lastUpdatedBy());
    assertEquals("Name", actualCloneResult.name());
    assertEquals("Provenance", actualCloneResult.provenance());
    assertEquals("The characteristics of someone or something", actualCloneResult.description());
    assertEquals(1L, actualCloneResult.gridId());
    assertEquals(EntityKind.ALL, actualCloneResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCloneResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)} with {@code long},
   * {@code ReportGridUpdateCommand}, {@code String}.
   *
   * <p>Method under test: {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, ReportGridUpdateCommand, String) with 'long', 'ReportGridUpdateCommand', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.clone(long, ReportGridUpdateCommand, String)"
  })
  void testCloneWithLongReportGridUpdateCommandString6() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    builderResult.addFixedColumnDefinitions(
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    builderResult.addFixedColumnDefinitions(
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    ImmutableReportGridDefinition immutableReportGridDefinition =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();
    doNothing()
        .when(reportGridDao)
        .updateColumnDefinitions(
            anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(immutableReportGridDefinition);
    when(reportGridMemberService.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);

    // Act
    ReportGridInfo actualCloneResult =
        reportGridService.clone(
            1L,
            ImmutableReportGridUpdateCommand.builder()
                .description("The characteristics of someone or something")
                .kind(ReportGridKind.PUBLIC)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(reportGridDao).create(isA(ReportGridCreateCommand.class), eq("janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridDao)
        .updateColumnDefinitions(eq(1L), isA(ReportGridColumnDefinitionsUpdateCommand.class));
    verify(reportGridMemberService).register(1L, "janedoe", ReportGridMemberRole.OWNER);
    assertTrue(actualCloneResult instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualCloneResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCloneResult.lastUpdatedBy());
    assertEquals("Name", actualCloneResult.name());
    assertEquals("Provenance", actualCloneResult.provenance());
    assertEquals("The characteristics of someone or something", actualCloneResult.description());
    assertEquals(1L, actualCloneResult.gridId());
    assertEquals(EntityKind.ALL, actualCloneResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCloneResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)} with {@code long},
   * {@code ReportGridUpdateCommand}, {@code String}.
   *
   * <ul>
   *   <li>Then calls {@link ReportGridMemberDao#register(long, String, ReportGridMemberRole)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, ReportGridUpdateCommand, String) with 'long', 'ReportGridUpdateCommand', 'String'; then calls register(long, String, ReportGridMemberRole)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.clone(long, ReportGridUpdateCommand, String)"
  })
  void testCloneWithLongReportGridUpdateCommandString_thenCallsRegister() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    doNothing()
        .when(reportGridDao)
        .updateColumnDefinitions(
            anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    // Act
    ReportGridInfo actualCloneResult =
        reportGridService.clone(
            1L,
            ImmutableReportGridUpdateCommand.builder()
                .description("The characteristics of someone or something")
                .kind(ReportGridKind.PUBLIC)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(reportGridDao).create(isA(ReportGridCreateCommand.class), eq("janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridDao)
        .updateColumnDefinitions(eq(1L), isA(ReportGridColumnDefinitionsUpdateCommand.class));
    verify(reportGridMemberDao).register(1L, "janedoe", ReportGridMemberRole.OWNER);
    assertTrue(actualCloneResult instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualCloneResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCloneResult.lastUpdatedBy());
    assertEquals("Name", actualCloneResult.name());
    assertEquals("Provenance", actualCloneResult.provenance());
    assertEquals("The characteristics of someone or something", actualCloneResult.description());
    assertEquals(1L, actualCloneResult.gridId());
    assertEquals(EntityKind.ALL, actualCloneResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCloneResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)} with {@code long},
   * {@code ReportGridUpdateCommand}, {@code String}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableReportGridInfo}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, ReportGridUpdateCommand, String) with 'long', 'ReportGridUpdateCommand', 'String'; then return ImmutableReportGridInfo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridInfo ReportGridService.clone(long, ReportGridUpdateCommand, String)"
  })
  void testCloneWithLongReportGridUpdateCommandString_thenReturnImmutableReportGridInfo() {
    // Arrange
    doNothing()
        .when(reportGridDao)
        .updateColumnDefinitions(
            anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridInfoById(anyLong()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    when(reportGridMemberService.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);

    // Act
    ReportGridInfo actualCloneResult =
        reportGridService.clone(
            1L,
            ImmutableReportGridUpdateCommand.builder()
                .description("The characteristics of someone or something")
                .kind(ReportGridKind.PUBLIC)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(reportGridDao).create(isA(ReportGridCreateCommand.class), eq("janedoe"));
    verify(reportGridDao).getGridDefinitionById(1L);
    verify(reportGridDao).getGridInfoById(1L);
    verify(reportGridDao)
        .updateColumnDefinitions(eq(1L), isA(ReportGridColumnDefinitionsUpdateCommand.class));
    verify(reportGridMemberService).register(1L, "janedoe", ReportGridMemberRole.OWNER);
    assertTrue(actualCloneResult instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualCloneResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCloneResult.lastUpdatedBy());
    assertEquals("Name", actualCloneResult.name());
    assertEquals("Provenance", actualCloneResult.provenance());
    assertEquals("The characteristics of someone or something", actualCloneResult.description());
    assertEquals(1L, actualCloneResult.gridId());
    assertEquals(EntityKind.ALL, actualCloneResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCloneResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }
}
