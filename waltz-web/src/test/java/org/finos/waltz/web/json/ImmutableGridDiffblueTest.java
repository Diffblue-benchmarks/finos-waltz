package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.web.json.ImmutableGrid.Builder;
import org.finos.waltz.web.json.ImmutableGrid.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableGridDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRows(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build rows Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRows(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRows(Iterable); when ArrayList(); then return build rows Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link ImmutableRow.Json} (default constructor).
   *   <li>Then builder build rows size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRows(Row)}
   */
  @Test
  @DisplayName(
      "Test Builder addRows(Row) with 'element'; when Json (default constructor); then builder build rows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link ImmutableRow.Json} (default constructor).
   *   <li>Then builder build rows size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRows(Row[])}
   */
  @Test
  @DisplayName(
      "Test Builder addRows(Row[]) with 'elements'; when Json (default constructor); then builder build rows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#columnDescriptors(List)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid Builder.build()", "Builder Builder.columnDescriptors(List)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableGrid.builder();
    Builder actualColumnDescriptorsResult =
        actualBuilderResult.columnDescriptors(new ArrayList<>());
    Optional<? extends List<ColumnDescriptor>> columnDescriptors = Optional.of(new ArrayList<>());

    // Assert
    assertTrue(
        actualColumnDescriptorsResult
            .columnDescriptors(columnDescriptors)
            .build()
            .rows()
            .isEmpty());
  }

  /**
   * Test Builder {@link Builder#columnDescriptors(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#columnDescriptors(Optional)}
   */
  @Test
  @DisplayName("Test Builder columnDescriptors(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then builder build is builder columnDescriptors {@link ArrayList#ArrayList()} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Grid)}
   */
  @Test
  @DisplayName(
      "Test Builder from(Grid); then builder build is builder columnDescriptors ArrayList() build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Grid)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderColumnDescriptorsArrayListBuild() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    Builder builderResult2 = ImmutableGrid.builder();
    ImmutableGrid instance = builderResult2.columnDescriptors(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableGrid actualImmutableGrid = builderResult.build();
    assertEquals(instance, actualImmutableGrid);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Grid)}.
   *
   * <ul>
   *   <li>Then return build rows size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Grid)}
   */
  @Test
  @DisplayName("Test Builder from(Grid); then return build rows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Grid)"})
  void testBuilderFrom_thenReturnBuildRowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    Builder builderResult2 = ImmutableGrid.builder();

    ImmutableRow.Builder builderResult3 = ImmutableRow.builder();
    builderResult2.addRows(
        builderResult3
            .id(
                ImmutableKeyCell.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .type("Type")
                    .waltzId(1L)
                    .build())
            .build());

    // Act and Assert
    List<Row> rowsResult =
        builderResult
            .from(builderResult2.columnDescriptors(new ArrayList<>()).build())
            .build()
            .rows();
    assertEquals(1, rowsResult.size());
    Row getResult = rowsResult.get(0);
    KeyCell idResult = getResult.id();
    assertTrue(idResult instanceof ImmutableKeyCell);
    assertTrue(getResult instanceof ImmutableRow);
    assertEquals("Type", idResult.type());
    assertEquals(EntityKind.ALL, idResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, idResult.lifecyclePhase());
    assertTrue(getResult.cells().isEmpty());
  }

  /**
   * Test Builder {@link Builder#rows(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build rows Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#rows(Iterable)}
   */
  @Test
  @DisplayName("Test Builder rows(Iterable); when ArrayList(); then return build rows Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link ImmutableGrid#columnDescriptors()}
   */
  @Test
  @DisplayName("Test columnDescriptors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableGrid.columnDescriptors()"})
  void testColumnDescriptors() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    // Act
    Optional<List<ColumnDescriptor>> actualColumnDescriptorsResult =
        builderResult.columnDescriptors(new ArrayList<>()).build().columnDescriptors();

    // Assert
    assertTrue(actualColumnDescriptorsResult.get().isEmpty());
    assertTrue(actualColumnDescriptorsResult.isPresent());
  }

  /**
   * Test {@link ImmutableGrid#copyOf(Grid)}.
   *
   * <ul>
   *   <li>When builder columnDescriptors {@link ArrayList#ArrayList()} build.
   *   <li>Then return rows Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#copyOf(Grid)}
   */
  @Test
  @DisplayName(
      "Test copyOf(Grid); when builder columnDescriptors ArrayList() build; then return rows Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGrid#equals(Object)}
   *   <li>{@link ImmutableGrid#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid immutableGrid = builderResult.columnDescriptors(new ArrayList<>()).build();

    Builder builderResult2 = ImmutableGrid.builder();
    ImmutableGrid immutableGrid2 = builderResult2.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableGrid, immutableGrid2);
    assertEquals(immutableGrid.hashCode(), immutableGrid2.hashCode());
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}, and {@link ImmutableGrid#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGrid#equals(Object)}
   *   <li>{@link ImmutableGrid#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid immutableGrid = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableGrid, immutableGrid);
    int expectedHashCodeResult = immutableGrid.hashCode();
    assertEquals(expectedHashCodeResult, immutableGrid.hashCode());
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    ImmutableRow.Builder builderResult2 = ImmutableRow.builder();
    builderResult.addRows(
        builderResult2
            .id(
                ImmutableKeyCell.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .type("Type")
                    .waltzId(1L)
                    .build())
            .build());
    ImmutableGrid immutableGrid = builderResult.columnDescriptors(new ArrayList<>()).build();

    Builder builderResult3 = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(immutableGrid, builderResult3.columnDescriptors(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<ColumnDescriptor> columnDescriptors = new ArrayList<>();
    columnDescriptors.add(ImmutableColumnDescriptor.builder().id("42").name("Name").build());
    ImmutableGrid immutableGrid =
        ImmutableGrid.builder().columnDescriptors(columnDescriptors).build();

    Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(immutableGrid, builderResult.columnDescriptors(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(builderResult.columnDescriptors(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link ImmutableGrid#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableGrid.equals(Object)", "int ImmutableGrid.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.columnDescriptors(new ArrayList<>()).build(),
        "Different type to ImmutableGrid");
  }

  /**
   * Test {@link ImmutableGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableRow.Json} (default constructor).
   *   <li>Then return rows size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return rows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnRowsSizeIsOne() {
    // Arrange
    ArrayList<Row> rows = new ArrayList<>();
    ImmutableRow.Json json = new ImmutableRow.Json();
    rows.add(json);

    Json json2 = new Json();
    Optional<List<ColumnDescriptor>> columnDescriptors = Optional.of(new ArrayList<>());
    json2.setColumnDescriptors(columnDescriptors);
    json2.setRows(rows);

    // Act
    ImmutableGrid actualFromJsonResult = ImmutableGrid.fromJson(json2);

    // Assert
    List<Row> rowsResult = actualFromJsonResult.rows();
    assertEquals(1, rowsResult.size());
    assertSame(json, rowsResult.get(0));
  }

  /**
   * Test {@link ImmutableGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ColumnDescriptors is {@code null}.
   *   <li>Then return rows size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ColumnDescriptors is 'null'; then return rows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonColumnDescriptorsIsNull_thenReturnRowsSizeIsOne() {
    // Arrange
    ArrayList<Row> rows = new ArrayList<>();
    ImmutableRow.Json json = new ImmutableRow.Json();
    rows.add(json);

    Json json2 = new Json();
    json2.setColumnDescriptors(null);
    json2.setRows(rows);

    // Act
    ImmutableGrid actualFromJsonResult = ImmutableGrid.fromJson(json2);

    // Assert
    List<Row> rowsResult = actualFromJsonResult.rows();
    assertEquals(1, rowsResult.size());
    assertSame(json, rowsResult.get(0));
  }

  /**
   * Test {@link ImmutableGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Rows is {@code null}.
   *   <li>Then return rows Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Rows is 'null'; then return rows Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonRowsIsNull_thenReturnRowsEmpty() {
    // Arrange
    Json json = new Json();
    Optional<List<ColumnDescriptor>> columnDescriptors = Optional.of(new ArrayList<>());
    json.setColumnDescriptors(columnDescriptors);
    json.setRows(null);

    // Act
    ImmutableGrid actualFromJsonResult = ImmutableGrid.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return rows size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return rows size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.fromJson(Json)"})
  void testFromJson_thenReturnRowsSizeIsTwo() {
    // Arrange
    ArrayList<Row> rows = new ArrayList<>();

    ImmutableRow.Builder builderResult = ImmutableRow.builder();
    rows.add(
        builderResult
            .id(
                ImmutableKeyCell.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .type("Type")
                    .waltzId(1L)
                    .build())
            .build());
    ImmutableRow.Json json = new ImmutableRow.Json();
    rows.add(json);

    Json json2 = new Json();
    Optional<List<ColumnDescriptor>> columnDescriptors = Optional.of(new ArrayList<>());
    json2.setColumnDescriptors(columnDescriptors);
    json2.setRows(rows);

    // Act
    ImmutableGrid actualFromJsonResult = ImmutableGrid.fromJson(json2);

    // Assert
    List<Row> rowsResult = actualFromJsonResult.rows();
    assertEquals(2, rowsResult.size());
    Row getResult = rowsResult.get(0);
    KeyCell idResult = getResult.id();
    assertTrue(idResult instanceof ImmutableKeyCell);
    assertTrue(getResult instanceof ImmutableRow);
    assertEquals("Type", idResult.type());
    assertEquals(EntityKind.ALL, idResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, idResult.lifecyclePhase());
    assertTrue(getResult.cells().isEmpty());
    assertSame(json, rowsResult.get(1));
  }

  /**
   * Test {@link ImmutableGrid#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return rows Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return rows Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnRowsEmpty() {
    // Arrange and Act
    ImmutableGrid actualFromJsonResult = ImmutableGrid.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.rows().isEmpty());
  }

  /**
   * Test Json {@link Json#columnDescriptors()}.
   *
   * <p>Method under test: {@link Json#columnDescriptors()}
   */
  @Test
  @DisplayName("Test Json columnDescriptors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.columnDescriptors()"})
  void testJsonColumnDescriptors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnDescriptors());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#rows()}
   */
  @Test
  @DisplayName("Test Json rows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.rows()"})
  void testJsonRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rows());
  }

  /**
   * Test {@link ImmutableGrid#rows()}.
   *
   * <p>Method under test: {@link ImmutableGrid#rows()}
   */
  @Test
  @DisplayName("Test rows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ImmutableGrid.rows()"})
  void testRows() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertTrue(builderResult.columnDescriptors(new ArrayList<>()).build().rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#toString()}.
   *
   * <p>Method under test: {@link ImmutableGrid#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableGrid.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertEquals(
        "Grid{columnDescriptors=[], rows=[]}",
        builderResult.columnDescriptors(new ArrayList<>()).build().toString());
  }

  /**
   * Test {@link ImmutableGrid#withColumnDescriptors(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableGrid#withColumnDescriptors(Optional)}
   */
  @Test
  @DisplayName("Test withColumnDescriptors(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withColumnDescriptors(Optional)"})
  void testWithColumnDescriptorsWithOptional() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid immutableGrid = builderResult.columnDescriptors(new ArrayList<>()).build();
    Optional<? extends List<ColumnDescriptor>> optional = Optional.of(new ArrayList<>());

    // Act and Assert
    assertTrue(immutableGrid.withColumnDescriptors(optional).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#withColumnDescriptors(List)} with {@code value}.
   *
   * <ul>
   *   <li>Given builder id {@code 42} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  @DisplayName(
      "Test withColumnDescriptors(List) with 'value'; given builder id '42' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withColumnDescriptors(List)"})
  void testWithColumnDescriptorsWithValue_givenBuilderId42NameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid immutableGrid = builderResult.columnDescriptors(new ArrayList<>()).build();

    ArrayList<ColumnDescriptor> value = new ArrayList<>();
    value.add(ImmutableColumnDescriptor.builder().id("42").name("Name").build());

    // Act and Assert
    assertTrue(immutableGrid.withColumnDescriptors(value).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#withColumnDescriptors(List)} with {@code value}.
   *
   * <ul>
   *   <li>Given builder id {@code 42} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  @DisplayName(
      "Test withColumnDescriptors(List) with 'value'; given builder id '42' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withColumnDescriptors(List)"})
  void testWithColumnDescriptorsWithValue_givenBuilderId42NameNameBuild2() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid immutableGrid = builderResult.columnDescriptors(new ArrayList<>()).build();

    ArrayList<ColumnDescriptor> value = new ArrayList<>();
    value.add(ImmutableColumnDescriptor.builder().id("42").name("Name").build());
    value.add(ImmutableColumnDescriptor.builder().id("42").name("Name").build());

    // Act and Assert
    assertTrue(immutableGrid.withColumnDescriptors(value).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#withColumnDescriptors(List)} with {@code value}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGrid#withColumnDescriptors(List)}
   */
  @Test
  @DisplayName("Test withColumnDescriptors(List) with 'value'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withColumnDescriptors(List)"})
  void testWithColumnDescriptorsWithValue_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid immutableGrid = builderResult.columnDescriptors(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(immutableGrid.withColumnDescriptors(new ArrayList<>()).rows().isEmpty());
  }

  /**
   * Test {@link ImmutableGrid#withRows(Row[])} with {@code Row[]}.
   *
   * <p>Method under test: {@link ImmutableGrid#withRows(Row[])}
   */
  @Test
  @DisplayName("Test withRows(Row[]) with 'Row[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGrid ImmutableGrid.withRows(Row[])"})
  void testWithRowsWithRow() {
    // Arrange
    Builder builderResult = ImmutableGrid.builder();
    ImmutableGrid immutableGrid = builderResult.columnDescriptors(new ArrayList<>()).build();

    ImmutableRow.Builder builderResult2 = ImmutableRow.builder();

    // Act and Assert
    List<Row> rowsResult =
        immutableGrid
            .withRows(
                builderResult2
                    .id(
                        ImmutableKeyCell.builder()
                            .externalId("42")
                            .kind(EntityKind.ALL)
                            .lifecyclePhase(LifecyclePhase.PRODUCTION)
                            .name("Name")
                            .type("Type")
                            .waltzId(1L)
                            .build())
                    .build())
            .rows();
    assertEquals(1, rowsResult.size());
    Row getResult = rowsResult.get(0);
    KeyCell idResult = getResult.id();
    assertTrue(idResult instanceof ImmutableKeyCell);
    assertTrue(getResult instanceof ImmutableRow);
    assertEquals("Type", idResult.type());
    assertEquals(EntityKind.ALL, idResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, idResult.lifecyclePhase());
    assertTrue(getResult.cells().isEmpty());
  }
}
