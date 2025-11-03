package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.report_grid.ImmutableReportGridUpdateCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridUpdateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridUpdateCommandDiffblueTest {
  /**
   * Test {@link ImmutableReportGridUpdateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridUpdateCommand#builder()}
   *   <li>{@link ImmutableReportGridUpdateCommand#description(String)}
   *   <li>{@link ImmutableReportGridUpdateCommand#kind(ReportGridKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridUpdateCommand Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.kind(ReportGridKind)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDescriptionResult = ImmutableReportGridUpdateCommand.builder()
        .description("The characteristics of someone or something");

    // Assert
    assertSame(actualDescriptionResult, actualDescriptionResult.kind(ReportGridKind.PUBLIC));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridUpdateCommand)}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridUpdateCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridUpdateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableReportGridUpdateCommand.builder();
    ReportGridUpdateCommand instance = mock(ReportGridUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).name();
    ImmutableReportGridUpdateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridUpdateCommand)}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridUpdateCommand); then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridUpdateCommand)"})
  void testBuilderFrom_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridUpdateCommand.builder();
    ReportGridUpdateCommand instance = mock(ReportGridUpdateCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).name();
    ImmutableReportGridUpdateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridUpdateCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridUpdateCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridUpdateCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridUpdateCommand.builder();
    ReportGridUpdateCommand instance = mock(ReportGridUpdateCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
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
    Builder builderResult = ImmutableReportGridUpdateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableReportGridUpdateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualNameResult);
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
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setKind(ReportGridKind)}
   *   <li>{@link Json#setName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setKind(ReportGridKind)",
      "void Json.setName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(ReportGridKind.PUBLIC);
    actualJson.setName("Name");

    // Assert
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(ReportGridKind.PUBLIC, actualJson.kind);
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReportGridKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
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
}
