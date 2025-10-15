package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCountWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCountWidgetData.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCountWidgetDataDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCellData(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCellData(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllCellData(Iterable); when ArrayList(); then return build cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCellData(Iterable)"})
  void testBuilderAddAllCellData_whenArrayList_thenReturnBuildCellDataEmpty() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetData.builder();

    // Act
    Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(CountWidgetDatum)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableCountWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(CountWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(CountWidgetDatum) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(CountWidgetDatum)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableCountWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(CountWidgetDatum[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableCountWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(CountWidgetDatum[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(CountWidgetDatum[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(CountWidgetDatum[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableCountWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
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
  @MethodsUnderTest({"ImmutableCountWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableCountWidgetData.builder().build().cellData().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellData(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellData(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder cellData(Iterable); when ArrayList(); then return build cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellData(Iterable)"})
  void testBuilderCellData_whenArrayList_thenReturnBuildCellDataEmpty() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetData.builder();

    // Act
    Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Test Builder {@link Builder#from(CountWidgetData)}.
   *
   * <p>Method under test: {@link Builder#from(CountWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(CountWidgetData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CountWidgetData)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetData.builder();

    Builder builderResult2 = ImmutableCountWidgetData.builder();
    builderResult2.addCellData(
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build());
    ImmutableCountWidgetData instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCountWidgetData actualImmutableCountWidgetData = builderResult.build();
    assertEquals(instance, actualImmutableCountWidgetData);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CountWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CountWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(CountWidgetData); when builder build; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CountWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetData.builder();
    ImmutableCountWidgetData instance = ImmutableCountWidgetData.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCountWidgetData actualImmutableCountWidgetData = builderResult.build();
    assertEquals(instance, actualImmutableCountWidgetData);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableCountWidgetData#copyOf(CountWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetData#copyOf(CountWidgetData)}
   */
  @Test
  @DisplayName("Test copyOf(CountWidgetData); when builder build; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountWidgetData ImmutableCountWidgetData.copyOf(CountWidgetData)"})
  void testCopyOf_whenBuilderBuild_thenReturnCellDataEmpty() {
    // Arrange
    ImmutableCountWidgetData instance = ImmutableCountWidgetData.builder().build();

    // Act and Assert
    assertTrue(ImmutableCountWidgetData.copyOf(instance).cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableCountWidgetData#equals(Object)}, and {@link
   * ImmutableCountWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCountWidgetData#equals(Object)}
   *   <li>{@link ImmutableCountWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetData.equals(Object)",
    "int ImmutableCountWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCountWidgetData immutableCountWidgetData = ImmutableCountWidgetData.builder().build();
    ImmutableCountWidgetData immutableCountWidgetData2 = ImmutableCountWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableCountWidgetData, immutableCountWidgetData2);
    assertEquals(immutableCountWidgetData.hashCode(), immutableCountWidgetData2.hashCode());
  }

  /**
   * Test {@link ImmutableCountWidgetData#equals(Object)}, and {@link
   * ImmutableCountWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCountWidgetData#equals(Object)}
   *   <li>{@link ImmutableCountWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetData.equals(Object)",
    "int ImmutableCountWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCountWidgetData immutableCountWidgetData = ImmutableCountWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableCountWidgetData, immutableCountWidgetData);
    int expectedHashCodeResult = immutableCountWidgetData.hashCode();
    assertEquals(expectedHashCodeResult, immutableCountWidgetData.hashCode());
  }

  /**
   * Test {@link ImmutableCountWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetData.equals(Object)",
    "int ImmutableCountWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetData.builder();
    builderResult.addCellData(
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableCountWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableCountWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetData.equals(Object)",
    "int ImmutableCountWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableCountWidgetData.builder().build(), null);
  }

  /**
   * Test {@link ImmutableCountWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetData.equals(Object)",
    "int ImmutableCountWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCountWidgetData.builder().build(), "Different type to ImmutableCountWidgetData");
  }

  /**
   * Test {@link ImmutableCountWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableCountWidgetDatum.Json}
   *       (default constructor).
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountWidgetData ImmutableCountWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<CountWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableCountWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act
    ImmutableCountWidgetData actualFromJsonResult = ImmutableCountWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
  }

  /**
   * Test {@link ImmutableCountWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) CellData is 'null'; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountWidgetData ImmutableCountWidgetData.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonCellDataIsNull_thenReturnCellDataEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellData(null);

    // Act
    ImmutableCountWidgetData actualFromJsonResult = ImmutableCountWidgetData.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableCountWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return cellData is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountWidgetData ImmutableCountWidgetData.fromJson(Json)"})
  void testFromJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<CountWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build());
    cellData.add(new ImmutableCountWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act
    ImmutableCountWidgetData actualFromJsonResult = ImmutableCountWidgetData.fromJson(json);

    // Assert
    assertEquals(cellData, actualFromJsonResult.cellData());
  }

  /**
   * Test {@link ImmutableCountWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountWidgetData ImmutableCountWidgetData.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnCellDataEmpty() {
    // Arrange and Act
    ImmutableCountWidgetData actualFromJsonResult = ImmutableCountWidgetData.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCountWidgetData#toString()}
   *   <li>{@link ImmutableCountWidgetData#cellData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set ImmutableCountWidgetData.cellData()",
    "String ImmutableCountWidgetData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCountWidgetData immutableCountWidgetData = ImmutableCountWidgetData.builder().build();

    // Act
    String actualToStringResult = immutableCountWidgetData.toString();

    // Assert
    assertEquals("CountWidgetData{cellData=[]}", actualToStringResult);
    assertTrue(immutableCountWidgetData.cellData().isEmpty());
  }

  /**
   * Test Json {@link Json#cellData()}.
   *
   * <p>Method under test: {@link Json#cellData()}
   */
  @Test
  @DisplayName("Test Json cellData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Json.cellData()"})
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellData());
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
    // Arrange, Act and Assert
    assertTrue(new Json().cellData.isEmpty());
  }

  /**
   * Test {@link ImmutableCountWidgetData#withCellData(CountWidgetDatum[])} with {@code
   * CountWidgetDatum[]}.
   *
   * <p>Method under test: {@link ImmutableCountWidgetData#withCellData(CountWidgetDatum[])}
   */
  @Test
  @DisplayName("Test withCellData(CountWidgetDatum[]) with 'CountWidgetDatum[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCountWidgetData ImmutableCountWidgetData.withCellData(CountWidgetDatum[])"
  })
  void testWithCellDataWithCountWidgetDatum() {
    // Arrange
    ImmutableCountWidgetData immutableCountWidgetData = ImmutableCountWidgetData.builder().build();

    // Act and Assert
    assertEquals(
        1,
        immutableCountWidgetData
            .withCellData(
                ImmutableCountWidgetDatum.builder()
                    .cellExternalId("42")
                    .currentStateCount(3)
                    .targetStateCount(3)
                    .build())
            .cellData()
            .size());
  }
}
