package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.FlowDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataTypeDirectionKeyDiffblueTest {
  /**
   * Test {@link DataTypeDirectionKey#mkKey(Long, FlowDirection)}.
   * <p>
   * Method under test: {@link DataTypeDirectionKey#mkKey(Long, FlowDirection)}
   */
  @Test
  @DisplayName("Test mkKey(Long, FlowDirection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataTypeDirectionKey DataTypeDirectionKey.mkKey(Long, FlowDirection)"})
  void testMkKey() {
    // Arrange and Act
    DataTypeDirectionKey actualMkKeyResult = DataTypeDirectionKey.mkKey(1L, FlowDirection.INBOUND);

    // Assert
    assertTrue(actualMkKeyResult instanceof ImmutableDataTypeDirectionKey);
    assertEquals(1L, actualMkKeyResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, actualMkKeyResult.flowDirection());
  }
}
