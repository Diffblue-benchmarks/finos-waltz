package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link Row#getHeaders()}
   */
  @Test
  @DisplayName("Test Row getHeaders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Row.getHeaders()"})
  void testRowGetHeaders() {
    // Arrange
    ImmutableTabularRow inputRow = ImmutableTabularRow.builder().rowNumber(10).values("42").build();
    Row row = new Row(inputRow, new HashMap<>());

    // Act and Assert
    assertTrue(row.getHeaders().isEmpty());
  }

  /**
   * Test Row {@link Row#getRowNum()}.
   *
   * <p>Method under test: {@link Row#getRowNum()}
   */
  @Test
  @DisplayName("Test Row getRowNum()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer Row.getRowNum()"})
  void testRowGetRowNum() {
    // Arrange
    ImmutableTabularRow inputRow = ImmutableTabularRow.builder().rowNumber(10).values("42").build();
    Row row = new Row(inputRow, new HashMap<>());

    // Act and Assert
    assertEquals(10, row.getRowNum().intValue());
  }

  /**
   * Test Row {@link Row#getValue(String)}.
   *
   * <p>Method under test: {@link Row#getValue(String)}
   */
  @Test
  @DisplayName("Test Row getValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Row.getValue(String)"})
  void testRowGetValue() {
    // Arrange
    ImmutableTabularRow inputRow = ImmutableTabularRow.builder().rowNumber(10).values("42").build();
    Row row = new Row(inputRow, new HashMap<>());

    // Act and Assert
    assertNull(row.getValue("Name"));
  }

  /**
   * Test Row {@link Row#Row(TabularRow, Map)}.
   *
   * <p>Method under test: {@link Row#Row(TabularRow, Map)}
   */
  @Test
  @DisplayName("Test Row new Row(TabularRow, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Row.<init>(TabularRow, Map)"})
  void testRowNewRow() {
    // Arrange
    ImmutableTabularRow inputRow = ImmutableTabularRow.builder().rowNumber(10).values("42").build();

    // Act
    Row actualRow = new Row(inputRow, new HashMap<>());

    // Assert
    assertEquals(10, actualRow.getRowNum().intValue());
    assertTrue(actualRow.getHeaders().isEmpty());
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName("Test streamData(String); when empty string; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenEmptyString_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TabularDataUtilities.streamData(""));
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   *
   * <ul>
   *   <li>When {@code Input String}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName(
      "Test streamData(String); when 'Input String'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenInputString_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Row> actualStreamDataResult = TabularDataUtilities.streamData("Input String");

    // Assert
    assertTrue(actualStreamDataResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName("Test streamData(String); when 'null'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenNull_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TabularDataUtilities.streamData(null));
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   *
   * <ul>
   *   <li>When {@code #}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName("Test streamData(String); when '#'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenNumberSign_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TabularDataUtilities.streamData("#"));
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   *
   * <ul>
   *   <li>When {@code [,\t|][,\t|]}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName("Test streamData(String); when '[,\\t|][,\\t|]'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenTT_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> TabularDataUtilities.streamData("[,\\t|][,\\t|]"));
  }

  /**
   * Test {@link TabularDataUtilities#streamData(String)}.
   *
   * <ul>
   *   <li>When {@code [,\t|]}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link TabularDataUtilities#streamData(String)}
   */
  @Test
  @DisplayName(
      "Test streamData(String); when '[,\\t|]'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream TabularDataUtilities.streamData(String)"})
  void testStreamData_whenT_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Row> actualStreamDataResult = TabularDataUtilities.streamData("[,\\t|]");

    // Assert
    assertTrue(actualStreamDataResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
