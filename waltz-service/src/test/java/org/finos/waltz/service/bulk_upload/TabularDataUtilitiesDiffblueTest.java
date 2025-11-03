package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.finos.waltz.service.bulk_upload.TabularDataUtilities.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TabularDataUtilitiesDiffblueTest {
  /**
   * Test Row {@link Row#getHeaders()}.
   * <p>
   * Method under test: {@link Row#getHeaders()}
   */
  @Test
  @DisplayName("Test Row getHeaders()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Row.getHeaders()"})
  void testRowGetHeaders() {
    // Arrange, Act and Assert
    assertTrue((new Row(null, new HashMap<>())).getHeaders().isEmpty());
  }

  /**
   * Test Row {@link Row#getRowNum()}.
   * <ul>
   *   <li>Given {@link TabularRow} {@link TabularRow#rowNumber()} return ten.</li>
   *   <li>Then return intValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Row#getRowNum()}
   */
  @Test
  @DisplayName("Test Row getRowNum(); given TabularRow rowNumber() return ten; then return intValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Row.getRowNum()"})
  void testRowGetRowNum_givenTabularRowRowNumberReturnTen_thenReturnIntValueIsTen() {
    // Arrange
    TabularRow inputRow = mock(TabularRow.class);
    when(inputRow.rowNumber()).thenReturn(10);

    // Act
    Integer actualRowNum = (new Row(inputRow, new HashMap<>())).getRowNum();

    // Assert
    verify(inputRow).rowNumber();
    assertEquals(10, actualRowNum.intValue());
  }

  /**
   * Test Row {@link Row#getValue(String)}.
   * <p>
   * Method under test: {@link Row#getValue(String)}
   */
  @Test
  @DisplayName("Test Row getValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Row.getValue(String)"})
  void testRowGetValue() {
    // Arrange, Act and Assert
    assertNull((new Row(null, new HashMap<>())).getValue("Name"));
  }

  /**
   * Test Row {@link Row#Row(TabularRow, Map)}.
   * <p>
   * Method under test: {@link Row#Row(TabularRow, Map)}
   */
  @Test
  @DisplayName("Test Row new Row(TabularRow, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Row.<init>(TabularRow, Map)"})
  void testRowNewRow() {
    // Arrange, Act and Assert
    assertTrue((new Row(null, new HashMap<>())).getHeaders().isEmpty());
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName("Test streamData(String); when empty string; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenEmptyString_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TabularDataUtilities.streamData(""));
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   * <ul>
   *   <li>When {@code Input String}.</li>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName("Test streamData(String); when 'Input String'; then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenInputString_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Row> actualStreamDataResult = TabularDataUtilities.streamData("Input String");

    // Assert
    assertTrue(actualStreamDataResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName("Test streamData(String); when 'null'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenNull_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TabularDataUtilities.streamData(null));
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   * <ul>
   *   <li>When {@code #}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName("Test streamData(String); when '#'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenNumberSign_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TabularDataUtilities.streamData("#"));
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   * <ul>
   *   <li>When {@code [,\t|]}.</li>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName("Test streamData(String); when '[,\\t|]'; then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenT_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Row> actualStreamDataResult = TabularDataUtilities.streamData("[,\\t|]");

    // Assert
    assertTrue(actualStreamDataResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
