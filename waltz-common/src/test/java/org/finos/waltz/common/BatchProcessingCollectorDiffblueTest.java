package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BatchProcessingCollectorDiffblueTest {
  /**
   * Test {@link BatchProcessingCollector#supplier()}.
   *
   * <p>Method under test: {@link BatchProcessingCollector#supplier()}
   */
  @Test
  @DisplayName("Test supplier()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.function.Supplier BatchProcessingCollector.supplier()"})
  void testSupplier() {
    // Arrange
    BatchProcessingCollector<Object> batchProcessingCollector =
        new BatchProcessingCollector<>(3, mock(Consumer.class));

    // Act and Assert
    assertTrue(batchProcessingCollector.supplier().get().isEmpty());
  }

  /**
   * Test {@link BatchProcessingCollector#accumulator()}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BatchProcessingCollector#accumulator()}
   */
  @Test
  @DisplayName(
      "Test accumulator(); given Consumer accept(Object) does nothing; then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BiConsumer BatchProcessingCollector.accumulator()"})
  void testAccumulator_givenConsumerAcceptDoesNothing_thenArrayListEmpty() {
    // Arrange
    Consumer<List<Object>> batchProcessor = mock(Consumer.class);
    doNothing().when(batchProcessor).accept(Mockito.<List<Object>>any());
    BatchProcessingCollector<Object> batchProcessingCollector =
        new BatchProcessingCollector<>(1, batchProcessor);

    // Act
    BiConsumer<List<Object>, Object> actualAccumulatorResult =
        batchProcessingCollector.accumulator();
    ArrayList<Object> objectList = new ArrayList<>();
    actualAccumulatorResult.accept(objectList, "42");

    // Assert that nothing has changed
    verify(batchProcessor).accept(isA(List.class));
    assertTrue(objectList.isEmpty());
  }

  /**
   * Test {@link BatchProcessingCollector#accumulator()}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link BatchProcessingCollector#accumulator()}
   */
  @Test
  @DisplayName("Test accumulator(); then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BiConsumer BatchProcessingCollector.accumulator()"})
  void testAccumulator_thenArrayListSizeIsOne() {
    // Arrange
    BatchProcessingCollector<Object> batchProcessingCollector =
        new BatchProcessingCollector<>(3, mock(Consumer.class));

    // Act
    BiConsumer<List<Object>, Object> actualAccumulatorResult =
        batchProcessingCollector.accumulator();
    ArrayList<Object> objectList = new ArrayList<>();
    actualAccumulatorResult.accept(objectList, "42");

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", objectList.get(0));
  }

  /**
   * Test {@link BatchProcessingCollector#combiner()}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BatchProcessingCollector#combiner()}
   */
  @Test
  @DisplayName(
      "Test combiner(); given Consumer accept(Object) does nothing; then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinaryOperator BatchProcessingCollector.combiner()"})
  void testCombiner_givenConsumerAcceptDoesNothing_thenArrayListEmpty() {
    // Arrange
    Consumer<List<Object>> batchProcessor = mock(Consumer.class);
    doNothing().when(batchProcessor).accept(Mockito.<List<Object>>any());
    BatchProcessingCollector<Object> batchProcessingCollector =
        new BatchProcessingCollector<>(3, batchProcessor);

    // Act
    BinaryOperator<List<Object>> actualCombinerResult = batchProcessingCollector.combiner();
    ArrayList<Object> objectList = new ArrayList<>();
    List<Object> actualApplyResult = actualCombinerResult.apply(objectList, new ArrayList<>());

    // Assert
    verify(batchProcessor, atLeast(1)).accept(isA(List.class));
    assertTrue(objectList.isEmpty());
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Test {@link BatchProcessingCollector#finisher()}.
   *
   * <ul>
   *   <li>Then return apply {@link ArrayList#ArrayList()} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link BatchProcessingCollector#finisher()}
   */
  @Test
  @DisplayName("Test finisher(); then return apply ArrayList() intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function BatchProcessingCollector.finisher()"})
  void testFinisher_thenReturnApplyArrayListIntValueIsZero() {
    // Arrange
    Consumer<List<Object>> batchProcessor = mock(Consumer.class);
    doNothing().when(batchProcessor).accept(Mockito.<List<Object>>any());
    BatchProcessingCollector<Object> batchProcessingCollector =
        new BatchProcessingCollector<>(3, batchProcessor);

    // Act
    Function<List<Object>, Integer> actualFinisherResult = batchProcessingCollector.finisher();
    ArrayList<Object> objectList = new ArrayList<>();
    Integer actualApplyResult = actualFinisherResult.apply(objectList);

    // Assert
    verify(batchProcessor).accept(isA(List.class));
    assertEquals(0, actualApplyResult.intValue());
    assertTrue(objectList.isEmpty());
  }

  /**
   * Test {@link BatchProcessingCollector#characteristics()}.
   *
   * <p>Method under test: {@link BatchProcessingCollector#characteristics()}
   */
  @Test
  @DisplayName("Test characteristics()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set BatchProcessingCollector.characteristics()"})
  void testCharacteristics() {
    // Arrange
    BatchProcessingCollector<Object> batchProcessingCollector =
        new BatchProcessingCollector<>(3, mock(Consumer.class));

    // Act and Assert
    assertTrue(batchProcessingCollector.characteristics().isEmpty());
  }
}
