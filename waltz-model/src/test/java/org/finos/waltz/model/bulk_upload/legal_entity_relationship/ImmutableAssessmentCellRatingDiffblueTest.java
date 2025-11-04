package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentCellRatingDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#addAllErrors(Iterable)}
   */
  @Test
  void testBuilderAddAllErrors2() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    builderResult.resolvedRating(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllErrors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#addErrors(RatingResolutionError)}
   */
  @Test
  void testBuilderAddErrors() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableRatingResolutionError.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#addErrors(RatingResolutionError)}
   */
  @Test
  void testBuilderAddErrors2() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    builderResult.resolvedRating(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableRatingResolutionError.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#addErrors(RatingResolutionError[])}
   */
  @Test
  void testBuilderAddErrors3() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableRatingResolutionError.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#addErrors(RatingResolutionError[])}
   */
  @Test
  void testBuilderAddErrors4() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    builderResult.resolvedRating(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addErrors(new ImmutableRatingResolutionError.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#comment(Optional)}
   */
  @Test
  void testBuilderComment() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#comment(Optional)}
   */
  @Test
  void testBuilderComment2() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    builderResult.resolvedRating(mock(RatingSchemeItem.class));
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#errors(Iterable)}
   */
  @Test
  void testBuilderErrors2() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    builderResult.resolvedRating(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.errors(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#from(AssessmentCellRating)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(new HashSet<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableAssessmentCellRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#from(AssessmentCellRating)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();

    HashSet<RatingResolutionError> ratingResolutionErrorSet = new HashSet<>();
    ratingResolutionErrorSet.add(new ImmutableRatingResolutionError.Json());
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(ratingResolutionErrorSet);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableAssessmentCellRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    ImmutableAssessmentCellRating buildResult = builderResult.build();
    assertEquals(1, buildResult.errors().size());
    assertEquals(ResolutionStatus.NEW, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#from(AssessmentCellRating)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(new HashSet<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    Optional<RatingSchemeItem> ofResult = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableAssessmentCellRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#from(AssessmentCellRating)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(new HashSet<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> emptyResult = Optional.empty();
    when(instance.resolvedRating()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableAssessmentCellRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#from(AssessmentCellRating)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#status(ResolutionStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act
    ImmutableAssessmentCellRating.Builder actualStatusResult = builderResult.status(ResolutionStatus.NEW);

    // Assert
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Builder#status(ResolutionStatus)}
   */
  @Test
  void testBuilderStatus2() {
    // Arrange
    ImmutableAssessmentCellRating.Builder builderResult = ImmutableAssessmentCellRating.builder();
    builderResult.resolvedRating(mock(RatingSchemeItem.class));

    // Act
    ImmutableAssessmentCellRating.Builder actualStatusResult = builderResult.status(ResolutionStatus.NEW);

    // Assert
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating#copyOf(AssessmentCellRating)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(new HashSet<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableAssessmentCellRating actualCopyOfResult = ImmutableAssessmentCellRating.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.errors().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating#copyOf(AssessmentCellRating)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<RatingResolutionError> ratingResolutionErrorSet = new HashSet<>();
    ratingResolutionErrorSet.add(new ImmutableRatingResolutionError.Json());
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(ratingResolutionErrorSet);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableAssessmentCellRating actualCopyOfResult = ImmutableAssessmentCellRating.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(1, actualCopyOfResult.errors().size());
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating#copyOf(AssessmentCellRating)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<RatingResolutionError> ratingResolutionErrorSet = new HashSet<>();
    ratingResolutionErrorSet.add(new ImmutableRatingResolutionError.Json());
    ratingResolutionErrorSet.add(new ImmutableRatingResolutionError.Json());
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(ratingResolutionErrorSet);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableAssessmentCellRating actualCopyOfResult = ImmutableAssessmentCellRating.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
    assertEquals(ratingResolutionErrorSet, actualCopyOfResult.errors());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating#copyOf(AssessmentCellRating)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(new HashSet<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    Optional<RatingSchemeItem> ofResult = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableAssessmentCellRating actualCopyOfResult = ImmutableAssessmentCellRating.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.errors().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating#copyOf(AssessmentCellRating)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    AssessmentCellRating instance = mock(AssessmentCellRating.class);
    when(instance.errors()).thenReturn(new HashSet<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<RatingSchemeItem> emptyResult = Optional.empty();
    when(instance.resolvedRating()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableAssessmentCellRating actualCopyOfResult = ImmutableAssessmentCellRating.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).errors();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.errors().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating#fromJson(ImmutableAssessmentCellRating.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentCellRating.Json json = new ImmutableAssessmentCellRating.Json();
    json.setResolvedRating(null);
    json.setComment(null);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrors(null);

    // Act
    ImmutableAssessmentCellRating actualFromJsonResult = ImmutableAssessmentCellRating.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertTrue(actualFromJsonResult.errors().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating#fromJson(ImmutableAssessmentCellRating.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<RatingResolutionError> errors = new LinkedHashSet<>();
    errors.add(new ImmutableRatingResolutionError.Json());

    ImmutableAssessmentCellRating.Json json = new ImmutableAssessmentCellRating.Json();
    json.setResolvedRating(null);
    json.setComment(null);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrors(errors);

    // Act
    ImmutableAssessmentCellRating actualFromJsonResult = ImmutableAssessmentCellRating.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.errors().size());
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating#fromJson(ImmutableAssessmentCellRating.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<RatingResolutionError> errors = new LinkedHashSet<>();
    errors.add(new ImmutableRatingResolutionError.Json());
    errors.add(new ImmutableRatingResolutionError.Json());

    ImmutableAssessmentCellRating.Json json = new ImmutableAssessmentCellRating.Json();
    json.setResolvedRating(null);
    json.setComment(null);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrors(errors);

    // Act
    ImmutableAssessmentCellRating actualFromJsonResult = ImmutableAssessmentCellRating.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertEquals(errors, actualFromJsonResult.errors());
  }

  /**
   * Method under test: {@link ImmutableAssessmentCellRating.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentCellRating.Json()).comment());
  }

  /**
   * Method under test: {@link ImmutableAssessmentCellRating.Json#errors()}
   */
  @Test
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentCellRating.Json()).errors());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentCellRating.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentCellRating.Json actualJson = new ImmutableAssessmentCellRating.Json();

    // Assert
    assertNull(actualJson.status);
    assertFalse(actualJson.comment.isPresent());
    assertFalse(actualJson.resolvedRating.isPresent());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCellRating.Json#resolvedRating()}
   */
  @Test
  void testJsonResolvedRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentCellRating.Json()).resolvedRating());
  }

  /**
   * Method under test: {@link ImmutableAssessmentCellRating.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentCellRating.Json()).status());
  }
}
