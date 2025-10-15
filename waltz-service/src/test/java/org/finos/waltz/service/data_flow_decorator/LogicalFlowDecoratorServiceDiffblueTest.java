package org.finos.waltz.service.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.data_flow_decorator.LogicalFlowDecoratorSummaryDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.logical_flow.LogicalFlowStatsDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.data_flow_decorator.DataTypeDirectionKey;
import org.finos.waltz.model.data_flow_decorator.DecoratorRatingSummary;
import org.finos.waltz.model.data_flow_decorator.ImmutableDataTypeDirectionKey;
import org.finos.waltz.model.data_flow_decorator.ImmutableUpdateDataFlowDecoratorsAction;
import org.finos.waltz.model.data_flow_decorator.LogicalFlowDecoratorStat;
import org.finos.waltz.model.data_flow_decorator.UpdateDataFlowDecoratorsAction;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.usage_info.DataTypeUsageService;
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
class LogicalFlowDecoratorServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private DataTypeDao dataTypeDao;

  @Mock private DataTypeUsageService dataTypeUsageService;

  @Mock private LogicalFlowDao logicalFlowDao;

  @Mock private LogicalFlowDecoratorDao logicalFlowDecoratorDao;

  @Mock private LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator;

  @InjectMocks private LogicalFlowDecoratorService logicalFlowDecoratorService;

  @Mock private LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao;

  @Mock private LogicalFlowService logicalFlowService;

  @Mock private LogicalFlowStatsDao logicalFlowStatsDao;

  /**
   * Test {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeDao}.
   *   <li>Then return array of {@code int} with two and one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}
   */
  @Test
  @DisplayName(
      "Test addDecoratorsBatch(List, String); given DataTypeDao; then return array of int with two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorService.addDecoratorsBatch(List, String)"})
  void testAddDecoratorsBatch_givenDataTypeDao_thenReturnArrayOfIntWithTwoAndOne() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ArrayList<UpdateDataFlowDecoratorsAction> actions = new ArrayList<>();
    actions.add(ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build());

    // Act
    int[] actualAddDecoratorsBatchResult =
        logicalFlowDecoratorService.addDecoratorsBatch(actions, "janedoe");

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsBatchResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeDao}.
   *   <li>Then return array of {@code int} with two and one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}
   */
  @Test
  @DisplayName(
      "Test addDecoratorsBatch(List, String); given DataTypeDao; then return array of int with two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorService.addDecoratorsBatch(List, String)"})
  void testAddDecoratorsBatch_givenDataTypeDao_thenReturnArrayOfIntWithTwoAndOne2() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);

    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    logicalFlowList.add(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ArrayList<UpdateDataFlowDecoratorsAction> actions = new ArrayList<>();
    actions.add(ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build());

    // Act
    int[] actualAddDecoratorsBatchResult =
        logicalFlowDecoratorService.addDecoratorsBatch(actions, "janedoe");

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsBatchResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeDao}.
   *   <li>Then return array of {@code int} with two and one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}
   */
  @Test
  @DisplayName(
      "Test addDecoratorsBatch(List, String); given DataTypeDao; then return array of int with two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorService.addDecoratorsBatch(List, String)"})
  void testAddDecoratorsBatch_givenDataTypeDao_thenReturnArrayOfIntWithTwoAndOne3() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);

    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    logicalFlowList.add(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created2)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult2 =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    logicalFlowList.add(
        sourceResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ArrayList<UpdateDataFlowDecoratorsAction> actions = new ArrayList<>();
    actions.add(ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build());

    // Act
    int[] actualAddDecoratorsBatchResult =
        logicalFlowDecoratorService.addDecoratorsBatch(actions, "janedoe");

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsBatchResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeDao}.
   *   <li>Then return array of {@code int} with two and one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}
   */
  @Test
  @DisplayName(
      "Test addDecoratorsBatch(List, String); given DataTypeDao; then return array of int with two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorService.addDecoratorsBatch(List, String)"})
  void testAddDecoratorsBatch_givenDataTypeDao_thenReturnArrayOfIntWithTwoAndOne4() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ArrayList<UpdateDataFlowDecoratorsAction> actions = new ArrayList<>();
    actions.add(ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build());
    actions.add(ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build());

    // Act
    int[] actualAddDecoratorsBatchResult =
        logicalFlowDecoratorService.addDecoratorsBatch(actions, "janedoe");

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsBatchResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DataTypeDao#findByIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}
   */
  @Test
  @DisplayName("Test addDecoratorsBatch(List, String); then calls findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorService.addDecoratorsBatch(List, String)"})
  void testAddDecoratorsBatch_thenCallsFindByIds() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    logicalFlowList.add(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult2 =
        ImmutableUpdateDataFlowDecoratorsAction.builder();
    builderResult2.addAddedDecorators(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        builderResult2.flowId(1L).build();

    ArrayList<UpdateDataFlowDecoratorsAction> actions = new ArrayList<>();
    actions.add(immutableUpdateDataFlowDecoratorsAction);

    // Act
    int[] actualAddDecoratorsBatchResult =
        logicalFlowDecoratorService.addDecoratorsBatch(actions, "janedoe");

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsBatchResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DataTypeDao#findByIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}
   */
  @Test
  @DisplayName("Test addDecoratorsBatch(List, String); then calls findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorService.addDecoratorsBatch(List, String)"})
  void testAddDecoratorsBatch_thenCallsFindByIds2() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(dataTypeList);

    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    logicalFlowList.add(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult2 =
        ImmutableUpdateDataFlowDecoratorsAction.builder();
    builderResult2.addAddedDecorators(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        builderResult2.flowId(1L).build();

    ArrayList<UpdateDataFlowDecoratorsAction> actions = new ArrayList<>();
    actions.add(immutableUpdateDataFlowDecoratorsAction);

    // Act
    int[] actualAddDecoratorsBatchResult =
        logicalFlowDecoratorService.addDecoratorsBatch(actions, "janedoe");

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsBatchResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DataTypeDao#findByIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}
   */
  @Test
  @DisplayName("Test addDecoratorsBatch(List, String); then calls findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorService.addDecoratorsBatch(List, String)"})
  void testAddDecoratorsBatch_thenCallsFindByIds3() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(dataTypeList);

    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    logicalFlowList.add(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult2 =
        ImmutableUpdateDataFlowDecoratorsAction.builder();
    builderResult2.addAddedDecorators(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        builderResult2.flowId(1L).build();

    ArrayList<UpdateDataFlowDecoratorsAction> actions = new ArrayList<>();
    actions.add(immutableUpdateDataFlowDecoratorsAction);

    // Act
    int[] actualAddDecoratorsBatchResult =
        logicalFlowDecoratorService.addDecoratorsBatch(actions, "janedoe");

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsBatchResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}
   */
  @Test
  @DisplayName("Test addDecoratorsBatch(List, String); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorService.addDecoratorsBatch(List, String)"})
  void testAddDecoratorsBatch_thenReturnEmptyArrayOfInt() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {}, logicalFlowDecoratorService.addDecoratorsBatch(new ArrayList<>(), "janedoe"));
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector2() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector3() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector4() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector5() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector6() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector7() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector8() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector_givenActive() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test summarizeInboundForSelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector_givenInHouse() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeInboundForSelector(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeInboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeInboundForSelector_givenPending() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult =
        logicalFlowDecoratorService.summarizeInboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector2() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector3() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector4() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector5() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector6() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector7() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector8() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector_givenActive() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test summarizeOutboundForSelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
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
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector_givenInHouse() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test summarizeOutboundForSelector(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorService.summarizeOutboundForSelector(IdSelectionOptions)"
  })
  void testSummarizeOutboundForSelector_givenPending() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult =
        logicalFlowDecoratorService.summarizeOutboundForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#summarizeForAll()}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorService#summarizeForAll()}
   */
  @Test
  @DisplayName("Test summarizeForAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDecoratorService.summarizeForAll()"})
  void testSummarizeForAll() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.summarizeForAll()).thenReturn(new ArrayList<>());

    // Act
    List<DecoratorRatingSummary> actualSummarizeForAllResult =
        logicalFlowDecoratorService.summarizeForAll();

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeForAll();
    assertTrue(actualSummarizeForAllResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity2() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity3() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity4() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity5() {
    // Arrange
    HashMap<DataTypeDirectionKey, List<Long>> dataTypeDirectionKeyListMap = new HashMap<>();
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();
    dataTypeDirectionKeyListMap.put(immutableDataTypeDirectionKey, new ArrayList<>());
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeDirectionKeyListMap);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity6() {
    // Arrange
    HashMap<DataTypeDirectionKey, List<Long>> dataTypeDirectionKeyListMap = new HashMap<>();
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();
    dataTypeDirectionKeyListMap.put(immutableDataTypeDirectionKey, new ArrayList<>());
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeDirectionKeyListMap);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity7() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(3L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity_givenActive() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findFlowsByDatatypeForEntity(IdSelectionOptions); given ArrayList() add one; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity_givenArrayListAddOne_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);

    HashMap<DataTypeDirectionKey, List<Long>> dataTypeDirectionKeyListMap = new HashMap<>();
    dataTypeDirectionKeyListMap.put(
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build(),
        resultLongList);
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeDirectionKeyListMap);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertEquals(1, actualFindFlowsByDatatypeForEntityResult.size());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findFlowsByDatatypeForEntity(IdSelectionOptions); given ArrayList() add one; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity_givenArrayListAddOne_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);

    HashMap<DataTypeDirectionKey, List<Long>> dataTypeDirectionKeyListMap = new HashMap<>();
    dataTypeDirectionKeyListMap.put(
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build(),
        resultLongList);
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeDirectionKeyListMap);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertEquals(1, actualFindFlowsByDatatypeForEntityResult.size());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity_givenInHouse() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity_givenPending() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findFlowsByDatatypeForEntity(IdSelectionOptions); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowDecoratorService.findFlowsByDatatypeForEntity(IdSelectionOptions)"
  })
  void testFindFlowsByDatatypeForEntity_thenReturnEmpty() {
    // Arrange
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

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
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult =
        logicalFlowDecoratorService.findFlowsByDatatypeForEntity(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }
}
