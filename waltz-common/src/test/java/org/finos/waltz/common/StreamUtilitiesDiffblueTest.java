package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StreamUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link StreamUtilities#batchProcessingCollector(int, Consumer)}
   */
  @Test
  void testBatchProcessingCollector() {
    // Arrange and Act
    Collector<Object, List<Object>, Integer> actualBatchProcessingCollectorResult = StreamUtilities
        .<Object>batchProcessingCollector(3, mock(Consumer.class));

    // Assert
    assertTrue(actualBatchProcessingCollectorResult instanceof BatchProcessingCollector);
  }

  /**
   * Method under test: {@link StreamUtilities#concat(Collection[])}
   */
  @Test
  void testConcat() {
    // Arrange and Act
    Stream<Object> actualConcatResult = StreamUtilities.concat(new ArrayList<>());

    // Assert
    assertTrue(actualConcatResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link StreamUtilities#concat(Stream[])}
   */
  @Test
  void testConcat2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();

    // Act
    Stream<Object> actualConcatResult = StreamUtilities.concat(streamResult);

    // Assert
    assertTrue(actualConcatResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StreamUtilities.Siphon#Siphon(Predicate)}
   *   <li>{@link StreamUtilities.Siphon#getResults()}
   * </ul>
   */
  @Test
  void testSiphonGettersAndSetters() {
    // Arrange and Act
    StreamUtilities.Siphon<Object> actualSiphon = new StreamUtilities.Siphon<>(mock(Predicate.class));

    // Assert
    assertTrue(actualSiphon.getResults().isEmpty());
  }

  /**
   * Method under test: {@link StreamUtilities.Siphon#hasResults()}
   */
  @Test
  void testSiphonHasResults() {
    // Arrange
    StreamUtilities.Siphon<Object> mkSiphonResult = StreamUtilities.mkSiphon(mock(RangeBand.class)::equals);

    // Act and Assert
    assertFalse(mkSiphonResult.hasResults());
  }

  /**
   * Method under test: {@link StreamUtilities.Siphon#stream()}
   */
  @Test
  void testSiphonStream() {
    // Arrange
    StreamUtilities.Siphon<Object> mkSiphonResult = StreamUtilities.mkSiphon(mock(RangeBand.class)::equals);

    // Act
    Stream<Object> actualStreamResult = mkSiphonResult.stream();

    // Assert
    assertTrue(actualStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link StreamUtilities.Siphon#test(Object)}
   */
  @Test
  void testSiphonTest() {
    // Arrange
    StreamUtilities.Siphon<Object> mkSiphonResult = StreamUtilities.mkSiphon(mock(RangeBand.class)::equals);

    // Act and Assert
    assertTrue(mkSiphonResult.test("42"));
  }

  /**
   * Method under test: {@link StreamUtilities.Siphon#test(Object)}
   */
  @Test
  void testSiphonTest2() {
    // Arrange
    Predicate<Object> pred = mock(Predicate.class);
    when(pred.test(Mockito.<Object>any())).thenReturn(true);
    StreamUtilities.Siphon<Object> siphon = new StreamUtilities.Siphon<>(pred);

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
   * Method under test: {@link StreamUtilities#tap()}
   */
  @Test
  void testTap() {
    // Arrange and Act
    Function<Object, Object> actualTapResult = StreamUtilities.tap();

    // Assert
    assertEquals("42", actualTapResult.apply("42"));
  }

  /**
   * Method under test: {@link StreamUtilities#tap(Consumer)}
   */
  @Test
  void testTap2() {
    // Arrange and Act
    Function<Object, Object> actualTapResult = StreamUtilities.tap(FunctionUtilities::discardResult);

    // Assert
    assertEquals("42", actualTapResult.apply("42"));
  }

  /**
   * Method under test: {@link StreamUtilities#ofNullableArray(Object[])}
   */
  @Test
  void testOfNullableArray() {
    // Arrange and Act
    Stream<Object> actualOfNullableArrayResult = StreamUtilities.ofNullableArray(new Object[]{"Arr"});

    // Assert
    List<Object> collectResult = actualOfNullableArrayResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("Arr", collectResult.get(0));
  }

  /**
   * Method under test: {@link StreamUtilities#ofNullableArray(Object[])}
   */
  @Test
  void testOfNullableArray2() {
    // Arrange and Act
    Stream<Object> actualOfNullableArrayResult = StreamUtilities.ofNullableArray(null);

    // Assert
    assertTrue(actualOfNullableArrayResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link StreamUtilities#lines(String)}
   */
  @Test
  void testLines() {
    // Arrange and Act
    Stream<String> actualLinesResult = StreamUtilities.lines("Multi Line Str");

    // Assert
    List<String> collectResult = actualLinesResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("Multi Line Str", collectResult.get(0));
  }

  /**
   * Method under test: {@link StreamUtilities#mkSiphon(Predicate)}
   */
  @Test
  void testMkSiphon() {
    // Arrange and Act
    StreamUtilities.Siphon<Object> actualMkSiphonResult = StreamUtilities.mkSiphon(mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualMkSiphonResult.hasResults());
    Stream<Object> streamResult = actualMkSiphonResult.stream();
    assertTrue(streamResult.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualMkSiphonResult.getResults().isEmpty());
  }
}
