package org.finos.waltz.model.server_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.server_information.ImmutableServerSummaryStatistics.Builder;
import org.finos.waltz.model.server_information.ImmutableServerSummaryStatistics.Json;
import org.finos.waltz.model.tally.ImmutableOrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableServerSummaryStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllEnvironmentCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEnvironmentCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllEnvironmentCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEnvironmentCounts(Iterable)"})
  void testBuilderAddAllEnvironmentCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualAddAllEnvironmentCountsResult =
        builderResult.addAllEnvironmentCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEnvironmentCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAllHardwareEndOfLifeStatusCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllHardwareEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllHardwareEndOfLifeStatusCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllHardwareEndOfLifeStatusCounts(Iterable)"})
  void testBuilderAddAllHardwareEndOfLifeStatusCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualAddAllHardwareEndOfLifeStatusCountsResult =
        builderResult.addAllHardwareEndOfLifeStatusCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllHardwareEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAllLocationCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllLocationCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllLocationCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllLocationCounts(Iterable)"})
  void testBuilderAddAllLocationCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualAddAllLocationCountsResult =
        builderResult.addAllLocationCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllLocationCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAllOperatingSystemCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOperatingSystemCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllOperatingSystemCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOperatingSystemCounts(Iterable)"})
  void testBuilderAddAllOperatingSystemCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualAddAllOperatingSystemCountsResult =
        builderResult.addAllOperatingSystemCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllOperatingSystemCountsResult);
  }

  /**
   * Test Builder {@link Builder#addAllOperatingSystemEndOfLifeStatusCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOperatingSystemEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllOperatingSystemEndOfLifeStatusCounts(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOperatingSystemEndOfLifeStatusCounts(Iterable)"})
  void testBuilderAddAllOperatingSystemEndOfLifeStatusCounts_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualAddAllOperatingSystemEndOfLifeStatusCountsResult =
        builderResult.addAllOperatingSystemEndOfLifeStatusCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllOperatingSystemEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#addEnvironmentCounts(Tally)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addEnvironmentCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addEnvironmentCounts(Tally) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEnvironmentCounts(Tally)"})
  void testBuilderAddEnvironmentCountsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddEnvironmentCountsResult =
        builderResult.addEnvironmentCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddEnvironmentCountsResult);
  }

  /**
   * Test Builder {@link Builder#addEnvironmentCounts(Tally[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addEnvironmentCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addEnvironmentCounts(Tally[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEnvironmentCounts(Tally[])"})
  void testBuilderAddEnvironmentCountsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddEnvironmentCountsResult =
        builderResult.addEnvironmentCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddEnvironmentCountsResult);
  }

  /**
   * Test Builder {@link Builder#addHardwareEndOfLifeStatusCounts(Tally)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addHardwareEndOfLifeStatusCounts(Tally)}
   */
  @Test
  @DisplayName(
      "Test Builder addHardwareEndOfLifeStatusCounts(Tally) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addHardwareEndOfLifeStatusCounts(Tally)"})
  void testBuilderAddHardwareEndOfLifeStatusCountsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddHardwareEndOfLifeStatusCountsResult =
        builderResult.addHardwareEndOfLifeStatusCounts(
            builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddHardwareEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#addHardwareEndOfLifeStatusCounts(Tally[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addHardwareEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  @DisplayName(
      "Test Builder addHardwareEndOfLifeStatusCounts(Tally[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addHardwareEndOfLifeStatusCounts(Tally[])"})
  void testBuilderAddHardwareEndOfLifeStatusCountsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddHardwareEndOfLifeStatusCountsResult =
        builderResult.addHardwareEndOfLifeStatusCounts(
            builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddHardwareEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#addLocationCounts(Tally)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addLocationCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addLocationCounts(Tally) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLocationCounts(Tally)"})
  void testBuilderAddLocationCountsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddLocationCountsResult =
        builderResult.addLocationCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddLocationCountsResult);
  }

  /**
   * Test Builder {@link Builder#addLocationCounts(Tally[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addLocationCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addLocationCounts(Tally[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLocationCounts(Tally[])"})
  void testBuilderAddLocationCountsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddLocationCountsResult =
        builderResult.addLocationCounts(builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddLocationCountsResult);
  }

  /**
   * Test Builder {@link Builder#addOperatingSystemCounts(Tally)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOperatingSystemCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addOperatingSystemCounts(Tally) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperatingSystemCounts(Tally)"})
  void testBuilderAddOperatingSystemCountsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddOperatingSystemCountsResult =
        builderResult.addOperatingSystemCounts(
            builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddOperatingSystemCountsResult);
  }

  /**
   * Test Builder {@link Builder#addOperatingSystemCounts(Tally[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOperatingSystemCounts(Tally[])}
   */
  @Test
  @DisplayName(
      "Test Builder addOperatingSystemCounts(Tally[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperatingSystemCounts(Tally[])"})
  void testBuilderAddOperatingSystemCountsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddOperatingSystemCountsResult =
        builderResult.addOperatingSystemCounts(
            builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddOperatingSystemCountsResult);
  }

  /**
   * Test Builder {@link Builder#addOperatingSystemEndOfLifeStatusCounts(Tally)} with {@code
   * element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOperatingSystemEndOfLifeStatusCounts(Tally)}
   */
  @Test
  @DisplayName(
      "Test Builder addOperatingSystemEndOfLifeStatusCounts(Tally) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperatingSystemEndOfLifeStatusCounts(Tally)"})
  void testBuilderAddOperatingSystemEndOfLifeStatusCountsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddOperatingSystemEndOfLifeStatusCountsResult =
        builderResult.addOperatingSystemEndOfLifeStatusCounts(
            builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddOperatingSystemEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#addOperatingSystemEndOfLifeStatusCounts(Tally[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOperatingSystemEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  @DisplayName(
      "Test Builder addOperatingSystemEndOfLifeStatusCounts(Tally[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperatingSystemEndOfLifeStatusCounts(Tally[])"})
  void testBuilderAddOperatingSystemEndOfLifeStatusCountsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddOperatingSystemEndOfLifeStatusCountsResult =
        builderResult.addOperatingSystemEndOfLifeStatusCounts(
            builderResult2.count(10.0d).id("42").index(1).build());

    // Assert
    assertSame(builderResult, actualAddOperatingSystemEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerSummaryStatistics Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableServerSummaryStatistics actualImmutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Assert
    assertEquals(3L, actualImmutableServerSummaryStatistics.physicalCount());
    assertEquals(3L, actualImmutableServerSummaryStatistics.virtualCount());
    assertEquals(6L, actualImmutableServerSummaryStatistics.totalCount());
    assertTrue(actualImmutableServerSummaryStatistics.environmentCounts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#environmentCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#environmentCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder environmentCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.environmentCounts(Iterable)"})
  void testBuilderEnvironmentCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualEnvironmentCountsResult = builderResult.environmentCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualEnvironmentCountsResult);
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryBasicStatistics)} with {@code
   * ServerSummaryBasicStatistics}.
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryBasicStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ServerSummaryBasicStatistics) with 'ServerSummaryBasicStatistics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryBasicStatistics)"})
  void testBuilderFromWithServerSummaryBasicStatistics() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    builderResult.from(
        ImmutableServerSummaryBasicStatistics.builder().physicalCount(3L).virtualCount(3L).build());

    // Assert
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics = builderResult.build();
    assertEquals(3L, immutableServerSummaryStatistics.physicalCount());
    assertEquals(3L, immutableServerSummaryStatistics.virtualCount());
    assertEquals(6L, immutableServerSummaryStatistics.totalCount());
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryBasicStatistics)} with {@code
   * ServerSummaryBasicStatistics}.
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryBasicStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ServerSummaryBasicStatistics) with 'ServerSummaryBasicStatistics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryBasicStatistics)"})
  void testBuilderFromWithServerSummaryBasicStatistics2() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();
    ImmutableServerSummaryStatistics instance =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    ImmutableServerSummaryStatistics actualImmutableServerSummaryStatistics =
        builderResult.from((ServerSummaryBasicStatistics) instance).build();
    assertEquals(instance, actualImmutableServerSummaryStatistics);
    ImmutableServerSummaryStatistics actualImmutableServerSummaryStatistics2 =
        builderResult.build();
    assertEquals(instance, actualImmutableServerSummaryStatistics2);
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code
   * ServerSummaryStatistics}.
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    Builder builderResult2 = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addEnvironmentCounts(builderResult3.count(10.0d).id("42").index(1).build());

    // Act and Assert
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        builderResult.from(builderResult2.physicalCount(3L).virtualCount(3L).build()).build();
    List<Tally<String>> hardwareEndOfLifeStatusCountsResult =
        immutableServerSummaryStatistics.hardwareEndOfLifeStatusCounts();
    assertTrue(hardwareEndOfLifeStatusCountsResult.isEmpty());
    assertSame(
        hardwareEndOfLifeStatusCountsResult, immutableServerSummaryStatistics.locationCounts());
    assertSame(
        hardwareEndOfLifeStatusCountsResult,
        immutableServerSummaryStatistics.operatingSystemCounts());
    assertSame(
        hardwareEndOfLifeStatusCountsResult,
        immutableServerSummaryStatistics.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code
   * ServerSummaryStatistics}.
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics2() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    Builder builderResult2 = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addOperatingSystemCounts(builderResult3.count(10.0d).id("42").index(1).build());

    ImmutableOrderedTally.Builder<String> builderResult4 = ImmutableOrderedTally.builder();
    builderResult2.addEnvironmentCounts(builderResult4.count(10.0d).id("42").index(1).build());

    // Act and Assert
    List<Tally<String>> operatingSystemCountsResult =
        builderResult
            .from(builderResult2.physicalCount(3L).virtualCount(3L).build())
            .build()
            .operatingSystemCounts();
    assertEquals(1, operatingSystemCountsResult.size());
    assertTrue(operatingSystemCountsResult.get(0) instanceof ImmutableOrderedTally);
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code
   * ServerSummaryStatistics}.
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics3() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    Builder builderResult2 = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addLocationCounts(builderResult3.count(10.0d).id("42").index(1).build());

    ImmutableOrderedTally.Builder<String> builderResult4 = ImmutableOrderedTally.builder();
    builderResult2.addEnvironmentCounts(builderResult4.count(10.0d).id("42").index(1).build());

    // Act and Assert
    List<Tally<String>> locationCountsResult =
        builderResult
            .from(builderResult2.physicalCount(3L).virtualCount(3L).build())
            .build()
            .locationCounts();
    assertEquals(1, locationCountsResult.size());
    assertTrue(locationCountsResult.get(0) instanceof ImmutableOrderedTally);
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code
   * ServerSummaryStatistics}.
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics4() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    Builder builderResult2 = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addOperatingSystemEndOfLifeStatusCounts(
        builderResult3.count(10.0d).id("42").index(1).build());

    ImmutableOrderedTally.Builder<String> builderResult4 = ImmutableOrderedTally.builder();
    builderResult2.addEnvironmentCounts(builderResult4.count(10.0d).id("42").index(1).build());

    // Act and Assert
    List<Tally<String>> operatingSystemEndOfLifeStatusCountsResult =
        builderResult
            .from(builderResult2.physicalCount(3L).virtualCount(3L).build())
            .build()
            .operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, operatingSystemEndOfLifeStatusCountsResult.size());
    assertTrue(operatingSystemEndOfLifeStatusCountsResult.get(0) instanceof ImmutableOrderedTally);
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code
   * ServerSummaryStatistics}.
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics5() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    Builder builderResult2 = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addHardwareEndOfLifeStatusCounts(
        builderResult3.count(10.0d).id("42").index(1).build());

    ImmutableOrderedTally.Builder<String> builderResult4 = ImmutableOrderedTally.builder();
    builderResult2.addEnvironmentCounts(builderResult4.count(10.0d).id("42").index(1).build());

    // Act and Assert
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        builderResult.from(builderResult2.physicalCount(3L).virtualCount(3L).build()).build();
    List<Tally<String>> hardwareEndOfLifeStatusCountsResult =
        immutableServerSummaryStatistics.hardwareEndOfLifeStatusCounts();
    assertEquals(1, hardwareEndOfLifeStatusCountsResult.size());
    assertTrue(hardwareEndOfLifeStatusCountsResult.get(0) instanceof ImmutableOrderedTally);
    List<Tally<String>> locationCountsResult = immutableServerSummaryStatistics.locationCounts();
    assertTrue(locationCountsResult.isEmpty());
    assertSame(locationCountsResult, immutableServerSummaryStatistics.operatingSystemCounts());
    assertSame(
        locationCountsResult,
        immutableServerSummaryStatistics.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test Builder {@link Builder#from(ServerSummaryStatistics)} with {@code
   * ServerSummaryStatistics}.
   *
   * <ul>
   *   <li>Then return build environmentCounts Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ServerSummaryStatistics) with 'ServerSummaryStatistics'; then return build environmentCounts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerSummaryStatistics)"})
  void testBuilderFromWithServerSummaryStatistics_thenReturnBuildEnvironmentCountsEmpty() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act and Assert
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        builderResult
            .from(
                ImmutableServerSummaryStatistics.builder()
                    .physicalCount(3L)
                    .virtualCount(3L)
                    .build())
            .build();
    List<Tally<String>> environmentCountsResult =
        immutableServerSummaryStatistics.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(
        environmentCountsResult, immutableServerSummaryStatistics.hardwareEndOfLifeStatusCounts());
    assertSame(environmentCountsResult, immutableServerSummaryStatistics.locationCounts());
    assertSame(environmentCountsResult, immutableServerSummaryStatistics.operatingSystemCounts());
    assertSame(
        environmentCountsResult,
        immutableServerSummaryStatistics.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test Builder {@link Builder#hardwareEndOfLifeStatusCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#hardwareEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder hardwareEndOfLifeStatusCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.hardwareEndOfLifeStatusCounts(Iterable)"})
  void testBuilderHardwareEndOfLifeStatusCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualHardwareEndOfLifeStatusCountsResult =
        builderResult.hardwareEndOfLifeStatusCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualHardwareEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#locationCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#locationCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder locationCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.locationCounts(Iterable)"})
  void testBuilderLocationCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualLocationCountsResult = builderResult.locationCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualLocationCountsResult);
  }

  /**
   * Test Builder {@link Builder#operatingSystemCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operatingSystemCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder operatingSystemCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operatingSystemCounts(Iterable)"})
  void testBuilderOperatingSystemCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualOperatingSystemCountsResult =
        builderResult.operatingSystemCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualOperatingSystemCountsResult);
  }

  /**
   * Test Builder {@link Builder#operatingSystemEndOfLifeStatusCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operatingSystemEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder operatingSystemEndOfLifeStatusCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operatingSystemEndOfLifeStatusCounts(Iterable)"})
  void testBuilderOperatingSystemEndOfLifeStatusCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualOperatingSystemEndOfLifeStatusCountsResult =
        builderResult.operatingSystemEndOfLifeStatusCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualOperatingSystemEndOfLifeStatusCountsResult);
  }

  /**
   * Test Builder {@link Builder#physicalCount(long)}.
   *
   * <p>Method under test: {@link Builder#physicalCount(long)}
   */
  @Test
  @DisplayName("Test Builder physicalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.physicalCount(long)"})
  void testBuilderPhysicalCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualPhysicalCountResult = builderResult.physicalCount(3L);

    // Assert
    assertSame(builderResult, actualPhysicalCountResult);
  }

  /**
   * Test Builder {@link Builder#totalCount(long)}.
   *
   * <p>Method under test: {@link Builder#totalCount(long)}
   */
  @Test
  @DisplayName("Test Builder totalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.totalCount(long)"})
  void testBuilderTotalCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualTotalCountResult = builderResult.totalCount(3L);

    // Assert
    assertSame(builderResult, actualTotalCountResult);
  }

  /**
   * Test Builder {@link Builder#virtualCount(long)}.
   *
   * <p>Method under test: {@link Builder#virtualCount(long)}
   */
  @Test
  @DisplayName("Test Builder virtualCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.virtualCount(long)"})
  void testBuilderVirtualCount() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    // Act
    Builder actualVirtualCountResult = builderResult.virtualCount(3L);

    // Assert
    assertSame(builderResult, actualVirtualCountResult);
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#copyOf(ServerSummaryStatistics)}.
   *
   * <ul>
   *   <li>Then return physicalCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#copyOf(ServerSummaryStatistics)}
   */
  @Test
  @DisplayName("Test copyOf(ServerSummaryStatistics); then return physicalCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.copyOf(ServerSummaryStatistics)"
  })
  void testCopyOf_thenReturnPhysicalCountIsThree() {
    // Arrange
    ImmutableServerSummaryStatistics instance =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act
    ImmutableServerSummaryStatistics actualCopyOfResult =
        ImmutableServerSummaryStatistics.copyOf(instance);

    // Assert
    assertEquals(3L, actualCopyOfResult.physicalCount());
    assertEquals(3L, actualCopyOfResult.virtualCount());
    assertEquals(6L, actualCopyOfResult.totalCount());
    List<Tally<String>> environmentCountsResult = actualCopyOfResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualCopyOfResult.hardwareEndOfLifeStatusCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.locationCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#equals(Object)}, and {@link
   * ImmutableServerSummaryStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableServerSummaryStatistics#equals(Object)}
   *   <li>{@link ImmutableServerSummaryStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryStatistics.equals(Object)",
    "int ImmutableServerSummaryStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics2 =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    assertEquals(immutableServerSummaryStatistics, immutableServerSummaryStatistics2);
    assertEquals(
        immutableServerSummaryStatistics.hashCode(), immutableServerSummaryStatistics2.hashCode());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#equals(Object)}, and {@link
   * ImmutableServerSummaryStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableServerSummaryStatistics#equals(Object)}
   *   <li>{@link ImmutableServerSummaryStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryStatistics.equals(Object)",
    "int ImmutableServerSummaryStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    assertEquals(immutableServerSummaryStatistics, immutableServerSummaryStatistics);
    int expectedHashCodeResult = immutableServerSummaryStatistics.hashCode();
    assertEquals(expectedHashCodeResult, immutableServerSummaryStatistics.hashCode());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryStatistics.equals(Object)",
    "int ImmutableServerSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addEnvironmentCounts(builderResult2.count(10.0d).id("42").index(1).build());
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        builderResult.physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    assertNotEquals(
        immutableServerSummaryStatistics,
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryStatistics.equals(Object)",
    "int ImmutableServerSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addOperatingSystemCounts(builderResult2.count(10.0d).id("42").index(1).build());
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        builderResult.physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    assertNotEquals(
        immutableServerSummaryStatistics,
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryStatistics.equals(Object)",
    "int ImmutableServerSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addLocationCounts(builderResult2.count(10.0d).id("42").index(1).build());
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        builderResult.physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    assertNotEquals(
        immutableServerSummaryStatistics,
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryStatistics.equals(Object)",
    "int ImmutableServerSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addOperatingSystemEndOfLifeStatusCounts(
        builderResult2.count(10.0d).id("42").index(1).build());
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        builderResult.physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    assertNotEquals(
        immutableServerSummaryStatistics,
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryStatistics.equals(Object)",
    "int ImmutableServerSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableServerSummaryStatistics.builder();

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addHardwareEndOfLifeStatusCounts(
        builderResult2.count(10.0d).id("42").index(1).build());
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        builderResult.physicalCount(3L).virtualCount(3L).build();

    // Act and Assert
    assertNotEquals(
        immutableServerSummaryStatistics,
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryStatistics.equals(Object)",
    "int ImmutableServerSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build(),
        null);
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerSummaryStatistics.equals(Object)",
    "int ImmutableServerSummaryStatistics.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build(),
        "Different type to ImmutableServerSummaryStatistics");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableServerSummaryStatistics#toString()}
   *   <li>{@link ImmutableServerSummaryStatistics#environmentCounts()}
   *   <li>{@link ImmutableServerSummaryStatistics#hardwareEndOfLifeStatusCounts()}
   *   <li>{@link ImmutableServerSummaryStatistics#locationCounts()}
   *   <li>{@link ImmutableServerSummaryStatistics#operatingSystemCounts()}
   *   <li>{@link ImmutableServerSummaryStatistics#operatingSystemEndOfLifeStatusCounts()}
   *   <li>{@link ImmutableServerSummaryStatistics#physicalCount()}
   *   <li>{@link ImmutableServerSummaryStatistics#totalCount()}
   *   <li>{@link ImmutableServerSummaryStatistics#virtualCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableServerSummaryStatistics.environmentCounts()",
    "List ImmutableServerSummaryStatistics.hardwareEndOfLifeStatusCounts()",
    "List ImmutableServerSummaryStatistics.locationCounts()",
    "List ImmutableServerSummaryStatistics.operatingSystemCounts()",
    "List ImmutableServerSummaryStatistics.operatingSystemEndOfLifeStatusCounts()",
    "long ImmutableServerSummaryStatistics.physicalCount()",
    "String ImmutableServerSummaryStatistics.toString()",
    "long ImmutableServerSummaryStatistics.totalCount()",
    "long ImmutableServerSummaryStatistics.virtualCount()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act
    String actualToStringResult = immutableServerSummaryStatistics.toString();
    List<Tally<String>> actualEnvironmentCountsResult =
        immutableServerSummaryStatistics.environmentCounts();
    List<Tally<String>> actualHardwareEndOfLifeStatusCountsResult =
        immutableServerSummaryStatistics.hardwareEndOfLifeStatusCounts();
    List<Tally<String>> actualLocationCountsResult =
        immutableServerSummaryStatistics.locationCounts();
    List<Tally<String>> actualOperatingSystemCountsResult =
        immutableServerSummaryStatistics.operatingSystemCounts();
    List<Tally<String>> actualOperatingSystemEndOfLifeStatusCountsResult =
        immutableServerSummaryStatistics.operatingSystemEndOfLifeStatusCounts();
    long actualPhysicalCountResult = immutableServerSummaryStatistics.physicalCount();
    long actualTotalCountResult = immutableServerSummaryStatistics.totalCount();

    // Assert
    assertEquals(
        "ServerSummaryStatistics{virtualCount=3, physicalCount=3, totalCount=6, environmentCounts=[],"
            + " operatingSystemCounts=[], locationCounts=[], operatingSystemEndOfLifeStatusCounts=[], hardwareEndOf"
            + "LifeStatusCounts=[]}",
        actualToStringResult);
    assertEquals(3L, actualPhysicalCountResult);
    assertEquals(3L, immutableServerSummaryStatistics.virtualCount());
    assertEquals(6L, actualTotalCountResult);
    assertTrue(actualEnvironmentCountsResult.isEmpty());
    assertSame(actualEnvironmentCountsResult, actualHardwareEndOfLifeStatusCountsResult);
    assertSame(actualEnvironmentCountsResult, actualLocationCountsResult);
    assertSame(actualEnvironmentCountsResult, actualOperatingSystemCountsResult);
    assertSame(actualEnvironmentCountsResult, actualOperatingSystemEndOfLifeStatusCountsResult);
  }

  /**
   * Test Json {@link Json#environmentCounts()}.
   *
   * <p>Method under test: {@link Json#environmentCounts()}
   */
  @Test
  @DisplayName("Test Json environmentCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.environmentCounts()"})
  void testJsonEnvironmentCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().environmentCounts());
  }

  /**
   * Test Json {@link Json#hardwareEndOfLifeStatusCounts()}.
   *
   * <p>Method under test: {@link Json#hardwareEndOfLifeStatusCounts()}
   */
  @Test
  @DisplayName("Test Json hardwareEndOfLifeStatusCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.hardwareEndOfLifeStatusCounts()"})
  void testJsonHardwareEndOfLifeStatusCounts() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().hardwareEndOfLifeStatusCounts());
  }

  /**
   * Test Json {@link Json#locationCounts()}.
   *
   * <p>Method under test: {@link Json#locationCounts()}
   */
  @Test
  @DisplayName("Test Json locationCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.locationCounts()"})
  void testJsonLocationCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().locationCounts());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#operatingSystemCounts()}
   */
  @Test
  @DisplayName("Test Json operatingSystemCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.operatingSystemCounts()"})
  void testJsonOperatingSystemCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operatingSystemCounts());
  }

  /**
   * Test Json {@link Json#operatingSystemEndOfLifeStatusCounts()}.
   *
   * <p>Method under test: {@link Json#operatingSystemEndOfLifeStatusCounts()}
   */
  @Test
  @DisplayName("Test Json operatingSystemEndOfLifeStatusCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.operatingSystemEndOfLifeStatusCounts()"})
  void testJsonOperatingSystemEndOfLifeStatusCounts() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new Json().operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test Json {@link Json#physicalCount()}.
   *
   * <p>Method under test: {@link Json#physicalCount()}
   */
  @Test
  @DisplayName("Test Json physicalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.physicalCount()"})
  void testJsonPhysicalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalCount());
  }

  /**
   * Test Json {@link Json#setPhysicalCount(long)}.
   *
   * <p>Method under test: {@link Json#setPhysicalCount(long)}
   */
  @Test
  @DisplayName("Test Json setPhysicalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setTotalCount(long)}
   */
  @Test
  @DisplayName("Test Json setTotalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setVirtualCount(long)}
   */
  @Test
  @DisplayName("Test Json setVirtualCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#totalCount()}
   */
  @Test
  @DisplayName("Test Json totalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.totalCount()"})
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().totalCount());
  }

  /**
   * Test Json {@link Json#virtualCount()}.
   *
   * <p>Method under test: {@link Json#virtualCount()}
   */
  @Test
  @DisplayName("Test Json virtualCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.virtualCount()"})
  void testJsonVirtualCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().virtualCount());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withEnvironmentCounts(Tally[])} with {@code
   * Tally[]}.
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#withEnvironmentCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withEnvironmentCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withEnvironmentCounts(Tally[])"
  })
  void testWithEnvironmentCountsWithTally() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableServerSummaryStatistics actualWithEnvironmentCountsResult =
        immutableServerSummaryStatistics.withEnvironmentCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> environmentCountsResult =
        actualWithEnvironmentCountsResult.environmentCounts();
    assertEquals(1, environmentCountsResult.size());
    Tally<String> getResult = environmentCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    assertEquals(3L, actualWithEnvironmentCountsResult.physicalCount());
    assertEquals(3L, actualWithEnvironmentCountsResult.virtualCount());
    assertEquals(6L, actualWithEnvironmentCountsResult.totalCount());
    List<Tally<String>> hardwareEndOfLifeStatusCountsResult =
        actualWithEnvironmentCountsResult.hardwareEndOfLifeStatusCounts();
    assertTrue(hardwareEndOfLifeStatusCountsResult.isEmpty());
    assertSame(
        hardwareEndOfLifeStatusCountsResult, actualWithEnvironmentCountsResult.locationCounts());
    assertSame(
        hardwareEndOfLifeStatusCountsResult,
        actualWithEnvironmentCountsResult.operatingSystemCounts());
    assertSame(
        hardwareEndOfLifeStatusCountsResult,
        actualWithEnvironmentCountsResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withHardwareEndOfLifeStatusCounts(Tally[])} with
   * {@code Tally[]}.
   *
   * <p>Method under test: {@link
   * ImmutableServerSummaryStatistics#withHardwareEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withHardwareEndOfLifeStatusCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withHardwareEndOfLifeStatusCounts(Tally[])"
  })
  void testWithHardwareEndOfLifeStatusCountsWithTally() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableServerSummaryStatistics actualWithHardwareEndOfLifeStatusCountsResult =
        immutableServerSummaryStatistics.withHardwareEndOfLifeStatusCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> hardwareEndOfLifeStatusCountsResult =
        actualWithHardwareEndOfLifeStatusCountsResult.hardwareEndOfLifeStatusCounts();
    assertEquals(1, hardwareEndOfLifeStatusCountsResult.size());
    Tally<String> getResult = hardwareEndOfLifeStatusCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    assertEquals(3L, actualWithHardwareEndOfLifeStatusCountsResult.physicalCount());
    assertEquals(3L, actualWithHardwareEndOfLifeStatusCountsResult.virtualCount());
    assertEquals(6L, actualWithHardwareEndOfLifeStatusCountsResult.totalCount());
    List<Tally<String>> environmentCountsResult =
        actualWithHardwareEndOfLifeStatusCountsResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(
        environmentCountsResult, actualWithHardwareEndOfLifeStatusCountsResult.locationCounts());
    assertSame(
        environmentCountsResult,
        actualWithHardwareEndOfLifeStatusCountsResult.operatingSystemCounts());
    assertSame(
        environmentCountsResult,
        actualWithHardwareEndOfLifeStatusCountsResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withLocationCounts(Tally[])} with {@code Tally[]}.
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#withLocationCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withLocationCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withLocationCounts(Tally[])"
  })
  void testWithLocationCountsWithTally() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableServerSummaryStatistics actualWithLocationCountsResult =
        immutableServerSummaryStatistics.withLocationCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> locationCountsResult = actualWithLocationCountsResult.locationCounts();
    assertEquals(1, locationCountsResult.size());
    Tally<String> getResult = locationCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    assertEquals(3L, actualWithLocationCountsResult.physicalCount());
    assertEquals(3L, actualWithLocationCountsResult.virtualCount());
    assertEquals(6L, actualWithLocationCountsResult.totalCount());
    List<Tally<String>> environmentCountsResult =
        actualWithLocationCountsResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(
        environmentCountsResult, actualWithLocationCountsResult.hardwareEndOfLifeStatusCounts());
    assertSame(environmentCountsResult, actualWithLocationCountsResult.operatingSystemCounts());
    assertSame(
        environmentCountsResult,
        actualWithLocationCountsResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withOperatingSystemCounts(Tally[])} with {@code
   * Tally[]}.
   *
   * <p>Method under test: {@link
   * ImmutableServerSummaryStatistics#withOperatingSystemCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withOperatingSystemCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withOperatingSystemCounts(Tally[])"
  })
  void testWithOperatingSystemCountsWithTally() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableServerSummaryStatistics actualWithOperatingSystemCountsResult =
        immutableServerSummaryStatistics.withOperatingSystemCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> operatingSystemCountsResult =
        actualWithOperatingSystemCountsResult.operatingSystemCounts();
    assertEquals(1, operatingSystemCountsResult.size());
    Tally<String> getResult = operatingSystemCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    assertEquals(3L, actualWithOperatingSystemCountsResult.physicalCount());
    assertEquals(3L, actualWithOperatingSystemCountsResult.virtualCount());
    assertEquals(6L, actualWithOperatingSystemCountsResult.totalCount());
    List<Tally<String>> environmentCountsResult =
        actualWithOperatingSystemCountsResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(
        environmentCountsResult,
        actualWithOperatingSystemCountsResult.hardwareEndOfLifeStatusCounts());
    assertSame(environmentCountsResult, actualWithOperatingSystemCountsResult.locationCounts());
    assertSame(
        environmentCountsResult,
        actualWithOperatingSystemCountsResult.operatingSystemEndOfLifeStatusCounts());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withOperatingSystemEndOfLifeStatusCounts(Tally[])}
   * with {@code Tally[]}.
   *
   * <p>Method under test: {@link
   * ImmutableServerSummaryStatistics#withOperatingSystemEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withOperatingSystemEndOfLifeStatusCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withOperatingSystemEndOfLifeStatusCounts(Tally[])"
  })
  void testWithOperatingSystemEndOfLifeStatusCountsWithTally() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableServerSummaryStatistics actualWithOperatingSystemEndOfLifeStatusCountsResult =
        immutableServerSummaryStatistics.withOperatingSystemEndOfLifeStatusCounts(
            builderResult.count(10.0d).id("42").index(1).build());

    // Assert
    List<Tally<String>> operatingSystemEndOfLifeStatusCountsResult =
        actualWithOperatingSystemEndOfLifeStatusCountsResult.operatingSystemEndOfLifeStatusCounts();
    assertEquals(1, operatingSystemEndOfLifeStatusCountsResult.size());
    Tally<String> getResult = operatingSystemEndOfLifeStatusCountsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<String>) getResult).index());
    assertEquals(10.0d, getResult.count());
    assertEquals(3L, actualWithOperatingSystemEndOfLifeStatusCountsResult.physicalCount());
    assertEquals(3L, actualWithOperatingSystemEndOfLifeStatusCountsResult.virtualCount());
    assertEquals(6L, actualWithOperatingSystemEndOfLifeStatusCountsResult.totalCount());
    List<Tally<String>> environmentCountsResult =
        actualWithOperatingSystemEndOfLifeStatusCountsResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(
        environmentCountsResult,
        actualWithOperatingSystemEndOfLifeStatusCountsResult.hardwareEndOfLifeStatusCounts());
    assertSame(
        environmentCountsResult,
        actualWithOperatingSystemEndOfLifeStatusCountsResult.locationCounts());
    assertSame(
        environmentCountsResult,
        actualWithOperatingSystemEndOfLifeStatusCountsResult.operatingSystemCounts());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withPhysicalCount(long)}.
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#withPhysicalCount(long)}
   */
  @Test
  @DisplayName("Test withPhysicalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withPhysicalCount(long)"
  })
  void testWithPhysicalCount() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(42L).virtualCount(3L).build();

    // Act
    ImmutableServerSummaryStatistics actualWithPhysicalCountResult =
        immutableServerSummaryStatistics.withPhysicalCount(42L);

    // Assert
    assertSame(immutableServerSummaryStatistics, actualWithPhysicalCountResult);
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withPhysicalCount(long)}.
   *
   * <ul>
   *   <li>Then return totalCount is six.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#withPhysicalCount(long)}
   */
  @Test
  @DisplayName("Test withPhysicalCount(long); then return totalCount is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withPhysicalCount(long)"
  })
  void testWithPhysicalCount_thenReturnTotalCountIsSix() {
    // Arrange, Act and Assert
    assertEquals(
        6L,
        ImmutableServerSummaryStatistics.builder()
            .physicalCount(3L)
            .virtualCount(3L)
            .build()
            .withPhysicalCount(42L)
            .totalCount());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withTotalCount(long)}.
   *
   * <ul>
   *   <li>Then return builder physicalCount three virtualCount three build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#withTotalCount(long)}
   */
  @Test
  @DisplayName(
      "Test withTotalCount(long); then return builder physicalCount three virtualCount three build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withTotalCount(long)"
  })
  void testWithTotalCount_thenReturnBuilderPhysicalCountThreeVirtualCountThreeBuild() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build();

    // Act
    ImmutableServerSummaryStatistics actualWithTotalCountResult =
        immutableServerSummaryStatistics.withTotalCount(6L);

    // Assert
    assertSame(immutableServerSummaryStatistics, actualWithTotalCountResult);
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withTotalCount(long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return totalCount is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#withTotalCount(long)}
   */
  @Test
  @DisplayName("Test withTotalCount(long); when forty-two; then return totalCount is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withTotalCount(long)"
  })
  void testWithTotalCount_whenFortyTwo_thenReturnTotalCountIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42L,
        ImmutableServerSummaryStatistics.builder()
            .physicalCount(3L)
            .virtualCount(3L)
            .build()
            .withTotalCount(42L)
            .totalCount());
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withVirtualCount(long)}.
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#withVirtualCount(long)}
   */
  @Test
  @DisplayName("Test withVirtualCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withVirtualCount(long)"
  })
  void testWithVirtualCount() {
    // Arrange
    ImmutableServerSummaryStatistics immutableServerSummaryStatistics =
        ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(42L).build();

    // Act
    ImmutableServerSummaryStatistics actualWithVirtualCountResult =
        immutableServerSummaryStatistics.withVirtualCount(42L);

    // Assert
    assertSame(immutableServerSummaryStatistics, actualWithVirtualCountResult);
  }

  /**
   * Test {@link ImmutableServerSummaryStatistics#withVirtualCount(long)}.
   *
   * <ul>
   *   <li>Then return totalCount is six.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerSummaryStatistics#withVirtualCount(long)}
   */
  @Test
  @DisplayName("Test withVirtualCount(long); then return totalCount is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerSummaryStatistics ImmutableServerSummaryStatistics.withVirtualCount(long)"
  })
  void testWithVirtualCount_thenReturnTotalCountIsSix() {
    // Arrange, Act and Assert
    assertEquals(
        6L,
        ImmutableServerSummaryStatistics.builder()
            .physicalCount(3L)
            .virtualCount(3L)
            .build()
            .withVirtualCount(42L)
            .totalCount());
  }
}
