package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAggregatedEntitiesWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAggregatedEntitiesWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregatedEntitiesWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAggregatedEntityReferences(EntityReference)} with {@code
   * element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAggregatedEntityReferences(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addAggregatedEntityReferences(EntityReference) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAggregatedEntityReferences(EntityReference)"})
  void testBuilderAddAggregatedEntityReferencesWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act
    Builder actualAddAggregatedEntityReferencesResult =
        builderResult.addAggregatedEntityReferences(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualAddAggregatedEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#addAggregatedEntityReferences(EntityReference[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAggregatedEntityReferences(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAggregatedEntityReferences(EntityReference[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAggregatedEntityReferences(EntityReference[])"})
  void testBuilderAddAggregatedEntityReferencesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act
    Builder actualAddAggregatedEntityReferencesResult =
        builderResult.addAggregatedEntityReferences(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualAddAggregatedEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#addAllAggregatedEntityReferences(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAggregatedEntityReferences(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAggregatedEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAggregatedEntityReferences(Iterable)"})
  void testBuilderAddAllAggregatedEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act
    Builder actualAddAllAggregatedEntityReferencesResult =
        builderResult.addAllAggregatedEntityReferences(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAggregatedEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#aggregatedEntityReferences(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#aggregatedEntityReferences(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder aggregatedEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.aggregatedEntityReferences(Iterable)"})
  void testBuilderAggregatedEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act
    Builder actualAggregatedEntityReferencesResult =
        builderResult.aggregatedEntityReferences(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAggregatedEntityReferencesResult);
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
  @MethodsUnderTest({"ImmutableAggregatedEntitiesWidgetDatum Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAggregatedEntitiesWidgetDatum actualImmutableAggregatedEntitiesWidgetDatum =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();

    // Assert
    assertEquals("42", actualImmutableAggregatedEntitiesWidgetDatum.cellExternalId());
    assertTrue(actualImmutableAggregatedEntitiesWidgetDatum.aggregatedEntityReferences().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test Builder cellExternalId(String); when '42'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId_when42_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregatedEntitiesWidgetDatum)} with {@code
   * AggregatedEntitiesWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregatedEntitiesWidgetDatum) with 'AggregatedEntitiesWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregatedEntitiesWidgetDatum)"})
  void testBuilderFromWithAggregatedEntitiesWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();
    ImmutableAggregatedEntitiesWidgetDatum instance =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregatedEntitiesWidgetDatum actualImmutableAggregatedEntitiesWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregatedEntitiesWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregatedEntitiesWidgetDatum)} with {@code
   * AggregatedEntitiesWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregatedEntitiesWidgetDatum) with 'AggregatedEntitiesWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregatedEntitiesWidgetDatum)"})
  void testBuilderFromWithAggregatedEntitiesWidgetDatum2() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    Builder builderResult2 = ImmutableAggregatedEntitiesWidgetDatum.builder();
    builderResult2.addAggregatedEntityReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableAggregatedEntitiesWidgetDatum instance = builderResult2.cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregatedEntitiesWidgetDatum actualImmutableAggregatedEntitiesWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregatedEntitiesWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();
    ImmutableAggregatedEntitiesWidgetDatum instance =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from((CellExternalIdProvider) instance);

    // Assert
    ImmutableAggregatedEntitiesWidgetDatum actualImmutableAggregatedEntitiesWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregatedEntitiesWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#copyOf(AggregatedEntitiesWidgetDatum)}.
   *
   * <ul>
   *   <li>When builder cellExternalId {@code 42} build.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregatedEntitiesWidgetDatum#copyOf(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AggregatedEntitiesWidgetDatum); when builder cellExternalId '42' build; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetDatum ImmutableAggregatedEntitiesWidgetDatum.copyOf(AggregatedEntitiesWidgetDatum)"
  })
  void testCopyOf_whenBuilderCellExternalId42Build_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum instance =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualCopyOfResult =
        ImmutableAggregatedEntitiesWidgetDatum.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.aggregatedEntityReferences().isEmpty());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}, and {@link
   * ImmutableAggregatedEntitiesWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetDatum.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum immutableAggregatedEntitiesWidgetDatum =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();
    ImmutableAggregatedEntitiesWidgetDatum immutableAggregatedEntitiesWidgetDatum2 =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableAggregatedEntitiesWidgetDatum, immutableAggregatedEntitiesWidgetDatum2);
    assertEquals(
        immutableAggregatedEntitiesWidgetDatum.hashCode(),
        immutableAggregatedEntitiesWidgetDatum2.hashCode());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}, and {@link
   * ImmutableAggregatedEntitiesWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetDatum.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum immutableAggregatedEntitiesWidgetDatum =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableAggregatedEntitiesWidgetDatum, immutableAggregatedEntitiesWidgetDatum);
    int expectedHashCodeResult = immutableAggregatedEntitiesWidgetDatum.hashCode();
    assertEquals(expectedHashCodeResult, immutableAggregatedEntitiesWidgetDatum.hashCode());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetDatum.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();
    builderResult.addAggregatedEntityReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableAggregatedEntitiesWidgetDatum immutableAggregatedEntitiesWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableAggregatedEntitiesWidgetDatum,
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetDatum.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum immutableAggregatedEntitiesWidgetDatum =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("Cell External Id").build();

    // Act and Assert
    assertNotEquals(
        immutableAggregatedEntitiesWidgetDatum,
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetDatum.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build(), null);
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetDatum.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build(),
        "Different type to ImmutableAggregatedEntitiesWidgetDatum");
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AggregatedEntityReferences is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AggregatedEntityReferences is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetDatum ImmutableAggregatedEntitiesWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAggregatedEntityReferencesIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setAggregatedEntityReferences(new HashSet<>());

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualFromJsonResult =
        ImmutableAggregatedEntitiesWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.aggregatedEntityReferences().isEmpty());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) AggregatedEntityReferences is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) AggregatedEntityReferences is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetDatum ImmutableAggregatedEntitiesWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonAggregatedEntityReferencesIsNull() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setAggregatedEntityReferences(null);

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualFromJsonResult =
        ImmutableAggregatedEntitiesWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.aggregatedEntityReferences().isEmpty());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return aggregatedEntityReferences is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return aggregatedEntityReferences is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetDatum ImmutableAggregatedEntitiesWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnAggregatedEntityReferencesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<EntityReference> aggregatedEntityReferences = new LinkedHashSet<>();
    aggregatedEntityReferences.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    aggregatedEntityReferences.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setAggregatedEntityReferences(aggregatedEntityReferences);

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualFromJsonResult =
        ImmutableAggregatedEntitiesWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(aggregatedEntityReferences, actualFromJsonResult.aggregatedEntityReferences());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return aggregatedEntityReferences size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return aggregatedEntityReferences size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetDatum ImmutableAggregatedEntitiesWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnAggregatedEntityReferencesSizeIsOne() {
    // Arrange
    LinkedHashSet<EntityReference> aggregatedEntityReferences = new LinkedHashSet<>();
    aggregatedEntityReferences.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setAggregatedEntityReferences(aggregatedEntityReferences);

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualFromJsonResult =
        ImmutableAggregatedEntitiesWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(1, actualFromJsonResult.aggregatedEntityReferences().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetDatum#toString()}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetDatum#aggregatedEntityReferences()}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetDatum#cellExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAggregatedEntitiesWidgetDatum.aggregatedEntityReferences()",
    "String ImmutableAggregatedEntitiesWidgetDatum.cellExternalId()",
    "String ImmutableAggregatedEntitiesWidgetDatum.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum immutableAggregatedEntitiesWidgetDatum =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();

    // Act
    String actualToStringResult = immutableAggregatedEntitiesWidgetDatum.toString();
    Set<EntityReference> actualAggregatedEntityReferencesResult =
        immutableAggregatedEntitiesWidgetDatum.aggregatedEntityReferences();

    // Assert
    assertEquals("42", immutableAggregatedEntitiesWidgetDatum.cellExternalId());
    assertEquals(
        "AggregatedEntitiesWidgetDatum{cellExternalId=42, aggregatedEntityReferences=[]}",
        actualToStringResult);
    assertTrue(actualAggregatedEntityReferencesResult.isEmpty());
  }

  /**
   * Test Json {@link Json#aggregatedEntityReferences()}.
   *
   * <p>Method under test: {@link Json#aggregatedEntityReferences()}
   */
  @Test
  @DisplayName("Test Json aggregatedEntityReferences()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.aggregatedEntityReferences()"})
  void testJsonAggregatedEntityReferences() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().aggregatedEntityReferences());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   *
   * <p>Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellExternalId());
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
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.aggregatedEntityReferences.isEmpty());
  }

  /**
   * Test {@link
   * ImmutableAggregatedEntitiesWidgetDatum#withAggregatedEntityReferences(EntityReference[])} with
   * {@code EntityReference[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregatedEntitiesWidgetDatum#withAggregatedEntityReferences(EntityReference[])}
   */
  @Test
  @DisplayName("Test withAggregatedEntityReferences(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetDatum ImmutableAggregatedEntitiesWidgetDatum.withAggregatedEntityReferences(EntityReference[])"
  })
  void testWithAggregatedEntityReferencesWithEntityReference() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum immutableAggregatedEntitiesWidgetDatum =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualWithAggregatedEntityReferencesResult =
        immutableAggregatedEntitiesWidgetDatum.withAggregatedEntityReferences(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals("42", actualWithAggregatedEntityReferencesResult.cellExternalId());
    assertEquals(1, actualWithAggregatedEntityReferencesResult.aggregatedEntityReferences().size());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetDatum ImmutableAggregatedEntitiesWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnBuilderCellExternalId42Build() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum immutableAggregatedEntitiesWidgetDatum =
        ImmutableAggregatedEntitiesWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualWithCellExternalIdResult =
        immutableAggregatedEntitiesWidgetDatum.withCellExternalId("42");

    // Assert
    assertSame(immutableAggregatedEntitiesWidgetDatum, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregatedEntitiesWidgetDatum ImmutableAggregatedEntitiesWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAggregatedEntitiesWidgetDatum actualWithCellExternalIdResult =
        ImmutableAggregatedEntitiesWidgetDatum.builder()
            .cellExternalId("cellExternalId")
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertTrue(actualWithCellExternalIdResult.aggregatedEntityReferences().isEmpty());
  }
}
