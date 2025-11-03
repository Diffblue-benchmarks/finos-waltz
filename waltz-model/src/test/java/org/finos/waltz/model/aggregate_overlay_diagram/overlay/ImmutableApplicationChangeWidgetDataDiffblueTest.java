package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableApplicationChangeWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableApplicationChangeWidgetData.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationChangeWidgetDataDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCellData(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build cellData Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCellData(Iterable); when ArrayList(); then return build cellData Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCellData(Iterable)"})
  void testBuilderAddAllCellData_whenArrayList_thenReturnBuildCellDataEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetData.builder();

    // Act
    Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(ApplicationChangeWidgetDatum)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableApplicationChangeWidgetDatum.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(ApplicationChangeWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder addCellData(ApplicationChangeWidgetDatum) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(ApplicationChangeWidgetDatum)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetData.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableApplicationChangeWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(ApplicationChangeWidgetDatum[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableApplicationChangeWidgetDatum.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(ApplicationChangeWidgetDatum[])}
   */
  @Test
  @DisplayName("Test Builder addCellData(ApplicationChangeWidgetDatum[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(ApplicationChangeWidgetDatum[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetData.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableApplicationChangeWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApplicationChangeWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableApplicationChangeWidgetData.builder().build().cellData().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellData(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build cellData Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#cellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder cellData(Iterable); when ArrayList(); then return build cellData Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellData(Iterable)"})
  void testBuilderCellData_whenArrayList_thenReturnBuildCellDataEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetData.builder();

    // Act
    Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationChangeWidgetData)}.
   * <ul>
   *   <li>Given {@link ImmutableApplicationChangeWidgetDatum.Json} (default constructor).</li>
   *   <li>When builder addCellData {@link ImmutableApplicationChangeWidgetDatum.Json} (default constructor).</li>
   *   <li>Then builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationChangeWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationChangeWidgetData); given Json (default constructor); when builder addCellData Json (default constructor); then builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationChangeWidgetData)"})
  void testBuilderFrom_givenJson_whenBuilderAddCellDataJson_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetData.builder();
    Builder builderResult2 = ImmutableApplicationChangeWidgetData.builder();
    builderResult2.addCellData(new ImmutableApplicationChangeWidgetDatum.Json());
    ImmutableApplicationChangeWidgetData instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationChangeWidgetData)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationChangeWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationChangeWidgetData); when builder build; then builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationChangeWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetData.builder();
    ImmutableApplicationChangeWidgetData instance = ImmutableApplicationChangeWidgetData.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#copyOf(ApplicationChangeWidgetData)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return cellData Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationChangeWidgetData#copyOf(ApplicationChangeWidgetData)}
   */
  @Test
  @DisplayName("Test copyOf(ApplicationChangeWidgetData); when builder build; then return cellData Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationChangeWidgetData ImmutableApplicationChangeWidgetData.copyOf(ApplicationChangeWidgetData)"})
  void testCopyOf_whenBuilderBuild_thenReturnCellDataEmpty() {
    // Arrange
    ImmutableApplicationChangeWidgetData instance = ImmutableApplicationChangeWidgetData.builder().build();

    // Act and Assert
    assertTrue(ImmutableApplicationChangeWidgetData.copyOf(instance).cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#equals(Object)}, and {@link ImmutableApplicationChangeWidgetData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationChangeWidgetData#equals(Object)}
   *   <li>{@link ImmutableApplicationChangeWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationChangeWidgetData.equals(Object)",
      "int ImmutableApplicationChangeWidgetData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableApplicationChangeWidgetData buildResult = ImmutableApplicationChangeWidgetData.builder().build();
    ImmutableApplicationChangeWidgetData buildResult2 = ImmutableApplicationChangeWidgetData.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#equals(Object)}, and {@link ImmutableApplicationChangeWidgetData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationChangeWidgetData#equals(Object)}
   *   <li>{@link ImmutableApplicationChangeWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationChangeWidgetData.equals(Object)",
      "int ImmutableApplicationChangeWidgetData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableApplicationChangeWidgetData buildResult = ImmutableApplicationChangeWidgetData.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationChangeWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationChangeWidgetData.equals(Object)",
      "int ImmutableApplicationChangeWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetData.builder();
    builderResult.addCellData(new ImmutableApplicationChangeWidgetDatum.Json());
    ImmutableApplicationChangeWidgetData buildResult = builderResult.build();
    ImmutableApplicationChangeWidgetData buildResult2 = ImmutableApplicationChangeWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationChangeWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationChangeWidgetData.equals(Object)",
      "int ImmutableApplicationChangeWidgetData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableApplicationChangeWidgetData buildResult = ImmutableApplicationChangeWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationChangeWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableApplicationChangeWidgetData.equals(Object)",
      "int ImmutableApplicationChangeWidgetData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableApplicationChangeWidgetData buildResult = ImmutableApplicationChangeWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableApplicationChangeWidgetData");
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableApplicationChangeWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationChangeWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApplicationChangeWidgetData ImmutableApplicationChangeWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<ApplicationChangeWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableApplicationChangeWidgetDatum.Json());
    cellData.add(new ImmutableApplicationChangeWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(cellData, ImmutableApplicationChangeWidgetData.fromJson(json).cellData());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableApplicationChangeWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationChangeWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApplicationChangeWidgetData ImmutableApplicationChangeWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<ApplicationChangeWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableApplicationChangeWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act and Assert
    assertEquals(1, ImmutableApplicationChangeWidgetData.fromJson(json).cellData().size());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.</li>
   *   <li>Then return cellData Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationChangeWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) CellData is 'null'; then return cellData Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApplicationChangeWidgetData ImmutableApplicationChangeWidgetData.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonCellDataIsNull_thenReturnCellDataEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellData(null);

    // Act and Assert
    assertTrue(ImmutableApplicationChangeWidgetData.fromJson(json).cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return cellData Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationChangeWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return cellData Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApplicationChangeWidgetData ImmutableApplicationChangeWidgetData.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnCellDataEmpty() {
    // Arrange, Act and Assert
    assertTrue(ImmutableApplicationChangeWidgetData.fromJson(new Json()).cellData().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationChangeWidgetData#toString()}
   *   <li>{@link ImmutableApplicationChangeWidgetData#cellData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ImmutableApplicationChangeWidgetData.cellData()",
      "String ImmutableApplicationChangeWidgetData.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableApplicationChangeWidgetData buildResult = ImmutableApplicationChangeWidgetData.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();

    // Assert
    assertEquals("ApplicationChangeWidgetData{cellData=[]}", actualToStringResult);
    assertTrue(buildResult.cellData().isEmpty());
  }

  /**
   * Test Json {@link Json#cellData()}.
   * <p>
   * Method under test: {@link Json#cellData()}
   */
  @Test
  @DisplayName("Test Json cellData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.cellData()"})
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
    // Arrange, Act and Assert
    assertTrue((new Json()).cellData.isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetData#withCellData(ApplicationChangeWidgetDatum[])} with {@code ApplicationChangeWidgetDatum[]}.
   * <ul>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableApplicationChangeWidgetData#withCellData(ApplicationChangeWidgetDatum[])}
   */
  @Test
  @DisplayName("Test withCellData(ApplicationChangeWidgetDatum[]) with 'ApplicationChangeWidgetDatum[]'; then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableApplicationChangeWidgetData ImmutableApplicationChangeWidgetData.withCellData(ApplicationChangeWidgetDatum[])"})
  void testWithCellDataWithApplicationChangeWidgetDatum_thenReturnCellDataSizeIsOne() {
    // Arrange
    ImmutableApplicationChangeWidgetData buildResult = ImmutableApplicationChangeWidgetData.builder().build();

    // Act and Assert
    assertEquals(1, buildResult.withCellData(new ImmutableApplicationChangeWidgetDatum.Json()).cellData().size());
  }
}
