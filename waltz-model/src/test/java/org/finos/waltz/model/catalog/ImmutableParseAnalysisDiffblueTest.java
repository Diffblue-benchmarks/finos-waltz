package org.finos.waltz.model.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.finos.waltz.model.catalog.ImmutableParseAnalysis.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableParseAnalysisDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllFieldCounts(Iterable)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllFieldCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFieldCounts(Iterable); given three; when LinkedHashSet() add three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllFieldCounts(Iterable)"})
  void testBuilderAddAllFieldCounts_givenThree_whenLinkedHashSetAddThree() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(3);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFieldCounts(elements));
  }

  /**
   * Test Builder {@link Builder#addAllFieldCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllFieldCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFieldCounts(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllFieldCounts(Iterable)"})
  void testBuilderAddAllFieldCounts_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFieldCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addFieldCounts(int)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addFieldCounts(int)}
   */
  @Test
  @DisplayName("Test Builder addFieldCounts(int) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFieldCounts(int)"})
  void testBuilderAddFieldCountsWithElement() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addFieldCounts(3));
  }

  /**
   * Test Builder {@link Builder#addFieldCounts(int[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addFieldCounts(int[])}
   */
  @Test
  @DisplayName("Test Builder addFieldCounts(int[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFieldCounts(int[])"})
  void testBuilderAddFieldCountsWithElements() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addFieldCounts(3, 2, 3, 2));
  }

  /**
   * Test Builder {@link Builder#delimiterChar(char)}.
   * <p>
   * Method under test: {@link Builder#delimiterChar(char)}
   */
  @Test
  @DisplayName("Test Builder delimiterChar(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.delimiterChar(char)"})
  void testBuilderDelimiterChar() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.delimiterChar('A'));
  }

  /**
   * Test Builder {@link Builder#fieldCounts(Iterable)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#fieldCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder fieldCounts(Iterable); given three; when LinkedHashSet() add three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.fieldCounts(Iterable)"})
  void testBuilderFieldCounts_givenThree_whenLinkedHashSetAddThree() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(3);

    // Act and Assert
    assertSame(builderResult, builderResult.fieldCounts(elements));
  }

  /**
   * Test Builder {@link Builder#fieldCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#fieldCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder fieldCounts(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.fieldCounts(Iterable)"})
  void testBuilderFieldCounts_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fieldCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ParseAnalysis)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then builder build fieldCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParseAnalysis)}
   */
  @Test
  @DisplayName("Test Builder from(ParseAnalysis); given ArrayList() add two; then builder build fieldCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParseAnalysis)"})
  void testBuilderFrom_givenArrayListAddTwo_thenBuilderBuildFieldCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    ParseAnalysis instance = mock(ParseAnalysis.class);
    when(instance.delimiterChar()).thenReturn('A');
    when(instance.quoteChar()).thenReturn('A');
    when(instance.fieldCounts()).thenReturn(integerList);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ParseAnalysis)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build delimiterChar is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParseAnalysis)}
   */
  @Test
  @DisplayName("Test Builder from(ParseAnalysis); given ArrayList(); then builder build delimiterChar is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParseAnalysis)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildDelimiterCharIsA() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();
    ParseAnalysis instance = mock(ParseAnalysis.class);
    when(instance.delimiterChar()).thenReturn('A');
    when(instance.quoteChar()).thenReturn('A');
    when(instance.fieldCounts()).thenReturn(new ArrayList<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ParseAnalysis)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParseAnalysis)}
   */
  @Test
  @DisplayName("Test Builder from(ParseAnalysis); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParseAnalysis)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();
    ParseAnalysis instance = mock(ParseAnalysis.class);
    when(instance.quoteChar()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).quoteChar();
  }

  /**
   * Test Builder {@link Builder#quoteChar(char)}.
   * <p>
   * Method under test: {@link Builder#quoteChar(char)}
   */
  @Test
  @DisplayName("Test Builder quoteChar(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.quoteChar(char)"})
  void testBuilderQuoteChar() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.quoteChar('A'));
  }
}
