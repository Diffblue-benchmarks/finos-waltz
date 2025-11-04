package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.CommentProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRating#builder()}
   *   <li>{@link ImmutableAssessmentRating#comment(String)}
   *   <li>{@link ImmutableAssessmentRating#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableAssessmentRating#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAssessmentRating.Builder actualIdResult = ImmutableAssessmentRating.builder().comment("Comment").id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableAssessmentRating.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableAssessmentRating.Builder actualLastUpdatedAtResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#assessmentDefinitionId(long)}
   */
  @Test
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn("Comment");

    // Act
    ImmutableAssessmentRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn(null);

    // Act
    ImmutableAssessmentRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAssessmentRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAssessmentRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(IsReadOnlyProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    IsReadOnlyProvider instance = mock(IsReadOnlyProvider.class);
    when(instance.isReadOnly()).thenReturn(true);

    // Act
    ImmutableAssessmentRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isReadOnly();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableAssessmentRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssessmentRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(AssessmentRating)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    AssessmentRating instance = mock(AssessmentRating.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.comment()).thenReturn("Comment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(AssessmentRating)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    AssessmentRating instance = mock(AssessmentRating.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.comment()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(AssessmentRating)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    AssessmentRating instance = mock(AssessmentRating.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.comment()).thenReturn("Comment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssessmentRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    ImmutableAssessmentRating buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.assessmentDefinitionId());
    assertEquals(1L, buildResult.ratingId());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(AssessmentRating)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    AssessmentRating instance = mock(AssessmentRating.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.comment()).thenReturn("Comment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssessmentRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    ImmutableAssessmentRating buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.assessmentDefinitionId());
    assertEquals(1L, buildResult.ratingId());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#from(AssessmentRating)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    AssessmentRating instance = mock(AssessmentRating.class);
    when(instance.ratingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.comment()).thenReturn("Comment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).ratingId();
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Builder#ratingId(long)}
   */
  @Test
  void testBuilderRatingId() {
    // Arrange
    ImmutableAssessmentRating.Builder builderResult = ImmutableAssessmentRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating#copyOf(AssessmentRating)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRating instance = mock(AssessmentRating.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.comment()).thenReturn("Comment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssessmentRating actualCopyOfResult = ImmutableAssessmentRating.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating#copyOf(AssessmentRating)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AssessmentRating instance = mock(AssessmentRating.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.comment()).thenReturn("Comment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssessmentRating actualCopyOfResult = ImmutableAssessmentRating.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating#copyOf(AssessmentRating)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AssessmentRating instance = mock(AssessmentRating.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.comment()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssessmentRating actualCopyOfResult = ImmutableAssessmentRating.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.comment());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating#copyOf(AssessmentRating)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AssessmentRating instance = mock(AssessmentRating.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.comment()).thenReturn("Comment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(false);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssessmentRating actualCopyOfResult = ImmutableAssessmentRating.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertFalse(actualCopyOfResult.isReadOnly());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Json#assessmentDefinitionId()}
   */
  @Test
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRating.Json()).assessmentDefinitionId());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRating.Json()).comment());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRating.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRating.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRating.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRating.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRating.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRating.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRating.Json actualJson = new ImmutableAssessmentRating.Json();

    // Assert
    assertNull(actualJson.comment);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.entityReference);
    assertEquals(0L, actualJson.assessmentDefinitionId);
    assertEquals(0L, actualJson.ratingId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.assessmentDefinitionIdIsSet);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.ratingIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRating.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#ratingId()}
   */
  @Test
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRating.Json()).ratingId());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Json#setAssessmentDefinitionId(long)}
   */
  @Test
  void testJsonSetAssessmentDefinitionId() {
    // Arrange
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();

    // Act
    json.setAssessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, json.assessmentDefinitionId);
    assertTrue(json.assessmentDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Json#setAssessmentDefinitionId(long)}
   */
  @Test
  void testJsonSetAssessmentDefinitionId2() {
    // Arrange
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setAssessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, json.assessmentDefinitionId);
    assertTrue(json.assessmentDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRating.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly2() {
    // Arrange
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#setRatingId(long)}
   */
  @Test
  void testJsonSetRatingId() {
    // Arrange
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRating.Json#setRatingId(long)}
   */
  @Test
  void testJsonSetRatingId2() {
    // Arrange
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }
}
