package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableRatingResolutionErrorDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableRatingResolutionError.Builder#errorCode(RatingResolutionErrorCode)}
   */
  @Test
  void testBuilderErrorCode() {
    // Arrange
    ImmutableRatingResolutionError.Builder builderResult = ImmutableRatingResolutionError.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingResolutionError.Builder#errorMessage(String)}
   */
  @Test
  void testBuilderErrorMessage() {
    // Arrange
    ImmutableRatingResolutionError.Builder builderResult = ImmutableRatingResolutionError.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errorMessage("An error occurred"));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingResolutionError.Builder#from(BulkUploadError)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRatingResolutionError.Builder builderResult = ImmutableRatingResolutionError.builder();
    BulkUploadError instance = mock(BulkUploadError.class);
    when(instance.errorMessage()).thenReturn("An error occurred");

    // Act
    ImmutableRatingResolutionError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingResolutionError.Builder#from(BulkUploadError)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRatingResolutionError.Builder builderResult = ImmutableRatingResolutionError.builder();
    BulkUploadError instance = mock(BulkUploadError.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorMessage();
  }

  /**
   * Method under test:
   * {@link ImmutableRatingResolutionError.Builder#from(RatingResolutionError)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRatingResolutionError.Builder builderResult = ImmutableRatingResolutionError.builder();
    RatingResolutionError instance = mock(RatingResolutionError.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.errorCode()).thenReturn(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Act
    ImmutableRatingResolutionError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).errorCode();
    ImmutableRatingResolutionError buildResult = builderResult.build();
    assertEquals("An error occurred", buildResult.errorMessage());
    assertEquals(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, buildResult.errorCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingResolutionError.Builder#from(RatingResolutionError)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableRatingResolutionError.Builder builderResult = ImmutableRatingResolutionError.builder();
    RatingResolutionError instance = mock(RatingResolutionError.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException("instance"));
    when(instance.errorCode()).thenReturn(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorMessage();
    verify(instance).errorCode();
  }

  /**
   * Method under test:
   * {@link ImmutableRatingResolutionError#copyOf(RatingResolutionError)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RatingResolutionError instance = mock(RatingResolutionError.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.errorCode()).thenReturn(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Act
    ImmutableRatingResolutionError actualCopyOfResult = ImmutableRatingResolutionError.copyOf(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).errorCode();
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertEquals(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualCopyOfResult.errorCode());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingResolutionError#fromJson(ImmutableRatingResolutionError.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableRatingResolutionError.Json json = new ImmutableRatingResolutionError.Json();
    json.setErrorMessage("Json");
    json.setErrorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Act
    ImmutableRatingResolutionError actualFromJsonResult = ImmutableRatingResolutionError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.errorMessage());
    assertEquals(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualFromJsonResult.errorCode());
  }

  /**
   * Method under test: {@link ImmutableRatingResolutionError.Json#errorCode()}
   */
  @Test
  void testJsonErrorCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingResolutionError.Json()).errorCode());
  }

  /**
   * Method under test: {@link ImmutableRatingResolutionError.Json#errorMessage()}
   */
  @Test
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingResolutionError.Json()).errorMessage());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableRatingResolutionError.Json}
   *   <li>
   * {@link ImmutableRatingResolutionError.Json#setErrorCode(RatingResolutionErrorCode)}
   *   <li>{@link ImmutableRatingResolutionError.Json#setErrorMessage(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableRatingResolutionError.Json actualJson = new ImmutableRatingResolutionError.Json();
    actualJson.setErrorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);
    actualJson.setErrorMessage("An error occurred");

    // Assert
    assertEquals("An error occurred", actualJson.errorMessage);
    assertEquals(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualJson.errorCode);
  }
}
