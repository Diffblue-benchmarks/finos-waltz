package org.finos.waltz.model.accesslog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ImmutableAccessLogDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAccessLog#builder()}
   *   <li>{@link ImmutableAccessLog#createdAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAccessLog.Builder actualBuilderResult = ImmutableAccessLog.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test: {@link ImmutableAccessLog.Builder#from(AccessLog)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAccessLog.Builder builderResult = ImmutableAccessLog.builder();
    AccessLog instance = mock(AccessLog.class);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.userId()).thenReturn("42");
    when(instance.params()).thenReturn("Params");
    when(instance.state()).thenReturn("MD");

    // Act
    ImmutableAccessLog.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).params();
    verify(instance).state();
    verify(instance).userId();
    ImmutableAccessLog buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals("MD", buildResult.state());
    assertEquals("Params", buildResult.params());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAccessLog.Builder#from(AccessLog)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAccessLog.Builder builderResult = ImmutableAccessLog.builder();
    AccessLog instance = mock(AccessLog.class);
    when(instance.createdAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");
    when(instance.params()).thenReturn("Params");
    when(instance.state()).thenReturn("MD");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).params();
    verify(instance).state();
    verify(instance).userId();
  }

  /**
   * Method under test: {@link ImmutableAccessLog.Builder#params(String)}
   */
  @Test
  void testBuilderParams() {
    // Arrange
    ImmutableAccessLog.Builder builderResult = ImmutableAccessLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.params("Params"));
  }

  /**
   * Method under test: {@link ImmutableAccessLog.Builder#state(String)}
   */
  @Test
  void testBuilderState() {
    // Arrange
    ImmutableAccessLog.Builder builderResult = ImmutableAccessLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.state("MD"));
  }

  /**
   * Method under test: {@link ImmutableAccessLog.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableAccessLog.Builder builderResult = ImmutableAccessLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Method under test: {@link ImmutableAccessLog#copyOf(AccessLog)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AccessLog instance = mock(AccessLog.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.userId()).thenReturn("42");
    when(instance.params()).thenReturn("Params");
    when(instance.state()).thenReturn("MD");

    // Act
    ImmutableAccessLog actualCopyOfResult = ImmutableAccessLog.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).params();
    verify(instance).state();
    verify(instance).userId();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("MD", actualCopyOfResult.state());
    assertEquals("Params", actualCopyOfResult.params());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAccessLog#fromJson(ImmutableAccessLog.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAccessLog.Json json = new ImmutableAccessLog.Json();
    json.setState("Json");
    json.setParams("Json");
    json.setUserId("Json");
    json.setCreatedAt(null);

    // Act
    ImmutableAccessLog actualFromJsonResult = ImmutableAccessLog.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.params());
    assertEquals("Json", actualFromJsonResult.state());
    assertEquals("Json", actualFromJsonResult.userId());
  }

  /**
   * Method under test:
   * {@link ImmutableAccessLog#fromJson(ImmutableAccessLog.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAccessLog.Json json = new ImmutableAccessLog.Json();
    json.setState("Json");
    json.setParams("Json");
    json.setUserId("Json");
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableAccessLog actualFromJsonResult = ImmutableAccessLog.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.params());
    assertEquals("Json", actualFromJsonResult.state());
    assertEquals("Json", actualFromJsonResult.userId());
    LocalDateTime expectedCreatedAtResult = json.createdAt;
    assertSame(expectedCreatedAtResult, actualFromJsonResult.createdAt());
  }

  /**
   * Method under test: {@link ImmutableAccessLog.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAccessLog.Json()).createdAt());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableAccessLog.Json}
   *   <li>{@link ImmutableAccessLog.Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link ImmutableAccessLog.Json#setParams(String)}
   *   <li>{@link ImmutableAccessLog.Json#setState(String)}
   *   <li>{@link ImmutableAccessLog.Json#setUserId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAccessLog.Json actualJson = new ImmutableAccessLog.Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setParams("Params");
    actualJson.setState("MD");
    actualJson.setUserId("42");

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAccessLog.Json#params()}
   */
  @Test
  void testJsonParams() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAccessLog.Json()).params());
  }

  /**
   * Method under test: {@link ImmutableAccessLog.Json#state()}
   */
  @Test
  void testJsonState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAccessLog.Json()).state());
  }

  /**
   * Method under test: {@link ImmutableAccessLog.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAccessLog.Json()).userId());
  }
}
