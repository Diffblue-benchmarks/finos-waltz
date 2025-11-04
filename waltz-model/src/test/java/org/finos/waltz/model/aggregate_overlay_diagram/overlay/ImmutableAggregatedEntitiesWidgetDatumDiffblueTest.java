package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableAggregatedEntitiesWidgetDatumDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#addAggregatedEntityReferences(EntityReference)}
   */
  @Test
  void testBuilderAddAggregatedEntityReferences() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAggregatedEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#addAggregatedEntityReferences(EntityReference[])}
   */
  @Test
  void testBuilderAddAggregatedEntityReferences2() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAggregatedEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#addAllAggregatedEntityReferences(Iterable)}
   */
  @Test
  void testBuilderAddAllAggregatedEntityReferences() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAggregatedEntityReferences(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#aggregatedEntityReferences(Iterable)}
   */
  @Test
  void testBuilderAggregatedEntityReferences() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.aggregatedEntityReferences(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    // Act
    ImmutableAggregatedEntitiesWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId2() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();
    builderResult.addAggregatedEntityReferences(mock(EntityReference.class));

    // Act
    ImmutableAggregatedEntitiesWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    ImmutableAggregatedEntitiesWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.aggregatedEntityReferences().size());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#from(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();
    AggregatedEntitiesWidgetDatum instance = mock(AggregatedEntitiesWidgetDatum.class);
    when(instance.aggregatedEntityReferences()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAggregatedEntitiesWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).aggregatedEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#from(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();
    AggregatedEntitiesWidgetDatum instance = mock(AggregatedEntitiesWidgetDatum.class);
    when(instance.aggregatedEntityReferences()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).aggregatedEntityReferences();
    verify(instance).cellExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#from(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    AggregatedEntitiesWidgetDatum instance = mock(AggregatedEntitiesWidgetDatum.class);
    when(instance.aggregatedEntityReferences()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAggregatedEntitiesWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).aggregatedEntityReferences();
    verify(instance).cellExternalId();
    ImmutableAggregatedEntitiesWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.aggregatedEntityReferences().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Builder#from(CellExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Builder builderResult = ImmutableAggregatedEntitiesWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAggregatedEntitiesWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum#copyOf(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AggregatedEntitiesWidgetDatum instance = mock(AggregatedEntitiesWidgetDatum.class);
    when(instance.aggregatedEntityReferences()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualCopyOfResult = ImmutableAggregatedEntitiesWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).aggregatedEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.aggregatedEntityReferences().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum#copyOf(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    AggregatedEntitiesWidgetDatum instance = mock(AggregatedEntitiesWidgetDatum.class);
    when(instance.aggregatedEntityReferences()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualCopyOfResult = ImmutableAggregatedEntitiesWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).aggregatedEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(1, actualCopyOfResult.aggregatedEntityReferences().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum#copyOf(AggregatedEntitiesWidgetDatum)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    entityReferenceSet.add(mock(EntityReference.class));
    AggregatedEntitiesWidgetDatum instance = mock(AggregatedEntitiesWidgetDatum.class);
    when(instance.aggregatedEntityReferences()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualCopyOfResult = ImmutableAggregatedEntitiesWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).aggregatedEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(entityReferenceSet, actualCopyOfResult.aggregatedEntityReferences());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(ImmutableAggregatedEntitiesWidgetDatum.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetDatum.Json json = new ImmutableAggregatedEntitiesWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setAggregatedEntityReferences(null);

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualFromJsonResult = ImmutableAggregatedEntitiesWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.aggregatedEntityReferences().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum#fromJson(ImmutableAggregatedEntitiesWidgetDatum.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<EntityReference> aggregatedEntityReferences = new LinkedHashSet<>();
    aggregatedEntityReferences.add(mock(EntityReference.class));

    ImmutableAggregatedEntitiesWidgetDatum.Json json = new ImmutableAggregatedEntitiesWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setAggregatedEntityReferences(aggregatedEntityReferences);

    // Act
    ImmutableAggregatedEntitiesWidgetDatum actualFromJsonResult = ImmutableAggregatedEntitiesWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(1, actualFromJsonResult.aggregatedEntityReferences().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Json#aggregatedEntityReferences()}
   */
  @Test
  void testJsonAggregatedEntityReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregatedEntitiesWidgetDatum.Json()).aggregatedEntityReferences());
  }

  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAggregatedEntitiesWidgetDatum.Json()).cellExternalId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAggregatedEntitiesWidgetDatum.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAggregatedEntitiesWidgetDatum.Json actualJson = new ImmutableAggregatedEntitiesWidgetDatum.Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.aggregatedEntityReferences.isEmpty());
  }
}
