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

class ImmutableAssessmentRatingsWidgetDataDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData.Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    // Act
    ImmutableAssessmentRatingsWidgetData.Builder actualAddAllCellDataResult = builderResult
        .addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData.Builder#addCellData(AssessmentRatingsWidgetDatum)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData.Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    // Act
    ImmutableAssessmentRatingsWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableAssessmentRatingsWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData.Builder#addCellData(AssessmentRatingsWidgetDatum[])}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData.Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    // Act
    ImmutableAssessmentRatingsWidgetData.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableAssessmentRatingsWidgetDatum.Json());

    // Assert
    assertEquals(1, actualAddCellDataResult.build().cellData().size());
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAssessmentRatingsWidgetData.builder().build().cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData.Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    // Act
    ImmutableAssessmentRatingsWidgetData.Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData.Builder#from(AssessmentRatingsWidgetData)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData.Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();
    AssessmentRatingsWidgetData instance = mock(AssessmentRatingsWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentRatingsWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData.Builder#from(AssessmentRatingsWidgetData)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData.Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    HashSet<AssessmentRatingsWidgetDatum> assessmentRatingsWidgetDatumSet = new HashSet<>();
    assessmentRatingsWidgetDatumSet.add(new ImmutableAssessmentRatingsWidgetDatum.Json());
    AssessmentRatingsWidgetData instance = mock(AssessmentRatingsWidgetData.class);
    when(instance.cellData()).thenReturn(assessmentRatingsWidgetDatumSet);

    // Act
    ImmutableAssessmentRatingsWidgetData.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData#copyOf(AssessmentRatingsWidgetData)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingsWidgetData instance = mock(AssessmentRatingsWidgetData.class);
    when(instance.cellData()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentRatingsWidgetData actualCopyOfResult = ImmutableAssessmentRatingsWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertTrue(actualCopyOfResult.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData#copyOf(AssessmentRatingsWidgetData)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentRatingsWidgetDatum> assessmentRatingsWidgetDatumSet = new HashSet<>();
    assessmentRatingsWidgetDatumSet.add(new ImmutableAssessmentRatingsWidgetDatum.Json());
    AssessmentRatingsWidgetData instance = mock(AssessmentRatingsWidgetData.class);
    when(instance.cellData()).thenReturn(assessmentRatingsWidgetDatumSet);

    // Act
    ImmutableAssessmentRatingsWidgetData actualCopyOfResult = ImmutableAssessmentRatingsWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(1, actualCopyOfResult.cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData#copyOf(AssessmentRatingsWidgetData)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentRatingsWidgetDatum> assessmentRatingsWidgetDatumSet = new HashSet<>();
    assessmentRatingsWidgetDatumSet.add(new ImmutableAssessmentRatingsWidgetDatum.Json());
    assessmentRatingsWidgetDatumSet.add(new ImmutableAssessmentRatingsWidgetDatum.Json());
    AssessmentRatingsWidgetData instance = mock(AssessmentRatingsWidgetData.class);
    when(instance.cellData()).thenReturn(assessmentRatingsWidgetDatumSet);

    // Act
    ImmutableAssessmentRatingsWidgetData actualCopyOfResult = ImmutableAssessmentRatingsWidgetData.copyOf(instance);

    // Assert
    verify(instance).cellData();
    assertEquals(assessmentRatingsWidgetDatumSet, actualCopyOfResult.cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData#fromJson(ImmutableAssessmentRatingsWidgetData.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData.Json json = new ImmutableAssessmentRatingsWidgetData.Json();

    // Act and Assert
    Set<AssessmentRatingsWidgetDatum> cellDataResult = ImmutableAssessmentRatingsWidgetData.fromJson(json).cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(json.cellData, cellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData#fromJson(ImmutableAssessmentRatingsWidgetData.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData.Json json = new ImmutableAssessmentRatingsWidgetData.Json();
    json.setCellData(null);

    // Act and Assert
    assertTrue(ImmutableAssessmentRatingsWidgetData.fromJson(json).cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData#fromJson(ImmutableAssessmentRatingsWidgetData.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AssessmentRatingsWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAssessmentRatingsWidgetDatum.Json());

    ImmutableAssessmentRatingsWidgetData.Json json = new ImmutableAssessmentRatingsWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(1, ImmutableAssessmentRatingsWidgetData.fromJson(json).cellData().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData#fromJson(ImmutableAssessmentRatingsWidgetData.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<AssessmentRatingsWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAssessmentRatingsWidgetDatum.Json());
    cellData.add(new ImmutableAssessmentRatingsWidgetDatum.Json());

    ImmutableAssessmentRatingsWidgetData.Json json = new ImmutableAssessmentRatingsWidgetData.Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(cellData, ImmutableAssessmentRatingsWidgetData.fromJson(json).cellData());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetData.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingsWidgetData.Json()).cellData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRatingsWidgetData.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableAssessmentRatingsWidgetData.Json()).cellData.isEmpty());
  }
}
