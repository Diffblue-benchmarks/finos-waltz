package org.finos.waltz.service.usage_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.data_type_usage.DataTypeUsageDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.data_type_usage.DataTypeUsage;
import org.finos.waltz.model.data_type_usage.ImmutableDataTypeUsage;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.system.ImmutableSystemChangeSet;
import org.finos.waltz.model.system.SystemChangeSet;
import org.finos.waltz.model.usage_info.ImmutableUsageInfo;
import org.finos.waltz.model.usage_info.UsageInfo;
import org.finos.waltz.model.usage_info.UsageKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
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
class DataTypeUsageServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private DataTypeDao dataTypeDao;

  @Mock private DataTypeUsageDao dataTypeUsageDao;

  @InjectMocks private DataTypeUsageService dataTypeUsageService;

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForAppIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector() {
    // Arrange
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(null, options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(isNull(), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForAppIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector2() {
    // Arrange
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(null, options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(isNull(), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForAppIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector3() {
    // Arrange
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(null, options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(isNull(), isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForAppIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector4() {
    // Arrange
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(null, options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(isNull(), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForAppIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector5() {
    // Arrange
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.CHANGE_INITIATIVE)
                .name("Name")
                .build());

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(EntityKind.ALL, options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForAppIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector6() {
    // Arrange
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(
            EntityKind.ALL,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForAppIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector7() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
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

    DataTypeUsageService dataTypeUsageService =
        new DataTypeUsageService(dataTypeUsageDao, dataTypeDao, changeLogService);

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
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(
            EntityKind.ALL,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForAppIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector8() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
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

    DataTypeUsageService dataTypeUsageService =
        new DataTypeUsageService(dataTypeUsageDao, dataTypeDao, changeLogService);

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
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(
            EntityKind.ALL,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForAppIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector9() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
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

    DataTypeUsageService dataTypeUsageService =
        new DataTypeUsageService(dataTypeUsageDao, dataTypeDao, changeLogService);

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
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(
            EntityKind.ALL,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findForAppIdSelector(EntityKind, IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(null, options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(isNull(), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findForAppIdSelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector_givenHashSetAddActive() {
    // Arrange
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(null, options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(isNull(), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findForAppIdSelector(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector_givenHashSetAddPending() {
    // Arrange
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(null, options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(isNull(), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#findForAppIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findForAppIdSelector(EntityKind, IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeUsageService.findForAppIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindForAppIdSelector_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.findForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
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

    DataTypeUsageService dataTypeUsageService =
        new DataTypeUsageService(dataTypeUsageDao, dataTypeDao, changeLogService);

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
    List<DataTypeUsage> actualFindForAppIdSelectorResult =
        dataTypeUsageService.findForAppIdSelector(
            EntityKind.ALL,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageService.findForEntity(EntityReference)"})
  void testFindForEntity() {
    // Arrange
    when(dataTypeUsageDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DataTypeUsage> actualFindForEntityResult = dataTypeUsageService.findForEntity(null);

    // Assert
    verify(dataTypeUsageDao).findForEntity(isNull());
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#findForEntityAndDataType(EntityReference, Long)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#findForEntityAndDataType(EntityReference,
   * Long)}
   */
  @Test
  @DisplayName("Test findForEntityAndDataType(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageService.findForEntityAndDataType(EntityReference, Long)"})
  void testFindForEntityAndDataType() {
    // Arrange
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DataTypeUsage> actualFindForEntityAndDataTypeResult =
        dataTypeUsageService.findForEntityAndDataType(null, 1L);

    // Assert
    verify(dataTypeUsageDao).findForEntityAndDataType(isNull(), eq(1L));
    assertTrue(actualFindForEntityAndDataTypeResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageService#save(EntityReference, Long, List, String)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  @DisplayName("Test save(EntityReference, Long, List, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemChangeSet DataTypeUsageService.save(EntityReference, Long, List, String)"
  })
  void testSave() {
    // Arrange
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();

    ImmutableDataTypeUsage.Builder dataTypeIdResult =
        ImmutableDataTypeUsage.builder().dataTypeId(1L);

    ImmutableDataTypeUsage.Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    dataTypeUsageList.add(
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build());
    when(dataTypeUsageDao.deleteUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageKind>>any()))
        .thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(dataTypeUsageList);
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult =
        dataTypeUsageService.save(null, 1L, new ArrayList<>(), "42");

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(dataTypeUsageDao).deleteUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isNull(), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isNull(), eq(1L), isA(List.class));
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualSaveResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualSaveResult.inserts());
    assertSame(deletesResult, actualSaveResult.updates());
  }

  /**
   * Test {@link DataTypeUsageService#save(EntityReference, Long, List, String)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  @DisplayName("Test save(EntityReference, Long, List, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemChangeSet DataTypeUsageService.save(EntityReference, Long, List, String)"
  })
  void testSave2() {
    // Arrange
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();

    ImmutableDataTypeUsage.Builder dataTypeIdResult =
        ImmutableDataTypeUsage.builder().dataTypeId(1L);

    ImmutableDataTypeUsage.Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    dataTypeUsageList.add(
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build());

    ImmutableDataTypeUsage.Builder dataTypeIdResult2 =
        ImmutableDataTypeUsage.builder().dataTypeId(1L);

    ImmutableDataTypeUsage.Builder provenanceResult2 =
        dataTypeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    dataTypeUsageList.add(
        provenanceResult2
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build());
    when(dataTypeUsageDao.deleteUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageKind>>any()))
        .thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(dataTypeUsageList);
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult =
        dataTypeUsageService.save(null, 1L, new ArrayList<>(), "42");

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(dataTypeUsageDao).deleteUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isNull(), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isNull(), eq(1L), isA(List.class));
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualSaveResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualSaveResult.inserts());
    assertSame(deletesResult, actualSaveResult.updates());
  }

  /**
   * Test {@link DataTypeUsageService#save(EntityReference, Long, List, String)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  @DisplayName("Test save(EntityReference, Long, List, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemChangeSet DataTypeUsageService.save(EntityReference, Long, List, String)"
  })
  void testSave3() {
    // Arrange
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();

    ImmutableDataTypeUsage.Builder dataTypeIdResult =
        ImmutableDataTypeUsage.builder().dataTypeId(1L);

    ImmutableDataTypeUsage.Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    dataTypeUsageList.add(
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build());
    when(dataTypeUsageDao.deleteUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageKind>>any()))
        .thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(dataTypeUsageList);
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    ArrayList<UsageInfo> usages = new ArrayList<>();
    usages.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult =
        dataTypeUsageService.save(null, 1L, usages, "42");

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(dataTypeUsageDao).deleteUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isNull(), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isNull(), eq(1L), isA(List.class));
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualSaveResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualSaveResult.inserts());
    assertSame(deletesResult, actualSaveResult.updates());
  }

  /**
   * Test {@link DataTypeUsageService#save(EntityReference, Long, List, String)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  @DisplayName("Test save(EntityReference, Long, List, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemChangeSet DataTypeUsageService.save(EntityReference, Long, List, String)"
  })
  void testSave4() {
    // Arrange
    when(dataTypeUsageDao.deleteUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageKind>>any()))
        .thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<UsageInfo> usages = new ArrayList<>();
    usages.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.MODIFIER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult =
        dataTypeUsageService.save(entityReference, 1L, usages, "42");

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(dataTypeUsageDao).deleteUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isA(EntityReference.class), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    assertEquals(usages, actualSaveResult.inserts());
  }

  /**
   * Test {@link DataTypeUsageService#save(EntityReference, Long, List, String)}.
   *
   * <ul>
   *   <li>Given builder description empty string Selected is {@code true} kind {@code CONSUMER}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, Long, List, String); given builder description empty string Selected is 'true' kind 'CONSUMER' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemChangeSet DataTypeUsageService.save(EntityReference, Long, List, String)"
  })
  void testSave_givenBuilderDescriptionEmptyStringSelectedIsTrueKindConsumerBuild() {
    // Arrange
    when(dataTypeUsageDao.deleteUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageKind>>any()))
        .thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<UsageInfo> usages = new ArrayList<>();
    usages.add(
        ImmutableUsageInfo.builder()
            .description("")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult =
        dataTypeUsageService.save(entityReference, 1L, usages, "42");

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(dataTypeUsageDao).deleteUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isA(EntityReference.class), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    assertEquals(usages, actualSaveResult.inserts());
  }

  /**
   * Test {@link DataTypeUsageService#save(EntityReference, Long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, Long, List, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemChangeSet DataTypeUsageService.save(EntityReference, Long, List, String)"
  })
  void testSave_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.deleteUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageKind>>any()))
        .thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    DataTypeUsageService dataTypeUsageService =
        new DataTypeUsageService(dataTypeUsageDao, dataTypeDao, changeLogService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<UsageInfo> usages = new ArrayList<>();
    usages.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult =
        dataTypeUsageService.save(entityReference, 1L, usages, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dataTypeDao).getById(1L);
    verify(dataTypeUsageDao).deleteUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isA(EntityReference.class), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    assertEquals(usages, actualSaveResult.inserts());
  }

  /**
   * Test {@link DataTypeUsageService#save(EntityReference, Long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, Long, List, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemChangeSet DataTypeUsageService.save(EntityReference, Long, List, String)"
  })
  void testSave_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(dataTypeUsageDao.deleteUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageKind>>any()))
        .thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<UsageInfo> usages = new ArrayList<>();
    usages.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult =
        dataTypeUsageService.save(entityReference, 1L, usages, "42");

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(dataTypeUsageDao).deleteUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isA(EntityReference.class), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isA(EntityReference.class), eq(1L), isA(List.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    assertEquals(usages, actualSaveResult.inserts());
  }

  /**
   * Test {@link DataTypeUsageService#save(EntityReference, Long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return deletes Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, Long, List, String); given ChangeLogService; when ArrayList(); then return deletes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemChangeSet DataTypeUsageService.save(EntityReference, Long, List, String)"
  })
  void testSave_givenChangeLogService_whenArrayList_thenReturnDeletesEmpty() {
    // Arrange
    when(dataTypeUsageDao.deleteUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageKind>>any()))
        .thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult =
        dataTypeUsageService.save(null, 1L, new ArrayList<>(), "42");

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(dataTypeUsageDao).deleteUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isNull(), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isNull(), eq(1L), isA(List.class));
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualSaveResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualSaveResult.inserts());
    assertSame(deletesResult, actualSaveResult.updates());
  }

  /**
   * Test {@link DataTypeUsageService#save(EntityReference, Long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService}.
   *   <li>When {@code null}.
   *   <li>Then return deletes Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, Long, List, String); given ChangeLogService; when 'null'; then return deletes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemChangeSet DataTypeUsageService.save(EntityReference, Long, List, String)"
  })
  void testSave_givenChangeLogService_whenNull_thenReturnDeletesEmpty() {
    // Arrange
    when(dataTypeUsageDao.deleteUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageKind>>any()))
        .thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(
            Mockito.<EntityReference>any(), Mockito.<Long>any(), Mockito.<List<UsageInfo>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult =
        dataTypeUsageService.save(null, 1L, null, "42");

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(dataTypeUsageDao).deleteUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isNull(), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isNull(), eq(1L), isA(List.class));
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualSaveResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualSaveResult.inserts());
    assertSame(deletesResult, actualSaveResult.updates());
  }

  /**
   * Test {@link DataTypeUsageService#recalculateForAllApplications()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#recalculateForAllApplications()}
   */
  @Test
  @DisplayName("Test recalculateForAllApplications(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageService.recalculateForAllApplications()"})
  void testRecalculateForAllApplications_thenReturnFalse() {
    // Arrange
    when(dataTypeUsageDao.recalculateForAllApplications()).thenReturn(false);

    // Act
    boolean actualRecalculateForAllApplicationsResult =
        dataTypeUsageService.recalculateForAllApplications();

    // Assert
    verify(dataTypeUsageDao).recalculateForAllApplications();
    assertFalse(actualRecalculateForAllApplicationsResult);
  }

  /**
   * Test {@link DataTypeUsageService#recalculateForAllApplications()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#recalculateForAllApplications()}
   */
  @Test
  @DisplayName("Test recalculateForAllApplications(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageService.recalculateForAllApplications()"})
  void testRecalculateForAllApplications_thenReturnTrue() {
    // Arrange
    when(dataTypeUsageDao.recalculateForAllApplications()).thenReturn(true);

    // Act
    boolean actualRecalculateForAllApplicationsResult =
        dataTypeUsageService.recalculateForAllApplications();

    // Assert
    verify(dataTypeUsageDao).recalculateForAllApplications();
    assertTrue(actualRecalculateForAllApplicationsResult);
  }

  /**
   * Test {@link DataTypeUsageService#recalculateForApplications(Collection)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  @DisplayName("Test recalculateForApplications(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageService.recalculateForApplications(Collection)"})
  void testRecalculateForApplications() {
    // Arrange
    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act and Assert
    assertTrue(dataTypeUsageService.recalculateForApplications(refs));
  }

  /**
   * Test {@link DataTypeUsageService#recalculateForApplications(Collection)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  @DisplayName("Test recalculateForApplications(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageService.recalculateForApplications(Collection)"})
  void testRecalculateForApplications2() {
    // Arrange
    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act and Assert
    assertTrue(dataTypeUsageService.recalculateForApplications(refs));
  }

  /**
   * Test {@link DataTypeUsageService#recalculateForApplications(Collection)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  @DisplayName("Test recalculateForApplications(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageService.recalculateForApplications(Collection)"})
  void testRecalculateForApplications3() {
    // Arrange
    when(dataTypeUsageDao.recalculateForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(true);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build());

    // Act
    boolean actualRecalculateForApplicationsResult =
        dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(dataTypeUsageDao, atLeast(1))
        .recalculateForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any());
    assertTrue(actualRecalculateForApplicationsResult);
  }

  /**
   * Test {@link DataTypeUsageService#recalculateForApplications(Collection)}.
   *
   * <p>Method under test: {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  @DisplayName("Test recalculateForApplications(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageService.recalculateForApplications(Collection)"})
  void testRecalculateForApplications4() {
    // Arrange
    when(dataTypeUsageDao.recalculateForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(true);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.APPLICATION)
            .name("Name")
            .build());

    // Act
    boolean actualRecalculateForApplicationsResult =
        dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(dataTypeUsageDao, atLeast(1))
        .recalculateForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any());
    assertTrue(actualRecalculateForApplicationsResult);
  }

  /**
   * Test {@link DataTypeUsageService#recalculateForApplications(Collection)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeUsageDao}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  @DisplayName(
      "Test recalculateForApplications(Collection); given DataTypeUsageDao; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageService.recalculateForApplications(Collection)"})
  void testRecalculateForApplications_givenDataTypeUsageDao_whenArrayList() {
    // Arrange, Act and Assert
    assertTrue(dataTypeUsageService.recalculateForApplications(new ArrayList<>()));
  }

  /**
   * Test {@link DataTypeUsageService#recalculateForApplications(Collection)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  @DisplayName("Test recalculateForApplications(Collection); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageService.recalculateForApplications(Collection)"})
  void testRecalculateForApplications_thenReturnFalse() {
    // Arrange
    when(dataTypeUsageDao.recalculateForIdSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(false);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build());

    // Act
    boolean actualRecalculateForApplicationsResult =
        dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(dataTypeUsageDao)
        .recalculateForIdSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    assertFalse(actualRecalculateForApplicationsResult);
  }
}
