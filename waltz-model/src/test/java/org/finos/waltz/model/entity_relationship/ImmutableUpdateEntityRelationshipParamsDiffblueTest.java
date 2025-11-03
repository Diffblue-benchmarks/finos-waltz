package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.entity_relationship.ImmutableUpdateEntityRelationshipParams.Builder;
import org.finos.waltz.model.entity_relationship.ImmutableUpdateEntityRelationshipParams.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateEntityRelationshipParamsDiffblueTest {
  /**
   * Test {@link ImmutableUpdateEntityRelationshipParams#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#builder()}
   *   <li>{@link ImmutableUpdateEntityRelationshipParams#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateEntityRelationshipParams Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableUpdateEntityRelationshipParams.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
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
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
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
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateEntityRelationshipParams)} with {@code UpdateEntityRelationshipParams}.
   * <p>
   * Method under test: {@link Builder#from(UpdateEntityRelationshipParams)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateEntityRelationshipParams) with 'UpdateEntityRelationshipParams'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateEntityRelationshipParams)"})
  void testBuilderFromWithUpdateEntityRelationshipParams() {
    // Arrange
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    UpdateEntityRelationshipParams instance = mock(UpdateEntityRelationshipParams.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.relationshipKind()).thenReturn("Relationship Kind");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).relationshipKind();
    ImmutableUpdateEntityRelationshipParams buildResult = builderResult.build();
    assertEquals("Relationship Kind", buildResult.relationshipKind());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateEntityRelationshipParams)} with {@code UpdateEntityRelationshipParams}.
   * <p>
   * Method under test: {@link Builder#from(UpdateEntityRelationshipParams)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateEntityRelationshipParams) with 'UpdateEntityRelationshipParams'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateEntityRelationshipParams)"})
  void testBuilderFromWithUpdateEntityRelationshipParams2() {
    // Arrange
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();
    UpdateEntityRelationshipParams instance = mock(UpdateEntityRelationshipParams.class);
    when(instance.description()).thenReturn(null);
    when(instance.relationshipKind()).thenReturn("Relationship Kind");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).relationshipKind();
    ImmutableUpdateEntityRelationshipParams buildResult = builderResult.build();
    assertEquals("Relationship Kind", buildResult.relationshipKind());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#relationshipKind(String)}.
   * <p>
   * Method under test: {@link Builder#relationshipKind(String)}
   */
  @Test
  @DisplayName("Test Builder relationshipKind(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relationshipKind(String)"})
  void testBuilderRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableUpdateEntityRelationshipParams.builder();

    // Act
    Builder actualRelationshipKindResult = builderResult.relationshipKind("Relationship Kind");

    // Assert
    ImmutableUpdateEntityRelationshipParams buildResult = builderResult.build();
    assertEquals("Relationship Kind", buildResult.relationshipKind());
    assertNull(buildResult.description());
    assertSame(builderResult, actualRelationshipKindResult);
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
   *   <li>{@link Json#setRelationshipKind(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setRelationshipKind(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setRelationshipKind("Relationship Kind");

    // Assert
    assertEquals("Relationship Kind", actualJson.relationshipKind);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Test Json {@link Json#relationshipKind()}.
   * <p>
   * Method under test: {@link Json#relationshipKind()}
   */
  @Test
  @DisplayName("Test Json relationshipKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.relationshipKind()"})
  void testJsonRelationshipKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relationshipKind());
  }
}
