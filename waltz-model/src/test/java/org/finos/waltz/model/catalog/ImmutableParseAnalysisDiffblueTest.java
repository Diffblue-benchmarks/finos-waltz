package org.finos.waltz.model.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableParseAnalysisDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableParseAnalysis.Builder#addAllFieldCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllFieldCounts() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFieldCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableParseAnalysis.Builder#addAllFieldCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllFieldCounts2() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(3);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFieldCounts(elements));
  }

  /**
   * Method under test: {@link ImmutableParseAnalysis.Builder#addFieldCounts(int)}
   */
  @Test
  void testBuilderAddFieldCounts() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addFieldCounts(3));
  }

  /**
   * Method under test:
   * {@link ImmutableParseAnalysis.Builder#addFieldCounts(int[])}
   */
  @Test
  void testBuilderAddFieldCounts2() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addFieldCounts(3, 2, 3, 2));
  }

  /**
   * Method under test: {@link ImmutableParseAnalysis.Builder#delimiterChar(char)}
   */
  @Test
  void testBuilderDelimiterChar() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.delimiterChar('A'));
  }

  /**
   * Method under test:
   * {@link ImmutableParseAnalysis.Builder#fieldCounts(Iterable)}
   */
  @Test
  void testBuilderFieldCounts() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fieldCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableParseAnalysis.Builder#fieldCounts(Iterable)}
   */
  @Test
  void testBuilderFieldCounts2() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(3);

    // Act and Assert
    assertSame(builderResult, builderResult.fieldCounts(elements));
  }

  /**
   * Method under test: {@link ImmutableParseAnalysis.Builder#from(ParseAnalysis)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();
    ParseAnalysis instance = mock(ParseAnalysis.class);
    when(instance.delimiterChar()).thenReturn('A');
    when(instance.quoteChar()).thenReturn('A');
    when(instance.fieldCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableParseAnalysis.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).delimiterChar();
    verify(instance).fieldCounts();
    verify(instance).quoteChar();
    ImmutableParseAnalysis buildResult = builderResult.build();
    assertEquals('A', buildResult.delimiterChar());
    assertEquals('A', buildResult.quoteChar());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableParseAnalysis.Builder#from(ParseAnalysis)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    ParseAnalysis instance = mock(ParseAnalysis.class);
    when(instance.delimiterChar()).thenReturn('A');
    when(instance.quoteChar()).thenReturn('A');
    when(instance.fieldCounts()).thenReturn(integerList);

    // Act
    ImmutableParseAnalysis.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).delimiterChar();
    verify(instance).fieldCounts();
    verify(instance).quoteChar();
    ImmutableParseAnalysis buildResult = builderResult.build();
    assertEquals('A', buildResult.delimiterChar());
    assertEquals('A', buildResult.quoteChar());
    List<Integer> fieldCountsResult = buildResult.fieldCounts();
    assertEquals(1, fieldCountsResult.size());
    assertEquals(2, fieldCountsResult.get(0).intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableParseAnalysis.Builder#from(ParseAnalysis)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();
    ParseAnalysis instance = mock(ParseAnalysis.class);
    when(instance.quoteChar()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).quoteChar();
  }

  /**
   * Method under test: {@link ImmutableParseAnalysis.Builder#quoteChar(char)}
   */
  @Test
  void testBuilderQuoteChar() {
    // Arrange
    ImmutableParseAnalysis.Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.quoteChar('A'));
  }

  /**
   * Method under test: {@link ImmutableParseAnalysis#copyOf(ParseAnalysis)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ParseAnalysis instance = mock(ParseAnalysis.class);
    when(instance.delimiterChar()).thenReturn('A');
    when(instance.quoteChar()).thenReturn('A');
    when(instance.fieldCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableParseAnalysis actualCopyOfResult = ImmutableParseAnalysis.copyOf(instance);

    // Assert
    verify(instance).delimiterChar();
    verify(instance).fieldCounts();
    verify(instance).quoteChar();
    assertEquals('A', actualCopyOfResult.delimiterChar());
    assertEquals('A', actualCopyOfResult.quoteChar());
    assertTrue(actualCopyOfResult.fieldCounts().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableParseAnalysis#copyOf(ParseAnalysis)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    ParseAnalysis instance = mock(ParseAnalysis.class);
    when(instance.delimiterChar()).thenReturn('A');
    when(instance.quoteChar()).thenReturn('A');
    when(instance.fieldCounts()).thenReturn(integerList);

    // Act
    ImmutableParseAnalysis actualCopyOfResult = ImmutableParseAnalysis.copyOf(instance);

    // Assert
    verify(instance).delimiterChar();
    verify(instance).fieldCounts();
    verify(instance).quoteChar();
    assertEquals('A', actualCopyOfResult.delimiterChar());
    assertEquals('A', actualCopyOfResult.quoteChar());
    List<Integer> fieldCountsResult = actualCopyOfResult.fieldCounts();
    assertEquals(1, fieldCountsResult.size());
    assertEquals(2, fieldCountsResult.get(0).intValue());
  }

  /**
   * Method under test: {@link ImmutableParseAnalysis#copyOf(ParseAnalysis)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(3);
    integerList.add(2);
    ParseAnalysis instance = mock(ParseAnalysis.class);
    when(instance.delimiterChar()).thenReturn('A');
    when(instance.quoteChar()).thenReturn('A');
    when(instance.fieldCounts()).thenReturn(integerList);

    // Act
    ImmutableParseAnalysis actualCopyOfResult = ImmutableParseAnalysis.copyOf(instance);

    // Assert
    verify(instance).delimiterChar();
    verify(instance).fieldCounts();
    verify(instance).quoteChar();
    assertEquals('A', actualCopyOfResult.delimiterChar());
    assertEquals('A', actualCopyOfResult.quoteChar());
    assertEquals(integerList, actualCopyOfResult.fieldCounts());
  }
}
