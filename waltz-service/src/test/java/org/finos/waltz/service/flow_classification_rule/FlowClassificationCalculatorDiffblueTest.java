package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchyItem;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorRatingsCalculator;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.tag.TagService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowClassificationCalculatorDiffblueTest {
  /**
   * Method under test:
   * {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  void testUpdate() {
    // Arrange
    DataType dataType = mock(DataType.class);
    when(dataType.entityReference()).thenReturn(null);
    when(dataType.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getById(anyLong())).thenReturn(dataType);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Optional<EntityKind>>any())).thenReturn(new ArrayList<>());
    FlowClassificationCalculator flowClassificationCalculator = new FlowClassificationCalculator(dataTypeDao,
        entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);
    EntityReference vantageRef = mock(EntityReference.class);
    when(vantageRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    int[] actualUpdateResult = flowClassificationCalculator.update(1L, vantageRef);

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(eq(1L));
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isNull());
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(vantageRef, atLeast(1)).kind();
    verify(dataType).id();
    verify(dataType).name();
    verify(dataType).entityReference();
    assertEquals(0, actualUpdateResult.length);
  }

  /**
   * Method under test:
   * {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    DataType dataType = mock(DataType.class);
    when(dataType.entityReference()).thenReturn(null);
    when(dataType.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getById(anyLong())).thenReturn(dataType);
    EntityHierarchyItem entityHierarchyItem = mock(EntityHierarchyItem.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(entityHierarchyItem.id()).thenReturn(ofResult2);

    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(entityHierarchyItem);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any())).thenReturn(entityHierarchyItemList);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Optional<EntityKind>>any())).thenReturn(new ArrayList<>());
    FlowClassificationCalculator flowClassificationCalculator = new FlowClassificationCalculator(dataTypeDao,
        entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);
    EntityReference vantageRef = mock(EntityReference.class);
    when(vantageRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    int[] actualUpdateResult = flowClassificationCalculator.update(1L, vantageRef);

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(eq(1L));
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isNull());
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(vantageRef, atLeast(1)).kind();
    verify(dataType).id();
    verify(entityHierarchyItem).id();
    verify(dataType).name();
    verify(dataType).entityReference();
    assertEquals(0, actualUpdateResult.length);
  }

  /**
   * Method under test:
   * {@link FlowClassificationCalculator#update(Long, EntityReference)}
   */
  @Test
  void testUpdate3() {
    // Arrange
    DataType dataType = mock(DataType.class);
    when(dataType.entityReference()).thenReturn(null);
    when(dataType.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getById(anyLong())).thenReturn(dataType);
    EntityHierarchyItem entityHierarchyItem = mock(EntityHierarchyItem.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(entityHierarchyItem.id()).thenReturn(ofResult2);
    EntityHierarchyItem entityHierarchyItem2 = mock(EntityHierarchyItem.class);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(entityHierarchyItem2.id()).thenReturn(ofResult3);

    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(entityHierarchyItem2);
    entityHierarchyItemList.add(entityHierarchyItem);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.findDesendents(Mockito.<EntityReference>any())).thenReturn(entityHierarchyItemList);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Optional<EntityKind>>any())).thenReturn(new ArrayList<>());
    FlowClassificationCalculator flowClassificationCalculator = new FlowClassificationCalculator(dataTypeDao,
        entityHierarchyDao, ratingsCalculator, logicalFlowDecoratorDao);
    EntityReference vantageRef = mock(EntityReference.class);
    when(vantageRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    int[] actualUpdateResult = flowClassificationCalculator.update(1L, vantageRef);

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(dataTypeDao).getById(eq(1L));
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(entityHierarchyDao).findDesendents(isNull());
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(vantageRef, atLeast(1)).kind();
    verify(dataType).id();
    verify(entityHierarchyItem2).id();
    verify(entityHierarchyItem).id();
    verify(dataType).name();
    verify(dataType).entityReference();
    assertEquals(0, actualUpdateResult.length);
  }
}
