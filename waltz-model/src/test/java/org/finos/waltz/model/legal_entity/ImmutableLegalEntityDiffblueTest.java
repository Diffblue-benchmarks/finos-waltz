package org.finos.waltz.model.legal_entity;

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
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLegalEntity#builder()}
   *   <li>{@link ImmutableLegalEntity#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link ImmutableLegalEntity#kind(EntityKind)}
   *   <li>{@link ImmutableLegalEntity#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableLegalEntity#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableLegalEntity.Builder actualIdResult = ImmutableLegalEntity.builder()
        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableLegalEntity.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableLegalEntity.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntity.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableLegalEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntity.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntity.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableLegalEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntity.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableLegalEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableLegalEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntity.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLegalEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntity.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
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
   * {@link ImmutableLegalEntity.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#from(LegalEntity)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    LegalEntity instance = mock(LegalEntity.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    ImmutableLegalEntity buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#from(LegalEntity)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    LegalEntity instance = mock(LegalEntity.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#from(LegalEntity)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    LegalEntity instance = mock(LegalEntity.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntity.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    ImmutableLegalEntity buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableLegalEntity.Builder builderResult = ImmutableLegalEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableLegalEntity#copyOf(LegalEntity)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LegalEntity instance = mock(LegalEntity.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntity actualCopyOfResult = ImmutableLegalEntity.copyOf(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableLegalEntity#copyOf(LegalEntity)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    LegalEntity instance = mock(LegalEntity.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntity actualCopyOfResult = ImmutableLegalEntity.copyOf(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntity#fromJson(ImmutableLegalEntity.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLegalEntity.Json json = new ImmutableLegalEntity.Json();
    json.setEntityLifecycleStatus(null);
    json.setId(null);
    json.setProvenance(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setName("Json");
    json.setDescription("Json");
    json.setExternalId("Json");
    json.setKind(null);

    // Act
    ImmutableLegalEntity actualFromJsonResult = ImmutableLegalEntity.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(EntityKind.LEGAL_ENTITY, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntity#fromJson(ImmutableLegalEntity.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableLegalEntity.Json json = new ImmutableLegalEntity.Json();
    json.setEntityLifecycleStatus(null);
    json.setId(null);
    json.setProvenance(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setName("Json");
    json.setDescription("Json");
    json.setExternalId("Json");
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableLegalEntity actualFromJsonResult = ImmutableLegalEntity.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntity.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntity.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntity.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntity.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntity.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntity.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntity.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntity.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLegalEntity.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLegalEntity.Json actualJson = new ImmutableLegalEntity.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.externalId);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableLegalEntity.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntity.Json()).provenance());
  }
}
