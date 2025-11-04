package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableReportGridUpdateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridUpdateCommand#builder()}
   *   <li>{@link ImmutableReportGridUpdateCommand#description(String)}
   *   <li>{@link ImmutableReportGridUpdateCommand#kind(ReportGridKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridUpdateCommand.Builder actualDescriptionResult = ImmutableReportGridUpdateCommand.builder()
        .description("The characteristics of someone or something");

    // Assert
    assertSame(actualDescriptionResult, actualDescriptionResult.kind(ReportGridKind.PUBLIC));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridUpdateCommand.Builder#from(ReportGridUpdateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridUpdateCommand.Builder builderResult = ImmutableReportGridUpdateCommand.builder();
    ReportGridUpdateCommand instance = mock(ReportGridUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridUpdateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableReportGridUpdateCommand.Builder#from(ReportGridUpdateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridUpdateCommand.Builder builderResult = ImmutableReportGridUpdateCommand.builder();
    ReportGridUpdateCommand instance = mock(ReportGridUpdateCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridUpdateCommand.Builder#from(ReportGridUpdateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridUpdateCommand.Builder builderResult = ImmutableReportGridUpdateCommand.builder();
    ReportGridUpdateCommand instance = mock(ReportGridUpdateCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridUpdateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableReportGridUpdateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableReportGridUpdateCommand.Builder builderResult = ImmutableReportGridUpdateCommand.builder();

    // Act
    ImmutableReportGridUpdateCommand.Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableReportGridUpdateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridUpdateCommand#copyOf(ReportGridUpdateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridUpdateCommand instance = mock(ReportGridUpdateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridUpdateCommand actualCopyOfResult = ImmutableReportGridUpdateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).name();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridUpdateCommand#copyOf(ReportGridUpdateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ReportGridUpdateCommand instance = mock(ReportGridUpdateCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridUpdateCommand actualCopyOfResult = ImmutableReportGridUpdateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).name();
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridUpdateCommand#fromJson(ImmutableReportGridUpdateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGridUpdateCommand.Json json = new ImmutableReportGridUpdateCommand.Json();
    json.setName("Json");
    json.setDescription(null);
    json.setKind(null);

    // Act
    ImmutableReportGridUpdateCommand actualFromJsonResult = ImmutableReportGridUpdateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(ReportGridKind.PUBLIC, actualFromJsonResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridUpdateCommand#fromJson(ImmutableReportGridUpdateCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableReportGridUpdateCommand.Json json = new ImmutableReportGridUpdateCommand.Json();
    json.setName("Json");
    json.setDescription(null);
    json.setKind(ReportGridKind.PUBLIC);

    // Act
    ImmutableReportGridUpdateCommand actualFromJsonResult = ImmutableReportGridUpdateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(ReportGridKind.PUBLIC, actualFromJsonResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridUpdateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridUpdateCommand.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableReportGridUpdateCommand.Json}
   *   <li>{@link ImmutableReportGridUpdateCommand.Json#setDescription(String)}
   *   <li>{@link ImmutableReportGridUpdateCommand.Json#setKind(ReportGridKind)}
   *   <li>{@link ImmutableReportGridUpdateCommand.Json#setName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableReportGridUpdateCommand.Json actualJson = new ImmutableReportGridUpdateCommand.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(ReportGridKind.PUBLIC);
    actualJson.setName("Name");

    // Assert
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(ReportGridKind.PUBLIC, actualJson.kind);
  }

  /**
   * Method under test: {@link ImmutableReportGridUpdateCommand.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridUpdateCommand.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableReportGridUpdateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridUpdateCommand.Json()).name());
  }
}
