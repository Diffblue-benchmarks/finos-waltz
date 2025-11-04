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
import org.junit.jupiter.api.Test;

class ImmutableApplicationChangeWidgetDataDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableApplicationChangeWidgetData.Builder builderResult = ImmutableApplicationChangeWidgetData.builder();

    // Act
    ImmutableApplicationChangeWidgetData.Builder actualAddAllCellDataResult = builderResult
        .addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData.Builder#addCellData(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableApplicationChangeWidgetData.Builder builderResult = ImmutableApplicationChangeWidgetData.builder();

    // Act
    ImmutableApplicationChangeWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableApplicationChangeWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData.Builder#addCellData(ApplicationChangeWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableApplicationChangeWidgetData.Builder builderResult = ImmutableApplicationChangeWidgetData.builder();

    // Act
    ImmutableApplicationChangeWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableApplicationChangeWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableApplicationChangeWidgetData.builder().build().cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableApplicationChangeWidgetData.Builder builderResult = ImmutableApplicationChangeWidgetData.builder();

    // Act
    ImmutableApplicationChangeWidgetData.Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData.Builder#from(ApplicationChangeWidgetData)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationChangeWidgetData.Builder builderResult = ImmutableApplicationChangeWidgetData.builder();
    ApplicationChangeWidgetData instance = mock(ApplicationChangeWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableApplicationChangeWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData.Builder#from(ApplicationChangeWidgetData)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationChangeWidgetData.Builder builderResult = ImmutableApplicationChangeWidgetData.builder();

    HashSet<ApplicationChangeWidgetDatum> applicationChangeWidgetDatumSet = new HashSet<>();
    applicationChangeWidgetDatumSet.add(new ImmutableApplicationChangeWidgetDatum.Json());
    ApplicationChangeWidgetData instance = mock(ApplicationChangeWidgetData.class);
    when(instance.cellData()).thenReturn(applicationChangeWidgetDatumSet);

    // Act
    ImmutableApplicationChangeWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData#copyOf(ApplicationChangeWidgetData)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationChangeWidgetData instance = mock(ApplicationChangeWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableApplicationChangeWidgetData actualCopyOfResult = ImmutableApplicationChangeWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertTrue(actualCopyOfResult.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData#copyOf(ApplicationChangeWidgetData)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ApplicationChangeWidgetDatum> applicationChangeWidgetDatumSet = new HashSet<>();
    applicationChangeWidgetDatumSet.add(new ImmutableApplicationChangeWidgetDatum.Json());
    ApplicationChangeWidgetData instance = mock(ApplicationChangeWidgetData.class);
    when(instance.cellData()).thenReturn(applicationChangeWidgetDatumSet);

    // Act
    ImmutableApplicationChangeWidgetData actualCopyOfResult = ImmutableApplicationChangeWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, actualCopyOfResult.cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData#copyOf(ApplicationChangeWidgetData)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<ApplicationChangeWidgetDatum> applicationChangeWidgetDatumSet = new HashSet<>();
    applicationChangeWidgetDatumSet.add(new ImmutableApplicationChangeWidgetDatum.Json());
    applicationChangeWidgetDatumSet.add(new ImmutableApplicationChangeWidgetDatum.Json());
    ApplicationChangeWidgetData instance = mock(ApplicationChangeWidgetData.class);
    when(instance.cellData()).thenReturn(applicationChangeWidgetDatumSet);

    // Act
    ImmutableApplicationChangeWidgetData actualCopyOfResult = ImmutableApplicationChangeWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(applicationChangeWidgetDatumSet, actualCopyOfResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData#fromJson(ImmutableApplicationChangeWidgetData.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationChangeWidgetData.Json json = new ImmutableApplicationChangeWidgetData.Json();

    // Act and Assert
    Set<ApplicationChangeWidgetDatum> cellDataResult = ImmutableApplicationChangeWidgetData.fromJson(json).cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(json.cellData, cellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData#fromJson(ImmutableApplicationChangeWidgetData.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableApplicationChangeWidgetData.Json json = new ImmutableApplicationChangeWidgetData.Json();
    json.setCellData(null);

    // Act and Assert
    assertTrue(ImmutableApplicationChangeWidgetData.fromJson(json).cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData#fromJson(ImmutableApplicationChangeWidgetData.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<ApplicationChangeWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableApplicationChangeWidgetDatum.Json());

    ImmutableApplicationChangeWidgetData.Json json = new ImmutableApplicationChangeWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(1, ImmutableApplicationChangeWidgetData.fromJson(json).cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData#fromJson(ImmutableApplicationChangeWidgetData.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<ApplicationChangeWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableApplicationChangeWidgetDatum.Json());
    cellData.add(new ImmutableApplicationChangeWidgetDatum.Json());

    ImmutableApplicationChangeWidgetData.Json json = new ImmutableApplicationChangeWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(cellData, ImmutableApplicationChangeWidgetData.fromJson(json).cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetData.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationChangeWidgetData.Json()).cellData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableApplicationChangeWidgetData.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableApplicationChangeWidgetData.Json()).cellData.isEmpty());
  }
}
