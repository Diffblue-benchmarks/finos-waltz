package org.finos.waltz.model.rel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableUpdateRelationshipKindCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#builder()}
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableUpdateRelationshipKindCommand.Builder actualBuilderResult = ImmutableUpdateRelationshipKindCommand
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableUpdateRelationshipKindCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableUpdateRelationshipKindCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableUpdateRelationshipKindCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#from(UpdateRelationshipKindCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    UpdateRelationshipKindCommand instance = mock(UpdateRelationshipKindCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableUpdateRelationshipKindCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableUpdateRelationshipKindCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#from(UpdateRelationshipKindCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    UpdateRelationshipKindCommand instance = mock(UpdateRelationshipKindCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#from(UpdateRelationshipKindCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    UpdateRelationshipKindCommand instance = mock(UpdateRelationshipKindCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableUpdateRelationshipKindCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableUpdateRelationshipKindCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Builder#reverseName(String)}
   */
  @Test
  void testBuilderReverseName() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.reverseName("Reverse Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand#copyOf(UpdateRelationshipKindCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateRelationshipKindCommand instance = mock(UpdateRelationshipKindCommand.class);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableUpdateRelationshipKindCommand actualCopyOfResult = ImmutableUpdateRelationshipKindCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).reverseName();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Reverse Name", actualCopyOfResult.reverseName());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateRelationshipKindCommand.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUpdateRelationshipKindCommand.Json}
   *   <li>
   * {@link ImmutableUpdateRelationshipKindCommand.Json#setDescription(String)}
   *   <li>{@link ImmutableUpdateRelationshipKindCommand.Json#setName(String)}
   *   <li>
   * {@link ImmutableUpdateRelationshipKindCommand.Json#setReverseName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUpdateRelationshipKindCommand.Json actualJson = new ImmutableUpdateRelationshipKindCommand.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setName("Name");
    actualJson.setReverseName("Reverse Name");

    // Assert
    assertEquals("Name", actualJson.name);
    assertEquals("Reverse Name", actualJson.reverseName);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableUpdateRelationshipKindCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateRelationshipKindCommand.Json()).name());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateRelationshipKindCommand.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Json#reverseName()}
   */
  @Test
  void testJsonReverseName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateRelationshipKindCommand.Json()).reverseName());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRelationshipKindCommand.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand.Json json = new ImmutableUpdateRelationshipKindCommand.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
