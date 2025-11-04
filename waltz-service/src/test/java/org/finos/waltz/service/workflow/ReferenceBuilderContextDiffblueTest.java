package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ReferenceBuilderContextDiffblueTest {
  /**
   * Method under test: {@link ReferenceBuilderContext#get(String)}
   */
  @Test
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new ReferenceBuilderContext()).get("Name"));
  }

  /**
   * Method under test: {@link ReferenceBuilderContext#set(String, Object)}
   */
  @Test
  void testSet() {
    // Arrange
    ReferenceBuilderContext referenceBuilderContext = new ReferenceBuilderContext();

    // Act
    referenceBuilderContext.set("Name", null);

    // Assert
    Set<String> keysResult = referenceBuilderContext.keys();
    assertEquals(1, keysResult.size());
    assertTrue(keysResult.contains("Name"));
  }

  /**
   * Method under test: {@link ReferenceBuilderContext#keys()}
   */
  @Test
  void testKeys() {
    // Arrange, Act and Assert
    assertTrue((new ReferenceBuilderContext()).keys().isEmpty());
  }

  /**
   * Method under test: {@link ReferenceBuilderContext#has(String)}
   */
  @Test
  void testHas() {
    // Arrange, Act and Assert
    assertFalse((new ReferenceBuilderContext()).has("Name"));
  }

  /**
   * Method under test: {@link ReferenceBuilderContext#declarations()}
   */
  @Test
  void testDeclarations() {
    // Arrange, Act and Assert
    assertTrue((new ReferenceBuilderContext()).declarations().isEmpty());
  }
}
