package org.finos.waltz.service.data_flow_decorator;

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
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.data_type.search.DataTypeSearchDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator.Builder;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.tag.TagService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LogicalFlowDecoratorRatingsCalculatorDiffblueTest {
  @Mock private ApplicationService applicationService;

  @Mock private DataTypeService dataTypeService;

  @Mock private FlowClassificationRuleDao flowClassificationRuleDao;

  @Mock private LogicalFlowDao logicalFlowDao;

  @InjectMocks private LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator;

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators() {
    // Arrange
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
    when(applicationService.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators2() {
    // Arrange
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
    when(applicationService.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators3() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList =
        new ArrayList<>();

    ImmutableFlowClassificationRuleVantagePoint.Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    ImmutableFlowClassificationRuleVantagePoint.Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleVantagePointList.add(
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators4() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList =
        new ArrayList<>();

    ImmutableFlowClassificationRuleVantagePoint.Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    ImmutableFlowClassificationRuleVantagePoint.Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleVantagePointList.add(
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());

    ImmutableFlowClassificationRuleVantagePoint.Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    ImmutableFlowClassificationRuleVantagePoint.Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleVantagePointList.add(
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators5() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators6() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators7() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(decorators);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators8() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(decorators);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators9() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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
                .id(2L)
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

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators10() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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
                .id(-2L)
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

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators11() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult2.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    Builder builderResult3 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult3.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(-2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult3 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult3.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(decorators);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertEquals(2, actualCalculateResult.size());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators12() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult2.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    Builder builderResult3 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult3.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult3 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(-2L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult3.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(decorators);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertEquals(2, actualCalculateResult.size());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators13() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult2.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    Builder builderResult3 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult3.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult3 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(-2L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult3.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(decorators);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertEquals(2, actualCalculateResult.size());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators14() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult2.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    Builder builderResult3 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult3.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult3 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(-2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult3.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(decorators);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertEquals(2, actualCalculateResult.size());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationDao#findByIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'; then calls findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators_thenCallsFindByIds() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators_thenReturnSizeIsOne() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult2.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(decorators);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertEquals(1, actualCalculateResult.size());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators_thenReturnSizeIsOne2() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());

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

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult2.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    Builder builderResult3 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult3.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult3 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult3.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(decorators);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertEquals(1, actualCalculateResult.size());
  }

  /**
   * Test {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)} with {@code
   * decorators}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  @DisplayName("Test calculate(Collection) with 'decorators'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowDecoratorRatingsCalculator.calculate(Collection)"})
  void testCalculateWithDecorators_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<DataTypeDecorator> actualCalculateResult =
        logicalFlowDecoratorRatingsCalculator.calculate(new ArrayList<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }
}
