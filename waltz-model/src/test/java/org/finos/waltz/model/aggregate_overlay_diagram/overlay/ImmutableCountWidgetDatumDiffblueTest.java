package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCountWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCountWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCountWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountWidgetDatum Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCountWidgetDatum actualImmutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();

    // Assert
    assertEquals("42", actualImmutableCountWidgetDatum.cellExternalId());
    assertEquals(3, actualImmutableCountWidgetDatum.currentStateCount());
    assertEquals(3, actualImmutableCountWidgetDatum.targetStateCount());
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
    Builder builderResult = ImmutableCountWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#currentStateCount(int)}.
   *
   * <p>Method under test: {@link Builder#currentStateCount(int)}
   */
  @Test
  @DisplayName("Test Builder currentStateCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.currentStateCount(int)"})
  void testBuilderCurrentStateCount() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetDatum.builder();

    // Act
    Builder actualCurrentStateCountResult = builderResult.currentStateCount(3);

    // Assert
    assertSame(builderResult, actualCurrentStateCountResult);
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
    Builder builderResult = ImmutableCountWidgetDatum.builder();
    ImmutableCountWidgetDatum instance =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((CellExternalIdProvider) instance);

    // Assert
    ImmutableCountWidgetDatum actualImmutableCountWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableCountWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then calls {@link CellExternalIdProvider#cellExternalId()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; given '42'; then calls cellExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_given42_thenCallsCellExternalId() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetDatum.builder();

    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CountWidgetDatum)} with {@code CountWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(CountWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(CountWidgetDatum) with 'CountWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CountWidgetDatum)"})
  void testBuilderFromWithCountWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetDatum.builder();
    ImmutableCountWidgetDatum instance =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCountWidgetDatum actualImmutableCountWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableCountWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#targetStateCount(int)}.
   *
   * <p>Method under test: {@link Builder#targetStateCount(int)}
   */
  @Test
  @DisplayName("Test Builder targetStateCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetStateCount(int)"})
  void testBuilderTargetStateCount() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetDatum.builder();

    // Act
    Builder actualTargetStateCountResult = builderResult.targetStateCount(3);

    // Assert
    assertSame(builderResult, actualTargetStateCountResult);
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#copyOf(CountWidgetDatum)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#copyOf(CountWidgetDatum)}
   */
  @Test
  @DisplayName("Test copyOf(CountWidgetDatum); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCountWidgetDatum ImmutableCountWidgetDatum.copyOf(CountWidgetDatum)"
  })
  void testCopyOf_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableCountWidgetDatum instance =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();

    // Act
    ImmutableCountWidgetDatum actualCopyOfResult = ImmutableCountWidgetDatum.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(3, actualCopyOfResult.currentStateCount());
    assertEquals(3, actualCopyOfResult.targetStateCount());
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#equals(Object)}, and {@link
   * ImmutableCountWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCountWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableCountWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetDatum.equals(Object)",
    "int ImmutableCountWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCountWidgetDatum immutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();
    ImmutableCountWidgetDatum immutableCountWidgetDatum2 =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableCountWidgetDatum, immutableCountWidgetDatum2);
    assertEquals(immutableCountWidgetDatum.hashCode(), immutableCountWidgetDatum2.hashCode());
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#equals(Object)}, and {@link
   * ImmutableCountWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCountWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableCountWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetDatum.equals(Object)",
    "int ImmutableCountWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCountWidgetDatum immutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableCountWidgetDatum, immutableCountWidgetDatum);
    int expectedHashCodeResult = immutableCountWidgetDatum.hashCode();
    assertEquals(expectedHashCodeResult, immutableCountWidgetDatum.hashCode());
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetDatum.equals(Object)",
    "int ImmutableCountWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCountWidgetDatum immutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("Cell External Id")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCountWidgetDatum,
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetDatum.equals(Object)",
    "int ImmutableCountWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCountWidgetDatum immutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(1)
            .targetStateCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCountWidgetDatum,
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetDatum.equals(Object)",
    "int ImmutableCountWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableCountWidgetDatum immutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCountWidgetDatum,
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetDatum.equals(Object)",
    "int ImmutableCountWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCountWidgetDatum.equals(Object)",
    "int ImmutableCountWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build(),
        "Different type to ImmutableCountWidgetDatum");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCountWidgetDatum#toString()}
   *   <li>{@link ImmutableCountWidgetDatum#cellExternalId()}
   *   <li>{@link ImmutableCountWidgetDatum#currentStateCount()}
   *   <li>{@link ImmutableCountWidgetDatum#targetStateCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCountWidgetDatum.cellExternalId()",
    "int ImmutableCountWidgetDatum.currentStateCount()",
    "int ImmutableCountWidgetDatum.targetStateCount()",
    "String ImmutableCountWidgetDatum.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCountWidgetDatum immutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();

    // Act
    String actualToStringResult = immutableCountWidgetDatum.toString();
    String actualCellExternalIdResult = immutableCountWidgetDatum.cellExternalId();
    int actualCurrentStateCountResult = immutableCountWidgetDatum.currentStateCount();

    // Assert
    assertEquals("42", actualCellExternalIdResult);
    assertEquals(
        "CountWidgetDatum{cellExternalId=42, currentStateCount=3, targetStateCount=3}",
        actualToStringResult);
    assertEquals(3, actualCurrentStateCountResult);
    assertEquals(3, immutableCountWidgetDatum.targetStateCount());
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
   * Test Json {@link Json#currentStateCount()}.
   *
   * <p>Method under test: {@link Json#currentStateCount()}
   */
  @Test
  @DisplayName("Test Json currentStateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.currentStateCount()"})
  void testJsonCurrentStateCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().currentStateCount());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCellExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCellExternalId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCellExternalId("42");

    // Assert
    assertEquals("42", actualJson.cellExternalId);
    assertEquals(0, actualJson.currentStateCount);
    assertEquals(0, actualJson.targetStateCount);
    assertFalse(actualJson.currentStateCountIsSet);
    assertFalse(actualJson.targetStateCountIsSet);
  }

  /**
   * Test Json {@link Json#setCurrentStateCount(int)}.
   *
   * <p>Method under test: {@link Json#setCurrentStateCount(int)}
   */
  @Test
  @DisplayName("Test Json setCurrentStateCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCurrentStateCount(int)"})
  void testJsonSetCurrentStateCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCurrentStateCount(3);

    // Assert
    assertEquals(3, json.currentStateCount);
    assertTrue(json.currentStateCountIsSet);
  }

  /**
   * Test Json {@link Json#setTargetStateCount(int)}.
   *
   * <p>Method under test: {@link Json#setTargetStateCount(int)}
   */
  @Test
  @DisplayName("Test Json setTargetStateCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setTargetStateCount(int)"})
  void testJsonSetTargetStateCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTargetStateCount(3);

    // Assert
    assertEquals(3, json.targetStateCount);
    assertTrue(json.targetStateCountIsSet);
  }

  /**
   * Test Json {@link Json#targetStateCount()}.
   *
   * <p>Method under test: {@link Json#targetStateCount()}
   */
  @Test
  @DisplayName("Test Json targetStateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.targetStateCount()"})
  void testJsonTargetStateCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetStateCount());
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#withCellExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCountWidgetDatum ImmutableCountWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId() {
    // Arrange
    ImmutableCountWidgetDatum immutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build();

    // Act
    ImmutableCountWidgetDatum actualWithCellExternalIdResult =
        immutableCountWidgetDatum.withCellExternalId("42");

    // Assert
    assertSame(immutableCountWidgetDatum, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCountWidgetDatum ImmutableCountWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableCountWidgetDatum actualWithCellExternalIdResult =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("cellExternalId")
            .currentStateCount(3)
            .targetStateCount(3)
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertEquals(3, actualWithCellExternalIdResult.currentStateCount());
    assertEquals(3, actualWithCellExternalIdResult.targetStateCount());
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#withCurrentStateCount(int)}.
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#withCurrentStateCount(int)}
   */
  @Test
  @DisplayName("Test withCurrentStateCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCountWidgetDatum ImmutableCountWidgetDatum.withCurrentStateCount(int)"
  })
  void testWithCurrentStateCount() {
    // Arrange
    ImmutableCountWidgetDatum immutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(42)
            .targetStateCount(3)
            .build();

    // Act
    ImmutableCountWidgetDatum actualWithCurrentStateCountResult =
        immutableCountWidgetDatum.withCurrentStateCount(42);

    // Assert
    assertSame(immutableCountWidgetDatum, actualWithCurrentStateCountResult);
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#withCurrentStateCount(int)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#withCurrentStateCount(int)}
   */
  @Test
  @DisplayName("Test withCurrentStateCount(int); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCountWidgetDatum ImmutableCountWidgetDatum.withCurrentStateCount(int)"
  })
  void testWithCurrentStateCount_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableCountWidgetDatum actualWithCurrentStateCountResult =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build()
            .withCurrentStateCount(42);

    // Assert
    assertEquals("42", actualWithCurrentStateCountResult.cellExternalId());
    assertEquals(3, actualWithCurrentStateCountResult.targetStateCount());
    assertEquals(42, actualWithCurrentStateCountResult.currentStateCount());
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#withTargetStateCount(int)}.
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#withTargetStateCount(int)}
   */
  @Test
  @DisplayName("Test withTargetStateCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCountWidgetDatum ImmutableCountWidgetDatum.withTargetStateCount(int)"
  })
  void testWithTargetStateCount() {
    // Arrange
    ImmutableCountWidgetDatum immutableCountWidgetDatum =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(42)
            .build();

    // Act
    ImmutableCountWidgetDatum actualWithTargetStateCountResult =
        immutableCountWidgetDatum.withTargetStateCount(42);

    // Assert
    assertSame(immutableCountWidgetDatum, actualWithTargetStateCountResult);
  }

  /**
   * Test {@link ImmutableCountWidgetDatum#withTargetStateCount(int)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountWidgetDatum#withTargetStateCount(int)}
   */
  @Test
  @DisplayName("Test withTargetStateCount(int); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCountWidgetDatum ImmutableCountWidgetDatum.withTargetStateCount(int)"
  })
  void testWithTargetStateCount_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableCountWidgetDatum actualWithTargetStateCountResult =
        ImmutableCountWidgetDatum.builder()
            .cellExternalId("42")
            .currentStateCount(3)
            .targetStateCount(3)
            .build()
            .withTargetStateCount(42);

    // Assert
    assertEquals("42", actualWithTargetStateCountResult.cellExternalId());
    assertEquals(3, actualWithTargetStateCountResult.currentStateCount());
    assertEquals(42, actualWithTargetStateCountResult.targetStateCount());
  }
}
