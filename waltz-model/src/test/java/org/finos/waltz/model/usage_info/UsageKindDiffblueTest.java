package org.finos.waltz.model.usage_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class UsageKindDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UsageKind#displayName()}
   *   <li>{@link UsageKind#isReadOnly()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    UsageKind valueOfResult = UsageKind.valueOf("CONSUMER");

    // Act
    String actualDisplayNameResult = valueOfResult.displayName();

    // Assert
    assertEquals("Consumer", actualDisplayNameResult);
    assertTrue(valueOfResult.isReadOnly());
  }
}
