package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexityWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllComplexities(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllComplexities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllComplexities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllComplexities(Iterable)"})
  void testBuilderAddAllComplexities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllComplexities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addComplexities(ComplexityEntry)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableComplexityEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addComplexities(ComplexityEntry)}
   */
  @Test
  @DisplayName("Test Builder addComplexities(ComplexityEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addComplexities(ComplexityEntry)"})
  void testBuilderAddComplexitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addComplexities(new ImmutableComplexityEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#addComplexities(ComplexityEntry[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableComplexityEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addComplexities(ComplexityEntry[])}
   */
  @Test
  @DisplayName("Test Builder addComplexities(ComplexityEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addComplexities(ComplexityEntry[])"})
  void testBuilderAddComplexitiesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addComplexities(new ImmutableComplexityEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder cellExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId() {
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#complexities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder complexities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.complexities(Iterable)"})
  void testBuilderComplexities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableComplexityEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityWidgetDatum) with 'ComplexityWidgetDatum'; given HashSet() add Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityWidgetDatum)"})
  void testBuilderFromWithComplexityWidgetDatum_givenHashSetAddJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    HashSet<ComplexityEntry> complexityEntrySet = new HashSet<>();
    complexityEntrySet.add(new ImmutableComplexityEntry.Json());
    ComplexityWidgetDatum instance = mock(ComplexityWidgetDatum.class);
    when(instance.complexities()).thenReturn(complexityEntrySet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).complexities();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityWidgetDatum)} with {@code ComplexityWidgetDatum}.
   * <ul>
   *   <li>Then return build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityWidgetDatum) with 'ComplexityWidgetDatum'; then return build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityWidgetDatum)"})
  void testBuilderFromWithComplexityWidgetDatum_thenReturnBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();
    ComplexityWidgetDatum instance = mock(ComplexityWidgetDatum.class);
    when(instance.complexities()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).complexities();
    ImmutableComplexityWidgetDatum buildResult = actualFromResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals("42", builderResult.build().cellExternalId());
    assertTrue(buildResult.complexities().isEmpty());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("0");
    BigDecimal averageComplexityResult = buildResult.averageComplexity();
    assertEquals(expectedAverageComplexityResult, averageComplexityResult);
    assertSame(averageComplexityResult, buildResult.totalComplexity());
  }

  /**
   * Test Builder {@link Builder#from(ComplexityWidgetDatum)} with {@code ComplexityWidgetDatum}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityWidgetDatum) with 'ComplexityWidgetDatum'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityWidgetDatum)"})
  void testBuilderFromWithComplexityWidgetDatum_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableComplexityWidgetDatum.builder();
    ComplexityWidgetDatum instance = mock(ComplexityWidgetDatum.class);
    when(instance.complexities()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellExternalId();
    verify(instance).complexities();
  }

  /**
   * Test Json {@link Json#averageComplexity()}.
   * <p>
   * Method under test: {@link Json#averageComplexity()}
   */
  @Test
  @DisplayName("Test Json averageComplexity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.averageComplexity()"})
  void testJsonAverageComplexity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).averageComplexity());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   * <p>
   * Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cellExternalId());
  }

  /**
   * Test Json {@link Json#complexities()}.
   * <p>
   * Method under test: {@link Json#complexities()}
   */
  @Test
  @DisplayName("Test Json complexities()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.complexities()"})
  void testJsonComplexities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).complexities());
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
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.complexities.isEmpty());
  }

  /**
   * Test Json {@link Json#totalComplexity()}.
   * <p>
   * Method under test: {@link Json#totalComplexity()}
   */
  @Test
  @DisplayName("Test Json totalComplexity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.totalComplexity()"})
  void testJsonTotalComplexity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).totalComplexity());
  }
}
