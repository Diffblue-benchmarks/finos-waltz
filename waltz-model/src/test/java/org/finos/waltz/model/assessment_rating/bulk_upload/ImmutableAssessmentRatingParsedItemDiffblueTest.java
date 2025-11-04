package org.finos.waltz.model.assessment_rating.bulk_upload;

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

class ImmutableAssessmentRatingParsedItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParsedItem#builder()}
   *   <li>{@link ImmutableAssessmentRatingParsedItem#comment(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedItem.Builder actualBuilderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.comment("Comment"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableAssessmentRatingParsedItem.Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem.Builder#from(AssessmentRatingParsedItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingParsedItem.Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();
    AssessmentRatingParsedItem instance = mock(AssessmentRatingParsedItem.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.ratingCode()).thenReturn("Rating Code");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingParsedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).ratingCode();
    ImmutableAssessmentRatingParsedItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Rating Code", buildResult.ratingCode());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem.Builder#from(AssessmentRatingParsedItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingParsedItem.Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();
    AssessmentRatingParsedItem instance = mock(AssessmentRatingParsedItem.class);
    when(instance.comment()).thenReturn(null);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.ratingCode()).thenReturn("Rating Code");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingParsedItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).ratingCode();
    ImmutableAssessmentRatingParsedItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Rating Code", buildResult.ratingCode());
    assertNull(buildResult.comment());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableAssessmentRatingParsedItem.Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem.Builder#ratingCode(String)}
   */
  @Test
  void testBuilderRatingCode() {
    // Arrange
    ImmutableAssessmentRatingParsedItem.Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCode("Rating Code"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem#copyOf(AssessmentRatingParsedItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingParsedItem instance = mock(AssessmentRatingParsedItem.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.ratingCode()).thenReturn("Rating Code");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingParsedItem actualCopyOfResult = ImmutableAssessmentRatingParsedItem.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).ratingCode();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Rating Code", actualCopyOfResult.ratingCode());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem#copyOf(AssessmentRatingParsedItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AssessmentRatingParsedItem instance = mock(AssessmentRatingParsedItem.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.isReadOnly()).thenReturn(false);
    when(instance.ratingCode()).thenReturn("Rating Code");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingParsedItem actualCopyOfResult = ImmutableAssessmentRatingParsedItem.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).ratingCode();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Rating Code", actualCopyOfResult.ratingCode());
    assertFalse(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem#fromJson(ImmutableAssessmentRatingParsedItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    json.setRatingCode("externalId");
    json.setExternalId("42");

    // Act
    ImmutableAssessmentRatingParsedItem actualFromJsonResult = ImmutableAssessmentRatingParsedItem.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.externalId());
    assertEquals("externalId", actualFromJsonResult.ratingCode());
    assertNull(actualFromJsonResult.comment());
    assertFalse(actualFromJsonResult.isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingParsedItem.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingParsedItem.Json()).comment());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingParsedItem.Json()).externalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAssessmentRatingParsedItem.Json}
   *   <li>{@link ImmutableAssessmentRatingParsedItem.Json#setComment(String)}
   *   <li>{@link ImmutableAssessmentRatingParsedItem.Json#setExternalId(String)}
   *   <li>{@link ImmutableAssessmentRatingParsedItem.Json#setRatingCode(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedItem.Json actualJson = new ImmutableAssessmentRatingParsedItem.Json();
    actualJson.setComment("Comment");
    actualJson.setExternalId("42");
    actualJson.setRatingCode("Rating Code");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("Comment", actualJson.comment);
    assertEquals("Rating Code", actualJson.ratingCode);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingParsedItem.Json()).isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem.Json#ratingCode()}
   */
  @Test
  void testJsonRatingCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingParsedItem.Json()).ratingCode());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedItem.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }
}
