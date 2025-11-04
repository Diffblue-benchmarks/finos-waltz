package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.DescriptionProvider;
import org.junit.jupiter.api.Test;

class ImmutableUpdateEntityRelationshipParamsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#builder()}
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableUpdateEntityRelationshipParams.Builder actualBuilderResult = ImmutableUpdateEntityRelationshipParams
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateEntityRelationshipParams.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams.Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableUpdateEntityRelationshipParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateEntityRelationshipParams.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams.Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableUpdateEntityRelationshipParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateEntityRelationshipParams.Builder#from(UpdateEntityRelationshipParams)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams.Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    UpdateEntityRelationshipParams instance = mock(UpdateEntityRelationshipParams.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.relationshipKind()).thenReturn("Relationship Kind");

    // Act
    ImmutableUpdateEntityRelationshipParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).relationshipKind();
    ImmutableUpdateEntityRelationshipParams buildResult = builderResult.build();
    assertEquals("Relationship Kind", buildResult.relationshipKind());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateEntityRelationshipParams.Builder#from(UpdateEntityRelationshipParams)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams.Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    UpdateEntityRelationshipParams instance = mock(UpdateEntityRelationshipParams.class);
    when(instance.description()).thenReturn(null);
    when(instance.relationshipKind()).thenReturn("Relationship Kind");

    // Act
    ImmutableUpdateEntityRelationshipParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).relationshipKind();
    ImmutableUpdateEntityRelationshipParams buildResult = builderResult.build();
    assertEquals("Relationship Kind", buildResult.relationshipKind());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateEntityRelationshipParams.Builder#relationshipKind(String)}
   */
  @Test
  void testBuilderRelationshipKind() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams.Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();

    // Act
    ImmutableUpdateEntityRelationshipParams.Builder actualRelationshipKindResult = builderResult
        .relationshipKind("Relationship Kind");

    // Assert
    ImmutableUpdateEntityRelationshipParams buildResult = builderResult.build();
    assertEquals("Relationship Kind", buildResult.relationshipKind());
    assertNull(buildResult.description());
    assertSame(builderResult, actualRelationshipKindResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateEntityRelationshipParams#copyOf(UpdateEntityRelationshipParams)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateEntityRelationshipParams instance = mock(UpdateEntityRelationshipParams.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.relationshipKind()).thenReturn("Relationship Kind");

    // Act
    ImmutableUpdateEntityRelationshipParams actualCopyOfResult = ImmutableUpdateEntityRelationshipParams
        .copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).relationshipKind();
    assertEquals("Relationship Kind", actualCopyOfResult.relationshipKind());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateEntityRelationshipParams#fromJson(ImmutableUpdateEntityRelationshipParams.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUpdateEntityRelationshipParams.Json json = new ImmutableUpdateEntityRelationshipParams.Json();
    json.setDescription(null);
    json.setRelationshipKind("Json");

    // Act
    ImmutableUpdateEntityRelationshipParams actualFromJsonResult = ImmutableUpdateEntityRelationshipParams
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.relationshipKind());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateEntityRelationshipParams.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateEntityRelationshipParams.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUpdateEntityRelationshipParams.Json}
   *   <li>
   * {@link ImmutableUpdateEntityRelationshipParams.Json#setDescription(String)}
   *   <li>
   * {@link ImmutableUpdateEntityRelationshipParams.Json#setRelationshipKind(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUpdateEntityRelationshipParams.Json actualJson = new ImmutableUpdateEntityRelationshipParams.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setRelationshipKind("Relationship Kind");

    // Assert
    assertEquals("Relationship Kind", actualJson.relationshipKind);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateEntityRelationshipParams.Json#relationshipKind()}
   */
  @Test
  void testJsonRelationshipKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateEntityRelationshipParams.Json()).relationshipKind());
  }
}
