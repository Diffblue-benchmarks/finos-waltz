package org.finos.waltz.model.entity_workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityWorkflowDefinitionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowDefinition#builder()}
   *   <li>{@link ImmutableEntityWorkflowDefinition#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityWorkflowDefinition.Builder actualIdResult = ImmutableEntityWorkflowDefinition.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEntityWorkflowDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEntityWorkflowDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityWorkflowDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityWorkflowDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityWorkflowDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableEntityWorkflowDefinition buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(EntityWorkflowDefinition)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    EntityWorkflowDefinition instance = mock(EntityWorkflowDefinition.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityWorkflowDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    ImmutableEntityWorkflowDefinition buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(EntityWorkflowDefinition)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    EntityWorkflowDefinition instance = mock(EntityWorkflowDefinition.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(EntityWorkflowDefinition)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    EntityWorkflowDefinition instance = mock(EntityWorkflowDefinition.class);
    when(instance.description()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityWorkflowDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    ImmutableEntityWorkflowDefinition buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#from(EntityWorkflowDefinition)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    EntityWorkflowDefinition instance = mock(EntityWorkflowDefinition.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityWorkflowDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    ImmutableEntityWorkflowDefinition buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowDefinition.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Builder builderResult = ImmutableEntityWorkflowDefinition.builder();

    // Act
    ImmutableEntityWorkflowDefinition.Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableEntityWorkflowDefinition buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition#copyOf(EntityWorkflowDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityWorkflowDefinition instance = mock(EntityWorkflowDefinition.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityWorkflowDefinition actualCopyOfResult = ImmutableEntityWorkflowDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition#copyOf(EntityWorkflowDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityWorkflowDefinition instance = mock(EntityWorkflowDefinition.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityWorkflowDefinition actualCopyOfResult = ImmutableEntityWorkflowDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition#fromJson(ImmutableEntityWorkflowDefinition.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityWorkflowDefinition.Json json = new ImmutableEntityWorkflowDefinition.Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);

    // Act
    ImmutableEntityWorkflowDefinition actualFromJsonResult = ImmutableEntityWorkflowDefinition.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWorkflowDefinition.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityWorkflowDefinition.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowDefinition.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityWorkflowDefinition.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityWorkflowDefinition.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityWorkflowDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityWorkflowDefinition.Json actualJson = new ImmutableEntityWorkflowDefinition.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
  }
}
