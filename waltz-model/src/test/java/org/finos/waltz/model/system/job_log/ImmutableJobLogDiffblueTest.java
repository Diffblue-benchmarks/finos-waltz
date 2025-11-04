package org.finos.waltz.model.system.job_log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableJobLogDiffblueTest {
  /**
   * Method under test: {@link ImmutableJobLog.Builder#entityKind(EntityKind)}
   */
  @Test
  void testBuilderEntityKind() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableJobLog.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableJobLog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableJobLog.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableJobLog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableJobLog.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableJobLog.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableJobLog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableJobLog.Builder#from(JobLog)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();
    JobLog instance = mock(JobLog.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.end()).thenReturn(ofResult);
    when(instance.status()).thenReturn(JobStatus.SUCCESS);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.start()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableJobLog.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableJobLog.Builder#from(JobLog)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();
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
   * Method under test: {@link ImmutableJobLog.Builder#from(JobLog)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();
    JobLog instance = mock(JobLog.class);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.end()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(JobStatus.SUCCESS);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.start()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableJobLog.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableJobLog.Builder#from(JobLog)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();
    JobLog instance = mock(JobLog.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.end()).thenReturn(ofResult);
    when(instance.status()).thenReturn(JobStatus.SUCCESS);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.start()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableJobLog.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableJobLog.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableJobLog.Builder#start(LocalDateTime)}
   */
  @Test
  void testBuilderStart() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.start(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test: {@link ImmutableJobLog.Builder#status(JobStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableJobLog.Builder builderResult = ImmutableJobLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(JobStatus.SUCCESS));
  }

  /**
   * Method under test: {@link ImmutableJobLog#copyOf(JobLog)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    JobLog instance = mock(JobLog.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.end()).thenReturn(ofResult);
    when(instance.status()).thenReturn(JobStatus.SUCCESS);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.start()).thenReturn(ofResult2.atStartOfDay());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableJobLog actualCopyOfResult = ImmutableJobLog.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).end();
    verify(instance).entityKind();
    verify(instance).start();
    verify(instance).status();
    LocalDateTime startResult = actualCopyOfResult.start();
    assertEquals("00:00", startResult.toLocalTime().toString());
    LocalDate toLocalDateResult = startResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualCopyOfResult.status());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableJobLog#copyOf(JobLog)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    JobLog instance = mock(JobLog.class);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.end()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(JobStatus.SUCCESS);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.start()).thenReturn(ofResult.atStartOfDay());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableJobLog actualCopyOfResult = ImmutableJobLog.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).end();
    verify(instance).entityKind();
    verify(instance).start();
    verify(instance).status();
    LocalDateTime startResult = actualCopyOfResult.start();
    assertEquals("00:00", startResult.toLocalTime().toString());
    LocalDate toLocalDateResult = startResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualCopyOfResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableJobLog#fromJson(ImmutableJobLog.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableJobLog.Json json = new ImmutableJobLog.Json();
    json.setName("Json");
    json.setDescription(null);
    json.setStatus(JobStatus.SUCCESS);
    json.setEntityKind(EntityKind.ALL);
    json.setStart(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setEnd(null);

    // Act
    ImmutableJobLog actualFromJsonResult = ImmutableJobLog.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.entityKind());
    assertEquals(JobStatus.SUCCESS, actualFromJsonResult.status());
    LocalDateTime expectedStartResult = json.start;
    assertSame(expectedStartResult, actualFromJsonResult.start());
  }

  /**
   * Method under test: {@link ImmutableJobLog.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableJobLog.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableJobLog.Json#end()}
   */
  @Test
  void testJsonEnd() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableJobLog.Json()).end());
  }

  /**
   * Method under test: {@link ImmutableJobLog.Json#entityKind()}
   */
  @Test
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableJobLog.Json()).entityKind());
  }

  /**
   * Method under test: {@link ImmutableJobLog.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableJobLog.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableJobLog.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableJobLog.Json actualJson = new ImmutableJobLog.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.start);
    assertNull(actualJson.entityKind);
    assertNull(actualJson.status);
    assertFalse(actualJson.end.isPresent());
  }

  /**
   * Method under test: {@link ImmutableJobLog.Json#start()}
   */
  @Test
  void testJsonStart() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableJobLog.Json()).start());
  }

  /**
   * Method under test: {@link ImmutableJobLog.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableJobLog.Json()).status());
  }
}
