package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
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
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.data_type.search.DataTypeSearchDao;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.entity_hierarchy.EntityHierarchyDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
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
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator.Builder;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchyItem;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchyItem;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorRatingsCalculator;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.tag.TagService;
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
class FlowClassificationCalculatorDiffblueTest {
  @Mock private DataTypeDao dataTypeDao;

  @Mock private EntityHierarchyDao entityHierarchyDao;

  @InjectMocks private FlowClassificationCalculator flowClassificationCalculator;

  @Mock private LogicalFlowDecoratorDao logicalFlowDecoratorDao;

  @Mock private LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator;

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef() {
    // Arrange
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

    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(entityHierarchyItemList);

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(mock(TagDao.class), null);

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

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef2() {
    // Arrange
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

    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    entityHierarchyItemList.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(entityHierarchyItemList);

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(mock(TagDao.class), null);

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

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef3() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

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

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    TagService tagService = new TagService(mock(TagDao.class), null);

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

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef4() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

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

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef5() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

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

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef6() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(mock(TagDao.class), null);

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

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef7() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(mock(TagDao.class), null);

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

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef8() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new ArrayList<>());

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(ratingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef9() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(ratingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef10() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

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
    dataTypeDecoratorList.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(ratingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef11() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    Optional<? extends AuthoritativenessRatingValue> rating = Optional.empty();

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(ratingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef12() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating = Optional.empty();
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(ratingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef13() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(ratingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef14() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(ratingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef15() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(ratingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef16() {
    // Arrange
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
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(-2L)
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
    dataTypeDecoratorList.add(ratingResult2.targetInboundRating(targetInboundRating2).build());
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef17() {
    // Arrange
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
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

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
                    .id(-2L)
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
    dataTypeDecoratorList.add(ratingResult2.targetInboundRating(targetInboundRating2).build());
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef18() {
    // Arrange
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
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

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
            .flowClassificationRuleId(-2L)
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
    dataTypeDecoratorList.add(ratingResult2.targetInboundRating(targetInboundRating2).build());
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef19() {
    // Arrange
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
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

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
            .id(-2L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorList.add(ratingResult2.targetInboundRating(targetInboundRating2).build());
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef20() {
    // Arrange
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
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

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
            .inboundFlowClassificationRuleId(-2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorList.add(ratingResult2.targetInboundRating(targetInboundRating2).build());
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(logicalFlowDecoratorDao.updateDecorators(Mockito.<Set<DataTypeDecorator>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDecoratorDao).updateDecorators(isA(Set.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName("Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef21() {
    // Arrange
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

    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(entityHierarchyItemList);

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(dataTypeDecoratorList);

    ArrayList<DataTypeDecorator> dataTypeDecoratorList2 = new ArrayList<>();

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
    dataTypeDecoratorList2.add(ratingResult2.targetInboundRating(targetInboundRating2).build());
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList2);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(logicalFlowDecoratorRatingsCalculator).calculate(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationDao#findByIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'; then calls findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef_thenCallsFindByIds() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(mock(TagDao.class), null);

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

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationDao#findByIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'; then calls findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef_thenCallsFindByIds2() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(mock(TagDao.class), null);

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

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationDao#findByIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'; then calls findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef_thenCallsFindByIds3() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(mock(TagDao.class), null);

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

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

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
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

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
    dataTypeDecoratorList.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationCalculator#update(Long, EntityReference)} with {@code
   * dataTypeId}, {@code vantageRef}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationService#findByIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test update(Long, EntityReference) with 'dataTypeId', 'vantageRef'; then calls findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowClassificationCalculator.update(Long, EntityReference)"})
  void testUpdateWithDataTypeIdVantageRef_thenCallsFindByIds4() {
    // Arrange
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

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

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

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao, logicalFlowDao, dataTypeService);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    FlowClassificationCalculator flowClassificationCalculator =
        new FlowClassificationCalculator(
            dataTypeDao, entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);

    // Act
    int[] actualUpdateResult =
        flowClassificationCalculator.update(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).getById(1L);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isA(EntityReference.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findExpandedFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(applicationService, atLeast(1)).findByIds(isA(Collection.class));
    assertArrayEquals(new int[] {}, actualUpdateResult);
  }
}
