package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexityWidgetDatumDiffblueTest {
  /**
   * Test {@link ImmutableComplexityWidgetDatum#averageComplexity()}.
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#averageComplexity()}
   */
  @Test
  @DisplayName("Test averageComplexity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ImmutableComplexityWidgetDatum.averageComplexity()"})
  void testAverageComplexity() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    BigDecimal actualAverageComplexityResult = immutableComplexityWidgetDatum.averageComplexity();

    // Assert
    assertEquals(new BigDecimal("0"), actualAverageComplexityResult);
    assertSame(BigDecimal.ZERO, immutableComplexityWidgetDatum.totalComplexity());
  }

  /**
   * Test Builder {@link Builder#addAllComplexities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllComplexities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllComplexities(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllComplexities(Iterable)"})
  void testBuilderAddAllComplexities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act
    Builder actualAddAllComplexitiesResult = builderResult.addAllComplexities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllComplexitiesResult);
  }

  /**
   * Test Builder {@link Builder#addComplexities(ComplexityEntry)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableComplexityEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addComplexities(ComplexityEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addComplexities(ComplexityEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addComplexities(ComplexityEntry)"})
  void testBuilderAddComplexitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act
    Builder actualAddComplexitiesResult =
        builderResult.addComplexities(new ImmutableComplexityEntry.Json());

    // Assert
    assertSame(builderResult, actualAddComplexitiesResult);
  }

  /**
   * Test Builder {@link Builder#addComplexities(ComplexityEntry[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableComplexityEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addComplexities(ComplexityEntry[])}
   */
  @Test
  @DisplayName(
      "Test Builder addComplexities(ComplexityEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addComplexities(ComplexityEntry[])"})
  void testBuilderAddComplexitiesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act
    Builder actualAddComplexitiesResult =
        builderResult.addComplexities(new ImmutableComplexityEntry.Json());

    // Assert
    assertSame(builderResult, actualAddComplexitiesResult);
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
  @MethodsUnderTest({"ImmutableComplexityWidgetDatum Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableComplexityWidgetDatum actualImmutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Assert
    assertEquals("42", actualImmutableComplexityWidgetDatum.cellExternalId());
    assertTrue(actualImmutableComplexityWidgetDatum.complexities().isEmpty());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("0");
    assertEquals(
        expectedAverageComplexityResult, actualImmutableComplexityWidgetDatum.averageComplexity());
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test Builder cellExternalId(String); when '42'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId_when42_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#complexities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#complexities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder complexities(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.complexities(Iterable)"})
  void testBuilderComplexities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act
    Builder actualComplexitiesResult = builderResult.complexities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualComplexitiesResult);
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
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();
    ImmutableComplexityWidgetDatum instance =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from((CellExternalIdProvider) instance);

    // Assert
    ImmutableComplexityWidgetDatum actualImmutableComplexityWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableComplexityWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityWidgetDatum)} with {@code ComplexityWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(ComplexityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityWidgetDatum) with 'ComplexityWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexityWidgetDatum)"})
  void testBuilderFromWithComplexityWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();
    ImmutableComplexityWidgetDatum instance =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    ImmutableComplexityWidgetDatum actualImmutableComplexityWidgetDatum =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableComplexityWidgetDatum);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityWidgetDatum)} with {@code ComplexityWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(ComplexityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityWidgetDatum) with 'ComplexityWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexityWidgetDatum)"})
  void testBuilderFromWithComplexityWidgetDatum2() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    Builder builderResult2 = ImmutableComplexityWidgetDatum.builder();

    ImmutableComplexityEntry.Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    builderResult2.addComplexities(
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build());
    ImmutableComplexityWidgetDatum instance = builderResult2.cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableComplexityWidgetDatum actualImmutableComplexityWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableComplexityWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#copyOf(ComplexityWidgetDatum)}.
   *
   * <ul>
   *   <li>When builder cellExternalId {@code 42} build.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#copyOf(ComplexityWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ComplexityWidgetDatum); when builder cellExternalId '42' build; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityWidgetDatum ImmutableComplexityWidgetDatum.copyOf(ComplexityWidgetDatum)"
  })
  void testCopyOf_whenBuilderCellExternalId42Build_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableComplexityWidgetDatum instance =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableComplexityWidgetDatum actualCopyOfResult =
        ImmutableComplexityWidgetDatum.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.complexities().isEmpty());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("0");
    BigDecimal averageComplexityResult = actualCopyOfResult.averageComplexity();
    assertEquals(expectedAverageComplexityResult, averageComplexityResult);
    assertSame(averageComplexityResult, actualCopyOfResult.totalComplexity());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#equals(Object)}, and {@link
   * ImmutableComplexityWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableComplexityWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityWidgetDatum.equals(Object)",
    "int ImmutableComplexityWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum2 =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableComplexityWidgetDatum, immutableComplexityWidgetDatum2);
    assertEquals(
        immutableComplexityWidgetDatum.hashCode(), immutableComplexityWidgetDatum2.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#equals(Object)}, and {@link
   * ImmutableComplexityWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableComplexityWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityWidgetDatum.equals(Object)",
    "int ImmutableComplexityWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableComplexityWidgetDatum, immutableComplexityWidgetDatum);
    int expectedHashCodeResult = immutableComplexityWidgetDatum.hashCode();
    assertEquals(expectedHashCodeResult, immutableComplexityWidgetDatum.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityWidgetDatum.equals(Object)",
    "int ImmutableComplexityWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    ImmutableComplexityEntry.Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    builderResult.addComplexities(
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build());
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableComplexityWidgetDatum,
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityWidgetDatum.equals(Object)",
    "int ImmutableComplexityWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("Cell External Id").build();

    // Act and Assert
    assertNotEquals(
        immutableComplexityWidgetDatum,
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityWidgetDatum.equals(Object)",
    "int ImmutableComplexityWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    ImmutableComplexityEntry.Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    builderResult.addComplexities(
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build());
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        builderResult.cellExternalId("42").build();

    Builder builderResult2 = ImmutableComplexityWidgetDatum.builder();

    ImmutableComplexityEntry.Builder complexityKindIdResult2 =
        ImmutableComplexityEntry.builder().appId(2L).complexityKindId(1L);
    builderResult2.addComplexities(
        complexityKindIdResult2.complexityScore(new BigDecimal("2.3")).build());

    // Act and Assert
    assertNotEquals(immutableComplexityWidgetDatum, builderResult2.cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityWidgetDatum.equals(Object)",
    "int ImmutableComplexityWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build(), null);
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityWidgetDatum.equals(Object)",
    "int ImmutableComplexityWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build(),
        "Different type to ImmutableComplexityWidgetDatum");
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Complexities is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Complexities is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityWidgetDatum ImmutableComplexityWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonComplexitiesIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setComplexities(new HashSet<>());

    // Act
    ImmutableComplexityWidgetDatum actualFromJsonResult =
        ImmutableComplexityWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.complexities().isEmpty());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("0");
    BigDecimal averageComplexityResult = actualFromJsonResult.averageComplexity();
    assertEquals(expectedAverageComplexityResult, averageComplexityResult);
    assertSame(averageComplexityResult, actualFromJsonResult.totalComplexity());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Complexities is {@code null}.
   *   <li>Then return cellExternalId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Complexities is 'null'; then return cellExternalId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityWidgetDatum ImmutableComplexityWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonComplexitiesIsNull_thenReturnCellExternalIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setComplexities(null);

    // Act
    ImmutableComplexityWidgetDatum actualFromJsonResult =
        ImmutableComplexityWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.complexities().isEmpty());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("0");
    BigDecimal averageComplexityResult = actualFromJsonResult.averageComplexity();
    assertEquals(expectedAverageComplexityResult, averageComplexityResult);
    assertSame(averageComplexityResult, actualFromJsonResult.totalComplexity());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return complexities size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return complexities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityWidgetDatum ImmutableComplexityWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnComplexitiesSizeIsOne() {
    // Arrange
    LinkedHashSet<ComplexityEntry> complexities = new LinkedHashSet<>();

    ImmutableComplexityEntry.Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    complexities.add(complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setComplexities(complexities);

    // Act
    ImmutableComplexityWidgetDatum actualFromJsonResult =
        ImmutableComplexityWidgetDatum.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.complexities().size());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("2.3");
    assertEquals(expectedAverageComplexityResult, actualFromJsonResult.averageComplexity());
    BigDecimal expectedTotalComplexityResult = new BigDecimal("2.3");
    assertEquals(expectedTotalComplexityResult, actualFromJsonResult.totalComplexity());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return totalComplexity is {@link BigDecimal#BigDecimal(String)} with {@code 4.6}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return totalComplexity is BigDecimal(String) with '4.6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityWidgetDatum ImmutableComplexityWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnTotalComplexityIsBigDecimalWith46() {
    // Arrange
    LinkedHashSet<ComplexityEntry> complexities = new LinkedHashSet<>();

    ImmutableComplexityEntry.Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(2L).complexityKindId(1L);
    complexities.add(complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build());

    ImmutableComplexityEntry.Builder complexityKindIdResult2 =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    complexities.add(complexityKindIdResult2.complexityScore(new BigDecimal("2.3")).build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setComplexities(complexities);

    // Act
    ImmutableComplexityWidgetDatum actualFromJsonResult =
        ImmutableComplexityWidgetDatum.fromJson(json);

    // Assert
    BigDecimal expectedAverageComplexityResult = new BigDecimal("2.3");
    assertEquals(expectedAverageComplexityResult, actualFromJsonResult.averageComplexity());
    BigDecimal expectedTotalComplexityResult = new BigDecimal("4.6");
    assertEquals(expectedTotalComplexityResult, actualFromJsonResult.totalComplexity());
    assertEquals(complexities, actualFromJsonResult.complexities());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityWidgetDatum#toString()}
   *   <li>{@link ImmutableComplexityWidgetDatum#cellExternalId()}
   *   <li>{@link ImmutableComplexityWidgetDatum#complexities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableComplexityWidgetDatum.cellExternalId()",
    "java.util.Set ImmutableComplexityWidgetDatum.complexities()",
    "String ImmutableComplexityWidgetDatum.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    String actualToStringResult = immutableComplexityWidgetDatum.toString();
    String actualCellExternalIdResult = immutableComplexityWidgetDatum.cellExternalId();

    // Assert
    assertEquals("42", actualCellExternalIdResult);
    assertEquals(
        "ComplexityWidgetDatum{cellExternalId=42, totalComplexity=0, averageComplexity=0, complexities=[]}",
        actualToStringResult);
    assertTrue(immutableComplexityWidgetDatum.complexities().isEmpty());
  }

  /**
   * Test Json {@link Json#averageComplexity()}.
   *
   * <p>Method under test: {@link Json#averageComplexity()}
   */
  @Test
  @DisplayName("Test Json averageComplexity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.averageComplexity()"})
  void testJsonAverageComplexity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().averageComplexity());
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
   * Test Json {@link Json#complexities()}.
   *
   * <p>Method under test: {@link Json#complexities()}
   */
  @Test
  @DisplayName("Test Json complexities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Json.complexities()"})
  void testJsonComplexities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().complexities());
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
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.complexities.isEmpty());
  }

  /**
   * Test Json {@link Json#totalComplexity()}.
   *
   * <p>Method under test: {@link Json#totalComplexity()}
   */
  @Test
  @DisplayName("Test Json totalComplexity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.totalComplexity()"})
  void testJsonTotalComplexity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().totalComplexity());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#totalComplexity()}.
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#totalComplexity()}
   */
  @Test
  @DisplayName("Test totalComplexity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ImmutableComplexityWidgetDatum.totalComplexity()"})
  void testTotalComplexity() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    BigDecimal actualTotalComplexityResult = immutableComplexityWidgetDatum.totalComplexity();

    // Assert
    assertEquals(new BigDecimal("0"), actualTotalComplexityResult);
    assertSame(BigDecimal.ZERO, immutableComplexityWidgetDatum.averageComplexity());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityWidgetDatum ImmutableComplexityWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnBuilderCellExternalId42Build() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableComplexityWidgetDatum actualWithCellExternalIdResult =
        immutableComplexityWidgetDatum.withCellExternalId("42");

    // Assert
    assertSame(immutableComplexityWidgetDatum, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return complexities Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return complexities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityWidgetDatum ImmutableComplexityWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnComplexitiesEmpty() {
    // Arrange and Act
    ImmutableComplexityWidgetDatum actualWithCellExternalIdResult =
        ImmutableComplexityWidgetDatum.builder()
            .cellExternalId("cellExternalId")
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertTrue(actualWithCellExternalIdResult.complexities().isEmpty());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("0");
    BigDecimal averageComplexityResult = actualWithCellExternalIdResult.averageComplexity();
    assertEquals(expectedAverageComplexityResult, averageComplexityResult);
    assertSame(averageComplexityResult, actualWithCellExternalIdResult.totalComplexity());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return complexities size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return complexities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityWidgetDatum ImmutableComplexityWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnComplexitiesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    ImmutableComplexityEntry.Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    builderResult.addComplexities(
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build());

    // Act
    ImmutableComplexityWidgetDatum actualWithCellExternalIdResult =
        builderResult.cellExternalId("cellExternalId").build().withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertEquals(1, actualWithCellExternalIdResult.complexities().size());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("2.3");
    assertEquals(
        expectedAverageComplexityResult, actualWithCellExternalIdResult.averageComplexity());
    BigDecimal expectedTotalComplexityResult = new BigDecimal("2.3");
    assertEquals(expectedTotalComplexityResult, actualWithCellExternalIdResult.totalComplexity());
  }

  /**
   * Test {@link ImmutableComplexityWidgetDatum#withComplexities(ComplexityEntry[])} with {@code
   * ComplexityEntry[]}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableComplexityWidgetDatum#withComplexities(ComplexityEntry[])}
   */
  @Test
  @DisplayName(
      "Test withComplexities(ComplexityEntry[]) with 'ComplexityEntry[]'; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityWidgetDatum ImmutableComplexityWidgetDatum.withComplexities(ComplexityEntry[])"
  })
  void testWithComplexitiesWithComplexityEntry_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    ImmutableComplexityEntry.Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);

    // Act
    ImmutableComplexityWidgetDatum actualWithComplexitiesResult =
        immutableComplexityWidgetDatum.withComplexities(
            complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build());

    // Assert
    assertEquals("42", actualWithComplexitiesResult.cellExternalId());
    assertEquals(1, actualWithComplexitiesResult.complexities().size());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("2.3");
    assertEquals(expectedAverageComplexityResult, actualWithComplexitiesResult.averageComplexity());
    BigDecimal expectedTotalComplexityResult = new BigDecimal("2.3");
    assertEquals(expectedTotalComplexityResult, actualWithComplexitiesResult.totalComplexity());
  }
}
