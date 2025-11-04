package org.finos.waltz.jobs.tools.lineage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DataTypeEdgeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataTypeEdge#toString()}
   *   <li>{@link DataTypeEdge#getDataTypes()}
   *   <li>{@link DataTypeEdge#getFlowId()}
   * </ul>
   */
  @Test
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

  /**
   * Method under test: {@link DataTypeEdge#DataTypeEdge(long, List)}
   */
  @Test
  void testNewDataTypeEdge() {
    // Arrange
    ArrayList<String> dataTypes = new ArrayList<>();

    // Act
    DataTypeEdge actualDataTypeEdge = new DataTypeEdge(1L, dataTypes);

    // Assert
    assertEquals(1L, actualDataTypeEdge.getFlowId());
    List<String> dataTypes2 = actualDataTypeEdge.getDataTypes();
    assertTrue(dataTypes2.isEmpty());
    assertSame(dataTypes, dataTypes2);
  }

  /**
   * Method under test: {@link DataTypeEdge#DataTypeEdge(long, List)}
   */
  @Test
  void testNewDataTypeEdge2() {
    // Arrange
    ArrayList<String> dataTypes = new ArrayList<>();
    dataTypes.add("foo");

    // Act
    DataTypeEdge actualDataTypeEdge = new DataTypeEdge(1L, dataTypes);

    // Assert
    List<String> dataTypes2 = actualDataTypeEdge.getDataTypes();
    assertEquals(1, dataTypes2.size());
    assertEquals("foo", dataTypes2.get(0));
    assertEquals(1L, actualDataTypeEdge.getFlowId());
    assertSame(dataTypes, dataTypes2);
  }

  /**
   * Method under test: {@link DataTypeEdge#DataTypeEdge(long, List)}
   */
  @Test
  void testNewDataTypeEdge3() {
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
}
