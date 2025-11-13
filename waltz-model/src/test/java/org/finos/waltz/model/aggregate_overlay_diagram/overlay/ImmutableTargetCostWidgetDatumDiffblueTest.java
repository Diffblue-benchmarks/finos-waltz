package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableTargetCostWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableTargetCostWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTargetCostWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTargetCostWidgetDatum Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCellExternalIdResult =
        ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");
    BigDecimal currentStateCost = new BigDecimal("2.3");
    Builder actualCurrentStateCostResult =
        actualCellExternalIdResult.currentStateCost(currentStateCost);
    BigDecimal targetStateCost = new BigDecimal("2.3");
    ImmutableTargetCostWidgetDatum actualImmutableTargetCostWidgetDatum =
        actualCurrentStateCostResult.targetStateCost(targetStateCost).build();

    // Assert
    assertEquals("42", actualImmutableTargetCostWidgetDatum.cellExternalId());
    BigDecimal expectedCurrentStateCostResult = new BigDecimal("2.3");
    BigDecimal currentStateCostResult = actualImmutableTargetCostWidgetDatum.currentStateCost();
    assertEquals(expectedCurrentStateCostResult, currentStateCostResult);
    BigDecimal expectedTargetStateCostResult = new BigDecimal("2.3");
    BigDecimal targetStateCostResult = actualImmutableTargetCostWidgetDatum.targetStateCost();
    assertEquals(expectedTargetStateCostResult, targetStateCostResult);
    assertSame(currentStateCost, currentStateCostResult);
    assertSame(targetStateCost, targetStateCostResult);
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder cellExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#currentStateCost(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#currentStateCost(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder currentStateCost(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.currentStateCost(BigDecimal)"})
  void testBuilderCurrentStateCost_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    // Act
    Builder actualCurrentStateCostResult = builderResult.currentStateCost(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualCurrentStateCostResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum instance =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    // Act and Assert
    ImmutableTargetCostWidgetDatum actualImmutableTargetCostWidgetDatum =
        builderResult.from((CellExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableTargetCostWidgetDatum);
    ImmutableTargetCostWidgetDatum actualImmutableTargetCostWidgetDatum2 = builderResult.build();
    assertEquals(instance, actualImmutableTargetCostWidgetDatum2);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; given '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_given42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TargetCostWidgetDatum)} with {@code TargetCostWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(TargetCostWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(TargetCostWidgetDatum) with 'TargetCostWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TargetCostWidgetDatum)"})
  void testBuilderFromWithTargetCostWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum instance =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTargetCostWidgetDatum actualImmutableTargetCostWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableTargetCostWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#targetStateCost(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetStateCost(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder targetStateCost(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetStateCost(BigDecimal)"})
  void testBuilderTargetStateCost_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTargetCostWidgetDatum.builder();

    // Act
    Builder actualTargetStateCostResult = builderResult.targetStateCost(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualTargetStateCostResult);
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#copyOf(TargetCostWidgetDatum)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#copyOf(TargetCostWidgetDatum)}
   */
  @Test
  @DisplayName("Test copyOf(TargetCostWidgetDatum); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetCostWidgetDatum ImmutableTargetCostWidgetDatum.copyOf(TargetCostWidgetDatum)"
  })
  void testCopyOf_thenReturnCellExternalIdIs42() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum instance =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    // Act
    ImmutableTargetCostWidgetDatum actualCopyOfResult =
        ImmutableTargetCostWidgetDatum.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    BigDecimal expectedCurrentStateCostResult = new BigDecimal("2.3");
    assertEquals(expectedCurrentStateCostResult, actualCopyOfResult.currentStateCost());
    BigDecimal expectedTargetStateCostResult = new BigDecimal("2.3");
    assertEquals(expectedTargetStateCostResult, actualCopyOfResult.targetStateCost());
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#equals(Object)}, and {@link
   * ImmutableTargetCostWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTargetCostWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableTargetCostWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetCostWidgetDatum.equals(Object)",
    "int ImmutableTargetCostWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    Builder cellExternalIdResult2 = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult2 = cellExternalIdResult2.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum2 =
        currentStateCostResult2.targetStateCost(new BigDecimal("2.3")).build();

    // Act and Assert
    assertEquals(immutableTargetCostWidgetDatum, immutableTargetCostWidgetDatum2);
    assertEquals(
        immutableTargetCostWidgetDatum.hashCode(), immutableTargetCostWidgetDatum2.hashCode());
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#equals(Object)}, and {@link
   * ImmutableTargetCostWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTargetCostWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableTargetCostWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetCostWidgetDatum.equals(Object)",
    "int ImmutableTargetCostWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    // Act and Assert
    assertEquals(immutableTargetCostWidgetDatum, immutableTargetCostWidgetDatum);
    int expectedHashCodeResult = immutableTargetCostWidgetDatum.hashCode();
    assertEquals(expectedHashCodeResult, immutableTargetCostWidgetDatum.hashCode());
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetCostWidgetDatum.equals(Object)",
    "int ImmutableTargetCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder cellExternalIdResult =
        ImmutableTargetCostWidgetDatum.builder().cellExternalId("Cell External Id");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    Builder cellExternalIdResult2 = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult2 = cellExternalIdResult2.currentStateCost(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableTargetCostWidgetDatum,
        currentStateCostResult2.targetStateCost(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetCostWidgetDatum.equals(Object)",
    "int ImmutableTargetCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("4.5"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    Builder cellExternalIdResult2 = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult2 = cellExternalIdResult2.currentStateCost(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableTargetCostWidgetDatum,
        currentStateCostResult2.targetStateCost(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetCostWidgetDatum.equals(Object)",
    "int ImmutableTargetCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("4.5")).build();

    Builder cellExternalIdResult2 = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult2 = cellExternalIdResult2.currentStateCost(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableTargetCostWidgetDatum,
        currentStateCostResult2.targetStateCost(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetCostWidgetDatum.equals(Object)",
    "int ImmutableTargetCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build(), null);
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetCostWidgetDatum.equals(Object)",
    "int ImmutableTargetCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build(),
        "Different type to ImmutableTargetCostWidgetDatum");
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return cellExternalId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetCostWidgetDatum ImmutableTargetCostWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnCellExternalIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setCurrentStateCost(new BigDecimal("2.3"));
    json.setTargetStateCost(new BigDecimal("2.3"));

    // Act
    ImmutableTargetCostWidgetDatum actualFromJsonResult =
        ImmutableTargetCostWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    BigDecimal expectedCurrentStateCostResult = new BigDecimal("2.3");
    assertEquals(expectedCurrentStateCostResult, actualFromJsonResult.currentStateCost());
    BigDecimal expectedTargetStateCostResult = new BigDecimal("2.3");
    assertEquals(expectedTargetStateCostResult, actualFromJsonResult.targetStateCost());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTargetCostWidgetDatum#toString()}
   *   <li>{@link ImmutableTargetCostWidgetDatum#cellExternalId()}
   *   <li>{@link ImmutableTargetCostWidgetDatum#currentStateCost()}
   *   <li>{@link ImmutableTargetCostWidgetDatum#targetStateCost()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableTargetCostWidgetDatum.cellExternalId()",
    "BigDecimal ImmutableTargetCostWidgetDatum.currentStateCost()",
    "BigDecimal ImmutableTargetCostWidgetDatum.targetStateCost()",
    "String ImmutableTargetCostWidgetDatum.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");
    BigDecimal currentStateCost = new BigDecimal("2.3");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(currentStateCost);
    BigDecimal targetStateCost = new BigDecimal("2.3");
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(targetStateCost).build();

    // Act
    String actualToStringResult = immutableTargetCostWidgetDatum.toString();
    String actualCellExternalIdResult = immutableTargetCostWidgetDatum.cellExternalId();
    BigDecimal actualCurrentStateCostResult = immutableTargetCostWidgetDatum.currentStateCost();
    BigDecimal actualTargetStateCostResult = immutableTargetCostWidgetDatum.targetStateCost();

    // Assert
    assertEquals("42", actualCellExternalIdResult);
    assertEquals(
        "TargetCostWidgetDatum{cellExternalId=42, currentStateCost=2.3, targetStateCost=2.3}",
        actualToStringResult);
    assertEquals(new BigDecimal("2.3"), actualCurrentStateCostResult);
    assertEquals(new BigDecimal("2.3"), actualTargetStateCostResult);
    assertSame(currentStateCost, actualCurrentStateCostResult);
    assertSame(targetStateCost, actualTargetStateCostResult);
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   *
   * <p>Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellExternalId());
  }

  /**
   * Test Json {@link Json#currentStateCost()}.
   *
   * <p>Method under test: {@link Json#currentStateCost()}
   */
  @Test
  @DisplayName("Test Json currentStateCost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.currentStateCost()"})
  void testJsonCurrentStateCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().currentStateCost());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCellExternalId(String)}
   *   <li>{@link Json#setCurrentStateCost(BigDecimal)}
   *   <li>{@link Json#setTargetStateCost(BigDecimal)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCellExternalId(String)",
    "void Json.setCurrentStateCost(BigDecimal)",
    "void Json.setTargetStateCost(BigDecimal)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCellExternalId("42");
    actualJson.setCurrentStateCost(new BigDecimal("2.3"));
    actualJson.setTargetStateCost(new BigDecimal("2.3"));

    // Assert
    assertEquals("42", actualJson.cellExternalId);
    assertEquals(new BigDecimal("2.3"), actualJson.currentStateCost);
    assertEquals(new BigDecimal("2.3"), actualJson.targetStateCost);
  }

  /**
   * Test Json {@link Json#targetStateCost()}.
   *
   * <p>Method under test: {@link Json#targetStateCost()}
   */
  @Test
  @DisplayName("Test Json targetStateCost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.targetStateCost()"})
  void testJsonTargetStateCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetStateCost());
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#withCellExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetCostWidgetDatum ImmutableTargetCostWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    // Act
    ImmutableTargetCostWidgetDatum actualWithCellExternalIdResult =
        immutableTargetCostWidgetDatum.withCellExternalId("42");

    // Assert
    assertSame(immutableTargetCostWidgetDatum, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetCostWidgetDatum ImmutableTargetCostWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnCellExternalIdIs42() {
    // Arrange
    Builder cellExternalIdResult =
        ImmutableTargetCostWidgetDatum.builder().cellExternalId("cellExternalId");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));

    // Act
    ImmutableTargetCostWidgetDatum actualWithCellExternalIdResult =
        currentStateCostResult
            .targetStateCost(new BigDecimal("2.3"))
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    BigDecimal expectedCurrentStateCostResult = new BigDecimal("2.3");
    assertEquals(expectedCurrentStateCostResult, actualWithCellExternalIdResult.currentStateCost());
    BigDecimal expectedTargetStateCostResult = new BigDecimal("2.3");
    assertEquals(expectedTargetStateCostResult, actualWithCellExternalIdResult.targetStateCost());
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#withCurrentStateCost(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#withCurrentStateCost(BigDecimal)}
   */
  @Test
  @DisplayName("Test withCurrentStateCost(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetCostWidgetDatum ImmutableTargetCostWidgetDatum.withCurrentStateCost(BigDecimal)"
  })
  void testWithCurrentStateCost() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    // Act
    ImmutableTargetCostWidgetDatum actualWithCurrentStateCostResult =
        immutableTargetCostWidgetDatum.withCurrentStateCost(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableTargetCostWidgetDatum, actualWithCurrentStateCostResult);
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#withCurrentStateCost(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#withCurrentStateCost(BigDecimal)}
   */
  @Test
  @DisplayName("Test withCurrentStateCost(BigDecimal); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetCostWidgetDatum ImmutableTargetCostWidgetDatum.withCurrentStateCost(BigDecimal)"
  })
  void testWithCurrentStateCost_thenReturnCellExternalIdIs42() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("4.5"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    // Act
    ImmutableTargetCostWidgetDatum actualWithCurrentStateCostResult =
        immutableTargetCostWidgetDatum.withCurrentStateCost(new BigDecimal("2.3"));

    // Assert
    assertEquals("42", actualWithCurrentStateCostResult.cellExternalId());
    BigDecimal expectedCurrentStateCostResult = new BigDecimal("2.3");
    assertEquals(
        expectedCurrentStateCostResult, actualWithCurrentStateCostResult.currentStateCost());
    BigDecimal expectedTargetStateCostResult = new BigDecimal("2.3");
    assertEquals(expectedTargetStateCostResult, actualWithCurrentStateCostResult.targetStateCost());
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#withTargetStateCost(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#withTargetStateCost(BigDecimal)}
   */
  @Test
  @DisplayName("Test withTargetStateCost(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetCostWidgetDatum ImmutableTargetCostWidgetDatum.withTargetStateCost(BigDecimal)"
  })
  void testWithTargetStateCost() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build();

    // Act
    ImmutableTargetCostWidgetDatum actualWithTargetStateCostResult =
        immutableTargetCostWidgetDatum.withTargetStateCost(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableTargetCostWidgetDatum, actualWithTargetStateCostResult);
  }

  /**
   * Test {@link ImmutableTargetCostWidgetDatum#withTargetStateCost(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetCostWidgetDatum#withTargetStateCost(BigDecimal)}
   */
  @Test
  @DisplayName("Test withTargetStateCost(BigDecimal); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetCostWidgetDatum ImmutableTargetCostWidgetDatum.withTargetStateCost(BigDecimal)"
  })
  void testWithTargetStateCost_thenReturnCellExternalIdIs42() {
    // Arrange
    Builder cellExternalIdResult = ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    Builder currentStateCostResult = cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    ImmutableTargetCostWidgetDatum immutableTargetCostWidgetDatum =
        currentStateCostResult.targetStateCost(new BigDecimal("4.5")).build();

    // Act
    ImmutableTargetCostWidgetDatum actualWithTargetStateCostResult =
        immutableTargetCostWidgetDatum.withTargetStateCost(new BigDecimal("2.3"));

    // Assert
    assertEquals("42", actualWithTargetStateCostResult.cellExternalId());
    BigDecimal expectedCurrentStateCostResult = new BigDecimal("2.3");
    assertEquals(
        expectedCurrentStateCostResult, actualWithTargetStateCostResult.currentStateCost());
    BigDecimal expectedTargetStateCostResult = new BigDecimal("2.3");
    assertEquals(expectedTargetStateCostResult, actualWithTargetStateCostResult.targetStateCost());
  }
}
