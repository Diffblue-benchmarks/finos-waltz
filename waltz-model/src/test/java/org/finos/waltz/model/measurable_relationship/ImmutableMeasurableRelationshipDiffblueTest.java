package org.finos.waltz.model.measurable_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRelationshipDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRelationship#builder()}
   *   <li>{@link ImmutableMeasurableRelationship#description(String)}
   *   <li>{@link ImmutableMeasurableRelationship#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurableRelationship#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMeasurableRelationship.Builder actualDescriptionResult = ImmutableMeasurableRelationship.builder()
        .description("The characteristics of someone or something");
    ImmutableMeasurableRelationship.Builder actualLastUpdatedAtResult = actualDescriptionResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableMeasurableRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableMeasurableRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableMeasurableRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();
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
   * {@link ImmutableMeasurableRelationship.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#from(MeasurableRelationship)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();
    MeasurableRelationship instance = mock(MeasurableRelationship.class);
    when(instance.measurableA()).thenReturn(1L);
    when(instance.relationshipKind()).thenReturn(MeasurableRelationshipKind.WEAKLY_RELATES_TO);
    when(instance.measurableB()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableA();
    verify(instance).measurableB();
    verify(instance).relationshipKind();
    ImmutableMeasurableRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.measurableA());
    assertEquals(1L, buildResult.measurableB());
    assertEquals(MeasurableRelationshipKind.WEAKLY_RELATES_TO, buildResult.relationshipKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#from(MeasurableRelationship)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();
    MeasurableRelationship instance = mock(MeasurableRelationship.class);
    when(instance.measurableA()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableB()).thenReturn(1L);
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
    verify(instance).measurableA();
    verify(instance).measurableB();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#from(MeasurableRelationship)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();
    MeasurableRelationship instance = mock(MeasurableRelationship.class);
    when(instance.measurableA()).thenReturn(1L);
    when(instance.relationshipKind()).thenReturn(MeasurableRelationshipKind.WEAKLY_RELATES_TO);
    when(instance.measurableB()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableA();
    verify(instance).measurableB();
    verify(instance).relationshipKind();
    ImmutableMeasurableRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.measurableA());
    assertEquals(1L, buildResult.measurableB());
    assertEquals(MeasurableRelationshipKind.WEAKLY_RELATES_TO, buildResult.relationshipKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#measurableA(long)}
   */
  @Test
  void testBuilderMeasurableA() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableA(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#measurableB(long)}
   */
  @Test
  void testBuilderMeasurableB() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableB(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Builder#relationshipKind(MeasurableRelationshipKind)}
   */
  @Test
  void testBuilderRelationshipKind() {
    // Arrange
    ImmutableMeasurableRelationship.Builder builderResult = ImmutableMeasurableRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship#copyOf(MeasurableRelationship)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRelationship instance = mock(MeasurableRelationship.class);
    when(instance.measurableA()).thenReturn(1L);
    when(instance.relationshipKind()).thenReturn(MeasurableRelationshipKind.WEAKLY_RELATES_TO);
    when(instance.measurableB()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRelationship actualCopyOfResult = ImmutableMeasurableRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableA();
    verify(instance).measurableB();
    verify(instance).relationshipKind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.measurableA());
    assertEquals(1L, actualCopyOfResult.measurableB());
    assertEquals(MeasurableRelationshipKind.WEAKLY_RELATES_TO, actualCopyOfResult.relationshipKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship#copyOf(MeasurableRelationship)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    MeasurableRelationship instance = mock(MeasurableRelationship.class);
    when(instance.measurableA()).thenReturn(1L);
    when(instance.relationshipKind()).thenReturn(MeasurableRelationshipKind.WEAKLY_RELATES_TO);
    when(instance.measurableB()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurableRelationship actualCopyOfResult = ImmutableMeasurableRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableA();
    verify(instance).measurableB();
    verify(instance).relationshipKind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.measurableA());
    assertEquals(1L, actualCopyOfResult.measurableB());
    assertEquals(MeasurableRelationshipKind.WEAKLY_RELATES_TO, actualCopyOfResult.relationshipKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRelationship.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRelationship.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableRelationship.Json}
   *   <li>{@link ImmutableMeasurableRelationship.Json#setDescription(String)}
   *   <li>
   * {@link ImmutableMeasurableRelationship.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurableRelationship.Json#setLastUpdatedBy(String)}
   *   <li>{@link ImmutableMeasurableRelationship.Json#setProvenance(String)}
   *   <li>
   * {@link ImmutableMeasurableRelationship.Json#setRelationshipKind(MeasurableRelationshipKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableRelationship.Json actualJson = new ImmutableMeasurableRelationship.Json();
    actualJson.setDescription("The characteristics of someone or something");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");
    actualJson.setRelationshipKind(MeasurableRelationshipKind.WEAKLY_RELATES_TO);

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRelationship.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRelationship.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRelationship.Json#measurableA()}
   */
  @Test
  void testJsonMeasurableA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRelationship.Json()).measurableA());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRelationship.Json#measurableB()}
   */
  @Test
  void testJsonMeasurableB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRelationship.Json()).measurableB());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRelationship.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRelationship.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Json#relationshipKind()}
   */
  @Test
  void testJsonRelationshipKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRelationship.Json()).relationshipKind());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Json#setMeasurableA(long)}
   */
  @Test
  void testJsonSetMeasurableA() {
    // Arrange
    ImmutableMeasurableRelationship.Json json = new ImmutableMeasurableRelationship.Json();

    // Act
    json.setMeasurableA(1L);

    // Assert
    assertEquals(1L, json.measurableA);
    assertTrue(json.measurableAIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRelationship.Json#setMeasurableB(long)}
   */
  @Test
  void testJsonSetMeasurableB() {
    // Arrange
    ImmutableMeasurableRelationship.Json json = new ImmutableMeasurableRelationship.Json();

    // Act
    json.setMeasurableB(1L);

    // Assert
    assertEquals(1L, json.measurableB);
    assertTrue(json.measurableBIsSet);
  }
}
