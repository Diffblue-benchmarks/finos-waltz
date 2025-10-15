package org.finos.waltz.model.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add three.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllFieldCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllFieldCounts(Iterable); given three; when LinkedHashSet() add three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllFieldCounts(Iterable)"})
  void testBuilderAddAllFieldCounts_givenThree_whenLinkedHashSetAddThree() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(3);

    // Act
    Builder actualAddAllFieldCountsResult = builderResult.addAllFieldCounts(elements);

    // Assert
    assertSame(builderResult, actualAddAllFieldCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAllFieldCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllFieldCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFieldCounts(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllFieldCounts(Iterable)"})
  void testBuilderAddAllFieldCounts_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act
    Builder actualAddAllFieldCountsResult = builderResult.addAllFieldCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllFieldCountsResult);
  }

  /**
   * Test Builder {@link Builder#addFieldCounts(int)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addFieldCounts(int)}
   */
  @Test
  @DisplayName("Test Builder addFieldCounts(int) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFieldCounts(int)"})
  void testBuilderAddFieldCountsWithElement() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act
    Builder actualAddFieldCountsResult = builderResult.addFieldCounts(3);

    // Assert
    assertSame(builderResult, actualAddFieldCountsResult);
  }

  /**
   * Test Builder {@link Builder#addFieldCounts(int[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addFieldCounts(int[])}
   */
  @Test
  @DisplayName("Test Builder addFieldCounts(int[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFieldCounts(int[])"})
  void testBuilderAddFieldCountsWithElements() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act
    Builder actualAddFieldCountsResult = builderResult.addFieldCounts(3, 2, 3, 2);

    // Assert
    assertSame(builderResult, actualAddFieldCountsResult);
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
  @MethodsUnderTest({"ImmutableParseAnalysis Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableParseAnalysis actualImmutableParseAnalysis =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();

    // Assert
    assertEquals('A', actualImmutableParseAnalysis.delimiterChar());
    assertEquals('A', actualImmutableParseAnalysis.quoteChar());
    assertTrue(actualImmutableParseAnalysis.fieldCounts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#delimiterChar(char)}.
   *
   * <p>Method under test: {@link Builder#delimiterChar(char)}
   */
  @Test
  @DisplayName("Test Builder delimiterChar(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.delimiterChar(char)"})
  void testBuilderDelimiterChar() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act
    Builder actualDelimiterCharResult = builderResult.delimiterChar('A');

    // Assert
    assertSame(builderResult, actualDelimiterCharResult);
  }

  /**
   * Test Builder {@link Builder#fieldCounts(Iterable)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add three.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fieldCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder fieldCounts(Iterable); given three; when LinkedHashSet() add three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fieldCounts(Iterable)"})
  void testBuilderFieldCounts_givenThree_whenLinkedHashSetAddThree() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(3);

    // Act
    Builder actualFieldCountsResult = builderResult.fieldCounts(elements);

    // Assert
    assertSame(builderResult, actualFieldCountsResult);
  }

  /**
   * Test Builder {@link Builder#fieldCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fieldCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder fieldCounts(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fieldCounts(Iterable)"})
  void testBuilderFieldCounts_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act
    Builder actualFieldCountsResult = builderResult.fieldCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualFieldCountsResult);
  }

  /**
   * Test Builder {@link Builder#from(ParseAnalysis)}.
   *
   * <ul>
   *   <li>Then builder build is builder delimiterChar {@code A} quoteChar {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParseAnalysis)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ParseAnalysis); then builder build is builder delimiterChar 'A' quoteChar 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParseAnalysis)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderDelimiterCharAQuoteCharABuild() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    Builder builderResult2 = ImmutableParseAnalysis.builder();
    builderResult2.addFieldCounts(3);
    ImmutableParseAnalysis instance = builderResult2.delimiterChar('A').quoteChar('A').build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableParseAnalysis actualImmutableParseAnalysis = builderResult.build();
    assertEquals(instance, actualImmutableParseAnalysis);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParseAnalysis)}.
   *
   * <ul>
   *   <li>Then return build is builder delimiterChar {@code A} quoteChar {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParseAnalysis)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ParseAnalysis); then return build is builder delimiterChar 'A' quoteChar 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParseAnalysis)"})
  void testBuilderFrom_thenReturnBuildIsBuilderDelimiterCharAQuoteCharABuild() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();
    ImmutableParseAnalysis instance =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();

    // Act and Assert
    ImmutableParseAnalysis actualImmutableParseAnalysis = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableParseAnalysis);
  }

  /**
   * Test Builder {@link Builder#quoteChar(char)}.
   *
   * <p>Method under test: {@link Builder#quoteChar(char)}
   */
  @Test
  @DisplayName("Test Builder quoteChar(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.quoteChar(char)"})
  void testBuilderQuoteChar() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();

    // Act
    Builder actualQuoteCharResult = builderResult.quoteChar('A');

    // Assert
    assertSame(builderResult, actualQuoteCharResult);
  }

  /**
   * Test {@link ImmutableParseAnalysis#copyOf(ParseAnalysis)}.
   *
   * <ul>
   *   <li>When builder delimiterChar {@code A} quoteChar {@code A} build.
   *   <li>Then return delimiterChar is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#copyOf(ParseAnalysis)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ParseAnalysis); when builder delimiterChar 'A' quoteChar 'A' build; then return delimiterChar is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableParseAnalysis ImmutableParseAnalysis.copyOf(ParseAnalysis)"})
  void testCopyOf_whenBuilderDelimiterCharAQuoteCharABuild_thenReturnDelimiterCharIsA() {
    // Arrange
    ImmutableParseAnalysis instance =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();

    // Act
    ImmutableParseAnalysis actualCopyOfResult = ImmutableParseAnalysis.copyOf(instance);

    // Assert
    assertEquals('A', actualCopyOfResult.delimiterChar());
    assertEquals('A', actualCopyOfResult.quoteChar());
    assertTrue(actualCopyOfResult.fieldCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableParseAnalysis#equals(Object)}, and {@link
   * ImmutableParseAnalysis#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableParseAnalysis#equals(Object)}
   *   <li>{@link ImmutableParseAnalysis#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableParseAnalysis.equals(Object)",
    "int ImmutableParseAnalysis.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableParseAnalysis immutableParseAnalysis =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();
    ImmutableParseAnalysis immutableParseAnalysis2 =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();

    // Act and Assert
    assertEquals(immutableParseAnalysis, immutableParseAnalysis2);
    assertEquals(immutableParseAnalysis.hashCode(), immutableParseAnalysis2.hashCode());
  }

  /**
   * Test {@link ImmutableParseAnalysis#equals(Object)}, and {@link
   * ImmutableParseAnalysis#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableParseAnalysis#equals(Object)}
   *   <li>{@link ImmutableParseAnalysis#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableParseAnalysis.equals(Object)",
    "int ImmutableParseAnalysis.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableParseAnalysis immutableParseAnalysis =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();

    // Act and Assert
    assertEquals(immutableParseAnalysis, immutableParseAnalysis);
    int expectedHashCodeResult = immutableParseAnalysis.hashCode();
    assertEquals(expectedHashCodeResult, immutableParseAnalysis.hashCode());
  }

  /**
   * Test {@link ImmutableParseAnalysis#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableParseAnalysis.equals(Object)",
    "int ImmutableParseAnalysis.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableParseAnalysis.builder();
    builderResult.addFieldCounts(3);
    ImmutableParseAnalysis immutableParseAnalysis =
        builderResult.delimiterChar('A').quoteChar('A').build();

    // Act and Assert
    assertNotEquals(
        immutableParseAnalysis,
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build());
  }

  /**
   * Test {@link ImmutableParseAnalysis#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableParseAnalysis.equals(Object)",
    "int ImmutableParseAnalysis.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableParseAnalysis immutableParseAnalysis =
        ImmutableParseAnalysis.builder().delimiterChar('\u0001').quoteChar('A').build();

    // Act and Assert
    assertNotEquals(
        immutableParseAnalysis,
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build());
  }

  /**
   * Test {@link ImmutableParseAnalysis#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableParseAnalysis.equals(Object)",
    "int ImmutableParseAnalysis.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableParseAnalysis immutableParseAnalysis =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('\u0001').build();

    // Act and Assert
    assertNotEquals(
        immutableParseAnalysis,
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build());
  }

  /**
   * Test {@link ImmutableParseAnalysis#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableParseAnalysis.equals(Object)",
    "int ImmutableParseAnalysis.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build(), null);
  }

  /**
   * Test {@link ImmutableParseAnalysis#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableParseAnalysis.equals(Object)",
    "int ImmutableParseAnalysis.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build(),
        "Different type to ImmutableParseAnalysis");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableParseAnalysis#toString()}
   *   <li>{@link ImmutableParseAnalysis#delimiterChar()}
   *   <li>{@link ImmutableParseAnalysis#fieldCounts()}
   *   <li>{@link ImmutableParseAnalysis#quoteChar()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "char ImmutableParseAnalysis.delimiterChar()",
    "List ImmutableParseAnalysis.fieldCounts()",
    "char ImmutableParseAnalysis.quoteChar()",
    "String ImmutableParseAnalysis.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableParseAnalysis immutableParseAnalysis =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();

    // Act
    String actualToStringResult = immutableParseAnalysis.toString();
    char actualDelimiterCharResult = immutableParseAnalysis.delimiterChar();
    List<Integer> actualFieldCountsResult = immutableParseAnalysis.fieldCounts();

    // Assert
    assertEquals(
        "ParseAnalysis{quoteChar=A, delimiterChar=A, fieldCounts=[]}", actualToStringResult);
    assertEquals('A', actualDelimiterCharResult);
    assertEquals('A', immutableParseAnalysis.quoteChar());
    assertTrue(actualFieldCountsResult.isEmpty());
  }

  /**
   * Test {@link ImmutableParseAnalysis#withDelimiterChar(char)}.
   *
   * <ul>
   *   <li>Then return builder delimiterChar {@code A} quoteChar {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#withDelimiterChar(char)}
   */
  @Test
  @DisplayName(
      "Test withDelimiterChar(char); then return builder delimiterChar 'A' quoteChar 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableParseAnalysis ImmutableParseAnalysis.withDelimiterChar(char)"})
  void testWithDelimiterChar_thenReturnBuilderDelimiterCharAQuoteCharABuild() {
    // Arrange
    ImmutableParseAnalysis immutableParseAnalysis =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();

    // Act
    ImmutableParseAnalysis actualWithDelimiterCharResult =
        immutableParseAnalysis.withDelimiterChar('A');

    // Assert
    assertSame(immutableParseAnalysis, actualWithDelimiterCharResult);
  }

  /**
   * Test {@link ImmutableParseAnalysis#withDelimiterChar(char)}.
   *
   * <ul>
   *   <li>Then return delimiterChar is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#withDelimiterChar(char)}
   */
  @Test
  @DisplayName("Test withDelimiterChar(char); then return delimiterChar is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableParseAnalysis ImmutableParseAnalysis.withDelimiterChar(char)"})
  void testWithDelimiterChar_thenReturnDelimiterCharIsA() {
    // Arrange and Act
    ImmutableParseAnalysis actualWithDelimiterCharResult =
        ImmutableParseAnalysis.builder()
            .delimiterChar('\u0000')
            .quoteChar('A')
            .build()
            .withDelimiterChar('A');

    // Assert
    assertEquals('A', actualWithDelimiterCharResult.delimiterChar());
    assertEquals('A', actualWithDelimiterCharResult.quoteChar());
    assertTrue(actualWithDelimiterCharResult.fieldCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableParseAnalysis#withFieldCounts(int[])} with {@code int[]}.
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#withFieldCounts(int[])}
   */
  @Test
  @DisplayName("Test withFieldCounts(int[]) with 'int[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableParseAnalysis ImmutableParseAnalysis.withFieldCounts(int[])"})
  void testWithFieldCountsWithInt() {
    // Arrange and Act
    ImmutableParseAnalysis actualWithFieldCountsResult =
        ImmutableParseAnalysis.builder()
            .delimiterChar('A')
            .quoteChar('A')
            .build()
            .withFieldCounts(3, 1, 3, 1);

    // Assert
    assertEquals('A', actualWithFieldCountsResult.delimiterChar());
    assertEquals('A', actualWithFieldCountsResult.quoteChar());
    List<Integer> fieldCountsResult = actualWithFieldCountsResult.fieldCounts();
    assertEquals(4, fieldCountsResult.size());
    assertEquals(1, fieldCountsResult.get(1).intValue());
    assertEquals(1, fieldCountsResult.get(3).intValue());
    assertEquals(3, fieldCountsResult.get(0).intValue());
    assertEquals(3, fieldCountsResult.get(2).intValue());
  }

  /**
   * Test {@link ImmutableParseAnalysis#withFieldCounts(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return delimiterChar is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#withFieldCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withFieldCounts(Iterable) with 'Iterable'; given three; then return delimiterChar is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableParseAnalysis ImmutableParseAnalysis.withFieldCounts(Iterable)"})
  void testWithFieldCountsWithIterable_givenThree_thenReturnDelimiterCharIsA() {
    // Arrange
    ImmutableParseAnalysis immutableParseAnalysis =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(3);

    // Act
    ImmutableParseAnalysis actualWithFieldCountsResult =
        immutableParseAnalysis.withFieldCounts(elements);

    // Assert
    assertEquals('A', actualWithFieldCountsResult.delimiterChar());
    assertEquals('A', actualWithFieldCountsResult.quoteChar());
    List<Integer> fieldCountsResult = actualWithFieldCountsResult.fieldCounts();
    assertEquals(1, fieldCountsResult.size());
    assertEquals(3, fieldCountsResult.get(0).intValue());
  }

  /**
   * Test {@link ImmutableParseAnalysis#withQuoteChar(char)}.
   *
   * <ul>
   *   <li>Then return builder delimiterChar {@code A} quoteChar {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#withQuoteChar(char)}
   */
  @Test
  @DisplayName(
      "Test withQuoteChar(char); then return builder delimiterChar 'A' quoteChar 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableParseAnalysis ImmutableParseAnalysis.withQuoteChar(char)"})
  void testWithQuoteChar_thenReturnBuilderDelimiterCharAQuoteCharABuild() {
    // Arrange
    ImmutableParseAnalysis immutableParseAnalysis =
        ImmutableParseAnalysis.builder().delimiterChar('A').quoteChar('A').build();

    // Act
    ImmutableParseAnalysis actualWithQuoteCharResult = immutableParseAnalysis.withQuoteChar('A');

    // Assert
    assertSame(immutableParseAnalysis, actualWithQuoteCharResult);
  }

  /**
   * Test {@link ImmutableParseAnalysis#withQuoteChar(char)}.
   *
   * <ul>
   *   <li>Then return delimiterChar is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableParseAnalysis#withQuoteChar(char)}
   */
  @Test
  @DisplayName("Test withQuoteChar(char); then return delimiterChar is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableParseAnalysis ImmutableParseAnalysis.withQuoteChar(char)"})
  void testWithQuoteChar_thenReturnDelimiterCharIsA() {
    // Arrange and Act
    ImmutableParseAnalysis actualWithQuoteCharResult =
        ImmutableParseAnalysis.builder()
            .delimiterChar('A')
            .quoteChar('\u0000')
            .build()
            .withQuoteChar('A');

    // Assert
    assertEquals('A', actualWithQuoteCharResult.delimiterChar());
    assertEquals('A', actualWithQuoteCharResult.quoteChar());
    assertTrue(actualWithQuoteCharResult.fieldCounts().isEmpty());
  }
}
