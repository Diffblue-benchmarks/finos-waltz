package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapBuilderDiffblueTest {
  /**
   * Test {@link MapBuilder#add(Object, Object)}.
   *
   * <p>Method under test: {@link MapBuilder#add(Object, Object)}
   */
  @Test
  @DisplayName("Test add(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapBuilder MapBuilder.add(Object, Object)"})
  void testAdd() {
    // Arrange
    MapBuilder<Object, Object> mapBuilder = new MapBuilder<>();

    // Act
    MapBuilder<Object, Object> actualAddResult = mapBuilder.add("42", "42");

    // Assert
    Map<Object, Object> objectObjectMap = mapBuilder.build();
    assertEquals(1, objectObjectMap.size());
    assertEquals("42", objectObjectMap.get("42"));
    assertSame(mapBuilder, actualAddResult);
  }

  /**
   * Test {@link MapBuilder#build()}.
   *
   * <p>Method under test: {@link MapBuilder#build()}
   */
  @Test
  @DisplayName("Test build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapBuilder.build()"})
  void testBuild() {
    // Arrange
    MapBuilder<Object, Object> mapBuilder = new MapBuilder<>();

    // Act and Assert
    assertTrue(mapBuilder.build().isEmpty());
  }
}
