package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.report_grid.ImmutableReportGridInstance.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridInstance.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridInstanceDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCellData(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCellData(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCellData(Iterable)"})
  void testBuilderAddAllCellData_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRatingSchemeItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingSchemeItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingSchemeItems(Iterable)"})
  void testBuilderAddAllRatingSchemeItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingSchemeItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllSubjects(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllSubjects(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSubjects(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllSubjects(Iterable)"})
  void testBuilderAddAllSubjects_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSubjects(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addCellData(ReportGridCell)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableReportGridCell.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder addCellData(ReportGridCell) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(ReportGridCell)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableReportGridCell.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(ReportGridCell[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableReportGridCell.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(ReportGridCell[])}
   */
  @Test
  @DisplayName("Test Builder addCellData(ReportGridCell[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(ReportGridCell[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableReportGridCell.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem)"})
  void testBuilderAddRatingSchemeItemsWithElement() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem[])"})
  void testBuilderAddRatingSchemeItemsWithElements() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addSubjects(ReportSubject)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableReportSubject.Json} (default constructor).</li>
   *   <li>Then builder build subjects size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSubjects(ReportSubject)}
   */
  @Test
  @DisplayName("Test Builder addSubjects(ReportSubject) with 'element'; when Json (default constructor); then builder build subjects size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSubjects(ReportSubject)"})
  void testBuilderAddSubjectsWithElement_whenJson_thenBuilderBuildSubjectsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddSubjectsResult = builderResult.addSubjects(new ImmutableReportSubject.Json());

    // Assert
    assertEquals(1, builderResult.build().subjects().size());
    assertSame(builderResult, actualAddSubjectsResult);
  }

  /**
   * Test Builder {@link Builder#addSubjects(ReportSubject[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableReportSubject.Json} (default constructor).</li>
   *   <li>Then builder build subjects size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSubjects(ReportSubject[])}
   */
  @Test
  @DisplayName("Test Builder addSubjects(ReportSubject[]) with 'elements'; when Json (default constructor); then builder build subjects size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSubjects(ReportSubject[])"})
  void testBuilderAddSubjectsWithElements_whenJson_thenBuilderBuildSubjectsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddSubjectsResult = builderResult.addSubjects(new ImmutableReportSubject.Json());

    // Assert
    assertEquals(1, builderResult.build().subjects().size());
    assertSame(builderResult, actualAddSubjectsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableReportGridInstance.builder().build().cellData().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellData(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#cellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder cellData(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellData(Iterable)"})
  void testBuilderCellData_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInstance)}.
   * <ul>
   *   <li>Given {@link ImmutableReportGridCell.Json} (default constructor).</li>
   *   <li>Then return build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridInstance)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridInstance); given Json (default constructor); then return build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridInstance)"})
  void testBuilderFrom_givenJson_thenReturnBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();
    Builder builderResult2 = ImmutableReportGridInstance.builder();
    builderResult2.addCellData(new ImmutableReportGridCell.Json());
    builderResult2.addSubjects(new ImmutableReportSubject.Json());
    ImmutableReportGridInstance instance = builderResult2.build();

    // Act and Assert
    ImmutableReportGridInstance buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.cellData().size());
    assertEquals(1, buildResult.subjects().size());
    assertTrue(buildResult.ratingSchemeItems().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInstance)}.
   * <ul>
   *   <li>Given {@link ImmutableReportSubject.Json} (default constructor).</li>
   *   <li>Then return build ratingSchemeItems is build cellData.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridInstance)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridInstance); given Json (default constructor); then return build ratingSchemeItems is build cellData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridInstance)"})
  void testBuilderFrom_givenJson_thenReturnBuildRatingSchemeItemsIsBuildCellData() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();
    Builder builderResult2 = ImmutableReportGridInstance.builder();
    builderResult2.addSubjects(new ImmutableReportSubject.Json());
    ImmutableReportGridInstance instance = builderResult2.build();

    // Act and Assert
    ImmutableReportGridInstance buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.subjects().size());
    Set<ReportGridCell> cellDataResult = buildResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(cellDataResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInstance)}.
   * <ul>
   *   <li>Then return build ratingSchemeItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridInstance)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridInstance); then return build ratingSchemeItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridInstance)"})
  void testBuilderFrom_thenReturnBuildRatingSchemeItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();
    Builder builderResult2 = ImmutableReportGridInstance.builder();
    builderResult2.addRatingSchemeItems(mock(RatingSchemeItem.class));
    builderResult2.addSubjects(new ImmutableReportSubject.Json());
    ImmutableReportGridInstance instance = builderResult2.build();

    // Act and Assert
    ImmutableReportGridInstance buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.ratingSchemeItems().size());
    assertEquals(1, buildResult.subjects().size());
    assertTrue(buildResult.cellData().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInstance)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build subjects is build cellData.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridInstance)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridInstance); when builder build; then return build subjects is build cellData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridInstance)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildSubjectsIsBuildCellData() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();
    ImmutableReportGridInstance instance = ImmutableReportGridInstance.builder().build();

    // Act and Assert
    ImmutableReportGridInstance buildResult = builderResult.from(instance).build();
    Set<ReportGridCell> cellDataResult = buildResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(cellDataResult, buildResult.ratingSchemeItems());
    assertSame(cellDataResult, buildResult.subjects());
  }

  /**
   * Test Builder {@link Builder#ratingSchemeItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingSchemeItems(Iterable)"})
  void testBuilderRatingSchemeItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#subjects(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#subjects(Iterable)}
   */
  @Test
  @DisplayName("Test Builder subjects(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.subjects(Iterable)"})
  void testBuilderSubjects_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjects(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableReportGridInstance#copyOf(ReportGridInstance)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return cellData Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#copyOf(ReportGridInstance)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridInstance); when builder build; then return cellData Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.copyOf(ReportGridInstance)"})
  void testCopyOf_whenBuilderBuild_thenReturnCellDataEmpty() {
    // Arrange
    ImmutableReportGridInstance instance = ImmutableReportGridInstance.builder().build();

    // Act
    ImmutableReportGridInstance actualCopyOfResult = ImmutableReportGridInstance.copyOf(instance);

    // Assert
    Set<ReportGridCell> cellDataResult = actualCopyOfResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualCopyOfResult.ratingSchemeItems());
    assertSame(cellDataResult, actualCopyOfResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}, and {@link ImmutableReportGridInstance#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridInstance#equals(Object)}
   *   <li>{@link ImmutableReportGridInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridInstance.equals(Object)",
      "int ImmutableReportGridInstance.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridInstance buildResult = ImmutableReportGridInstance.builder().build();
    ImmutableReportGridInstance buildResult2 = ImmutableReportGridInstance.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}, and {@link ImmutableReportGridInstance#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridInstance#equals(Object)}
   *   <li>{@link ImmutableReportGridInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridInstance.equals(Object)",
      "int ImmutableReportGridInstance.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridInstance buildResult = ImmutableReportGridInstance.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridInstance.equals(Object)",
      "int ImmutableReportGridInstance.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addSubjects(new ImmutableReportSubject.Json());
    ImmutableReportGridInstance buildResult = builderResult.build();
    ImmutableReportGridInstance buildResult2 = ImmutableReportGridInstance.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridInstance.equals(Object)",
      "int ImmutableReportGridInstance.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));
    ImmutableReportGridInstance buildResult = builderResult.build();
    ImmutableReportGridInstance buildResult2 = ImmutableReportGridInstance.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridInstance.equals(Object)",
      "int ImmutableReportGridInstance.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addCellData(new ImmutableReportGridCell.Json());
    ImmutableReportGridInstance buildResult = builderResult.build();
    ImmutableReportGridInstance buildResult2 = ImmutableReportGridInstance.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridInstance.equals(Object)",
      "int ImmutableReportGridInstance.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridInstance buildResult = ImmutableReportGridInstance.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableReportGridInstance.equals(Object)",
      "int ImmutableReportGridInstance.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridInstance buildResult = ImmutableReportGridInstance.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableReportGridInstance");
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableReportGridCell.Json} (default constructor).</li>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<ReportGridCell> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableReportGridCell.Json());
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setSubjects(null);
    json2.setRatingSchemeItems(null);
    json2.setCellData(cellData);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json2);

    // Assert
    assertTrue(actualFromJsonResult.ratingSchemeItems().isEmpty());
    assertEquals(cellData, actualFromJsonResult.cellData());
    Set<Long> expectedSubjectsResult = json.ratingIdValues;
    assertSame(expectedSubjectsResult, actualFromJsonResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableReportGridCell.Json} (default constructor).</li>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<ReportGridCell> cellData = new LinkedHashSet<>();
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setSubjects(null);
    json2.setRatingSchemeItems(null);
    json2.setCellData(cellData);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.ratingSchemeItems().isEmpty());
    Set<Long> expectedSubjectsResult = json.ratingIdValues;
    assertSame(expectedSubjectsResult, actualFromJsonResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableReportSubject.Json} (default constructor).</li>
   *   <li>Then return subjects size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return subjects size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnSubjectsSizeIsOne() {
    // Arrange
    LinkedHashSet<ReportSubject> subjects = new LinkedHashSet<>();
    subjects.add(new ImmutableReportSubject.Json());

    Json json = new Json();
    json.setSubjects(subjects);
    json.setRatingSchemeItems(null);
    json.setCellData(null);

    // Act and Assert
    assertEquals(1, ImmutableReportGridInstance.fromJson(json).subjects().size());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.</li>
   *   <li>Then return cellData Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) CellData is 'null'; then return cellData Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonCellDataIsNull_thenReturnCellDataEmpty() {
    // Arrange
    Json json = new Json();
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
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_thenReturnRatingSchemeItemsSizeIsOne() {
    // Arrange
    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(mock(RatingSchemeItem.class));

    Json json = new Json();
    json.setSubjects(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setCellData(null);

    // Act and Assert
    assertEquals(1, ImmutableReportGridInstance.fromJson(json).ratingSchemeItems().size());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return ratingSchemeItems is {@link Json} (default constructor) {@link Json#subjects}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return ratingSchemeItems is Json (default constructor) subjects")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnRatingSchemeItemsIsJsonSubjects() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    Set<ReportSubject> reportSubjectSet = json.subjects;
    assertSame(reportSubjectSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(reportSubjectSet, actualFromJsonResult.subjects());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridInstance#toString()}
   *   <li>{@link ImmutableReportGridInstance#cellData()}
   *   <li>{@link ImmutableReportGridInstance#ratingSchemeItems()}
   *   <li>{@link ImmutableReportGridInstance#subjects()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableReportGridInstance.cellData()",
      "Set ImmutableReportGridInstance.ratingSchemeItems()", "Set ImmutableReportGridInstance.subjects()",
      "String ImmutableReportGridInstance.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridInstance buildResult = ImmutableReportGridInstance.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<ReportGridCell> actualCellDataResult = buildResult.cellData();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult = buildResult.ratingSchemeItems();
    Set<ReportSubject> actualSubjectsResult = buildResult.subjects();

    // Assert
    assertEquals("ReportGridInstance{subjects=[], ratingSchemeItems=[], cellData=[]}", actualToStringResult);
    assertTrue(actualCellDataResult.isEmpty());
    assertSame(actualCellDataResult, actualRatingSchemeItemsResult);
    assertSame(actualCellDataResult, actualSubjectsResult);
  }

  /**
   * Test Json {@link Json#cellData()}.
   * <p>
   * Method under test: {@link Json#cellData()}
   */
  @Test
  @DisplayName("Test Json cellData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.cellData()"})
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cellData());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertTrue(actualJson.cellData.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
    assertTrue(actualJson.subjects.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingSchemeItems()}.
   * <p>
   * Method under test: {@link Json#ratingSchemeItems()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.ratingSchemeItems()"})
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingSchemeItems());
  }

  /**
   * Test Json {@link Json#subjects()}.
   * <p>
   * Method under test: {@link Json#subjects()}
   */
  @Test
  @DisplayName("Test Json subjects()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.subjects()"})
  void testJsonSubjects() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#withCellData(ReportGridCell[])} with {@code ReportGridCell[]}.
   * <ul>
   *   <li>When {@link ImmutableReportGridCell.Json} (default constructor).</li>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#withCellData(ReportGridCell[])}
   */
  @Test
  @DisplayName("Test withCellData(ReportGridCell[]) with 'ReportGridCell[]'; when Json (default constructor); then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.withCellData(ReportGridCell[])"})
  void testWithCellDataWithReportGridCell_whenJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    ImmutableReportGridInstance buildResult = ImmutableReportGridInstance.builder().build();
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();

    // Act
    ImmutableReportGridInstance actualWithCellDataResult = buildResult.withCellData(json);

    // Assert
    assertEquals(1, actualWithCellDataResult.cellData().size());
    assertTrue(actualWithCellDataResult.ratingSchemeItems().isEmpty());
    Set<Long> expectedSubjectsResult = json.ratingIdValues;
    assertSame(expectedSubjectsResult, actualWithCellDataResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#withRatingSchemeItems(RatingSchemeItem[])} with {@code RatingSchemeItem[]}.
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableReportGridInstance ImmutableReportGridInstance.withRatingSchemeItems(RatingSchemeItem[])"})
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableReportGridInstance buildResult = ImmutableReportGridInstance.builder().build();

    // Act
    ImmutableReportGridInstance actualWithRatingSchemeItemsResult = buildResult
        .withRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    Set<ReportGridCell> cellDataResult = actualWithRatingSchemeItemsResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualWithRatingSchemeItemsResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#withSubjects(ReportSubject[])} with {@code ReportSubject[]}.
   * <ul>
   *   <li>When {@link ImmutableReportSubject.Json} (default constructor).</li>
   *   <li>Then return subjects size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableReportGridInstance#withSubjects(ReportSubject[])}
   */
  @Test
  @DisplayName("Test withSubjects(ReportSubject[]) with 'ReportSubject[]'; when Json (default constructor); then return subjects size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.withSubjects(ReportSubject[])"})
  void testWithSubjectsWithReportSubject_whenJson_thenReturnSubjectsSizeIsOne() {
    // Arrange
    ImmutableReportGridInstance buildResult = ImmutableReportGridInstance.builder().build();

    // Act
    ImmutableReportGridInstance actualWithSubjectsResult = buildResult.withSubjects(new ImmutableReportSubject.Json());

    // Assert
    assertEquals(1, actualWithSubjectsResult.subjects().size());
    Set<ReportGridCell> cellDataResult = actualWithSubjectsResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualWithSubjectsResult.ratingSchemeItems());
  }
}
