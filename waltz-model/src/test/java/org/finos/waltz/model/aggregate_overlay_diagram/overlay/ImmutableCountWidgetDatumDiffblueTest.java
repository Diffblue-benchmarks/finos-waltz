package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableCountWidgetDatumDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCountWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableCountWidgetDatum.Builder builderResult = ImmutableCountWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetDatum.Builder#currentStateCount(int)}
   */
  @Test
  void testBuilderCurrentStateCount() {
    // Arrange
    ImmutableCountWidgetDatum.Builder builderResult = ImmutableCountWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.currentStateCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetDatum.Builder#from(CellExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCountWidgetDatum.Builder builderResult = ImmutableCountWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableCountWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetDatum.Builder#from(CountWidgetDatum)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCountWidgetDatum.Builder builderResult = ImmutableCountWidgetDatum.builder();
    CountWidgetDatum instance = mock(CountWidgetDatum.class);
    when(instance.currentStateCount()).thenReturn(3);
    when(instance.targetStateCount()).thenReturn(3);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableCountWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).currentStateCount();
    verify(instance).targetStateCount();
    ImmutableCountWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(3, buildResult.currentStateCount());
    assertEquals(3, buildResult.targetStateCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetDatum.Builder#from(CountWidgetDatum)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCountWidgetDatum.Builder builderResult = ImmutableCountWidgetDatum.builder();
    CountWidgetDatum instance = mock(CountWidgetDatum.class);
    when(instance.targetStateCount()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellExternalId();
    verify(instance).targetStateCount();
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetDatum.Builder#targetStateCount(int)}
   */
  @Test
  void testBuilderTargetStateCount() {
    // Arrange
    ImmutableCountWidgetDatum.Builder builderResult = ImmutableCountWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetStateCount(3));
  }

  /**
   * Method under test: {@link ImmutableCountWidgetDatum#copyOf(CountWidgetDatum)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CountWidgetDatum instance = mock(CountWidgetDatum.class);
    when(instance.currentStateCount()).thenReturn(3);
    when(instance.targetStateCount()).thenReturn(3);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableCountWidgetDatum actualCopyOfResult = ImmutableCountWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).currentStateCount();
    verify(instance).targetStateCount();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(3, actualCopyOfResult.currentStateCount());
    assertEquals(3, actualCopyOfResult.targetStateCount());
  }

  /**
   * Method under test: {@link ImmutableCountWidgetDatum.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCountWidgetDatum.Json()).cellExternalId());
  }

  /**
   * Method under test: {@link ImmutableCountWidgetDatum.Json#currentStateCount()}
   */
  @Test
  void testJsonCurrentStateCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCountWidgetDatum.Json()).currentStateCount());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableCountWidgetDatum.Json}
   *   <li>{@link ImmutableCountWidgetDatum.Json#setCellExternalId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableCountWidgetDatum.Json actualJson = new ImmutableCountWidgetDatum.Json();
    actualJson.setCellExternalId("42");

    // Assert
    assertEquals("42", actualJson.cellExternalId);
    assertEquals(0, actualJson.currentStateCount);
    assertEquals(0, actualJson.targetStateCount);
    assertFalse(actualJson.currentStateCountIsSet);
    assertFalse(actualJson.targetStateCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetDatum.Json#setCurrentStateCount(int)}
   */
  @Test
  void testJsonSetCurrentStateCount() {
    // Arrange
    ImmutableCountWidgetDatum.Json json = new ImmutableCountWidgetDatum.Json();

    // Act
    json.setCurrentStateCount(3);

    // Assert
    assertEquals(3, json.currentStateCount);
    assertTrue(json.currentStateCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableCountWidgetDatum.Json#setTargetStateCount(int)}
   */
  @Test
  void testJsonSetTargetStateCount() {
    // Arrange
    ImmutableCountWidgetDatum.Json json = new ImmutableCountWidgetDatum.Json();

    // Act
    json.setTargetStateCount(3);

    // Assert
    assertEquals(3, json.targetStateCount);
    assertTrue(json.targetStateCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableCountWidgetDatum.Json#targetStateCount()}
   */
  @Test
  void testJsonTargetStateCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCountWidgetDatum.Json()).targetStateCount());
  }
}
