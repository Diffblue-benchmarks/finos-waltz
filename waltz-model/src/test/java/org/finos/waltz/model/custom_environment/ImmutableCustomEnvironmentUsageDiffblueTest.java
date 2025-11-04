package org.finos.waltz.model.custom_environment;

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
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableCustomEnvironmentUsageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCustomEnvironmentUsage#builder()}
   *   <li>{@link ImmutableCustomEnvironmentUsage#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableCustomEnvironmentUsage#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableCustomEnvironmentUsage.Builder actualBuilderResult = ImmutableCustomEnvironmentUsage.builder();
    ImmutableCustomEnvironmentUsage.Builder actualIdResult = actualBuilderResult
        .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableCustomEnvironmentUsage.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#createdBy(String)}
   */
  @Test
  void testBuilderCreatedBy() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#customEnvironmentId(Long)}
   */
  @Test
  void testBuilderCustomEnvironmentId() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.customEnvironmentId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableCustomEnvironmentUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableCustomEnvironmentUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableCustomEnvironmentUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableCustomEnvironmentUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#from(CustomEnvironmentUsage)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    CustomEnvironmentUsage instance = mock(CustomEnvironmentUsage.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.customEnvironmentId()).thenReturn(1L);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).customEnvironmentId();
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#from(CustomEnvironmentUsage)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    CustomEnvironmentUsage instance = mock(CustomEnvironmentUsage.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.customEnvironmentId()).thenReturn(1L);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableCustomEnvironmentUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).customEnvironmentId();
    verify(instance).entityReference();
    ImmutableCustomEnvironmentUsage buildResult = builderResult.build();
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.customEnvironmentId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironmentUsage.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage#copyOf(CustomEnvironmentUsage)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CustomEnvironmentUsage instance = mock(CustomEnvironmentUsage.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.customEnvironmentId()).thenReturn(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableCustomEnvironmentUsage actualCopyOfResult = ImmutableCustomEnvironmentUsage.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).customEnvironmentId();
    verify(instance).entityReference();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.customEnvironmentId().longValue());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage#fromJson(ImmutableCustomEnvironmentUsage.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Json json = new ImmutableCustomEnvironmentUsage.Json();
    json.setId(null);
    json.setCreatedAt(null);
    json.setCreatedBy("Json");
    json.setProvenance(null);
    json.setCustomEnvironmentId(1L);
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableCustomEnvironmentUsage actualFromJsonResult = ImmutableCustomEnvironmentUsage.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.customEnvironmentId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage#fromJson(ImmutableCustomEnvironmentUsage.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Json json = new ImmutableCustomEnvironmentUsage.Json();
    json.setId(null);
    json.setCreatedAt(null);
    json.setCreatedBy("Json");
    json.setProvenance("Json");
    json.setCustomEnvironmentId(1L);
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableCustomEnvironmentUsage actualFromJsonResult = ImmutableCustomEnvironmentUsage.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.customEnvironmentId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage#fromJson(ImmutableCustomEnvironmentUsage.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableCustomEnvironmentUsage.Json json = new ImmutableCustomEnvironmentUsage.Json();
    json.setId(null);
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setCreatedBy("Json");
    json.setProvenance(null);
    json.setCustomEnvironmentId(1L);
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableCustomEnvironmentUsage actualFromJsonResult = ImmutableCustomEnvironmentUsage.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.customEnvironmentId().longValue());
    LocalDateTime expectedCreatedAtResult = json.createdAt;
    assertSame(expectedCreatedAtResult, actualFromJsonResult.createdAt());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironmentUsage.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironmentUsage.Json()).createdAt());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironmentUsage.Json#createdBy()}
   */
  @Test
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironmentUsage.Json()).createdBy());
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Json#customEnvironmentId()}
   */
  @Test
  void testJsonCustomEnvironmentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableCustomEnvironmentUsage.Json()).customEnvironmentId());
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironmentUsage.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableCustomEnvironmentUsage.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironmentUsage.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironmentUsage.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCustomEnvironmentUsage.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableCustomEnvironmentUsage.Json actualJson = new ImmutableCustomEnvironmentUsage.Json();

    // Assert
    assertNull(actualJson.customEnvironmentId);
    assertNull(actualJson.createdBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironmentUsage.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironmentUsage.Json()).provenance());
  }
}
