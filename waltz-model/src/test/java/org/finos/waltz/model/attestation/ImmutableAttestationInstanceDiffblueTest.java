package org.finos.waltz.model.attestation;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableAttestationInstanceDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#attestationRunId(Long)}
   */
  @Test
  void testBuilderAttestationRunId() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestationRunId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#attestedBy(Optional)}
   */
  @Test
  void testBuilderAttestedBy() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    Optional<String> attestedBy = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.attestedBy(attestedBy));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  void testBuilderAttestedEntityKind() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAttestationInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAttestationInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#from(AttestationInstance)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.parentEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult2);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#from(AttestationInstance)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult3);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableAttestationInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
    ImmutableAttestationInstance buildResult = builderResult.build();
    assertEquals(1L, buildResult.attestationRunId().longValue());
    assertEquals(1L, buildResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#from(AttestationInstance)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult3);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableAttestationInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
    ImmutableAttestationInstance buildResult = builderResult.build();
    assertNull(buildResult.attestedEntityId());
    assertEquals(1L, buildResult.attestationRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#from(AttestationInstance)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult2);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableAttestationInstance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
    ImmutableAttestationInstance buildResult = builderResult.build();
    assertEquals(1L, buildResult.attestationRunId().longValue());
    assertEquals(1L, buildResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#from(AttestationInstance)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenThrow(new IllegalStateException("instance"));
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult2);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
  }

  /**
   * Method under test: {@link ImmutableAttestationInstance.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAttestationInstance.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Builder#parentEntity(EntityReference)}
   */
  @Test
  void testBuilderParentEntity() {
    // Arrange
    ImmutableAttestationInstance.Builder builderResult = ImmutableAttestationInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntity(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance#copyOf(AttestationInstance)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult3);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableAttestationInstance actualCopyOfResult = ImmutableAttestationInstance.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
    assertEquals(1L, actualCopyOfResult.attestationRunId().longValue());
    assertEquals(1L, actualCopyOfResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance#copyOf(AttestationInstance)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult2);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableAttestationInstance actualCopyOfResult = ImmutableAttestationInstance.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
    assertEquals(1L, actualCopyOfResult.attestationRunId().longValue());
    assertEquals(1L, actualCopyOfResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Json#attestationRunId()}
   */
  @Test
  void testJsonAttestationRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationInstance.Json()).attestationRunId());
  }

  /**
   * Method under test: {@link ImmutableAttestationInstance.Json#attestedAt()}
   */
  @Test
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationInstance.Json()).attestedAt());
  }

  /**
   * Method under test: {@link ImmutableAttestationInstance.Json#attestedBy()}
   */
  @Test
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationInstance.Json()).attestedBy());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Json#attestedEntityId()}
   */
  @Test
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationInstance.Json()).attestedEntityId());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstance.Json#attestedEntityKind()}
   */
  @Test
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationInstance.Json()).attestedEntityKind());
  }

  /**
   * Method under test: {@link ImmutableAttestationInstance.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationInstance.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttestationInstance.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttestationInstance.Json actualJson = new ImmutableAttestationInstance.Json();

    // Assert
    assertNull(actualJson.attestationRunId);
    assertNull(actualJson.attestedEntityId);
    assertNull(actualJson.attestedEntityKind);
    assertNull(actualJson.parentEntity);
    assertFalse(actualJson.attestedAt.isPresent());
    assertFalse(actualJson.attestedBy.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableAttestationInstance.Json#parentEntity()}
   */
  @Test
  void testJsonParentEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationInstance.Json()).parentEntity());
  }
}
