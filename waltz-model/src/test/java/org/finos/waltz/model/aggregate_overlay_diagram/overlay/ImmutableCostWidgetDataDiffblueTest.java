package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.cost.EntityCostKind;
import org.finos.waltz.model.measurable.Measurable;
import org.junit.jupiter.api.Test;

class ImmutableCostWidgetDataDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addAllApplications(Iterable)}
   */
  @Test
  void testBuilderAddAllApplications() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData2() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addAllCostKinds(Iterable)}
   */
  @Test
  void testBuilderAddAllCostKinds() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCostKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addAllMeasurables(Iterable)}
   */
  @Test
  void testBuilderAddAllMeasurables() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMeasurables(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addApplications(Application)}
   */
  @Test
  void testBuilderAddApplications() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    ImmutableCostWidgetData.Builder actualAddApplicationsResult = builderResult
        .addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addApplications(Application[])}
   */
  @Test
  void testBuilderAddApplications2() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    ImmutableCostWidgetData.Builder actualAddApplicationsResult = builderResult
        .addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addCellData(CostWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    ImmutableCostWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableCostWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addCellData(CostWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act
    ImmutableCostWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableCostWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addCellData(CostWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData3() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    ImmutableCostWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableCostWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addCellData(CostWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData4() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act
    ImmutableCostWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableCostWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addCostKinds(EntityCostKind)}
   */
  @Test
  void testBuilderAddCostKinds() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    ImmutableCostWidgetData.Builder actualAddCostKindsResult = builderResult.addCostKinds(mock(EntityCostKind.class));

    // Assert
    assertEquals(1, builderResult.build().costKinds().size());
    assertSame(builderResult, actualAddCostKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addCostKinds(EntityCostKind[])}
   */
  @Test
  void testBuilderAddCostKinds2() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    ImmutableCostWidgetData.Builder actualAddCostKindsResult = builderResult.addCostKinds(mock(EntityCostKind.class));

    // Assert
    assertEquals(1, builderResult.build().costKinds().size());
    assertSame(builderResult, actualAddCostKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addMeasurables(Measurable)}
   */
  @Test
  void testBuilderAddMeasurables() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    ImmutableCostWidgetData.Builder actualAddMeasurablesResult = builderResult.addMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#addMeasurables(Measurable[])}
   */
  @Test
  void testBuilderAddMeasurables2() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    ImmutableCostWidgetData.Builder actualAddMeasurablesResult = builderResult.addMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#applications(Iterable)}
   */
  @Test
  void testBuilderApplications() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applications(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableCostWidgetData.builder().build().applications().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData2() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#costKinds(Iterable)}
   */
  @Test
  void testBuilderCostKinds() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.costKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#from(CostWidgetData)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.costKinds()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());

    // Act
    ImmutableCostWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#from(CostWidgetData)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    HashSet<CostWidgetDatum> costWidgetDatumSet = new HashSet<>();
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    costWidgetDatumSet.add(json);
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(costWidgetDatumSet);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.costKinds()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());

    // Act
    ImmutableCostWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    ImmutableCostWidgetData buildResult = builderResult.build();
    assertEquals(1, buildResult.cellData().size());
    assertSame(builderResult, actualFromResult);
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, buildResult.applications());
    assertSame(measurableCostEntrySet, buildResult.costKinds());
    assertSame(measurableCostEntrySet, buildResult.measurables());
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#from(CostWidgetData)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(mock(Application.class));
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(applicationSet);
    when(instance.costKinds()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());

    // Act
    ImmutableCostWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#from(CostWidgetData)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    HashSet<EntityCostKind> entityCostKindSet = new HashSet<>();
    entityCostKindSet.add(mock(EntityCostKind.class));
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.costKinds()).thenReturn(entityCostKindSet);
    when(instance.measurables()).thenReturn(new HashSet<>());

    // Act
    ImmutableCostWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    assertEquals(1, builderResult.build().costKinds().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#from(CostWidgetData)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    HashSet<Measurable> measurableSet = new HashSet<>();
    measurableSet.add(mock(Measurable.class));
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.costKinds()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(measurableSet);

    // Act
    ImmutableCostWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData.Builder#measurables(Iterable)}
   */
  @Test
  void testBuilderMeasurables() {
    // Arrange
    ImmutableCostWidgetData.Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurables(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.costKinds()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());

    // Act
    ImmutableCostWidgetData actualCopyOfResult = ImmutableCostWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
    assertSame(applicationsResult, actualCopyOfResult.costKinds());
    assertSame(applicationsResult, actualCopyOfResult.measurables());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<CostWidgetDatum> costWidgetDatumSet = new HashSet<>();
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    costWidgetDatumSet.add(json);
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(costWidgetDatumSet);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.costKinds()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());

    // Act
    ImmutableCostWidgetData actualCopyOfResult = ImmutableCostWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    assertEquals(1, actualCopyOfResult.cellData().size());
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, applicationsResult);
    assertSame(measurableCostEntrySet, actualCopyOfResult.costKinds());
    assertSame(measurableCostEntrySet, actualCopyOfResult.measurables());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<CostWidgetDatum> costWidgetDatumSet = new HashSet<>();
    costWidgetDatumSet.add(new ImmutableCostWidgetDatum.Json());
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    costWidgetDatumSet.add(json);
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(costWidgetDatumSet);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.costKinds()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());

    // Act
    ImmutableCostWidgetData actualCopyOfResult = ImmutableCostWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(costWidgetDatumSet, actualCopyOfResult.cellData());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, applicationsResult);
    assertSame(measurableCostEntrySet, actualCopyOfResult.costKinds());
    assertSame(measurableCostEntrySet, actualCopyOfResult.measurables());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(mock(Application.class));
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(applicationSet);
    when(instance.costKinds()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());

    // Act
    ImmutableCostWidgetData actualCopyOfResult = ImmutableCostWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    assertEquals(1, actualCopyOfResult.applications().size());
    Set<CostWidgetDatum> cellDataResult = actualCopyOfResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualCopyOfResult.costKinds());
    assertSame(cellDataResult, actualCopyOfResult.measurables());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<EntityCostKind> entityCostKindSet = new HashSet<>();
    entityCostKindSet.add(mock(EntityCostKind.class));
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.costKinds()).thenReturn(entityCostKindSet);
    when(instance.measurables()).thenReturn(new HashSet<>());

    // Act
    ImmutableCostWidgetData actualCopyOfResult = ImmutableCostWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    assertEquals(1, actualCopyOfResult.costKinds().size());
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
    assertSame(applicationsResult, actualCopyOfResult.measurables());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<Measurable> measurableSet = new HashSet<>();
    measurableSet.add(mock(Measurable.class));
    CostWidgetData instance = mock(CostWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.costKinds()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(measurableSet);

    // Act
    ImmutableCostWidgetData actualCopyOfResult = ImmutableCostWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).costKinds();
    verify(instance).measurables();
    assertEquals(1, actualCopyOfResult.measurables().size());
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
    assertSame(applicationsResult, actualCopyOfResult.costKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData#fromJson(ImmutableCostWidgetData.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCostWidgetData.Json json = new ImmutableCostWidgetData.Json();

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    Set<Measurable> measurableSet = json.measurables;
    assertSame(measurableSet, applicationsResult);
    assertSame(measurableSet, actualFromJsonResult.cellData());
    assertSame(measurableSet, actualFromJsonResult.costKinds());
    assertSame(measurableSet, actualFromJsonResult.measurables());
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData#fromJson(ImmutableCostWidgetData.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableCostWidgetData.Json json = new ImmutableCostWidgetData.Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setMeasurables(null);
    json.setCostKinds(null);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
    assertSame(applicationsResult, actualFromJsonResult.costKinds());
    assertSame(applicationsResult, actualFromJsonResult.measurables());
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData#fromJson(ImmutableCostWidgetData.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<EntityCostKind> costKinds = new LinkedHashSet<>();
    costKinds.add(mock(EntityCostKind.class));

    ImmutableCostWidgetData.Json json = new ImmutableCostWidgetData.Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setMeasurables(null);
    json.setCostKinds(costKinds);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.costKinds().size());
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
    assertSame(applicationsResult, actualFromJsonResult.measurables());
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData#fromJson(ImmutableCostWidgetData.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<Measurable> measurables = new LinkedHashSet<>();
    measurables.add(mock(Measurable.class));

    ImmutableCostWidgetData.Json json = new ImmutableCostWidgetData.Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setMeasurables(measurables);
    json.setCostKinds(null);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurables().size());
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
    assertSame(applicationsResult, actualFromJsonResult.costKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData#fromJson(ImmutableCostWidgetData.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();
    applications.add(mock(Application.class));

    ImmutableCostWidgetData.Json json = new ImmutableCostWidgetData.Json();
    json.setCellData(null);
    json.setApplications(applications);
    json.setMeasurables(null);
    json.setCostKinds(null);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applications().size());
    Set<CostWidgetDatum> cellDataResult = actualFromJsonResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualFromJsonResult.costKinds());
    assertSame(cellDataResult, actualFromJsonResult.measurables());
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData#fromJson(ImmutableCostWidgetData.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    HashSet<CostWidgetDatum> cellData = new HashSet<>();
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    cellData.add(json);

    ImmutableCostWidgetData.Json json2 = new ImmutableCostWidgetData.Json();
    json2.setCellData(cellData);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, applicationsResult);
    assertSame(measurableCostEntrySet, actualFromJsonResult.costKinds());
    assertSame(measurableCostEntrySet, actualFromJsonResult.measurables());
  }

  /**
   * Method under test:
   * {@link ImmutableCostWidgetData#fromJson(ImmutableCostWidgetData.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    HashSet<CostWidgetDatum> cellData = new HashSet<>();
    cellData.add(new ImmutableCostWidgetDatum.Json());
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    cellData.add(json);

    ImmutableCostWidgetData.Json json2 = new ImmutableCostWidgetData.Json();
    json2.setCellData(cellData);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json2);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(cellData, actualFromJsonResult.cellData());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, applicationsResult);
    assertSame(measurableCostEntrySet, actualFromJsonResult.costKinds());
    assertSame(measurableCostEntrySet, actualFromJsonResult.measurables());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData.Json#applications()}
   */
  @Test
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostWidgetData.Json()).applications());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostWidgetData.Json()).cellData());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData.Json#costKinds()}
   */
  @Test
  void testJsonCostKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostWidgetData.Json()).costKinds());
  }

  /**
   * Method under test: {@link ImmutableCostWidgetData.Json#measurables()}
   */
  @Test
  void testJsonMeasurables() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostWidgetData.Json()).measurables());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCostWidgetData.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableCostWidgetData.Json actualJson = new ImmutableCostWidgetData.Json();

    // Assert
    assertTrue(actualJson.applications.isEmpty());
    assertTrue(actualJson.cellData.isEmpty());
    assertTrue(actualJson.costKinds.isEmpty());
    assertTrue(actualJson.measurables.isEmpty());
  }
}
