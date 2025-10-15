package org.finos.waltz.data.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AggregateOverlayDiagramUtilitiesDiffblueTest {
  /**
   * Test {@link AggregateOverlayDiagramUtilities#loadCellExtIdToAggregatedEntities(DSLContext, Set,
   * EntityKind, Select, Optional)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramUtilities#loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind,
   * Select, Optional)}
   */
  @Test
  @DisplayName(
      "Test loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind, Select, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map AggregateOverlayDiagramUtilities.loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind, Select, Optional)"
  })
  void testLoadCellExtIdToAggregatedEntities() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<String, EntityReference> tuple2 =
        new Tuple2<>(
            "Cannot load measurable id to entity map for entity kind: %s",
            immutableEntityReference);
    cellMappings.add(tuple2);
    Select<Record1<Long>> inScopeEntityIdSelector = mock(Select.class);
    Optional<LocalDate> targetStateDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AggregateOverlayDiagramUtilities.loadCellExtIdToAggregatedEntities(
                dsl, cellMappings, EntityKind.ALL, inScopeEntityIdSelector, targetStateDate));
  }

  /**
   * Test {@link AggregateOverlayDiagramUtilities#loadCellExtIdToAggregatedEntities(DSLContext, Set,
   * EntityKind, Select, Optional)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramUtilities#loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind,
   * Select, Optional)}
   */
  @Test
  @DisplayName(
      "Test loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind, Select, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map AggregateOverlayDiagramUtilities.loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind, Select, Optional)"
  })
  void testLoadCellExtIdToAggregatedEntities2() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("V1", immutableEntityReference);
    cellMappings.add(tuple2);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<String, EntityReference> tuple22 =
        new Tuple2<>(
            "Cannot load measurable id to entity map for entity kind: %s",
            immutableEntityReference2);
    cellMappings.add(tuple22);
    Select<Record1<Long>> inScopeEntityIdSelector = mock(Select.class);
    Optional<LocalDate> targetStateDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AggregateOverlayDiagramUtilities.loadCellExtIdToAggregatedEntities(
                dsl, cellMappings, EntityKind.ALL, inScopeEntityIdSelector, targetStateDate));
  }

  /**
   * Test {@link AggregateOverlayDiagramUtilities#loadCellExtIdToAggregatedEntities(DSLContext, Set,
   * EntityKind, Select, Optional)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramUtilities#loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind,
   * Select, Optional)}
   */
  @Test
  @DisplayName(
      "Test loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind, Select, Optional); when 'ALL'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map AggregateOverlayDiagramUtilities.loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind, Select, Optional)"
  })
  void testLoadCellExtIdToAggregatedEntities_whenAll_thenThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    Select<Record1<Long>> inScopeEntityIdSelector = mock(Select.class);
    Optional<LocalDate> targetStateDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AggregateOverlayDiagramUtilities.loadCellExtIdToAggregatedEntities(
                dsl, cellMappings, EntityKind.ALL, inScopeEntityIdSelector, targetStateDate));
  }

  /**
   * Test {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}
   */
  @Test
  @DisplayName("Test toMeasurableIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramUtilities.toMeasurableIds(Set)"})
  void testToMeasurableIds() {
    // Arrange
    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("V1", immutableEntityReference);
    cellMappings.add(tuple2);

    // Act
    Set<Long> actualToMeasurableIdsResult =
        AggregateOverlayDiagramUtilities.toMeasurableIds(cellMappings);

    // Assert
    assertTrue(actualToMeasurableIdsResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}
   */
  @Test
  @DisplayName("Test toMeasurableIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramUtilities.toMeasurableIds(Set)"})
  void testToMeasurableIds2() {
    // Arrange
    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("42", immutableEntityReference);
    cellMappings.add(tuple2);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<String, EntityReference> tuple22 = new Tuple2<>("V1", immutableEntityReference2);
    cellMappings.add(tuple22);

    // Act
    Set<Long> actualToMeasurableIdsResult =
        AggregateOverlayDiagramUtilities.toMeasurableIds(cellMappings);

    // Assert
    assertTrue(actualToMeasurableIdsResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}
   */
  @Test
  @DisplayName("Test toMeasurableIds(Set); when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramUtilities.toMeasurableIds(Set)"})
  void testToMeasurableIds_whenHashSet_thenReturnEmpty() {
    // Arrange and Act
    Set<Long> actualToMeasurableIdsResult =
        AggregateOverlayDiagramUtilities.toMeasurableIds(new HashSet<>());

    // Assert
    assertTrue(actualToMeasurableIdsResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramUtilities#toDataTypeIds(Set)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramUtilities#toDataTypeIds(Set)}
   */
  @Test
  @DisplayName("Test toDataTypeIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramUtilities.toDataTypeIds(Set)"})
  void testToDataTypeIds() {
    // Arrange
    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("V1", immutableEntityReference);
    cellMappings.add(tuple2);

    // Act
    Set<Long> actualToDataTypeIdsResult =
        AggregateOverlayDiagramUtilities.toDataTypeIds(cellMappings);

    // Assert
    assertTrue(actualToDataTypeIdsResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramUtilities#toDataTypeIds(Set)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramUtilities#toDataTypeIds(Set)}
   */
  @Test
  @DisplayName("Test toDataTypeIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramUtilities.toDataTypeIds(Set)"})
  void testToDataTypeIds2() {
    // Arrange
    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("42", immutableEntityReference);
    cellMappings.add(tuple2);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<String, EntityReference> tuple22 = new Tuple2<>("V1", immutableEntityReference2);
    cellMappings.add(tuple22);

    // Act
    Set<Long> actualToDataTypeIdsResult =
        AggregateOverlayDiagramUtilities.toDataTypeIds(cellMappings);

    // Assert
    assertTrue(actualToDataTypeIdsResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramUtilities#toDataTypeIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramUtilities#toDataTypeIds(Set)}
   */
  @Test
  @DisplayName("Test toDataTypeIds(Set); when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramUtilities.toDataTypeIds(Set)"})
  void testToDataTypeIds_whenHashSet_thenReturnEmpty() {
    // Arrange and Act
    Set<Long> actualToDataTypeIdsResult =
        AggregateOverlayDiagramUtilities.toDataTypeIds(new HashSet<>());

    // Assert
    assertTrue(actualToDataTypeIdsResult.isEmpty());
  }

  /**
   * Test {@link
   * AggregateOverlayDiagramUtilities#findMeasurableIdToAggregatedEntityIdMap(DSLContext,
   * EntityKind, Select, Set, Optional)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramUtilities#findMeasurableIdToAggregatedEntityIdMap(DSLContext,
   * EntityKind, Select, Set, Optional)}
   */
  @Test
  @DisplayName(
      "Test findMeasurableIdToAggregatedEntityIdMap(DSLContext, EntityKind, Select, Set, Optional); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map AggregateOverlayDiagramUtilities.findMeasurableIdToAggregatedEntityIdMap(DSLContext, EntityKind, Select, Set, Optional)"
  })
  void testFindMeasurableIdToAggregatedEntityIdMap_thenThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    Select<Record1<Long>> inScopeEntityIdSelector = mock(Select.class);
    HashSet<Long> backingEntityIds = new HashSet<>();
    Optional<LocalDate> targetStateDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AggregateOverlayDiagramUtilities.findMeasurableIdToAggregatedEntityIdMap(
                dsl, EntityKind.ALL, inScopeEntityIdSelector, backingEntityIds, targetStateDate));
  }

  /**
   * Test {@link AggregateOverlayDiagramUtilities#loadEntityIdToRefMap(DSLContext, EntityKind,
   * Select)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramUtilities#loadEntityIdToRefMap(DSLContext,
   * EntityKind, Select)}
   */
  @Test
  @DisplayName("Test loadEntityIdToRefMap(DSLContext, EntityKind, Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map AggregateOverlayDiagramUtilities.loadEntityIdToRefMap(DSLContext, EntityKind, Select)"
  })
  void testLoadEntityIdToRefMap() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AggregateOverlayDiagramUtilities.loadEntityIdToRefMap(
                new DefaultDSLContext(SQLDialect.SQL99), EntityKind.ALL, mock(Select.class)));
  }
}
