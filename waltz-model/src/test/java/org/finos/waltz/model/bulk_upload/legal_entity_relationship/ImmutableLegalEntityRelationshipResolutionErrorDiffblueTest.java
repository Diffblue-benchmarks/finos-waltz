package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipResolutionErrorDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError.Builder#errorCode(LegalEntityResolutionErrorCode)}
   */
  @Test
  void testBuilderErrorCode() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError.Builder builderResult = ImmutableLegalEntityRelationshipResolutionError
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError.Builder#errorMessage(String)}
   */
  @Test
  void testBuilderErrorMessage() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError.Builder builderResult = ImmutableLegalEntityRelationshipResolutionError
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errorMessage("An error occurred"));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError.Builder#from(BulkUploadError)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError.Builder builderResult = ImmutableLegalEntityRelationshipResolutionError
        .builder();
    BulkUploadError instance = mock(BulkUploadError.class);
    when(instance.errorMessage()).thenReturn("An error occurred");

    // Act
    ImmutableLegalEntityRelationshipResolutionError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError.Builder#from(BulkUploadError)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError.Builder builderResult = ImmutableLegalEntityRelationshipResolutionError
        .builder();
    BulkUploadError instance = mock(BulkUploadError.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorMessage();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError.Builder#from(LegalEntityRelationshipResolutionError)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError.Builder builderResult = ImmutableLegalEntityRelationshipResolutionError
        .builder();
    LegalEntityRelationshipResolutionError instance = mock(LegalEntityRelationshipResolutionError.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.errorCode()).thenReturn(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);

    // Act
    ImmutableLegalEntityRelationshipResolutionError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorCode();
    verify(instance).errorMessage();
    ImmutableLegalEntityRelationshipResolutionError buildResult = builderResult.build();
    assertEquals("An error occurred", buildResult.errorMessage());
    assertEquals(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, buildResult.errorCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError.Builder#from(LegalEntityRelationshipResolutionError)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError.Builder builderResult = ImmutableLegalEntityRelationshipResolutionError
        .builder();
    LegalEntityRelationshipResolutionError instance = mock(LegalEntityRelationshipResolutionError.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException("instance"));
    when(instance.errorCode()).thenReturn(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorCode();
    verify(instance).errorMessage();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError#copyOf(LegalEntityRelationshipResolutionError)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LegalEntityRelationshipResolutionError instance = mock(LegalEntityRelationshipResolutionError.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.errorCode()).thenReturn(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);

    // Act
    ImmutableLegalEntityRelationshipResolutionError actualCopyOfResult = ImmutableLegalEntityRelationshipResolutionError
        .copyOf(instance);

    // Assert
    verify(instance).errorCode();
    verify(instance).errorMessage();
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertEquals(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, actualCopyOfResult.errorCode());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError#fromJson(ImmutableLegalEntityRelationshipResolutionError.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError.Json json = new ImmutableLegalEntityRelationshipResolutionError.Json();
    json.setErrorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);
    json.setErrorMessage("Json");

    // Act
    ImmutableLegalEntityRelationshipResolutionError actualFromJsonResult = ImmutableLegalEntityRelationshipResolutionError
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.errorMessage());
    assertEquals(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, actualFromJsonResult.errorCode());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError.Json#errorCode()}
   */
  @Test
  void testJsonErrorCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipResolutionError.Json()).errorCode());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipResolutionError.Json#errorMessage()}
   */
  @Test
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipResolutionError.Json()).errorMessage());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableLegalEntityRelationshipResolutionError.Json}
   *   <li>
   * {@link ImmutableLegalEntityRelationshipResolutionError.Json#setErrorCode(LegalEntityResolutionErrorCode)}
   *   <li>
   * {@link ImmutableLegalEntityRelationshipResolutionError.Json#setErrorMessage(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipResolutionError.Json actualJson = new ImmutableLegalEntityRelationshipResolutionError.Json();
    actualJson.setErrorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);
    actualJson.setErrorMessage("An error occurred");

    // Assert
    assertEquals("An error occurred", actualJson.errorMessage);
    assertEquals(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, actualJson.errorCode);
  }
}
