package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableMyEntityDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMyEntity#builder()}
   *   <li>{@link ImmutableMyEntity#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMyEntity.Builder actualBuilderResult = ImmutableMyEntity.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test: {@link ImmutableMyEntity.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableMyEntity.Builder builderResult = ImmutableMyEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableMyEntity.Builder#from(ImporterExperiment.MyEntity)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMyEntity.Builder builderResult = ImmutableMyEntity.builder();
    ImporterExperiment.MyEntity instance = mock(ImporterExperiment.MyEntity.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMyEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    ImmutableMyEntity buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMyEntity.Builder#from(ImporterExperiment.MyEntity)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMyEntity.Builder builderResult = ImmutableMyEntity.builder();
    ImporterExperiment.MyEntity instance = mock(ImporterExperiment.MyEntity.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableMyEntity.Builder#from(ImporterExperiment.MyEntity)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMyEntity.Builder builderResult = ImmutableMyEntity.builder();
    ImporterExperiment.MyEntity instance = mock(ImporterExperiment.MyEntity.class);
    when(instance.description()).thenReturn(null);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMyEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    ImmutableMyEntity buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMyEntity.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableMyEntity.Builder builderResult = ImmutableMyEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableMyEntity#copyOf(ImporterExperiment.MyEntity)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ImporterExperiment.MyEntity instance = mock(ImporterExperiment.MyEntity.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMyEntity actualCopyOfResult = ImmutableMyEntity.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableMyEntity#fromJson(ImmutableMyEntity.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMyEntity.Json json = new ImmutableMyEntity.Json();
    json.setName("Json");
    json.setExternalId("Json");
    json.setDescription(null);

    // Act
    ImmutableMyEntity actualFromJsonResult = ImmutableMyEntity.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Method under test: {@link ImmutableMyEntity.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMyEntity.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableMyEntity.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMyEntity.Json()).externalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableMyEntity.Json}
   *   <li>{@link ImmutableMyEntity.Json#setDescription(String)}
   *   <li>{@link ImmutableMyEntity.Json#setExternalId(String)}
   *   <li>{@link ImmutableMyEntity.Json#setName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMyEntity.Json actualJson = new ImmutableMyEntity.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setExternalId("42");
    actualJson.setName("Name");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Method under test: {@link ImmutableMyEntity.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMyEntity.Json()).name());
  }
}
