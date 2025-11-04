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
import org.finos.waltz.model.complexity.ComplexityKind;
import org.junit.jupiter.api.Test;

class ImmutableComplexityWidgetDataDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addAllApplications(Iterable)}
   */
  @Test
  void testBuilderAddAllApplications() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData2() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addAllComplexityKinds(Iterable)}
   */
  @Test
  void testBuilderAddAllComplexityKinds() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllComplexityKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addApplications(Application)}
   */
  @Test
  void testBuilderAddApplications() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    ImmutableComplexityWidgetData.Builder actualAddApplicationsResult = builderResult
        .addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addApplications(Application[])}
   */
  @Test
  void testBuilderAddApplications2() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    ImmutableComplexityWidgetData.Builder actualAddApplicationsResult = builderResult
        .addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addCellData(ComplexityWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    ImmutableComplexityWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableComplexityWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addCellData(ComplexityWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act
    ImmutableComplexityWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableComplexityWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addCellData(ComplexityWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData3() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    ImmutableComplexityWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableComplexityWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addCellData(ComplexityWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData4() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act
    ImmutableComplexityWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableComplexityWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addComplexityKinds(ComplexityKind)}
   */
  @Test
  void testBuilderAddComplexityKinds() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    ImmutableComplexityWidgetData.Builder actualAddComplexityKindsResult = builderResult
        .addComplexityKinds(mock(ComplexityKind.class));

    // Assert
    assertEquals(1, builderResult.build().complexityKinds().size());
    assertSame(builderResult, actualAddComplexityKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#addComplexityKinds(ComplexityKind[])}
   */
  @Test
  void testBuilderAddComplexityKinds2() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act
    ImmutableComplexityWidgetData.Builder actualAddComplexityKindsResult = builderResult
        .addComplexityKinds(mock(ComplexityKind.class));

    // Assert
    assertEquals(1, builderResult.build().complexityKinds().size());
    assertSame(builderResult, actualAddComplexityKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#applications(Iterable)}
   */
  @Test
  void testBuilderApplications() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applications(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableComplexityWidgetData.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableComplexityWidgetData.builder().build().applications().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData2() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#complexityKinds(Iterable)}
   */
  @Test
  void testBuilderComplexityKinds() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#from(ComplexityWidgetData)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();
    ComplexityWidgetData instance = mock(ComplexityWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.complexityKinds()).thenReturn(new HashSet<>());

    // Act
    ImmutableComplexityWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).complexityKinds();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#from(ComplexityWidgetData)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    HashSet<ComplexityWidgetDatum> complexityWidgetDatumSet = new HashSet<>();
    ImmutableComplexityWidgetDatum.Json json = new ImmutableComplexityWidgetDatum.Json();
    complexityWidgetDatumSet.add(json);
    ComplexityWidgetData instance = mock(ComplexityWidgetData.class);
    when(instance.cellData()).thenReturn(complexityWidgetDatumSet);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.complexityKinds()).thenReturn(new HashSet<>());

    // Act
    ImmutableComplexityWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).complexityKinds();
    ImmutableComplexityWidgetData buildResult = builderResult.build();
    assertEquals(1, buildResult.cellData().size());
    assertSame(builderResult, actualFromResult);
    Set<ComplexityEntry> complexityEntrySet = json.complexities;
    assertSame(complexityEntrySet, buildResult.applications());
    assertSame(complexityEntrySet, buildResult.complexityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#from(ComplexityWidgetData)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(mock(Application.class));
    ComplexityWidgetData instance = mock(ComplexityWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(applicationSet);
    when(instance.complexityKinds()).thenReturn(new HashSet<>());

    // Act
    ImmutableComplexityWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).complexityKinds();
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Builder#from(ComplexityWidgetData)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableComplexityWidgetData.Builder builderResult = ImmutableComplexityWidgetData.builder();

    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    complexityKindSet.add(mock(ComplexityKind.class));
    ComplexityWidgetData instance = mock(ComplexityWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.complexityKinds()).thenReturn(complexityKindSet);

    // Act
    ImmutableComplexityWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).complexityKinds();
    assertEquals(1, builderResult.build().complexityKinds().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#copyOf(ComplexityWidgetData)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ComplexityWidgetData instance = mock(ComplexityWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.complexityKinds()).thenReturn(new HashSet<>());

    // Act
    ImmutableComplexityWidgetData actualCopyOfResult = ImmutableComplexityWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).complexityKinds();
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
    assertSame(applicationsResult, actualCopyOfResult.complexityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#copyOf(ComplexityWidgetData)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ComplexityWidgetDatum> complexityWidgetDatumSet = new HashSet<>();
    ImmutableComplexityWidgetDatum.Json json = new ImmutableComplexityWidgetDatum.Json();
    complexityWidgetDatumSet.add(json);
    ComplexityWidgetData instance = mock(ComplexityWidgetData.class);
    when(instance.cellData()).thenReturn(complexityWidgetDatumSet);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.complexityKinds()).thenReturn(new HashSet<>());

    // Act
    ImmutableComplexityWidgetData actualCopyOfResult = ImmutableComplexityWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).complexityKinds();
    assertEquals(1, actualCopyOfResult.cellData().size());
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    Set<ComplexityEntry> complexityEntrySet = json.complexities;
    assertSame(complexityEntrySet, applicationsResult);
    assertSame(complexityEntrySet, actualCopyOfResult.complexityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#copyOf(ComplexityWidgetData)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<ComplexityWidgetDatum> complexityWidgetDatumSet = new HashSet<>();
    complexityWidgetDatumSet.add(new ImmutableComplexityWidgetDatum.Json());
    ImmutableComplexityWidgetDatum.Json json = new ImmutableComplexityWidgetDatum.Json();
    complexityWidgetDatumSet.add(json);
    ComplexityWidgetData instance = mock(ComplexityWidgetData.class);
    when(instance.cellData()).thenReturn(complexityWidgetDatumSet);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.complexityKinds()).thenReturn(new HashSet<>());

    // Act
    ImmutableComplexityWidgetData actualCopyOfResult = ImmutableComplexityWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).complexityKinds();
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(complexityWidgetDatumSet, actualCopyOfResult.cellData());
    Set<ComplexityEntry> complexityEntrySet = json.complexities;
    assertSame(complexityEntrySet, applicationsResult);
    assertSame(complexityEntrySet, actualCopyOfResult.complexityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#copyOf(ComplexityWidgetData)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(mock(Application.class));
    ComplexityWidgetData instance = mock(ComplexityWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(applicationSet);
    when(instance.complexityKinds()).thenReturn(new HashSet<>());

    // Act
    ImmutableComplexityWidgetData actualCopyOfResult = ImmutableComplexityWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).complexityKinds();
    assertEquals(1, actualCopyOfResult.applications().size());
    Set<ComplexityWidgetDatum> cellDataResult = actualCopyOfResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualCopyOfResult.complexityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#copyOf(ComplexityWidgetData)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    complexityKindSet.add(mock(ComplexityKind.class));
    ComplexityWidgetData instance = mock(ComplexityWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.complexityKinds()).thenReturn(complexityKindSet);

    // Act
    ImmutableComplexityWidgetData actualCopyOfResult = ImmutableComplexityWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).applications();
    verify(instance).complexityKinds();
    assertEquals(1, actualCopyOfResult.complexityKinds().size());
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#fromJson(ImmutableComplexityWidgetData.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableComplexityWidgetData.Json json = new ImmutableComplexityWidgetData.Json();

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    Set<ComplexityKind> complexityKindSet = json.complexityKinds;
    assertSame(complexityKindSet, applicationsResult);
    assertSame(complexityKindSet, actualFromJsonResult.cellData());
    assertSame(complexityKindSet, actualFromJsonResult.complexityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#fromJson(ImmutableComplexityWidgetData.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableComplexityWidgetData.Json json = new ImmutableComplexityWidgetData.Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setComplexityKinds(null);

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
    assertSame(applicationsResult, actualFromJsonResult.complexityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#fromJson(ImmutableComplexityWidgetData.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<ComplexityKind> complexityKinds = new LinkedHashSet<>();
    complexityKinds.add(mock(ComplexityKind.class));

    ImmutableComplexityWidgetData.Json json = new ImmutableComplexityWidgetData.Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setComplexityKinds(complexityKinds);

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.complexityKinds().size());
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#fromJson(ImmutableComplexityWidgetData.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();
    applications.add(mock(Application.class));

    ImmutableComplexityWidgetData.Json json = new ImmutableComplexityWidgetData.Json();
    json.setCellData(null);
    json.setApplications(applications);
    json.setComplexityKinds(null);

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applications().size());
    Set<ComplexityWidgetDatum> cellDataResult = actualFromJsonResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualFromJsonResult.complexityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#fromJson(ImmutableComplexityWidgetData.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<ComplexityWidgetDatum> cellData = new LinkedHashSet<>();
    ImmutableComplexityWidgetDatum.Json json = new ImmutableComplexityWidgetDatum.Json();
    cellData.add(json);

    ImmutableComplexityWidgetData.Json json2 = new ImmutableComplexityWidgetData.Json();
    json2.setCellData(cellData);
    json2.setApplications(null);
    json2.setComplexityKinds(null);

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    Set<ComplexityEntry> complexityEntrySet = json.complexities;
    assertSame(complexityEntrySet, applicationsResult);
    assertSame(complexityEntrySet, actualFromJsonResult.complexityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData#fromJson(ImmutableComplexityWidgetData.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    LinkedHashSet<ComplexityWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableComplexityWidgetDatum.Json());
    ImmutableComplexityWidgetDatum.Json json = new ImmutableComplexityWidgetDatum.Json();
    cellData.add(json);

    ImmutableComplexityWidgetData.Json json2 = new ImmutableComplexityWidgetData.Json();
    json2.setCellData(cellData);
    json2.setApplications(null);
    json2.setComplexityKinds(null);

    // Act
    ImmutableComplexityWidgetData actualFromJsonResult = ImmutableComplexityWidgetData.fromJson(json2);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(cellData, actualFromJsonResult.cellData());
    Set<ComplexityEntry> complexityEntrySet = json.complexities;
    assertSame(complexityEntrySet, applicationsResult);
    assertSame(complexityEntrySet, actualFromJsonResult.complexityKinds());
  }

  /**
   * Method under test: {@link ImmutableComplexityWidgetData.Json#applications()}
   */
  @Test
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityWidgetData.Json()).applications());
  }

  /**
   * Method under test: {@link ImmutableComplexityWidgetData.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityWidgetData.Json()).cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetData.Json#complexityKinds()}
   */
  @Test
  void testJsonComplexityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableComplexityWidgetData.Json()).complexityKinds());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableComplexityWidgetData.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableComplexityWidgetData.Json actualJson = new ImmutableComplexityWidgetData.Json();

    // Assert
    assertTrue(actualJson.applications.isEmpty());
    assertTrue(actualJson.cellData.isEmpty());
    assertTrue(actualJson.complexityKinds.isEmpty());
  }
}
