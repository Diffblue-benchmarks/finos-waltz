package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BatchProcessingCollectorDiffblueTest {
  /**
   * Method under test: {@link BatchProcessingCollector#supplier()}
   */
  @Test
  void testSupplier() {
    // Arrange
    BatchProcessingCollector<Object> batchProcessingCollector = new BatchProcessingCollector<>(3, mock(Consumer.class));

    // Act and Assert
    assertTrue(batchProcessingCollector.supplier().get().isEmpty());
  }

  /**
   * Method under test: {@link BatchProcessingCollector#accumulator()}
   */
  @Test
  void testAccumulator() {
    // Arrange
    BatchProcessingCollector<Object> batchProcessingCollector = new BatchProcessingCollector<>(3, mock(Consumer.class));

    // Act
    BiConsumer<List<Object>, Object> actualAccumulatorResult = batchProcessingCollector.accumulator();
    ArrayList<Object> objectList = new ArrayList<>();
    actualAccumulatorResult.accept(objectList, "42");

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", objectList.get(0));
  }

  /**
   * Method under test: {@link BatchProcessingCollector#accumulator()}
   */
  @Test
  void testAccumulator2() {
    // Arrange
    Consumer<List<Object>> batchProcessor = mock(Consumer.class);
    doNothing().when(batchProcessor).accept(Mockito.<List<Object>>any());
    BatchProcessingCollector<Object> batchProcessingCollector = new BatchProcessingCollector<>(1, batchProcessor);

    // Act
    BiConsumer<List<Object>, Object> actualAccumulatorResult = batchProcessingCollector.accumulator();
    ArrayList<Object> objectList = new ArrayList<>();
    actualAccumulatorResult.accept(objectList, "42");

    // Assert
    verify(batchProcessor).accept(isA(List.class));
    assertTrue(objectList.isEmpty());
  }

  /**
   * Method under test: {@link BatchProcessingCollector#combiner()}
   */
  @Test
  void testCombiner() {
    // Arrange
    Consumer<List<Object>> batchProcessor = mock(Consumer.class);
    doNothing().when(batchProcessor).accept(Mockito.<List<Object>>any());
    BatchProcessingCollector<Object> batchProcessingCollector = new BatchProcessingCollector<>(3, batchProcessor);

    // Act
    BinaryOperator<List<Object>> actualCombinerResult = batchProcessingCollector.combiner();
    ArrayList<Object> objectList = new ArrayList<>();
    List<Object> actualApplyResult = actualCombinerResult.apply(objectList, new ArrayList<>());

    // Assert
    verify(batchProcessor, atLeast(1)).accept(isA(List.class));
    assertTrue(actualApplyResult.isEmpty());
  }

  /**
   * Method under test: {@link BatchProcessingCollector#finisher()}
   */
  @Test
  void testFinisher() {
    // Arrange
    Consumer<List<Object>> batchProcessor = mock(Consumer.class);
    doNothing().when(batchProcessor).accept(Mockito.<List<Object>>any());
    BatchProcessingCollector<Object> batchProcessingCollector = new BatchProcessingCollector<>(3, batchProcessor);

    // Act
    Function<List<Object>, Integer> actualFinisherResult = batchProcessingCollector.finisher();
    Integer actualApplyResult = actualFinisherResult.apply(new ArrayList<>());

    // Assert
    verify(batchProcessor).accept(isA(List.class));
    assertEquals(0, actualApplyResult.intValue());
  }

  /**
   * Method under test: {@link BatchProcessingCollector#characteristics()}
   */
  @Test
  void testCharacteristics() {
    // Arrange
    BatchProcessingCollector<Object> batchProcessingCollector = new BatchProcessingCollector<>(3, mock(Consumer.class));

    // Act and Assert
    assertTrue(batchProcessingCollector.characteristics().isEmpty());
  }
}
