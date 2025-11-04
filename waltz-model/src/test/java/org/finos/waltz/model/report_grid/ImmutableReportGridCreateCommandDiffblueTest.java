package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ImmutableReportGridCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridCreateCommand#builder()}
   *   <li>{@link ImmutableReportGridCreateCommand#description(String)}
   *   <li>{@link ImmutableReportGridCreateCommand#kind(ReportGridKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridCreateCommand.Builder actualDescriptionResult = ImmutableReportGridCreateCommand.builder()
        .description("The characteristics of someone or something");

    // Assert
    assertSame(actualDescriptionResult, actualDescriptionResult.kind(ReportGridKind.PUBLIC));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand.Builder#from(ReportGridCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridCreateCommand.Builder builderResult = ImmutableReportGridCreateCommand.builder();
    ReportGridCreateCommand instance = mock(ReportGridCreateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).subjectKind();
    ImmutableReportGridCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand.Builder#from(ReportGridCreateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridCreateCommand.Builder builderResult = ImmutableReportGridCreateCommand.builder();
    ReportGridCreateCommand instance = mock(ReportGridCreateCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).subjectKind();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand.Builder#from(ReportGridCreateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridCreateCommand.Builder builderResult = ImmutableReportGridCreateCommand.builder();
    ReportGridCreateCommand instance = mock(ReportGridCreateCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).subjectKind();
    ImmutableReportGridCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableReportGridCreateCommand.Builder builderResult = ImmutableReportGridCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutableReportGridCreateCommand.Builder builderResult = ImmutableReportGridCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand#copyOf(ReportGridCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridCreateCommand instance = mock(ReportGridCreateCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridCreateCommand actualCopyOfResult = ImmutableReportGridCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand#copyOf(ReportGridCreateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ReportGridCreateCommand instance = mock(ReportGridCreateCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridCreateCommand actualCopyOfResult = ImmutableReportGridCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand#fromJson(ImmutableReportGridCreateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGridCreateCommand.Json json = new ImmutableReportGridCreateCommand.Json();
    json.setName("Json");
    json.setSubjectKind(EntityKind.ALL);
    json.setDescription(null);
    json.setKind(null);

    // Act
    ImmutableReportGridCreateCommand actualFromJsonResult = ImmutableReportGridCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(ReportGridKind.PRIVATE, actualFromJsonResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand#fromJson(ImmutableReportGridCreateCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableReportGridCreateCommand.Json json = new ImmutableReportGridCreateCommand.Json();
    json.setName("Json");
    json.setSubjectKind(EntityKind.ALL);
    json.setDescription(null);
    json.setKind(ReportGridKind.PUBLIC);

    // Act
    ImmutableReportGridCreateCommand actualFromJsonResult = ImmutableReportGridCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualFromJsonResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridCreateCommand.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableReportGridCreateCommand.Json}
   *   <li>{@link ImmutableReportGridCreateCommand.Json#setDescription(String)}
   *   <li>{@link ImmutableReportGridCreateCommand.Json#setKind(ReportGridKind)}
   *   <li>{@link ImmutableReportGridCreateCommand.Json#setName(String)}
   *   <li>{@link ImmutableReportGridCreateCommand.Json#setSubjectKind(EntityKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableReportGridCreateCommand.Json actualJson = new ImmutableReportGridCreateCommand.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(ReportGridKind.PUBLIC);
    actualJson.setName("Name");
    actualJson.setSubjectKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(EntityKind.ALL, actualJson.subjectKind);
    assertEquals(ReportGridKind.PUBLIC, actualJson.kind);
  }

  /**
   * Method under test: {@link ImmutableReportGridCreateCommand.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCreateCommand.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableReportGridCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCreateCommand.Json()).name());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCreateCommand.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridCreateCommand.Json()).subjectKind());
  }
}
