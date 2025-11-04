package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.FlowDataType;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchy;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleCreateCommand;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.model.logical_flow.FlowClassificationRulesView;
import org.finos.waltz.model.logical_flow.ImmutableFlowClassificationRulesView;
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
import org.jooq.SQLDialect;
import org.jooq.UpdateConditionStep;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowClassificationRuleServiceDiffblueTest {
  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findByEntityKind(EntityKind)}
   */
  @Test
  void testFindByEntityKind() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    ArrayList<FlowClassificationRule> flowClassificationRuleList = new ArrayList<>();
    when(flowClassificationRuleDao.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(flowClassificationRuleList);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    List<FlowClassificationRule> actualFindByEntityKindResult = (new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao,
        ratingCalculator, changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).findByEntityKind(EntityKind.ALL);

    // Assert
    verify(flowClassificationRuleDao).findByEntityKind(eq(EntityKind.ALL));
    assertTrue(actualFindByEntityKindResult.isEmpty());
    assertSame(flowClassificationRuleList, actualFindByEntityKindResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findByEntityKind(EntityKind)}
   */
  @Test
  void testFindByEntityKind2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).findByEntityKind(EntityKind.ALL));
    verify(flowClassificationRuleDao).findByEntityKind(eq(EntityKind.ALL));
  }

  /**
   * Method under test: {@link FlowClassificationRuleService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.getById(anyLong())).thenReturn(null);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    FlowClassificationRule actualById = (new FlowClassificationRuleService(flowClassificationRuleDao,
        flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao, ratingCalculator,
        changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).getById(1L);

    // Assert
    verify(flowClassificationRuleDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link FlowClassificationRuleService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.getById(anyLong())).thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).getById(1L));
    verify(flowClassificationRuleDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    ArrayList<FlowClassificationRule> flowClassificationRuleList = new ArrayList<>();
    when(flowClassificationRuleDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(flowClassificationRuleList);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    List<FlowClassificationRule> actualFindByEntityReferenceResult = (new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao,
        ratingCalculator, changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).findByEntityReference(null);

    // Assert
    verify(flowClassificationRuleDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(flowClassificationRuleList, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).findByEntityReference(null));
    verify(flowClassificationRuleDao).findByEntityReference(isNull());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findByApplicationId(long)}
   */
  @Test
  void testFindByApplicationId() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    ArrayList<FlowClassificationRule> flowClassificationRuleList = new ArrayList<>();
    when(flowClassificationRuleDao.findByApplicationId(anyLong())).thenReturn(flowClassificationRuleList);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    List<FlowClassificationRule> actualFindByApplicationIdResult = (new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao,
        ratingCalculator, changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).findByApplicationId(1L);

    // Assert
    verify(flowClassificationRuleDao).findByApplicationId(eq(1L));
    assertTrue(actualFindByApplicationIdResult.isEmpty());
    assertSame(flowClassificationRuleList, actualFindByApplicationIdResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findByApplicationId(long)}
   */
  @Test
  void testFindByApplicationId2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findByApplicationId(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).findByApplicationId(1L));
    verify(flowClassificationRuleDao).findByApplicationId(eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#insert(FlowClassificationRuleCreateCommand, String)}
   */
  @Test
  void testInsert() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.insert(Mockito.<FlowClassificationRuleCreateCommand>any(), Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).insert(null, "janedoe"));
    verify(flowClassificationRuleDao).insert(isNull(), eq("janedoe"));
  }

  /**
   * Method under test: {@link FlowClassificationRuleService#remove(long, String)}
   */
  @Test
  void testRemove() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.getById(anyLong())).thenReturn(null);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).remove(1L, "janedoe"));
    verify(flowClassificationRuleDao).getById(eq(1L));
  }

  /**
   * Method under test: {@link FlowClassificationRuleService#remove(long, String)}
   */
  @Test
  void testRemove2() {
    // Arrange
    FlowClassificationRule flowClassificationRule = mock(FlowClassificationRule.class);
    when(flowClassificationRule.vantagePointReference()).thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.getById(anyLong())).thenReturn(flowClassificationRule);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).remove(1L, "janedoe"));
    verify(flowClassificationRuleDao, atLeast(1)).getById(eq(1L));
    verify(flowClassificationRule).vantagePointReference();
  }

  /**
   * Method under test: {@link FlowClassificationRuleService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    ArrayList<FlowClassificationRule> flowClassificationRuleList = new ArrayList<>();
    when(flowClassificationRuleDao.findAll()).thenReturn(flowClassificationRuleList);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    List<FlowClassificationRule> actualFindAllResult = (new FlowClassificationRuleService(flowClassificationRuleDao,
        flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao, ratingCalculator,
        changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).findAll();

    // Assert
    verify(flowClassificationRuleDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(flowClassificationRuleList, actualFindAllResult);
  }

  /**
   * Method under test: {@link FlowClassificationRuleService#findAll()}
   */
  @Test
  void testFindAll2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findAll()).thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).findAll());
    verify(flowClassificationRuleDao).findAll();
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  void testFastRecalculateAllFlowRatings() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao
        .updateDecoratorsWithClassifications(Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
            .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<EntityHierarchy>any(), Mockito.<Set<FlowDataType>>any())).thenReturn(new ArrayList<>());
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    EntityHierarchyService entityHierarchyService = new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao,
        entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any())).thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao3, entityHierarchyDao2,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    // Act
    int actualFastRecalculateAllFlowRatingsResult = (new FlowClassificationRuleService(flowClassificationRuleDao,
        flowClassificationDao, dataTypeDao2, organisationalUnitDao2, applicationDao, actorDao, ratingCalculator,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        entityHierarchyService, logicalFlowDecoratorDao, mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1)).findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  void testFastRecalculateAllFlowRatings2() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Loading decorator population points", "An error occurred"));
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
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            logicalFlowDecoratorDao, mock(EndUserAppDao.class), mock(AppGroupEntryDao.class), mock(AppGroupDao.class)))
                .fastRecalculateAllFlowRatings());
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  void testFastRecalculateAllFlowRatings3() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.ruleId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.classificationCode()).thenReturn("Classification Code");
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao
        .updateDecoratorsWithClassifications(Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
            .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<EntityHierarchy>any(), Mockito.<Set<FlowDataType>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    EntityHierarchyService entityHierarchyService = new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao,
        entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any())).thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao3, entityHierarchyDao2,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    // Act
    int actualFastRecalculateAllFlowRatingsResult = (new FlowClassificationRuleService(flowClassificationRuleDao,
        flowClassificationDao, dataTypeDao2, organisationalUnitDao2, applicationDao, actorDao, ratingCalculator,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        entityHierarchyService, logicalFlowDecoratorDao, mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1)).findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(flowClassificationRuleVantagePoint, atLeast(1)).classificationCode();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).ruleId();
    verify(flowClassificationRuleVantagePoint).vantagePoint();
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#fastRecalculateAllFlowRatings()}
   */
  @Test
  void testFastRecalculateAllFlowRatings4() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.ruleId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.classificationCode()).thenReturn("Classification Code");
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint2 = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint2.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint2.ruleId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint2.classificationCode()).thenReturn("Classification Code");
    when(flowClassificationRuleVantagePoint2.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint2);
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao
        .updateDecoratorsWithClassifications(Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
            .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<EntityHierarchy>any(), Mockito.<Set<FlowDataType>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    EntityHierarchyService entityHierarchyService = new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao,
        entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.fetchFlowDataTypePopulation(Mockito.<Condition>any())).thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao3, entityHierarchyDao2,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    // Act
    int actualFastRecalculateAllFlowRatingsResult = (new FlowClassificationRuleService(flowClassificationRuleDao,
        flowClassificationDao, dataTypeDao2, organisationalUnitDao2, applicationDao, actorDao, ratingCalculator,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        entityHierarchyService, logicalFlowDecoratorDao, mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).fastRecalculateAllFlowRatings();

    // Assert
    verify(logicalFlowDecoratorDao).fetchFlowDataTypePopulation(isA(Condition.class));
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1)).findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(flowClassificationRuleVantagePoint2, atLeast(1)).classificationCode();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).classificationCode();
    verify(flowClassificationRuleVantagePoint2, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint2, atLeast(1)).ruleId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).ruleId();
    verify(flowClassificationRuleVantagePoint2).vantagePoint();
    assertEquals(1, actualFastRecalculateAllFlowRatingsResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  void testRecalculateRatingsForPopulation() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao
        .updateDecoratorsWithClassifications(Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
            .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<EntityHierarchy>any(), Mockito.<Set<FlowDataType>>any())).thenReturn(new ArrayList<>());
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    EntityHierarchyService entityHierarchyService = new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao,
        entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class));

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao3, entityHierarchyDao2,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    FlowClassificationRuleService flowClassificationRuleService = new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao2, organisationalUnitDao2, applicationDao,
        actorDao, ratingCalculator,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        entityHierarchyService, mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class),
        mock(AppGroupEntryDao.class), mock(AppGroupDao.class));

    // Act
    int actualRecalculateRatingsForPopulationResult = flowClassificationRuleService
        .recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1)).findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  void testRecalculateRatingsForPopulation2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao
        .updateDecoratorsWithClassifications(Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
            .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<EntityHierarchy>any(), Mockito.<Set<FlowDataType>>any())).thenReturn(new ArrayList<>());
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenThrow(new NotFoundException("Loading hierarchies", "An error occurred"));
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    EntityHierarchyService entityHierarchyService = new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao,
        entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class));

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao3, entityHierarchyDao2,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    FlowClassificationRuleService flowClassificationRuleService = new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao2, organisationalUnitDao2, applicationDao,
        actorDao, ratingCalculator,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        entityHierarchyService, mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class),
        mock(AppGroupEntryDao.class), mock(AppGroupDao.class));

    // Act
    int actualRecalculateRatingsForPopulationResult = flowClassificationRuleService
        .recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1)).findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        isNull(), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  void testRecalculateRatingsForPopulation3() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.ruleId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.classificationCode()).thenReturn("Classification Code");
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao
        .updateDecoratorsWithClassifications(Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
            .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<EntityHierarchy>any(), Mockito.<Set<FlowDataType>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    EntityHierarchyService entityHierarchyService = new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao,
        entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class));

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao3, entityHierarchyDao2,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    FlowClassificationRuleService flowClassificationRuleService = new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao2, organisationalUnitDao2, applicationDao,
        actorDao, ratingCalculator,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        entityHierarchyService, mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class),
        mock(AppGroupEntryDao.class), mock(AppGroupDao.class));

    // Act
    int actualRecalculateRatingsForPopulationResult = flowClassificationRuleService
        .recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1)).findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(flowClassificationRuleVantagePoint, atLeast(1)).classificationCode();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).ruleId();
    verify(flowClassificationRuleVantagePoint).vantagePoint();
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#recalculateRatingsForPopulation(Set)}
   */
  @Test
  void testRecalculateRatingsForPopulation4() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.ruleId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.classificationCode()).thenReturn("Classification Code");
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint2 = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint2.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint2.ruleId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint2.classificationCode()).thenReturn("Classification Code");
    when(flowClassificationRuleVantagePoint2.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint2);
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao
        .updateDecoratorsWithClassifications(Mockito.<Set<UpdateConditionStep<LogicalFlowDecoratorRecord>>>any()))
            .thenReturn(1);
    when(flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<EntityHierarchy>any(), Mockito.<Set<FlowDataType>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    EntityHierarchyService entityHierarchyService = new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao,
        entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class));

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao3, entityHierarchyDao2,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    FlowClassificationRuleService flowClassificationRuleService = new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao2, organisationalUnitDao2, applicationDao,
        actorDao, ratingCalculator,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        entityHierarchyService, mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class),
        mock(AppGroupEntryDao.class), mock(AppGroupDao.class));

    // Act
    int actualRecalculateRatingsForPopulationResult = flowClassificationRuleService
        .recalculateRatingsForPopulation(new HashSet<>());

    // Assert
    verify(entityHierarchyDao, atLeast(1)).fetchHierarchyForKind(Mockito.<EntityKind>any());
    verify(flowClassificationRuleDao, atLeast(1)).findFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        isA(EntityHierarchy.class), isA(Set.class));
    verify(flowClassificationRuleDao).updateDecoratorsWithClassifications(isA(Set.class));
    verify(flowClassificationRuleVantagePoint2, atLeast(1)).classificationCode();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).classificationCode();
    verify(flowClassificationRuleVantagePoint2, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint2, atLeast(1)).ruleId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).ruleId();
    verify(flowClassificationRuleVantagePoint2).vantagePoint();
    assertEquals(1, actualRecalculateRatingsForPopulationResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  void testCleanupOrphans() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    Integer actualCleanupOrphansResult = (new FlowClassificationRuleService(flowClassificationRuleDao,
        flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao, ratingCalculator,
        changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).cleanupOrphans("42");

    // Assert
    verify(flowClassificationRuleDao).cleanupOrphans();
    assertEquals(0, actualCleanupOrphansResult.intValue());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  void testCleanupOrphans2() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(entityReference);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    Integer actualCleanupOrphansResult = (new FlowClassificationRuleService(flowClassificationRuleDao,
        flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao, ratingCalculator,
        changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).cleanupOrphans("42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowClassificationRuleDao).cleanupOrphans();
    verify(entityReference).kind();
    assertEquals(1, actualCleanupOrphansResult.intValue());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  void testCleanupOrphans3() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(entityReference2);
    entityReferenceSet.add(entityReference);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    Integer actualCleanupOrphansResult = (new FlowClassificationRuleService(flowClassificationRuleDao,
        flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao, ratingCalculator,
        changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).cleanupOrphans("42");

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(flowClassificationRuleDao).cleanupOrphans();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    assertEquals(2, actualCleanupOrphansResult.intValue());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  void testCleanupOrphans4() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenThrow(new NotFoundException(
        "Application removed as an flow classification rule source as it no longer exists", "An error occurred"));

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(entityReference3);
    entityReferenceSet.add(entityReference2);
    entityReferenceSet.add(entityReference);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).cleanupOrphans("42"));
    verify(flowClassificationRuleDao).cleanupOrphans();
    verify(entityReference3).kind();
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  void testCleanupOrphans5() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenThrow(new NotFoundException(
        "Application removed as an flow classification rule source as it no longer exists", "An error occurred"));

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(entityReference3);
    entityReferenceSet.add(entityReference2);
    entityReferenceSet.add(entityReference);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).cleanupOrphans("42"));
    verify(flowClassificationRuleDao).cleanupOrphans();
    verify(entityReference3).kind();
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#cleanupOrphans(String)}
   */
  @Test
  void testCleanupOrphans6() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenThrow(new NotFoundException(
        "Application removed as an flow classification rule source as it no longer exists", "An error occurred"));

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(entityReference3);
    entityReferenceSet.add(entityReference2);
    entityReferenceSet.add(entityReference);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.cleanupOrphans()).thenReturn(entityReferenceSet);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).cleanupOrphans("42"));
    verify(flowClassificationRuleDao).cleanupOrphans();
    verify(entityReference3).kind();
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findCompanionEntityRules(long)}
   */
  @Test
  void testFindCompanionEntityRules() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    when(flowClassificationRuleDao.findCompanionEntityRules(anyLong())).thenReturn(flowClassificationRuleSet);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    Set<FlowClassificationRule> actualFindCompanionEntityRulesResult = (new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao,
        ratingCalculator, changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).findCompanionEntityRules(1L);

    // Assert
    verify(flowClassificationRuleDao).findCompanionEntityRules(eq(1L));
    assertTrue(actualFindCompanionEntityRulesResult.isEmpty());
    assertSame(flowClassificationRuleSet, actualFindCompanionEntityRulesResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findCompanionEntityRules(long)}
   */
  @Test
  void testFindCompanionEntityRules2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findCompanionEntityRules(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).findCompanionEntityRules(1L));
    verify(flowClassificationRuleDao).findCompanionEntityRules(eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findCompanionDataTypeRules(long)}
   */
  @Test
  void testFindCompanionDataTypeRules() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    when(flowClassificationRuleDao.findCompanionDataTypeRules(anyLong())).thenReturn(flowClassificationRuleSet);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    Collection<FlowClassificationRule> actualFindCompanionDataTypeRulesResult = (new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao,
        ratingCalculator, changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).findCompanionDataTypeRules(1L);

    // Assert
    verify(flowClassificationRuleDao).findCompanionDataTypeRules(eq(1L));
    assertTrue(actualFindCompanionDataTypeRulesResult instanceof Set);
    assertTrue(actualFindCompanionDataTypeRulesResult.isEmpty());
    assertSame(flowClassificationRuleSet, actualFindCompanionDataTypeRulesResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findCompanionDataTypeRules(long)}
   */
  @Test
  void testFindCompanionDataTypeRules2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findCompanionDataTypeRules(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).findCompanionDataTypeRules(1L));
    verify(flowClassificationRuleDao).findCompanionDataTypeRules(eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findAppliedClassificationRulesForFlow(Long)}
   */
  @Test
  void testFindAppliedClassificationRulesForFlow() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(flowClassificationRuleSet);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    Set<FlowClassificationRule> actualFindAppliedClassificationRulesForFlowResult = (new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao,
        ratingCalculator, changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).findAppliedClassificationRulesForFlow(1L);

    // Assert
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(eq(1L));
    assertTrue(actualFindAppliedClassificationRulesForFlowResult.isEmpty());
    assertSame(flowClassificationRuleSet, actualFindAppliedClassificationRulesForFlowResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#findAppliedClassificationRulesForFlow(Long)}
   */
  @Test
  void testFindAppliedClassificationRulesForFlow2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).findAppliedClassificationRulesForFlow(1L));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  void testGetFlowClassificationsViewForFlow() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    FlowClassificationRulesView actualFlowClassificationsViewForFlow = (new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao,
        ratingCalculator, changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).getFlowClassificationsViewForFlow(1L);

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(eq(1L));
    assertTrue(actualFlowClassificationsViewForFlow instanceof ImmutableFlowClassificationRulesView);
    Set<DataType> dataTypesResult = actualFlowClassificationsViewForFlow.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFlowClassificationsViewForFlow.flowClassificationRules());
    assertSame(dataTypesResult, actualFlowClassificationsViewForFlow.flowClassifications());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  void testGetFlowClassificationsViewForFlow2() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new FlowClassificationRuleService(flowClassificationRuleDao, flowClassificationDao, dataTypeDao,
            organisationalUnitDao, applicationDao, actorDao, ratingCalculator, changeLogService,
            new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
                measurableDao, organisationalUnitDao2,
                new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
            mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
            mock(AppGroupDao.class))).getFlowClassificationsViewForFlow(1L));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  void testGetFlowClassificationsViewForFlow3() {
    // Arrange
    FlowClassificationRule flowClassificationRule = mock(FlowClassificationRule.class);
    when(flowClassificationRule.classificationId()).thenReturn(1L);
    when(flowClassificationRule.dataTypeId()).thenReturn(1L);

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(flowClassificationRule);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(flowClassificationRuleSet);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    FlowClassificationRulesView actualFlowClassificationsViewForFlow = (new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao,
        ratingCalculator, changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).getFlowClassificationsViewForFlow(1L);

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(eq(1L));
    verify(flowClassificationRule).classificationId();
    verify(flowClassificationRule).dataTypeId();
    assertTrue(actualFlowClassificationsViewForFlow instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualFlowClassificationsViewForFlow.flowClassificationRules().size());
    Set<DataType> dataTypesResult = actualFlowClassificationsViewForFlow.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFlowClassificationsViewForFlow.flowClassifications());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleService#getFlowClassificationsViewForFlow(long)}
   */
  @Test
  void testGetFlowClassificationsViewForFlow4() {
    // Arrange
    FlowClassificationRule flowClassificationRule = mock(FlowClassificationRule.class);
    when(flowClassificationRule.classificationId()).thenReturn(1L);
    when(flowClassificationRule.dataTypeId()).thenReturn(1L);
    FlowClassificationRule flowClassificationRule2 = mock(FlowClassificationRule.class);
    when(flowClassificationRule2.classificationId()).thenReturn(1L);
    when(flowClassificationRule2.dataTypeId()).thenReturn(1L);

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(flowClassificationRule2);
    flowClassificationRuleSet.add(flowClassificationRule);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findAppliedClassificationRulesForFlow(Mockito.<Long>any()))
        .thenReturn(flowClassificationRuleSet);
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ActorDao actorDao = mock(ActorDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao2 = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    FlowClassificationCalculator ratingCalculator = new FlowClassificationCalculator(dataTypeDao2, entityHierarchyDao,
        new LogicalFlowDecoratorRatingsCalculator(applicationService, flowClassificationRuleDao2, logicalFlowDao,
            new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))),
        mock(LogicalFlowDecoratorDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao3 = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao2 = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao2 = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    FlowClassificationRulesView actualFlowClassificationsViewForFlow = (new FlowClassificationRuleService(
        flowClassificationRuleDao, flowClassificationDao, dataTypeDao, organisationalUnitDao, applicationDao, actorDao,
        ratingCalculator, changeLogService,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao3, entityHierarchyDao2, entityStatisticDao,
            measurableDao, organisationalUnitDao2,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)),
        mock(LogicalFlowDecoratorDao.class), mock(EndUserAppDao.class), mock(AppGroupEntryDao.class),
        mock(AppGroupDao.class))).getFlowClassificationsViewForFlow(1L);

    // Assert
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findByIds(isA(Set.class));
    verify(flowClassificationRuleDao).findAppliedClassificationRulesForFlow(eq(1L));
    verify(flowClassificationRule2).classificationId();
    verify(flowClassificationRule).classificationId();
    verify(flowClassificationRule2).dataTypeId();
    verify(flowClassificationRule).dataTypeId();
    assertTrue(actualFlowClassificationsViewForFlow instanceof ImmutableFlowClassificationRulesView);
    Set<DataType> dataTypesResult = actualFlowClassificationsViewForFlow.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertEquals(flowClassificationRuleSet, actualFlowClassificationsViewForFlow.flowClassificationRules());
    assertSame(dataTypesResult, actualFlowClassificationsViewForFlow.flowClassifications());
  }
}
