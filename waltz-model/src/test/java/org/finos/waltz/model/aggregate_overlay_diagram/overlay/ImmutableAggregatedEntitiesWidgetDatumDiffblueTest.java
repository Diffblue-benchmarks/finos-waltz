package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAggregatedEntitiesWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAggregatedEntitiesWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregatedEntitiesWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAggregatedEntityReferences(EntityReference)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAggregatedEntityReferences(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addAggregatedEntityReferences(EntityReference) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAggregatedEntityReferences(EntityReference)"})
  void testBuilderAddAggregatedEntityReferencesWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAggregatedEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addAggregatedEntityReferences(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAggregatedEntityReferences(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addAggregatedEntityReferences(EntityReference[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAggregatedEntityReferences(EntityReference[])"})
  void testBuilderAddAggregatedEntityReferencesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAggregatedEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addAllAggregatedEntityReferences(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAggregatedEntityReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAggregatedEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAggregatedEntityReferences(Iterable)"})
  void testBuilderAddAllAggregatedEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAggregatedEntityReferences(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#aggregatedEntityReferences(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#aggregatedEntityReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder aggregatedEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.aggregatedEntityReferences(Iterable)"})
  void testBuilderAggregatedEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.aggregatedEntityReferences(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder cellExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregatedEntitiesWidgetDatum)} with {@code AggregatedEntitiesWidgetDatum}.
   * <p>
   * Method under test: {@link Builder#from(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AggregatedEntitiesWidgetDatum) with 'AggregatedEntitiesWidgetDatum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregatedEntitiesWidgetDatum)"})
  void testBuilderFromWithAggregatedEntitiesWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    AggregatedEntitiesWidgetDatum instance = mock(AggregatedEntitiesWidgetDatum.class);
    when(instance.aggregatedEntityReferences()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).aggregatedEntityReferences();
    verify(instance).cellExternalId();
    ImmutableAggregatedEntitiesWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.aggregatedEntityReferences().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregatedEntitiesWidgetDatum)} with {@code AggregatedEntitiesWidgetDatum}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AggregatedEntitiesWidgetDatum) with 'AggregatedEntitiesWidgetDatum'; given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregatedEntitiesWidgetDatum)"})
  void testBuilderFromWithAggregatedEntitiesWidgetDatum_givenHashSet() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();
    AggregatedEntitiesWidgetDatum instance = mock(AggregatedEntitiesWidgetDatum.class);
    when(instance.aggregatedEntityReferences()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).aggregatedEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregatedEntitiesWidgetDatum)} with {@code AggregatedEntitiesWidgetDatum}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AggregatedEntitiesWidgetDatum) with 'AggregatedEntitiesWidgetDatum'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregatedEntitiesWidgetDatum)"})
  void testBuilderFromWithAggregatedEntitiesWidgetDatum_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();
    AggregatedEntitiesWidgetDatum instance = mock(AggregatedEntitiesWidgetDatum.class);
    when(instance.aggregatedEntityReferences()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).aggregatedEntityReferences();
    verify(instance).cellExternalId();
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
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
   * Test Json {@link Json#aggregatedEntityReferences()}.
   * <p>
   * Method under test: {@link Json#aggregatedEntityReferences()}
   */
  @Test
  @DisplayName("Test Json aggregatedEntityReferences()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.aggregatedEntityReferences()"})
  void testJsonAggregatedEntityReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).aggregatedEntityReferences());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   * <p>
   * Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cellExternalId());
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
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.aggregatedEntityReferences.isEmpty());
  }
}
