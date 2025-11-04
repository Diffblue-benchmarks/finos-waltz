package org.finos.waltz.model.server_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.Test;

class ImmutableServerSummaryStatisticsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addAllEnvironmentCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllEnvironmentCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEnvironmentCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addAllHardwareEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllHardwareEndOfLifeStatusCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllHardwareEndOfLifeStatusCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addAllLocationCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllLocationCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllLocationCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addAllOperatingSystemCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllOperatingSystemCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOperatingSystemCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addAllOperatingSystemEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllOperatingSystemEndOfLifeStatusCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOperatingSystemEndOfLifeStatusCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addEnvironmentCounts(Tally)}
   */
  @Test
  void testBuilderAddEnvironmentCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEnvironmentCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addEnvironmentCounts(Tally[])}
   */
  @Test
  void testBuilderAddEnvironmentCounts2() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEnvironmentCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addHardwareEndOfLifeStatusCounts(Tally)}
   */
  @Test
  void testBuilderAddHardwareEndOfLifeStatusCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addHardwareEndOfLifeStatusCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addHardwareEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  void testBuilderAddHardwareEndOfLifeStatusCounts2() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addHardwareEndOfLifeStatusCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addLocationCounts(Tally)}
   */
  @Test
  void testBuilderAddLocationCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addLocationCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addLocationCounts(Tally[])}
   */
  @Test
  void testBuilderAddLocationCounts2() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addLocationCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addOperatingSystemCounts(Tally)}
   */
  @Test
  void testBuilderAddOperatingSystemCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperatingSystemCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addOperatingSystemCounts(Tally[])}
   */
  @Test
  void testBuilderAddOperatingSystemCounts2() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperatingSystemCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addOperatingSystemEndOfLifeStatusCounts(Tally)}
   */
  @Test
  void testBuilderAddOperatingSystemEndOfLifeStatusCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperatingSystemEndOfLifeStatusCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#addOperatingSystemEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  void testBuilderAddOperatingSystemEndOfLifeStatusCounts2() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperatingSystemEndOfLifeStatusCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#environmentCounts(Iterable)}
   */
  @Test
  void testBuilderEnvironmentCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.environmentCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#from(ServerSummaryBasicStatistics)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();
    ServerSummaryBasicStatistics instance = mock(ServerSummaryBasicStatistics.class);
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    ImmutableServerSummaryStatistics buildResult = builderResult.build();
    assertEquals(3L, buildResult.physicalCount());
    assertEquals(3L, buildResult.totalCount());
    assertEquals(3L, buildResult.virtualCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#from(ServerSummaryStatistics)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    ImmutableServerSummaryStatistics buildResult = builderResult.build();
    assertEquals(3L, buildResult.physicalCount());
    assertEquals(3L, buildResult.totalCount());
    assertEquals(3L, buildResult.virtualCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#from(ServerSummaryStatistics)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(tallyList);
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    ImmutableServerSummaryStatistics buildResult = builderResult.build();
    assertEquals(1, buildResult.environmentCounts().size());
    assertEquals(3L, buildResult.physicalCount());
    assertEquals(3L, buildResult.totalCount());
    assertEquals(3L, buildResult.virtualCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#from(ServerSummaryStatistics)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(tallyList);
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    ImmutableServerSummaryStatistics buildResult = builderResult.build();
    assertEquals(1, buildResult.hardwareEndOfLifeStatusCounts().size());
    assertEquals(3L, buildResult.physicalCount());
    assertEquals(3L, buildResult.totalCount());
    assertEquals(3L, buildResult.virtualCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#from(ServerSummaryStatistics)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(tallyList);
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    ImmutableServerSummaryStatistics buildResult = builderResult.build();
    assertEquals(1, buildResult.locationCounts().size());
    assertEquals(3L, buildResult.physicalCount());
    assertEquals(3L, buildResult.totalCount());
    assertEquals(3L, buildResult.virtualCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#from(ServerSummaryStatistics)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(tallyList);
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    ImmutableServerSummaryStatistics buildResult = builderResult.build();
    assertEquals(1, buildResult.operatingSystemCounts().size());
    assertEquals(3L, buildResult.physicalCount());
    assertEquals(3L, buildResult.totalCount());
    assertEquals(3L, buildResult.virtualCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#from(ServerSummaryStatistics)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(tallyList);
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    ImmutableServerSummaryStatistics buildResult = builderResult.build();
    assertEquals(1, buildResult.operatingSystemEndOfLifeStatusCounts().size());
    assertEquals(3L, buildResult.physicalCount());
    assertEquals(3L, buildResult.totalCount());
    assertEquals(3L, buildResult.virtualCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#hardwareEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  void testBuilderHardwareEndOfLifeStatusCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.hardwareEndOfLifeStatusCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#locationCounts(Iterable)}
   */
  @Test
  void testBuilderLocationCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.locationCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#operatingSystemCounts(Iterable)}
   */
  @Test
  void testBuilderOperatingSystemCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystemCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#operatingSystemEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  void testBuilderOperatingSystemEndOfLifeStatusCounts() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystemEndOfLifeStatusCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#physicalCount(long)}
   */
  @Test
  void testBuilderPhysicalCount() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#physicalCount(long)}
   */
  @Test
  void testBuilderPhysicalCount2() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();
    builderResult.addEnvironmentCounts(mock(Tally.class));

    // Act and Assert
    assertSame(builderResult, builderResult.physicalCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#totalCount(long)}
   */
  @Test
  void testBuilderTotalCount() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.totalCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#totalCount(long)}
   */
  @Test
  void testBuilderTotalCount2() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();
    builderResult.addEnvironmentCounts(mock(Tally.class));

    // Act and Assert
    assertSame(builderResult, builderResult.totalCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#virtualCount(long)}
   */
  @Test
  void testBuilderVirtualCount() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.virtualCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Builder#virtualCount(long)}
   */
  @Test
  void testBuilderVirtualCount2() {
    // Arrange
    ImmutableServerSummaryStatistics.Builder builderResult = ImmutableServerSummaryStatistics.builder();
    builderResult.addEnvironmentCounts(mock(Tally.class));

    // Act and Assert
    assertSame(builderResult, builderResult.virtualCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics#copyOf(ServerSummaryStatistics)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics actualCopyOfResult = ImmutableServerSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    List<Tally<String>> environmentCountsResult = actualCopyOfResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualCopyOfResult.hardwareEndOfLifeStatusCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.locationCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics#copyOf(ServerSummaryStatistics)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(tallyList);
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics actualCopyOfResult = ImmutableServerSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, actualCopyOfResult.environmentCounts().size());
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    List<Tally<String>> hardwareEndOfLifeStatusCountsResult = actualCopyOfResult.hardwareEndOfLifeStatusCounts();
    assertTrue(hardwareEndOfLifeStatusCountsResult.isEmpty());
    assertSame(hardwareEndOfLifeStatusCountsResult, actualCopyOfResult.locationCounts());
    assertSame(hardwareEndOfLifeStatusCountsResult, actualCopyOfResult.operatingSystemCounts());
    assertSame(hardwareEndOfLifeStatusCountsResult, actualCopyOfResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics#copyOf(ServerSummaryStatistics)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(tallyList);
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics actualCopyOfResult = ImmutableServerSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    List<Tally<String>> hardwareEndOfLifeStatusCountsResult = actualCopyOfResult.hardwareEndOfLifeStatusCounts();
    assertTrue(hardwareEndOfLifeStatusCountsResult.isEmpty());
    assertEquals(tallyList, actualCopyOfResult.environmentCounts());
    assertSame(hardwareEndOfLifeStatusCountsResult, actualCopyOfResult.locationCounts());
    assertSame(hardwareEndOfLifeStatusCountsResult, actualCopyOfResult.operatingSystemCounts());
    assertSame(hardwareEndOfLifeStatusCountsResult, actualCopyOfResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics#copyOf(ServerSummaryStatistics)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(tallyList);
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics actualCopyOfResult = ImmutableServerSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, actualCopyOfResult.hardwareEndOfLifeStatusCounts().size());
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    List<Tally<String>> environmentCountsResult = actualCopyOfResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualCopyOfResult.locationCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics#copyOf(ServerSummaryStatistics)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(tallyList);
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics actualCopyOfResult = ImmutableServerSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, actualCopyOfResult.locationCounts().size());
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    List<Tally<String>> environmentCountsResult = actualCopyOfResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualCopyOfResult.hardwareEndOfLifeStatusCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics#copyOf(ServerSummaryStatistics)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(tallyList);
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics actualCopyOfResult = ImmutableServerSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, actualCopyOfResult.operatingSystemCounts().size());
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    List<Tally<String>> environmentCountsResult = actualCopyOfResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualCopyOfResult.hardwareEndOfLifeStatusCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.locationCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics#copyOf(ServerSummaryStatistics)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    ServerSummaryStatistics instance = mock(ServerSummaryStatistics.class);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.hardwareEndOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.locationCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemCounts()).thenReturn(new ArrayList<>());
    when(instance.operatingSystemEndOfLifeStatusCounts()).thenReturn(tallyList);
    when(instance.physicalCount()).thenReturn(3L);
    when(instance.virtualCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableServerSummaryStatistics actualCopyOfResult = ImmutableServerSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, actualCopyOfResult.operatingSystemEndOfLifeStatusCounts().size());
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    List<Tally<String>> environmentCountsResult = actualCopyOfResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualCopyOfResult.hardwareEndOfLifeStatusCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.locationCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#environmentCounts()}
   */
  @Test
  void testJsonEnvironmentCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryStatistics.Json()).environmentCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#hardwareEndOfLifeStatusCounts()}
   */
  @Test
  void testJsonHardwareEndOfLifeStatusCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryStatistics.Json()).hardwareEndOfLifeStatusCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#locationCounts()}
   */
  @Test
  void testJsonLocationCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryStatistics.Json()).locationCounts());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableServerSummaryStatistics.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableServerSummaryStatistics.Json actualJson = new ImmutableServerSummaryStatistics.Json();

    // Assert
    assertEquals(0L, actualJson.physicalCount);
    assertEquals(0L, actualJson.totalCount);
    assertEquals(0L, actualJson.virtualCount);
    assertFalse(actualJson.physicalCountIsSet);
    assertFalse(actualJson.totalCountIsSet);
    assertFalse(actualJson.virtualCountIsSet);
    assertTrue(actualJson.environmentCounts.isEmpty());
    assertTrue(actualJson.hardwareEndOfLifeStatusCounts.isEmpty());
    assertTrue(actualJson.locationCounts.isEmpty());
    assertTrue(actualJson.operatingSystemCounts.isEmpty());
    assertTrue(actualJson.operatingSystemEndOfLifeStatusCounts.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#operatingSystemCounts()}
   */
  @Test
  void testJsonOperatingSystemCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryStatistics.Json()).operatingSystemCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#operatingSystemEndOfLifeStatusCounts()}
   */
  @Test
  void testJsonOperatingSystemEndOfLifeStatusCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryStatistics.Json()).operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#physicalCount()}
   */
  @Test
  void testJsonPhysicalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryStatistics.Json()).physicalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#setPhysicalCount(long)}
   */
  @Test
  void testJsonSetPhysicalCount() {
    // Arrange
    ImmutableServerSummaryStatistics.Json json = new ImmutableServerSummaryStatistics.Json();

    // Act
    json.setPhysicalCount(3L);

    // Assert
    assertEquals(3L, json.physicalCount);
    assertTrue(json.physicalCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#setTotalCount(long)}
   */
  @Test
  void testJsonSetTotalCount() {
    // Arrange
    ImmutableServerSummaryStatistics.Json json = new ImmutableServerSummaryStatistics.Json();

    // Act
    json.setTotalCount(3L);

    // Assert
    assertEquals(3L, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#setVirtualCount(long)}
   */
  @Test
  void testJsonSetVirtualCount() {
    // Arrange
    ImmutableServerSummaryStatistics.Json json = new ImmutableServerSummaryStatistics.Json();

    // Act
    json.setVirtualCount(3L);

    // Assert
    assertEquals(3L, json.virtualCount);
    assertTrue(json.virtualCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableServerSummaryStatistics.Json#totalCount()}
   */
  @Test
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerSummaryStatistics.Json()).totalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableServerSummaryStatistics.Json#virtualCount()}
   */
  @Test
  void testJsonVirtualCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerSummaryStatistics.Json()).virtualCount());
  }
}
