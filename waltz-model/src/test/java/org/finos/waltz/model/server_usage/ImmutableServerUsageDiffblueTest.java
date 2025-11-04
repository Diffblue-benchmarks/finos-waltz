package org.finos.waltz.model.server_usage;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableServerUsageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableServerUsage#builder()}
   *   <li>{@link ImmutableServerUsage#environment(String)}
   *   <li>{@link ImmutableServerUsage#kind(EntityKind)}
   *   <li>{@link ImmutableServerUsage#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableServerUsage#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableServerUsage.Builder actualIdResult = ImmutableServerUsage.builder().environment("Environment").id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableServerUsage.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableServerUsage.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableServerUsage.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableServerUsage.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableServerUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerUsage.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableServerUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableServerUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableServerUsage.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableServerUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerUsage.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
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
   * {@link ImmutableServerUsage.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#from(ServerUsage)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    ServerUsage instance = mock(ServerUsage.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.environment()).thenReturn("Environment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).environment();
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#from(ServerUsage)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    ServerUsage instance = mock(ServerUsage.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.serverId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.environment()).thenReturn("Environment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).environment();
    verify(instance).kind();
    verify(instance).serverId();
    ImmutableServerUsage buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Environment", buildResult.environment());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.serverId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#from(ServerUsage)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    ServerUsage instance = mock(ServerUsage.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.environment()).thenReturn("Environment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).environment();
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#from(ServerUsage)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    ServerUsage instance = mock(ServerUsage.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.serverId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.environment()).thenReturn("Environment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).environment();
    verify(instance).kind();
    verify(instance).serverId();
    ImmutableServerUsage buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Environment", buildResult.environment());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.serverId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Builder#serverId(long)}
   */
  @Test
  void testBuilderServerId() {
    // Arrange
    ImmutableServerUsage.Builder builderResult = ImmutableServerUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.serverId(1L));
  }

  /**
   * Method under test: {@link ImmutableServerUsage#copyOf(ServerUsage)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ServerUsage instance = mock(ServerUsage.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.serverId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.environment()).thenReturn("Environment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerUsage actualCopyOfResult = ImmutableServerUsage.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).environment();
    verify(instance).kind();
    verify(instance).serverId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Environment", actualCopyOfResult.environment());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.serverId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableServerUsage#copyOf(ServerUsage)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ServerUsage instance = mock(ServerUsage.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.serverId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.environment()).thenReturn("Environment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerUsage actualCopyOfResult = ImmutableServerUsage.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).environment();
    verify(instance).kind();
    verify(instance).serverId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Environment", actualCopyOfResult.environment());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.serverId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerUsage.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#environment()}
   */
  @Test
  void testJsonEnvironment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerUsage.Json()).environment());
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerUsage.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerUsage.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerUsage.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerUsage.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableServerUsage.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableServerUsage.Json actualJson = new ImmutableServerUsage.Json();

    // Assert
    assertNull(actualJson.environment);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityReference);
    assertEquals(0L, actualJson.serverId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.serverIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerUsage.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#serverId()}
   */
  @Test
  void testJsonServerId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerUsage.Json()).serverId());
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#setServerId(long)}
   */
  @Test
  void testJsonSetServerId() {
    // Arrange
    ImmutableServerUsage.Json json = new ImmutableServerUsage.Json();

    // Act
    json.setServerId(1L);

    // Assert
    assertEquals(1L, json.serverId);
    assertTrue(json.serverIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableServerUsage.Json#setServerId(long)}
   */
  @Test
  void testJsonSetServerId2() {
    // Arrange
    ImmutableServerUsage.Json json = new ImmutableServerUsage.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setServerId(1L);

    // Assert
    assertEquals(1L, json.serverId);
    assertTrue(json.serverIdIsSet);
  }
}
