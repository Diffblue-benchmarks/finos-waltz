package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowStatistics.Builder;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowStatistics.Json;
import org.finos.waltz.model.tally.ImmutableTallyPack;
import org.finos.waltz.model.tally.TallyPack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDataTypeCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDataTypeCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDataTypeCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDataTypeCounts(Iterable)"})
  void testBuilderAddAllDataTypeCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act
    Builder actualAddAllDataTypeCountsResult =
        builderResult.addAllDataTypeCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDataTypeCountsResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypeCounts(TallyPack)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypeCounts(TallyPack)}
   */
  @Test
  @DisplayName("Test Builder addDataTypeCounts(TallyPack) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypeCounts(TallyPack)"})
  void testBuilderAddDataTypeCountsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    ImmutableTallyPack.Builder<String> builderResult2 = ImmutableTallyPack.builder();

    // Act
    Builder actualAddDataTypeCountsResult =
        builderResult.addDataTypeCounts(
            builderResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .build());

    // Assert
    assertSame(builderResult, actualAddDataTypeCountsResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypeCounts(TallyPack[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypeCounts(TallyPack[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypeCounts(TallyPack[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypeCounts(TallyPack[])"})
  void testBuilderAddDataTypeCountsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    ImmutableTallyPack.Builder<String> builderResult2 = ImmutableTallyPack.builder();

    // Act
    Builder actualAddDataTypeCountsResult =
        builderResult.addDataTypeCounts(
            builderResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .build());

    // Assert
    assertSame(builderResult, actualAddDataTypeCountsResult);
  }

  /**
   * Test Builder {@link Builder#appCounts(LogicalFlowMeasures)}.
   *
   * <ul>
   *   <li>When {@link ImmutableLogicalFlowMeasures.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#appCounts(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName(
      "Test Builder appCounts(LogicalFlowMeasures); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appCounts(LogicalFlowMeasures)"})
  void testBuilderAppCounts_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act
    Builder actualAppCountsResult =
        builderResult.appCounts(new ImmutableLogicalFlowMeasures.Json());

    // Assert
    assertSame(builderResult, actualAppCountsResult);
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
  @MethodsUnderTest({"ImmutableLogicalFlowStatistics Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableLogicalFlowStatistics.builder();
    ImmutableLogicalFlowMeasures appCounts =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();
    Builder actualAppCountsResult = actualBuilderResult.appCounts(appCounts);
    ImmutableLogicalFlowMeasures flowCounts =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();
    ImmutableLogicalFlowStatistics actualImmutableLogicalFlowStatistics =
        actualAppCountsResult.flowCounts(flowCounts).build();

    // Assert
    assertTrue(actualImmutableLogicalFlowStatistics.dataTypeCounts().isEmpty());
    assertSame(appCounts, actualImmutableLogicalFlowStatistics.appCounts());
    assertSame(flowCounts, actualImmutableLogicalFlowStatistics.flowCounts());
  }

  /**
   * Test Builder {@link Builder#dataTypeCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataTypeCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypeCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeCounts(Iterable)"})
  void testBuilderDataTypeCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act
    Builder actualDataTypeCountsResult = builderResult.dataTypeCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDataTypeCountsResult);
  }

  /**
   * Test Builder {@link Builder#flowCounts(LogicalFlowMeasures)}.
   *
   * <ul>
   *   <li>When {@link ImmutableLogicalFlowMeasures.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#flowCounts(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName(
      "Test Builder flowCounts(LogicalFlowMeasures); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowCounts(LogicalFlowMeasures)"})
  void testBuilderFlowCounts_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act
    Builder actualFlowCountsResult =
        builderResult.flowCounts(new ImmutableLogicalFlowMeasures.Json());

    // Assert
    assertSame(builderResult, actualFlowCountsResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowStatistics)}.
   *
   * <p>Method under test: {@link Builder#from(LogicalFlowStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowStatistics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowStatistics)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder builderResult2 = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult2.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics instance =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalFlowStatistics actualImmutableLogicalFlowStatistics = builderResult.build();
    assertEquals(instance, actualImmutableLogicalFlowStatistics);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowStatistics)}.
   *
   * <ul>
   *   <li>Then return build dataTypeCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LogicalFlowStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LogicalFlowStatistics); then return build dataTypeCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowStatistics)"})
  void testBuilderFrom_thenReturnBuildDataTypeCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder builderResult2 = ImmutableLogicalFlowStatistics.builder();

    ImmutableTallyPack.Builder<String> builderResult3 = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    builderResult2.addDataTypeCounts(
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(ofResult.atStartOfDay())
            .build());

    Builder appCountsResult =
        builderResult2.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());

    // Act and Assert
    List<TallyPack<String>> dataTypeCountsResult =
        builderResult
            .from(
                appCountsResult
                    .flowCounts(
                        ImmutableLogicalFlowMeasures.builder()
                            .inbound(10.0d)
                            .intra(10.0d)
                            .outbound(10.0d)
                            .build())
                    .build())
            .build()
            .dataTypeCounts();
    assertEquals(1, dataTypeCountsResult.size());
    TallyPack<String> getResult = dataTypeCountsResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableTallyPack);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(getResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#copyOf(LogicalFlowStatistics)}.
   *
   * <ul>
   *   <li>Then appCounts return {@link ImmutableLogicalFlowMeasures}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#copyOf(LogicalFlowStatistics)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LogicalFlowStatistics); then appCounts return ImmutableLogicalFlowMeasures")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowStatistics ImmutableLogicalFlowStatistics.copyOf(LogicalFlowStatistics)"
  })
  void testCopyOf_thenAppCountsReturnImmutableLogicalFlowMeasures() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics instance =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowStatistics actualCopyOfResult =
        ImmutableLogicalFlowStatistics.copyOf(instance);

    // Assert
    LogicalFlowMeasures appCountsResult2 = actualCopyOfResult.appCounts();
    assertTrue(appCountsResult2 instanceof ImmutableLogicalFlowMeasures);
    LogicalFlowMeasures flowCountsResult = actualCopyOfResult.flowCounts();
    assertTrue(flowCountsResult instanceof ImmutableLogicalFlowMeasures);
    assertEquals(10.0d, appCountsResult2.inbound());
    assertEquals(10.0d, appCountsResult2.intra());
    assertEquals(10.0d, appCountsResult2.outbound());
    assertTrue(actualCopyOfResult.dataTypeCounts().isEmpty());
    assertEquals(appCountsResult2, flowCountsResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#equals(Object)}, and {@link
   * ImmutableLogicalFlowStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowStatistics#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowStatistics.equals(Object)",
    "int ImmutableLogicalFlowStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    Builder builderResult2 = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult2 =
        builderResult2.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics2 =
        appCountsResult2
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLogicalFlowStatistics, immutableLogicalFlowStatistics2);
    assertEquals(
        immutableLogicalFlowStatistics.hashCode(), immutableLogicalFlowStatistics2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#equals(Object)}, and {@link
   * ImmutableLogicalFlowStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowStatistics#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowStatistics.equals(Object)",
    "int ImmutableLogicalFlowStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLogicalFlowStatistics, immutableLogicalFlowStatistics);
    int expectedHashCodeResult = immutableLogicalFlowStatistics.hashCode();
    assertEquals(expectedHashCodeResult, immutableLogicalFlowStatistics.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowStatistics.equals(Object)",
    "int ImmutableLogicalFlowStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    ImmutableTallyPack.Builder<String> builderResult2 = ImmutableTallyPack.builder();
    builderResult.addDataTypeCounts(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    Builder builderResult3 = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult2 =
        builderResult3.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowStatistics,
        appCountsResult2
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowStatistics.equals(Object)",
    "int ImmutableLogicalFlowStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(0.5d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    Builder builderResult2 = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult2 =
        builderResult2.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowStatistics,
        appCountsResult2
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowStatistics.equals(Object)",
    "int ImmutableLogicalFlowStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(0.5d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    Builder builderResult2 = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult2 =
        builderResult2.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowStatistics,
        appCountsResult2
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowStatistics.equals(Object)",
    "int ImmutableLogicalFlowStatistics.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());

    // Act and Assert
    assertNotEquals(
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowStatistics.equals(Object)",
    "int ImmutableLogicalFlowStatistics.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());

    // Act and Assert
    assertNotEquals(
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build(),
        "Different type to ImmutableLogicalFlowStatistics");
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return dataTypeCounts Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return dataTypeCounts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowStatistics ImmutableLogicalFlowStatistics.fromJson(Json)"
  })
  void testFromJson_givenArrayList_thenReturnDataTypeCountsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableLogicalFlowMeasures.Json appCounts = new ImmutableLogicalFlowMeasures.Json();
    json.setAppCounts(appCounts);
    ImmutableLogicalFlowMeasures.Json flowCounts = new ImmutableLogicalFlowMeasures.Json();
    json.setFlowCounts(flowCounts);
    json.setDataTypeCounts(new ArrayList<>());

    // Act
    ImmutableLogicalFlowStatistics actualFromJsonResult =
        ImmutableLogicalFlowStatistics.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.dataTypeCounts().isEmpty());
    assertSame(appCounts, actualFromJsonResult.appCounts());
    assertSame(flowCounts, actualFromJsonResult.flowCounts());
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then appCounts return {@link ImmutableLogicalFlowMeasures}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then appCounts return ImmutableLogicalFlowMeasures")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowStatistics ImmutableLogicalFlowStatistics.fromJson(Json)"
  })
  void testFromJson_thenAppCountsReturnImmutableLogicalFlowMeasures() {
    // Arrange
    ArrayList<TallyPack<String>> dataTypeCounts = new ArrayList<>();

    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();
    dataTypeCounts.add(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());

    Json json = new Json();
    json.setAppCounts(
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build());
    json.setFlowCounts(
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build());
    json.setDataTypeCounts(dataTypeCounts);

    // Act
    ImmutableLogicalFlowStatistics actualFromJsonResult =
        ImmutableLogicalFlowStatistics.fromJson(json);

    // Assert
    LogicalFlowMeasures appCountsResult = actualFromJsonResult.appCounts();
    assertTrue(appCountsResult instanceof ImmutableLogicalFlowMeasures);
    assertTrue(actualFromJsonResult.flowCounts() instanceof ImmutableLogicalFlowMeasures);
    assertEquals(10.0d, appCountsResult.inbound());
    assertEquals(10.0d, appCountsResult.intra());
    assertEquals(10.0d, appCountsResult.outbound());
    assertEquals(dataTypeCounts, actualFromJsonResult.dataTypeCounts());
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return dataTypeCounts size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return dataTypeCounts size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowStatistics ImmutableLogicalFlowStatistics.fromJson(Json)"
  })
  void testFromJson_thenReturnDataTypeCountsSizeIsTwo() {
    // Arrange
    ArrayList<TallyPack<String>> dataTypeCounts = new ArrayList<>();

    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();
    dataTypeCounts.add(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());

    ImmutableTallyPack.Builder<String> builderResult2 = ImmutableTallyPack.builder();
    dataTypeCounts.add(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());

    Json json = new Json();
    json.setAppCounts(
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build());
    json.setFlowCounts(
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build());
    json.setDataTypeCounts(dataTypeCounts);

    // Act
    ImmutableLogicalFlowStatistics actualFromJsonResult =
        ImmutableLogicalFlowStatistics.fromJson(json);

    // Assert
    List<TallyPack<String>> dataTypeCountsResult = actualFromJsonResult.dataTypeCounts();
    assertEquals(2, dataTypeCountsResult.size());
    TallyPack<String> getResult = dataTypeCountsResult.get(1);
    assertTrue(getResult instanceof ImmutableTallyPack);
    assertEquals(dataTypeCountsResult.get(0), getResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) DataTypeCounts is {@code null}.
   *   <li>Then return dataTypeCounts Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) DataTypeCounts is 'null'; then return dataTypeCounts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowStatistics ImmutableLogicalFlowStatistics.fromJson(Json)"
  })
  void testFromJson_whenJsonDataTypeCountsIsNull_thenReturnDataTypeCountsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableLogicalFlowMeasures.Json appCounts = new ImmutableLogicalFlowMeasures.Json();
    json.setAppCounts(appCounts);
    ImmutableLogicalFlowMeasures.Json flowCounts = new ImmutableLogicalFlowMeasures.Json();
    json.setFlowCounts(flowCounts);
    json.setDataTypeCounts(null);

    // Act
    ImmutableLogicalFlowStatistics actualFromJsonResult =
        ImmutableLogicalFlowStatistics.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.dataTypeCounts().isEmpty());
    assertSame(appCounts, actualFromJsonResult.appCounts());
    assertSame(flowCounts, actualFromJsonResult.flowCounts());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowStatistics#toString()}
   *   <li>{@link ImmutableLogicalFlowStatistics#appCounts()}
   *   <li>{@link ImmutableLogicalFlowStatistics#dataTypeCounts()}
   *   <li>{@link ImmutableLogicalFlowStatistics#flowCounts()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LogicalFlowMeasures ImmutableLogicalFlowStatistics.appCounts()",
    "List ImmutableLogicalFlowStatistics.dataTypeCounts()",
    "LogicalFlowMeasures ImmutableLogicalFlowStatistics.flowCounts()",
    "String ImmutableLogicalFlowStatistics.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableLogicalFlowStatistics.toString();
    LogicalFlowMeasures actualAppCountsResult = immutableLogicalFlowStatistics.appCounts();
    List<TallyPack<String>> actualDataTypeCountsResult =
        immutableLogicalFlowStatistics.dataTypeCounts();
    LogicalFlowMeasures actualFlowCountsResult = immutableLogicalFlowStatistics.flowCounts();

    // Assert
    assertTrue(actualAppCountsResult instanceof ImmutableLogicalFlowMeasures);
    assertTrue(actualFlowCountsResult instanceof ImmutableLogicalFlowMeasures);
    assertEquals(
        "LogicalFlowStatistics{appCounts=LogicalFlowMeasures{inbound=10.0, outbound=10.0, intra=10.0},"
            + " flowCounts=LogicalFlowMeasures{inbound=10.0, outbound=10.0, intra=10.0}, dataTypeCounts=[]}",
        actualToStringResult);
    assertTrue(actualDataTypeCountsResult.isEmpty());
    assertEquals(actualAppCountsResult, actualFlowCountsResult);
  }

  /**
   * Test Json {@link Json#appCounts()}.
   *
   * <p>Method under test: {@link Json#appCounts()}
   */
  @Test
  @DisplayName("Test Json appCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowMeasures Json.appCounts()"})
  void testJsonAppCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appCounts());
  }

  /**
   * Test Json {@link Json#dataTypeCounts()}.
   *
   * <p>Method under test: {@link Json#dataTypeCounts()}
   */
  @Test
  @DisplayName("Test Json dataTypeCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.dataTypeCounts()"})
  void testJsonDataTypeCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeCounts());
  }

  /**
   * Test Json {@link Json#flowCounts()}.
   *
   * <p>Method under test: {@link Json#flowCounts()}
   */
  @Test
  @DisplayName("Test Json flowCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowMeasures Json.flowCounts()"})
  void testJsonFlowCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowCounts());
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
    assertNull(actualJson.appCounts);
    assertNull(actualJson.flowCounts);
    assertTrue(actualJson.dataTypeCounts.isEmpty());
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#withAppCounts(LogicalFlowMeasures)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#withAppCounts(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName("Test withAppCounts(LogicalFlowMeasures)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowStatistics ImmutableLogicalFlowStatistics.withAppCounts(LogicalFlowMeasures)"
  })
  void testWithAppCounts() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowStatistics actualWithAppCountsResult =
        immutableLogicalFlowStatistics.withAppCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());

    // Assert
    assertEquals(immutableLogicalFlowStatistics, actualWithAppCountsResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#withDataTypeCounts(TallyPack[])} with {@code
   * TallyPack[]}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowStatistics#withDataTypeCounts(TallyPack[])}
   */
  @Test
  @DisplayName("Test withDataTypeCounts(TallyPack[]) with 'TallyPack[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowStatistics ImmutableLogicalFlowStatistics.withDataTypeCounts(TallyPack[])"
  })
  void testWithDataTypeCountsWithTallyPack() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    ImmutableTallyPack.Builder<String> builderResult2 = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLogicalFlowStatistics actualWithDataTypeCountsResult =
        immutableLogicalFlowStatistics.withDataTypeCounts(
            builderResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(ofResult.atStartOfDay())
                .build());

    // Assert
    List<TallyPack<String>> dataTypeCountsResult = actualWithDataTypeCountsResult.dataTypeCounts();
    assertEquals(1, dataTypeCountsResult.size());
    TallyPack<String> getResult = dataTypeCountsResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LogicalFlowMeasures appCountsResult2 = actualWithDataTypeCountsResult.appCounts();
    assertTrue(appCountsResult2 instanceof ImmutableLogicalFlowMeasures);
    LogicalFlowMeasures flowCountsResult = actualWithDataTypeCountsResult.flowCounts();
    assertTrue(flowCountsResult instanceof ImmutableLogicalFlowMeasures);
    assertTrue(getResult instanceof ImmutableTallyPack);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(10.0d, appCountsResult2.inbound());
    assertEquals(10.0d, appCountsResult2.intra());
    assertEquals(10.0d, appCountsResult2.outbound());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(getResult.tallies().isEmpty());
    assertEquals(appCountsResult2, flowCountsResult);
    assertSame(ofResult, getResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLogicalFlowStatistics#withFlowCounts(LogicalFlowMeasures)}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowStatistics#withFlowCounts(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName("Test withFlowCounts(LogicalFlowMeasures)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowStatistics ImmutableLogicalFlowStatistics.withFlowCounts(LogicalFlowMeasures)"
  })
  void testWithFlowCounts() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    Builder appCountsResult =
        builderResult.appCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());
    ImmutableLogicalFlowStatistics immutableLogicalFlowStatistics =
        appCountsResult
            .flowCounts(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowStatistics actualWithFlowCountsResult =
        immutableLogicalFlowStatistics.withFlowCounts(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());

    // Assert
    assertEquals(immutableLogicalFlowStatistics, actualWithFlowCountsResult);
  }
}
