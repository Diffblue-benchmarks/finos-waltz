package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadLegalEntityRelationshipCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadLegalEntityRelationshipCommand#builder()}
   *   <li>
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand#updateMode(BulkUpdateMode)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkUploadLegalEntityRelationshipCommand.Builder actualBuilderResult = ImmutableBulkUploadLegalEntityRelationshipCommand
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.updateMode(BulkUpdateMode.ADD_ONLY));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Builder#from(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand.Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand
        .builder();
    BulkUploadLegalEntityRelationshipCommand instance = mock(BulkUploadLegalEntityRelationshipCommand.class);
    when(instance.updateMode()).thenReturn(BulkUpdateMode.ADD_ONLY);
    when(instance.inputString()).thenReturn("Input String");
    when(instance.legalEntityRelationshipKindId()).thenReturn(1L);

    // Act
    ImmutableBulkUploadLegalEntityRelationshipCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).legalEntityRelationshipKindId();
    verify(instance).updateMode();
    ImmutableBulkUploadLegalEntityRelationshipCommand buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(1L, buildResult.legalEntityRelationshipKindId());
    assertEquals(BulkUpdateMode.ADD_ONLY, buildResult.updateMode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Builder#from(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand.Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand
        .builder();
    BulkUploadLegalEntityRelationshipCommand instance = mock(BulkUploadLegalEntityRelationshipCommand.class);
    when(instance.updateMode()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");
    when(instance.legalEntityRelationshipKindId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).inputString();
    verify(instance).legalEntityRelationshipKindId();
    verify(instance).updateMode();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand.Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Builder#legalEntityRelationshipKindId(long)}
   */
  @Test
  void testBuilderLegalEntityRelationshipKindId() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand.Builder builderResult = ImmutableBulkUploadLegalEntityRelationshipCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.legalEntityRelationshipKindId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand#copyOf(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkUploadLegalEntityRelationshipCommand instance = mock(BulkUploadLegalEntityRelationshipCommand.class);
    when(instance.updateMode()).thenReturn(BulkUpdateMode.ADD_ONLY);
    when(instance.inputString()).thenReturn("Input String");
    when(instance.legalEntityRelationshipKindId()).thenReturn(1L);

    // Act
    ImmutableBulkUploadLegalEntityRelationshipCommand actualCopyOfResult = ImmutableBulkUploadLegalEntityRelationshipCommand
        .copyOf(instance);

    // Assert
    verify(instance).inputString();
    verify(instance).legalEntityRelationshipKindId();
    verify(instance).updateMode();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1L, actualCopyOfResult.legalEntityRelationshipKindId());
    assertEquals(BulkUpdateMode.ADD_ONLY, actualCopyOfResult.updateMode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Json}
   *   <li>
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Json#setInputString(String)}
   *   <li>
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Json#setUpdateMode(BulkUpdateMode)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkUploadLegalEntityRelationshipCommand.Json actualJson = new ImmutableBulkUploadLegalEntityRelationshipCommand.Json();
    actualJson.setInputString("Input String");
    actualJson.setUpdateMode(BulkUpdateMode.ADD_ONLY);

    // Assert
    assertEquals("Input String", actualJson.inputString);
    assertEquals(0L, actualJson.legalEntityRelationshipKindId);
    assertEquals(BulkUpdateMode.ADD_ONLY, actualJson.updateMode);
    assertFalse(actualJson.legalEntityRelationshipKindIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Json#inputString()}
   */
  @Test
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadLegalEntityRelationshipCommand.Json()).inputString());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Json#legalEntityRelationshipKindId()}
   */
  @Test
  void testJsonLegalEntityRelationshipKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadLegalEntityRelationshipCommand.Json()).legalEntityRelationshipKindId());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Json#setLegalEntityRelationshipKindId(long)}
   */
  @Test
  void testJsonSetLegalEntityRelationshipKindId() {
    // Arrange
    ImmutableBulkUploadLegalEntityRelationshipCommand.Json json = new ImmutableBulkUploadLegalEntityRelationshipCommand.Json();

    // Act
    json.setLegalEntityRelationshipKindId(1L);

    // Assert
    assertEquals(1L, json.legalEntityRelationshipKindId);
    assertTrue(json.legalEntityRelationshipKindIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadLegalEntityRelationshipCommand.Json#updateMode()}
   */
  @Test
  void testJsonUpdateMode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadLegalEntityRelationshipCommand.Json()).updateMode());
  }
}
