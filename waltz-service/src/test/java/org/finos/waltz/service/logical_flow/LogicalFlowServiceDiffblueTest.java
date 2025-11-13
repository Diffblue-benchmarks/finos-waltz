package org.finos.waltz.service.logical_flow;

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
import static org.mockito.Mockito.doThrow;
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
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.datatype_decorator.PhysicalSpecDecoratorDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.logical_flow.LogicalFlowStatsDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.model.logical_flow.AddLogicalFlowCommand;
import org.finos.waltz.model.logical_flow.FlowInfo;
import org.finos.waltz.model.logical_flow.ImmutableAddLogicalFlowCommand;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow.Builder;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowGraphSummary;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowView;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.logical_flow.LogicalFlowGraphSummary;
import org.finos.waltz.model.logical_flow.LogicalFlowView;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.permission.permission_checker.FlowPermissionChecker;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.usage_info.DataTypeUsageService;
import org.jooq.Record1;
import org.jooq.Select;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LogicalFlowServiceDiffblueTest {
  @Mock private AssessmentDefinitionService assessmentDefinitionService;

  @Mock private AssessmentRatingService assessmentRatingService;

  @Mock private ChangeLogService changeLogService;

  @Mock private DBExecutorPoolInterface dBExecutorPoolInterface;

  @Mock private DataTypeService dataTypeService;

  @Mock private DataTypeUsageService dataTypeUsageService;

  @Mock private FlowPermissionChecker flowPermissionChecker;

  @Mock private LogicalFlowDao logicalFlowDao;

  @Mock private LogicalFlowDecoratorDao logicalFlowDecoratorDao;

  @InjectMocks private LogicalFlowService logicalFlowService;

  @Mock private LogicalFlowStatsDao logicalFlowStatsDao;

  @Mock private PhysicalFlowDao physicalFlowDao;

  @Mock private PhysicalSpecDecoratorDao physicalSpecDecoratorDao;

  @Mock private PhysicalSpecificationDao physicalSpecificationDao;

  @Mock private RatingSchemeService ratingSchemeService;

  /**
   * Test {@link LogicalFlowService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<LogicalFlow> actualFindByEntityReferenceResult =
        logicalFlowService.findByEntityReference(null);

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.findByEntityReference(null));
    verify(logicalFlowDao).findByEntityReference(isNull());
  }

  /**
   * Test {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}.
   *
   * <p>Method under test: {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}
   */
  @Test
  @DisplayName("Test findBySourceAndTargetEntityReferences(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySourceAndTargetEntityReferences(List)"})
  void testFindBySourceAndTargetEntityReferences() {
    // Arrange
    when(logicalFlowDao.findBySourcesAndTargets(
            Mockito.<List<Tuple2<EntityReference, EntityReference>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Tuple2<EntityReference, EntityReference>> sourceAndTargets = new ArrayList<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Tuple2<EntityReference, EntityReference> tuple2 =
        new Tuple2<>(immutableEntityReference, immutableEntityReference2);
    sourceAndTargets.add(tuple2);

    // Act
    List<LogicalFlow> actualFindBySourceAndTargetEntityReferencesResult =
        logicalFlowService.findBySourceAndTargetEntityReferences(sourceAndTargets);

    // Assert
    verify(logicalFlowDao).findBySourcesAndTargets(isA(List.class));
    assertTrue(actualFindBySourceAndTargetEntityReferencesResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}.
   *
   * <p>Method under test: {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}
   */
  @Test
  @DisplayName("Test findBySourceAndTargetEntityReferences(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySourceAndTargetEntityReferences(List)"})
  void testFindBySourceAndTargetEntityReferences2() {
    // Arrange
    when(logicalFlowDao.findBySourcesAndTargets(
            Mockito.<List<Tuple2<EntityReference, EntityReference>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Tuple2<EntityReference, EntityReference>> sourceAndTargets = new ArrayList<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Tuple2<EntityReference, EntityReference> tuple2 =
        new Tuple2<>(immutableEntityReference, immutableEntityReference2);
    sourceAndTargets.add(tuple2);
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Tuple2<EntityReference, EntityReference> tuple22 =
        new Tuple2<>(immutableEntityReference3, immutableEntityReference4);
    sourceAndTargets.add(tuple22);

    // Act
    List<LogicalFlow> actualFindBySourceAndTargetEntityReferencesResult =
        logicalFlowService.findBySourceAndTargetEntityReferences(sourceAndTargets);

    // Assert
    verify(logicalFlowDao).findBySourcesAndTargets(isA(List.class));
    assertTrue(actualFindBySourceAndTargetEntityReferencesResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}
   */
  @Test
  @DisplayName(
      "Test findBySourceAndTargetEntityReferences(List); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySourceAndTargetEntityReferences(List)"})
  void testFindBySourceAndTargetEntityReferences_thenThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.findBySourcesAndTargets(
            Mockito.<List<Tuple2<EntityReference, EntityReference>>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> logicalFlowService.findBySourceAndTargetEntityReferences(new ArrayList<>()));
    verify(logicalFlowDao).findBySourcesAndTargets(isA(List.class));
  }

  /**
   * Test {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}
   */
  @Test
  @DisplayName(
      "Test findBySourceAndTargetEntityReferences(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySourceAndTargetEntityReferences(List)"})
  void testFindBySourceAndTargetEntityReferences_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(logicalFlowDao.findBySourcesAndTargets(
            Mockito.<List<Tuple2<EntityReference, EntityReference>>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<LogicalFlow> actualFindBySourceAndTargetEntityReferencesResult =
        logicalFlowService.findBySourceAndTargetEntityReferences(new ArrayList<>());

    // Assert
    verify(logicalFlowDao).findBySourcesAndTargets(isA(List.class));
    assertTrue(actualFindBySourceAndTargetEntityReferencesResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findActiveByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findActiveByFlowIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findActiveByFlowIds(Collection); given one; when ArrayList() add one; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findActiveByFlowIds(Collection)"})
  void testFindActiveByFlowIds_givenOne_whenArrayListAddOne_thenReturnList() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Collection<LogicalFlow> actualFindActiveByFlowIdsResult =
        logicalFlowService.findActiveByFlowIds(ids);

    // Assert
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertTrue(actualFindActiveByFlowIdsResult instanceof List);
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindActiveByFlowIdsResult);
  }

  /**
   * Test {@link LogicalFlowService#findActiveByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findActiveByFlowIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findActiveByFlowIds(Collection); given zero; when ArrayList() add zero; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findActiveByFlowIds(Collection)"})
  void testFindActiveByFlowIds_givenZero_whenArrayListAddZero_thenReturnList() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Collection<LogicalFlow> actualFindActiveByFlowIdsResult =
        logicalFlowService.findActiveByFlowIds(ids);

    // Assert
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertTrue(actualFindActiveByFlowIdsResult instanceof List);
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindActiveByFlowIdsResult);
  }

  /**
   * Test {@link LogicalFlowService#findActiveByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findActiveByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findActiveByFlowIds(Collection); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findActiveByFlowIds(Collection)"})
  void testFindActiveByFlowIds_thenThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> logicalFlowService.findActiveByFlowIds(new ArrayList<>()));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowService#findActiveByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findActiveByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findActiveByFlowIds(Collection); when ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findActiveByFlowIds(Collection)"})
  void testFindActiveByFlowIds_whenArrayList_thenReturnList() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);

    // Act
    Collection<LogicalFlow> actualFindActiveByFlowIdsResult =
        logicalFlowService.findActiveByFlowIds(new ArrayList<>());

    // Assert
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertTrue(actualFindActiveByFlowIdsResult instanceof List);
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindActiveByFlowIdsResult);
  }

  /**
   * Test {@link LogicalFlowService#findAllByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findAllByFlowIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findAllByFlowIds(Collection); given one; when ArrayList() add one; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findAllByFlowIds(Collection)"})
  void testFindAllByFlowIds_givenOne_whenArrayListAddOne_thenReturnList() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Collection<LogicalFlow> actualFindAllByFlowIdsResult = logicalFlowService.findAllByFlowIds(ids);

    // Assert
    verify(logicalFlowDao).findAllByFlowIds(isA(Collection.class));
    assertTrue(actualFindAllByFlowIdsResult instanceof List);
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindAllByFlowIdsResult);
  }

  /**
   * Test {@link LogicalFlowService#findAllByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findAllByFlowIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findAllByFlowIds(Collection); given zero; when ArrayList() add zero; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findAllByFlowIds(Collection)"})
  void testFindAllByFlowIds_givenZero_whenArrayListAddZero_thenReturnList() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Collection<LogicalFlow> actualFindAllByFlowIdsResult = logicalFlowService.findAllByFlowIds(ids);

    // Assert
    verify(logicalFlowDao).findAllByFlowIds(isA(Collection.class));
    assertTrue(actualFindAllByFlowIdsResult instanceof List);
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindAllByFlowIdsResult);
  }

  /**
   * Test {@link LogicalFlowService#findAllByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findAllByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findAllByFlowIds(Collection); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findAllByFlowIds(Collection)"})
  void testFindAllByFlowIds_thenThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> logicalFlowService.findAllByFlowIds(new ArrayList<>()));
    verify(logicalFlowDao).findAllByFlowIds(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowService#findAllByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findAllByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findAllByFlowIds(Collection); when ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findAllByFlowIds(Collection)"})
  void testFindAllByFlowIds_whenArrayList_thenReturnList() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);

    // Act
    Collection<LogicalFlow> actualFindAllByFlowIdsResult =
        logicalFlowService.findAllByFlowIds(new ArrayList<>());

    // Assert
    verify(logicalFlowDao).findAllByFlowIds(isA(Collection.class));
    assertTrue(actualFindAllByFlowIdsResult instanceof List);
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindAllByFlowIdsResult);
  }

  /**
   * Test {@link LogicalFlowService#getById(long)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.getById(long)"})
  void testGetById_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act
    LogicalFlow actualById = logicalFlowService.getById(1L);

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    EntityReference sourceResult2 = actualById.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult = actualById.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableLogicalFlow);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertFalse(actualById.isReadOnly());
    assertFalse(actualById.isRemoved());
    assertEquals(sourceResult2, targetResult);
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LogicalFlowService#getById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.getById(long)"})
  void testGetById_thenThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.getByFlowId(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.getById(1L));
    verify(logicalFlowDao).getByFlowId(1L);
  }

  /**
   * Test {@link LogicalFlowService#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.getByExternalId(String)"})
  void testGetByExternalId_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowExternalId(Mockito.<String>any()))
        .thenReturn(
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

    // Act
    LogicalFlow actualByExternalId = logicalFlowService.getByExternalId("42");

    // Assert
    verify(logicalFlowDao).getByFlowExternalId("42");
    EntityReference sourceResult2 = actualByExternalId.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult = actualByExternalId.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertTrue(actualByExternalId instanceof ImmutableLogicalFlow);
    assertEquals("2020-03-01", actualByExternalId.lastUpdatedBy());
    assertEquals("Provenance", actualByExternalId.provenance());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityKind.ALL, actualByExternalId.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualByExternalId.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertFalse(actualByExternalId.isReadOnly());
    assertFalse(actualByExternalId.isRemoved());
    assertEquals(sourceResult2, targetResult);
    assertSame(ofResult, actualByExternalId.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LogicalFlowService#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.getByExternalId(String)"})
  void testGetByExternalId_thenThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.getByFlowExternalId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.getByExternalId("42"));
    verify(logicalFlowDao).getByFlowExternalId("42");
  }

  /**
   * Test {@link LogicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<LogicalFlow> actualFindBySelectorResult =
        logicalFlowService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector2() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<LogicalFlow> actualFindBySelectorResult =
        logicalFlowService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector3() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<LogicalFlow> actualFindBySelectorResult =
        logicalFlowService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector4() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<LogicalFlow> actualFindBySelectorResult =
        logicalFlowService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenActive_whenBuilderAddEntityLifecycleStatusesActive() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<LogicalFlow> actualFindBySelectorResult =
        logicalFlowService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<LogicalFlow> actualFindBySelectorResult =
        logicalFlowService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenPending_whenBuilderAddEntityLifecycleStatusesPending() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<LogicalFlow> actualFindBySelectorResult =
        logicalFlowService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  @DisplayName("Test addFlow(AddLogicalFlowCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.addFlow(AddLogicalFlowCommand, String)"})
  void testAddFlow() {
    // Arrange
    ImmutableAddLogicalFlowCommand.Builder builderResult = ImmutableAddLogicalFlowCommand.builder();

    ImmutableAddLogicalFlowCommand.Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            logicalFlowService.addFlow(
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
                    .build(),
                "janedoe"));
  }

  /**
   * Test {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  @DisplayName("Test addFlow(AddLogicalFlowCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.addFlow(AddLogicalFlowCommand, String)"})
  void testAddFlow2() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<LogicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<DataType> ofResult = Optional.of(immutableDataType);
    when(dataTypeService.getUnknownDataType()).thenReturn(ofResult);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.addFlow(Mockito.<LogicalFlow>any()))
        .thenReturn(
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
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});

    ImmutableAddLogicalFlowCommand.Builder builderResult2 =
        ImmutableAddLogicalFlowCommand.builder();

    ImmutableAddLogicalFlowCommand.Builder sourceResult2 =
        builderResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    LogicalFlow actualAddFlowResult =
        logicalFlowService.addFlow(
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
                .build(),
            "janedoe");

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).addFlow(isA(LogicalFlow.class));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(LogicalFlow.class), eq("janedoe"), eq("Added"), eq(Operation.ADD));
    verify(dataTypeService).getUnknownDataType();
    EntityReference sourceResult3 = actualAddFlowResult.source();
    assertTrue(sourceResult3 instanceof ImmutableEntityReference);
    EntityReference targetResult = actualAddFlowResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertTrue(actualAddFlowResult instanceof ImmutableLogicalFlow);
    assertEquals("2020-03-01", actualAddFlowResult.lastUpdatedBy());
    assertEquals("Provenance", actualAddFlowResult.provenance());
    assertEquals("The characteristics of someone or something", sourceResult3.description());
    assertEquals(1L, sourceResult3.id());
    assertEquals(EntityKind.ALL, sourceResult3.kind());
    assertEquals(EntityKind.ALL, actualAddFlowResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualAddFlowResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult3.entityLifecycleStatus());
    assertFalse(actualAddFlowResult.isReadOnly());
    assertFalse(actualAddFlowResult.isRemoved());
    assertEquals(sourceResult3, targetResult);
    assertSame(ofResult2, actualAddFlowResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  @DisplayName("Test addFlow(AddLogicalFlowCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.addFlow(AddLogicalFlowCommand, String)"})
  void testAddFlow3() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<DataType> ofResult = Optional.of(immutableDataType);
    when(dataTypeService.getUnknownDataType()).thenReturn(ofResult);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.addFlow(Mockito.<LogicalFlow>any()))
        .thenReturn(
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
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableAddLogicalFlowCommand.Builder builderResult2 =
        ImmutableAddLogicalFlowCommand.builder();

    ImmutableAddLogicalFlowCommand.Builder sourceResult2 =
        builderResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            logicalFlowService.addFlow(
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
                    .build(),
                "janedoe"));
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).addFlow(isA(LogicalFlow.class));
    verify(dataTypeService).getUnknownDataType();
  }

  /**
   * Test {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  @DisplayName("Test addFlow(AddLogicalFlowCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.addFlow(AddLogicalFlowCommand, String)"})
  void testAddFlow4() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<LogicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<DataType> ofResult = Optional.of(immutableDataType);
    when(dataTypeService.getUnknownDataType()).thenReturn(ofResult);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.addFlow(Mockito.<LogicalFlow>any()))
        .thenReturn(
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
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});

    ImmutableAddLogicalFlowCommand.Builder builderResult2 =
        ImmutableAddLogicalFlowCommand.builder();

    ImmutableAddLogicalFlowCommand.Builder sourceResult2 =
        builderResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(2L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    LogicalFlow actualAddFlowResult =
        logicalFlowService.addFlow(
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
                .build(),
            "janedoe");

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao).addFlow(isA(LogicalFlow.class));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(LogicalFlow.class), eq("janedoe"), eq("Added"), eq(Operation.ADD));
    verify(dataTypeService).getUnknownDataType();
    EntityReference sourceResult3 = actualAddFlowResult.source();
    assertTrue(sourceResult3 instanceof ImmutableEntityReference);
    EntityReference targetResult = actualAddFlowResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertTrue(actualAddFlowResult instanceof ImmutableLogicalFlow);
    assertEquals("2020-03-01", actualAddFlowResult.lastUpdatedBy());
    assertEquals("Provenance", actualAddFlowResult.provenance());
    assertEquals("The characteristics of someone or something", sourceResult3.description());
    assertEquals(1L, sourceResult3.id());
    assertEquals(EntityKind.ALL, sourceResult3.kind());
    assertEquals(EntityKind.ALL, actualAddFlowResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualAddFlowResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult3.entityLifecycleStatus());
    assertFalse(actualAddFlowResult.isReadOnly());
    assertFalse(actualAddFlowResult.isRemoved());
    assertEquals(sourceResult3, targetResult);
    assertSame(ofResult2, actualAddFlowResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeService} {@link DataTypeService#getUnknownDataType()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  @DisplayName(
      "Test addFlow(AddLogicalFlowCommand, String); given DataTypeService getUnknownDataType() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.addFlow(AddLogicalFlowCommand, String)"})
  void testAddFlow_givenDataTypeServiceGetUnknownDataTypeReturnEmpty() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<LogicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    Optional<DataType> emptyResult = Optional.empty();
    when(dataTypeService.getUnknownDataType()).thenReturn(emptyResult);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.addFlow(Mockito.<LogicalFlow>any()))
        .thenReturn(
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

    ImmutableAddLogicalFlowCommand.Builder builderResult2 =
        ImmutableAddLogicalFlowCommand.builder();

    ImmutableAddLogicalFlowCommand.Builder sourceResult2 =
        builderResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    LogicalFlow actualAddFlowResult =
        logicalFlowService.addFlow(
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
                .build(),
            "janedoe");

    // Assert
    verify(logicalFlowDao).addFlow(isA(LogicalFlow.class));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(LogicalFlow.class), eq("janedoe"), eq("Added"), eq(Operation.ADD));
    verify(dataTypeService).getUnknownDataType();
    EntityReference sourceResult3 = actualAddFlowResult.source();
    assertTrue(sourceResult3 instanceof ImmutableEntityReference);
    EntityReference targetResult = actualAddFlowResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertTrue(actualAddFlowResult instanceof ImmutableLogicalFlow);
    assertEquals("2020-03-01", actualAddFlowResult.lastUpdatedBy());
    assertEquals("Provenance", actualAddFlowResult.provenance());
    assertEquals("The characteristics of someone or something", sourceResult3.description());
    assertEquals(1L, sourceResult3.id());
    assertEquals(EntityKind.ALL, sourceResult3.kind());
    assertEquals(EntityKind.ALL, actualAddFlowResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualAddFlowResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult3.entityLifecycleStatus());
    assertFalse(actualAddFlowResult.isReadOnly());
    assertFalse(actualAddFlowResult.isRemoved());
    assertEquals(sourceResult3, targetResult);
    assertSame(ofResult, actualAddFlowResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link AddLogicalFlowCommand#source()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  @DisplayName(
      "Test addFlow(AddLogicalFlowCommand, String); given IllegalArgumentException(); then calls source()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.addFlow(AddLogicalFlowCommand, String)"})
  void testAddFlow_givenIllegalArgumentException_thenCallsSource() {
    // Arrange
    AddLogicalFlowCommand addCmd = mock(AddLogicalFlowCommand.class);
    when(addCmd.target()).thenThrow(new IllegalArgumentException());
    when(addCmd.source())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.addFlow(addCmd, "janedoe"));
    verify(addCmd).source();
    verify(addCmd).target();
  }

  /**
   * Test {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#addFlow(LogicalFlow)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  @DisplayName(
      "Test addFlow(AddLogicalFlowCommand, String); given LogicalFlowDao addFlow(LogicalFlow) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.addFlow(AddLogicalFlowCommand, String)"})
  void testAddFlow_givenLogicalFlowDaoAddFlowThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.addFlow(Mockito.<LogicalFlow>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableAddLogicalFlowCommand.Builder builderResult = ImmutableAddLogicalFlowCommand.builder();

    ImmutableAddLogicalFlowCommand.Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            logicalFlowService.addFlow(
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
                    .build(),
                "janedoe"));
    verify(logicalFlowDao).addFlow(isA(LogicalFlow.class));
  }

  /**
   * Test {@link LogicalFlowService#addFlows(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#addFlows(Collection, String)}
   */
  @Test
  @DisplayName("Test addFlows(Collection, String); given ChangeLogService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowService.addFlows(Collection, String)"})
  void testAddFlows_givenChangeLogService() {
    // Arrange
    ArrayList<AddLogicalFlowCommand> addCmds = new ArrayList<>();

    ImmutableAddLogicalFlowCommand.Builder builderResult = ImmutableAddLogicalFlowCommand.builder();

    ImmutableAddLogicalFlowCommand.Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    addCmds.add(
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.addFlows(addCmds, "janedoe"));
  }

  /**
   * Test {@link LogicalFlowService#addFlows(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#addFlows(Collection, String)}
   */
  @Test
  @DisplayName("Test addFlows(Collection, String); given ChangeLogService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowService.addFlows(Collection, String)"})
  void testAddFlows_givenChangeLogService2() {
    // Arrange
    ArrayList<AddLogicalFlowCommand> addCmds = new ArrayList<>();

    ImmutableAddLogicalFlowCommand.Builder builderResult = ImmutableAddLogicalFlowCommand.builder();

    ImmutableAddLogicalFlowCommand.Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    addCmds.add(
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

    ImmutableAddLogicalFlowCommand.Builder builderResult2 =
        ImmutableAddLogicalFlowCommand.builder();

    ImmutableAddLogicalFlowCommand.Builder sourceResult2 =
        builderResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    addCmds.add(
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.addFlows(addCmds, "janedoe"));
  }

  /**
   * Test {@link LogicalFlowService#addFlows(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(Collection)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#addFlows(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test addFlows(Collection, String); given ChangeLogService write(Collection) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowService.addFlows(Collection, String)"})
  void testAddFlows_givenChangeLogServiceWriteThrowIllegalArgumentException() {
    // Arrange
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> logicalFlowService.addFlows(new ArrayList<>(), "janedoe"));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowService#addFlows(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#addFlows(Set, String)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#addFlows(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test addFlows(Collection, String); given LogicalFlowDao addFlows(Set, String) return HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowService.addFlows(Collection, String)"})
  void testAddFlows_givenLogicalFlowDaoAddFlowsReturnHashSet_thenReturnEmpty() {
    // Arrange
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    when(logicalFlowDao.addFlows(Mockito.<Set<LogicalFlow>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<LogicalFlow> actualAddFlowsResult =
        logicalFlowService.addFlows(new ArrayList<>(), "janedoe");

    // Assert
    verify(logicalFlowDao).addFlows(isA(Set.class), eq("janedoe"));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualAddFlowsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#addFlows(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#addFlows(Set, String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#addFlows(Collection, String)}
   */
  @Test
  @DisplayName(
      "Test addFlows(Collection, String); given LogicalFlowDao addFlows(Set, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowService.addFlows(Collection, String)"})
  void testAddFlows_givenLogicalFlowDaoAddFlowsThrowIllegalArgumentException() {
    // Arrange
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    when(logicalFlowDao.addFlows(Mockito.<Set<LogicalFlow>>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> logicalFlowService.addFlows(new ArrayList<>(), "janedoe"));
    verify(logicalFlowDao).addFlows(isA(Set.class), eq("janedoe"));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowService#updateReadOnly(long, boolean, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  @DisplayName("Test updateReadOnly(long, boolean, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.updateReadOnly(long, boolean, String)"})
  void testUpdateReadOnly() {
    // Arrange
    when(logicalFlowDao.updateReadOnly(anyLong(), anyBoolean(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.updateReadOnly(1L, true, "User"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(logicalFlowDao).updateReadOnly(1L, true, "User");
  }

  /**
   * Test {@link LogicalFlowService#updateReadOnly(long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateReadOnly(long, boolean, String); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.updateReadOnly(long, boolean, String)"})
  void testUpdateReadOnly_givenChangeLogServiceWriteThrowIllegalArgumentException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());
    when(logicalFlowDao.updateReadOnly(anyLong(), anyBoolean(), Mockito.<String>any()))
        .thenReturn(1L);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.updateReadOnly(1L, true, "User"));
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(logicalFlowDao).updateReadOnly(1L, true, "User");
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link LogicalFlowService#updateReadOnly(long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#getByFlowId(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateReadOnly(long, boolean, String); given LogicalFlowDao getByFlowId(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.updateReadOnly(long, boolean, String)"})
  void testUpdateReadOnly_givenLogicalFlowDaoGetByFlowIdThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.getByFlowId(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.updateReadOnly(1L, true, "User"));
    verify(logicalFlowDao).getByFlowId(1L);
  }

  /**
   * Test {@link LogicalFlowService#updateReadOnly(long, boolean, String)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateReadOnly(long, boolean, String); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.updateReadOnly(long, boolean, String)"})
  void testUpdateReadOnly_thenSourceReturnImmutableEntityReference() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(logicalFlowDao.updateReadOnly(anyLong(), anyBoolean(), Mockito.<String>any()))
        .thenReturn(1L);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act
    LogicalFlow actualUpdateReadOnlyResult = logicalFlowService.updateReadOnly(1L, true, "User");

    // Assert
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(logicalFlowDao).updateReadOnly(1L, true, "User");
    verify(changeLogService).write(isA(ChangeLog.class));
    EntityReference sourceResult2 = actualUpdateReadOnlyResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult = actualUpdateReadOnlyResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertTrue(actualUpdateReadOnlyResult instanceof ImmutableLogicalFlow);
    assertEquals("2020-03-01", actualUpdateReadOnlyResult.lastUpdatedBy());
    assertEquals("Provenance", actualUpdateReadOnlyResult.provenance());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityKind.ALL, actualUpdateReadOnlyResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualUpdateReadOnlyResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertFalse(actualUpdateReadOnlyResult.isReadOnly());
    assertFalse(actualUpdateReadOnlyResult.isRemoved());
    assertEquals(sourceResult2, targetResult);
    assertSame(ofResult, actualUpdateReadOnlyResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LogicalFlowService#updateReadOnly(long, boolean, String)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateReadOnly(long, boolean, String); when 'false'; then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow LogicalFlowService.updateReadOnly(long, boolean, String)"})
  void testUpdateReadOnly_whenFalse_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act
    LogicalFlow actualUpdateReadOnlyResult = logicalFlowService.updateReadOnly(1L, false, "User");

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    EntityReference sourceResult2 = actualUpdateReadOnlyResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult = actualUpdateReadOnlyResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertTrue(actualUpdateReadOnlyResult instanceof ImmutableLogicalFlow);
    assertEquals("2020-03-01", actualUpdateReadOnlyResult.lastUpdatedBy());
    assertEquals("Provenance", actualUpdateReadOnlyResult.provenance());
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityKind.ALL, actualUpdateReadOnlyResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualUpdateReadOnlyResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertFalse(actualUpdateReadOnlyResult.isReadOnly());
    assertFalse(actualUpdateReadOnlyResult.isRemoved());
    assertEquals(sourceResult2, targetResult);
    assertSame(ofResult, actualUpdateReadOnlyResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LogicalFlowService#removeFlow(Long, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  @DisplayName("Test removeFlow(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowService.removeFlow(Long, String)"})
  void testRemoveFlow() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<LogicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(entityReferenceList);
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act
    int actualRemoveFlowResult = logicalFlowService.removeFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    verify(logicalFlowDao).removeFlow(1L, "janedoe");
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(LogicalFlow.class),
            eq("janedoe"),
            eq("Removed : datatypes [Name]"),
            eq(Operation.REMOVE));
    verify(dataTypeService).findByIdSelector(isA(Select.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Test {@link LogicalFlowService#removeFlow(Long, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  @DisplayName("Test removeFlow(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowService.removeFlow(Long, String)"})
  void testRemoveFlow2() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<LogicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(entityReferenceList);
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act
    int actualRemoveFlowResult = logicalFlowService.removeFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    verify(logicalFlowDao).removeFlow(1L, "janedoe");
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(LogicalFlow.class),
            eq("janedoe"),
            eq("Removed : datatypes [Name, Name]"),
            eq(Operation.REMOVE));
    verify(dataTypeService).findByIdSelector(isA(Select.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Test {@link LogicalFlowService#removeFlow(Long, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  @DisplayName("Test removeFlow(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowService.removeFlow(Long, String)"})
  void testRemoveFlow3() {
    // Arrange
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException());
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.removeFlow(1L, "janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(logicalFlowDao).removeFlow(1L, "janedoe");
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowService#removeFlow(Long, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  @DisplayName("Test removeFlow(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowService.removeFlow(Long, String)"})
  void testRemoveFlow4() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<LogicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(-2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act
    int actualRemoveFlowResult = logicalFlowService.removeFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    verify(logicalFlowDao).removeFlow(1L, "janedoe");
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(LogicalFlow.class),
            eq("janedoe"),
            eq("Removed : datatypes []"),
            eq(Operation.REMOVE));
    verify(dataTypeService).findByIdSelector(isA(Select.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Test {@link LogicalFlowService#removeFlow(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#getByFlowId(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  @DisplayName(
      "Test removeFlow(Long, String); given LogicalFlowDao getByFlowId(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowService.removeFlow(Long, String)"})
  void testRemoveFlow_givenLogicalFlowDaoGetByFlowIdThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.getByFlowId(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.removeFlow(1L, "janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
  }

  /**
   * Test {@link LogicalFlowService#removeFlow(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#removeFlow(Long, String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  @DisplayName(
      "Test removeFlow(Long, String); given LogicalFlowDao removeFlow(Long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowService.removeFlow(Long, String)"})
  void testRemoveFlow_givenLogicalFlowDaoRemoveFlowThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.removeFlow(1L, "janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(logicalFlowDao).removeFlow(1L, "janedoe");
  }

  /**
   * Test {@link LogicalFlowService#removeFlow(Long, String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  @DisplayName("Test removeFlow(Long, String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowService.removeFlow(Long, String)"})
  void testRemoveFlow_thenReturnOne() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<LogicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
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

    // Act
    int actualRemoveFlowResult = logicalFlowService.removeFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    verify(logicalFlowDao).removeFlow(1L, "janedoe");
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(LogicalFlow.class),
            eq("janedoe"),
            eq("Removed : datatypes []"),
            eq(Operation.REMOVE));
    verify(dataTypeService).findByIdSelector(isA(Select.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Test {@link LogicalFlowService#restoreFlow(long, String)}.
   *
   * <p>Method under test: {@link LogicalFlowService#restoreFlow(long, String)}
   */
  @Test
  @DisplayName("Test restoreFlow(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogicalFlowService.restoreFlow(long, String)"})
  void testRestoreFlow() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(logicalFlowDao.restoreFlow(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.restoreFlow(1L, "janedoe"));
    verify(logicalFlowDao).restoreFlow(1L, "janedoe");
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class), eq("janedoe"), eq("Restored"), eq(Operation.ADD));
  }

  /**
   * Test {@link LogicalFlowService#restoreFlow(long, String)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#restoreFlow(long, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#restoreFlow(long, String)}
   */
  @Test
  @DisplayName(
      "Test restoreFlow(long, String); given LogicalFlowDao restoreFlow(long, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogicalFlowService.restoreFlow(long, String)"})
  void testRestoreFlow_givenLogicalFlowDaoRestoreFlowReturnFalse_thenReturnFalse() {
    // Arrange
    when(logicalFlowDao.restoreFlow(anyLong(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualRestoreFlowResult = logicalFlowService.restoreFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).restoreFlow(1L, "janedoe");
    assertFalse(actualRestoreFlowResult);
  }

  /**
   * Test {@link LogicalFlowService#restoreFlow(long, String)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#restoreFlow(long, String)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#restoreFlow(long, String)}
   */
  @Test
  @DisplayName(
      "Test restoreFlow(long, String); given LogicalFlowDao restoreFlow(long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogicalFlowService.restoreFlow(long, String)"})
  void testRestoreFlow_givenLogicalFlowDaoRestoreFlowThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.restoreFlow(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.restoreFlow(1L, "janedoe"));
    verify(logicalFlowDao).restoreFlow(1L, "janedoe");
  }

  /**
   * Test {@link LogicalFlowService#restoreFlow(long, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#restoreFlow(long, String)}
   */
  @Test
  @DisplayName("Test restoreFlow(long, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogicalFlowService.restoreFlow(long, String)"})
  void testRestoreFlow_thenReturnTrue() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(logicalFlowDao.restoreFlow(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualRestoreFlowResult = logicalFlowService.restoreFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).restoreFlow(1L, "janedoe");
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class), eq("janedoe"), eq("Restored"), eq(Operation.ADD));
    assertTrue(actualRestoreFlowResult);
  }

  /**
   * Test {@link LogicalFlowService#cleanupOrphans()}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#cleanupOrphans()}
   */
  @Test
  @DisplayName("Test cleanupOrphans(); then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer LogicalFlowService.cleanupOrphans()"})
  void testCleanupOrphans_thenReturnIntValueIsOne() {
    // Arrange
    when(logicalFlowDao.cleanupOrphans()).thenReturn(1);

    // Act
    Integer actualCleanupOrphansResult = logicalFlowService.cleanupOrphans();

    // Assert
    verify(logicalFlowDao).cleanupOrphans();
    assertEquals(1, actualCleanupOrphansResult.intValue());
  }

  /**
   * Test {@link LogicalFlowService#cleanupOrphans()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#cleanupOrphans()}
   */
  @Test
  @DisplayName("Test cleanupOrphans(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer LogicalFlowService.cleanupOrphans()"})
  void testCleanupOrphans_thenThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.cleanupOrphans()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.cleanupOrphans());
    verify(logicalFlowDao).cleanupOrphans();
  }

  /**
   * Test {@link LogicalFlowService#cleanupSelfReferencingFlows()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#cleanupSelfReferencingFlows()}
   */
  @Test
  @DisplayName("Test cleanupSelfReferencingFlows(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowService.cleanupSelfReferencingFlows()"})
  void testCleanupSelfReferencingFlows_thenReturnOne() {
    // Arrange
    when(logicalFlowDao.cleanupSelfReferencingFlows()).thenReturn(1);

    // Act
    int actualCleanupSelfReferencingFlowsResult = logicalFlowService.cleanupSelfReferencingFlows();

    // Assert
    verify(logicalFlowDao).cleanupSelfReferencingFlows();
    assertEquals(1, actualCleanupSelfReferencingFlowsResult);
  }

  /**
   * Test {@link LogicalFlowService#cleanupSelfReferencingFlows()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#cleanupSelfReferencingFlows()}
   */
  @Test
  @DisplayName("Test cleanupSelfReferencingFlows(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowService.cleanupSelfReferencingFlows()"})
  void testCleanupSelfReferencingFlows_thenThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.cleanupSelfReferencingFlows()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.cleanupSelfReferencingFlows());
    verify(logicalFlowDao).cleanupSelfReferencingFlows();
  }

  /**
   * Test {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  @DisplayName(
      "Test findUpstreamFlowsForEntityReferences(List); given LogicalFlowDao; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findUpstreamFlowsForEntityReferences(List)"})
  void testFindUpstreamFlowsForEntityReferences_givenLogicalFlowDao_whenArrayList() {
    // Arrange and Act
    Collection<LogicalFlow> actualFindUpstreamFlowsForEntityReferencesResult =
        logicalFlowService.findUpstreamFlowsForEntityReferences(new ArrayList<>());

    // Assert
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult instanceof List);
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  @DisplayName("Test findUpstreamFlowsForEntityReferences(List); given LogicalFlowDao; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findUpstreamFlowsForEntityReferences(List)"})
  void testFindUpstreamFlowsForEntityReferences_givenLogicalFlowDao_whenNull() {
    // Arrange and Act
    Collection<LogicalFlow> actualFindUpstreamFlowsForEntityReferencesResult =
        logicalFlowService.findUpstreamFlowsForEntityReferences(null);

    // Assert
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult instanceof List);
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  @DisplayName("Test findUpstreamFlowsForEntityReferences(List); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findUpstreamFlowsForEntityReferences(List)"})
  void testFindUpstreamFlowsForEntityReferences_thenReturnArrayList() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findUpstreamFlowsForEntityReferences(Mockito.<List<EntityReference>>any()))
        .thenReturn(logicalFlowList);

    ArrayList<EntityReference> references = new ArrayList<>();
    references.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    Collection<LogicalFlow> actualFindUpstreamFlowsForEntityReferencesResult =
        logicalFlowService.findUpstreamFlowsForEntityReferences(references);

    // Assert
    verify(logicalFlowDao).findUpstreamFlowsForEntityReferences(isA(List.class));
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult instanceof List);
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult.isEmpty());
    assertSame(logicalFlowList, actualFindUpstreamFlowsForEntityReferencesResult);
  }

  /**
   * Test {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  @DisplayName("Test findUpstreamFlowsForEntityReferences(List); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findUpstreamFlowsForEntityReferences(List)"})
  void testFindUpstreamFlowsForEntityReferences_thenReturnArrayList2() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findUpstreamFlowsForEntityReferences(Mockito.<List<EntityReference>>any()))
        .thenReturn(logicalFlowList);

    ArrayList<EntityReference> references = new ArrayList<>();
    references.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    references.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    Collection<LogicalFlow> actualFindUpstreamFlowsForEntityReferencesResult =
        logicalFlowService.findUpstreamFlowsForEntityReferences(references);

    // Assert
    verify(logicalFlowDao).findUpstreamFlowsForEntityReferences(isA(List.class));
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult instanceof List);
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult.isEmpty());
    assertSame(logicalFlowList, actualFindUpstreamFlowsForEntityReferencesResult);
  }

  /**
   * Test {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  @DisplayName(
      "Test findUpstreamFlowsForEntityReferences(List); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LogicalFlowService.findUpstreamFlowsForEntityReferences(List)"})
  void testFindUpstreamFlowsForEntityReferences_thenThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.findUpstreamFlowsForEntityReferences(Mockito.<List<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException());

    ArrayList<EntityReference> references = new ArrayList<>();
    references.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> logicalFlowService.findUpstreamFlowsForEntityReferences(references));
    verify(logicalFlowDao).findUpstreamFlowsForEntityReferences(isA(List.class));
  }

  /**
   * Test {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findEditableFlowIdsForParentReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowService.findEditableFlowIdsForParentReference(EntityReference, String)"
  })
  void testFindEditableFlowIdsForParentReference() {
    // Arrange
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> logicalFlowService.findEditableFlowIdsForParentReference(null, "janedoe"));
    verify(logicalFlowDao).findByEntityReference(isNull());
  }

  /**
   * Test {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findEditableFlowIdsForParentReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowService.findEditableFlowIdsForParentReference(EntityReference, String)"
  })
  void testFindEditableFlowIdsForParentReference2() {
    // Arrange
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(flowPermissionChecker.findFlowPermissionsForParentEntity(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> logicalFlowService.findEditableFlowIdsForParentReference(null, "janedoe"));
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(flowPermissionChecker).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
  }

  /**
   * Test {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ADD}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findEditableFlowIdsForParentReference(EntityReference, String); given HashSet() add 'ADD'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowService.findEditableFlowIdsForParentReference(EntityReference, String)"
  })
  void testFindEditableFlowIdsForParentReference_givenHashSetAddAdd_thenReturnEmpty() {
    // Arrange
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    HashSet<Operation> operationSet = new HashSet<>();
    operationSet.add(Operation.ADD);
    when(flowPermissionChecker.findFlowPermissionsForParentEntity(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(operationSet);

    // Act
    Set<Long> actualFindEditableFlowIdsForParentReferenceResult =
        logicalFlowService.findEditableFlowIdsForParentReference(null, "janedoe");

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(flowPermissionChecker).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
    assertTrue(actualFindEditableFlowIdsForParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ADD}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findEditableFlowIdsForParentReference(EntityReference, String); given HashSet() add 'ADD'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowService.findEditableFlowIdsForParentReference(EntityReference, String)"
  })
  void testFindEditableFlowIdsForParentReference_givenHashSetAddAdd_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
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
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowList);

    HashSet<Operation> operationSet = new HashSet<>();
    operationSet.add(Operation.ADD);
    when(flowPermissionChecker.findFlowPermissionsForParentEntity(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(operationSet);

    // Act
    Set<Long> actualFindEditableFlowIdsForParentReferenceResult =
        logicalFlowService.findEditableFlowIdsForParentReference(null, "janedoe");

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(flowPermissionChecker).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
    assertEquals(1, actualFindEditableFlowIdsForParentReferenceResult.size());
    assertTrue(actualFindEditableFlowIdsForParentReferenceResult.contains(1L));
  }

  /**
   * Test {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ADD}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findEditableFlowIdsForParentReference(EntityReference, String); given HashSet() add 'ADD'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowService.findEditableFlowIdsForParentReference(EntityReference, String)"
  })
  void testFindEditableFlowIdsForParentReference_givenHashSetAddAdd_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
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

    Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder provenanceResult2 =
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

    Builder sourceResult2 =
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
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowList);

    HashSet<Operation> operationSet = new HashSet<>();
    operationSet.add(Operation.ADD);
    when(flowPermissionChecker.findFlowPermissionsForParentEntity(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(operationSet);

    // Act
    Set<Long> actualFindEditableFlowIdsForParentReferenceResult =
        logicalFlowService.findEditableFlowIdsForParentReference(null, "janedoe");

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(flowPermissionChecker).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
    assertEquals(1, actualFindEditableFlowIdsForParentReferenceResult.size());
    assertTrue(actualFindEditableFlowIdsForParentReferenceResult.contains(1L));
  }

  /**
   * Test {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findEditableFlowIdsForParentReference(EntityReference, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowService.findEditableFlowIdsForParentReference(EntityReference, String)"
  })
  void testFindEditableFlowIdsForParentReference_thenReturnEmpty() {
    // Arrange
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(flowPermissionChecker.findFlowPermissionsForParentEntity(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Long> actualFindEditableFlowIdsForParentReferenceResult =
        logicalFlowService.findEditableFlowIdsForParentReference(null, "janedoe");

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(flowPermissionChecker).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
    assertTrue(actualFindEditableFlowIdsForParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findEditableFlowIdsForParentReference(EntityReference, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowService.findEditableFlowIdsForParentReference(EntityReference, String)"
  })
  void testFindEditableFlowIdsForParentReference_thenReturnEmpty2() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
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
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowList);
    when(flowPermissionChecker.findFlowPermissionsForParentEntity(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Long> actualFindEditableFlowIdsForParentReferenceResult =
        logicalFlowService.findEditableFlowIdsForParentReference(null, "janedoe");

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(flowPermissionChecker, atLeast(1))
        .findFlowPermissionsForParentEntity(Mockito.<EntityReference>any(), eq("janedoe"));
    assertTrue(actualFindEditableFlowIdsForParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findEditableFlowIdsForParentReference(EntityReference, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LogicalFlowService.findEditableFlowIdsForParentReference(EntityReference, String)"
  })
  void testFindEditableFlowIdsForParentReference_thenReturnEmpty3() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
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

    Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder provenanceResult2 =
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

    Builder sourceResult2 =
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
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowList);
    when(flowPermissionChecker.findFlowPermissionsForParentEntity(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Long> actualFindEditableFlowIdsForParentReferenceResult =
        logicalFlowService.findEditableFlowIdsForParentReference(null, "janedoe");

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(flowPermissionChecker, atLeast(1))
        .findFlowPermissionsForParentEntity(Mockito.<EntityReference>any(), eq("janedoe"));
    assertTrue(actualFindEditableFlowIdsForParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test getFlowInfoByDirection(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LogicalFlowGraphSummary LogicalFlowService.getFlowInfoByDirection(EntityReference, Long)"
  })
  void testGetFlowInfoByDirection() {
    // Arrange
    when(logicalFlowStatsDao.getFlowInfoByDirection(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.getFlowInfoByDirection(null, 1L));
    verify(logicalFlowStatsDao).getFlowInfoByDirection(isNull(), eq(1L));
  }

  /**
   * Test {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test getFlowInfoByDirection(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LogicalFlowGraphSummary LogicalFlowService.getFlowInfoByDirection(EntityReference, Long)"
  })
  void testGetFlowInfoByDirection2() {
    // Arrange
    when(dataTypeService.getDataTypeById(anyLong())).thenThrow(new IllegalArgumentException());
    when(logicalFlowStatsDao.getFlowInfoByDirection(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.getFlowInfoByDirection(null, 1L));
    verify(logicalFlowStatsDao).getFlowInfoByDirection(isNull(), eq(1L));
    verify(dataTypeService).getDataTypeById(1L);
  }

  /**
   * Test {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeService}.
   *   <li>Then return parentDataType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}
   */
  @Test
  @DisplayName(
      "Test getFlowInfoByDirection(EntityReference, Long); given DataTypeService; then return parentDataType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LogicalFlowGraphSummary LogicalFlowService.getFlowInfoByDirection(EntityReference, Long)"
  })
  void testGetFlowInfoByDirection_givenDataTypeService_thenReturnParentDataTypeIsNull() {
    // Arrange
    when(logicalFlowStatsDao.getFlowInfoByDirection(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new HashMap<>());

    // Act
    LogicalFlowGraphSummary actualFlowInfoByDirection =
        logicalFlowService.getFlowInfoByDirection(null, null);

    // Assert
    verify(logicalFlowStatsDao).getFlowInfoByDirection(isNull(), isNull());
    assertTrue(actualFlowInfoByDirection instanceof ImmutableLogicalFlowGraphSummary);
    assertNull(actualFlowInfoByDirection.parentDataType());
    assertNull(actualFlowInfoByDirection.startingDataType());
    assertTrue(actualFlowInfoByDirection.flowInfoByDirection().isEmpty());
  }

  /**
   * Test {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}.
   *
   * <ul>
   *   <li>Then parentDataType return {@link ImmutableDataType}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}
   */
  @Test
  @DisplayName(
      "Test getFlowInfoByDirection(EntityReference, Long); then parentDataType return ImmutableDataType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LogicalFlowGraphSummary LogicalFlowService.getFlowInfoByDirection(EntityReference, Long)"
  })
  void testGetFlowInfoByDirection_thenParentDataTypeReturnImmutableDataType() {
    // Arrange
    when(dataTypeService.getDataTypeById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    when(logicalFlowStatsDao.getFlowInfoByDirection(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new HashMap<>());

    // Act
    LogicalFlowGraphSummary actualFlowInfoByDirection =
        logicalFlowService.getFlowInfoByDirection(null, 1L);

    // Assert
    verify(logicalFlowStatsDao).getFlowInfoByDirection(isNull(), eq(1L));
    verify(dataTypeService, atLeast(1)).getDataTypeById(1L);
    DataType parentDataTypeResult = actualFlowInfoByDirection.parentDataType();
    assertTrue(parentDataTypeResult instanceof ImmutableDataType);
    assertTrue(actualFlowInfoByDirection instanceof ImmutableLogicalFlowGraphSummary);
    assertEquals("Code", parentDataTypeResult.code());
    assertEquals("Name", parentDataTypeResult.name());
    assertEquals("The characteristics of someone or something", parentDataTypeResult.description());
    assertEquals(EntityKind.ALL, parentDataTypeResult.kind());
    assertFalse(parentDataTypeResult.deprecated());
    assertFalse(parentDataTypeResult.unknown());
    assertTrue(actualFlowInfoByDirection.flowInfoByDirection().isEmpty());
    assertTrue(parentDataTypeResult.concrete());
    assertSame(parentDataTypeResult, actualFlowInfoByDirection.startingDataType());
  }

  /**
   * Test {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}.
   *
   * <ul>
   *   <li>Then return flowInfoByDirection size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}
   */
  @Test
  @DisplayName(
      "Test getFlowInfoByDirection(EntityReference, Long); then return flowInfoByDirection size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LogicalFlowGraphSummary LogicalFlowService.getFlowInfoByDirection(EntityReference, Long)"
  })
  void testGetFlowInfoByDirection_thenReturnFlowInfoByDirectionSizeIsOne() {
    // Arrange
    when(dataTypeService.getDataTypeById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    HashMap<FlowDirection, Set<FlowInfo>> flowDirectionSetMap = new HashMap<>();
    flowDirectionSetMap.put(FlowDirection.INBOUND, new HashSet<>());
    when(logicalFlowStatsDao.getFlowInfoByDirection(
            Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(flowDirectionSetMap);

    // Act
    LogicalFlowGraphSummary actualFlowInfoByDirection =
        logicalFlowService.getFlowInfoByDirection(null, 1L);

    // Assert
    verify(logicalFlowStatsDao).getFlowInfoByDirection(isNull(), eq(1L));
    verify(dataTypeService, atLeast(1)).getDataTypeById(1L);
    DataType parentDataTypeResult = actualFlowInfoByDirection.parentDataType();
    assertTrue(parentDataTypeResult instanceof ImmutableDataType);
    assertTrue(actualFlowInfoByDirection instanceof ImmutableLogicalFlowGraphSummary);
    assertEquals("Code", parentDataTypeResult.code());
    assertEquals("Name", parentDataTypeResult.name());
    assertEquals("The characteristics of someone or something", parentDataTypeResult.description());
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult =
        actualFlowInfoByDirection.flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertEquals(EntityKind.ALL, parentDataTypeResult.kind());
    assertFalse(parentDataTypeResult.deprecated());
    assertFalse(parentDataTypeResult.unknown());
    assertTrue(flowInfoByDirectionResult.get(FlowDirection.INBOUND).isEmpty());
    assertTrue(parentDataTypeResult.concrete());
    assertSame(parentDataTypeResult, actualFlowInfoByDirection.startingDataType());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.getFlowView(idSelectionOptions));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView2() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.getFlowView(idSelectionOptions));
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView3() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<DataTypeDecorator> dataTypeDecoratorSet = new HashSet<>();

    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
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

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorSet.add(ratingResult.targetInboundRating(targetInboundRating).build());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeDecoratorSet);
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.logicalFlowDataTypeDecorators().size());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView4() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
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

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult =
        actualFlowView.logicalFlowDataTypeDecorators();
    assertEquals(1, logicalFlowDataTypeDecoratorsResult.size());
    assertEquals(
        logicalFlowDataTypeDecoratorsResult,
        actualFlowView.physicalSpecificationDataTypeDecorators());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView5() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
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

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    ImmutableDataTypeDecorator.Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult2 =
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

    ImmutableDataTypeDecorator.Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorList.add(ratingResult2.targetInboundRating(targetInboundRating2).build());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult =
        actualFlowView.logicalFlowDataTypeDecorators();
    assertEquals(1, logicalFlowDataTypeDecoratorsResult.size());
    assertEquals(
        logicalFlowDataTypeDecoratorsResult,
        actualFlowView.physicalSpecificationDataTypeDecorators());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView6() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(assessmentRatingList);
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView7() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(assessmentRatingList);
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView8() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getFlowView(IdSelectionOptions); given HashSet() add 'PENDING'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_givenHashSetAddPending_thenCallsFilters() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(idSelectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getFlowView(IdSelectionOptions); given HashSet() add 'REMOVED'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_givenHashSetAddRemoved_thenCallsFilters() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(idSelectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   *   <li>Then return {@link ImmutableLogicalFlowView}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getFlowView(IdSelectionOptions); given HashSet() add 'REMOVED'; then return ImmutableLogicalFlowView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_givenHashSetAddRemoved_thenReturnImmutableLogicalFlowView() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#findBySelector(Select)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getFlowView(IdSelectionOptions); given LogicalFlowDao findBySelector(Select) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_givenLogicalFlowDaoFindBySelectorThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.getFlowView(idSelectionOptions));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowDao} {@link PhysicalFlowDao#findBySelector(Select)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getFlowView(IdSelectionOptions); given PhysicalFlowDao findBySelector(Select) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_givenPhysicalFlowDaoFindBySelectorThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> logicalFlowService.getFlowView(idSelectionOptions));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenCallsFilters() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableLogicalFlowView}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then return ImmutableLogicalFlowView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnImmutableLogicalFlowView() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return logicalFlowRatings is logicalFlowDataTypeDecorators.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getFlowView(IdSelectionOptions); then return logicalFlowRatings is logicalFlowDataTypeDecorators")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnLogicalFlowRatingsIsLogicalFlowDataTypeDecorators() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.logicalFlowAssessmentDefinitions().size());
    assertEquals(1, actualFlowView.physicalFlowAssessmentDefinitions().size());
    assertEquals(1, actualFlowView.physicalSpecificationAssessmentDefinitions().size());
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult =
        actualFlowView.logicalFlowDataTypeDecorators();
    assertTrue(logicalFlowDataTypeDecoratorsResult.isEmpty());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.logicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.logicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalFlowRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalFlows());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualFlowView.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalSpecificationRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalSpecifications());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.ratingSchemeItems());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return logicalFlowRatings size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then return logicalFlowRatings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnLogicalFlowRatingsSizeIsOne() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(assessmentRatingList);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.logicalFlowAssessmentDefinitions().size());
    Set<AssessmentRating> logicalFlowRatingsResult = actualFlowView.logicalFlowRatings();
    assertEquals(1, logicalFlowRatingsResult.size());
    assertEquals(1, actualFlowView.physicalFlowAssessmentDefinitions().size());
    assertEquals(1, actualFlowView.physicalSpecificationAssessmentDefinitions().size());
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult =
        actualFlowView.logicalFlowDataTypeDecorators();
    assertTrue(logicalFlowDataTypeDecoratorsResult.isEmpty());
    assertEquals(logicalFlowRatingsResult, actualFlowView.physicalFlowRatings());
    assertEquals(logicalFlowRatingsResult, actualFlowView.physicalSpecificationRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.logicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalFlows());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualFlowView.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalSpecifications());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.ratingSchemeItems());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return logicalFlowRatings size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then return logicalFlowRatings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnLogicalFlowRatingsSizeIsOne2() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(assessmentRatingList);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.logicalFlowAssessmentDefinitions().size());
    Set<AssessmentRating> logicalFlowRatingsResult = actualFlowView.logicalFlowRatings();
    assertEquals(1, logicalFlowRatingsResult.size());
    assertEquals(1, actualFlowView.physicalFlowAssessmentDefinitions().size());
    assertEquals(1, actualFlowView.physicalSpecificationAssessmentDefinitions().size());
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult =
        actualFlowView.logicalFlowDataTypeDecorators();
    assertTrue(logicalFlowDataTypeDecoratorsResult.isEmpty());
    assertEquals(logicalFlowRatingsResult, actualFlowView.physicalFlowRatings());
    assertEquals(logicalFlowRatingsResult, actualFlowView.physicalSpecificationRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.logicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalFlows());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualFlowView.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalSpecifications());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.ratingSchemeItems());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return logicalFlowRatings size is two.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then return logicalFlowRatings size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnLogicalFlowRatingsSizeIsTwo() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(2L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(assessmentRatingList);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.logicalFlowAssessmentDefinitions().size());
    assertEquals(1, actualFlowView.physicalFlowAssessmentDefinitions().size());
    assertEquals(1, actualFlowView.physicalSpecificationAssessmentDefinitions().size());
    Set<AssessmentRating> logicalFlowRatingsResult = actualFlowView.logicalFlowRatings();
    assertEquals(2, logicalFlowRatingsResult.size());
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult =
        actualFlowView.logicalFlowDataTypeDecorators();
    assertTrue(logicalFlowDataTypeDecoratorsResult.isEmpty());
    assertEquals(logicalFlowRatingsResult, actualFlowView.physicalFlowRatings());
    assertEquals(logicalFlowRatingsResult, actualFlowView.physicalSpecificationRatings());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.logicalFlows());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalFlows());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualFlowView.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.physicalSpecifications());
    assertSame(logicalFlowDataTypeDecoratorsResult, actualFlowView.ratingSchemeItems());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return logicalFlows size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then return logicalFlows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnLogicalFlowsSizeIsOne() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
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
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(logicalFlowList);
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.logicalFlows().size());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return logicalFlows size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then return logicalFlows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnLogicalFlowsSizeIsOne2() {
    // Arrange
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
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

    Builder sourceResult =
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

    Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder provenanceResult2 =
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

    Builder sourceResult2 =
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
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(logicalFlowList);
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.logicalFlows().size());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return physicalFlows size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then return physicalFlows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnPhysicalFlowsSizeIsOne() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created);

    ImmutablePhysicalFlow.Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult.transport(TransportKindValue.of("42")).build());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalFlowList);
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.physicalFlows().size());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return physicalFlows size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then return physicalFlows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnPhysicalFlowsSizeIsOne2() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created);

    ImmutablePhysicalFlow.Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutablePhysicalFlow.Builder basisOffsetResult2 =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalFlow.Builder createdResult2 = basisOffsetResult2.created(created2);

    ImmutablePhysicalFlow.Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult2.transport(TransportKindValue.of("42")).build());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalFlowList);
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.physicalFlows().size());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return physicalSpecifications size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getFlowView(IdSelectionOptions); then return physicalSpecifications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnPhysicalSpecificationsSizeIsOne() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    physicalSpecificationSet.add(
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalSpecificationSet);
    when(ratingSchemeService.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.physicalSpecifications().size());
  }

  /**
   * Test {@link LogicalFlowService#getFlowView(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowService#getFlowView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getFlowView(IdSelectionOptions); then return ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowView LogicalFlowService.getFlowView(IdSelectionOptions)"})
  void testGetFlowView_thenReturnRatingSchemeItemsSizeIsOne() {
    // Arrange
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowDecoratorDao.findByLogicalFlowIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(physicalSpecDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.entityReference())
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
    LogicalFlowView actualFlowView = logicalFlowService.getFlowView(idSelectionOptions);

    // Assert
    verify(logicalFlowDecoratorDao).findByLogicalFlowIdSelector(isA(Select.class));
    verify(physicalSpecDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentDefinitionService, atLeast(1))
        .findByPrimaryDefinitionsForKind(Mockito.<EntityKind>any(), isA(Optional.class));
    verify(assessmentRatingService, atLeast(1))
        .findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), isA(IdSelectionOptions.class));
    verify(ratingSchemeService).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualFlowView instanceof ImmutableLogicalFlowView);
    assertEquals(1, actualFlowView.ratingSchemeItems().size());
  }
}
