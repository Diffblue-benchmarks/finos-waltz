package org.finos.waltz.service.usage_info;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.data_type_usage.DataTypeUsage;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.system.ImmutableSystemChangeSet;
import org.finos.waltz.model.system.SystemChangeSet;
import org.finos.waltz.model.usage_info.UsageInfo;
import org.finos.waltz.model.usage_info.UsageKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataTypeUsageServiceDiffblueTest {
  /**
   * Method under test:
   * {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindForAppIdSelector() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();
    when(dataTypeUsageDao.findForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeUsageList);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult = dataTypeUsageService.findForAppIdSelector(EntityKind.ALL,
        options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
    assertSame(dataTypeUsageList, actualFindForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindForAppIdSelector2() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();
    when(dataTypeUsageDao.findForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeUsageList);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult = dataTypeUsageService.findForAppIdSelector(EntityKind.ALL,
        options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
    assertSame(dataTypeUsageList, actualFindForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindForAppIdSelector3() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();
    when(dataTypeUsageDao.findForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeUsageList);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult = dataTypeUsageService.findForAppIdSelector(EntityKind.ALL,
        options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
    assertSame(dataTypeUsageList, actualFindForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindForAppIdSelector4() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();
    when(dataTypeUsageDao.findForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeUsageList);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult = dataTypeUsageService.findForAppIdSelector(EntityKind.ALL,
        options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
    assertSame(dataTypeUsageList, actualFindForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindForAppIdSelector5() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();
    when(dataTypeUsageDao.findForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeUsageList);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult = dataTypeUsageService.findForAppIdSelector(EntityKind.ALL,
        options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
    assertSame(dataTypeUsageList, actualFindForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#findForAppIdSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindForAppIdSelector6() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();
    when(dataTypeUsageDao.findForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(dataTypeUsageList);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DataTypeUsage> actualFindForAppIdSelectorResult = dataTypeUsageService.findForAppIdSelector(EntityKind.ALL,
        options);

    // Assert
    verify(dataTypeUsageDao).findForIdSelector(eq(EntityKind.ALL), isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindForAppIdSelectorResult.isEmpty());
    assertSame(dataTypeUsageList, actualFindForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#findForEntity(EntityReference)}
   */
  @Test
  void testFindForEntity() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();
    when(dataTypeUsageDao.findForEntity(Mockito.<EntityReference>any())).thenReturn(dataTypeUsageList);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);

    // Act
    List<DataTypeUsage> actualFindForEntityResult = (new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForEntity(null);

    // Assert
    verify(dataTypeUsageDao).findForEntity(isNull());
    assertTrue(actualFindForEntityResult.isEmpty());
    assertSame(dataTypeUsageList, actualFindForEntityResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  void testFindForEntityAndDataType() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    ArrayList<DataTypeUsage> dataTypeUsageList = new ArrayList<>();
    when(dataTypeUsageDao.findForEntityAndDataType(Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(dataTypeUsageList);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);

    // Act
    List<DataTypeUsage> actualFindForEntityAndDataTypeResult = (new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForEntityAndDataType(null, 1L);

    // Assert
    verify(dataTypeUsageDao).findForEntityAndDataType(isNull(), eq(1L));
    assertTrue(actualFindForEntityAndDataTypeResult.isEmpty());
    assertSame(dataTypeUsageList, actualFindForEntityAndDataTypeResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#save(EntityReference, Long, List, String)}
   */
  @Test
  void testSave() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.deleteUsageInfo(Mockito.<EntityReference>any(), Mockito.<Long>any(),
        Mockito.<List<UsageKind>>any())).thenReturn(1);
    when(dataTypeUsageDao.insertUsageInfo(Mockito.<EntityReference>any(), Mockito.<Long>any(),
        Mockito.<List<UsageInfo>>any())).thenReturn(new int[]{1, -1, 1, -1});
    when(dataTypeUsageDao.updateUsageInfo(Mockito.<EntityReference>any(), Mockito.<Long>any(),
        Mockito.<List<UsageInfo>>any())).thenReturn(new int[]{1, -1, 1, -1});
    when(dataTypeUsageDao.findForEntityAndDataType(Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    DataType dataType = mock(DataType.class);
    when(dataType.name()).thenReturn("Name");
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getById(anyLong())).thenReturn(dataType);

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualSaveResult = (new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).save(null,
                1L, null, "42");

    // Assert
    verify(dataTypeDao).getById(eq(1L));
    verify(dataTypeUsageDao).deleteUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).findForEntityAndDataType(isNull(), eq(1L));
    verify(dataTypeUsageDao).insertUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataTypeUsageDao).updateUsageInfo(isNull(), eq(1L), isA(List.class));
    verify(dataType).name();
    assertTrue(actualSaveResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualSaveResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualSaveResult.inserts());
    assertSame(deletesResult, actualSaveResult.updates());
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForAllApplications()}
   */
  @Test
  void testRecalculateForAllApplications() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.recalculateForAllApplications()).thenReturn(true);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);

    // Act
    boolean actualRecalculateForAllApplicationsResult = (new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .recalculateForAllApplications();

    // Assert
    verify(dataTypeUsageDao).recalculateForAllApplications();
    assertTrue(actualRecalculateForAllApplicationsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForAllApplications()}
   */
  @Test
  void testRecalculateForAllApplications2() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.recalculateForAllApplications()).thenReturn(false);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);

    // Act
    boolean actualRecalculateForAllApplicationsResult = (new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .recalculateForAllApplications();

    // Assert
    verify(dataTypeUsageDao).recalculateForAllApplications();
    assertFalse(actualRecalculateForAllApplicationsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  void testRecalculateForApplications() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertTrue(dataTypeUsageService.recalculateForApplications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  void testRecalculateForApplications2() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(entityReference);

    // Act
    boolean actualRecalculateForApplicationsResult = dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(entityReference, atLeast(1)).kind();
    assertTrue(actualRecalculateForApplicationsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  void testRecalculateForApplications3() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(entityReference2);
    refs.add(entityReference);

    // Act
    boolean actualRecalculateForApplicationsResult = dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(entityReference2, atLeast(1)).kind();
    verify(entityReference, atLeast(1)).kind();
    assertTrue(actualRecalculateForApplicationsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  void testRecalculateForApplications4() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.recalculateForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(true);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ACTOR);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(entityReference2);
    refs.add(entityReference);

    // Act
    boolean actualRecalculateForApplicationsResult = dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(dataTypeUsageDao, atLeast(1)).recalculateForIdSelector(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any());
    verify(entityReference2).id();
    verify(entityReference2, atLeast(1)).kind();
    verify(entityReference, atLeast(1)).kind();
    assertTrue(actualRecalculateForApplicationsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  void testRecalculateForApplications5() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.recalculateForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(false);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ACTOR);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(entityReference2);
    refs.add(entityReference);

    // Act
    boolean actualRecalculateForApplicationsResult = dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(dataTypeUsageDao).recalculateForIdSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    verify(entityReference2).id();
    verify(entityReference2, atLeast(1)).kind();
    verify(entityReference, atLeast(1)).kind();
    assertFalse(actualRecalculateForApplicationsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  void testRecalculateForApplications6() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.recalculateForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(true);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(-1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ACTOR);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(entityReference2);
    refs.add(entityReference);

    // Act
    boolean actualRecalculateForApplicationsResult = dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(dataTypeUsageDao, atLeast(1)).recalculateForIdSelector(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any());
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2, atLeast(1)).kind();
    verify(entityReference, atLeast(1)).kind();
    assertTrue(actualRecalculateForApplicationsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  void testRecalculateForApplications7() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.recalculateForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(true);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.APPLICATION);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(entityReference2);
    refs.add(entityReference);

    // Act
    boolean actualRecalculateForApplicationsResult = dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(dataTypeUsageDao, atLeast(1)).recalculateForIdSelector(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any());
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2, atLeast(1)).kind();
    verify(entityReference, atLeast(1)).kind();
    assertTrue(actualRecalculateForApplicationsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeUsageService#recalculateForApplications(Collection)}
   */
  @Test
  void testRecalculateForApplications8() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    when(dataTypeUsageDao.recalculateForIdSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(true);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.APPLICATION);

    ArrayList<EntityReference> refs = new ArrayList<>();
    refs.add(entityReference2);
    refs.add(entityReference);

    // Act
    boolean actualRecalculateForApplicationsResult = dataTypeUsageService.recalculateForApplications(refs);

    // Assert
    verify(dataTypeUsageDao, atLeast(1)).recalculateForIdSelector(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any());
    verify(entityReference2).id();
    verify(entityReference2, atLeast(1)).kind();
    verify(entityReference, atLeast(1)).kind();
    assertTrue(actualRecalculateForApplicationsResult);
  }
}
