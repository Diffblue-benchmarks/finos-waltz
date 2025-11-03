package org.finos.waltz.model.system.job_log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.system.job_log.ImmutableJobLog.Builder;
import org.finos.waltz.model.system.job_log.ImmutableJobLog.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableJobLogDiffblueTest {
  /**
   * Test {@link ImmutableJobLog#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableJobLog#builder()}
   *   <li>{@link ImmutableJobLog#description(String)}
   *   <li>{@link ImmutableJobLog#end(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableJobLog Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.end(LocalDateTime)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDescriptionResult = ImmutableJobLog.builder()
        .description("The characteristics of someone or something");
    Builder actualEndResult = actualDescriptionResult.end(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> end = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualEndResult, actualEndResult.end(end));
  }

  /**
   * Test Builder {@link Builder#end(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#end(Optional)}
   */
  @Test
  @DisplayName("Test Builder end(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.end(Optional)"})
  void testBuilderEndWithOptional() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    Optional<? extends LocalDateTime> end = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertSame(builderResult, builderResult.end(end));
  }

  /**
   * Test Builder {@link Builder#entityKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#entityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder entityKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityKind(EntityKind)"})
  void testBuilderEntityKind() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
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
    Builder builderResult = ImmutableJobLog.builder();
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
    Builder builderResult = ImmutableJobLog.builder();
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
    Builder builderResult = ImmutableJobLog.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(JobLog)} with {@code JobLog}.
   * <p>
   * Method under test: {@link Builder#from(JobLog)}
   */
  @Test
  @DisplayName("Test Builder from(JobLog) with 'JobLog'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(JobLog)"})
  void testBuilderFromWithJobLog() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    JobLog instance = mock(JobLog.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.end()).thenReturn(ofResult);
    when(instance.status()).thenReturn(JobStatus.SUCCESS);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.start()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).end();
    verify(instance).entityKind();
    verify(instance).start();
    verify(instance).status();
    ImmutableJobLog buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(JobStatus.SUCCESS, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(JobLog)} with {@code JobLog}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link JobLog} {@link JobLog#end()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(JobLog)}
   */
  @Test
  @DisplayName("Test Builder from(JobLog) with 'JobLog'; given empty; when JobLog end() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(JobLog)"})
  void testBuilderFromWithJobLog_givenEmpty_whenJobLogEndReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    JobLog instance = mock(JobLog.class);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.end()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(JobStatus.SUCCESS);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.start()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).end();
    verify(instance).entityKind();
    verify(instance).start();
    verify(instance).status();
    ImmutableJobLog buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(JobStatus.SUCCESS, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(JobLog)} with {@code JobLog}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(JobLog)}
   */
  @Test
  @DisplayName("Test Builder from(JobLog) with 'JobLog'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(JobLog)"})
  void testBuilderFromWithJobLog_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    JobLog instance = mock(JobLog.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.end()).thenReturn(ofResult);
    when(instance.status()).thenReturn(JobStatus.SUCCESS);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.start()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).end();
    verify(instance).entityKind();
    verify(instance).start();
    verify(instance).status();
    ImmutableJobLog buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(JobStatus.SUCCESS, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(JobLog)} with {@code JobLog}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(JobLog)}
   */
  @Test
  @DisplayName("Test Builder from(JobLog) with 'JobLog'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(JobLog)"})
  void testBuilderFromWithJobLog_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();
    JobLog instance = mock(JobLog.class);
    when(instance.end()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.start()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).end();
    verify(instance).entityKind();
    verify(instance).start();
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
    Builder builderResult = ImmutableJobLog.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableJobLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#start(LocalDateTime)}.
   * <p>
   * Method under test: {@link Builder#start(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder start(LocalDateTime)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.start(LocalDateTime)"})
  void testBuilderStart() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.start(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#status(JobStatus)}.
   * <p>
   * Method under test: {@link Builder#status(JobStatus)}
   */
  @Test
  @DisplayName("Test Builder status(JobStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.status(JobStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableJobLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(JobStatus.SUCCESS));
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
   * Test Json {@link Json#end()}.
   * <p>
   * Method under test: {@link Json#end()}
   */
  @Test
  @DisplayName("Test Json end()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.end()"})
  void testJsonEnd() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).end());
  }

  /**
   * Test Json {@link Json#entityKind()}.
   * <p>
   * Method under test: {@link Json#entityKind()}
   */
  @Test
  @DisplayName("Test Json entityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.entityKind()"})
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityKind());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.start);
    assertNull(actualJson.entityKind);
    assertNull(actualJson.status);
    assertFalse(actualJson.end.isPresent());
  }

  /**
   * Test Json {@link Json#start()}.
   * <p>
   * Method under test: {@link Json#start()}
   */
  @Test
  @DisplayName("Test Json start()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.start()"})
  void testJsonStart() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).start());
  }

  /**
   * Test Json {@link Json#status()}.
   * <p>
   * Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JobStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).status());
  }
}
