package org.finos.waltz.jobs.tools.lineage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataTypeEdgeDiffblueTest {
  /**
   * Test {@link DataTypeEdge#DataTypeEdge(long, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return DataTypes is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeEdge#DataTypeEdge(long, List)}
   */
  @Test
  @DisplayName(
      "Test new DataTypeEdge(long, List); given '42'; when ArrayList() add '42'; then return DataTypes is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataTypeEdge.<init>(long, List)"})
  void testNewDataTypeEdge_given42_whenArrayListAdd42_thenReturnDataTypesIsArrayList() {
    // Arrange
    ArrayList<String> dataTypes = new ArrayList<>();
    dataTypes.add("42");
    dataTypes.add("foo");

    // Act
    DataTypeEdge actualDataTypeEdge = new DataTypeEdge(1L, dataTypes);

    // Assert
    assertEquals(1L, actualDataTypeEdge.getFlowId());
    assertSame(dataTypes, actualDataTypeEdge.getDataTypes());
  }

  /**
   * Test {@link DataTypeEdge#DataTypeEdge(long, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return DataTypes is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeEdge#DataTypeEdge(long, List)}
   */
  @Test
  @DisplayName(
      "Test new DataTypeEdge(long, List); given 'foo'; when ArrayList() add 'foo'; then return DataTypes is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataTypeEdge.<init>(long, List)"})
  void testNewDataTypeEdge_givenFoo_whenArrayListAddFoo_thenReturnDataTypesIsArrayList() {
    // Arrange
    ArrayList<String> dataTypes = new ArrayList<>();
    dataTypes.add("foo");

    // Act
    DataTypeEdge actualDataTypeEdge = new DataTypeEdge(1L, dataTypes);

    // Assert
    assertEquals(1L, actualDataTypeEdge.getFlowId());
    assertSame(dataTypes, actualDataTypeEdge.getDataTypes());
  }

  /**
   * Test {@link DataTypeEdge#DataTypeEdge(long, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return DataTypes Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeEdge#DataTypeEdge(long, List)}
   */
  @Test
  @DisplayName("Test new DataTypeEdge(long, List); when ArrayList(); then return DataTypes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataTypeEdge.<init>(long, List)"})
  void testNewDataTypeEdge_whenArrayList_thenReturnDataTypesEmpty() {
    // Arrange and Act
    DataTypeEdge actualDataTypeEdge = new DataTypeEdge(1L, new ArrayList<>());

    // Assert
    assertEquals(1L, actualDataTypeEdge.getFlowId());
    assertTrue(actualDataTypeEdge.getDataTypes().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DataTypeEdge#toString()}
   *   <li>{@link DataTypeEdge#getDataTypes()}
   *   <li>{@link DataTypeEdge#getFlowId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DataTypeEdge.getDataTypes()",
    "long DataTypeEdge.getFlowId()",
    "String DataTypeEdge.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<String> dataTypes = new ArrayList<>();
    DataTypeEdge dataTypeEdge = new DataTypeEdge(1L, dataTypes);

    // Act
    String actualToStringResult = dataTypeEdge.toString();
    List<String> actualDataTypes = dataTypeEdge.getDataTypes();

    // Assert
    assertEquals("(null : null : [])", actualToStringResult);
    assertEquals(1L, dataTypeEdge.getFlowId());
    assertTrue(actualDataTypes.isEmpty());
    assertSame(dataTypes, actualDataTypes);
  }
}
