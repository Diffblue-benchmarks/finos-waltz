package org.finos.waltz.model.process_diagram;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramAndEntities.Builder;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramAndEntities.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramAndEntitiesDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllEntities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntities(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEntities(Iterable)"})
  void testBuilderAddAllEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act
    Builder actualAddAllEntitiesResult = builderResult.addAllEntities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#addEntities(ProcessDiagramEntity)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableProcessDiagramEntity.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addEntities(ProcessDiagramEntity)}
   */
  @Test
  @DisplayName(
      "Test Builder addEntities(ProcessDiagramEntity) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntities(ProcessDiagramEntity)"})
  void testBuilderAddEntitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act
    Builder actualAddEntitiesResult =
        builderResult.addEntities(new ImmutableProcessDiagramEntity.Json());

    // Assert
    assertSame(builderResult, actualAddEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#addEntities(ProcessDiagramEntity[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableProcessDiagramEntity.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addEntities(ProcessDiagramEntity[])}
   */
  @Test
  @DisplayName(
      "Test Builder addEntities(ProcessDiagramEntity[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntities(ProcessDiagramEntity[])"})
  void testBuilderAddEntitiesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act
    Builder actualAddEntitiesResult =
        builderResult.addEntities(new ImmutableProcessDiagramEntity.Json());

    // Assert
    assertSame(builderResult, actualAddEntitiesResult);
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
  @MethodsUnderTest({"ImmutableProcessDiagramAndEntities Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagram diagram =
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build();
    ImmutableProcessDiagramAndEntities actualImmutableProcessDiagramAndEntities =
        actualBuilderResult.diagram(diagram).build();

    // Assert
    assertTrue(actualImmutableProcessDiagramAndEntities.entities().isEmpty());
    assertSame(diagram, actualImmutableProcessDiagramAndEntities.diagram());
  }

  /**
   * Test Builder {@link Builder#diagram(ProcessDiagram)}.
   *
   * <ul>
   *   <li>When {@link ImmutableProcessDiagram.Json} (default constructor).
   *   <li>Then builder build diagram is {@link ImmutableProcessDiagram.Json} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#diagram(ProcessDiagram)}
   */
  @Test
  @DisplayName(
      "Test Builder diagram(ProcessDiagram); when Json (default constructor); then builder build diagram is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagram(ProcessDiagram)"})
  void testBuilderDiagram_whenJson_thenBuilderBuildDiagramIsJson() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();

    // Act
    Builder actualDiagramResult = builderResult.diagram(diagram);

    // Assert
    assertSame(diagram, builderResult.build().diagram());
    assertSame(builderResult, actualDiagramResult);
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act
    Builder actualEntitiesResult = builderResult.entities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramAndEntities)}.
   *
   * <p>Method under test: {@link Builder#from(ProcessDiagramAndEntities)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramAndEntities)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramAndEntities)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    Builder builderResult2 = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagramAndEntities instance =
        builderResult2
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableProcessDiagramAndEntities actualImmutableProcessDiagramAndEntities =
        builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagramAndEntities);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramAndEntities)}.
   *
   * <p>Method under test: {@link Builder#from(ProcessDiagramAndEntities)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramAndEntities)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramAndEntities)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    Builder builderResult2 = ImmutableProcessDiagramAndEntities.builder();

    ImmutableProcessDiagramEntity.Builder diagramIdResult =
        ImmutableProcessDiagramEntity.builder().diagramId(1L);
    builderResult2.addEntities(
        diagramIdResult
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
    ImmutableProcessDiagramAndEntities instance =
        builderResult2
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableProcessDiagramAndEntities actualImmutableProcessDiagramAndEntities =
        builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagramAndEntities);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#copyOf(ProcessDiagramAndEntities)}.
   *
   * <ul>
   *   <li>Then diagram return {@link ImmutableProcessDiagram}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableProcessDiagramAndEntities#copyOf(ProcessDiagramAndEntities)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ProcessDiagramAndEntities); then diagram return ImmutableProcessDiagram")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramAndEntities ImmutableProcessDiagramAndEntities.copyOf(ProcessDiagramAndEntities)"
  })
  void testCopyOf_thenDiagramReturnImmutableProcessDiagram() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    ImmutableProcessDiagramAndEntities instance =
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(ofResult.atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(ofResult2.atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableProcessDiagramAndEntities actualCopyOfResult =
        ImmutableProcessDiagramAndEntities.copyOf(instance);

    // Assert
    ProcessDiagram diagramResult = actualCopyOfResult.diagram();
    assertTrue(diagramResult instanceof ImmutableProcessDiagram);
    assertEquals("2020-03-01", diagramResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", diagramResult.createdBy());
    assertEquals("Name", diagramResult.name());
    assertEquals("Provenance", diagramResult.provenance());
    assertEquals("The characteristics of someone or something", diagramResult.description());
    assertEquals(EntityKind.ALL, diagramResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, diagramResult.diagramKind());
    assertTrue(actualCopyOfResult.entities().isEmpty());
    assertSame(ofResult, diagramResult.createdAt().toLocalDate());
    assertSame(ofResult2, diagramResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#equals(Object)}, and {@link
   * ImmutableProcessDiagramAndEntities#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagramAndEntities#equals(Object)}
   *   <li>{@link ImmutableProcessDiagramAndEntities#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramAndEntities.equals(Object)",
    "int ImmutableProcessDiagramAndEntities.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagramAndEntities immutableProcessDiagramAndEntities =
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagramAndEntities immutableProcessDiagramAndEntities2 =
        builderResult2
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableProcessDiagramAndEntities, immutableProcessDiagramAndEntities2);
    assertEquals(
        immutableProcessDiagramAndEntities.hashCode(),
        immutableProcessDiagramAndEntities2.hashCode());
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#equals(Object)}, and {@link
   * ImmutableProcessDiagramAndEntities#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagramAndEntities#equals(Object)}
   *   <li>{@link ImmutableProcessDiagramAndEntities#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramAndEntities.equals(Object)",
    "int ImmutableProcessDiagramAndEntities.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagramAndEntities immutableProcessDiagramAndEntities =
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableProcessDiagramAndEntities, immutableProcessDiagramAndEntities);
    int expectedHashCodeResult = immutableProcessDiagramAndEntities.hashCode();
    assertEquals(expectedHashCodeResult, immutableProcessDiagramAndEntities.hashCode());
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramAndEntities#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramAndEntities.equals(Object)",
    "int ImmutableProcessDiagramAndEntities.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    ImmutableProcessDiagramEntity.Builder diagramIdResult =
        ImmutableProcessDiagramEntity.builder().diagramId(1L);
    builderResult.addEntities(
        diagramIdResult
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
    ImmutableProcessDiagramAndEntities immutableProcessDiagramAndEntities =
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagramAndEntities,
        builderResult2
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramAndEntities#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramAndEntities.equals(Object)",
    "int ImmutableProcessDiagramAndEntities.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagramAndEntities immutableProcessDiagramAndEntities =
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.now().atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagramAndEntities,
        builderResult2
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramAndEntities#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramAndEntities.equals(Object)",
    "int ImmutableProcessDiagramAndEntities.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramAndEntities#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramAndEntities.equals(Object)",
    "int ImmutableProcessDiagramAndEntities.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build(),
        "Different type to ImmutableProcessDiagramAndEntities");
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Entities is {@link HashSet#HashSet()}.
   *   <li>Then return entities Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramAndEntities#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Entities is HashSet(); then return entities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramAndEntities ImmutableProcessDiagramAndEntities.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonEntitiesIsHashSet_thenReturnEntitiesEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();
    json.setDiagram(diagram);
    json.setEntities(new HashSet<>());

    // Act
    ImmutableProcessDiagramAndEntities actualFromJsonResult =
        ImmutableProcessDiagramAndEntities.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.entities().isEmpty());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableProcessDiagramEntity.Json} (default constructor).
   *   <li>Then return entities size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramAndEntities#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return entities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramAndEntities ImmutableProcessDiagramAndEntities.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnEntitiesSizeIsOne() {
    // Arrange
    LinkedHashSet<ProcessDiagramEntity> entities = new LinkedHashSet<>();
    entities.add(new ImmutableProcessDiagramEntity.Json());

    Json json = new Json();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();
    json.setDiagram(diagram);
    json.setEntities(entities);

    // Act
    ImmutableProcessDiagramAndEntities actualFromJsonResult =
        ImmutableProcessDiagramAndEntities.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.entities().size());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Entities is {@code null}.
   *   <li>Then return entities Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramAndEntities#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Entities is 'null'; then return entities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramAndEntities ImmutableProcessDiagramAndEntities.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonEntitiesIsNull_thenReturnEntitiesEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();
    json.setDiagram(diagram);
    json.setEntities(null);

    // Act
    ImmutableProcessDiagramAndEntities actualFromJsonResult =
        ImmutableProcessDiagramAndEntities.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.entities().isEmpty());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return entities is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramAndEntities#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return entities is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramAndEntities ImmutableProcessDiagramAndEntities.fromJson(Json)"
  })
  void testFromJson_thenReturnEntitiesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<ProcessDiagramEntity> entities = new LinkedHashSet<>();

    ImmutableProcessDiagramEntity.Builder diagramIdResult =
        ImmutableProcessDiagramEntity.builder().diagramId(1L);
    entities.add(
        diagramIdResult
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
    entities.add(new ImmutableProcessDiagramEntity.Json());

    Json json = new Json();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();
    json.setDiagram(diagram);
    json.setEntities(entities);

    // Act
    ImmutableProcessDiagramAndEntities actualFromJsonResult =
        ImmutableProcessDiagramAndEntities.fromJson(json);

    // Assert
    assertEquals(entities, actualFromJsonResult.entities());
    assertSame(diagram, actualFromJsonResult.diagram());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagramAndEntities#toString()}
   *   <li>{@link ImmutableProcessDiagramAndEntities#diagram()}
   *   <li>{@link ImmutableProcessDiagramAndEntities#entities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessDiagram ImmutableProcessDiagramAndEntities.diagram()",
    "java.util.Set ImmutableProcessDiagramAndEntities.entities()",
    "String ImmutableProcessDiagramAndEntities.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagramAndEntities immutableProcessDiagramAndEntities =
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableProcessDiagramAndEntities.toString();
    ProcessDiagram actualDiagramResult = immutableProcessDiagramAndEntities.diagram();

    // Assert
    assertTrue(actualDiagramResult instanceof ImmutableProcessDiagram);
    assertEquals(
        "ProcessDiagramAndEntities{diagram=ProcessDiagram{id=1, name=Name, externalId=42, provenance=Provenance,"
            + " lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, createdAt=1970-01-01T00:00, createdBy=Jan"
            + " 1, 2020 8:00am GMT+0100, diagramKind=WALTZ_SPARX, layoutData=Layout Data, kind=ALL}, entities=[]"
            + "}",
        actualToStringResult);
    assertTrue(immutableProcessDiagramAndEntities.entities().isEmpty());
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
  @MethodsUnderTest({"ProcessDiagram Json.diagram()"})
  void testJsonDiagram() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagram());
  }

  /**
   * Test Json {@link Json#entities()}.
   *
   * <p>Method under test: {@link Json#entities()}
   */
  @Test
  @DisplayName("Test Json entities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Json.entities()"})
  void testJsonEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entities());
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
    assertTrue(actualJson.entities.isEmpty());
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#withDiagram(ProcessDiagram)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagramAndEntities#withDiagram(ProcessDiagram)}
   */
  @Test
  @DisplayName("Test withDiagram(ProcessDiagram)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramAndEntities ImmutableProcessDiagramAndEntities.withDiagram(ProcessDiagram)"
  })
  void testWithDiagram() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagramAndEntities immutableProcessDiagramAndEntities =
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableProcessDiagramAndEntities actualWithDiagramResult =
        immutableProcessDiagramAndEntities.withDiagram(
            ImmutableProcessDiagram.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .description("The characteristics of someone or something")
                .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableProcessDiagramAndEntities, actualWithDiagramResult);
  }

  /**
   * Test {@link ImmutableProcessDiagramAndEntities#withEntities(ProcessDiagramEntity[])} with
   * {@code ProcessDiagramEntity[]}.
   *
   * <p>Method under test: {@link
   * ImmutableProcessDiagramAndEntities#withEntities(ProcessDiagramEntity[])}
   */
  @Test
  @DisplayName("Test withEntities(ProcessDiagramEntity[]) with 'ProcessDiagramEntity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramAndEntities ImmutableProcessDiagramAndEntities.withEntities(ProcessDiagramEntity[])"
  })
  void testWithEntitiesWithProcessDiagramEntity() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    ImmutableProcessDiagramAndEntities immutableProcessDiagramAndEntities =
        builderResult
            .diagram(
                ImmutableProcessDiagram.builder()
                    .createdAt(ofResult.atStartOfDay())
                    .createdBy("Jan 1, 2020 8:00am GMT+0100")
                    .description("The characteristics of someone or something")
                    .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(ofResult2.atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .build())
            .build();

    ImmutableProcessDiagramEntity.Builder diagramIdResult =
        ImmutableProcessDiagramEntity.builder().diagramId(1L);

    // Act
    ImmutableProcessDiagramAndEntities actualWithEntitiesResult =
        immutableProcessDiagramAndEntities.withEntities(
            diagramIdResult
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
    ProcessDiagram diagramResult = actualWithEntitiesResult.diagram();
    assertTrue(diagramResult instanceof ImmutableProcessDiagram);
    assertEquals("2020-03-01", diagramResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", diagramResult.createdBy());
    assertEquals("Name", diagramResult.name());
    assertEquals("Provenance", diagramResult.provenance());
    assertEquals("The characteristics of someone or something", diagramResult.description());
    assertEquals(1, actualWithEntitiesResult.entities().size());
    assertEquals(EntityKind.ALL, diagramResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, diagramResult.diagramKind());
    assertSame(ofResult, diagramResult.createdAt().toLocalDate());
    assertSame(ofResult2, diagramResult.lastUpdatedAt().toLocalDate());
  }
}
