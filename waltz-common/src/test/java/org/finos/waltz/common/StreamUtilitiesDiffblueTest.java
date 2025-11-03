package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.finos.waltz.common.StreamUtilities.Siphon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StreamUtilitiesDiffblueTest {
  /**
   * Test {@link StreamUtilities#batchProcessingCollector(int, Consumer)}.
   * <p>
   * Method under test: {@link StreamUtilities#batchProcessingCollector(int, Consumer)}
   */
  @Test
  @DisplayName("Test batchProcessingCollector(int, Consumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collector StreamUtilities.batchProcessingCollector(int, Consumer)"})
  void testBatchProcessingCollector() {
    // Arrange and Act
    Collector<Object, List<Object>, Integer> actualBatchProcessingCollectorResult = StreamUtilities
        .<Object>batchProcessingCollector(3, mock(Consumer.class));

    // Assert
    assertTrue(actualBatchProcessingCollectorResult instanceof BatchProcessingCollector);
  }

  /**
   * Test {@link StreamUtilities#concat(Stream[])} with {@code streams}.
   * <p>
   * Method under test: {@link StreamUtilities#concat(Stream[])}
   */
  @Test
  @DisplayName("Test concat(Stream[]) with 'streams'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream StreamUtilities.concat(Stream[])"})
  void testConcatWithStreams() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();

    // Act
    Stream<Object> actualConcatResult = StreamUtilities.concat(streamResult);

    // Assert
    assertTrue(actualConcatResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtilities#concat(Collection[])} with {@code values}.
   * <p>
   * Method under test: {@link StreamUtilities#concat(Collection[])}
   */
  @Test
  @DisplayName("Test concat(Collection[]) with 'values'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream StreamUtilities.concat(Collection[])"})
  void testConcatWithValues() {
    // Arrange and Act
    Stream<Object> actualConcatResult = StreamUtilities.concat(new ArrayList<>());

    // Assert
    assertTrue(actualConcatResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test Siphon getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Siphon#Siphon(Predicate)}
   *   <li>{@link Siphon#getResults()}
   * </ul>
   */
  @Test
  @DisplayName("Test Siphon getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Siphon.<init>(Predicate)", "List Siphon.getResults()"})
  void testSiphonGettersAndSetters() {
    // Arrange and Act
    Siphon<Object> actualSiphon = new Siphon<>(mock(Predicate.class));

    // Assert
    assertTrue(actualSiphon.getResults().isEmpty());
  }

  /**
   * Test Siphon {@link Siphon#hasResults()}.
   * <p>
   * Method under test: {@link Siphon#hasResults()}
   */
  @Test
  @DisplayName("Test Siphon hasResults()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Siphon.hasResults()"})
  void testSiphonHasResults() {
    // Arrange
    Siphon<Object> mkSiphonResult = StreamUtilities.mkSiphon(mock(RangeBand.class)::equals);

    // Act and Assert
    assertFalse(mkSiphonResult.hasResults());
  }

  /**
   * Test Siphon {@link Siphon#stream()}.
   * <p>
   * Method under test: {@link Siphon#stream()}
   */
  @Test
  @DisplayName("Test Siphon stream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream Siphon.stream()"})
  void testSiphonStream() {
    // Arrange
    Siphon<Object> mkSiphonResult = StreamUtilities.mkSiphon(mock(RangeBand.class)::equals);

    // Act
    Stream<Object> actualStreamResult = mkSiphonResult.stream();

    // Assert
    assertTrue(actualStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test Siphon {@link Siphon#test(Object)}.
   * <p>
   * Method under test: {@link Siphon#test(Object)}
   */
  @Test
  @DisplayName("Test Siphon test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Siphon.test(Object)"})
  void testSiphonTest() {
    // Arrange
    Predicate<Object> pred = mock(Predicate.class);
    when(pred.test(Mockito.<Object>any())).thenReturn(true);
    Siphon<Object> siphon = new Siphon<>(pred);

    // Act
    boolean actualTestResult = siphon.test("42");

    // Assert
    verify(pred).test(isA(Object.class));
    Stream<Object> streamResult = siphon.stream();
    List<Object> collectResult = streamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("42", collectResult.get(0));
    List<Object> results = siphon.getResults();
    assertEquals(1, results.size());
    assertEquals("42", results.get(0));
    assertFalse(actualTestResult);
    assertTrue(siphon.hasResults());
  }

  /**
   * Test Siphon {@link Siphon#test(Object)}.
   * <ul>
   *   <li>Given {@link RangeBand}.</li>
   *   <li>Then not mkSiphon hasResults.</li>
   * </ul>
   * <p>
   * Method under test: {@link Siphon#test(Object)}
   */
  @Test
  @DisplayName("Test Siphon test(Object); given RangeBand; then not mkSiphon hasResults")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Siphon.test(Object)"})
  void testSiphonTest_givenRangeBand_thenNotMkSiphonHasResults() {
    // Arrange
    Siphon<Object> mkSiphonResult = StreamUtilities.mkSiphon(mock(RangeBand.class)::equals);

    // Act
    boolean actualTestResult = mkSiphonResult.test("42");

    // Assert
    assertFalse(mkSiphonResult.hasResults());
    Stream<Object> streamResult = mkSiphonResult.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(mkSiphonResult.getResults().isEmpty());
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link StreamUtilities#tap()}.
   * <p>
   * Method under test: {@link StreamUtilities#tap()}
   */
  @Test
  @DisplayName("Test tap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Function StreamUtilities.tap()"})
  void testTap() {
    // Arrange and Act
    Function<Object, Object> actualTapResult = StreamUtilities.tap();

    // Assert
    assertEquals("42", actualTapResult.apply("42"));
  }

  /**
   * Test {@link StreamUtilities#tap(Consumer)} with {@code Consumer}.
   * <p>
   * Method under test: {@link StreamUtilities#tap(Consumer)}
   */
  @Test
  @DisplayName("Test tap(Consumer) with 'Consumer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Function StreamUtilities.tap(Consumer)"})
  void testTapWithConsumer() {
    // Arrange and Act
    Function<Object, Object> actualTapResult = StreamUtilities.tap(FunctionUtilities::discardResult);

    // Assert
    assertEquals("42", actualTapResult.apply("42"));
  }

  /**
   * Test {@link StreamUtilities#ofNullableArray(Object[])}.
   * <ul>
   *   <li>Then return limit five collect toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtilities#ofNullableArray(Object[])}
   */
  @Test
  @DisplayName("Test ofNullableArray(Object[]); then return limit five collect toList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream StreamUtilities.ofNullableArray(Object[])"})
  void testOfNullableArray_thenReturnLimitFiveCollectToListSizeIsOne() {
    // Arrange and Act
    Stream<Object> actualOfNullableArrayResult = StreamUtilities.ofNullableArray(new Object[]{"Arr"});

    // Assert
    List<Object> collectResult = actualOfNullableArrayResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("Arr", collectResult.get(0));
  }

  /**
   * Test {@link StreamUtilities#ofNullableArray(Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamUtilities#ofNullableArray(Object[])}
   */
  @Test
  @DisplayName("Test ofNullableArray(Object[]); when 'null'; then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream StreamUtilities.ofNullableArray(Object[])"})
  void testOfNullableArray_whenNull_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualOfNullableArrayResult = StreamUtilities.ofNullableArray(null);

    // Assert
    assertTrue(actualOfNullableArrayResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamUtilities#lines(String)}.
   * <p>
   * Method under test: {@link StreamUtilities#lines(String)}
   */
  @Test
  @DisplayName("Test lines(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream StreamUtilities.lines(String)"})
  void testLines() {
    // Arrange and Act
    Stream<String> actualLinesResult = StreamUtilities.lines("Multi Line Str");

    // Assert
    List<String> collectResult = actualLinesResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("Multi Line Str", collectResult.get(0));
  }

  /**
   * Test {@link StreamUtilities#mkSiphon(Predicate)}.
   * <p>
   * Method under test: {@link StreamUtilities#mkSiphon(Predicate)}
   */
  @Test
  @DisplayName("Test mkSiphon(Predicate)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Siphon StreamUtilities.mkSiphon(Predicate)"})
  void testMkSiphon() {
    // Arrange and Act
    Siphon<Object> actualMkSiphonResult = StreamUtilities.mkSiphon(mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualMkSiphonResult.hasResults());
    Stream<Object> streamResult = actualMkSiphonResult.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualMkSiphonResult.getResults().isEmpty());
  }
}
