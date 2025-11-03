package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.web.json.ImmutableKeyCell.Json;
import org.finos.waltz.web.json.ImmutableRow.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRowDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCells(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCells(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCells(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCells(Iterable)"})
  void testBuilderAddAllCells_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCells(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addCells(CellValue)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableCellValue.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCells(CellValue)}
   */
  @Test
  @DisplayName("Test Builder addCells(CellValue) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCells(CellValue)"})
  void testBuilderAddCellsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCells(new ImmutableCellValue.Json()));
  }

  /**
   * Test Builder {@link Builder#addCells(CellValue[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableCellValue.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCells(CellValue[])}
   */
  @Test
  @DisplayName("Test Builder addCells(CellValue[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCells(CellValue[])"})
  void testBuilderAddCellsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCells(new ImmutableCellValue.Json()));
  }

  /**
   * Test Builder {@link Builder#cells(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#cells(Iterable)}
   */
  @Test
  @DisplayName("Test Builder cells(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cells(Iterable)"})
  void testBuilderCells_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cells(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(Row)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableCellValue.Json} (default constructor).</li>
   *   <li>Then build id return {@link Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Row)}
   */
  @Test
  @DisplayName("Test Builder from(Row); given ArrayList() add Json (default constructor); then build id return Json")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Row)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuildIdReturnJson() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();

    ArrayList<CellValue> cellValueList = new ArrayList<>();
    ImmutableCellValue.Json json = new ImmutableCellValue.Json();
    cellValueList.add(json);
    Row instance = mock(Row.class);
    when(instance.cells()).thenReturn(cellValueList);
    when(instance.id()).thenReturn(new Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cells();
    verify(instance).id();
    ImmutableRow buildResult = actualFromResult.build();
    KeyCell idResult = buildResult.id();
    assertTrue(idResult instanceof Json);
    List<CellValue> cellsResult = builderResult.build().cells();
    assertEquals(1, cellsResult.size());
    assertEquals(cellValueList, buildResult.cells());
    assertSame(json, cellsResult.get(0));
    Optional<String> optional = json.comment;
    assertSame(optional, ((Json) idResult).name);
    assertSame(optional, ((Json) idResult).waltzId);
  }

  /**
   * Test Builder {@link Builder#from(Row)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build id is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Row)}
   */
  @Test
  @DisplayName("Test Builder from(Row); given ArrayList(); then builder build id is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Row)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildIdIsJson() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    Row instance = mock(Row.class);
    when(instance.cells()).thenReturn(new ArrayList<>());
    Json json = new Json();
    when(instance.id()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cells();
    verify(instance).id();
    assertSame(json, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Row)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Row)}
   */
  @Test
  @DisplayName("Test Builder from(Row); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Row)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    Row instance = mock(Row.class);
    when(instance.cells()).thenThrow(new IllegalStateException("instance"));
    when(instance.id()).thenReturn(new Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cells();
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#id(KeyCell)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then builder build id is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#id(KeyCell)}
   */
  @Test
  @DisplayName("Test Builder id(KeyCell); when Json (default constructor); then builder build id is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(KeyCell)"})
  void testBuilderId_whenJson_thenBuilderBuildIdIsJson() {
    // Arrange
    Builder builderResult = ImmutableRow.builder();
    Json id = new Json();

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(id, builderResult.build().id());
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Json {@link ImmutableRow.Json#cells()}.
   * <p>
   * Method under test: {@link ImmutableRow.Json#cells()}
   */
  @Test
  @DisplayName("Test Json cells()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableRow.Json.cells()"})
  void testJsonCells() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRow.Json()).cells());
  }

  /**
   * Test Json {@link ImmutableRow.Json#id()}.
   * <p>
   * Method under test: {@link ImmutableRow.Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyCell ImmutableRow.Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRow.Json()).id());
  }

  /**
   * Test Json new {@link ImmutableRow.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableRow.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableRow.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRow.Json actualJson = new ImmutableRow.Json();

    // Assert
    assertNull(actualJson.id);
    assertTrue(actualJson.cells.isEmpty());
  }
}
