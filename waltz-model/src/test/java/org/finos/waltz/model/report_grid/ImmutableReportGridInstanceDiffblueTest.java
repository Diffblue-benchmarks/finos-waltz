package org.finos.waltz.model.report_grid;

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
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableReportGridInstanceDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addAllCellData(Iterable)}
   */
  @Test
  void testBuilderAddAllCellData2() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingSchemeItems() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addAllSubjects(Iterable)}
   */
  @Test
  void testBuilderAddAllSubjects() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSubjects(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addAllSubjects(Iterable)}
   */
  @Test
  void testBuilderAddAllSubjects2() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSubjects(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addCellData(ReportGridCell)}
   */
  @Test
  void testBuilderAddCellData() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    ImmutableReportGridInstance.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableReportGridCell.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addCellData(ReportGridCell)}
   */
  @Test
  void testBuilderAddCellData2() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Act
    ImmutableReportGridInstance.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableReportGridCell.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addCellData(ReportGridCell[])}
   */
  @Test
  void testBuilderAddCellData3() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    ImmutableReportGridInstance.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableReportGridCell.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addCellData(ReportGridCell[])}
   */
  @Test
  void testBuilderAddCellData4() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Act
    ImmutableReportGridInstance.Builder actualAddCellDataResult = builderResult
        .addCellData(new ImmutableReportGridCell.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  void testBuilderAddRatingSchemeItems() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    ImmutableReportGridInstance.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  void testBuilderAddRatingSchemeItems2() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    ImmutableReportGridInstance.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addSubjects(ReportSubject)}
   */
  @Test
  void testBuilderAddSubjects() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    ImmutableReportGridInstance.Builder actualAddSubjectsResult = builderResult
        .addSubjects(new ImmutableReportSubject.Json());

    // Assert
    assertEquals(1, builderResult.build().subjects().size());
    assertSame(builderResult, actualAddSubjectsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addSubjects(ReportSubject)}
   */
  @Test
  void testBuilderAddSubjects2() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Act
    ImmutableReportGridInstance.Builder actualAddSubjectsResult = builderResult
        .addSubjects(new ImmutableReportSubject.Json());

    // Assert
    assertEquals(1, builderResult.build().subjects().size());
    assertSame(builderResult, actualAddSubjectsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addSubjects(ReportSubject[])}
   */
  @Test
  void testBuilderAddSubjects3() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    ImmutableReportGridInstance.Builder actualAddSubjectsResult = builderResult
        .addSubjects(new ImmutableReportSubject.Json());

    // Assert
    assertEquals(1, builderResult.build().subjects().size());
    assertSame(builderResult, actualAddSubjectsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#addSubjects(ReportSubject[])}
   */
  @Test
  void testBuilderAddSubjects4() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Act
    ImmutableReportGridInstance.Builder actualAddSubjectsResult = builderResult
        .addSubjects(new ImmutableReportSubject.Json());

    // Assert
    assertEquals(1, builderResult.build().subjects().size());
    assertSame(builderResult, actualAddSubjectsResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridInstance.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableReportGridInstance.builder().build().cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#cellData(Iterable)}
   */
  @Test
  void testBuilderCellData2() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#from(ReportGridInstance)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#from(ReportGridInstance)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();
    reportGridCellSet.add(json);
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(reportGridCellSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    ImmutableReportGridInstance buildResult = builderResult.build();
    assertEquals(1, buildResult.cellData().size());
    assertSame(builderResult, actualFromResult);
    Set<Long> resultLongSet = json.ratingIdValues;
    assertSame(resultLongSet, buildResult.ratingSchemeItems());
    assertSame(resultLongSet, buildResult.subjects());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#from(ReportGridInstance)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);
    when(instance.subjects()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#from(ReportGridInstance)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();
    reportSubjectSet.add(new ImmutableReportSubject.Json());
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    // Act
    ImmutableReportGridInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertEquals(1, builderResult.build().subjects().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderRatingSchemeItems() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#subjects(Iterable)}
   */
  @Test
  void testBuilderSubjects() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjects(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Builder#subjects(Iterable)}
   */
  @Test
  void testBuilderSubjects2() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.subjects(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#copyOf(ReportGridInstance)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridInstance actualCopyOfResult = ImmutableReportGridInstance.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    Set<ReportGridCell> cellDataResult = actualCopyOfResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualCopyOfResult.ratingSchemeItems());
    assertSame(cellDataResult, actualCopyOfResult.subjects());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#copyOf(ReportGridInstance)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();
    reportGridCellSet.add(json);
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(reportGridCellSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridInstance actualCopyOfResult = ImmutableReportGridInstance.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertEquals(1, actualCopyOfResult.cellData().size());
    Set<RatingSchemeItem> ratingSchemeItemsResult = actualCopyOfResult.ratingSchemeItems();
    assertTrue(ratingSchemeItemsResult.isEmpty());
    Set<Long> resultLongSet = json.ratingIdValues;
    assertSame(resultLongSet, ratingSchemeItemsResult);
    assertSame(resultLongSet, actualCopyOfResult.subjects());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#copyOf(ReportGridInstance)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();
    reportGridCellSet.add(new ImmutableReportGridCell.Json());
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();
    reportGridCellSet.add(json);
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(reportGridCellSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridInstance actualCopyOfResult = ImmutableReportGridInstance.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    Set<RatingSchemeItem> ratingSchemeItemsResult = actualCopyOfResult.ratingSchemeItems();
    assertTrue(ratingSchemeItemsResult.isEmpty());
    assertEquals(reportGridCellSet, actualCopyOfResult.cellData());
    Set<Long> resultLongSet = json.ratingIdValues;
    assertSame(resultLongSet, ratingSchemeItemsResult);
    assertSame(resultLongSet, actualCopyOfResult.subjects());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#copyOf(ReportGridInstance)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);
    when(instance.subjects()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridInstance actualCopyOfResult = ImmutableReportGridInstance.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertEquals(1, actualCopyOfResult.ratingSchemeItems().size());
    Set<ReportGridCell> cellDataResult = actualCopyOfResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualCopyOfResult.subjects());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#copyOf(ReportGridInstance)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();
    reportSubjectSet.add(new ImmutableReportSubject.Json());
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    // Act
    ImmutableReportGridInstance actualCopyOfResult = ImmutableReportGridInstance.copyOf(instance);

    // Assert
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertEquals(1, actualCopyOfResult.subjects().size());
    Set<ReportGridCell> cellDataResult = actualCopyOfResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#fromJson(ImmutableReportGridInstance.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    Set<ReportGridCell> cellDataResult = actualFromJsonResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    Set<ReportSubject> reportSubjectSet = json.subjects;
    assertSame(reportSubjectSet, cellDataResult);
    assertSame(reportSubjectSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(reportSubjectSet, actualFromJsonResult.subjects());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#fromJson(ImmutableReportGridInstance.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();
    json.setSubjects(null);
    json.setRatingSchemeItems(null);
    json.setCellData(null);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    Set<ReportGridCell> cellDataResult = actualFromJsonResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualFromJsonResult.ratingSchemeItems());
    assertSame(cellDataResult, actualFromJsonResult.subjects());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#fromJson(ImmutableReportGridInstance.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<ReportGridCell> cellData = new LinkedHashSet<>();
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();
    cellData.add(json);

    ImmutableReportGridInstance.Json json2 = new ImmutableReportGridInstance.Json();
    json2.setSubjects(null);
    json2.setRatingSchemeItems(null);
    json2.setCellData(cellData);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    Set<RatingSchemeItem> ratingSchemeItemsResult = actualFromJsonResult.ratingSchemeItems();
    assertTrue(ratingSchemeItemsResult.isEmpty());
    Set<Long> resultLongSet = json.ratingIdValues;
    assertSame(resultLongSet, ratingSchemeItemsResult);
    assertSame(resultLongSet, actualFromJsonResult.subjects());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#fromJson(ImmutableReportGridInstance.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(mock(RatingSchemeItem.class));

    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();
    json.setSubjects(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setCellData(null);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    Set<ReportGridCell> cellDataResult = actualFromJsonResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualFromJsonResult.subjects());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#fromJson(ImmutableReportGridInstance.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<ReportSubject> subjects = new LinkedHashSet<>();
    subjects.add(new ImmutableReportSubject.Json());

    ImmutableReportGridInstance.Json json = new ImmutableReportGridInstance.Json();
    json.setSubjects(subjects);
    json.setRatingSchemeItems(null);
    json.setCellData(null);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.subjects().size());
    Set<ReportGridCell> cellDataResult = actualFromJsonResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance#fromJson(ImmutableReportGridInstance.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    LinkedHashSet<ReportGridCell> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableReportGridCell.Json());
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();
    cellData.add(json);

    ImmutableReportGridInstance.Json json2 = new ImmutableReportGridInstance.Json();
    json2.setSubjects(null);
    json2.setRatingSchemeItems(null);
    json2.setCellData(cellData);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json2);

    // Assert
    Set<RatingSchemeItem> ratingSchemeItemsResult = actualFromJsonResult.ratingSchemeItems();
    assertTrue(ratingSchemeItemsResult.isEmpty());
    assertEquals(cellData, actualFromJsonResult.cellData());
    Set<Long> resultLongSet = json.ratingIdValues;
    assertSame(resultLongSet, ratingSchemeItemsResult);
    assertSame(resultLongSet, actualFromJsonResult.subjects());
  }

  /**
   * Method under test: {@link ImmutableReportGridInstance.Json#cellData()}
   */
  @Test
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInstance.Json()).cellData());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridInstance.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridInstance.Json actualJson = new ImmutableReportGridInstance.Json();

    // Assert
    assertTrue(actualJson.cellData.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
    assertTrue(actualJson.subjects.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInstance.Json#ratingSchemeItems()}
   */
  @Test
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridInstance.Json()).ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableReportGridInstance.Json#subjects()}
   */
  @Test
  void testJsonSubjects() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInstance.Json()).subjects());
  }
}
