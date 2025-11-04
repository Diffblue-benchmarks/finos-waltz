package org.finos.waltz.model.server_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableServerSummaryBasicStatisticsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Builder#from(ServerSummaryBasicStatistics)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableServerSummaryBasicStatistics.Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();
    ServerSummaryBasicStatistics instance = mock(ServerSummaryBasicStatistics.class);
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryBasicStatistics.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Builder#physicalCount(long)}
   */
  @Test
  void testBuilderPhysicalCount() {
    // Arrange
    ImmutableServerSummaryBasicStatistics.Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Builder#totalCount(long)}
   */
  @Test
  void testBuilderTotalCount() {
    // Arrange
    ImmutableServerSummaryBasicStatistics.Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.totalCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Builder#virtualCount(long)}
   */
  @Test
  void testBuilderVirtualCount() {
    // Arrange
    ImmutableServerSummaryBasicStatistics.Builder builderResult = ImmutableServerSummaryBasicStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.virtualCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics#copyOf(ServerSummaryBasicStatistics)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ServerSummaryBasicStatistics instance = mock(ServerSummaryBasicStatistics.class);
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryBasicStatistics actualCopyOfResult = ImmutableServerSummaryBasicStatistics.copyOf(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableServerSummaryBasicStatistics.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableServerSummaryBasicStatistics.Json actualJson = new ImmutableServerSummaryBasicStatistics.Json();

    // Assert
    assertEquals(0L, actualJson.physicalCount);
    assertEquals(0L, actualJson.totalCount);
    assertEquals(0L, actualJson.virtualCount);
    assertFalse(actualJson.physicalCountIsSet);
    assertFalse(actualJson.totalCountIsSet);
    assertFalse(actualJson.virtualCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Json#physicalCount()}
   */
  @Test
  void testJsonPhysicalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryBasicStatistics.Json()).physicalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Json#setPhysicalCount(long)}
   */
  @Test
  void testJsonSetPhysicalCount() {
    // Arrange
    ImmutableServerSummaryBasicStatistics.Json json = new ImmutableServerSummaryBasicStatistics.Json();

    // Act
    json.setPhysicalCount(3L);

    // Assert
    assertEquals(3L, json.physicalCount);
    assertTrue(json.physicalCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Json#setTotalCount(long)}
   */
  @Test
  void testJsonSetTotalCount() {
    // Arrange
    ImmutableServerSummaryBasicStatistics.Json json = new ImmutableServerSummaryBasicStatistics.Json();

    // Act
    json.setTotalCount(3L);

    // Assert
    assertEquals(3L, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Json#setVirtualCount(long)}
   */
  @Test
  void testJsonSetVirtualCount() {
    // Arrange
    ImmutableServerSummaryBasicStatistics.Json json = new ImmutableServerSummaryBasicStatistics.Json();

    // Act
    json.setVirtualCount(3L);

    // Assert
    assertEquals(3L, json.virtualCount);
    assertTrue(json.virtualCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Json#totalCount()}
   */
  @Test
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryBasicStatistics.Json()).totalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryBasicStatistics.Json#virtualCount()}
   */
  @Test
  void testJsonVirtualCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryBasicStatistics.Json()).virtualCount());
  }
}
