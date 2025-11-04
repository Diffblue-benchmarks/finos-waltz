package org.finos.waltz.model.entity_statistic;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityStatisticValue#builder()}
   *   <li>{@link ImmutableEntityStatisticValue#provenance(String)}
   *   <li>{@link ImmutableEntityStatisticValue#reason(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityStatisticValue.Builder actualIdResult = ImmutableEntityStatisticValue.builder().id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableEntityStatisticValue.Builder actualProvenanceResult = actualIdResult.id(id).provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.reason("Just cause"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#createdAt(LocalDateTime)}
   */
  @Test
  void testBuilderCreatedAt() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#current(boolean)}
   */
  @Test
  void testBuilderCurrent() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.current(true));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#entity(EntityReference)}
   */
  @Test
  void testBuilderEntity() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entity(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityStatisticValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityStatisticValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityStatisticValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#from(EntityStatisticValue)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.entity()).thenThrow(new IllegalStateException("instance"));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#from(EntityStatisticValue)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.entity()).thenThrow(new IllegalStateException("instance"));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn(null);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#from(EntityStatisticValue)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.outcome()).thenReturn("Outcome");
    when(instance.entity()).thenReturn(mock(EntityReference.class));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableEntityStatisticValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).outcome();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
    ImmutableEntityStatisticValue buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Just cause", buildResult.reason());
    assertEquals("Outcome", buildResult.outcome());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.statisticId());
    assertEquals(StatisticValueState.EXEMPT, buildResult.state());
    assertTrue(buildResult.current());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#from(EntityStatisticValue)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.outcome()).thenThrow(new IllegalStateException("instance"));
    when(instance.entity()).thenReturn(mock(EntityReference.class));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn("Just cause");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).outcome();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#outcome(String)}
   */
  @Test
  void testBuilderOutcome() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.outcome("Outcome"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#state(StatisticValueState)}
   */
  @Test
  void testBuilderState() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.state(StatisticValueState.EXEMPT));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#statisticId(long)}
   */
  @Test
  void testBuilderStatisticId() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.statisticId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableEntityStatisticValue.Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue#copyOf(EntityStatisticValue)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.outcome()).thenReturn("Outcome");
    when(instance.entity()).thenReturn(mock(EntityReference.class));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn("Just cause");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult2.atStartOfDay());

    // Act
    ImmutableEntityStatisticValue actualCopyOfResult = ImmutableEntityStatisticValue.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).outcome();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Just cause", actualCopyOfResult.reason());
    assertEquals("Outcome", actualCopyOfResult.outcome());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.statisticId());
    assertEquals(StatisticValueState.EXEMPT, actualCopyOfResult.state());
    assertTrue(actualCopyOfResult.current());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue#copyOf(EntityStatisticValue)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.outcome()).thenReturn("Outcome");
    when(instance.entity()).thenReturn(mock(EntityReference.class));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(false);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn("Just cause");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult2.atStartOfDay());

    // Act
    ImmutableEntityStatisticValue actualCopyOfResult = ImmutableEntityStatisticValue.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).outcome();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Just cause", actualCopyOfResult.reason());
    assertEquals("Outcome", actualCopyOfResult.outcome());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.statisticId());
    assertEquals(StatisticValueState.EXEMPT, actualCopyOfResult.state());
    assertFalse(actualCopyOfResult.current());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue#copyOf(EntityStatisticValue)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntityStatisticValue instance = mock(EntityStatisticValue.class);
    when(instance.outcome()).thenReturn("Outcome");
    when(instance.entity()).thenReturn(mock(EntityReference.class));
    when(instance.value()).thenReturn("42");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.state()).thenReturn(StatisticValueState.EXEMPT);
    when(instance.current()).thenReturn(true);
    when(instance.statisticId()).thenReturn(1L);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.reason()).thenReturn(null);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult2.atStartOfDay());

    // Act
    ImmutableEntityStatisticValue actualCopyOfResult = ImmutableEntityStatisticValue.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).createdAt();
    verify(instance).current();
    verify(instance).entity();
    verify(instance).outcome();
    verify(instance).reason();
    verify(instance).state();
    verify(instance).statisticId();
    verify(instance).value();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Outcome", actualCopyOfResult.outcome());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.reason());
    assertEquals(1L, actualCopyOfResult.statisticId());
    assertEquals(StatisticValueState.EXEMPT, actualCopyOfResult.state());
    assertTrue(actualCopyOfResult.current());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).createdAt());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#current()}
   */
  @Test
  void testJsonCurrent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).current());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#entity()}
   */
  @Test
  void testJsonEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).entity());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityStatisticValue.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityStatisticValue.Json actualJson = new ImmutableEntityStatisticValue.Json();

    // Assert
    assertNull(actualJson.outcome);
    assertNull(actualJson.provenance);
    assertNull(actualJson.reason);
    assertNull(actualJson.value);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.entity);
    assertNull(actualJson.state);
    assertEquals(0L, actualJson.statisticId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.current);
    assertFalse(actualJson.currentIsSet);
    assertFalse(actualJson.statisticIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#outcome()}
   */
  @Test
  void testJsonOutcome() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).outcome());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#reason()}
   */
  @Test
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).reason());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Json#setCurrent(boolean)}
   */
  @Test
  void testJsonSetCurrent() {
    // Arrange
    ImmutableEntityStatisticValue.Json json = new ImmutableEntityStatisticValue.Json();

    // Act
    json.setCurrent(true);

    // Assert
    assertTrue(json.current);
    assertTrue(json.currentIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Json#setCurrent(boolean)}
   */
  @Test
  void testJsonSetCurrent2() {
    // Arrange
    ImmutableEntityStatisticValue.Json json = new ImmutableEntityStatisticValue.Json();
    json.setEntity(mock(EntityReference.class));

    // Act
    json.setCurrent(true);

    // Assert
    assertTrue(json.current);
    assertTrue(json.currentIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Json#setStatisticId(long)}
   */
  @Test
  void testJsonSetStatisticId() {
    // Arrange
    ImmutableEntityStatisticValue.Json json = new ImmutableEntityStatisticValue.Json();

    // Act
    json.setStatisticId(1L);

    // Assert
    assertEquals(1L, json.statisticId);
    assertTrue(json.statisticIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticValue.Json#setStatisticId(long)}
   */
  @Test
  void testJsonSetStatisticId2() {
    // Arrange
    ImmutableEntityStatisticValue.Json json = new ImmutableEntityStatisticValue.Json();
    json.setEntity(mock(EntityReference.class));

    // Act
    json.setStatisticId(1L);

    // Assert
    assertEquals(1L, json.statisticId);
    assertTrue(json.statisticIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#state()}
   */
  @Test
  void testJsonState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).state());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#statisticId()}
   */
  @Test
  void testJsonStatisticId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).statisticId());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticValue.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticValue.Json()).value());
  }
}
