package org.finos.waltz.model.entity_relationship;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityRelationshipDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityRelationship#builder()}
   *   <li>{@link ImmutableEntityRelationship#description(String)}
   *   <li>{@link ImmutableEntityRelationship#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableEntityRelationship#provenance(String)}
   *   <li>{@link ImmutableEntityRelationship#relationship(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityRelationship.Builder actualIdResult = ImmutableEntityRelationship.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableEntityRelationship.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableEntityRelationship.Builder actualProvenanceResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.relationship("127.0.0.1"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#a(EntityReference)}
   */
  @Test
  void testBuilderA() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.a(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#b(EntityReference)}
   */
  @Test
  void testBuilderB() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.b(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
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
   * {@link ImmutableEntityRelationship.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(EntityRelationship)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    when(instance.a()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(EntityRelationship)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    when(instance.a()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(EntityRelationship)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    when(instance.b()).thenThrow(new IllegalStateException("instance"));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(EntityRelationship)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.relationship()).thenReturn("127.0.0.1");
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationship();
    ImmutableEntityRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(EntityRelationship)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#from(EntityRelationship)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    EntityRelationship instance = mock(EntityRelationship.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.relationship()).thenReturn("127.0.0.1");
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationship();
    ImmutableEntityRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship#copyOf(EntityRelationship)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityRelationship instance = mock(EntityRelationship.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.relationship()).thenReturn("127.0.0.1");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityRelationship actualCopyOfResult = ImmutableEntityRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationship();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship#copyOf(EntityRelationship)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityRelationship instance = mock(EntityRelationship.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.relationship()).thenReturn("127.0.0.1");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityRelationship actualCopyOfResult = ImmutableEntityRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationship();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship#copyOf(EntityRelationship)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntityRelationship instance = mock(EntityRelationship.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.relationship()).thenReturn("127.0.0.1");
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.b()).thenReturn(mock(EntityReference.class));
    when(instance.a()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityRelationship actualCopyOfResult = ImmutableEntityRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).a();
    verify(instance).b();
    verify(instance).relationship();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship#fromJson(ImmutableEntityRelationship.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityRelationship.Json json = new ImmutableEntityRelationship.Json();
    json.setId(null);
    json.setProvenance(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setDescription(null);
    json.setA(mock(EntityReference.class));
    json.setB(mock(EntityReference.class));
    json.setRelationship(null);

    // Act
    ImmutableEntityRelationship actualFromJsonResult = ImmutableEntityRelationship.fromJson(json);

    // Assert
    assertEquals("HAS", actualFromJsonResult.relationship());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedAResult = json.a;
    assertSame(expectedAResult, actualFromJsonResult.a());
    EntityReference expectedBResult = json.b;
    assertSame(expectedBResult, actualFromJsonResult.b());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship#fromJson(ImmutableEntityRelationship.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableEntityRelationship.Json json = new ImmutableEntityRelationship.Json();
    json.setId(null);
    json.setProvenance(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setDescription(null);
    json.setA(mock(EntityReference.class));
    json.setB(mock(EntityReference.class));
    json.setRelationship("Json");

    // Act
    ImmutableEntityRelationship actualFromJsonResult = ImmutableEntityRelationship.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.relationship());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedAResult = json.a;
    assertSame(expectedAResult, actualFromJsonResult.a());
    EntityReference expectedBResult = json.b;
    assertSame(expectedBResult, actualFromJsonResult.b());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship#fromJson(ImmutableEntityRelationship.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableEntityRelationship.Json json = new ImmutableEntityRelationship.Json();
    json.setId(null);
    json.setProvenance("lastUpdatedBy");
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setDescription(null);
    json.setA(mock(EntityReference.class));
    json.setB(mock(EntityReference.class));
    json.setRelationship(null);

    // Act
    ImmutableEntityRelationship actualFromJsonResult = ImmutableEntityRelationship.fromJson(json);

    // Assert
    assertEquals("HAS", actualFromJsonResult.relationship());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedAResult = json.a;
    assertSame(expectedAResult, actualFromJsonResult.a());
    EntityReference expectedBResult = json.b;
    assertSame(expectedBResult, actualFromJsonResult.b());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityRelationship#fromJson(ImmutableEntityRelationship.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableEntityRelationship.Json json = new ImmutableEntityRelationship.Json();
    json.setId(null);
    json.setProvenance(null);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setDescription(null);
    json.setA(mock(EntityReference.class));
    json.setB(mock(EntityReference.class));
    json.setRelationship(null);

    // Act
    ImmutableEntityRelationship actualFromJsonResult = ImmutableEntityRelationship.fromJson(json);

    // Assert
    assertEquals("HAS", actualFromJsonResult.relationship());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedAResult = json.a;
    assertSame(expectedAResult, actualFromJsonResult.a());
    EntityReference expectedBResult = json.b;
    assertSame(expectedBResult, actualFromJsonResult.b());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Json#a()}
   */
  @Test
  void testJsonA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationship.Json()).a());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Json#b()}
   */
  @Test
  void testJsonB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationship.Json()).b());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationship.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationship.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationship.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationship.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityRelationship.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityRelationship.Json actualJson = new ImmutableEntityRelationship.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.relationship);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.a);
    assertNull(actualJson.b);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationship.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableEntityRelationship.Json#relationship()}
   */
  @Test
  void testJsonRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityRelationship.Json()).relationship());
  }
}
