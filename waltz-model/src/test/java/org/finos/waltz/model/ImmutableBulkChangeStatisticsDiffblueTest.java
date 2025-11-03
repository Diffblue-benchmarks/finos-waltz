package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableBulkChangeStatistics.Builder;
import org.finos.waltz.model.ImmutableBulkChangeStatistics.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkChangeStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#addedCount(int)}.
   * <p>
   * Method under test: {@link Builder#addedCount(int)}
   */
  @Test
  @DisplayName("Test Builder addedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addedCount(int)"})
  void testBuilderAddedCount() {
    // Arrange
    Builder builderResult = ImmutableBulkChangeStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addedCount(3));
  }

  /**
   * Test Builder {@link Builder#from(BulkChangeStatistics)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build addedCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkChangeStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(BulkChangeStatistics); given three; then builder build addedCount is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkChangeStatistics)"})
  void testBuilderFrom_givenThree_thenBuilderBuildAddedCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableBulkChangeStatistics.builder();
    BulkChangeStatistics instance = mock(BulkChangeStatistics.class);
    when(instance.addedCount()).thenReturn(3);
    when(instance.removedCount()).thenReturn(3);
    when(instance.updatedCount()).thenReturn(3);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedCount();
    verify(instance).removedCount();
    verify(instance).updatedCount();
    ImmutableBulkChangeStatistics buildResult = builderResult.build();
    assertEquals(3, buildResult.addedCount());
    assertEquals(3, buildResult.removedCount());
    assertEquals(3, buildResult.updatedCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#removedCount(int)}.
   * <p>
   * Method under test: {@link Builder#removedCount(int)}
   */
  @Test
  @DisplayName("Test Builder removedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.removedCount(int)"})
  void testBuilderRemovedCount() {
    // Arrange
    Builder builderResult = ImmutableBulkChangeStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.removedCount(3));
  }

  /**
   * Test Builder {@link Builder#updatedCount(int)}.
   * <p>
   * Method under test: {@link Builder#updatedCount(int)}
   */
  @Test
  @DisplayName("Test Builder updatedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.updatedCount(int)"})
  void testBuilderUpdatedCount() {
    // Arrange
    Builder builderResult = ImmutableBulkChangeStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.updatedCount(3));
  }

  /**
   * Test Json {@link Json#addedCount()}.
   * <p>
   * Method under test: {@link Json#addedCount()}
   */
  @Test
  @DisplayName("Test Json addedCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.addedCount()"})
  void testJsonAddedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).addedCount());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertEquals(0, actualJson.addedCount);
    assertEquals(0, actualJson.removedCount);
    assertEquals(0, actualJson.updatedCount);
    assertFalse(actualJson.addedCountIsSet);
    assertFalse(actualJson.removedCountIsSet);
    assertFalse(actualJson.updatedCountIsSet);
  }

  /**
   * Test Json {@link Json#removedCount()}.
   * <p>
   * Method under test: {@link Json#removedCount()}
   */
  @Test
  @DisplayName("Test Json removedCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.removedCount()"})
  void testJsonRemovedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).removedCount());
  }

  /**
   * Test Json {@link Json#setAddedCount(int)}.
   * <p>
   * Method under test: {@link Json#setAddedCount(int)}
   */
  @Test
  @DisplayName("Test Json setAddedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setAddedCount(int)"})
  void testJsonSetAddedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAddedCount(3);

    // Assert
    assertEquals(3, json.addedCount);
    assertTrue(json.addedCountIsSet);
  }

  /**
   * Test Json {@link Json#setRemovedCount(int)}.
   * <p>
   * Method under test: {@link Json#setRemovedCount(int)}
   */
  @Test
  @DisplayName("Test Json setRemovedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRemovedCount(int)"})
  void testJsonSetRemovedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRemovedCount(3);

    // Assert
    assertEquals(3, json.removedCount);
    assertTrue(json.removedCountIsSet);
  }

  /**
   * Test Json {@link Json#setUpdatedCount(int)}.
   * <p>
   * Method under test: {@link Json#setUpdatedCount(int)}
   */
  @Test
  @DisplayName("Test Json setUpdatedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setUpdatedCount(int)"})
  void testJsonSetUpdatedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setUpdatedCount(3);

    // Assert
    assertEquals(3, json.updatedCount);
    assertTrue(json.updatedCountIsSet);
  }

  /**
   * Test Json {@link Json#updatedCount()}.
   * <p>
   * Method under test: {@link Json#updatedCount()}
   */
  @Test
  @DisplayName("Test Json updatedCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.updatedCount()"})
  void testJsonUpdatedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).updatedCount());
  }
}
