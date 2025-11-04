package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableComplexityDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableComplexity#builder()}
   *   <li>{@link ImmutableComplexity#kind(EntityKind)}
   *   <li>{@link ImmutableComplexity#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableComplexity#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableComplexity.Builder actualIdResult = ImmutableComplexity.builder().id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableComplexity.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableComplexity.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#complexityKindId(Long)}
   */
  @Test
  void testBuilderComplexityKindId() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKindId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexity.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexity.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableComplexity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexity.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableComplexity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableComplexity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableComplexity.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableComplexity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexity.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
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
   * {@link ImmutableComplexity.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableComplexity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#from(Complexity)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    Complexity instance = mock(Complexity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.complexityKindId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.score()).thenReturn(new BigDecimal("2.3"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).complexityKindId();
    verify(instance).entityReference();
    verify(instance).score();
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#from(Complexity)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    Complexity instance = mock(Complexity.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.complexityKindId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.score()).thenReturn(bigDecimal);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableComplexity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).complexityKindId();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).score();
    ImmutableComplexity buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.complexityKindId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(bigDecimal, buildResult.score());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#from(Complexity)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    Complexity instance = mock(Complexity.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.complexityKindId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.score()).thenReturn(new BigDecimal("2.3"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).complexityKindId();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).score();
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#from(Complexity)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    Complexity instance = mock(Complexity.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.complexityKindId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.score()).thenReturn(bigDecimal);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableComplexity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).complexityKindId();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).score();
    ImmutableComplexity buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.complexityKindId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(bigDecimal, buildResult.score());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableComplexity.Builder#score(BigDecimal)}
   */
  @Test
  void testBuilderScore() {
    // Arrange
    ImmutableComplexity.Builder builderResult = ImmutableComplexity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.score(new BigDecimal("2.3")));
  }

  /**
   * Method under test: {@link ImmutableComplexity#copyOf(Complexity)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Complexity instance = mock(Complexity.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.complexityKindId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.score()).thenReturn(bigDecimal);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableComplexity actualCopyOfResult = ImmutableComplexity.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).complexityKindId();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).score();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.complexityKindId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    BigDecimal expectedScoreResult = new BigDecimal("2.3");
    BigDecimal scoreResult = actualCopyOfResult.score();
    assertEquals(expectedScoreResult, scoreResult);
    assertSame(bigDecimal, scoreResult);
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableComplexity#copyOf(Complexity)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Complexity instance = mock(Complexity.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.complexityKindId()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.score()).thenReturn(bigDecimal);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableComplexity actualCopyOfResult = ImmutableComplexity.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).complexityKindId();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).score();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.complexityKindId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    BigDecimal expectedScoreResult = new BigDecimal("2.3");
    BigDecimal scoreResult = actualCopyOfResult.score();
    assertEquals(expectedScoreResult, scoreResult);
    assertSame(bigDecimal, scoreResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexity#fromJson(ImmutableComplexity.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableComplexity.Json json = new ImmutableComplexity.Json();
    json.setId(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setProvenance(null);
    json.setEntityReference(mock(EntityReference.class));
    json.setComplexityKindId(1L);
    BigDecimal score = new BigDecimal("2.3");
    json.setScore(score);
    json.setKind(null);

    // Act
    ImmutableComplexity actualFromJsonResult = ImmutableComplexity.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.complexityKindId().longValue());
    assertEquals(EntityKind.COMPLEXITY, actualFromJsonResult.kind());
    BigDecimal expectedScoreResult = new BigDecimal("2.3");
    BigDecimal scoreResult = actualFromJsonResult.score();
    assertEquals(expectedScoreResult, scoreResult);
    assertSame(score, scoreResult);
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexity#fromJson(ImmutableComplexity.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableComplexity.Json json = new ImmutableComplexity.Json();
    json.setId(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setProvenance(null);
    json.setEntityReference(mock(EntityReference.class));
    json.setComplexityKindId(1L);
    BigDecimal score = new BigDecimal("2.3");
    json.setScore(score);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableComplexity actualFromJsonResult = ImmutableComplexity.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.complexityKindId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    BigDecimal expectedScoreResult = new BigDecimal("2.3");
    BigDecimal scoreResult = actualFromJsonResult.score();
    assertEquals(expectedScoreResult, scoreResult);
    assertSame(score, scoreResult);
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableComplexity.Json#complexityKindId()}
   */
  @Test
  void testJsonComplexityKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexity.Json()).complexityKindId());
  }

  /**
   * Method under test: {@link ImmutableComplexity.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexity.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableComplexity.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexity.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableComplexity.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexity.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableComplexity.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexity.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableComplexity.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexity.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableComplexity.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableComplexity.Json actualJson = new ImmutableComplexity.Json();

    // Assert
    assertNull(actualJson.complexityKindId);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.score);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableComplexity.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexity.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableComplexity.Json#score()}
   */
  @Test
  void testJsonScore() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexity.Json()).score());
  }
}
