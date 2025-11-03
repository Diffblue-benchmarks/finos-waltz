package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReferenceBuilderContextDiffblueTest {
  /**
   * Test {@link ReferenceBuilderContext#get(String)}.
   * <p>
   * Method under test: {@link ReferenceBuilderContext#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ReferenceBuilderContext.get(String)"})
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new ReferenceBuilderContext()).get("Name"));
  }

  /**
   * Test {@link ReferenceBuilderContext#set(String, Object)}.
   * <p>
   * Method under test: {@link ReferenceBuilderContext#set(String, Object)}
   */
  @Test
  @DisplayName("Test set(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ReferenceBuilderContext.set(String, Object)"})
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
   * Test {@link ReferenceBuilderContext#keys()}.
   * <p>
   * Method under test: {@link ReferenceBuilderContext#keys()}
   */
  @Test
  @DisplayName("Test keys()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReferenceBuilderContext.keys()"})
  void testKeys() {
    // Arrange, Act and Assert
    assertTrue((new ReferenceBuilderContext()).keys().isEmpty());
  }

  /**
   * Test {@link ReferenceBuilderContext#has(String)}.
   * <p>
   * Method under test: {@link ReferenceBuilderContext#has(String)}
   */
  @Test
  @DisplayName("Test has(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReferenceBuilderContext.has(String)"})
  void testHas() {
    // Arrange, Act and Assert
    assertFalse((new ReferenceBuilderContext()).has("Name"));
  }

  /**
   * Test {@link ReferenceBuilderContext#declarations()}.
   * <p>
   * Method under test: {@link ReferenceBuilderContext#declarations()}
   */
  @Test
  @DisplayName("Test declarations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReferenceBuilderContext.declarations()"})
  void testDeclarations() {
    // Arrange, Act and Assert
    assertTrue((new ReferenceBuilderContext()).declarations().isEmpty());
  }
}
