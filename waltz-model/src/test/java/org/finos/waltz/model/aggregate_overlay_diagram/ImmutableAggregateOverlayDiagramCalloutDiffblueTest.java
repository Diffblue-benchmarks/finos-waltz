package org.finos.waltz.model.aggregate_overlay_diagram;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramCallout.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramCallout.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramCalloutDiffblueTest {
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
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#content(String)}.
   * <p>
   * Method under test: {@link Builder#content(String)}
   */
  @Test
  @DisplayName("Test Builder content(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.content(String)"})
  void testBuilderContent() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.content("Not all who wander are lost"));
  }

  /**
   * Test Builder {@link Builder#diagramInstanceId(Long)}.
   * <p>
   * Method under test: {@link Builder#diagramInstanceId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramInstanceId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramInstanceId(Long)"})
  void testBuilderDiagramInstanceId() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramInstanceId(1L));
  }

  /**
   * Test Builder {@link Builder#endColor(String)}.
   * <p>
   * Method under test: {@link Builder#endColor(String)}
   */
  @Test
  @DisplayName("Test Builder endColor(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.endColor(String)"})
  void testBuilderEndColor() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.endColor("End Color"));
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramCallout)} with {@code AggregateOverlayDiagramCallout}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagramCallout) with 'AggregateOverlayDiagramCallout'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramCallout)"})
  void testBuilderFromWithAggregateOverlayDiagramCallout_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    AggregateOverlayDiagramCallout instance = mock(AggregateOverlayDiagramCallout.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.diagramInstanceId()).thenReturn(1L);
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.cellExternalId()).thenReturn("42");
    when(instance.endColor()).thenReturn("End Color");
    when(instance.title()).thenReturn("Dr");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).diagramInstanceId();
    verify(instance).endColor();
    verify(instance).startColor();
    verify(instance).title();
    ImmutableAggregateOverlayDiagramCallout buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals("Dr", buildResult.title());
    assertEquals("End Color", buildResult.endColor());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertEquals("Start Color", buildResult.startColor());
    assertEquals(1L, buildResult.diagramInstanceId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramCallout)} with {@code AggregateOverlayDiagramCallout}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagramCallout) with 'AggregateOverlayDiagramCallout'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramCallout)"})
  void testBuilderFromWithAggregateOverlayDiagramCallout_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    AggregateOverlayDiagramCallout instance = mock(AggregateOverlayDiagramCallout.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.diagramInstanceId()).thenReturn(1L);
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.cellExternalId()).thenReturn("42");
    when(instance.endColor()).thenReturn("End Color");
    when(instance.title()).thenReturn("Dr");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).diagramInstanceId();
    verify(instance).endColor();
    verify(instance).startColor();
    verify(instance).title();
    ImmutableAggregateOverlayDiagramCallout buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals("Dr", buildResult.title());
    assertEquals("End Color", buildResult.endColor());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertEquals("Start Color", buildResult.startColor());
    assertEquals(1L, buildResult.diagramInstanceId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramCallout)} with {@code AggregateOverlayDiagramCallout}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagramCallout) with 'AggregateOverlayDiagramCallout'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramCallout)"})
  void testBuilderFromWithAggregateOverlayDiagramCallout_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    AggregateOverlayDiagramCallout instance = mock(AggregateOverlayDiagramCallout.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagramInstanceId()).thenReturn(1L);
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.cellExternalId()).thenReturn("42");
    when(instance.endColor()).thenReturn("End Color");
    when(instance.title()).thenReturn("Dr");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).diagramInstanceId();
    verify(instance).endColor();
    verify(instance).startColor();
    verify(instance).title();
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
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
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
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
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
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#startColor(String)}.
   * <p>
   * Method under test: {@link Builder#startColor(String)}
   */
  @Test
  @DisplayName("Test Builder startColor(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.startColor(String)"})
  void testBuilderStartColor() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.startColor("Start Color"));
  }

  /**
   * Test Builder {@link Builder#title(String)}.
   * <p>
   * Method under test: {@link Builder#title(String)}
   */
  @Test
  @DisplayName("Test Builder title(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.title(String)"})
  void testBuilderTitle() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.title("Dr"));
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
   * Test Json {@link Json#content()}.
   * <p>
   * Method under test: {@link Json#content()}
   */
  @Test
  @DisplayName("Test Json content()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.content()"})
  void testJsonContent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).content());
  }

  /**
   * Test Json {@link Json#diagramInstanceId()}.
   * <p>
   * Method under test: {@link Json#diagramInstanceId()}
   */
  @Test
  @DisplayName("Test Json diagramInstanceId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.diagramInstanceId()"})
  void testJsonDiagramInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).diagramInstanceId());
  }

  /**
   * Test Json {@link Json#endColor()}.
   * <p>
   * Method under test: {@link Json#endColor()}
   */
  @Test
  @DisplayName("Test Json endColor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.endColor()"})
  void testJsonEndColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).endColor());
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
    assertNull(actualJson.diagramInstanceId);
    assertNull(actualJson.cellExternalId);
    assertNull(actualJson.content);
    assertNull(actualJson.endColor);
    assertNull(actualJson.startColor);
    assertNull(actualJson.title);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#startColor()}.
   * <p>
   * Method under test: {@link Json#startColor()}
   */
  @Test
  @DisplayName("Test Json startColor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.startColor()"})
  void testJsonStartColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).startColor());
  }

  /**
   * Test Json {@link Json#title()}.
   * <p>
   * Method under test: {@link Json#title()}
   */
  @Test
  @DisplayName("Test Json title()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.title()"})
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).title());
  }
}
