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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingsWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingsWidgetData.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingsWidgetDataDiffblueTest {
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
    Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    // Act
    Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(AssessmentRatingsWidgetDatum)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingsWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(AssessmentRatingsWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(AssessmentRatingsWidgetDatum) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(AssessmentRatingsWidgetDatum)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableAssessmentRatingsWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(AssessmentRatingsWidgetDatum[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingsWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(AssessmentRatingsWidgetDatum[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(AssessmentRatingsWidgetDatum[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(AssessmentRatingsWidgetDatum[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableAssessmentRatingsWidgetDatum.Json());

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
  @MethodsUnderTest({"ImmutableAssessmentRatingsWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAssessmentRatingsWidgetData.builder().build().cellData().isEmpty());
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
    Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    // Act
    Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertTrue(actualCellDataResult.build().cellData().isEmpty());
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingsWidgetData)}.
   *
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingsWidgetData)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingsWidgetData); given builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingsWidgetData)"})
  void testBuilderFrom_givenBuilderCellExternalId42Build() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();

    Builder builderResult2 = ImmutableAssessmentRatingsWidgetData.builder();
    builderResult2.addCellData(
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build());
    ImmutableAssessmentRatingsWidgetData instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingsWidgetData actualImmutableAssessmentRatingsWidgetData =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingsWidgetData);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingsWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingsWidgetData)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingsWidgetData); when builder build; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingsWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();
    ImmutableAssessmentRatingsWidgetData instance =
        ImmutableAssessmentRatingsWidgetData.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingsWidgetData actualImmutableAssessmentRatingsWidgetData =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingsWidgetData);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#copyOf(AssessmentRatingsWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingsWidgetData#copyOf(AssessmentRatingsWidgetData)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingsWidgetData); when builder build; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetData ImmutableAssessmentRatingsWidgetData.copyOf(AssessmentRatingsWidgetData)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnCellDataEmpty() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData instance =
        ImmutableAssessmentRatingsWidgetData.builder().build();

    // Act and Assert
    assertTrue(ImmutableAssessmentRatingsWidgetData.copyOf(instance).cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#equals(Object)}, and {@link
   * ImmutableAssessmentRatingsWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingsWidgetData#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingsWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetData.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData immutableAssessmentRatingsWidgetData =
        ImmutableAssessmentRatingsWidgetData.builder().build();
    ImmutableAssessmentRatingsWidgetData immutableAssessmentRatingsWidgetData2 =
        ImmutableAssessmentRatingsWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingsWidgetData, immutableAssessmentRatingsWidgetData2);
    assertEquals(
        immutableAssessmentRatingsWidgetData.hashCode(),
        immutableAssessmentRatingsWidgetData2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#equals(Object)}, and {@link
   * ImmutableAssessmentRatingsWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingsWidgetData#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingsWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetData.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData immutableAssessmentRatingsWidgetData =
        ImmutableAssessmentRatingsWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingsWidgetData, immutableAssessmentRatingsWidgetData);
    int expectedHashCodeResult = immutableAssessmentRatingsWidgetData.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingsWidgetData.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetData.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetData.builder();
    builderResult.addCellData(
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAssessmentRatingsWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetData.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAssessmentRatingsWidgetData.builder().build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetData.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingsWidgetData.builder().build(),
        "Different type to ImmutableAssessmentRatingsWidgetData");
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableAssessmentRatingsWidgetDatum.Json} (default constructor).
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetData ImmutableAssessmentRatingsWidgetData.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentRatingsWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAssessmentRatingsWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act
    ImmutableAssessmentRatingsWidgetData actualFromJsonResult =
        ImmutableAssessmentRatingsWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) CellData is 'null'; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetData ImmutableAssessmentRatingsWidgetData.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonCellDataIsNull_thenReturnCellDataEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellData(null);

    // Act
    ImmutableAssessmentRatingsWidgetData actualFromJsonResult =
        ImmutableAssessmentRatingsWidgetData.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return cellData is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetData ImmutableAssessmentRatingsWidgetData.fromJson(Json)"
  })
  void testFromJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AssessmentRatingsWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build());
    cellData.add(new ImmutableAssessmentRatingsWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);

    // Act
    ImmutableAssessmentRatingsWidgetData actualFromJsonResult =
        ImmutableAssessmentRatingsWidgetData.fromJson(json);

    // Assert
    assertEquals(cellData, actualFromJsonResult.cellData());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetData ImmutableAssessmentRatingsWidgetData.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnCellDataEmpty() {
    // Arrange and Act
    ImmutableAssessmentRatingsWidgetData actualFromJsonResult =
        ImmutableAssessmentRatingsWidgetData.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.cellData().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingsWidgetData#toString()}
   *   <li>{@link ImmutableAssessmentRatingsWidgetData#cellData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set ImmutableAssessmentRatingsWidgetData.cellData()",
    "String ImmutableAssessmentRatingsWidgetData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData immutableAssessmentRatingsWidgetData =
        ImmutableAssessmentRatingsWidgetData.builder().build();

    // Act
    String actualToStringResult = immutableAssessmentRatingsWidgetData.toString();

    // Assert
    assertEquals("AssessmentRatingsWidgetData{cellData=[]}", actualToStringResult);
    assertTrue(immutableAssessmentRatingsWidgetData.cellData().isEmpty());
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
   * Test {@link ImmutableAssessmentRatingsWidgetData#withCellData(AssessmentRatingsWidgetDatum[])}
   * with {@code AssessmentRatingsWidgetDatum[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingsWidgetData#withCellData(AssessmentRatingsWidgetDatum[])}
   */
  @Test
  @DisplayName(
      "Test withCellData(AssessmentRatingsWidgetDatum[]) with 'AssessmentRatingsWidgetDatum[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetData ImmutableAssessmentRatingsWidgetData.withCellData(AssessmentRatingsWidgetDatum[])"
  })
  void testWithCellDataWithAssessmentRatingsWidgetDatum() {
    // Arrange
    ImmutableAssessmentRatingsWidgetData immutableAssessmentRatingsWidgetData =
        ImmutableAssessmentRatingsWidgetData.builder().build();

    // Act and Assert
    assertEquals(
        1,
        immutableAssessmentRatingsWidgetData
            .withCellData(
                ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build())
            .cellData()
            .size());
  }
}
