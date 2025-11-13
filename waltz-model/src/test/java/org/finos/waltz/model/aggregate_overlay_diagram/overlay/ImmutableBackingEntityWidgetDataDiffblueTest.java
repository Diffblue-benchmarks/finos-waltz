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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableBackingEntityWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableBackingEntityWidgetData.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBackingEntityWidgetDataDiffblueTest {
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
    Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    // Act
    Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(BackingEntityWidgetDatum)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableBackingEntityWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(BackingEntityWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(BackingEntityWidgetDatum) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(BackingEntityWidgetDatum)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableBackingEntityWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(BackingEntityWidgetDatum[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableBackingEntityWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(BackingEntityWidgetDatum[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(BackingEntityWidgetDatum[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(BackingEntityWidgetDatum[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableBackingEntityWidgetDatum.Json());

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
  @MethodsUnderTest({"ImmutableBackingEntityWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableBackingEntityWidgetData.builder().build().cellData().isEmpty());
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
    Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    // Act
    Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Test Builder {@link Builder#from(BackingEntityWidgetData)}.
   *
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BackingEntityWidgetData)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BackingEntityWidgetData); given builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BackingEntityWidgetData)"})
  void testBuilderFrom_givenBuilderCellExternalId42Build() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetData.builder();

    Builder builderResult2 = ImmutableBackingEntityWidgetData.builder();
    builderResult2.addCellData(
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build());
    ImmutableBackingEntityWidgetData instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBackingEntityWidgetData actualImmutableBackingEntityWidgetData = builderResult.build();
    assertEquals(instance, actualImmutableBackingEntityWidgetData);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BackingEntityWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BackingEntityWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(BackingEntityWidgetData); when builder build; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BackingEntityWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetData.builder();
    ImmutableBackingEntityWidgetData instance = ImmutableBackingEntityWidgetData.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBackingEntityWidgetData actualImmutableBackingEntityWidgetData = builderResult.build();
    assertEquals(instance, actualImmutableBackingEntityWidgetData);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#copyOf(BackingEntityWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetData#copyOf(BackingEntityWidgetData)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BackingEntityWidgetData); when builder build; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetData ImmutableBackingEntityWidgetData.copyOf(BackingEntityWidgetData)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnCellDataEmpty() {
    // Arrange
    ImmutableBackingEntityWidgetData instance = ImmutableBackingEntityWidgetData.builder().build();

    // Act and Assert
    assertTrue(ImmutableBackingEntityWidgetData.copyOf(instance).cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#equals(Object)}, and {@link
   * ImmutableBackingEntityWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBackingEntityWidgetData#equals(Object)}
   *   <li>{@link ImmutableBackingEntityWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetData.equals(Object)",
    "int ImmutableBackingEntityWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBackingEntityWidgetData immutableBackingEntityWidgetData =
        ImmutableBackingEntityWidgetData.builder().build();
    ImmutableBackingEntityWidgetData immutableBackingEntityWidgetData2 =
        ImmutableBackingEntityWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableBackingEntityWidgetData, immutableBackingEntityWidgetData2);
    assertEquals(
        immutableBackingEntityWidgetData.hashCode(), immutableBackingEntityWidgetData2.hashCode());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#equals(Object)}, and {@link
   * ImmutableBackingEntityWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBackingEntityWidgetData#equals(Object)}
   *   <li>{@link ImmutableBackingEntityWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetData.equals(Object)",
    "int ImmutableBackingEntityWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBackingEntityWidgetData immutableBackingEntityWidgetData =
        ImmutableBackingEntityWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableBackingEntityWidgetData, immutableBackingEntityWidgetData);
    int expectedHashCodeResult = immutableBackingEntityWidgetData.hashCode();
    assertEquals(expectedHashCodeResult, immutableBackingEntityWidgetData.hashCode());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetData.equals(Object)",
    "int ImmutableBackingEntityWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetData.builder();
    builderResult.addCellData(
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableBackingEntityWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetData.equals(Object)",
    "int ImmutableBackingEntityWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableBackingEntityWidgetData.builder().build(), null);
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetData.equals(Object)",
    "int ImmutableBackingEntityWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBackingEntityWidgetData.builder().build(),
        "Different type to ImmutableBackingEntityWidgetData");
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableBackingEntityWidgetDatum.Json} (default constructor).
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetData ImmutableBackingEntityWidgetData.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<BackingEntityWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableBackingEntityWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act
    ImmutableBackingEntityWidgetData actualFromJsonResult =
        ImmutableBackingEntityWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) CellData is 'null'; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetData ImmutableBackingEntityWidgetData.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonCellDataIsNull_thenReturnCellDataEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellData(null);

    // Act
    ImmutableBackingEntityWidgetData actualFromJsonResult =
        ImmutableBackingEntityWidgetData.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return cellData is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetData ImmutableBackingEntityWidgetData.fromJson(Json)"
  })
  void testFromJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<BackingEntityWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build());
    cellData.add(new ImmutableBackingEntityWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act
    ImmutableBackingEntityWidgetData actualFromJsonResult =
        ImmutableBackingEntityWidgetData.fromJson(json);

    // Assert
    assertEquals(cellData, actualFromJsonResult.cellData());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetData ImmutableBackingEntityWidgetData.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnCellDataEmpty() {
    // Arrange and Act
    ImmutableBackingEntityWidgetData actualFromJsonResult =
        ImmutableBackingEntityWidgetData.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBackingEntityWidgetData#toString()}
   *   <li>{@link ImmutableBackingEntityWidgetData#cellData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set ImmutableBackingEntityWidgetData.cellData()",
    "String ImmutableBackingEntityWidgetData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBackingEntityWidgetData immutableBackingEntityWidgetData =
        ImmutableBackingEntityWidgetData.builder().build();

    // Act
    String actualToStringResult = immutableBackingEntityWidgetData.toString();

    // Assert
    assertEquals("BackingEntityWidgetData{cellData=[]}", actualToStringResult);
    assertTrue(immutableBackingEntityWidgetData.cellData().isEmpty());
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
   * Test {@link ImmutableBackingEntityWidgetData#withCellData(BackingEntityWidgetDatum[])} with
   * {@code BackingEntityWidgetDatum[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBackingEntityWidgetData#withCellData(BackingEntityWidgetDatum[])}
   */
  @Test
  @DisplayName("Test withCellData(BackingEntityWidgetDatum[]) with 'BackingEntityWidgetDatum[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetData ImmutableBackingEntityWidgetData.withCellData(BackingEntityWidgetDatum[])"
  })
  void testWithCellDataWithBackingEntityWidgetDatum() {
    // Arrange
    ImmutableBackingEntityWidgetData immutableBackingEntityWidgetData =
        ImmutableBackingEntityWidgetData.builder().build();

    // Act and Assert
    assertEquals(
        1,
        immutableBackingEntityWidgetData
            .withCellData(ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build())
            .cellData()
            .size());
  }
}
