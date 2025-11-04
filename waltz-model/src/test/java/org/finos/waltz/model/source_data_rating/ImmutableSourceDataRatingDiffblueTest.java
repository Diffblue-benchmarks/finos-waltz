package org.finos.waltz.model.source_data_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.Test;

class ImmutableSourceDataRatingDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSourceDataRating.Builder#accuracy(RagRating)}
   */
  @Test
  void testBuilderAccuracy() {
    // Arrange
    ImmutableSourceDataRating.Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.accuracy(RagRating.R));
  }

  /**
   * Method under test:
   * {@link ImmutableSourceDataRating.Builder#authoritativeness(RagRating)}
   */
  @Test
  void testBuilderAuthoritativeness() {
    // Arrange
    ImmutableSourceDataRating.Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.authoritativeness(RagRating.R));
  }

  /**
   * Method under test:
   * {@link ImmutableSourceDataRating.Builder#completeness(RagRating)}
   */
  @Test
  void testBuilderCompleteness() {
    // Arrange
    ImmutableSourceDataRating.Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completeness(RagRating.R));
  }

  /**
   * Method under test:
   * {@link ImmutableSourceDataRating.Builder#entityKind(EntityKind)}
   */
  @Test
  void testBuilderEntityKind() {
    // Arrange
    ImmutableSourceDataRating.Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableSourceDataRating.Builder#from(SourceDataRating)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSourceDataRating.Builder builderResult = ImmutableSourceDataRating.builder();
    SourceDataRating instance = mock(SourceDataRating.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastImportDate()).thenReturn(ofResult);
    when(instance.completeness()).thenReturn(RagRating.R);
    when(instance.accuracy()).thenReturn(RagRating.R);
    when(instance.authoritativeness()).thenReturn(RagRating.R);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.sourceName()).thenReturn("Source Name");

    // Act
    ImmutableSourceDataRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).accuracy();
    verify(instance).authoritativeness();
    verify(instance).completeness();
    verify(instance).entityKind();
    verify(instance).lastImportDate();
    verify(instance).sourceName();
    ImmutableSourceDataRating buildResult = builderResult.build();
    assertEquals("Source Name", buildResult.sourceName());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(RagRating.R, buildResult.accuracy());
    assertEquals(RagRating.R, buildResult.authoritativeness());
    assertEquals(RagRating.R, buildResult.completeness());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSourceDataRating.Builder#from(SourceDataRating)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSourceDataRating.Builder builderResult = ImmutableSourceDataRating.builder();
    SourceDataRating instance = mock(SourceDataRating.class);
    when(instance.lastImportDate()).thenThrow(new IllegalStateException("instance"));
    when(instance.completeness()).thenReturn(RagRating.R);
    when(instance.accuracy()).thenReturn(RagRating.R);
    when(instance.authoritativeness()).thenReturn(RagRating.R);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.sourceName()).thenReturn("Source Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).accuracy();
    verify(instance).authoritativeness();
    verify(instance).completeness();
    verify(instance).entityKind();
    verify(instance).lastImportDate();
    verify(instance).sourceName();
  }

  /**
   * Method under test:
   * {@link ImmutableSourceDataRating.Builder#from(SourceDataRating)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSourceDataRating.Builder builderResult = ImmutableSourceDataRating.builder();
    SourceDataRating instance = mock(SourceDataRating.class);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastImportDate()).thenReturn(emptyResult);
    when(instance.completeness()).thenReturn(RagRating.R);
    when(instance.accuracy()).thenReturn(RagRating.R);
    when(instance.authoritativeness()).thenReturn(RagRating.R);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.sourceName()).thenReturn("Source Name");

    // Act
    ImmutableSourceDataRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).accuracy();
    verify(instance).authoritativeness();
    verify(instance).completeness();
    verify(instance).entityKind();
    verify(instance).lastImportDate();
    verify(instance).sourceName();
    ImmutableSourceDataRating buildResult = builderResult.build();
    assertEquals("Source Name", buildResult.sourceName());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(RagRating.R, buildResult.accuracy());
    assertEquals(RagRating.R, buildResult.authoritativeness());
    assertEquals(RagRating.R, buildResult.completeness());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSourceDataRating.Builder#sourceName(String)}
   */
  @Test
  void testBuilderSourceName() {
    // Arrange
    ImmutableSourceDataRating.Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceName("Source Name"));
  }

  /**
   * Method under test: {@link ImmutableSourceDataRating#copyOf(SourceDataRating)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SourceDataRating instance = mock(SourceDataRating.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastImportDate()).thenReturn(ofResult);
    when(instance.completeness()).thenReturn(RagRating.R);
    when(instance.accuracy()).thenReturn(RagRating.R);
    when(instance.authoritativeness()).thenReturn(RagRating.R);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.sourceName()).thenReturn("Source Name");

    // Act
    ImmutableSourceDataRating actualCopyOfResult = ImmutableSourceDataRating.copyOf(instance);

    // Assert
    verify(instance).accuracy();
    verify(instance).authoritativeness();
    verify(instance).completeness();
    verify(instance).entityKind();
    verify(instance).lastImportDate();
    verify(instance).sourceName();
    assertEquals("Source Name", actualCopyOfResult.sourceName());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(RagRating.R, actualCopyOfResult.accuracy());
    assertEquals(RagRating.R, actualCopyOfResult.authoritativeness());
    assertEquals(RagRating.R, actualCopyOfResult.completeness());
  }

  /**
   * Method under test: {@link ImmutableSourceDataRating#copyOf(SourceDataRating)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SourceDataRating instance = mock(SourceDataRating.class);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastImportDate()).thenReturn(emptyResult);
    when(instance.completeness()).thenReturn(RagRating.R);
    when(instance.accuracy()).thenReturn(RagRating.R);
    when(instance.authoritativeness()).thenReturn(RagRating.R);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.sourceName()).thenReturn("Source Name");

    // Act
    ImmutableSourceDataRating actualCopyOfResult = ImmutableSourceDataRating.copyOf(instance);

    // Assert
    verify(instance).accuracy();
    verify(instance).authoritativeness();
    verify(instance).completeness();
    verify(instance).entityKind();
    verify(instance).lastImportDate();
    verify(instance).sourceName();
    assertEquals("Source Name", actualCopyOfResult.sourceName());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(RagRating.R, actualCopyOfResult.accuracy());
    assertEquals(RagRating.R, actualCopyOfResult.authoritativeness());
    assertEquals(RagRating.R, actualCopyOfResult.completeness());
  }

  /**
   * Method under test: {@link ImmutableSourceDataRating.Json#accuracy()}
   */
  @Test
  void testJsonAccuracy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSourceDataRating.Json()).accuracy());
  }

  /**
   * Method under test: {@link ImmutableSourceDataRating.Json#authoritativeness()}
   */
  @Test
  void testJsonAuthoritativeness() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSourceDataRating.Json()).authoritativeness());
  }

  /**
   * Method under test: {@link ImmutableSourceDataRating.Json#completeness()}
   */
  @Test
  void testJsonCompleteness() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSourceDataRating.Json()).completeness());
  }

  /**
   * Method under test: {@link ImmutableSourceDataRating.Json#entityKind()}
   */
  @Test
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSourceDataRating.Json()).entityKind());
  }

  /**
   * Method under test: {@link ImmutableSourceDataRating.Json#lastImportDate()}
   */
  @Test
  void testJsonLastImportDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSourceDataRating.Json()).lastImportDate());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSourceDataRating.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSourceDataRating.Json actualJson = new ImmutableSourceDataRating.Json();

    // Assert
    assertNull(actualJson.sourceName);
    assertNull(actualJson.entityKind);
    assertNull(actualJson.accuracy);
    assertNull(actualJson.authoritativeness);
    assertNull(actualJson.completeness);
    assertFalse(actualJson.lastImportDate.isPresent());
  }

  /**
   * Method under test: {@link ImmutableSourceDataRating.Json#sourceName()}
   */
  @Test
  void testJsonSourceName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSourceDataRating.Json()).sourceName());
  }
}
