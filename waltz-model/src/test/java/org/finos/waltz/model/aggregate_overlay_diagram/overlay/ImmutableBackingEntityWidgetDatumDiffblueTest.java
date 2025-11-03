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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableBackingEntityWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableBackingEntityWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBackingEntityWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllBackingEntityReferences(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllBackingEntityReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllBackingEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllBackingEntityReferences(Iterable)"})
  void testBuilderAddAllBackingEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllBackingEntityReferences(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addBackingEntityReferences(EntityReference)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addBackingEntityReferences(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addBackingEntityReferences(EntityReference) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addBackingEntityReferences(EntityReference)"})
  void testBuilderAddBackingEntityReferencesWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addBackingEntityReferences(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addBackingEntityReferences(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addBackingEntityReferences(EntityReference[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addBackingEntityReferences(EntityReference[])"})
  void testBuilderAddBackingEntityReferencesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#backingEntityReferences(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#backingEntityReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder backingEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.backingEntityReferences(Iterable)"})
  void testBuilderBackingEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.backingEntityReferences(new ArrayList<>()));
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
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(BackingEntityWidgetDatum)} with {@code BackingEntityWidgetDatum}.
   * <p>
   * Method under test: {@link Builder#from(BackingEntityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(BackingEntityWidgetDatum) with 'BackingEntityWidgetDatum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BackingEntityWidgetDatum)"})
  void testBuilderFromWithBackingEntityWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    BackingEntityWidgetDatum instance = mock(BackingEntityWidgetDatum.class);
    when(instance.backingEntityReferences()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).backingEntityReferences();
    verify(instance).cellExternalId();
    ImmutableBackingEntityWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.backingEntityReferences().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BackingEntityWidgetDatum)} with {@code BackingEntityWidgetDatum}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BackingEntityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(BackingEntityWidgetDatum) with 'BackingEntityWidgetDatum'; given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BackingEntityWidgetDatum)"})
  void testBuilderFromWithBackingEntityWidgetDatum_givenHashSet() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
    BackingEntityWidgetDatum instance = mock(BackingEntityWidgetDatum.class);
    when(instance.backingEntityReferences()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).backingEntityReferences();
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BackingEntityWidgetDatum)} with {@code BackingEntityWidgetDatum}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BackingEntityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(BackingEntityWidgetDatum) with 'BackingEntityWidgetDatum'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BackingEntityWidgetDatum)"})
  void testBuilderFromWithBackingEntityWidgetDatum_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
    BackingEntityWidgetDatum instance = mock(BackingEntityWidgetDatum.class);
    when(instance.backingEntityReferences()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).backingEntityReferences();
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
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
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
   * Test Json {@link Json#backingEntityReferences()}.
   * <p>
   * Method under test: {@link Json#backingEntityReferences()}
   */
  @Test
  @DisplayName("Test Json backingEntityReferences()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.backingEntityReferences()"})
  void testJsonBackingEntityReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).backingEntityReferences());
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
    assertTrue(actualJson.backingEntityReferences.isEmpty());
  }
}
