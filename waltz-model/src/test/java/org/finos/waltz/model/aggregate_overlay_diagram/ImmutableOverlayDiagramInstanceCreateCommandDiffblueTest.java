package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramInstanceCreateCommand.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramInstanceCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramInstanceCreateCommandDiffblueTest {
  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#builder()}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableOverlayDiagramInstanceCreateCommand Builder.build()",
      "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#diagramId(Long)}.
   * <p>
   * Method under test: {@link Builder#diagramId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramId(Long)"})
  void testBuilderDiagramId() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramInstanceCreateCommand)} with {@code OverlayDiagramInstanceCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramInstanceCreateCommand) with 'OverlayDiagramInstanceCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramInstanceCreateCommand)"})
  void testBuilderFromWithOverlayDiagramInstanceCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();
    OverlayDiagramInstanceCreateCommand instance = mock(OverlayDiagramInstanceCreateCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramInstanceCreateCommand)} with {@code OverlayDiagramInstanceCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramInstanceCreateCommand) with 'OverlayDiagramInstanceCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramInstanceCreateCommand)"})
  void testBuilderFromWithOverlayDiagramInstanceCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();
    OverlayDiagramInstanceCreateCommand instance = mock(OverlayDiagramInstanceCreateCommand.class);
    when(instance.svg()).thenReturn("Svg");
    when(instance.diagramId()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).parentEntityReference();
    verify(instance).svg();
    ImmutableOverlayDiagramInstanceCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Svg", buildResult.svg());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.diagramId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramInstanceCreateCommand)} with {@code OverlayDiagramInstanceCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramInstanceCreateCommand) with 'OverlayDiagramInstanceCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramInstanceCreateCommand)"})
  void testBuilderFromWithOverlayDiagramInstanceCreateCommand3() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();
    OverlayDiagramInstanceCreateCommand instance = mock(OverlayDiagramInstanceCreateCommand.class);
    when(instance.svg()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagramId()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).diagramId();
    verify(instance).parentEntityReference();
    verify(instance).svg();
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#parentEntityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentEntityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentEntityReference(EntityReference)"})
  void testBuilderParentEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#svg(String)}.
   * <p>
   * Method under test: {@link Builder#svg(String)}
   */
  @Test
  @DisplayName("Test Builder svg(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.svg(String)"})
  void testBuilderSvg() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.svg("Svg"));
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#diagramId()}.
   * <p>
   * Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).diagramId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setDiagramId(Long)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setParentEntityReference(EntityReference)}
   *   <li>{@link Json#setSvg(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setDiagramId(Long)",
      "void Json.setName(String)", "void Json.setParentEntityReference(EntityReference)", "void Json.setSvg(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setDiagramId(1L);
    actualJson.setName("Name");
    actualJson.setParentEntityReference(null);
    actualJson.setSvg("Svg");

    // Assert
    assertEquals(1L, actualJson.diagramId.longValue());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json {@link Json#parentEntityReference()}.
   * <p>
   * Method under test: {@link Json#parentEntityReference()}
   */
  @Test
  @DisplayName("Test Json parentEntityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.parentEntityReference()"})
  void testJsonParentEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentEntityReference());
  }

  /**
   * Test Json {@link Json#svg()}.
   * <p>
   * Method under test: {@link Json#svg()}
   */
  @Test
  @DisplayName("Test Json svg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.svg()"})
  void testJsonSvg() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).svg());
  }
}
