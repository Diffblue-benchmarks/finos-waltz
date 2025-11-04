package org.finos.waltz.model.database_usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableDatabaseUsageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDatabaseUsage#builder()}
   *   <li>{@link ImmutableDatabaseUsage#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableDatabaseUsage#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableDatabaseUsage.Builder actualBuilderResult = ImmutableDatabaseUsage.builder();
    ImmutableDatabaseUsage.Builder actualLastUpdatedAtResult = actualBuilderResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Builder#databaseId(long)}
   */
  @Test
  void testBuilderDatabaseId() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.databaseId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseUsage.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Builder#environment(String)}
   */
  @Test
  void testBuilderEnvironment() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.environment("Environment"));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseUsage.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableDatabaseUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseUsage.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();
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
   * {@link ImmutableDatabaseUsage.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDatabaseUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Builder#from(DatabaseUsage)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();
    DatabaseUsage instance = mock(DatabaseUsage.class);
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
   * Method under test: {@link ImmutableDatabaseUsage.Builder#from(DatabaseUsage)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();
    DatabaseUsage instance = mock(DatabaseUsage.class);
    when(instance.databaseId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.environment()).thenReturn("Environment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDatabaseUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).databaseId();
    verify(instance).entityReference();
    verify(instance).environment();
    verify(instance).id();
    ImmutableDatabaseUsage buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Environment", buildResult.environment());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.databaseId());
    assertEquals(1L, buildResult.id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Builder#from(DatabaseUsage)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();
    DatabaseUsage instance = mock(DatabaseUsage.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
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
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseUsage.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableDatabaseUsage.Builder builderResult = ImmutableDatabaseUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage#copyOf(DatabaseUsage)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DatabaseUsage instance = mock(DatabaseUsage.class);
    when(instance.databaseId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.environment()).thenReturn("Environment");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableDatabaseUsage actualCopyOfResult = ImmutableDatabaseUsage.copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).databaseId();
    verify(instance).entityReference();
    verify(instance).environment();
    verify(instance).id();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Environment", actualCopyOfResult.environment());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.databaseId());
    assertEquals(1L, actualCopyOfResult.id());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#databaseId()}
   */
  @Test
  void testJsonDatabaseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseUsage.Json()).databaseId());
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseUsage.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#environment()}
   */
  @Test
  void testJsonEnvironment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseUsage.Json()).environment());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDatabaseUsage.Json}
   *   <li>{@link ImmutableDatabaseUsage.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableDatabaseUsage.Json#setEnvironment(String)}
   *   <li>{@link ImmutableDatabaseUsage.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableDatabaseUsage.Json#setLastUpdatedBy(String)}
   *   <li>{@link ImmutableDatabaseUsage.Json#setProvenance(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDatabaseUsage.Json actualJson = new ImmutableDatabaseUsage.Json();
    actualJson.setEntityReference(null);
    actualJson.setEnvironment("Environment");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseUsage.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseUsage.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseUsage.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDatabaseUsage.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#setDatabaseId(long)}
   */
  @Test
  void testJsonSetDatabaseId() {
    // Arrange
    ImmutableDatabaseUsage.Json json = new ImmutableDatabaseUsage.Json();

    // Act
    json.setDatabaseId(1L);

    // Assert
    assertEquals(1L, json.databaseId);
    assertTrue(json.databaseIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#setDatabaseId(long)}
   */
  @Test
  void testJsonSetDatabaseId2() {
    // Arrange
    ImmutableDatabaseUsage.Json json = new ImmutableDatabaseUsage.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setDatabaseId(1L);

    // Assert
    assertEquals(1L, json.databaseId);
    assertTrue(json.databaseIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#setId(long)}
   */
  @Test
  void testJsonSetId() {
    // Arrange
    ImmutableDatabaseUsage.Json json = new ImmutableDatabaseUsage.Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Method under test: {@link ImmutableDatabaseUsage.Json#setId(long)}
   */
  @Test
  void testJsonSetId2() {
    // Arrange
    ImmutableDatabaseUsage.Json json = new ImmutableDatabaseUsage.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }
}
