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
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableLegalEntityRelationshipResolutionError.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableLegalEntityRelationshipResolutionError.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipResolutionErrorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipResolutionError Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipResolutionError
        actualImmutableLegalEntityRelationshipResolutionError =
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
                .errorMessage("An error occurred")
                .build();

    // Assert
    assertEquals(
        "An error occurred", actualImmutableLegalEntityRelationshipResolutionError.errorMessage());
    assertEquals(
        LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND,
        actualImmutableLegalEntityRelationshipResolutionError.errorCode());
  }

  /**
   * Test Builder {@link Builder#errorCode(LegalEntityResolutionErrorCode)}.
   *
   * <p>Method under test: {@link Builder#errorCode(LegalEntityResolutionErrorCode)}
   */
  @Test
  @DisplayName("Test Builder errorCode(LegalEntityResolutionErrorCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errorCode(LegalEntityResolutionErrorCode)"})
  void testBuilderErrorCode() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipResolutionError.builder();

    // Act
    Builder actualErrorCodeResult =
        builderResult.errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);

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
    Builder builderResult = ImmutableLegalEntityRelationshipResolutionError.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipResolutionError.builder();
    ImmutableLegalEntityRelationshipResolutionError instance =
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((BulkUploadError) instance);

    // Assert
    ImmutableLegalEntityRelationshipResolutionError
        actualImmutableLegalEntityRelationshipResolutionError = builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipResolutionError);
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
    Builder builderResult = ImmutableLegalEntityRelationshipResolutionError.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipResolutionError.builder();

    BulkUploadError instance = mock(BulkUploadError.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorMessage();
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipResolutionError)} with {@code
   * LegalEntityRelationshipResolutionError}.
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationshipResolutionError)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LegalEntityRelationshipResolutionError) with 'LegalEntityRelationshipResolutionError'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipResolutionError)"})
  void testBuilderFromWithLegalEntityRelationshipResolutionError() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipResolutionError.builder();
    ImmutableLegalEntityRelationshipResolutionError instance =
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLegalEntityRelationshipResolutionError
        actualImmutableLegalEntityRelationshipResolutionError = builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipResolutionError);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link
   * ImmutableLegalEntityRelationshipResolutionError#copyOf(LegalEntityRelationshipResolutionError)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipResolutionError#copyOf(LegalEntityRelationshipResolutionError)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LegalEntityRelationshipResolutionError); then return errorMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipResolutionError ImmutableLegalEntityRelationshipResolutionError.copyOf(LegalEntityRelationshipResolutionError)"
  })
  void testCopyOf_thenReturnErrorMessageIsAnErrorOccurred() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError instance =
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build();

    // Act
    ImmutableLegalEntityRelationshipResolutionError actualCopyOfResult =
        ImmutableLegalEntityRelationshipResolutionError.copyOf(instance);

    // Assert
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertEquals(
        LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, actualCopyOfResult.errorCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipResolutionError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipResolutionError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipResolutionError.equals(Object)",
    "int ImmutableLegalEntityRelationshipResolutionError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError
        immutableLegalEntityRelationshipResolutionError =
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
                .errorMessage("An error occurred")
                .build();
    ImmutableLegalEntityRelationshipResolutionError
        immutableLegalEntityRelationshipResolutionError2 =
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
                .errorMessage("An error occurred")
                .build();

    // Act and Assert
    assertEquals(
        immutableLegalEntityRelationshipResolutionError,
        immutableLegalEntityRelationshipResolutionError2);
    assertEquals(
        immutableLegalEntityRelationshipResolutionError.hashCode(),
        immutableLegalEntityRelationshipResolutionError2.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipResolutionError#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipResolutionError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipResolutionError.equals(Object)",
    "int ImmutableLegalEntityRelationshipResolutionError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError
        immutableLegalEntityRelationshipResolutionError =
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
                .errorMessage("An error occurred")
                .build();

    // Act and Assert
    assertEquals(
        immutableLegalEntityRelationshipResolutionError,
        immutableLegalEntityRelationshipResolutionError);
    int expectedHashCodeResult = immutableLegalEntityRelationshipResolutionError.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableLegalEntityRelationshipResolutionError.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipResolutionError.equals(Object)",
    "int ImmutableLegalEntityRelationshipResolutionError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError
        immutableLegalEntityRelationshipResolutionError =
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.TARGET_ENTITY_NOT_FOUND)
                .errorMessage("An error occurred")
                .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipResolutionError,
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipResolutionError.equals(Object)",
    "int ImmutableLegalEntityRelationshipResolutionError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError
        immutableLegalEntityRelationshipResolutionError =
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
                .errorMessage("Error Message")
                .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipResolutionError,
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipResolutionError.equals(Object)",
    "int ImmutableLegalEntityRelationshipResolutionError.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipResolutionError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipResolutionError.equals(Object)",
    "int ImmutableLegalEntityRelationshipResolutionError.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build(),
        "Different type to ImmutableLegalEntityRelationshipResolutionError");
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipResolutionError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code LEGAL_ENTITY_NOT_FOUND}.
   *   <li>Then return errorMessage is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipResolutionError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'LEGAL_ENTITY_NOT_FOUND'; then return errorMessage is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipResolutionError ImmutableLegalEntityRelationshipResolutionError.fromJson(Json)"
  })
  void testFromJson_givenLegalEntityNotFound_thenReturnErrorMessageIsJson() {
    // Arrange
    Json json = new Json();
    json.setErrorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);
    json.setErrorMessage("Json");

    // Act
    ImmutableLegalEntityRelationshipResolutionError actualFromJsonResult =
        ImmutableLegalEntityRelationshipResolutionError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.errorMessage());
    assertEquals(
        LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, actualFromJsonResult.errorCode());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipResolutionError#toString()}
   *   <li>{@link ImmutableLegalEntityRelationshipResolutionError#errorCode()}
   *   <li>{@link ImmutableLegalEntityRelationshipResolutionError#errorMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityResolutionErrorCode ImmutableLegalEntityRelationshipResolutionError.errorCode()",
    "String ImmutableLegalEntityRelationshipResolutionError.errorMessage()",
    "String ImmutableLegalEntityRelationshipResolutionError.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError
        immutableLegalEntityRelationshipResolutionError =
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
                .errorMessage("An error occurred")
                .build();

    // Act
    String actualToStringResult = immutableLegalEntityRelationshipResolutionError.toString();
    LegalEntityResolutionErrorCode actualErrorCodeResult =
        immutableLegalEntityRelationshipResolutionError.errorCode();

    // Assert
    assertEquals(
        "An error occurred", immutableLegalEntityRelationshipResolutionError.errorMessage());
    assertEquals(
        "LegalEntityRelationshipResolutionError{errorCode=LEGAL_ENTITY_NOT_FOUND, errorMessage=An error"
            + " occurred}",
        actualToStringResult);
    assertEquals(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, actualErrorCodeResult);
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
  @MethodsUnderTest({"LegalEntityResolutionErrorCode Json.errorCode()"})
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
   *   <li>{@link Json#setErrorCode(LegalEntityResolutionErrorCode)}
   *   <li>{@link Json#setErrorMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setErrorCode(LegalEntityResolutionErrorCode)",
    "void Json.setErrorMessage(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setErrorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);
    actualJson.setErrorMessage("An error occurred");

    // Assert
    assertEquals("An error occurred", actualJson.errorMessage);
    assertEquals(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, actualJson.errorCode);
  }

  /**
   * Test {@link
   * ImmutableLegalEntityRelationshipResolutionError#withErrorCode(LegalEntityResolutionErrorCode)}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipResolutionError#withErrorCode(LegalEntityResolutionErrorCode)}
   */
  @Test
  @DisplayName("Test withErrorCode(LegalEntityResolutionErrorCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipResolutionError ImmutableLegalEntityRelationshipResolutionError.withErrorCode(LegalEntityResolutionErrorCode)"
  })
  void testWithErrorCode() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError
        immutableLegalEntityRelationshipResolutionError =
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
                .errorMessage("An error occurred")
                .build();

    // Act
    ImmutableLegalEntityRelationshipResolutionError actualWithErrorCodeResult =
        immutableLegalEntityRelationshipResolutionError.withErrorCode(
            LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);

    // Assert
    assertSame(immutableLegalEntityRelationshipResolutionError, actualWithErrorCodeResult);
  }

  /**
   * Test {@link
   * ImmutableLegalEntityRelationshipResolutionError#withErrorCode(LegalEntityResolutionErrorCode)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipResolutionError#withErrorCode(LegalEntityResolutionErrorCode)}
   */
  @Test
  @DisplayName(
      "Test withErrorCode(LegalEntityResolutionErrorCode); then return errorMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipResolutionError ImmutableLegalEntityRelationshipResolutionError.withErrorCode(LegalEntityResolutionErrorCode)"
  })
  void testWithErrorCode_thenReturnErrorMessageIsAnErrorOccurred() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipResolutionError actualWithErrorCodeResult =
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.TARGET_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build()
            .withErrorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND);

    // Assert
    assertEquals("An error occurred", actualWithErrorCodeResult.errorMessage());
    assertEquals(
        LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND,
        actualWithErrorCodeResult.errorCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipResolutionError#withErrorMessage(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipResolutionError#withErrorMessage(String)}
   */
  @Test
  @DisplayName("Test withErrorMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipResolutionError ImmutableLegalEntityRelationshipResolutionError.withErrorMessage(String)"
  })
  void testWithErrorMessage() {
    // Arrange
    ImmutableLegalEntityRelationshipResolutionError
        immutableLegalEntityRelationshipResolutionError =
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
                .errorMessage("42")
                .build();

    // Act
    ImmutableLegalEntityRelationshipResolutionError actualWithErrorMessageResult =
        immutableLegalEntityRelationshipResolutionError.withErrorMessage("42");

    // Assert
    assertSame(immutableLegalEntityRelationshipResolutionError, actualWithErrorMessageResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipResolutionError#withErrorMessage(String)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipResolutionError#withErrorMessage(String)}
   */
  @Test
  @DisplayName("Test withErrorMessage(String); then return errorMessage is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipResolutionError ImmutableLegalEntityRelationshipResolutionError.withErrorMessage(String)"
  })
  void testWithErrorMessage_thenReturnErrorMessageIs42() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipResolutionError actualWithErrorMessageResult =
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build()
            .withErrorMessage("42");

    // Assert
    assertEquals("42", actualWithErrorMessageResult.errorMessage());
    assertEquals(
        LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND,
        actualWithErrorMessageResult.errorCode());
  }
}
