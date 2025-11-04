package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipItem#builder()}
   *   <li>{@link ImmutableBulkUploadRelationshipItem#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipItem.Builder actualBuilderResult = ImmutableBulkUploadRelationshipItem.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem.Builder#from(BulkUploadRelationshipItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkUploadRelationshipItem.Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();
    BulkUploadRelationshipItem instance = mock(BulkUploadRelationshipItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.targetExternalId()).thenReturn("42");
    when(instance.sourceExternalId()).thenReturn("42");

    // Act
    ImmutableBulkUploadRelationshipItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).sourceExternalId();
    verify(instance).targetExternalId();
    ImmutableBulkUploadRelationshipItem buildResult = builderResult.build();
    assertEquals("42", buildResult.sourceExternalId());
    assertEquals("42", buildResult.targetExternalId());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem.Builder#from(BulkUploadRelationshipItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkUploadRelationshipItem.Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();
    BulkUploadRelationshipItem instance = mock(BulkUploadRelationshipItem.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.targetExternalId()).thenReturn("42");
    when(instance.sourceExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).sourceExternalId();
    verify(instance).targetExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem.Builder#from(BulkUploadRelationshipItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkUploadRelationshipItem.Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();
    BulkUploadRelationshipItem instance = mock(BulkUploadRelationshipItem.class);
    when(instance.description()).thenReturn(null);
    when(instance.targetExternalId()).thenReturn("42");
    when(instance.sourceExternalId()).thenReturn("42");

    // Act
    ImmutableBulkUploadRelationshipItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).sourceExternalId();
    verify(instance).targetExternalId();
    ImmutableBulkUploadRelationshipItem buildResult = builderResult.build();
    assertEquals("42", buildResult.sourceExternalId());
    assertEquals("42", buildResult.targetExternalId());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem.Builder#sourceExternalId(String)}
   */
  @Test
  void testBuilderSourceExternalId() {
    // Arrange
    ImmutableBulkUploadRelationshipItem.Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem.Builder#targetExternalId(String)}
   */
  @Test
  void testBuilderTargetExternalId() {
    // Arrange
    ImmutableBulkUploadRelationshipItem.Builder builderResult = ImmutableBulkUploadRelationshipItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem#copyOf(BulkUploadRelationshipItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkUploadRelationshipItem instance = mock(BulkUploadRelationshipItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.targetExternalId()).thenReturn("42");
    when(instance.sourceExternalId()).thenReturn("42");

    // Act
    ImmutableBulkUploadRelationshipItem actualCopyOfResult = ImmutableBulkUploadRelationshipItem.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).sourceExternalId();
    verify(instance).targetExternalId();
    assertEquals("42", actualCopyOfResult.sourceExternalId());
    assertEquals("42", actualCopyOfResult.targetExternalId());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem#fromJson(ImmutableBulkUploadRelationshipItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    json.setSourceExternalId("Json");
    json.setTargetExternalId("Json");
    json.setDescription(null);

    // Act
    ImmutableBulkUploadRelationshipItem actualFromJsonResult = ImmutableBulkUploadRelationshipItem.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.sourceExternalId());
    assertEquals("Json", actualFromJsonResult.targetExternalId());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipItem.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkUploadRelationshipItem.Json}
   *   <li>{@link ImmutableBulkUploadRelationshipItem.Json#setDescription(String)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipItem.Json#setSourceExternalId(String)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipItem.Json#setTargetExternalId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipItem.Json actualJson = new ImmutableBulkUploadRelationshipItem.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setSourceExternalId("42");
    actualJson.setTargetExternalId("42");

    // Assert
    assertEquals("42", actualJson.sourceExternalId);
    assertEquals("42", actualJson.targetExternalId);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem.Json#sourceExternalId()}
   */
  @Test
  void testJsonSourceExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipItem.Json()).sourceExternalId());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipItem.Json#targetExternalId()}
   */
  @Test
  void testJsonTargetExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipItem.Json()).targetExternalId());
  }
}
