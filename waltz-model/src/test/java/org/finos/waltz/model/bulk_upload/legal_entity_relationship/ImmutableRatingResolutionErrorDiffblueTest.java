package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableRatingResolutionError.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableRatingResolutionError.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingResolutionErrorDiffblueTest {
  /**
   * Test Builder {@link Builder#errorCode(RatingResolutionErrorCode)}.
   * <p>
   * Method under test: {@link Builder#errorCode(RatingResolutionErrorCode)}
   */
  @Test
  @DisplayName("Test Builder errorCode(RatingResolutionErrorCode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errorCode(RatingResolutionErrorCode)"})
  void testBuilderErrorCode() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED));
  }

  /**
   * Test Builder {@link Builder#errorMessage(String)}.
   * <p>
   * Method under test: {@link Builder#errorMessage(String)}
   */
  @Test
  @DisplayName("Test Builder errorMessage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errorMessage(String)"})
  void testBuilderErrorMessage() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errorMessage("An error occurred"));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadError)} with {@code BulkUploadError}.
   * <ul>
   *   <li>Given {@code An error occurred}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadError) with 'BulkUploadError'; given 'An error occurred'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadError)"})
  void testBuilderFromWithBulkUploadError_givenAnErrorOccurred_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();
    BulkUploadError instance = mock(BulkUploadError.class);
    when(instance.errorMessage()).thenReturn("An error occurred");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadError)} with {@code BulkUploadError}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadError) with 'BulkUploadError'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadError)"})
  void testBuilderFromWithBulkUploadError_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();
    BulkUploadError instance = mock(BulkUploadError.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorMessage();
  }

  /**
   * Test Builder {@link Builder#from(RatingResolutionError)} with {@code RatingResolutionError}.
   * <p>
   * Method under test: {@link Builder#from(RatingResolutionError)}
   */
  @Test
  @DisplayName("Test Builder from(RatingResolutionError) with 'RatingResolutionError'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingResolutionError)"})
  void testBuilderFromWithRatingResolutionError() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();
    RatingResolutionError instance = mock(RatingResolutionError.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.errorCode()).thenReturn(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).errorCode();
    ImmutableRatingResolutionError buildResult = builderResult.build();
    assertEquals("An error occurred", buildResult.errorMessage());
    assertEquals(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, buildResult.errorCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingResolutionError)} with {@code RatingResolutionError}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingResolutionError)}
   */
  @Test
  @DisplayName("Test Builder from(RatingResolutionError) with 'RatingResolutionError'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingResolutionError)"})
  void testBuilderFromWithRatingResolutionError_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();
    RatingResolutionError instance = mock(RatingResolutionError.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException("instance"));
    when(instance.errorCode()).thenReturn(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorMessage();
    verify(instance).errorCode();
  }

  /**
   * Test Json {@link Json#errorCode()}.
   * <p>
   * Method under test: {@link Json#errorCode()}
   */
  @Test
  @DisplayName("Test Json errorCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RatingResolutionErrorCode Json.errorCode()"})
  void testJsonErrorCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errorCode());
  }

  /**
   * Test Json {@link Json#errorMessage()}.
   * <p>
   * Method under test: {@link Json#errorMessage()}
   */
  @Test
  @DisplayName("Test Json errorMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.errorMessage()"})
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errorMessage());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setErrorCode(RatingResolutionErrorCode)}
   *   <li>{@link Json#setErrorMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setErrorCode(RatingResolutionErrorCode)",
      "void Json.setErrorMessage(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setErrorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);
    actualJson.setErrorMessage("An error occurred");

    // Assert
    assertEquals("An error occurred", actualJson.errorMessage);
    assertEquals(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualJson.errorCode);
  }
}
