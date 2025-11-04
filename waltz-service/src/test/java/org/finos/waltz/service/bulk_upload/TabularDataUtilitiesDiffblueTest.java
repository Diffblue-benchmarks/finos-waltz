package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class TabularDataUtilitiesDiffblueTest {
  /**
   * Method under test: {@link TabularDataUtilities.Row#getHeaders()}
   */
  @Test
  void testRowGetHeaders() {
    // Arrange, Act and Assert
    assertTrue((new TabularDataUtilities.Row(null, new HashMap<>())).getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link TabularDataUtilities.Row#getHeaders()}
   */
  @Test
  void testRowGetHeaders2() {
    // Arrange
    HashMap<String, Integer> colIdxByName = new HashMap<>();
    colIdxByName.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue((new TabularDataUtilities.Row(null, colIdxByName)).getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link TabularDataUtilities.Row#getRowNum()}
   */
  @Test
  void testRowGetRowNum() {
    // Arrange
    TabularRow inputRow = mock(TabularRow.class);
    when(inputRow.rowNumber()).thenReturn(10);

    // Act
    Integer actualRowNum = (new TabularDataUtilities.Row(inputRow, new HashMap<>())).getRowNum();

    // Assert
    verify(inputRow).rowNumber();
    assertEquals(10, actualRowNum.intValue());
  }

  /**
   * Method under test: {@link TabularDataUtilities.Row#getValue(String)}
   */
  @Test
  void testRowGetValue() {
    // Arrange, Act and Assert
    assertNull((new TabularDataUtilities.Row(null, new HashMap<>())).getValue("Name"));
  }

  /**
   * Method under test: {@link TabularDataUtilities.Row#getValue(String)}
   */
  @Test
  void testRowGetValue2() {
    // Arrange
    HashMap<String, Integer> colIdxByName = new HashMap<>();
    colIdxByName.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull((new TabularDataUtilities.Row(null, colIdxByName)).getValue("Name"));
  }

  /**
   * Method under test: {@link TabularDataUtilities.Row#Row(TabularRow, Map)}
   */
  @Test
  void testRowNewRow() {
    // Arrange, Act and Assert
    assertTrue((new TabularDataUtilities.Row(null, new HashMap<>())).getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  void testStreamData() {
    // Arrange and Act
    Stream<TabularDataUtilities.Row> actualStreamDataResult = TabularDataUtilities.streamData("Input String");

    // Assert
    assertTrue(actualStreamDataResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  void testStreamData2() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TabularDataUtilities.streamData(null));
  }

  /**
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  void testStreamData3() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TabularDataUtilities.streamData("#"));
  }

  /**
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  void testStreamData4() {
    // Arrange and Act
    Stream<TabularDataUtilities.Row> actualStreamDataResult = TabularDataUtilities.streamData("[,\\t|]");

    // Assert
    assertTrue(actualStreamDataResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  void testStreamData5() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TabularDataUtilities.streamData(""));
  }
}
