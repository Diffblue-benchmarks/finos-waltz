package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class ImmutableComplexityWidgetDatumDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Builder#addAllComplexities(Iterable)}
   */
  @Test
  void testBuilderAddAllComplexities() {
    // Arrange
    ImmutableComplexityWidgetDatum.Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllComplexities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Builder#addComplexities(ComplexityEntry)}
   */
  @Test
  void testBuilderAddComplexities() {
    // Arrange
    ImmutableComplexityWidgetDatum.Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addComplexities(new ImmutableComplexityEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Builder#addComplexities(ComplexityEntry[])}
   */
  @Test
  void testBuilderAddComplexities2() {
    // Arrange
    ImmutableComplexityWidgetDatum.Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addComplexities(new ImmutableComplexityEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableComplexityWidgetDatum.Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act
    ImmutableComplexityWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Builder#complexities(Iterable)}
   */
  @Test
  void testBuilderComplexities() {
    // Arrange
    ImmutableComplexityWidgetDatum.Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Builder#from(CellExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableComplexityWidgetDatum.Builder builderResult = ImmutableComplexityWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableComplexityWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Builder#from(ComplexityWidgetDatum)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableComplexityWidgetDatum.Builder builderResult = ImmutableComplexityWidgetDatum.builder();
    ComplexityWidgetDatum instance = mock(ComplexityWidgetDatum.class);
    when(instance.complexities()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableComplexityWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).complexities();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Builder#from(ComplexityWidgetDatum)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableComplexityWidgetDatum.Builder builderResult = ImmutableComplexityWidgetDatum.builder();
    ComplexityWidgetDatum instance = mock(ComplexityWidgetDatum.class);
    when(instance.complexities()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellExternalId();
    verify(instance).complexities();
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Builder#from(ComplexityWidgetDatum)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableComplexityWidgetDatum.Builder builderResult = ImmutableComplexityWidgetDatum.builder();

    HashSet<ComplexityEntry> complexityEntrySet = new HashSet<>();
    complexityEntrySet.add(new ImmutableComplexityEntry.Json());
    ComplexityWidgetDatum instance = mock(ComplexityWidgetDatum.class);
    when(instance.complexities()).thenReturn(complexityEntrySet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableComplexityWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).complexities();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum#copyOf(ComplexityWidgetDatum)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ComplexityWidgetDatum instance = mock(ComplexityWidgetDatum.class);
    when(instance.complexities()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableComplexityWidgetDatum actualCopyOfResult = ImmutableComplexityWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).complexities();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.complexities().isEmpty());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("0");
    BigDecimal averageComplexityResult = actualCopyOfResult.averageComplexity();
    assertEquals(expectedAverageComplexityResult, averageComplexityResult);
    assertSame(averageComplexityResult, actualCopyOfResult.totalComplexity());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum#copyOf(ComplexityWidgetDatum)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ComplexityEntry complexityEntry = mock(ComplexityEntry.class);
    when(complexityEntry.complexityScore()).thenReturn(new BigDecimal("2.3"));

    HashSet<ComplexityEntry> complexityEntrySet = new HashSet<>();
    complexityEntrySet.add(complexityEntry);
    ComplexityWidgetDatum instance = mock(ComplexityWidgetDatum.class);
    when(instance.complexities()).thenReturn(complexityEntrySet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableComplexityWidgetDatum actualCopyOfResult = ImmutableComplexityWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(complexityEntry).complexityScore();
    verify(instance).complexities();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(1, actualCopyOfResult.complexities().size());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("2.3");
    assertEquals(expectedAverageComplexityResult, actualCopyOfResult.averageComplexity());
    BigDecimal expectedTotalComplexityResult = new BigDecimal("2.3");
    assertEquals(expectedTotalComplexityResult, actualCopyOfResult.totalComplexity());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum#fromJson(ImmutableComplexityWidgetDatum.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableComplexityWidgetDatum.Json json = new ImmutableComplexityWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setComplexities(null);

    // Act
    ImmutableComplexityWidgetDatum actualFromJsonResult = ImmutableComplexityWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.complexities().isEmpty());
    BigDecimal expectedAverageComplexityResult = new BigDecimal("0");
    BigDecimal averageComplexityResult = actualFromJsonResult.averageComplexity();
    assertEquals(expectedAverageComplexityResult, averageComplexityResult);
    assertSame(averageComplexityResult, actualFromJsonResult.totalComplexity());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Json#averageComplexity()}
   */
  @Test
  void testJsonAverageComplexity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableComplexityWidgetDatum.Json()).averageComplexity());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableComplexityWidgetDatum.Json()).cellExternalId());
  }

  /**
   * Method under test: {@link ImmutableComplexityWidgetDatum.Json#complexities()}
   */
  @Test
  void testJsonComplexities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityWidgetDatum.Json()).complexities());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableComplexityWidgetDatum.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableComplexityWidgetDatum.Json actualJson = new ImmutableComplexityWidgetDatum.Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.complexities.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityWidgetDatum.Json#totalComplexity()}
   */
  @Test
  void testJsonTotalComplexity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableComplexityWidgetDatum.Json()).totalComplexity());
  }
}
