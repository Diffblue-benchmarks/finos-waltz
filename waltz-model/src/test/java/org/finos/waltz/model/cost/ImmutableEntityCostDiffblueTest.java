package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class ImmutableEntityCostDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityCost#builder()}
   *   <li>{@link ImmutableEntityCost#kind(EntityKind)}
   *   <li>{@link ImmutableEntityCost#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityCost#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityCost.Builder actualIdResult = ImmutableEntityCost.builder().id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableEntityCost.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableEntityCost.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#amount(BigDecimal)}
   */
  @Test
  void testBuilderAmount() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.amount(new BigDecimal("2.3")));
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#costKindId(Long)}
   */
  @Test
  void testBuilderCostKindId() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.costKindId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCost.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCost.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCost.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCost.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableEntityCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCost.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
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
   * {@link ImmutableEntityCost.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#from(EntityCost)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    EntityCost instance = mock(EntityCost.class);
    when(instance.year()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.amount()).thenReturn(new BigDecimal("2.3"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).amount();
    verify(instance).year();
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#from(EntityCost)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    EntityCost instance = mock(EntityCost.class);
    when(instance.costKindId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.year()).thenReturn(1);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.amount()).thenReturn(bigDecimal);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).amount();
    verify(instance).costKindId();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).year();
    ImmutableEntityCost buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1, buildResult.year());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(bigDecimal, buildResult.amount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#from(EntityCost)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    EntityCost instance = mock(EntityCost.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.year()).thenReturn(1);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.amount()).thenReturn(new BigDecimal("2.3"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).amount();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).year();
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#from(EntityCost)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    EntityCost instance = mock(EntityCost.class);
    when(instance.costKindId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.year()).thenReturn(1);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.amount()).thenReturn(bigDecimal);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).amount();
    verify(instance).costKindId();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).year();
    ImmutableEntityCost buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1, buildResult.year());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(bigDecimal, buildResult.amount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Builder#year(int)}
   */
  @Test
  void testBuilderYear() {
    // Arrange
    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
  }

  /**
   * Method under test: {@link ImmutableEntityCost#copyOf(EntityCost)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityCost instance = mock(EntityCost.class);
    when(instance.costKindId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.year()).thenReturn(1);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.amount()).thenReturn(bigDecimal);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityCost actualCopyOfResult = ImmutableEntityCost.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).amount();
    verify(instance).costKindId();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).year();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(1L, actualCopyOfResult.costKindId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    BigDecimal amountResult = actualCopyOfResult.amount();
    assertEquals(expectedAmountResult, amountResult);
    assertSame(bigDecimal, amountResult);
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCost#copyOf(EntityCost)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityCost instance = mock(EntityCost.class);
    when(instance.costKindId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.year()).thenReturn(1);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.amount()).thenReturn(bigDecimal);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityCost actualCopyOfResult = ImmutableEntityCost.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).amount();
    verify(instance).costKindId();
    verify(instance).entityReference();
    verify(instance).kind();
    verify(instance).year();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(1L, actualCopyOfResult.costKindId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    BigDecimal amountResult = actualCopyOfResult.amount();
    assertEquals(expectedAmountResult, amountResult);
    assertSame(bigDecimal, amountResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#amount()}
   */
  @Test
  void testJsonAmount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCost.Json()).amount());
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#costKindId()}
   */
  @Test
  void testJsonCostKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCost.Json()).costKindId());
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCost.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCost.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCost.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCost.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCost.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityCost.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityCost.Json actualJson = new ImmutableEntityCost.Json();

    // Assert
    assertNull(actualJson.costKindId);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.amount);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityReference);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCost.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#setYear(int)}
   */
  @Test
  void testJsonSetYear() {
    // Arrange
    ImmutableEntityCost.Json json = new ImmutableEntityCost.Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#setYear(int)}
   */
  @Test
  void testJsonSetYear2() {
    // Arrange
    ImmutableEntityCost.Json json = new ImmutableEntityCost.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityCost.Json#year()}
   */
  @Test
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCost.Json()).year());
  }
}
