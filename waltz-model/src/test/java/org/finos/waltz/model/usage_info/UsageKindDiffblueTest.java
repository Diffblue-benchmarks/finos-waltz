package org.finos.waltz.model.usage_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UsageKindDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UsageKind#displayName()}
   *   <li>{@link UsageKind#isReadOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UsageKind.displayName()", "boolean UsageKind.isReadOnly()"})
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
