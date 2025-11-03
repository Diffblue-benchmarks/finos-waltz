package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.web.json.ImmutableGrid.Builder;
import org.finos.waltz.web.json.ImmutableGrid.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableGridDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRows(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build rows Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRows(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRows(Iterable); when ArrayList(); then return build rows Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRows(Iterable)"})
  void testBuilderAddAllRows_whenArrayList_thenReturnBuildRowsEmpty() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    // Act
    Builder actualAddAllRowsResult = builderResult.addAllRows(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllRowsResult.build().rows().isEmpty());
    assertSame(builderResult, actualAddAllRowsResult);
  }

  /**
   * Test Builder {@link Builder#addRows(Row)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableRow.Json} (default constructor).</li>
   *   <li>Then builder build rows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRows(Row)}
   */
  @Test
  @DisplayName("Test Builder addRows(Row) with 'element'; when Json (default constructor); then builder build rows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRows(Row)"})
  void testBuilderAddRowsWithElement_whenJson_thenBuilderBuildRowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableRow.Json element = new ImmutableRow.Json();

    // Act
    Builder actualAddRowsResult = builderResult.addRows(element);

    // Assert
    List<Row> rowsResult = builderResult.build().rows();
    assertEquals(1, rowsResult.size());
    assertSame(element, rowsResult.get(0));
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Test Builder {@link Builder#addRows(Row[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableRow.Json} (default constructor).</li>
   *   <li>Then builder build rows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRows(Row[])}
   */
  @Test
  @DisplayName("Test Builder addRows(Row[]) with 'elements'; when Json (default constructor); then builder build rows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRows(Row[])"})
  void testBuilderAddRowsWithElements_whenJson_thenBuilderBuildRowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableRow.Json json = new ImmutableRow.Json();

    // Act
    Builder actualAddRowsResult = builderResult.addRows(json);

    // Assert
    List<Row> rowsResult = builderResult.build().rows();
    assertEquals(1, rowsResult.size());
    assertSame(json, rowsResult.get(0));
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#columnDescriptors(List)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid Builder.build()", "Builder Builder.columnDescriptors(List)"})
  void testBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    Builder columnDescriptorsResult = builderResult.columnDescriptors(new ArrayList<>());
    Optional<? extends List<ColumnDescriptor>> columnDescriptors = Optional.of(new ArrayList<>());

    // Act and Assert
    assertTrue(columnDescriptorsResult.columnDescriptors(columnDescriptors).build().rows().isEmpty());
  }

  /**
   * Test Builder {@link Builder#columnDescriptors(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#columnDescriptors(Optional)}
   */
  @Test
  @DisplayName("Test Builder columnDescriptors(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.columnDescriptors(Optional)"})
  void testBuilderColumnDescriptorsWithOptional() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    Optional<? extends List<ColumnDescriptor>> columnDescriptors = Optional.of(new ArrayList<>());

    // Act
    Builder actualColumnDescriptorsResult = builderResult.columnDescriptors(columnDescriptors);

    // Assert
    assertTrue(actualColumnDescriptorsResult.build().rows().isEmpty());
    assertSame(builderResult, actualColumnDescriptorsResult);
  }

  /**
   * Test Builder {@link Builder#from(Grid)}.
   * <ul>
   *   <li>Given {@link ImmutableRow.Json} (default constructor).</li>
   *   <li>When builder addRows {@link ImmutableRow.Json} (default constructor).</li>
   *   <li>Then return build rows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Grid)}
   */
  @Test
  @DisplayName("Test Builder from(Grid); given Json (default constructor); when builder addRows Json (default constructor); then return build rows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Grid)"})
  void testBuilderFrom_givenJson_whenBuilderAddRowsJson_thenReturnBuildRowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    Builder builderResult2 = ImmutableGrid.builder();
    ImmutableRow.Json element = new ImmutableRow.Json();
    builderResult2.addRows(element);
    ImmutableGrid instance = builderResult2.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    List<Row> rowsResult = builderResult.from(instance).build().rows();
    assertEquals(1, rowsResult.size());
    assertSame(element, rowsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(Grid)}.
   * <ul>
   *   <li>Then builder build is builder columnDescriptors {@link ArrayList#ArrayList()} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Grid)}
   */
  @Test
  @DisplayName("Test Builder from(Grid); then builder build is builder columnDescriptors ArrayList() build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Grid)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderColumnDescriptorsArrayListBuild() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    Builder builderResult2 = ImmutableGrid.builder();
    ImmutableGrid instance = builderResult2.columnDescriptors(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rows(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build rows Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#rows(Iterable)}
   */
  @Test
  @DisplayName("Test Builder rows(Iterable); when ArrayList(); then return build rows Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rows(Iterable)"})
  void testBuilderRows_whenArrayList_thenReturnBuildRowsEmpty() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    // Act
    Builder actualRowsResult = builderResult.rows(new ArrayList<>());

    // Assert
    assertTrue(actualRowsResult.build().rows().isEmpty());
    assertSame(builderResult, actualRowsResult);
  }

  /**
   * Test {@link ImmutableGrid#columnDescriptors()}.
   * <p>
   * Method under test: {@link ImmutableGrid#columnDescriptors()}
   */
  @Test
  @DisplayName("Test columnDescriptors()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableGrid.columnDescriptors()"})
  void testColumnDescriptors() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act
    Optional<List<ColumnDescriptor>> actualColumnDescriptorsResult = buildResult.columnDescriptors();

    // Assert
    assertTrue(actualColumnDescriptorsResult.get().isEmpty());
    assertTrue(actualColumnDescriptorsResult.isPresent());
  }

  /**
   * Test {@link ImmutableGrid#copyOf(Grid)}.
   * <ul>
   *   <li>When builder columnDescriptors {@link ArrayList#ArrayList()} build.</li>
   *   <li>Then return rows Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#copyOf(Grid)}
   */
  @Test
  @DisplayName("Test copyOf(Grid); when builder columnDescriptors ArrayList() build; then return rows Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.copyOf(Grid)"})
  void testCopyOf_whenBuilderColumnDescriptorsArrayListBuild_thenReturnRowsEmpty() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid instance = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(ImmutableGrid.copyOf(instance).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}, and {@link ImmutableGrid#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableGrid#equals(Object)}
   *   <li>{@link ImmutableGrid#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();
    Builder builderResult2 = ImmutableGrid.builder();
    ImmutableGrid buildResult2 = builderResult2.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}, and {@link ImmutableGrid#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableGrid#equals(Object)}
   *   <li>{@link ImmutableGrid#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    builderResult.addRows(new ImmutableRow.Json());
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();
    Builder builderResult2 = ImmutableGrid.builder();
    ImmutableGrid buildResult2 = builderResult2.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<ColumnDescriptor> columnDescriptors = new ArrayList<>();
    columnDescriptors.add(new ImmutableColumnDescriptor.Json());
    ImmutableGrid buildResult = ImmutableGrid.builder().columnDescriptors(columnDescriptors).build();
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult2 = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableGrid");
  }

  /**
   * Test {@link ImmutableGrid#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableRow.Json} (default constructor).</li>
   *   <li>Then return rows is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return rows is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnRowsIsArrayList() {
    // Arrange
    ArrayList<Row> rows = new ArrayList<>();
    rows.add(new ImmutableRow.Json());

    Json json = new Json();
    json.setColumnDescriptors(null);
    json.setRows(rows);

    // Act and Assert
    assertEquals(rows, ImmutableGrid.fromJson(json).rows());
  }

  /**
   * Test {@link ImmutableGrid#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableRow.Json} (default constructor).</li>
   *   <li>Then return rows size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return rows size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnRowsSizeIsTwo() {
    // Arrange
    ArrayList<Row> rows = new ArrayList<>();
    rows.add(new ImmutableRow.Json());
    ImmutableRow.Json json = new ImmutableRow.Json();
    rows.add(json);

    Json json2 = new Json();
    json2.setColumnDescriptors(null);
    json2.setRows(rows);

    // Act and Assert
    List<Row> rowsResult = ImmutableGrid.fromJson(json2).rows();
    assertEquals(2, rowsResult.size());
    assertSame(json, rowsResult.get(1));
  }

  /**
   * Test {@link ImmutableGrid#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Rows is {@code null}.</li>
   *   <li>Then return rows Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Rows is 'null'; then return rows Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonRowsIsNull_thenReturnRowsEmpty() {
    // Arrange
    Json json = new Json();
    json.setColumnDescriptors(null);
    json.setRows(null);

    // Act and Assert
    assertTrue(ImmutableGrid.fromJson(json).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return rows Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return rows Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnRowsEmpty() {
    // Arrange, Act and Assert
    assertTrue(ImmutableGrid.fromJson(new Json()).rows().isEmpty());
  }

  /**
   * Test Json {@link Json#columnDescriptors()}.
   * <p>
   * Method under test: {@link Json#columnDescriptors()}
   */
  @Test
  @DisplayName("Test Json columnDescriptors()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.columnDescriptors()"})
  void testJsonColumnDescriptors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnDescriptors());
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
    assertFalse(actualJson.columnDescriptors.isPresent());
    assertTrue(actualJson.rows.isEmpty());
  }

  /**
   * Test Json {@link Json#rows()}.
   * <p>
   * Method under test: {@link Json#rows()}
   */
  @Test
  @DisplayName("Test Json rows()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.rows()"})
  void testJsonRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rows());
  }

  /**
   * Test {@link ImmutableGrid#rows()}.
   * <p>
   * Method under test: {@link ImmutableGrid#rows()}
   */
  @Test
  @DisplayName("Test rows()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableGrid.rows()"})
  void testRows() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(buildResult.rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#withColumnDescriptors(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableGrid#withColumnDescriptors(Optional)}
   */
  @Test
  @DisplayName("Test withColumnDescriptors(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withColumnDescriptors(Optional)"})
  void testWithColumnDescriptorsWithOptional() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();
    Optional<? extends List<ColumnDescriptor>> optional = Optional.of(new ArrayList<>());

    // Act and Assert
    assertTrue(buildResult.withColumnDescriptors(optional).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#withColumnDescriptors(List)} with {@code value}.
   * <ul>
   *   <li>Given {@link ImmutableColumnDescriptor.Json} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ImmutableColumnDescriptor.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  @DisplayName("Test withColumnDescriptors(List) with 'value'; given Json (default constructor); when ArrayList() add Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withColumnDescriptors(List)"})
  void testWithColumnDescriptorsWithValue_givenJson_whenArrayListAddJson() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();

    ArrayList<ColumnDescriptor> value = new ArrayList<>();
    value.add(new ImmutableColumnDescriptor.Json());

    // Act and Assert
    assertTrue(buildResult.withColumnDescriptors(value).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#withColumnDescriptors(List)} with {@code value}.
   * <ul>
   *   <li>Given {@link ImmutableColumnDescriptor.Json} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ImmutableColumnDescriptor.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  @DisplayName("Test withColumnDescriptors(List) with 'value'; given Json (default constructor); when ArrayList() add Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withColumnDescriptors(List)"})
  void testWithColumnDescriptorsWithValue_givenJson_whenArrayListAddJson2() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();

    ArrayList<ColumnDescriptor> value = new ArrayList<>();
    value.add(new ImmutableColumnDescriptor.Json());
    value.add(new ImmutableColumnDescriptor.Json());

    // Act and Assert
    assertTrue(buildResult.withColumnDescriptors(value).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#withColumnDescriptors(List)} with {@code value}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  @DisplayName("Test withColumnDescriptors(List) with 'value'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withColumnDescriptors(List)"})
  void testWithColumnDescriptorsWithValue_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(buildResult.withColumnDescriptors(new ArrayList<>()).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#withRows(Row[])} with {@code Row[]}.
   * <ul>
   *   <li>When {@link ImmutableRow.Json} (default constructor).</li>
   *   <li>Then return rows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableGrid#withRows(Row[])}
   */
  @Test
  @DisplayName("Test withRows(Row[]) with 'Row[]'; when Json (default constructor); then return rows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withRows(Row[])"})
  void testWithRowsWithRow_whenJson_thenReturnRowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid buildResult = builderResult.columnDescriptors(new ArrayList<>()).build();
    ImmutableRow.Json json = new ImmutableRow.Json();

    // Act and Assert
    List<Row> rowsResult = buildResult.withRows(json).rows();
    assertEquals(1, rowsResult.size());
    assertSame(json, rowsResult.get(0));
  }
}
