package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroupEntry.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroupEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramOverlayGroupEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#fill(String)}.
   * <p>
   * Method under test: {@link Builder#fill(String)}
   */
  @Test
  @DisplayName("Test Builder fill(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.fill(String)"})
  void testBuilderFill() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fill("Fill"));
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramOverlayGroupEntry)} with {@code FlowDiagramOverlayGroupEntry}.
   * <ul>
   *   <li>Then builder build fill is {@code Fill}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramOverlayGroupEntry) with 'FlowDiagramOverlayGroupEntry'; then builder build fill is 'Fill'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramOverlayGroupEntry)"})
  void testBuilderFromWithFlowDiagramOverlayGroupEntry_thenBuilderBuildFillIsFill() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    FlowDiagramOverlayGroupEntry instance = mock(FlowDiagramOverlayGroupEntry.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.stroke()).thenReturn("Stroke");
    when(instance.fill()).thenReturn("Fill");
    when(instance.overlayGroupId()).thenReturn(1L);
    when(instance.symbol()).thenReturn("Symbol");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).entityReference();
    verify(instance).fill();
    verify(instance).overlayGroupId();
    verify(instance).stroke();
    verify(instance).symbol();
    ImmutableFlowDiagramOverlayGroupEntry buildResult = builderResult.build();
    assertEquals("Fill", buildResult.fill());
    assertEquals("Stroke", buildResult.stroke());
    assertEquals("Symbol", buildResult.symbol());
    assertEquals(1L, buildResult.overlayGroupId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramOverlayGroupEntry)} with {@code FlowDiagramOverlayGroupEntry}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramOverlayGroupEntry) with 'FlowDiagramOverlayGroupEntry'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramOverlayGroupEntry)"})
  void testBuilderFromWithFlowDiagramOverlayGroupEntry_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    FlowDiagramOverlayGroupEntry instance = mock(FlowDiagramOverlayGroupEntry.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.stroke()).thenReturn("Stroke");
    when(instance.fill()).thenReturn("Fill");
    when(instance.overlayGroupId()).thenReturn(1L);
    when(instance.symbol()).thenReturn("Symbol");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).entityReference();
    verify(instance).fill();
    verify(instance).overlayGroupId();
    verify(instance).stroke();
    verify(instance).symbol();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#overlayGroupId(Long)}.
   * <p>
   * Method under test: {@link Builder#overlayGroupId(Long)}
   */
  @Test
  @DisplayName("Test Builder overlayGroupId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.overlayGroupId(Long)"})
  void testBuilderOverlayGroupId() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayGroupId(1L));
  }

  /**
   * Test Builder {@link Builder#stroke(String)}.
   * <p>
   * Method under test: {@link Builder#stroke(String)}
   */
  @Test
  @DisplayName("Test Builder stroke(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.stroke(String)"})
  void testBuilderStroke() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.stroke("Stroke"));
  }

  /**
   * Test Builder {@link Builder#symbol(String)}.
   * <p>
   * Method under test: {@link Builder#symbol(String)}
   */
  @Test
  @DisplayName("Test Builder symbol(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.symbol(String)"})
  void testBuilderSymbol() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.symbol("Symbol"));
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json {@link Json#fill()}.
   * <p>
   * Method under test: {@link Json#fill()}
   */
  @Test
  @DisplayName("Test Json fill()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.fill()"})
  void testJsonFill() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).fill());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
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
    assertNull(actualJson.overlayGroupId);
    assertNull(actualJson.fill);
    assertNull(actualJson.stroke);
    assertNull(actualJson.symbol);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#overlayGroupId()}.
   * <p>
   * Method under test: {@link Json#overlayGroupId()}
   */
  @Test
  @DisplayName("Test Json overlayGroupId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.overlayGroupId()"})
  void testJsonOverlayGroupId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).overlayGroupId());
  }

  /**
   * Test Json {@link Json#stroke()}.
   * <p>
   * Method under test: {@link Json#stroke()}
   */
  @Test
  @DisplayName("Test Json stroke()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.stroke()"})
  void testJsonStroke() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).stroke());
  }

  /**
   * Test Json {@link Json#symbol()}.
   * <p>
   * Method under test: {@link Json#symbol()}
   */
  @Test
  @DisplayName("Test Json symbol()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.symbol()"})
  void testJsonSymbol() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).symbol());
  }
}
