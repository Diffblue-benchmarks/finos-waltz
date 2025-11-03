package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
   * <p>
   * Method under test: {@link BatchProcessingCollector#supplier()}
   */
  @Test
  @DisplayName("Test supplier()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.function.Supplier BatchProcessingCollector.supplier()"})
  void testSupplier() {
    // Arrange
    BatchProcessingCollector<Object> batchProcessingCollector = new BatchProcessingCollector<>(3, mock(Consumer.class));

    // Act and Assert
    assertTrue(batchProcessingCollector.supplier().get().isEmpty());
  }

  /**
   * Test {@link BatchProcessingCollector#accumulator()}.
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchProcessingCollector#accumulator()}
   */
  @Test
  @DisplayName("Test accumulator(); given Consumer accept(Object) does nothing; then ArrayList() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BiConsumer BatchProcessingCollector.accumulator()"})
  void testAccumulator_givenConsumerAcceptDoesNothing_thenArrayListEmpty() {
    // Arrange
    Consumer<List<Object>> batchProcessor = mock(Consumer.class);
    doNothing().when(batchProcessor).accept(Mockito.<List<Object>>any());
    BatchProcessingCollector<Object> batchProcessingCollector = new BatchProcessingCollector<>(1, batchProcessor);

    // Act
    BiConsumer<List<Object>, Object> actualAccumulatorResult = batchProcessingCollector.accumulator();
    ArrayList<Object> objectList = new ArrayList<>();
    actualAccumulatorResult.accept(objectList, "42");

    // Assert that nothing has changed
    verify(batchProcessor).accept(isA(List.class));
    assertTrue(objectList.isEmpty());
  }

  /**
   * Test {@link BatchProcessingCollector#accumulator()}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BatchProcessingCollector#accumulator()}
   */
  @Test
  @DisplayName("Test accumulator(); then ArrayList() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BiConsumer BatchProcessingCollector.accumulator()"})
  void testAccumulator_thenArrayListSizeIsOne() {
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
   * Test {@link BatchProcessingCollector#combiner()}.
   * <p>
   * Method under test: {@link BatchProcessingCollector#combiner()}
   */
  @Test
  @DisplayName("Test combiner()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BinaryOperator BatchProcessingCollector.combiner()"})
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
   * Test {@link BatchProcessingCollector#finisher()}.
   * <p>
   * Method under test: {@link BatchProcessingCollector#finisher()}
   */
  @Test
  @DisplayName("Test finisher()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Function BatchProcessingCollector.finisher()"})
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
   * Test {@link BatchProcessingCollector#characteristics()}.
   * <p>
   * Method under test: {@link BatchProcessingCollector#characteristics()}
   */
  @Test
  @DisplayName("Test characteristics()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set BatchProcessingCollector.characteristics()"})
  void testCharacteristics() {
    // Arrange
    BatchProcessingCollector<Object> batchProcessingCollector = new BatchProcessingCollector<>(3, mock(Consumer.class));

    // Act and Assert
    assertTrue(batchProcessingCollector.characteristics().isEmpty());
  }
}
