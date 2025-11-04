package org.finos.waltz.model.allocation;

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
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableAllocationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAllocation#builder()}
   *   <li>{@link ImmutableAllocation#externalId(String)}
   *   <li>{@link ImmutableAllocation#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableAllocation#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAllocation.Builder actualExternalIdResult = ImmutableAllocation.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableAllocation.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableAllocation.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableAllocation.Builder actualLastUpdatedAtResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocation.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableAllocation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocation.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableAllocation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocation.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAllocation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAllocation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAllocation.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableAllocation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocation.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
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
   * {@link ImmutableAllocation.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAllocation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#from(Allocation)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    Allocation instance = mock(Allocation.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAllocation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    verify(instance).schemeId();
    ImmutableAllocation buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1, buildResult.percentage());
    assertEquals(1L, buildResult.measurableRatingId().longValue());
    assertEquals(1L, buildResult.schemeId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#from(Allocation)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    Allocation instance = mock(Allocation.class);
    when(instance.measurableRatingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#from(Allocation)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    Allocation instance = mock(Allocation.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAllocation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    verify(instance).schemeId();
    ImmutableAllocation buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1, buildResult.percentage());
    assertEquals(1L, buildResult.measurableRatingId().longValue());
    assertEquals(1L, buildResult.schemeId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#from(Allocation)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    Allocation instance = mock(Allocation.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAllocation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    verify(instance).schemeId();
    ImmutableAllocation buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1, buildResult.percentage());
    assertEquals(1L, buildResult.measurableRatingId().longValue());
    assertEquals(1L, buildResult.schemeId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocation.Builder#measurableRatingId(Long)}
   */
  @Test
  void testBuilderMeasurableRatingId() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatingId(1L));
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#percentage(int)}
   */
  @Test
  void testBuilderPercentage() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.percentage(1));
  }

  /**
   * Method under test: {@link ImmutableAllocation.Builder#schemeId(long)}
   */
  @Test
  void testBuilderSchemeId() {
    // Arrange
    ImmutableAllocation.Builder builderResult = ImmutableAllocation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.schemeId(1L));
  }

  /**
   * Method under test: {@link ImmutableAllocation#copyOf(Allocation)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Allocation instance = mock(Allocation.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.schemeId()).thenReturn(1L);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAllocation actualCopyOfResult = ImmutableAllocation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    verify(instance).schemeId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1, actualCopyOfResult.percentage());
    assertEquals(1L, actualCopyOfResult.measurableRatingId().longValue());
    assertEquals(1L, actualCopyOfResult.schemeId());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAllocation#copyOf(Allocation)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Allocation instance = mock(Allocation.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.schemeId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAllocation actualCopyOfResult = ImmutableAllocation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    verify(instance).schemeId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1, actualCopyOfResult.percentage());
    assertEquals(1L, actualCopyOfResult.measurableRatingId().longValue());
    assertEquals(1L, actualCopyOfResult.schemeId());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAllocation#copyOf(Allocation)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Allocation instance = mock(Allocation.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.schemeId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAllocation actualCopyOfResult = ImmutableAllocation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    verify(instance).schemeId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1, actualCopyOfResult.percentage());
    assertEquals(1L, actualCopyOfResult.measurableRatingId().longValue());
    assertEquals(1L, actualCopyOfResult.schemeId());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocation.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocation.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocation.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocation.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#measurableRatingId()}
   */
  @Test
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocation.Json()).measurableRatingId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAllocation.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAllocation.Json actualJson = new ImmutableAllocation.Json();

    // Assert
    assertNull(actualJson.measurableRatingId);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertEquals(0, actualJson.percentage);
    assertEquals(0L, actualJson.schemeId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.percentageIsSet);
    assertFalse(actualJson.schemeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#percentage()}
   */
  @Test
  void testJsonPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocation.Json()).percentage());
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocation.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#schemeId()}
   */
  @Test
  void testJsonSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocation.Json()).schemeId());
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#setPercentage(int)}
   */
  @Test
  void testJsonSetPercentage() {
    // Arrange
    ImmutableAllocation.Json json = new ImmutableAllocation.Json();

    // Act
    json.setPercentage(1);

    // Assert
    assertEquals(1, json.percentage);
    assertTrue(json.percentageIsSet);
  }

  /**
   * Method under test: {@link ImmutableAllocation.Json#setSchemeId(long)}
   */
  @Test
  void testJsonSetSchemeId() {
    // Arrange
    ImmutableAllocation.Json json = new ImmutableAllocation.Json();

    // Act
    json.setSchemeId(1L);

    // Assert
    assertEquals(1L, json.schemeId);
    assertTrue(json.schemeIdIsSet);
  }
}
