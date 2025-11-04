package org.finos.waltz.model.measurable_rating;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRating#builder()}
   *   <li>{@link ImmutableMeasurableRating#description(String)}
   *   <li>{@link ImmutableMeasurableRating#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurableRating#provenance(String)}
   *   <li>{@link ImmutableMeasurableRating#ratingId(Long)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMeasurableRating.Builder actualIdResult = ImmutableMeasurableRating.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableMeasurableRating.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableMeasurableRating.Builder actualProvenanceResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.ratingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableMeasurableRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableMeasurableRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableMeasurableRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableMeasurableRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableMeasurableRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
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
   * {@link ImmutableMeasurableRating.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#from(MeasurableRating)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#from(MeasurableRating)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#from(MeasurableRating)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.rating()).thenReturn('A');
    when(instance.ratingId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isPrimary();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
    verify(instance).rating();
    verify(instance).ratingId();
    ImmutableMeasurableRating buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals('A', buildResult.rating());
    assertEquals(1L, buildResult.ratingId().longValue());
    assertEquals(1L, buildResult.measurableId());
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#from(MeasurableRating)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.rating()).thenReturn('A');
    when(instance.ratingId()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isPrimary();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
    verify(instance).rating();
    verify(instance).ratingId();
    ImmutableMeasurableRating buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals('A', buildResult.rating());
    assertNull(buildResult.ratingId());
    assertEquals(1L, buildResult.measurableId());
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#from(MeasurableRating)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.rating()).thenReturn('A');
    when(instance.ratingId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRating.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isPrimary();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
    verify(instance).rating();
    verify(instance).ratingId();
    ImmutableMeasurableRating buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals('A', buildResult.rating());
    assertEquals(1L, buildResult.ratingId().longValue());
    assertEquals(1L, buildResult.measurableId());
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#isPrimary(boolean)}
   */
  @Test
  void testBuilderIsPrimary() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isPrimary(true));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Builder#measurableId(long)}
   */
  @Test
  void testBuilderMeasurableId() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableId(1L));
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Builder#rating(char)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableMeasurableRating.Builder builderResult = ImmutableMeasurableRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating('A'));
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating#copyOf(MeasurableRating)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.rating()).thenReturn('A');
    when(instance.ratingId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRating actualCopyOfResult = ImmutableMeasurableRating.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isPrimary();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
    verify(instance).rating();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertTrue(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating#copyOf(MeasurableRating)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.rating()).thenReturn('A');
    when(instance.ratingId()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRating actualCopyOfResult = ImmutableMeasurableRating.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isPrimary();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
    verify(instance).rating();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertNull(actualCopyOfResult.ratingId());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertTrue(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating#copyOf(MeasurableRating)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.rating()).thenReturn('A');
    when(instance.ratingId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRating actualCopyOfResult = ImmutableMeasurableRating.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isPrimary();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
    verify(instance).rating();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertTrue(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating#copyOf(MeasurableRating)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.rating()).thenReturn('A');
    when(instance.ratingId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(false);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRating actualCopyOfResult = ImmutableMeasurableRating.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isPrimary();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
    verify(instance).rating();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertFalse(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating#copyOf(MeasurableRating)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    MeasurableRating instance = mock(MeasurableRating.class);
    when(instance.rating()).thenReturn('A');
    when(instance.ratingId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.isReadOnly()).thenReturn(true);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRating actualCopyOfResult = ImmutableMeasurableRating.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).isPrimary();
    verify(instance).isReadOnly();
    verify(instance).measurableId();
    verify(instance).rating();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals('A', actualCopyOfResult.rating());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertTrue(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#isPrimary()}
   */
  @Test
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).isPrimary());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#measurableId()}
   */
  @Test
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).measurableId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableRating.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableRating.Json actualJson = new ImmutableMeasurableRating.Json();

    // Assert
    assertEquals('\u0000', actualJson.rating);
    assertNull(actualJson.ratingId);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.entityReference);
    assertEquals(0L, actualJson.measurableId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isPrimary);
    assertFalse(actualJson.isPrimaryIsSet);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.measurableIdIsSet);
    assertFalse(actualJson.ratingIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).rating());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#ratingId()}
   */
  @Test
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRating.Json()).ratingId());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Json#setIsPrimary(boolean)}
   */
  @Test
  void testJsonSetIsPrimary() {
    // Arrange
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();

    // Act
    json.setIsPrimary(true);

    // Assert
    assertTrue(json.isPrimary);
    assertTrue(json.isPrimaryIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Json#setIsPrimary(boolean)}
   */
  @Test
  void testJsonSetIsPrimary2() {
    // Arrange
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsPrimary(true);

    // Assert
    assertTrue(json.isPrimary);
    assertTrue(json.isPrimaryIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly2() {
    // Arrange
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Json#setMeasurableId(long)}
   */
  @Test
  void testJsonSetMeasurableId() {
    // Arrange
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRating.Json#setMeasurableId(long)}
   */
  @Test
  void testJsonSetMeasurableId2() {
    // Arrange
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#setRating(char)}
   */
  @Test
  void testJsonSetRating() {
    // Arrange
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRating.Json#setRating(char)}
   */
  @Test
  void testJsonSetRating2() {
    // Arrange
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }
}
