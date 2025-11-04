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
import org.junit.jupiter.api.Test;

class ImmutableAttestationWidgetDataDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#addAllApplications(Iterable)}
   */
  @Test
  void testBuilderAddAllApplications() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData2() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#addApplications(Application)}
   */
  @Test
  void testBuilderAddApplications() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    ImmutableAttestationWidgetData.Builder actualAddApplicationsResult = builderResult
        .addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#addApplications(Application[])}
   */
  @Test
  void testBuilderAddApplications2() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    ImmutableAttestationWidgetData.Builder actualAddApplicationsResult = builderResult
        .addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#addCellData(AttestationWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    ImmutableAttestationWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableAttestationWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#addCellData(AttestationWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act
    ImmutableAttestationWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableAttestationWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#addCellData(AttestationWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData3() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    ImmutableAttestationWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableAttestationWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#addCellData(AttestationWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData4() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act
    ImmutableAttestationWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableAttestationWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#applications(Iterable)}
   */
  @Test
  void testBuilderApplications() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applications(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableAttestationWidgetData.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAttestationWidgetData.builder().build().applications().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData2() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();
    builderResult.addApplications(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#from(AttestationWidgetData)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();
    AttestationWidgetData instance = mock(AttestationWidgetData.class);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableAttestationWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applications();
    verify(instance).cellData();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#from(AttestationWidgetData)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(mock(Application.class));
    AttestationWidgetData instance = mock(AttestationWidgetData.class);
    when(instance.applications()).thenReturn(applicationSet);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableAttestationWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applications();
    verify(instance).cellData();
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData.Builder#from(AttestationWidgetData)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAttestationWidgetData.Builder builderResult = ImmutableAttestationWidgetData.builder();

    HashSet<AttestationWidgetDatum> attestationWidgetDatumSet = new HashSet<>();
    ImmutableAttestationWidgetDatum.Json json = new ImmutableAttestationWidgetDatum.Json();
    attestationWidgetDatumSet.add(json);
    AttestationWidgetData instance = mock(AttestationWidgetData.class);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.cellData()).thenReturn(attestationWidgetDatumSet);

    // Act
    ImmutableAttestationWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applications();
    verify(instance).cellData();
    ImmutableAttestationWidgetData buildResult = builderResult.build();
    assertEquals(1, buildResult.cellData().size());
    assertSame(builderResult, actualFromResult);
    Set<AttestationEntry> expectedApplicationsResult = json.attestations;
    assertSame(expectedApplicationsResult, buildResult.applications());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData#copyOf(AttestationWidgetData)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationWidgetData instance = mock(AttestationWidgetData.class);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableAttestationWidgetData actualCopyOfResult = ImmutableAttestationWidgetData.copyOf(instance);

    // Assert
    verify(instance).applications();
    verify(instance).cellData();
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData#copyOf(AttestationWidgetData)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(mock(Application.class));
    AttestationWidgetData instance = mock(AttestationWidgetData.class);
    when(instance.applications()).thenReturn(applicationSet);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableAttestationWidgetData actualCopyOfResult = ImmutableAttestationWidgetData.copyOf(instance);

    // Assert
    verify(instance).applications();
    verify(instance).cellData();
    assertEquals(1, actualCopyOfResult.applications().size());
    assertTrue(actualCopyOfResult.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData#copyOf(AttestationWidgetData)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(mock(Application.class));
    applicationSet.add(mock(Application.class));
    AttestationWidgetData instance = mock(AttestationWidgetData.class);
    when(instance.applications()).thenReturn(applicationSet);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableAttestationWidgetData actualCopyOfResult = ImmutableAttestationWidgetData.copyOf(instance);

    // Assert
    verify(instance).applications();
    verify(instance).cellData();
    assertTrue(actualCopyOfResult.cellData().isEmpty());
    assertEquals(applicationSet, actualCopyOfResult.applications());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData#copyOf(AttestationWidgetData)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<AttestationWidgetDatum> attestationWidgetDatumSet = new HashSet<>();
    ImmutableAttestationWidgetDatum.Json json = new ImmutableAttestationWidgetDatum.Json();
    attestationWidgetDatumSet.add(json);
    AttestationWidgetData instance = mock(AttestationWidgetData.class);
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.cellData()).thenReturn(attestationWidgetDatumSet);

    // Act
    ImmutableAttestationWidgetData actualCopyOfResult = ImmutableAttestationWidgetData.copyOf(instance);

    // Assert
    verify(instance).applications();
    verify(instance).cellData();
    assertEquals(1, actualCopyOfResult.cellData().size());
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(json.attestations, applicationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData#fromJson(ImmutableAttestationWidgetData.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAttestationWidgetData.Json json = new ImmutableAttestationWidgetData.Json();

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    Set<AttestationWidgetDatum> attestationWidgetDatumSet = json.cellData;
    assertSame(attestationWidgetDatumSet, applicationsResult);
    assertSame(attestationWidgetDatumSet, actualFromJsonResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData#fromJson(ImmutableAttestationWidgetData.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAttestationWidgetData.Json json = new ImmutableAttestationWidgetData.Json();
    json.setCellData(null);
    json.setApplications(null);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData#fromJson(ImmutableAttestationWidgetData.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();
    applications.add(mock(Application.class));

    ImmutableAttestationWidgetData.Json json = new ImmutableAttestationWidgetData.Json();
    json.setCellData(null);
    json.setApplications(applications);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applications().size());
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData#fromJson(ImmutableAttestationWidgetData.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<AttestationWidgetDatum> cellData = new LinkedHashSet<>();
    ImmutableAttestationWidgetDatum.Json json = new ImmutableAttestationWidgetDatum.Json();
    cellData.add(json);

    ImmutableAttestationWidgetData.Json json2 = new ImmutableAttestationWidgetData.Json();
    json2.setCellData(cellData);
    json2.setApplications(null);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(json.attestations, applicationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetData#fromJson(ImmutableAttestationWidgetData.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<AttestationWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAttestationWidgetDatum.Json());
    ImmutableAttestationWidgetDatum.Json json = new ImmutableAttestationWidgetDatum.Json();
    cellData.add(json);

    ImmutableAttestationWidgetData.Json json2 = new ImmutableAttestationWidgetData.Json();
    json2.setCellData(cellData);
    json2.setApplications(null);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult = ImmutableAttestationWidgetData.fromJson(json2);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertEquals(cellData, actualFromJsonResult.cellData());
    assertSame(json.attestations, applicationsResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationWidgetData.Json#applications()}
   */
  @Test
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationWidgetData.Json()).applications());
  }

  /**
   * Method under test: {@link ImmutableAttestationWidgetData.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationWidgetData.Json()).cellData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttestationWidgetData.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttestationWidgetData.Json actualJson = new ImmutableAttestationWidgetData.Json();

    // Assert
    assertTrue(actualJson.applications.isEmpty());
    assertTrue(actualJson.cellData.isEmpty());
  }
}
