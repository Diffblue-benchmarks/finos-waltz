package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.web.json.ImmutableRow.Builder;
import org.finos.waltz.web.json.ImmutableRow.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRowDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCells(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCells(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCells(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCells(Iterable)"})
  void testBuilderAddAllCells_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act
    Builder actualAddAllCellsResult = builderResult.addAllCells(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllCellsResult);
  }

  /**
   * Test Builder {@link Builder#addCells(CellValue)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableCellValue.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCells(CellValue)}
   */
  @Test
  @DisplayName(
      "Test Builder addCells(CellValue) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCells(CellValue)"})
  void testBuilderAddCellsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act
    Builder actualAddCellsResult = builderResult.addCells(new ImmutableCellValue.Json());

    // Assert
    assertSame(builderResult, actualAddCellsResult);
  }

  /**
   * Test Builder {@link Builder#addCells(CellValue[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableCellValue.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCells(CellValue[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCells(CellValue[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCells(CellValue[])"})
  void testBuilderAddCellsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act
    Builder actualAddCellsResult = builderResult.addCells(new ImmutableCellValue.Json());

    // Assert
    assertSame(builderResult, actualAddCellsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRow Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableRow.builder();
    ImmutableKeyCell id =
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build();
    ImmutableRow actualImmutableRow = actualBuilderResult.id(id).build();

    // Assert
    assertTrue(actualImmutableRow.cells().isEmpty());
    assertSame(id, actualImmutableRow.id());
  }

  /**
   * Test Builder {@link Builder#cells(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cells(Iterable)}
   */
  @Test
  @DisplayName("Test Builder cells(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cells(Iterable)"})
  void testBuilderCells_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act
    Builder actualCellsResult = builderResult.cells(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualCellsResult);
  }

  /**
   * Test Builder {@link Builder#from(Row)}.
   *
   * <p>Method under test: {@link Builder#from(Row)}
   */
  @Test
  @DisplayName("Test Builder from(Row)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Row)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    Builder builderResult2 = ImmutableRow.builder();
    ImmutableRow instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRow actualImmutableRow = builderResult.build();
    assertEquals(instance, actualImmutableRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Row)}.
   *
   * <ul>
   *   <li>Then return build cells size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Row)}
   */
  @Test
  @DisplayName("Test Builder from(Row); then return build cells size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Row)"})
  void testBuilderFrom_thenReturnBuildCellsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    Builder builderResult2 = ImmutableRow.builder();
    builderResult2.addCells(
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build());

    // Act and Assert
    List<CellValue> cellsResult =
        builderResult
            .from(
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
            .build()
            .cells();
    assertEquals(1, cellsResult.size());
    CellValue getResult = cellsResult.get(0);
    assertTrue(getResult instanceof ImmutableCellValue);
    assertEquals("42", getResult.value());
    assertEquals("Name", getResult.name());
    assertEquals("Type", getResult.type());
  }

  /**
   * Test Builder {@link Builder#id(KeyCell)}.
   *
   * <ul>
   *   <li>When {@link ImmutableKeyCell.Json} (default constructor).
   *   <li>Then builder build id is {@link ImmutableKeyCell.Json} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#id(KeyCell)}
   */
  @Test
  @DisplayName(
      "Test Builder id(KeyCell); when Json (default constructor); then builder build id is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(KeyCell)"})
  void testBuilderId_whenJson_thenBuilderBuildIdIsJson() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    ImmutableKeyCell.Json id = new ImmutableKeyCell.Json();

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(id, builderResult.build().id());
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test {@link ImmutableRow#copyOf(Row)}.
   *
   * <ul>
   *   <li>Then id return {@link ImmutableKeyCell}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRow#copyOf(Row)}
   */
  @Test
  @DisplayName("Test copyOf(Row); then id return ImmutableKeyCell")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRow ImmutableRow.copyOf(Row)"})
  void testCopyOf_thenIdReturnImmutableKeyCell() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    ImmutableRow instance =
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
            .build();

    // Act
    ImmutableRow actualCopyOfResult = ImmutableRow.copyOf(instance);

    // Assert
    KeyCell idResult = actualCopyOfResult.id();
    assertTrue(idResult instanceof ImmutableKeyCell);
    assertEquals("Type", idResult.type());
    assertEquals(EntityKind.ALL, idResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, idResult.lifecyclePhase());
    assertTrue(actualCopyOfResult.cells().isEmpty());
  }

  /**
   * Test {@link ImmutableRow#equals(Object)}, and {@link ImmutableRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRow#equals(Object)}
   *   <li>{@link ImmutableRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRow.equals(Object)", "int ImmutableRow.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    ImmutableRow immutableRow =
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
            .build();

    Builder builderResult2 = ImmutableRow.builder();
    ImmutableRow immutableRow2 =
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
            .build();

    // Act and Assert
    assertEquals(immutableRow, immutableRow2);
    assertEquals(immutableRow.hashCode(), immutableRow2.hashCode());
  }

  /**
   * Test {@link ImmutableRow#equals(Object)}, and {@link ImmutableRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRow#equals(Object)}
   *   <li>{@link ImmutableRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRow.equals(Object)", "int ImmutableRow.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    ImmutableRow immutableRow =
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
            .build();

    // Act and Assert
    assertEquals(immutableRow, immutableRow);
    int expectedHashCodeResult = immutableRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableRow.hashCode());
  }

  /**
   * Test {@link ImmutableRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRow.equals(Object)", "int ImmutableRow.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    builderResult.addCells(
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build());
    ImmutableRow immutableRow =
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
            .build();

    Builder builderResult2 = ImmutableRow.builder();

    // Act and Assert
    assertNotEquals(
        immutableRow,
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
  }

  /**
   * Test {@link ImmutableRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRow.equals(Object)", "int ImmutableRow.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    ImmutableRow immutableRow =
        builderResult
            .id(
                ImmutableKeyCell.builder()
                    .externalId("Type")
                    .kind(EntityKind.ALL)
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .type("Type")
                    .waltzId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableRow.builder();

    // Act and Assert
    assertNotEquals(
        immutableRow,
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
  }

  /**
   * Test {@link ImmutableRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRow.equals(Object)", "int ImmutableRow.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRow.equals(Object)", "int ImmutableRow.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertNotEquals(
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
            .build(),
        "Different type to ImmutableRow");
  }

  /**
   * Test {@link ImmutableRow#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableCellValue.Json} (default
   *       constructor).
   *   <li>When {@link Json} (default constructor) Id is {@link ImmutableKeyCell.Json} (default
   *       constructor).
   *   <li>Then return cells size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRow#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); when Json (default constructor) Id is Json (default constructor); then return cells size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRow ImmutableRow.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_whenJsonIdIsJson_thenReturnCellsSizeIsOne() {
    // Arrange
    ArrayList<CellValue> cells = new ArrayList<>();
    ImmutableCellValue.Json json = new ImmutableCellValue.Json();
    cells.add(json);

    Json json2 = new Json();
    json2.setId(new ImmutableKeyCell.Json());
    json2.setCells(cells);

    // Act
    ImmutableRow actualFromJsonResult = ImmutableRow.fromJson(json2);

    // Assert
    List<CellValue> cellsResult = actualFromJsonResult.cells();
    assertEquals(1, cellsResult.size());
    assertSame(json, cellsResult.get(0));
  }

  /**
   * Test {@link ImmutableRow#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Json} (default constructor) Id is {@link ImmutableKeyCell.Json} (default
   *       constructor).
   *   <li>Then return cells Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRow#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList(); when Json (default constructor) Id is Json (default constructor); then return cells Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRow ImmutableRow.fromJson(Json)"})
  void testFromJson_givenArrayList_whenJsonIdIsJson_thenReturnCellsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableKeyCell.Json id = new ImmutableKeyCell.Json();
    json.setId(id);
    json.setCells(new ArrayList<>());

    // Act
    ImmutableRow actualFromJsonResult = ImmutableRow.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.cells().isEmpty());
    assertSame(id, actualFromJsonResult.id());
  }

  /**
   * Test {@link ImmutableRow#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Cells is {@code null}.
   *   <li>Then return cells Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRow#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Cells is 'null'; then return cells Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRow ImmutableRow.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonCellsIsNull_thenReturnCellsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableKeyCell.Json id = new ImmutableKeyCell.Json();
    json.setId(id);
    json.setCells(null);

    // Act
    ImmutableRow actualFromJsonResult = ImmutableRow.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.cells().isEmpty());
    assertSame(id, actualFromJsonResult.id());
  }

  /**
   * Test {@link ImmutableRow#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return cells size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRow#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return cells size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRow ImmutableRow.fromJson(Json)"})
  void testFromJson_thenReturnCellsSizeIsTwo() {
    // Arrange
    ArrayList<CellValue> cells = new ArrayList<>();
    cells.add(
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build());
    ImmutableCellValue.Json json = new ImmutableCellValue.Json();
    cells.add(json);

    Json json2 = new Json();
    json2.setId(new ImmutableKeyCell.Json());
    json2.setCells(cells);

    // Act
    ImmutableRow actualFromJsonResult = ImmutableRow.fromJson(json2);

    // Assert
    List<CellValue> cellsResult = actualFromJsonResult.cells();
    assertEquals(2, cellsResult.size());
    CellValue getResult = cellsResult.get(0);
    assertTrue(getResult instanceof ImmutableCellValue);
    assertEquals("42", getResult.value());
    assertEquals("Name", getResult.name());
    assertEquals("Type", getResult.type());
    assertSame(json, cellsResult.get(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRow#toString()}
   *   <li>{@link ImmutableRow#cells()}
   *   <li>{@link ImmutableRow#id()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableRow.cells()",
    "KeyCell ImmutableRow.id()",
    "String ImmutableRow.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    ImmutableRow immutableRow =
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
            .build();

    // Act
    String actualToStringResult = immutableRow.toString();
    List<CellValue> actualCellsResult = immutableRow.cells();

    // Assert
    assertTrue(immutableRow.id() instanceof ImmutableKeyCell);
    assertEquals(
        "Row{id=KeyCell{type=Type, name=Name, kind=ALL, waltzId=1, externalId=42, lifecyclePhase=PRODUCTION},"
            + " cells=[]}",
        actualToStringResult);
    assertTrue(actualCellsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#cells()}.
   *
   * <p>Method under test: {@link Json#cells()}
   */
  @Test
  @DisplayName("Test Json cells()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.cells()"})
  void testJsonCells() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cells());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyCell Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
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
    assertNull(actualJson.id);
    assertTrue(actualJson.cells.isEmpty());
  }

  /**
   * Test {@link ImmutableRow#withCells(CellValue[])} with {@code CellValue[]}.
   *
   * <p>Method under test: {@link ImmutableRow#withCells(CellValue[])}
   */
  @Test
  @DisplayName("Test withCells(CellValue[]) with 'CellValue[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRow ImmutableRow.withCells(CellValue[])"})
  void testWithCellsWithCellValue() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    ImmutableRow immutableRow =
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
            .build();

    // Act
    ImmutableRow actualWithCellsResult =
        immutableRow.withCells(
            ImmutableCellValue.builder()
                .comment("Comment")
                .name("Name")
                .type("Type")
                .value("42")
                .build());

    // Assert
    List<CellValue> cellsResult = actualWithCellsResult.cells();
    assertEquals(1, cellsResult.size());
    CellValue getResult = cellsResult.get(0);
    assertTrue(getResult instanceof ImmutableCellValue);
    KeyCell idResult = actualWithCellsResult.id();
    assertTrue(idResult instanceof ImmutableKeyCell);
    assertEquals("42", getResult.value());
    assertEquals("Name", getResult.name());
    assertEquals("Type", getResult.type());
    assertEquals("Type", idResult.type());
    assertEquals(EntityKind.ALL, idResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, idResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableRow#withId(KeyCell)}.
   *
   * <p>Method under test: {@link ImmutableRow#withId(KeyCell)}
   */
  @Test
  @DisplayName("Test withId(KeyCell)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRow ImmutableRow.withId(KeyCell)"})
  void testWithId() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    ImmutableRow immutableRow =
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
            .build();

    // Act
    ImmutableRow actualWithIdResult =
        immutableRow.withId(
            ImmutableKeyCell.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .lifecyclePhase(LifecyclePhase.PRODUCTION)
                .name("Name")
                .type("Type")
                .waltzId(1L)
                .build());

    // Assert
    assertEquals(immutableRow, actualWithIdResult);
  }
}
