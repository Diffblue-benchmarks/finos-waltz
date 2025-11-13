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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAggregatedEntitiesWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAggregatedEntitiesWidgetData.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregatedEntitiesWidgetDataDiffblueTest {
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
    Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    // Act
    Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(AggregatedEntitiesWidgetDatum)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAggregatedEntitiesWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(AggregatedEntitiesWidgetDatum) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(AggregatedEntitiesWidgetDatum)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableAggregatedEntitiesWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(AggregatedEntitiesWidgetDatum[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAggregatedEntitiesWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(AggregatedEntitiesWidgetDatum[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(AggregatedEntitiesWidgetDatum[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(AggregatedEntitiesWidgetDatum[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableAggregatedEntitiesWidgetDatum.Json());

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
  @MethodsUnderTest({"ImmutableAggregatedEntitiesWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAggregatedEntitiesWidgetData.builder().build().cellData().isEmpty());
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
    Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    // Act
    Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregatedEntitiesWidgetData)}.
   *
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AggregatedEntitiesWidgetData)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregatedEntitiesWidgetData); given builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregatedEntitiesWidgetData)"})
  void testBuilderFrom_givenBuilderCellExternalId42Build() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();

    Builder builderResult2 = ImmutableAggregatedEntitiesWidgetData.builder();
    builderResult2.addCellData(
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build());
    ImmutableAggregatedEntitiesWidgetData instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregatedEntitiesWidgetData actualImmutableAggregatedEntitiesWidgetData =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregatedEntitiesWidgetData);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregatedEntitiesWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AggregatedEntitiesWidgetData)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregatedEntitiesWidgetData); when builder build; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregatedEntitiesWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();
    ImmutableAggregatedEntitiesWidgetData instance =
        ImmutableAggregatedEntitiesWidgetData.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregatedEntitiesWidgetData actualImmutableAggregatedEntitiesWidgetData =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregatedEntitiesWidgetData);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#copyOf(AggregatedEntitiesWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregatedEntitiesWidgetData#copyOf(AggregatedEntitiesWidgetData)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AggregatedEntitiesWidgetData); when builder build; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetData ImmutableAggregatedEntitiesWidgetData.copyOf(AggregatedEntitiesWidgetData)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnCellDataEmpty() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData instance =
        ImmutableAggregatedEntitiesWidgetData.builder().build();

    // Act and Assert
    assertTrue(ImmutableAggregatedEntitiesWidgetData.copyOf(instance).cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}, and {@link
   * ImmutableAggregatedEntitiesWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetData.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData immutableAggregatedEntitiesWidgetData =
        ImmutableAggregatedEntitiesWidgetData.builder().build();
    ImmutableAggregatedEntitiesWidgetData immutableAggregatedEntitiesWidgetData2 =
        ImmutableAggregatedEntitiesWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableAggregatedEntitiesWidgetData, immutableAggregatedEntitiesWidgetData2);
    assertEquals(
        immutableAggregatedEntitiesWidgetData.hashCode(),
        immutableAggregatedEntitiesWidgetData2.hashCode());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}, and {@link
   * ImmutableAggregatedEntitiesWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetData.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData immutableAggregatedEntitiesWidgetData =
        ImmutableAggregatedEntitiesWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableAggregatedEntitiesWidgetData, immutableAggregatedEntitiesWidgetData);
    int expectedHashCodeResult = immutableAggregatedEntitiesWidgetData.hashCode();
    assertEquals(expectedHashCodeResult, immutableAggregatedEntitiesWidgetData.hashCode());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetData.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetData.builder();
    builderResult.addCellData(
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAggregatedEntitiesWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetData.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAggregatedEntitiesWidgetData.builder().build(), null);
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetData.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregatedEntitiesWidgetData.builder().build(),
        "Different type to ImmutableAggregatedEntitiesWidgetData");
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableAggregatedEntitiesWidgetDatum.Json} (default constructor).
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetData ImmutableAggregatedEntitiesWidgetData.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<AggregatedEntitiesWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAggregatedEntitiesWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act
    ImmutableAggregatedEntitiesWidgetData actualFromJsonResult =
        ImmutableAggregatedEntitiesWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) CellData is 'null'; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetData ImmutableAggregatedEntitiesWidgetData.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonCellDataIsNull_thenReturnCellDataEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellData(null);

    // Act
    ImmutableAggregatedEntitiesWidgetData actualFromJsonResult =
        ImmutableAggregatedEntitiesWidgetData.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return cellData is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetData ImmutableAggregatedEntitiesWidgetData.fromJson(Json)"
  })
  void testFromJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AggregatedEntitiesWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build());
    cellData.add(new ImmutableAggregatedEntitiesWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act
    ImmutableAggregatedEntitiesWidgetData actualFromJsonResult =
        ImmutableAggregatedEntitiesWidgetData.fromJson(json);

    // Assert
    assertEquals(cellData, actualFromJsonResult.cellData());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetData ImmutableAggregatedEntitiesWidgetData.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnCellDataEmpty() {
    // Arrange and Act
    ImmutableAggregatedEntitiesWidgetData actualFromJsonResult =
        ImmutableAggregatedEntitiesWidgetData.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetData#toString()}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetData#cellData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set ImmutableAggregatedEntitiesWidgetData.cellData()",
    "String ImmutableAggregatedEntitiesWidgetData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData immutableAggregatedEntitiesWidgetData =
        ImmutableAggregatedEntitiesWidgetData.builder().build();

    // Act
    String actualToStringResult = immutableAggregatedEntitiesWidgetData.toString();

    // Assert
    assertEquals("AggregatedEntitiesWidgetData{cellData=[]}", actualToStringResult);
    assertTrue(immutableAggregatedEntitiesWidgetData.cellData().isEmpty());
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
   * Test {@link
   * ImmutableAggregatedEntitiesWidgetData#withCellData(AggregatedEntitiesWidgetDatum[])} with
   * {@code AggregatedEntitiesWidgetDatum[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregatedEntitiesWidgetData#withCellData(AggregatedEntitiesWidgetDatum[])}
   */
  @Test
  @DisplayName(
      "Test withCellData(AggregatedEntitiesWidgetDatum[]) with 'AggregatedEntitiesWidgetDatum[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetData ImmutableAggregatedEntitiesWidgetData.withCellData(AggregatedEntitiesWidgetDatum[])"
  })
  void testWithCellDataWithAggregatedEntitiesWidgetDatum() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetData immutableAggregatedEntitiesWidgetData =
        ImmutableAggregatedEntitiesWidgetData.builder().build();

    // Act and Assert
    assertEquals(
        1,
        immutableAggregatedEntitiesWidgetData
            .withCellData(
                ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build())
            .cellData()
            .size());
  }
}
