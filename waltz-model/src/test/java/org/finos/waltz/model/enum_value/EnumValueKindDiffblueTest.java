package org.finos.waltz.model.enum_value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EnumValueKindDiffblueTest {
  /**
   * Method under test: {@link EnumValueKind#dbValue()}
   */
  @Test
  void testDbValue() {
    // Arrange, Act and Assert
    assertEquals("TransportKind", EnumValueKind.valueOf("TRANSPORT_KIND").dbValue());
  }
}
