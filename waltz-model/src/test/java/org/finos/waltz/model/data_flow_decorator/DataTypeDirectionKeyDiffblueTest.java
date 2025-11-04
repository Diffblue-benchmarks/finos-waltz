package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.waltz.model.FlowDirection;
import org.junit.jupiter.api.Test;

class DataTypeDirectionKeyDiffblueTest {
  /**
   * Method under test: {@link DataTypeDirectionKey#mkKey(Long, FlowDirection)}
   */
  @Test
  void testMkKey() {
    // Arrange and Act
    DataTypeDirectionKey actualMkKeyResult = DataTypeDirectionKey.mkKey(1L, FlowDirection.INBOUND);

    // Assert
    assertTrue(actualMkKeyResult instanceof ImmutableDataTypeDirectionKey);
    assertEquals(1L, actualMkKeyResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, actualMkKeyResult.flowDirection());
  }
}
