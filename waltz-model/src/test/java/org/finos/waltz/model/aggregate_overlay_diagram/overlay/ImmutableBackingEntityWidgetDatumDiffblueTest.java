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

class ImmutableBackingEntityWidgetDatumDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#addAllBackingEntityReferences(Iterable)}
   */
  @Test
  void testBuilderAddAllBackingEntityReferences() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllBackingEntityReferences(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#addBackingEntityReferences(EntityReference)}
   */
  @Test
  void testBuilderAddBackingEntityReferences() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#addBackingEntityReferences(EntityReference[])}
   */
  @Test
  void testBuilderAddBackingEntityReferences2() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#backingEntityReferences(Iterable)}
   */
  @Test
  void testBuilderBackingEntityReferences() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.backingEntityReferences(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act
    ImmutableBackingEntityWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId2() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
    builderResult.addBackingEntityReferences(mock(EntityReference.class));

    // Act
    ImmutableBackingEntityWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    ImmutableBackingEntityWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.backingEntityReferences().size());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#from(BackingEntityWidgetDatum)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
    BackingEntityWidgetDatum instance = mock(BackingEntityWidgetDatum.class);
    when(instance.backingEntityReferences()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableBackingEntityWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).backingEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#from(BackingEntityWidgetDatum)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
    BackingEntityWidgetDatum instance = mock(BackingEntityWidgetDatum.class);
    when(instance.backingEntityReferences()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).backingEntityReferences();
    verify(instance).cellExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#from(BackingEntityWidgetDatum)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    BackingEntityWidgetDatum instance = mock(BackingEntityWidgetDatum.class);
    when(instance.backingEntityReferences()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableBackingEntityWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).backingEntityReferences();
    verify(instance).cellExternalId();
    ImmutableBackingEntityWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.backingEntityReferences().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Builder#from(CellExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableBackingEntityWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum#copyOf(BackingEntityWidgetDatum)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BackingEntityWidgetDatum instance = mock(BackingEntityWidgetDatum.class);
    when(instance.backingEntityReferences()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableBackingEntityWidgetDatum actualCopyOfResult = ImmutableBackingEntityWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).backingEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.backingEntityReferences().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum#copyOf(BackingEntityWidgetDatum)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    BackingEntityWidgetDatum instance = mock(BackingEntityWidgetDatum.class);
    when(instance.backingEntityReferences()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableBackingEntityWidgetDatum actualCopyOfResult = ImmutableBackingEntityWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).backingEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(1, actualCopyOfResult.backingEntityReferences().size());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum#copyOf(BackingEntityWidgetDatum)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    entityReferenceSet.add(mock(EntityReference.class));
    BackingEntityWidgetDatum instance = mock(BackingEntityWidgetDatum.class);
    when(instance.backingEntityReferences()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableBackingEntityWidgetDatum actualCopyOfResult = ImmutableBackingEntityWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).backingEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(entityReferenceSet, actualCopyOfResult.backingEntityReferences());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum#fromJson(ImmutableBackingEntityWidgetDatum.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Json json = new ImmutableBackingEntityWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setBackingEntityReferences(null);

    // Act
    ImmutableBackingEntityWidgetDatum actualFromJsonResult = ImmutableBackingEntityWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.backingEntityReferences().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum#fromJson(ImmutableBackingEntityWidgetDatum.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<EntityReference> backingEntityReferences = new LinkedHashSet<>();
    backingEntityReferences.add(mock(EntityReference.class));

    ImmutableBackingEntityWidgetDatum.Json json = new ImmutableBackingEntityWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setBackingEntityReferences(backingEntityReferences);

    // Act
    ImmutableBackingEntityWidgetDatum actualFromJsonResult = ImmutableBackingEntityWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(1, actualFromJsonResult.backingEntityReferences().size());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Json#backingEntityReferences()}
   */
  @Test
  void testJsonBackingEntityReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBackingEntityWidgetDatum.Json()).backingEntityReferences());
  }

  /**
   * Method under test:
   * {@link ImmutableBackingEntityWidgetDatum.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBackingEntityWidgetDatum.Json()).cellExternalId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBackingEntityWidgetDatum.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBackingEntityWidgetDatum.Json actualJson = new ImmutableBackingEntityWidgetDatum.Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.backingEntityReferences.isEmpty());
  }
}
