package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableDiagramCalloutCreateCommand.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableDiagramCalloutCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDiagramCalloutCreateCommandDiffblueTest {
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
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

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
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.content("Not all who wander are lost"));
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
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.endColor("End Color"));
  }

  /**
   * Test Builder {@link Builder#from(DiagramCalloutCreateCommand)}.
   * <ul>
   *   <li>Given {@code End Color}.</li>
   *   <li>Then builder build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DiagramCalloutCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(DiagramCalloutCreateCommand); given 'End Color'; then builder build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DiagramCalloutCreateCommand)"})
  void testBuilderFrom_givenEndColor_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();
    DiagramCalloutCreateCommand instance = mock(DiagramCalloutCreateCommand.class);
    when(instance.endColor()).thenReturn("End Color");
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.title()).thenReturn("Dr");
    when(instance.instanceId()).thenReturn(1L);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).endColor();
    verify(instance).instanceId();
    verify(instance).startColor();
    verify(instance).title();
    ImmutableDiagramCalloutCreateCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals("Dr", buildResult.title());
    assertEquals("End Color", buildResult.endColor());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertEquals("Start Color", buildResult.startColor());
    assertEquals(1L, buildResult.instanceId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DiagramCalloutCreateCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DiagramCalloutCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(DiagramCalloutCreateCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DiagramCalloutCreateCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();
    DiagramCalloutCreateCommand instance = mock(DiagramCalloutCreateCommand.class);
    when(instance.endColor()).thenThrow(new IllegalStateException("instance"));
    when(instance.startColor()).thenReturn("Start Color");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.title()).thenReturn("Dr");
    when(instance.instanceId()).thenReturn(1L);
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellExternalId();
    verify(instance).content();
    verify(instance).endColor();
    verify(instance).instanceId();
    verify(instance).startColor();
    verify(instance).title();
  }

  /**
   * Test Builder {@link Builder#instanceId(Long)}.
   * <p>
   * Method under test: {@link Builder#instanceId(Long)}
   */
  @Test
  @DisplayName("Test Builder instanceId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.instanceId(Long)"})
  void testBuilderInstanceId() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instanceId(1L));
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
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

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
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

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
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCellExternalId(String)}
   *   <li>{@link Json#setContent(String)}
   *   <li>{@link Json#setEndColor(String)}
   *   <li>{@link Json#setInstanceId(Long)}
   *   <li>{@link Json#setStartColor(String)}
   *   <li>{@link Json#setTitle(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCellExternalId(String)", "void Json.setContent(String)",
      "void Json.setEndColor(String)", "void Json.setInstanceId(Long)", "void Json.setStartColor(String)",
      "void Json.setTitle(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCellExternalId("42");
    actualJson.setContent("Not all who wander are lost");
    actualJson.setEndColor("End Color");
    actualJson.setInstanceId(1L);
    actualJson.setStartColor("Start Color");
    actualJson.setTitle("Dr");

    // Assert
    assertEquals(1L, actualJson.instanceId.longValue());
  }

  /**
   * Test Json {@link Json#instanceId()}.
   * <p>
   * Method under test: {@link Json#instanceId()}
   */
  @Test
  @DisplayName("Test Json instanceId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.instanceId()"})
  void testJsonInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).instanceId());
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
