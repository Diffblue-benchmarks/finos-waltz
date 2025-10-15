package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInfo.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllBackingEntities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllBackingEntities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllBackingEntities(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllBackingEntities(Iterable)"})
  void testBuilderAddAllBackingEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act
    Builder actualAddAllBackingEntitiesResult =
        builderResult.addAllBackingEntities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllBackingEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#addBackingEntities(BackingEntity)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableBackingEntity.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addBackingEntities(BackingEntity)}
   */
  @Test
  @DisplayName(
      "Test Builder addBackingEntities(BackingEntity) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addBackingEntities(BackingEntity)"})
  void testBuilderAddBackingEntitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act
    Builder actualAddBackingEntitiesResult =
        builderResult.addBackingEntities(new ImmutableBackingEntity.Json());

    // Assert
    assertSame(builderResult, actualAddBackingEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#addBackingEntities(BackingEntity[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableBackingEntity.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addBackingEntities(BackingEntity[])}
   */
  @Test
  @DisplayName(
      "Test Builder addBackingEntities(BackingEntity[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addBackingEntities(BackingEntity[])"})
  void testBuilderAddBackingEntitiesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act
    Builder actualAddBackingEntitiesResult =
        builderResult.addBackingEntities(new ImmutableBackingEntity.Json());

    // Assert
    assertSame(builderResult, actualAddBackingEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#backingEntities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#backingEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder backingEntities(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.backingEntities(Iterable)"})
  void testBuilderBackingEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act
    Builder actualBackingEntitiesResult = builderResult.backingEntities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualBackingEntitiesResult);
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
  @MethodsUnderTest({"ImmutableAggregateOverlayDiagramInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagram diagram =
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build();
    ImmutableAggregateOverlayDiagramInfo actualImmutableAggregateOverlayDiagramInfo =
        actualBuilderResult.diagram(diagram).build();

    // Assert
    assertTrue(actualImmutableAggregateOverlayDiagramInfo.backingEntities().isEmpty());
    assertSame(diagram, actualImmutableAggregateOverlayDiagramInfo.diagram());
  }

  /**
   * Test Builder {@link Builder#diagram(AggregateOverlayDiagram)}.
   *
   * <ul>
   *   <li>When {@link ImmutableAggregateOverlayDiagram.Json} (default constructor).
   *   <li>Then builder build diagram is {@link ImmutableAggregateOverlayDiagram.Json} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#diagram(AggregateOverlayDiagram)}
   */
  @Test
  @DisplayName(
      "Test Builder diagram(AggregateOverlayDiagram); when Json (default constructor); then builder build diagram is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagram(AggregateOverlayDiagram)"})
  void testBuilderDiagram_whenJson_thenBuilderBuildDiagramIsJson() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();

    // Act
    Builder actualDiagramResult = builderResult.diagram(diagram);

    // Assert
    assertSame(diagram, builderResult.build().diagram());
    assertSame(builderResult, actualDiagramResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramInfo)}.
   *
   * <p>Method under test: {@link Builder#from(AggregateOverlayDiagramInfo)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagramInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    Builder builderResult2 = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagramInfo instance =
        builderResult2
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregateOverlayDiagramInfo actualImmutableAggregateOverlayDiagramInfo =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramInfo)}.
   *
   * <p>Method under test: {@link Builder#from(AggregateOverlayDiagramInfo)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagramInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    Builder builderResult2 = ImmutableAggregateOverlayDiagramInfo.builder();

    ImmutableBackingEntity.Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    builderResult2.addBackingEntities(
        cellIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableAggregateOverlayDiagramInfo instance =
        builderResult2
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregateOverlayDiagramInfo actualImmutableAggregateOverlayDiagramInfo =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#copyOf(AggregateOverlayDiagramInfo)}.
   *
   * <ul>
   *   <li>Then diagram return {@link ImmutableAggregateOverlayDiagram}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramInfo#copyOf(AggregateOverlayDiagramInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AggregateOverlayDiagramInfo); then diagram return ImmutableAggregateOverlayDiagram")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInfo ImmutableAggregateOverlayDiagramInfo.copyOf(AggregateOverlayDiagramInfo)"
  })
  void testCopyOf_thenDiagramReturnImmutableAggregateOverlayDiagram() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAggregateOverlayDiagramInfo instance =
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(ofResult.atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInfo actualCopyOfResult =
        ImmutableAggregateOverlayDiagramInfo.copyOf(instance);

    // Assert
    AggregateOverlayDiagram diagramResult = actualCopyOfResult.diagram();
    assertTrue(diagramResult instanceof ImmutableAggregateOverlayDiagram);
    assertEquals("2020-03-01", diagramResult.lastUpdatedBy());
    assertEquals("Layout Data", diagramResult.layoutData());
    assertEquals("Name", diagramResult.name());
    assertEquals("Provenance", diagramResult.provenance());
    assertEquals("The characteristics of someone or something", diagramResult.description());
    assertEquals(EntityKind.ALL, diagramResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, diagramResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, diagramResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, diagramResult.diagramKind());
    assertTrue(actualCopyOfResult.backingEntities().isEmpty());
    assertSame(ofResult, diagramResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagramInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagramInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInfo.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagramInfo immutableAggregateOverlayDiagramInfo =
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagramInfo immutableAggregateOverlayDiagramInfo2 =
        builderResult2
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAggregateOverlayDiagramInfo, immutableAggregateOverlayDiagramInfo2);
    assertEquals(
        immutableAggregateOverlayDiagramInfo.hashCode(),
        immutableAggregateOverlayDiagramInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagramInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagramInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInfo.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagramInfo immutableAggregateOverlayDiagramInfo =
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAggregateOverlayDiagramInfo, immutableAggregateOverlayDiagramInfo);
    int expectedHashCodeResult = immutableAggregateOverlayDiagramInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableAggregateOverlayDiagramInfo.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInfo.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    ImmutableBackingEntity.Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    builderResult.addBackingEntities(
        cellIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableAggregateOverlayDiagramInfo immutableAggregateOverlayDiagramInfo =
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInfo,
        builderResult2
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInfo.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagramInfo immutableAggregateOverlayDiagramInfo =
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ACTOR)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInfo,
        builderResult2
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInfo.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInfo.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build(),
        "Different type to ImmutableAggregateOverlayDiagramInfo");
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) BackingEntities is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) BackingEntities is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInfo ImmutableAggregateOverlayDiagramInfo.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonBackingEntitiesIsHashSet() {
    // Arrange
    Json json = new Json();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();
    json.setDiagram(diagram);
    json.setBackingEntities(new HashSet<>());

    // Act
    ImmutableAggregateOverlayDiagramInfo actualFromJsonResult =
        ImmutableAggregateOverlayDiagramInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.backingEntities().isEmpty());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableBackingEntity.Json}
   *       (default constructor).
   *   <li>Then return backingEntities size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return backingEntities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInfo ImmutableAggregateOverlayDiagramInfo.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnBackingEntitiesSizeIsOne() {
    // Arrange
    LinkedHashSet<BackingEntity> backingEntities = new LinkedHashSet<>();
    backingEntities.add(new ImmutableBackingEntity.Json());

    Json json = new Json();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();
    json.setDiagram(diagram);
    json.setBackingEntities(backingEntities);

    // Act
    ImmutableAggregateOverlayDiagramInfo actualFromJsonResult =
        ImmutableAggregateOverlayDiagramInfo.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.backingEntities().size());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return backingEntities is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return backingEntities is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInfo ImmutableAggregateOverlayDiagramInfo.fromJson(Json)"
  })
  void testFromJson_thenReturnBackingEntitiesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<BackingEntity> backingEntities = new LinkedHashSet<>();

    ImmutableBackingEntity.Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    backingEntities.add(
        cellIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    backingEntities.add(new ImmutableBackingEntity.Json());

    Json json = new Json();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();
    json.setDiagram(diagram);
    json.setBackingEntities(backingEntities);

    // Act
    ImmutableAggregateOverlayDiagramInfo actualFromJsonResult =
        ImmutableAggregateOverlayDiagramInfo.fromJson(json);

    // Assert
    assertEquals(backingEntities, actualFromJsonResult.backingEntities());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) BackingEntities is {@code null}.
   *   <li>Then return backingEntities Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) BackingEntities is 'null'; then return backingEntities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInfo ImmutableAggregateOverlayDiagramInfo.fromJson(Json)"
  })
  void testFromJson_whenJsonBackingEntitiesIsNull_thenReturnBackingEntitiesEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();
    json.setDiagram(diagram);
    json.setBackingEntities(null);

    // Act
    ImmutableAggregateOverlayDiagramInfo actualFromJsonResult =
        ImmutableAggregateOverlayDiagramInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.backingEntities().isEmpty());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramInfo#toString()}
   *   <li>{@link ImmutableAggregateOverlayDiagramInfo#backingEntities()}
   *   <li>{@link ImmutableAggregateOverlayDiagramInfo#diagram()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAggregateOverlayDiagramInfo.backingEntities()",
    "AggregateOverlayDiagram ImmutableAggregateOverlayDiagramInfo.diagram()",
    "String ImmutableAggregateOverlayDiagramInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagramInfo immutableAggregateOverlayDiagramInfo =
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableAggregateOverlayDiagramInfo.toString();
    Set<BackingEntity> actualBackingEntitiesResult =
        immutableAggregateOverlayDiagramInfo.backingEntities();

    // Assert
    assertTrue(
        immutableAggregateOverlayDiagramInfo.diagram() instanceof ImmutableAggregateOverlayDiagram);
    assertEquals(
        "AggregateOverlayDiagramInfo{diagram=AggregateOverlayDiagram{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00,"
            + " lastUpdatedBy=2020-03-01, provenance=Provenance, layoutData=Layout Data, aggregatedEntityKind=ALL,"
            + " diagramKind=WALTZ_ENTITY_OVERLAY, status=DRAFT, kind=ALL}, backingEntities=[]}",
        actualToStringResult);
    assertTrue(actualBackingEntitiesResult.isEmpty());
  }

  /**
   * Test Json {@link Json#backingEntities()}.
   *
   * <p>Method under test: {@link Json#backingEntities()}
   */
  @Test
  @DisplayName("Test Json backingEntities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.backingEntities()"})
  void testJsonBackingEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().backingEntities());
  }

  /**
   * Test Json {@link Json#diagram()}.
   *
   * <p>Method under test: {@link Json#diagram()}
   */
  @Test
  @DisplayName("Test Json diagram()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AggregateOverlayDiagram Json.diagram()"})
  void testJsonDiagram() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagram());
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
    assertNull(actualJson.diagram);
    assertTrue(actualJson.backingEntities.isEmpty());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#withBackingEntities(BackingEntity[])} with
   * {@code BackingEntity[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramInfo#withBackingEntities(BackingEntity[])}
   */
  @Test
  @DisplayName("Test withBackingEntities(BackingEntity[]) with 'BackingEntity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInfo ImmutableAggregateOverlayDiagramInfo.withBackingEntities(BackingEntity[])"
  })
  void testWithBackingEntitiesWithBackingEntity() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAggregateOverlayDiagramInfo immutableAggregateOverlayDiagramInfo =
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(ofResult.atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    ImmutableBackingEntity.Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");

    // Act
    ImmutableAggregateOverlayDiagramInfo actualWithBackingEntitiesResult =
        immutableAggregateOverlayDiagramInfo.withBackingEntities(
            cellIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Assert
    AggregateOverlayDiagram diagramResult = actualWithBackingEntitiesResult.diagram();
    assertTrue(diagramResult instanceof ImmutableAggregateOverlayDiagram);
    assertEquals("2020-03-01", diagramResult.lastUpdatedBy());
    assertEquals("Layout Data", diagramResult.layoutData());
    assertEquals("Name", diagramResult.name());
    assertEquals("Provenance", diagramResult.provenance());
    assertEquals("The characteristics of someone or something", diagramResult.description());
    assertEquals(1, actualWithBackingEntitiesResult.backingEntities().size());
    assertEquals(EntityKind.ALL, diagramResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, diagramResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, diagramResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, diagramResult.diagramKind());
    assertSame(ofResult, diagramResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInfo#withDiagram(AggregateOverlayDiagram)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramInfo#withDiagram(AggregateOverlayDiagram)}
   */
  @Test
  @DisplayName("Test withDiagram(AggregateOverlayDiagram)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInfo ImmutableAggregateOverlayDiagramInfo.withDiagram(AggregateOverlayDiagram)"
  })
  void testWithDiagram() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagramInfo immutableAggregateOverlayDiagramInfo =
        builderResult
            .diagram(
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build())
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInfo actualWithDiagramResult =
        immutableAggregateOverlayDiagramInfo.withDiagram(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.ALL)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    // Assert
    assertEquals(immutableAggregateOverlayDiagramInfo, actualWithDiagramResult);
  }
}
