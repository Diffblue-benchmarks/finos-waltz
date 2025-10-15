package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableRatingResolutionError.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableRatingResolutionError.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingResolutionErrorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingResolutionError Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableRatingResolutionError actualImmutableRatingResolutionError =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build();

    // Assert
    assertEquals("An error occurred", actualImmutableRatingResolutionError.errorMessage());
    assertEquals(
        RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED,
        actualImmutableRatingResolutionError.errorCode());
  }

  /**
   * Test Builder {@link Builder#errorCode(RatingResolutionErrorCode)}.
   *
   * <p>Method under test: {@link Builder#errorCode(RatingResolutionErrorCode)}
   */
  @Test
  @DisplayName("Test Builder errorCode(RatingResolutionErrorCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errorCode(RatingResolutionErrorCode)"})
  void testBuilderErrorCode() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();

    // Act
    Builder actualErrorCodeResult =
        builderResult.errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Assert
    assertSame(builderResult, actualErrorCodeResult);
  }

  /**
   * Test Builder {@link Builder#errorMessage(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#errorMessage(String)}
   */
  @Test
  @DisplayName("Test Builder errorMessage(String); when 'An error occurred'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errorMessage(String)"})
  void testBuilderErrorMessage_whenAnErrorOccurred_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();

    // Act
    Builder actualErrorMessageResult = builderResult.errorMessage("An error occurred");

    // Assert
    assertSame(builderResult, actualErrorMessageResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadError)} with {@code BulkUploadError}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadError) with 'BulkUploadError'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadError)"})
  void testBuilderFromWithBulkUploadError() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();
    ImmutableRatingResolutionError instance =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((BulkUploadError) instance);

    // Assert
    ImmutableRatingResolutionError actualImmutableRatingResolutionError = builderResult.build();
    assertEquals(instance, actualImmutableRatingResolutionError);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadError)} with {@code BulkUploadError}.
   *
   * <ul>
   *   <li>Given {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkUploadError)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkUploadError) with 'BulkUploadError'; given 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadError)"})
  void testBuilderFromWithBulkUploadError_givenAnErrorOccurred() {
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkUploadError)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkUploadError) with 'BulkUploadError'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadError)"})
  void testBuilderFromWithBulkUploadError_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();

    BulkUploadError instance = mock(BulkUploadError.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorMessage();
  }

  /**
   * Test Builder {@link Builder#from(RatingResolutionError)} with {@code RatingResolutionError}.
   *
   * <p>Method under test: {@link Builder#from(RatingResolutionError)}
   */
  @Test
  @DisplayName("Test Builder from(RatingResolutionError) with 'RatingResolutionError'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingResolutionError)"})
  void testBuilderFromWithRatingResolutionError() {
    // Arrange
    Builder builderResult = ImmutableRatingResolutionError.builder();
    ImmutableRatingResolutionError instance =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRatingResolutionError actualImmutableRatingResolutionError = builderResult.build();
    assertEquals(instance, actualImmutableRatingResolutionError);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableRatingResolutionError#copyOf(RatingResolutionError)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingResolutionError#copyOf(RatingResolutionError)}
   */
  @Test
  @DisplayName(
      "Test copyOf(RatingResolutionError); then return errorMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingResolutionError ImmutableRatingResolutionError.copyOf(RatingResolutionError)"
  })
  void testCopyOf_thenReturnErrorMessageIsAnErrorOccurred() {
    // Arrange
    ImmutableRatingResolutionError instance =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build();

    // Act
    ImmutableRatingResolutionError actualCopyOfResult =
        ImmutableRatingResolutionError.copyOf(instance);

    // Assert
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertEquals(
        RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualCopyOfResult.errorCode());
  }

  /**
   * Test {@link ImmutableRatingResolutionError#equals(Object)}, and {@link
   * ImmutableRatingResolutionError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingResolutionError#equals(Object)}
   *   <li>{@link ImmutableRatingResolutionError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingResolutionError.equals(Object)",
    "int ImmutableRatingResolutionError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableRatingResolutionError immutableRatingResolutionError =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build();
    ImmutableRatingResolutionError immutableRatingResolutionError2 =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build();

    // Act and Assert
    assertEquals(immutableRatingResolutionError, immutableRatingResolutionError2);
    assertEquals(
        immutableRatingResolutionError.hashCode(), immutableRatingResolutionError2.hashCode());
  }

  /**
   * Test {@link ImmutableRatingResolutionError#equals(Object)}, and {@link
   * ImmutableRatingResolutionError#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingResolutionError#equals(Object)}
   *   <li>{@link ImmutableRatingResolutionError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingResolutionError.equals(Object)",
    "int ImmutableRatingResolutionError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableRatingResolutionError immutableRatingResolutionError =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build();

    // Act and Assert
    assertEquals(immutableRatingResolutionError, immutableRatingResolutionError);
    int expectedHashCodeResult = immutableRatingResolutionError.hashCode();
    assertEquals(expectedHashCodeResult, immutableRatingResolutionError.hashCode());
  }

  /**
   * Test {@link ImmutableRatingResolutionError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingResolutionError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingResolutionError.equals(Object)",
    "int ImmutableRatingResolutionError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableRatingResolutionError immutableRatingResolutionError =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.RATING_VALUE_NOT_FOUND)
            .errorMessage("An error occurred")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingResolutionError,
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build());
  }

  /**
   * Test {@link ImmutableRatingResolutionError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingResolutionError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingResolutionError.equals(Object)",
    "int ImmutableRatingResolutionError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableRatingResolutionError immutableRatingResolutionError =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("Error Message")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingResolutionError,
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build());
  }

  /**
   * Test {@link ImmutableRatingResolutionError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingResolutionError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingResolutionError.equals(Object)",
    "int ImmutableRatingResolutionError.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableRatingResolutionError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingResolutionError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingResolutionError.equals(Object)",
    "int ImmutableRatingResolutionError.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build(),
        "Different type to ImmutableRatingResolutionError");
  }

  /**
   * Test {@link ImmutableRatingResolutionError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) ErrorMessage is {@code Json}.
   *   <li>Then return errorMessage is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingResolutionError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) ErrorMessage is 'Json'; then return errorMessage is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingResolutionError ImmutableRatingResolutionError.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonErrorMessageIsJson_thenReturnErrorMessageIsJson() {
    // Arrange
    Json json = new Json();
    json.setErrorMessage("Json");
    json.setErrorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Act
    ImmutableRatingResolutionError actualFromJsonResult =
        ImmutableRatingResolutionError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.errorMessage());
    assertEquals(
        RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualFromJsonResult.errorCode());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingResolutionError#toString()}
   *   <li>{@link ImmutableRatingResolutionError#errorCode()}
   *   <li>{@link ImmutableRatingResolutionError#errorMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RatingResolutionErrorCode ImmutableRatingResolutionError.errorCode()",
    "String ImmutableRatingResolutionError.errorMessage()",
    "String ImmutableRatingResolutionError.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableRatingResolutionError immutableRatingResolutionError =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build();

    // Act
    String actualToStringResult = immutableRatingResolutionError.toString();
    RatingResolutionErrorCode actualErrorCodeResult = immutableRatingResolutionError.errorCode();

    // Assert
    assertEquals("An error occurred", immutableRatingResolutionError.errorMessage());
    assertEquals(
        "RatingResolutionError{errorMessage=An error occurred, errorCode=MULTIPLE_RATINGS_DISALLOWED}",
        actualToStringResult);
    assertEquals(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualErrorCodeResult);
  }

  /**
   * Test Json {@link Json#errorCode()}.
   *
   * <p>Method under test: {@link Json#errorCode()}
   */
  @Test
  @DisplayName("Test Json errorCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingResolutionErrorCode Json.errorCode()"})
  void testJsonErrorCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().errorCode());
  }

  /**
   * Test Json {@link Json#errorMessage()}.
   *
   * <p>Method under test: {@link Json#errorMessage()}
   */
  @Test
  @DisplayName("Test Json errorMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.errorMessage()"})
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().errorMessage());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setErrorCode(RatingResolutionErrorCode)}
   *   <li>{@link Json#setErrorMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setErrorCode(RatingResolutionErrorCode)",
    "void Json.setErrorMessage(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setErrorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);
    actualJson.setErrorMessage("An error occurred");

    // Assert
    assertEquals("An error occurred", actualJson.errorMessage);
    assertEquals(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED, actualJson.errorCode);
  }

  /**
   * Test {@link ImmutableRatingResolutionError#withErrorCode(RatingResolutionErrorCode)}.
   *
   * <p>Method under test: {@link
   * ImmutableRatingResolutionError#withErrorCode(RatingResolutionErrorCode)}
   */
  @Test
  @DisplayName("Test withErrorCode(RatingResolutionErrorCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingResolutionError ImmutableRatingResolutionError.withErrorCode(RatingResolutionErrorCode)"
  })
  void testWithErrorCode() {
    // Arrange
    ImmutableRatingResolutionError immutableRatingResolutionError =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build();

    // Act
    ImmutableRatingResolutionError actualWithErrorCodeResult =
        immutableRatingResolutionError.withErrorCode(
            RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Assert
    assertSame(immutableRatingResolutionError, actualWithErrorCodeResult);
  }

  /**
   * Test {@link ImmutableRatingResolutionError#withErrorCode(RatingResolutionErrorCode)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRatingResolutionError#withErrorCode(RatingResolutionErrorCode)}
   */
  @Test
  @DisplayName(
      "Test withErrorCode(RatingResolutionErrorCode); then return errorMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingResolutionError ImmutableRatingResolutionError.withErrorCode(RatingResolutionErrorCode)"
  })
  void testWithErrorCode_thenReturnErrorMessageIsAnErrorOccurred() {
    // Arrange and Act
    ImmutableRatingResolutionError actualWithErrorCodeResult =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.RATING_VALUE_NOT_FOUND)
            .errorMessage("An error occurred")
            .build()
            .withErrorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED);

    // Assert
    assertEquals("An error occurred", actualWithErrorCodeResult.errorMessage());
    assertEquals(
        RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED,
        actualWithErrorCodeResult.errorCode());
  }

  /**
   * Test {@link ImmutableRatingResolutionError#withErrorMessage(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingResolutionError#withErrorMessage(String)}
   */
  @Test
  @DisplayName("Test withErrorMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingResolutionError ImmutableRatingResolutionError.withErrorMessage(String)"
  })
  void testWithErrorMessage() {
    // Arrange
    ImmutableRatingResolutionError immutableRatingResolutionError =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("42")
            .build();

    // Act
    ImmutableRatingResolutionError actualWithErrorMessageResult =
        immutableRatingResolutionError.withErrorMessage("42");

    // Assert
    assertSame(immutableRatingResolutionError, actualWithErrorMessageResult);
  }

  /**
   * Test {@link ImmutableRatingResolutionError#withErrorMessage(String)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingResolutionError#withErrorMessage(String)}
   */
  @Test
  @DisplayName("Test withErrorMessage(String); then return errorMessage is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingResolutionError ImmutableRatingResolutionError.withErrorMessage(String)"
  })
  void testWithErrorMessage_thenReturnErrorMessageIs42() {
    // Arrange and Act
    ImmutableRatingResolutionError actualWithErrorMessageResult =
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build()
            .withErrorMessage("42");

    // Assert
    assertEquals("42", actualWithErrorMessageResult.errorMessage());
    assertEquals(
        RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED,
        actualWithErrorMessageResult.errorCode());
  }
}
