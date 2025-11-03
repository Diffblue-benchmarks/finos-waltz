package org.finos.waltz.model.server_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.server_information.ImmutableServerSummaryBasicStatistics.Builder;
import org.finos.waltz.model.server_information.ImmutableServerSummaryBasicStatistics.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableServerSummaryBasicStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#from(ServerSummaryBasicStatistics)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build physicalCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ServerSummaryBasicStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryBasicStatistics); given three; then builder build physicalCount is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryBasicStatistics)"})
  void testBuilderFrom_givenThree_thenBuilderBuildPhysicalCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();
    ServerSummaryBasicStatistics instance = mock(ServerSummaryBasicStatistics.class);
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    ImmutableServerSummaryBasicStatistics buildResult = builderResult.build();
    assertEquals(3L, buildResult.physicalCount());
    assertEquals(3L, buildResult.totalCount());
    assertEquals(3L, buildResult.virtualCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#physicalCount(long)}.
   * <p>
   * Method under test: {@link Builder#physicalCount(long)}
   */
  @Test
  @DisplayName("Test Builder physicalCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.physicalCount(long)"})
  void testBuilderPhysicalCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalCount(3L));
  }

  /**
   * Test Builder {@link Builder#totalCount(long)}.
   * <p>
   * Method under test: {@link Builder#totalCount(long)}
   */
  @Test
  @DisplayName("Test Builder totalCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.totalCount(long)"})
  void testBuilderTotalCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.totalCount(3L));
  }

  /**
   * Test Builder {@link Builder#virtualCount(long)}.
   * <p>
   * Method under test: {@link Builder#virtualCount(long)}
   */
  @Test
  @DisplayName("Test Builder virtualCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.virtualCount(long)"})
  void testBuilderVirtualCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.virtualCount(3L));
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
    assertEquals(0L, actualJson.physicalCount);
    assertEquals(0L, actualJson.totalCount);
    assertEquals(0L, actualJson.virtualCount);
    assertFalse(actualJson.physicalCountIsSet);
    assertFalse(actualJson.totalCountIsSet);
    assertFalse(actualJson.virtualCountIsSet);
  }

  /**
   * Test Json {@link Json#physicalCount()}.
   * <p>
   * Method under test: {@link Json#physicalCount()}
   */
  @Test
  @DisplayName("Test Json physicalCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.physicalCount()"})
  void testJsonPhysicalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalCount());
  }

  /**
   * Test Json {@link Json#setPhysicalCount(long)}.
   * <p>
   * Method under test: {@link Json#setPhysicalCount(long)}
   */
  @Test
  @DisplayName("Test Json setPhysicalCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPhysicalCount(long)"})
  void testJsonSetPhysicalCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPhysicalCount(3L);

    // Assert
    assertEquals(3L, json.physicalCount);
    assertTrue(json.physicalCountIsSet);
  }

  /**
   * Test Json {@link Json#setTotalCount(long)}.
   * <p>
   * Method under test: {@link Json#setTotalCount(long)}
   */
  @Test
  @DisplayName("Test Json setTotalCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setTotalCount(long)"})
  void testJsonSetTotalCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTotalCount(3L);

    // Assert
    assertEquals(3L, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Test Json {@link Json#setVirtualCount(long)}.
   * <p>
   * Method under test: {@link Json#setVirtualCount(long)}
   */
  @Test
  @DisplayName("Test Json setVirtualCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setVirtualCount(long)"})
  void testJsonSetVirtualCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setVirtualCount(3L);

    // Assert
    assertEquals(3L, json.virtualCount);
    assertTrue(json.virtualCountIsSet);
  }

  /**
   * Test Json {@link Json#totalCount()}.
   * <p>
   * Method under test: {@link Json#totalCount()}
   */
  @Test
  @DisplayName("Test Json totalCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.totalCount()"})
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).totalCount());
  }

  /**
   * Test Json {@link Json#virtualCount()}.
   * <p>
   * Method under test: {@link Json#virtualCount()}
   */
  @Test
  @DisplayName("Test Json virtualCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.virtualCount()"})
  void testJsonVirtualCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).virtualCount());
  }
}
