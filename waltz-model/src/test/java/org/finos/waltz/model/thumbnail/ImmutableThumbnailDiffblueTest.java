package org.finos.waltz.model.thumbnail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableThumbnailDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableThumbnail#builder()}
   *   <li>{@link ImmutableThumbnail#externalId(String)}
   *   <li>{@link ImmutableThumbnail#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableThumbnail#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableThumbnail.Builder actualExternalIdResult = ImmutableThumbnail.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableThumbnail.Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);
    ImmutableThumbnail.Builder actualLastUpdatedAtResult = actualExternalIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Builder#blob(byte[])}
   */
  @Test
  void testBuilderBlob() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.blob("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnail.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableThumbnail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnail.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableThumbnail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnail.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnail.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableThumbnail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnail.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();
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
   * {@link ImmutableThumbnail.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableThumbnail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Builder#from(Thumbnail)}
   */
  @Test
  void testBuilderFrom7() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();
    Thumbnail instance = mock(Thumbnail.class);
    when(instance.parentEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).blob();
    verify(instance).mimeType();
    verify(instance).parentEntityReference();
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Builder#from(Thumbnail)}
   */
  @Test
  void testBuilderFrom8() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();
    Thumbnail instance = mock(Thumbnail.class);
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableThumbnail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).blob();
    verify(instance).mimeType();
    verify(instance).parentEntityReference();
    ImmutableThumbnail buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Mime Type", buildResult.mimeType());
    assertEquals("Provenance", buildResult.provenance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Builder#mimeType(String)}
   */
  @Test
  void testBuilderMimeType() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.mimeType("Mime Type"));
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnail.Builder#parentEntityReference(EntityReference)}
   */
  @Test
  void testBuilderParentEntityReference() {
    // Arrange
    ImmutableThumbnail.Builder builderResult = ImmutableThumbnail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableThumbnail#copyOf(Thumbnail)}
   */
  @Test
  void testCopyOf() throws UnsupportedEncodingException {
    // Arrange
    Thumbnail instance = mock(Thumbnail.class);
    when(instance.parentEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.mimeType()).thenReturn("Mime Type");
    when(instance.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableThumbnail actualCopyOfResult = ImmutableThumbnail.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).blob();
    verify(instance).mimeType();
    verify(instance).parentEntityReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Mime Type", actualCopyOfResult.mimeType());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnail#fromJson(ImmutableThumbnail.Json)}
   */
  @Test
  void testFromJson() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnail.Json json = new ImmutableThumbnail.Json();
    json.setExternalId(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setProvenance(null);
    json.setParentEntityReference(mock(EntityReference.class));
    json.setMimeType("Json");
    json.setBlob("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ImmutableThumbnail actualFromJsonResult = ImmutableThumbnail.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.mimeType());
    assertEquals("waltz", actualFromJsonResult.provenance());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnail#fromJson(ImmutableThumbnail.Json)}
   */
  @Test
  void testFromJson2() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnail.Json json = new ImmutableThumbnail.Json();
    json.setExternalId(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setParentEntityReference(mock(EntityReference.class));
    json.setMimeType("Json");
    json.setBlob("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ImmutableThumbnail actualFromJsonResult = ImmutableThumbnail.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.mimeType());
    assertEquals("Json", actualFromJsonResult.provenance());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableThumbnail#fromJson(ImmutableThumbnail.Json)}
   */
  @Test
  void testFromJson3() throws UnsupportedEncodingException {
    // Arrange
    ImmutableThumbnail.Json json = new ImmutableThumbnail.Json();
    json.setExternalId(null);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance(null);
    json.setParentEntityReference(mock(EntityReference.class));
    json.setMimeType("Json");
    json.setBlob("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ImmutableThumbnail actualFromJsonResult = ImmutableThumbnail.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.mimeType());
    assertEquals("waltz", actualFromJsonResult.provenance());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Json#blob()}
   */
  @Test
  void testJsonBlob() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableThumbnail.Json()).blob());
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableThumbnail.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableThumbnail.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableThumbnail.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Json#mimeType()}
   */
  @Test
  void testJsonMimeType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableThumbnail.Json()).mimeType());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableThumbnail.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableThumbnail.Json actualJson = new ImmutableThumbnail.Json();

    // Assert
    assertNull(actualJson.blob);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.mimeType);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.parentEntityReference);
    assertFalse(actualJson.externalId.isPresent());
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Json#parentEntityReference()}
   */
  @Test
  void testJsonParentEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableThumbnail.Json()).parentEntityReference());
  }

  /**
   * Method under test: {@link ImmutableThumbnail.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableThumbnail.Json()).provenance());
  }
}
