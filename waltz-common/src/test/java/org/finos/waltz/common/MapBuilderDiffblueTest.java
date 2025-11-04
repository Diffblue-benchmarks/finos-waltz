package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MapBuilderDiffblueTest {
  /**
   * Method under test: {@link MapBuilder#add(Object, Object)}
   */
  @Test
  void testAdd() {
    // Arrange
    MapBuilder<Object, Object> mapBuilder = new MapBuilder<>();

    // Act
    MapBuilder<Object, Object> actualAddResult = mapBuilder.add("42", "42");

    // Assert
    Map<Object, Object> buildResult = mapBuilder.build();
    assertEquals(1, buildResult.size());
    assertEquals("42", buildResult.get("42"));
    Map<Object, Object> buildResult2 = actualAddResult.build();
    assertEquals(1, buildResult2.size());
    assertEquals("42", buildResult2.get("42"));
    assertSame(mapBuilder, actualAddResult);
  }

  /**
   * Method under test: {@link MapBuilder#build()}
   */
  @Test
  void testBuild() {
    // Arrange
    MapBuilder<Object, Object> mapBuilder = new MapBuilder<>();

    // Act and Assert
    assertTrue(mapBuilder.build().isEmpty());
  }
}
