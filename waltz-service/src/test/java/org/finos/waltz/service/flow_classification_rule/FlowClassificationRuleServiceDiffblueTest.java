package org.finos.waltz.service.flow_classification_rule;

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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.NotFoundException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.actor.ActorDao;
import org.finos.waltz.data.app_group.AppGroupDao;
import org.finos.waltz.data.app_group.AppGroupEntryDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.data_type.search.DataTypeSearchDao;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.end_user_app.EndUserAppDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.entity_hierarchy.EntityHierarchyDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.FlowDataType;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.datatype.ImmutableFlowDataType;
import org.finos.waltz.model.datatype.ImmutableFlowDataType.Builder;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchy;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchyItem;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchy;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchyItem;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification.ImmutableFlowClassification;
import org.finos.waltz.model.flow_classification_rule.DiscouragedSource;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleCreateCommand;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleUpdateCommand;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleCreateCommand;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleUpdateCommand;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint;
import org.finos.waltz.model.logical_flow.FlowClassificationRulesView;
import org.finos.waltz.model.logical_flow.ImmutableFlowClassificationRulesView;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorRatingsCalculator;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.entity_hierarchy.EntityHierarchyService;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.finos.waltz.service.tag.TagService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.UpdateConditionStep;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FlowClassificationRuleServiceDiffblueTest {
  @Mock private ActorDao actorDao;

  @Mock private AppGroupDao appGroupDao;

  @Mock private AppGroupEntryDao appGroupEntryDao;

  @Mock private ApplicationDao applicationDao;

  @Mock private ChangeLogService changeLogService;

  @Mock private DataTypeDao dataTypeDao;

  @Mock private EndUserAppDao endUserAppDao;

  @Mock private EntityHierarchyService entityHierarchyService;

  @Mock private FlowClassificationCalculator flowClassificationCalculator;

  @Mock private FlowClassificationDao flowClassificationDao;

  @Mock private FlowClassificationRuleDao flowClassificationRuleDao;

  @InjectMocks private FlowClassificationRuleService flowClassificationRuleService;

  @Mock private LogicalFlowDecoratorDao logicalFlowDecoratorDao;

  @Mock private OrganisationalUnitDao organisationalUnitDao;

  /**
   * Test {@link FlowClassificationRuleService#findByEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findByEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleService.findByEntityKind(EntityKind)"})
  void testFindByEntityKind_thenReturnEmpty() {
    // Arrange
    when(flowClassificationRuleDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<FlowClassificationRule> actualFindByEntityKindResult =
        flowClassificationRuleService.findByEntityKind(EntityKind.ALL);

    // Assert
    verify(flowClassificationRuleDao).findByEntityKind(EntityKind.ALL);
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findByEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findByEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleService.findByEntityKind(EntityKind)"})
  void testFindByEntityKind_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> flowClassificationRuleService.findByEntityKind(EntityKind.ALL));
    verify(flowClassificationRuleDao).findByEntityKind(EntityKind.ALL);
  }

  /**
   * Test {@link FlowClassificationRuleService#getById(long)}.
   *
   * <ul>
   *   <li>Then subjectOrgUnitReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then subjectOrgUnitReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowClassificationRule FlowClassificationRuleService.getById(long)"})
  void testGetById_thenSubjectOrgUnitReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
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
    FlowClassificationRule actualById = flowClassificationRuleService.getById(1L);

    // Assert
    verify(flowClassificationRuleDao).getById(1L);
    EntityReference subjectOrgUnitReferenceResult2 = actualById.subjectOrgUnitReference();
    assertTrue(subjectOrgUnitReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference subjectReferenceResult2 = actualById.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointReferenceResult = actualById.vantagePointReference();
    assertTrue(vantagePointReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableFlowClassificationRule);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Not all who wander are lost", actualById.message());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.classificationId().longValue());
    assertEquals(1L, actualById.dataTypeId().longValue());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(MessageSeverity.NONE, actualById.messageSeverity());
    assertFalse(actualById.isReadonly());
    assertEquals(subjectOrgUnitReferenceResult2, subjectReferenceResult2);
    assertEquals(subjectOrgUnitReferenceResult2, vantagePointReferenceResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#getById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowClassificationRule FlowClassificationRuleService.getById(long)"})
  void testGetById_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> flowClassificationRuleService.getById(1L));
    verify(flowClassificationRuleDao).getById(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    when(flowClassificationRuleDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<FlowClassificationRule> actualFindByEntityReferenceResult =
        flowClassificationRuleService.findByEntityReference(null);

    // Assert
    verify(flowClassificationRuleDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> flowClassificationRuleService.findByEntityReference(null));
    verify(flowClassificationRuleDao).findByEntityReference(isNull());
  }

  /**
   * Test {@link FlowClassificationRuleService#findByApplicationId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findByApplicationId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleService.findByApplicationId(long)"})
  void testFindByApplicationId_thenReturnEmpty() {
    // Arrange
    when(flowClassificationRuleDao.findByApplicationId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<FlowClassificationRule> actualFindByApplicationIdResult =
        flowClassificationRuleService.findByApplicationId(1L);

    // Assert
    verify(flowClassificationRuleDao).findByApplicationId(1L);
    assertTrue(actualFindByApplicationIdResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findByApplicationId(long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findByApplicationId(long); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleService.findByApplicationId(long)"})
  void testFindByApplicationId_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.findByApplicationId(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> flowClassificationRuleService.findByApplicationId(1L));
    verify(flowClassificationRuleDao).findByApplicationId(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(FlowClassificationRuleUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.update(FlowClassificationRuleUpdateCommand, String)"
  })
  void testUpdate() {
    // Arrange
    when(flowClassificationRuleDao.update(Mockito.<FlowClassificationRuleUpdateCommand>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            flowClassificationRuleService.update(
                ImmutableFlowClassificationRuleUpdateCommand.builder()
                    .classificationId(1L)
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .message("Not all who wander are lost")
                    .severity(MessageSeverity.NONE)
                    .build(),
                "janedoe"));
    verify(flowClassificationRuleDao).update(isA(FlowClassificationRuleUpdateCommand.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(FlowClassificationRuleUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.update(FlowClassificationRuleUpdateCommand, String)"
  })
  void testUpdate2() {
    // Arrange
    when(flowClassificationRuleDao.update(Mockito.<FlowClassificationRuleUpdateCommand>any()))
        .thenReturn(1);

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build());
    when(actorDao.getById(anyLong())).thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            flowClassificationRuleService.update(
                ImmutableFlowClassificationRuleUpdateCommand.builder()
                    .classificationId(1L)
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .message("Not all who wander are lost")
                    .severity(MessageSeverity.NONE)
                    .build(),
                "janedoe"));
    verify(actorDao).getById(1L);
    verify(flowClassificationRuleDao).getById(1L);
    verify(flowClassificationRuleDao).update(isA(FlowClassificationRuleUpdateCommand.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(FlowClassificationRuleUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.update(FlowClassificationRuleUpdateCommand, String)"
  })
  void testUpdate3() {
    // Arrange
    when(flowClassificationRuleDao.update(Mockito.<FlowClassificationRuleUpdateCommand>any()))
        .thenReturn(1);

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeDao.getById(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            flowClassificationRuleService.update(
                ImmutableFlowClassificationRuleUpdateCommand.builder()
                    .classificationId(1L)
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .message("Not all who wander are lost")
                    .severity(MessageSeverity.NONE)
                    .build(),
                "janedoe"));
    verify(actorDao).getById(1L);
    verify(dataTypeDao).getById(1L);
    verify(flowClassificationRuleDao).getById(1L);
    verify(flowClassificationRuleDao).update(isA(FlowClassificationRuleUpdateCommand.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(FlowClassificationRuleUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.update(FlowClassificationRuleUpdateCommand, String)"
  })
  void testUpdate4() {
    // Arrange
    when(flowClassificationRuleDao.update(Mockito.<FlowClassificationRuleUpdateCommand>any()))
        .thenReturn(1);

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build());
    when(flowClassificationDao.getById(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
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
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            flowClassificationRuleService.update(
                ImmutableFlowClassificationRuleUpdateCommand.builder()
                    .classificationId(1L)
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .message("Not all who wander are lost")
                    .severity(MessageSeverity.NONE)
                    .build(),
                "janedoe"));
    verify(actorDao).getById(1L);
    verify(dataTypeDao).getById(1L);
    verify(flowClassificationDao).getById(1L);
    verify(flowClassificationRuleDao).getById(1L);
    verify(flowClassificationRuleDao).update(isA(FlowClassificationRuleUpdateCommand.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(FlowClassificationRuleUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.update(FlowClassificationRuleUpdateCommand, String)"
  })
  void testUpdate5() {
    // Arrange
    when(flowClassificationRuleDao.update(Mockito.<FlowClassificationRuleUpdateCommand>any()))
        .thenReturn(1);

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(null)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build());
    when(flowClassificationDao.getById(anyLong()))
        .thenReturn(
            ImmutableFlowClassification.builder()
                .code("Code")
                .color("Color")
                .defaultMessage("Default Message")
                .description("The characteristics of someone or something")
                .direction(FlowDirection.INBOUND)
                .id(1L)
                .isCustom(true)
                .kind(EntityKind.ALL)
                .messageSeverity(MessageSeverity.NONE)
                .name("Name")
                .position(1)
                .userSelectable(true)
                .build());
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    int actualUpdateResult =
        flowClassificationRuleService.update(
            ImmutableFlowClassificationRuleUpdateCommand.builder()
                .classificationId(1L)
                .description("The characteristics of someone or something")
                .id(1L)
                .message("Not all who wander are lost")
                .severity(MessageSeverity.NONE)
                .build(),
            "janedoe");

    // Assert
    verify(actorDao).getById(1L);
    verify(flowClassificationDao).getById(1L);
    verify(flowClassificationRuleDao).getById(1L);
    verify(flowClassificationRuleDao).update(isA(FlowClassificationRuleUpdateCommand.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link NotFoundException#NotFoundException(String, String)} with {@code Code} and
   *       message is {@code An error occurred}.
   *   <li>Then calls {@link FlowClassificationRuleUpdateCommand#id()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(FlowClassificationRuleUpdateCommand, String); given NotFoundException(String, String) with 'Code' and message is 'An error occurred'; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.update(FlowClassificationRuleUpdateCommand, String)"
  })
  void testUpdate_givenNotFoundExceptionWithCodeAndMessageIsAnErrorOccurred_thenCallsId() {
    // Arrange
    when(flowClassificationRuleDao.update(Mockito.<FlowClassificationRuleUpdateCommand>any()))
        .thenReturn(1);

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build());
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
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    FlowClassificationRuleUpdateCommand command = mock(FlowClassificationRuleUpdateCommand.class);
    when(command.classificationId()).thenThrow(new NotFoundException("Code", "An error occurred"));
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> flowClassificationRuleService.update(command, "janedoe"));
    verify(actorDao).getById(1L);
    verify(dataTypeDao).getById(1L);
    verify(flowClassificationRuleDao).getById(1L);
    verify(flowClassificationRuleDao).update(isA(FlowClassificationRuleUpdateCommand.class));
    verify(command, atLeast(1)).id();
    verify(command).classificationId();
  }

  /**
   * Test {@link FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(FlowClassificationRuleUpdateCommand, String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.update(FlowClassificationRuleUpdateCommand, String)"
  })
  void testUpdate_thenReturnOne() {
    // Arrange
    when(flowClassificationRuleDao.update(Mockito.<FlowClassificationRuleUpdateCommand>any()))
        .thenReturn(1);

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build());
    when(flowClassificationDao.getById(anyLong()))
        .thenReturn(
            ImmutableFlowClassification.builder()
                .code("Code")
                .color("Color")
                .defaultMessage("Default Message")
                .description("The characteristics of someone or something")
                .direction(FlowDirection.INBOUND)
                .id(1L)
                .isCustom(true)
                .kind(EntityKind.ALL)
                .messageSeverity(MessageSeverity.NONE)
                .name("Name")
                .position(1)
                .userSelectable(true)
                .build());
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
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    int actualUpdateResult =
        flowClassificationRuleService.update(
            ImmutableFlowClassificationRuleUpdateCommand.builder()
                .classificationId(1L)
                .description("The characteristics of someone or something")
                .id(1L)
                .message("Not all who wander are lost")
                .severity(MessageSeverity.NONE)
                .build(),
            "janedoe");

    // Assert
    verify(actorDao).getById(1L);
    verify(dataTypeDao).getById(1L);
    verify(flowClassificationDao).getById(1L);
    verify(flowClassificationRuleDao).getById(1L);
    verify(flowClassificationRuleDao).update(isA(FlowClassificationRuleUpdateCommand.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#update(FlowClassificationRuleUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(FlowClassificationRuleUpdateCommand, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.update(FlowClassificationRuleUpdateCommand, String)"
  })
  void testUpdate_thenThrowIllegalArgumentException() {
    // Arrange
    when(flowClassificationRuleDao.update(Mockito.<FlowClassificationRuleUpdateCommand>any()))
        .thenReturn(1);

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
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
        IllegalArgumentException.class,
        () ->
            flowClassificationRuleService.update(
                ImmutableFlowClassificationRuleUpdateCommand.builder()
                    .classificationId(1L)
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .message("Not all who wander are lost")
                    .severity(MessageSeverity.NONE)
                    .build(),
                "janedoe"));
    verify(flowClassificationRuleDao).getById(1L);
    verify(flowClassificationRuleDao).update(isA(FlowClassificationRuleUpdateCommand.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}
   */
  @Test
  @DisplayName("Test insert(FlowClassificationRuleCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FlowClassificationRuleService.insert(FlowClassificationRuleCreateCommand, String)"
  })
  void testInsert() {
    // Arrange
    when(flowClassificationRuleDao.insert(
            Mockito.<FlowClassificationRuleCreateCommand>any(), Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> flowClassificationRuleService.insert(null, "janedoe"));
    verify(flowClassificationRuleDao).insert(isNull(), eq("janedoe"));
  }

  /**
   * Test {@link FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}
   */
  @Test
  @DisplayName("Test insert(FlowClassificationRuleCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FlowClassificationRuleService.insert(FlowClassificationRuleCreateCommand, String)"
  })
  void testInsert2() {
    // Arrange
    when(flowClassificationRuleDao.insert(
            Mockito.<FlowClassificationRuleCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(actorDao.getById(anyLong())).thenThrow(new NotFoundException("Code", "An error occurred"));

    ImmutableFlowClassificationRuleCreateCommand.Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    ImmutableFlowClassificationRuleCreateCommand.Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            flowClassificationRuleService.insert(
                severityResult
                    .subjectReference(
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
    verify(actorDao).getById(1L);
    verify(flowClassificationRuleDao)
        .insert(isA(FlowClassificationRuleCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}
   */
  @Test
  @DisplayName("Test insert(FlowClassificationRuleCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FlowClassificationRuleService.insert(FlowClassificationRuleCreateCommand, String)"
  })
  void testInsert3() {
    // Arrange
    when(flowClassificationRuleDao.insert(
            Mockito.<FlowClassificationRuleCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
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
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new NotFoundException("kind", "An error occurred"));

    ImmutableFlowClassificationRuleCreateCommand.Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    ImmutableFlowClassificationRuleCreateCommand.Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            flowClassificationRuleService.insert(
                severityResult
                    .subjectReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ACTOR)
                            .name("Name")
                            .build())
                    .build(),
                "janedoe"));
    verify(actorDao, atLeast(1)).getById(1L);
    verify(dataTypeDao).getById(1L);
    verify(flowClassificationRuleDao)
        .insert(isA(FlowClassificationRuleCreateCommand.class), eq("janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}
   */
  @Test
  @DisplayName("Test insert(FlowClassificationRuleCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FlowClassificationRuleService.insert(FlowClassificationRuleCreateCommand, String)"
  })
  void testInsert4() {
    // Arrange
    when(flowClassificationRuleDao.insert(
            Mockito.<FlowClassificationRuleCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ImmutableFlowClassificationRuleCreateCommand.Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(null)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    ImmutableFlowClassificationRuleCreateCommand.Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act
    long actualInsertResult =
        flowClassificationRuleService.insert(
            severityResult
                .subjectReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build(),
            "janedoe");

    // Assert
    verify(actorDao, atLeast(1)).getById(1L);
    verify(flowClassificationRuleDao)
        .insert(isA(FlowClassificationRuleCreateCommand.class), eq("janedoe"));
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertEquals(1L, actualInsertResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test insert(FlowClassificationRuleCreateCommand, String); given ChangeLogService write(ChangeLog) return '19088743'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FlowClassificationRuleService.insert(FlowClassificationRuleCreateCommand, String)"
  })
  void testInsert_givenChangeLogServiceWriteReturn19088743() {
    // Arrange
    when(flowClassificationRuleDao.insert(
            Mockito.<FlowClassificationRuleCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
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
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ImmutableFlowClassificationRuleCreateCommand.Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    ImmutableFlowClassificationRuleCreateCommand.Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act
    long actualInsertResult =
        flowClassificationRuleService.insert(
            severityResult
                .subjectReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build(),
            "janedoe");

    // Assert
    verify(actorDao, atLeast(1)).getById(1L);
    verify(dataTypeDao).getById(1L);
    verify(flowClassificationRuleDao)
        .insert(isA(FlowClassificationRuleCreateCommand.class), eq("janedoe"));
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertEquals(1L, actualInsertResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}
   */
  @Test
  @DisplayName("Test insert(FlowClassificationRuleCreateCommand, String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FlowClassificationRuleService.insert(FlowClassificationRuleCreateCommand, String)"
  })
  void testInsert_thenReturnOne() {
    // Arrange
    when(flowClassificationRuleDao.insert(
            Mockito.<FlowClassificationRuleCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
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
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    ImmutableFlowClassificationRuleCreateCommand.Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    ImmutableFlowClassificationRuleCreateCommand.Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act
    long actualInsertResult =
        flowClassificationRuleService.insert(
            severityResult
                .subjectReference(
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
    verify(actorDao).getById(1L);
    verify(dataTypeDao).getById(1L);
    verify(flowClassificationRuleDao)
        .insert(isA(FlowClassificationRuleCreateCommand.class), eq("janedoe"));
    assertEquals(1L, actualInsertResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test insert(FlowClassificationRuleCreateCommand, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FlowClassificationRuleService.insert(FlowClassificationRuleCreateCommand, String)"
  })
  void testInsert_thenThrowIllegalArgumentException() {
    // Arrange
    when(flowClassificationRuleDao.insert(
            Mockito.<FlowClassificationRuleCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    ImmutableFlowClassificationRuleCreateCommand.Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    ImmutableFlowClassificationRuleCreateCommand.Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            flowClassificationRuleService.insert(
                severityResult
                    .subjectReference(
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
    verify(flowClassificationRuleDao)
        .insert(isA(FlowClassificationRuleCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowClassificationRuleService#remove(long, String)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#remove(long, String)}
   */
  @Test
  @DisplayName("Test remove(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.remove(long, String)"})
  void testRemove() {
    // Arrange
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenThrow(new NotFoundException("ASRM-NF", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> flowClassificationRuleService.remove(1L, "janedoe"));
    verify(flowClassificationRuleDao).getById(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#remove(long, String)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#remove(long, String)}
   */
  @Test
  @DisplayName("Test remove(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.remove(long, String)"})
  void testRemove2() {
    // Arrange
    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build());
    when(actorDao.getById(anyLong())).thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> flowClassificationRuleService.remove(1L, "janedoe"));
    verify(actorDao).getById(1L);
    verify(flowClassificationRuleDao, atLeast(1)).getById(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#remove(long, String)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#remove(long, String)}
   */
  @Test
  @DisplayName("Test remove(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.remove(long, String)"})
  void testRemove3() {
    // Arrange
    when(flowClassificationRuleDao.remove(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build());
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
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> flowClassificationRuleService.remove(1L, "janedoe"));
    verify(actorDao).getById(1L);
    verify(dataTypeDao).getById(1L);
    verify(flowClassificationRuleDao, atLeast(1)).getById(1L);
    verify(flowClassificationRuleDao).remove(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#remove(long, String)}.
   *
   * <ul>
   *   <li>Given {@link FlowClassificationRuleDao} {@link FlowClassificationRuleDao#remove(long)}
   *       return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#remove(long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(long, String); given FlowClassificationRuleDao remove(long) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.remove(long, String)"})
  void testRemove_givenFlowClassificationRuleDaoRemoveReturnOne_thenReturnOne() {
    // Arrange
    when(flowClassificationRuleDao.remove(anyLong())).thenReturn(1);

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ACTOR)
                        .name("Name")
                        .build())
                .build());
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
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    int actualRemoveResult = flowClassificationRuleService.remove(1L, "janedoe");

    // Assert
    verify(actorDao).getById(1L);
    verify(dataTypeDao).getById(1L);
    verify(flowClassificationRuleDao, atLeast(1)).getById(1L);
    verify(flowClassificationRuleDao).remove(1L);
    assertEquals(1, actualRemoveResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#remove(long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#remove(long, String)}
   */
  @Test
  @DisplayName("Test remove(long, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.remove(long, String)"})
  void testRemove_thenThrowIllegalArgumentException() {
    // Arrange
    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flowClassificationRuleDao.getById(anyLong()))
        .thenReturn(
            subjectReferenceResult
                .vantagePointReference(
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
        IllegalArgumentException.class, () -> flowClassificationRuleService.remove(1L, "janedoe"));
    verify(flowClassificationRuleDao, atLeast(1)).getById(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#findAll()}.
   *
   * <ul>
   *   <li>Given {@link FlowClassificationRuleDao} {@link FlowClassificationRuleDao#findAll()}
   *       return {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given FlowClassificationRuleDao findAll() return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleService.findAll()"})
  void testFindAll_givenFlowClassificationRuleDaoFindAllReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(flowClassificationRuleDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<FlowClassificationRule> actualFindAllResult = flowClassificationRuleService.findAll();

    // Assert
    verify(flowClassificationRuleDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findAll()}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleService.findAll()"})
  void testFindAll_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.findAll())
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> flowClassificationRuleService.findAll());
    verify(flowClassificationRuleDao).findAll();
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenThrow(new NotFoundException("options cannot be null", "An error occurred"));
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isNull(), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector2() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector3() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector4() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(flowDataTypeSet);

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector5() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector6() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

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
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao3,
            entityHierarchyDao2,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao2,
            organisationalUnitDao2,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            logicalFlowDecoratorDao,
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector7() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

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
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao3,
            entityHierarchyDao2,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao2,
            organisationalUnitDao2,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            logicalFlowDecoratorDao,
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector_givenActive() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector_givenInHouse() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test recalculateFlowRatingsForSelector(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector_givenPending() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test recalculateFlowRatingsForSelector(IdSelectionOptions); then calls fetchHierarchyForKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector_thenCallsFetchHierarchyForKind() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateFlowRatingsForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test recalculateFlowRatingsForSelector(IdSelectionOptions); then calls fetchHierarchyForKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FlowClassificationRuleService.recalculateFlowRatingsForSelector(IdSelectionOptions)"
  })
  void testRecalculateFlowRatingsForSelector_thenCallsFetchHierarchyForKind2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulationForFlowSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao3,
            entityHierarchyDao2,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao2,
            organisationalUnitDao2,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            logicalFlowDecoratorDao,
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

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
    int actualRecalculateFlowRatingsForSelectorResult =
        flowClassificationRuleService.recalculateFlowRatingsForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulationForFlowSelector(isA(Select.class));
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualRecalculateFlowRatingsForSelectorResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings2() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenThrow(
            new NotFoundException("Loading decorator population points", "An error occurred"));
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isNull(), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings3() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings4() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings5() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings6() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings7() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings8() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings9() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings10() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(2L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings11() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(null)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings12() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(null);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings13() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(2L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings14() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings15() {
    // Arrange
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
            .dataTypeId(null)
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings16() {
    // Arrange
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
                    .id(2L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> flowDataTypeSet = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowDataTypeSet.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(flowDataTypeSet);

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings17() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

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
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao3,
            entityHierarchyDao2,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao2,
            organisationalUnitDao2,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            logicalFlowDecoratorDao,
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings18() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

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
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao3,
            entityHierarchyDao2,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao2,
            organisationalUnitDao2,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            logicalFlowDecoratorDao,
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <ul>
   *   <li>Then calls {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings(); then calls fetchHierarchyForKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings_thenCallsFetchHierarchyForKind() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao3,
            entityHierarchyDao2,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao2,
            organisationalUnitDao2,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            logicalFlowDecoratorDao,
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

    // Act
    int actualFastRecalculateAllFlowRatingsResult =
        flowClassificationRuleService.fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  @DisplayName("Test fastRecalculateAllFlowRatings(); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.fastRecalculateAllFlowRatings()"})
  void testFastRecalculateAllFlowRatings_thenThrowNotFoundException() {
    // Arrange
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenThrow(
            new NotFoundException("Loading decorator population points", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> flowClassificationRuleService.fastRecalculateAllFlowRatings());
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenThrow(new NotFoundException("Loading hierarchies", "An error occurred"));

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isNull(), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation2() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation3() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation4() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation5() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation6() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation7() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(2L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation8() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(null)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation9() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(null);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation10() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(2L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation11() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation12() {
    // Arrange
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
            .dataTypeId(null)
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation13() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

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
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao3,
            entityHierarchyDao2,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao2,
            organisationalUnitDao2,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            mock(LogicalFlowDecoratorDao.class),
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation14() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

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
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao3,
            entityHierarchyDao2,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao2,
            organisationalUnitDao2,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            mock(LogicalFlowDecoratorDao.class),
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation15() {
    // Arrange
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
                    .id(2L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    EntityHierarchyService entityHierarchyService = mock(EntityHierarchyService.class);
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao2,
            entityHierarchyDao,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao,
            organisationalUnitDao,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            mock(LogicalFlowDecoratorDao.class),
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation16() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    EntityHierarchyService entityHierarchyService = mock(EntityHierarchyService.class);
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(builderResult.build());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao2,
            entityHierarchyDao,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao,
            organisationalUnitDao,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            mock(LogicalFlowDecoratorDao.class),
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(2L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(population);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <ul>
   *   <li>Given {@link FlowClassificationDao}.
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName(
      "Test recalculateRatingsForPopulation(Set); given FlowClassificationDao; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation_givenFlowClassificationDao_whenHashSet() {
    // Arrange
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName(
      "Test recalculateRatingsForPopulation(Set); then calls fetchHierarchyForKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation_thenCallsFetchHierarchyForKind() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(new ArrayList<>());

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
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
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao3,
            entityHierarchyDao2,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
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

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao2,
            organisationalUnitDao2,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService2,
            entityHierarchyService,
            mock(LogicalFlowDecoratorDao.class),
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenThrow(new NotFoundException("Loading hierarchies", "An error occurred"));
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> flowClassificationRuleService.recalculateRatingsForPopulation(new HashSet<>()));
    verify(flowClassificationRuleDao)
        .findFlowClassificationRuleVantagePoints(
            eq(FlowDirection.INBOUND), isA(EntityHierarchy.class), isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation_whenHashSet() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  @DisplayName("Test recalculateRatingsForPopulation(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleService.recalculateRatingsForPopulation(Set)"})
  void testRecalculateRatingsForPopulation_whenHashSet2() {
    // Arrange
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
    when(flowClassificationRuleDao.updateDecoratorsWithClassifications(
            Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
        .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(),
            Mockito.<EntityHierarchy>any(),
            Mockito.<Set<FlowDataType>>any()))
        .thenReturn(flowClassificationRuleVantagePointList);
    when(entityHierarchyService.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(ImmutableEntityHierarchy.builder().build());

    // Act
    int actualRecalculateRatingsForPopulationResult =
        flowClassificationRuleService.recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(flowClassificationRuleDao, atLeast(1))
        .findFlowClassificationRuleVantagePoints(
            Mockito.<FlowDirection>any(), isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(entityHierarchyService, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#cleanupOrphans(String)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  @DisplayName("Test cleanupOrphans(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer FlowClassificationRuleService.cleanupOrphans(String)"})
  void testCleanupOrphans() {
    // Arrange
    when(flowClassificationRuleDao.cleanupOrphans())
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> flowClassificationRuleService.cleanupOrphans("42"));
    verify(flowClassificationRuleDao).cleanupOrphans();
  }

  /**
   * Test {@link FlowClassificationRuleService#cleanupOrphans(String)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  @DisplayName("Test cleanupOrphans(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer FlowClassificationRuleService.cleanupOrphans(String)"})
  void testCleanupOrphans2() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(
            new NotFoundException(
                "Application removed as an flow classification rule source as it no longer exists",
                "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> flowClassificationRuleService.cleanupOrphans("42"));
    verify(flowClassificationRuleDao).cleanupOrphans();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#cleanupOrphans(String)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  @DisplayName("Test cleanupOrphans(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer FlowClassificationRuleService.cleanupOrphans(String)"})
  void testCleanupOrphans3() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.APPLICATION)
            .name("Name")
            .build());
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Integer actualCleanupOrphansResult = flowClassificationRuleService.cleanupOrphans("42");

    // Assert
    verify(flowClassificationRuleDao).cleanupOrphans();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualCleanupOrphansResult.intValue());
  }

  /**
   * Test {@link FlowClassificationRuleService#cleanupOrphans(String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  @DisplayName(
      "Test cleanupOrphans(String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer FlowClassificationRuleService.cleanupOrphans(String)"})
  void testCleanupOrphans_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);

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
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao2,
            entityHierarchyDao,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao3,
            entityHierarchyDao2,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao2,
            personHierarchyService,
            mock(PersonDao.class));

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao,
            organisationalUnitDao,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService,
            entityHierarchyService,
            mock(LogicalFlowDecoratorDao.class),
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));

    // Act
    Integer actualCleanupOrphansResult = flowClassificationRuleService.cleanupOrphans("42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowClassificationRuleDao).cleanupOrphans();
    assertEquals(1, actualCleanupOrphansResult.intValue());
  }

  /**
   * Test {@link FlowClassificationRuleService#cleanupOrphans(String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  @DisplayName("Test cleanupOrphans(String); given ChangeLogService; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer FlowClassificationRuleService.cleanupOrphans(String)"})
  void testCleanupOrphans_givenChangeLogService_thenReturnIntValueIsZero() {
    // Arrange
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(new HashSet<>());

    // Act
    Integer actualCleanupOrphansResult = flowClassificationRuleService.cleanupOrphans("42");

    // Assert
    verify(flowClassificationRuleDao).cleanupOrphans();
    assertEquals(0, actualCleanupOrphansResult.intValue());
  }

  /**
   * Test {@link FlowClassificationRuleService#cleanupOrphans(String)}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  @DisplayName("Test cleanupOrphans(String); then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer FlowClassificationRuleService.cleanupOrphans(String)"})
  void testCleanupOrphans_thenReturnIntValueIsOne() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Integer actualCleanupOrphansResult = flowClassificationRuleService.cleanupOrphans("42");

    // Assert
    verify(flowClassificationRuleDao).cleanupOrphans();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualCleanupOrphansResult.intValue());
  }

  /**
   * Test {@link FlowClassificationRuleService#cleanupOrphans(String)}.
   *
   * <ul>
   *   <li>Then return intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  @DisplayName("Test cleanupOrphans(String); then return intValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer FlowClassificationRuleService.cleanupOrphans(String)"})
  void testCleanupOrphans_thenReturnIntValueIsTwo() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceSet.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.APPLICATION)
            .name("Name")
            .build());
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Integer actualCleanupOrphansResult = flowClassificationRuleService.cleanupOrphans("42");

    // Assert
    verify(flowClassificationRuleDao).cleanupOrphans();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertEquals(2, actualCleanupOrphansResult.intValue());
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources() {
    // Arrange
    when(flowClassificationRuleDao.findDiscouragedSourcesBySelector(Mockito.<Condition>any()))
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
    List<DiscouragedSource> actualFindDiscouragedSourcesResult =
        flowClassificationRuleService.findDiscouragedSources(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findDiscouragedSourcesBySelector(isA(Condition.class));
    assertTrue(actualFindDiscouragedSourcesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources2() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowClassificationRuleService.findDiscouragedSources(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources3() {
    // Arrange
    when(flowClassificationRuleDao.findDiscouragedSourcesBySelector(Mockito.<Condition>any()))
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
    List<DiscouragedSource> actualFindDiscouragedSourcesResult =
        flowClassificationRuleService.findDiscouragedSources(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findDiscouragedSourcesBySelector(isA(Condition.class));
    assertTrue(actualFindDiscouragedSourcesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources4() {
    // Arrange
    when(flowClassificationRuleDao.findDiscouragedSourcesBySelector(Mockito.<Condition>any()))
        .thenReturn(new ArrayList<>());

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<DiscouragedSource> actualFindDiscouragedSourcesResult =
        flowClassificationRuleService.findDiscouragedSources(
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findDiscouragedSourcesBySelector(isA(Condition.class));
    assertTrue(actualFindDiscouragedSourcesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources5() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowClassificationRuleService.findDiscouragedSources(
                joiningEntityKindResult
                    .addAllApplicationKinds(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources_givenActive() {
    // Arrange
    when(flowClassificationRuleDao.findDiscouragedSourcesBySelector(Mockito.<Condition>any()))
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
    List<DiscouragedSource> actualFindDiscouragedSourcesResult =
        flowClassificationRuleService.findDiscouragedSources(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findDiscouragedSourcesBySelector(isA(Condition.class));
    assertTrue(actualFindDiscouragedSourcesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources_givenInHouse() {
    // Arrange
    when(flowClassificationRuleDao.findDiscouragedSourcesBySelector(Mockito.<Condition>any()))
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
    List<DiscouragedSource> actualFindDiscouragedSourcesResult =
        flowClassificationRuleService.findDiscouragedSources(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findDiscouragedSourcesBySelector(isA(Condition.class));
    assertTrue(actualFindDiscouragedSourcesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources_givenInHouse2() {
    // Arrange
    when(flowClassificationRuleDao.findDiscouragedSourcesBySelector(Mockito.<Condition>any()))
        .thenReturn(new ArrayList<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    ImmutableApplicationIdSelectionOptions.Builder builderResult2 =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<DiscouragedSource> actualFindDiscouragedSourcesResult =
        flowClassificationRuleService.findDiscouragedSources(
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findDiscouragedSourcesBySelector(isA(Condition.class));
    assertTrue(actualFindDiscouragedSourcesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources_givenPending() {
    // Arrange
    when(flowClassificationRuleDao.findDiscouragedSourcesBySelector(Mockito.<Condition>any()))
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
    List<DiscouragedSource> actualFindDiscouragedSourcesResult =
        flowClassificationRuleService.findDiscouragedSources(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findDiscouragedSourcesBySelector(isA(Condition.class));
    assertTrue(actualFindDiscouragedSourcesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findDiscouragedSources(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findDiscouragedSources(IdSelectionOptions); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleService.findDiscouragedSources(IdSelectionOptions)"
  })
  void testFindDiscouragedSources_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.findDiscouragedSourcesBySelector(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("options cannot be null", "An error occurred"));

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

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            flowClassificationRuleService.findDiscouragedSources(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(flowClassificationRuleDao).findDiscouragedSourcesBySelector(isA(Condition.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

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
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        flowClassificationRuleService.findClassificationRules(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules2() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

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

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            flowClassificationRuleService.findClassificationRules(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules3() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

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
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        flowClassificationRuleService.findClassificationRules(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules4() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.AGGREGATE_OVERLAY_DIAGRAM)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowClassificationRuleService.findClassificationRules(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules5() {
    // Arrange
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new NotFoundException("Code", "An error occurred"));
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> flowClassificationRuleService.findClassificationRules(options));
    verify(options).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules6() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());

    // Act
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        flowClassificationRuleService.findClassificationRules(options);

    // Assert
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules7() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());

    // Act
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        flowClassificationRuleService.findClassificationRules(options);

    // Assert
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules8() {
    // Arrange
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.AGGREGATE_OVERLAY_DIAGRAM)
                .name("Name")
                .build());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowClassificationRuleService.findClassificationRules(options));
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findClassificationRules(IdSelectionOptions); given builder addOmitApplicationKinds 'INTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules_givenBuilderAddOmitApplicationKindsInternallyHosted() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    when(options.filters()).thenReturn(immutableSelectionFilters);

    // Act
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        flowClassificationRuleService.findClassificationRules(options);

    // Assert
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules_givenHashSetAddActive() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());

    // Act
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        flowClassificationRuleService.findClassificationRules(options);

    // Assert
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findClassificationRules(IdSelectionOptions); given HashSet(); then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules_givenHashSet_thenCallsEntityLifecycleStatuses() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());

    // Act
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        flowClassificationRuleService.findClassificationRules(options);

    // Assert
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules_givenInHouse() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

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
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        flowClassificationRuleService.findClassificationRules(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findClassificationRules(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findClassificationRules(IdSelectionOptions); given 'INTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findClassificationRules(IdSelectionOptions)"
  })
  void testFindClassificationRules_givenInternallyHosted() {
    // Arrange
    when(flowClassificationRuleDao.findClassificationRules(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
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
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        flowClassificationRuleService.findClassificationRules(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowClassificationRuleDao).findClassificationRules(isA(Condition.class));
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#multiLog(String, Long, EntityReference, Optional,
   * EntityReference, String, Operation)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#multiLog(String, Long,
   * EntityReference, Optional, EntityReference, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test multiLog(String, Long, EntityReference, Optional, EntityReference, String, Operation); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FlowClassificationRuleService.multiLog(String, Long, EntityReference, Optional, EntityReference, String, Operation)"
  })
  void testMultiLog_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
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
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    LogicalFlowDecoratorRatingsCalculator ratingsCalculator =
        new LogicalFlowDecoratorRatingsCalculator(
            applicationService, flowClassificationRuleDao2, logicalFlowDao, dataTypeService);

    FlowClassificationCalculator ratingCalculator =
        new FlowClassificationCalculator(
            dataTypeDao2,
            entityHierarchyDao,
            ratingsCalculator,
            mock(LogicalFlowDecoratorDao.class));
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao3,
            entityHierarchyDao2,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao2,
            personHierarchyService,
            mock(PersonDao.class));

    FlowClassificationRuleService flowClassificationRuleService =
        new FlowClassificationRuleService(
            flowClassificationRuleDao,
            flowClassificationDao,
            dataTypeDao,
            organisationalUnitDao,
            applicationDao,
            actorDao,
            ratingCalculator,
            changeLogService,
            entityHierarchyService,
            mock(LogicalFlowDecoratorDao.class),
            mock(EndUserAppDao.class),
            mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class));
    ImmutableEntityReference parentRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<DataType> dataType = Optional.of(immutableDataType);

    // Act
    flowClassificationRuleService.multiLog(
        "janedoe",
        1L,
        parentRef,
        dataType,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "Msg",
        Operation.ADD);

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
  }

  /**
   * Test {@link FlowClassificationRuleService#multiLog(String, Long, EntityReference, Optional,
   * EntityReference, String, Operation)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#multiLog(String, Long,
   * EntityReference, Optional, EntityReference, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test multiLog(String, Long, EntityReference, Optional, EntityReference, String, Operation); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FlowClassificationRuleService.multiLog(String, Long, EntityReference, Optional, EntityReference, String, Operation)"
  })
  void testMultiLog_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ImmutableEntityReference parentRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<DataType> dataType = Optional.of(immutableDataType);

    // Act
    flowClassificationRuleService.multiLog(
        "janedoe",
        1L,
        parentRef,
        dataType,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "Msg",
        Operation.ADD);

    // Assert
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
  }

  /**
   * Test {@link FlowClassificationRuleService#multiLog(String, Long, EntityReference, Optional,
   * EntityReference, String, Operation)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>When empty.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#multiLog(String, Long,
   * EntityReference, Optional, EntityReference, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test multiLog(String, Long, EntityReference, Optional, EntityReference, String, Operation); given ChangeLogService write(ChangeLog) return '19088743'; when empty; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FlowClassificationRuleService.multiLog(String, Long, EntityReference, Optional, EntityReference, String, Operation)"
  })
  void testMultiLog_givenChangeLogServiceWriteReturn19088743_whenEmpty_thenCallsWrite() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ImmutableEntityReference parentRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<DataType> dataType = Optional.empty();

    // Act
    flowClassificationRuleService.multiLog(
        "janedoe",
        1L,
        parentRef,
        dataType,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "Msg",
        Operation.ADD);

    // Assert
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
  }

  /**
   * Test {@link FlowClassificationRuleService#multiLog(String, Long, EntityReference, Optional,
   * EntityReference, String, Operation)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#multiLog(String, Long,
   * EntityReference, Optional, EntityReference, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test multiLog(String, Long, EntityReference, Optional, EntityReference, String, Operation); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FlowClassificationRuleService.multiLog(String, Long, EntityReference, Optional, EntityReference, String, Operation)"
  })
  void testMultiLog_thenThrowNotFoundException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new NotFoundException("message", "An error occurred"));
    ImmutableEntityReference parentRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<DataType> dataType = Optional.of(immutableDataType);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            flowClassificationRuleService.multiLog(
                "janedoe",
                1L,
                parentRef,
                dataType,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Msg",
                Operation.ADD));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link FlowClassificationRuleService#findCompanionEntityRules(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findCompanionEntityRules(long)}
   */
  @Test
  @DisplayName("Test findCompanionEntityRules(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationRuleService.findCompanionEntityRules(long)"})
  void testFindCompanionEntityRules_thenReturnEmpty() {
    // Arrange
    when(flowClassificationRuleDao.findCompanionEntityRules(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<FlowClassificationRule> actualFindCompanionEntityRulesResult =
        flowClassificationRuleService.findCompanionEntityRules(1L);

    // Assert
    verify(flowClassificationRuleDao).findCompanionEntityRules(1L);
    assertTrue(actualFindCompanionEntityRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findCompanionEntityRules(long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findCompanionEntityRules(long)}
   */
  @Test
  @DisplayName("Test findCompanionEntityRules(long); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationRuleService.findCompanionEntityRules(long)"})
  void testFindCompanionEntityRules_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.findCompanionEntityRules(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> flowClassificationRuleService.findCompanionEntityRules(1L));
    verify(flowClassificationRuleDao).findCompanionEntityRules(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#findCompanionDataTypeRules(long)}.
   *
   * <ul>
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findCompanionDataTypeRules(long)}
   */
  @Test
  @DisplayName("Test findCompanionDataTypeRules(long); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FlowClassificationRuleService.findCompanionDataTypeRules(long)"})
  void testFindCompanionDataTypeRules_thenReturnSet() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    when(flowClassificationRuleDao.findCompanionDataTypeRules(anyLong()))
        .thenReturn(flowClassificationRuleSet);

    // Act
    Collection<FlowClassificationRule> actualFindCompanionDataTypeRulesResult =
        flowClassificationRuleService.findCompanionDataTypeRules(1L);

    // Assert
    verify(flowClassificationRuleDao).findCompanionDataTypeRules(1L);
    assertTrue(actualFindCompanionDataTypeRulesResult instanceof Set);
    assertTrue(actualFindCompanionDataTypeRulesResult.isEmpty());
    assertSame(flowClassificationRuleSet, actualFindCompanionDataTypeRulesResult);
  }

  /**
   * Test {@link FlowClassificationRuleService#findCompanionDataTypeRules(long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleService#findCompanionDataTypeRules(long)}
   */
  @Test
  @DisplayName("Test findCompanionDataTypeRules(long); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FlowClassificationRuleService.findCompanionDataTypeRules(long)"})
  void testFindCompanionDataTypeRules_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.findCompanionDataTypeRules(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> flowClassificationRuleService.findCompanionDataTypeRules(1L));
    verify(flowClassificationRuleDao).findCompanionDataTypeRules(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#findAppliedClassificationRulesForFlow(Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findAppliedClassificationRulesForFlow(Long)}
   */
  @Test
  @DisplayName("Test findAppliedClassificationRulesForFlow(Long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findAppliedClassificationRulesForFlow(Long)"
  })
  void testFindAppliedClassificationRulesForFlow_thenReturnEmpty() {
    // Arrange
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<FlowClassificationRule> actualFindAppliedClassificationRulesForFlowResult =
        flowClassificationRuleService.findAppliedClassificationRulesForFlow(1L);

    // Assert
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
    assertTrue(actualFindAppliedClassificationRulesForFlowResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleService#findAppliedClassificationRulesForFlow(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#findAppliedClassificationRulesForFlow(Long)}
   */
  @Test
  @DisplayName("Test findAppliedClassificationRulesForFlow(Long); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowClassificationRuleService.findAppliedClassificationRulesForFlow(Long)"
  })
  void testFindAppliedClassificationRulesForFlow_thenThrowNotFoundException() {
    // Arrange
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> flowClassificationRuleService.findAppliedClassificationRulesForFlow(1L));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  @DisplayName("Test getFlowClassificationsViewForFlow(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRulesView FlowClassificationRuleService.getFlowClassificationsViewForFlow(long)"
  })
  void testGetFlowClassificationsViewForFlow() {
    // Arrange
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> flowClassificationRuleService.getFlowClassificationsViewForFlow(1L));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  @DisplayName("Test getFlowClassificationsViewForFlow(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRulesView FlowClassificationRuleService.getFlowClassificationsViewForFlow(long)"
  })
  void testGetFlowClassificationsViewForFlow2() {
    // Arrange
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> flowClassificationRuleService.getFlowClassificationsViewForFlow(1L));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  @DisplayName("Test getFlowClassificationsViewForFlow(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRulesView FlowClassificationRuleService.getFlowClassificationsViewForFlow(long)"
  })
  void testGetFlowClassificationsViewForFlow3() {
    // Arrange
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    // Act
    FlowClassificationRulesView actualFlowClassificationsViewForFlow =
        flowClassificationRuleService.getFlowClassificationsViewForFlow(1L);

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
    assertTrue(
        actualFlowClassificationsViewForFlow instanceof ImmutableFlowClassificationRulesView);
    Set<DataType> dataTypesResult = actualFlowClassificationsViewForFlow.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFlowClassificationsViewForFlow.flowClassificationRules());
    assertSame(dataTypesResult, actualFlowClassificationsViewForFlow.flowClassifications());
  }

  /**
   * Test {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  @DisplayName("Test getFlowClassificationsViewForFlow(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRulesView FlowClassificationRuleService.getFlowClassificationsViewForFlow(long)"
  })
  void testGetFlowClassificationsViewForFlow4() {
    // Arrange
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> flowClassificationRuleService.getFlowClassificationsViewForFlow(1L));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
  }

  /**
   * Test {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  @DisplayName("Test getFlowClassificationsViewForFlow(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRulesView FlowClassificationRuleService.getFlowClassificationsViewForFlow(long)"
  })
  void testGetFlowClassificationsViewForFlow5() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleSet.add(
        subjectReferenceResult
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    ImmutableFlowClassificationRule.Builder provenanceResult2 =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult2 =
        provenanceResult2.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult2 =
        subjectOrgUnitReferenceResult2.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleSet.add(
        subjectReferenceResult2
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(flowClassificationRuleSet);
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    // Act
    FlowClassificationRulesView actualFlowClassificationsViewForFlow =
        flowClassificationRuleService.getFlowClassificationsViewForFlow(1L);

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
    assertTrue(
        actualFlowClassificationsViewForFlow instanceof ImmutableFlowClassificationRulesView);
    Set<DataType> dataTypesResult = actualFlowClassificationsViewForFlow.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFlowClassificationsViewForFlow.flowClassifications());
  }

  /**
   * Test {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}.
   *
   * <ul>
   *   <li>Then return dataTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  @DisplayName("Test getFlowClassificationsViewForFlow(long); then return dataTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRulesView FlowClassificationRuleService.getFlowClassificationsViewForFlow(long)"
  })
  void testGetFlowClassificationsViewForFlow_thenReturnDataTypesSizeIsOne() {
    // Arrange
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

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

    // Act
    FlowClassificationRulesView actualFlowClassificationsViewForFlow =
        flowClassificationRuleService.getFlowClassificationsViewForFlow(1L);

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
    assertTrue(
        actualFlowClassificationsViewForFlow instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualFlowClassificationsViewForFlow.dataTypes().size());
    Set<FlowClassificationRule> flowClassificationRulesResult =
        actualFlowClassificationsViewForFlow.flowClassificationRules();
    assertTrue(flowClassificationRulesResult.isEmpty());
    assertSame(
        flowClassificationRulesResult, actualFlowClassificationsViewForFlow.flowClassifications());
  }

  /**
   * Test {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}.
   *
   * <ul>
   *   <li>Then return dataTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  @DisplayName("Test getFlowClassificationsViewForFlow(long); then return dataTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRulesView FlowClassificationRuleService.getFlowClassificationsViewForFlow(long)"
  })
  void testGetFlowClassificationsViewForFlow_thenReturnDataTypesSizeIsOne2() {
    // Arrange
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

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

    // Act
    FlowClassificationRulesView actualFlowClassificationsViewForFlow =
        flowClassificationRuleService.getFlowClassificationsViewForFlow(1L);

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
    assertTrue(
        actualFlowClassificationsViewForFlow instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualFlowClassificationsViewForFlow.dataTypes().size());
    Set<FlowClassificationRule> flowClassificationRulesResult =
        actualFlowClassificationsViewForFlow.flowClassificationRules();
    assertTrue(flowClassificationRulesResult.isEmpty());
    assertSame(
        flowClassificationRulesResult, actualFlowClassificationsViewForFlow.flowClassifications());
  }

  /**
   * Test {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}.
   *
   * <ul>
   *   <li>Then return flowClassificationRules size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  @DisplayName(
      "Test getFlowClassificationsViewForFlow(long); then return flowClassificationRules size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRulesView FlowClassificationRuleService.getFlowClassificationsViewForFlow(long)"
  })
  void testGetFlowClassificationsViewForFlow_thenReturnFlowClassificationRulesSizeIsOne() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleSet.add(
        subjectReferenceResult
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(flowClassificationRuleSet);
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    // Act
    FlowClassificationRulesView actualFlowClassificationsViewForFlow =
        flowClassificationRuleService.getFlowClassificationsViewForFlow(1L);

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
    assertTrue(
        actualFlowClassificationsViewForFlow instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualFlowClassificationsViewForFlow.flowClassificationRules().size());
    Set<DataType> dataTypesResult = actualFlowClassificationsViewForFlow.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFlowClassificationsViewForFlow.flowClassifications());
  }

  /**
   * Test {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}.
   *
   * <ul>
   *   <li>Then return flowClassifications size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  @DisplayName(
      "Test getFlowClassificationsViewForFlow(long); then return flowClassifications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRulesView FlowClassificationRuleService.getFlowClassificationsViewForFlow(long)"
  })
  void testGetFlowClassificationsViewForFlow_thenReturnFlowClassificationsSizeIsOne() {
    // Arrange
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any()))
        .thenReturn(flowClassificationSet);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    // Act
    FlowClassificationRulesView actualFlowClassificationsViewForFlow =
        flowClassificationRuleService.getFlowClassificationsViewForFlow(1L);

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(1L);
    assertTrue(
        actualFlowClassificationsViewForFlow instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualFlowClassificationsViewForFlow.flowClassifications().size());
    Set<DataType> dataTypesResult = actualFlowClassificationsViewForFlow.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFlowClassificationsViewForFlow.flowClassificationRules());
  }
}
