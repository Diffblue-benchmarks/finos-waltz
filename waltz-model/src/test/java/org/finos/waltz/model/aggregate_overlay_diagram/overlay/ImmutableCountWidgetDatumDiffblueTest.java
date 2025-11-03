package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCountWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCountWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCountWidgetDatumDiffblueTest {
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
    Builder builderResult = ImmutableCountWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#currentStateCount(int)}.
   * <p>
   * Method under test: {@link Builder#currentStateCount(int)}
   */
  @Test
  @DisplayName("Test Builder currentStateCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.currentStateCount(int)"})
  void testBuilderCurrentStateCount() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.currentStateCount(3));
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; given '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_given42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CountWidgetDatum)} with {@code CountWidgetDatum}.
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CountWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(CountWidgetDatum) with 'CountWidgetDatum'; then builder build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CountWidgetDatum)"})
  void testBuilderFromWithCountWidgetDatum_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetDatum.builder();
    CountWidgetDatum instance = mock(CountWidgetDatum.class);
    when(instance.currentStateCount()).thenReturn(3);
    when(instance.targetStateCount()).thenReturn(3);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(CountWidgetDatum)} with {@code CountWidgetDatum}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CountWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(CountWidgetDatum) with 'CountWidgetDatum'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CountWidgetDatum)"})
  void testBuilderFromWithCountWidgetDatum_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetDatum.builder();
    CountWidgetDatum instance = mock(CountWidgetDatum.class);
    when(instance.targetStateCount()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellExternalId();
    verify(instance).targetStateCount();
  }

  /**
   * Test Builder {@link Builder#targetStateCount(int)}.
   * <p>
   * Method under test: {@link Builder#targetStateCount(int)}
   */
  @Test
  @DisplayName("Test Builder targetStateCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetStateCount(int)"})
  void testBuilderTargetStateCount() {
    // Arrange
    Builder builderResult = ImmutableCountWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetStateCount(3));
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
   * Test Json {@link Json#currentStateCount()}.
   * <p>
   * Method under test: {@link Json#currentStateCount()}
   */
  @Test
  @DisplayName("Test Json currentStateCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.currentStateCount()"})
  void testJsonCurrentStateCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).currentStateCount());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCellExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCellExternalId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCellExternalId("42");

    // Assert
    assertEquals("42", actualJson.cellExternalId);
    assertEquals(0, actualJson.currentStateCount);
    assertEquals(0, actualJson.targetStateCount);
    assertFalse(actualJson.currentStateCountIsSet);
    assertFalse(actualJson.targetStateCountIsSet);
  }

  /**
   * Test Json {@link Json#setCurrentStateCount(int)}.
   * <p>
   * Method under test: {@link Json#setCurrentStateCount(int)}
   */
  @Test
  @DisplayName("Test Json setCurrentStateCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCurrentStateCount(int)"})
  void testJsonSetCurrentStateCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCurrentStateCount(3);

    // Assert
    assertEquals(3, json.currentStateCount);
    assertTrue(json.currentStateCountIsSet);
  }

  /**
   * Test Json {@link Json#setTargetStateCount(int)}.
   * <p>
   * Method under test: {@link Json#setTargetStateCount(int)}
   */
  @Test
  @DisplayName("Test Json setTargetStateCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setTargetStateCount(int)"})
  void testJsonSetTargetStateCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTargetStateCount(3);

    // Assert
    assertEquals(3, json.targetStateCount);
    assertTrue(json.targetStateCountIsSet);
  }

  /**
   * Test Json {@link Json#targetStateCount()}.
   * <p>
   * Method under test: {@link Json#targetStateCount()}
   */
  @Test
  @DisplayName("Test Json targetStateCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.targetStateCount()"})
  void testJsonTargetStateCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetStateCount());
  }
}
