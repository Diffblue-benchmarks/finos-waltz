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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.server_information.ImmutableServerSummaryStatistics.Builder;
import org.finos.waltz.model.server_information.ImmutableServerSummaryStatistics.Json;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableServerSummaryStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllEnvironmentCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllEnvironmentCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEnvironmentCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllEnvironmentCounts(Iterable)"})
  void testBuilderAddAllEnvironmentCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEnvironmentCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllHardwareEndOfLifeStatusCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllHardwareEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllHardwareEndOfLifeStatusCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllHardwareEndOfLifeStatusCounts(Iterable)"})
  void testBuilderAddAllHardwareEndOfLifeStatusCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllHardwareEndOfLifeStatusCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllLocationCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllLocationCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllLocationCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllLocationCounts(Iterable)"})
  void testBuilderAddAllLocationCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllLocationCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllOperatingSystemCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOperatingSystemCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOperatingSystemCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOperatingSystemCounts(Iterable)"})
  void testBuilderAddAllOperatingSystemCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOperatingSystemCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllOperatingSystemEndOfLifeStatusCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOperatingSystemEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOperatingSystemEndOfLifeStatusCounts(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOperatingSystemEndOfLifeStatusCounts(Iterable)"})
  void testBuilderAddAllOperatingSystemEndOfLifeStatusCounts_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOperatingSystemEndOfLifeStatusCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addEnvironmentCounts(Tally)} with {@code element}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addEnvironmentCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addEnvironmentCounts(Tally) with 'element'; when Tally; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEnvironmentCounts(Tally)"})
  void testBuilderAddEnvironmentCountsWithElement_whenTally_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEnvironmentCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addEnvironmentCounts(Tally[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addEnvironmentCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addEnvironmentCounts(Tally[]) with 'elements'; when Tally; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEnvironmentCounts(Tally[])"})
  void testBuilderAddEnvironmentCountsWithElements_whenTally_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEnvironmentCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addHardwareEndOfLifeStatusCounts(Tally)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addHardwareEndOfLifeStatusCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addHardwareEndOfLifeStatusCounts(Tally) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addHardwareEndOfLifeStatusCounts(Tally)"})
  void testBuilderAddHardwareEndOfLifeStatusCountsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addHardwareEndOfLifeStatusCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addHardwareEndOfLifeStatusCounts(Tally[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addHardwareEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addHardwareEndOfLifeStatusCounts(Tally[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addHardwareEndOfLifeStatusCounts(Tally[])"})
  void testBuilderAddHardwareEndOfLifeStatusCountsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addHardwareEndOfLifeStatusCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addLocationCounts(Tally)} with {@code element}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addLocationCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addLocationCounts(Tally) with 'element'; when Tally; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLocationCounts(Tally)"})
  void testBuilderAddLocationCountsWithElement_whenTally_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addLocationCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addLocationCounts(Tally[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addLocationCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addLocationCounts(Tally[]) with 'elements'; when Tally; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addLocationCounts(Tally[])"})
  void testBuilderAddLocationCountsWithElements_whenTally_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addLocationCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addOperatingSystemCounts(Tally)} with {@code element}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOperatingSystemCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addOperatingSystemCounts(Tally) with 'element'; when Tally; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOperatingSystemCounts(Tally)"})
  void testBuilderAddOperatingSystemCountsWithElement_whenTally_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperatingSystemCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addOperatingSystemCounts(Tally[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOperatingSystemCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addOperatingSystemCounts(Tally[]) with 'elements'; when Tally; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOperatingSystemCounts(Tally[])"})
  void testBuilderAddOperatingSystemCountsWithElements_whenTally_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperatingSystemCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addOperatingSystemEndOfLifeStatusCounts(Tally)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOperatingSystemEndOfLifeStatusCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addOperatingSystemEndOfLifeStatusCounts(Tally) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOperatingSystemEndOfLifeStatusCounts(Tally)"})
  void testBuilderAddOperatingSystemEndOfLifeStatusCountsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperatingSystemEndOfLifeStatusCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addOperatingSystemEndOfLifeStatusCounts(Tally[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOperatingSystemEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addOperatingSystemEndOfLifeStatusCounts(Tally[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOperatingSystemEndOfLifeStatusCounts(Tally[])"})
  void testBuilderAddOperatingSystemEndOfLifeStatusCountsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperatingSystemEndOfLifeStatusCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#environmentCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#environmentCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder environmentCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.environmentCounts(Iterable)"})
  void testBuilderEnvironmentCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.environmentCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryBasicStatistics)} with {@code ServerSummaryBasicStatistics}.
   * <p>
   * Method under test: {@link Builder#from(ServerSummaryBasicStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryBasicStatistics) with 'ServerSummaryBasicStatistics'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryBasicStatistics)"})
  void testBuilderFromWithServerSummaryBasicStatistics() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();
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
    ImmutableServerSummaryStatistics buildResult = builderResult.build();
    assertEquals(3L, buildResult.physicalCount());
    assertEquals(3L, buildResult.totalCount());
    assertEquals(3L, buildResult.virtualCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code ServerSummaryStatistics}.
   * <p>
   * Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    ImmutableServerSummaryStatistics buildResult = actualFromResult.build();
    assertEquals(1, buildResult.environmentCounts().size());
    assertEquals(1, builderResult.build().environmentCounts().size());
    List<Tally<String>> hardwareEndOfLifeStatusCountsResult = buildResult.hardwareEndOfLifeStatusCounts();
    assertTrue(hardwareEndOfLifeStatusCountsResult.isEmpty());
    assertSame(hardwareEndOfLifeStatusCountsResult, buildResult.locationCounts());
    assertSame(hardwareEndOfLifeStatusCountsResult, buildResult.operatingSystemCounts());
    assertSame(hardwareEndOfLifeStatusCountsResult, buildResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code ServerSummaryStatistics}.
   * <p>
   * Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics2() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, actualFromResult.build().hardwareEndOfLifeStatusCounts().size());
    assertEquals(1, builderResult.build().hardwareEndOfLifeStatusCounts().size());
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code ServerSummaryStatistics}.
   * <p>
   * Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics3() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, actualFromResult.build().locationCounts().size());
    assertEquals(1, builderResult.build().locationCounts().size());
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code ServerSummaryStatistics}.
   * <p>
   * Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics4() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, actualFromResult.build().operatingSystemCounts().size());
    assertEquals(1, builderResult.build().operatingSystemCounts().size());
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code ServerSummaryStatistics}.
   * <p>
   * Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics5() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, actualFromResult.build().operatingSystemEndOfLifeStatusCounts().size());
    assertEquals(1, builderResult.build().operatingSystemEndOfLifeStatusCounts().size());
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code ServerSummaryStatistics}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ServerSummaryBasicStatistics#physicalCount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'; given ArrayList(); then calls physicalCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics_givenArrayList_thenCallsPhysicalCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();
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
    builderResult.from(instance);

    // Assert
    verify(instance).physicalCount();
    verify(instance).totalCount();
    verify(instance).virtualCount();
    verify(instance).environmentCounts();
    verify(instance).hardwareEndOfLifeStatusCounts();
    verify(instance).locationCounts();
    verify(instance).operatingSystemCounts();
    verify(instance).operatingSystemEndOfLifeStatusCounts();
  }

  /**
   * Test Builder {@link Builder#hardwareEndOfLifeStatusCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#hardwareEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder hardwareEndOfLifeStatusCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.hardwareEndOfLifeStatusCounts(Iterable)"})
  void testBuilderHardwareEndOfLifeStatusCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.hardwareEndOfLifeStatusCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#locationCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#locationCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder locationCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.locationCounts(Iterable)"})
  void testBuilderLocationCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.locationCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#operatingSystemCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#operatingSystemCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder operatingSystemCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operatingSystemCounts(Iterable)"})
  void testBuilderOperatingSystemCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystemCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#operatingSystemEndOfLifeStatusCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#operatingSystemEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder operatingSystemEndOfLifeStatusCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operatingSystemEndOfLifeStatusCounts(Iterable)"})
  void testBuilderOperatingSystemEndOfLifeStatusCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystemEndOfLifeStatusCounts(new ArrayList<>()));
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
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

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
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

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
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.virtualCount(3L));
  }

  /**
   * Test Json {@link Json#environmentCounts()}.
   * <p>
   * Method under test: {@link Json#environmentCounts()}
   */
  @Test
  @DisplayName("Test Json environmentCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.environmentCounts()"})
  void testJsonEnvironmentCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).environmentCounts());
  }

  /**
   * Test Json {@link Json#hardwareEndOfLifeStatusCounts()}.
   * <p>
   * Method under test: {@link Json#hardwareEndOfLifeStatusCounts()}
   */
  @Test
  @DisplayName("Test Json hardwareEndOfLifeStatusCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.hardwareEndOfLifeStatusCounts()"})
  void testJsonHardwareEndOfLifeStatusCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).hardwareEndOfLifeStatusCounts());
  }

  /**
   * Test Json {@link Json#locationCounts()}.
   * <p>
   * Method under test: {@link Json#locationCounts()}
   */
  @Test
  @DisplayName("Test Json locationCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.locationCounts()"})
  void testJsonLocationCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).locationCounts());
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
    assertTrue(actualJson.environmentCounts.isEmpty());
    assertTrue(actualJson.hardwareEndOfLifeStatusCounts.isEmpty());
    assertTrue(actualJson.locationCounts.isEmpty());
    assertTrue(actualJson.operatingSystemCounts.isEmpty());
    assertTrue(actualJson.operatingSystemEndOfLifeStatusCounts.isEmpty());
  }

  /**
   * Test Json {@link Json#operatingSystemCounts()}.
   * <p>
   * Method under test: {@link Json#operatingSystemCounts()}
   */
  @Test
  @DisplayName("Test Json operatingSystemCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.operatingSystemCounts()"})
  void testJsonOperatingSystemCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operatingSystemCounts());
  }

  /**
   * Test Json {@link Json#operatingSystemEndOfLifeStatusCounts()}.
   * <p>
   * Method under test: {@link Json#operatingSystemEndOfLifeStatusCounts()}
   */
  @Test
  @DisplayName("Test Json operatingSystemEndOfLifeStatusCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.operatingSystemEndOfLifeStatusCounts()"})
  void testJsonOperatingSystemEndOfLifeStatusCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operatingSystemEndOfLifeStatusCounts());
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
