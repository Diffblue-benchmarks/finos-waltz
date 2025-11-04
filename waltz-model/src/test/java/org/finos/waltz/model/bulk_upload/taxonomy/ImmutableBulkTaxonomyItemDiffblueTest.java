package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyItem#builder()}
   *   <li>{@link ImmutableBulkTaxonomyItem#description(String)}
   *   <li>{@link ImmutableBulkTaxonomyItem#parentExternalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkTaxonomyItem.Builder actualDescriptionResult = ImmutableBulkTaxonomyItem.builder()
        .description("The characteristics of someone or something");

    // Assert
    assertSame(actualDescriptionResult, actualDescriptionResult.parentExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyItem.Builder#concrete(boolean)}
   */
  @Test
  void testBuilderConcrete() {
    // Arrange
    ImmutableBulkTaxonomyItem.Builder builderResult = ImmutableBulkTaxonomyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.concrete(true));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyItem.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableBulkTaxonomyItem.Builder builderResult = ImmutableBulkTaxonomyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyItem.Builder#from(BulkTaxonomyItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkTaxonomyItem.Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.concrete()).thenReturn(true);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableBulkTaxonomyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).concrete();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
    ImmutableBulkTaxonomyItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyItem.Builder#from(BulkTaxonomyItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkTaxonomyItem.Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.parentExternalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyItem.Builder#from(BulkTaxonomyItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkTaxonomyItem.Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.description()).thenReturn(null);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.concrete()).thenReturn(true);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableBulkTaxonomyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).concrete();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
    ImmutableBulkTaxonomyItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyItem.Builder#from(BulkTaxonomyItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkTaxonomyItem.Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentExternalId()).thenReturn(null);
    when(instance.concrete()).thenReturn(true);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableBulkTaxonomyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).concrete();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
    ImmutableBulkTaxonomyItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.parentExternalId());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyItem.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableBulkTaxonomyItem.Builder builderResult = ImmutableBulkTaxonomyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyItem#copyOf(BulkTaxonomyItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.concrete()).thenReturn(true);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableBulkTaxonomyItem actualCopyOfResult = ImmutableBulkTaxonomyItem.copyOf(instance);

    // Assert
    verify(instance).concrete();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.parentExternalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.concrete());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyItem#copyOf(BulkTaxonomyItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.concrete()).thenReturn(false);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableBulkTaxonomyItem actualCopyOfResult = ImmutableBulkTaxonomyItem.copyOf(instance);

    // Assert
    verify(instance).concrete();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.parentExternalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertFalse(actualCopyOfResult.concrete());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyItem#fromJson(ImmutableBulkTaxonomyItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    json.setExternalId("42");
    json.setName("name");

    // Act
    ImmutableBulkTaxonomyItem actualFromJsonResult = ImmutableBulkTaxonomyItem.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.externalId());
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.parentExternalId());
    assertTrue(actualFromJsonResult.concrete());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyItem.Json#concrete()}
   */
  @Test
  void testJsonConcrete() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyItem.Json()).concrete());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyItem.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyItem.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyItem.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyItem.Json()).externalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkTaxonomyItem.Json}
   *   <li>{@link ImmutableBulkTaxonomyItem.Json#setDescription(String)}
   *   <li>{@link ImmutableBulkTaxonomyItem.Json#setExternalId(String)}
   *   <li>{@link ImmutableBulkTaxonomyItem.Json#setName(String)}
   *   <li>{@link ImmutableBulkTaxonomyItem.Json#setParentExternalId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkTaxonomyItem.Json actualJson = new ImmutableBulkTaxonomyItem.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setExternalId("42");
    actualJson.setName("Name");
    actualJson.setParentExternalId("42");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("42", actualJson.parentExternalId);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertFalse(actualJson.concrete);
    assertFalse(actualJson.concreteIsSet);
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyItem.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyItem.Json()).name());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyItem.Json#parentExternalId()}
   */
  @Test
  void testJsonParentExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyItem.Json()).parentExternalId());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyItem.Json#setConcrete(boolean)}
   */
  @Test
  void testJsonSetConcrete() {
    // Arrange
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();

    // Act
    json.setConcrete(true);

    // Assert
    assertTrue(json.concrete);
    assertTrue(json.concreteIsSet);
  }
}
