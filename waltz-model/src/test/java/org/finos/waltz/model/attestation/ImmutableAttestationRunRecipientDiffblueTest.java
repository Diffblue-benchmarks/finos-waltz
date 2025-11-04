package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunRecipientDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#completedCount(long)}
   */
  @Test
  void testBuilderCompletedCount() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completedCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAttestationRunRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAttestationRunRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#from(AttestationRunRecipient)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();
    AttestationRunRecipient instance = mock(AttestationRunRecipient.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.userId()).thenReturn("42");
    when(instance.completedCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableAttestationRunRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).completedCount();
    verify(instance).pendingCount();
    verify(instance).totalCount();
    verify(instance).userId();
    ImmutableAttestationRunRecipient buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(3L, buildResult.completedCount());
    assertEquals(3L, buildResult.pendingCount());
    assertEquals(3L, buildResult.totalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#from(AttestationRunRecipient)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();
    AttestationRunRecipient instance = mock(AttestationRunRecipient.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");
    when(instance.completedCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).completedCount();
    verify(instance).pendingCount();
    verify(instance).totalCount();
    verify(instance).userId();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#from(AttestationRunRecipient)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();
    AttestationRunRecipient instance = mock(AttestationRunRecipient.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.userId()).thenReturn("42");
    when(instance.completedCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableAttestationRunRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).completedCount();
    verify(instance).pendingCount();
    verify(instance).totalCount();
    verify(instance).userId();
    ImmutableAttestationRunRecipient buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(3L, buildResult.completedCount());
    assertEquals(3L, buildResult.pendingCount());
    assertEquals(3L, buildResult.totalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRunRecipient.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#pendingCount(long)}
   */
  @Test
  void testBuilderPendingCount() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.pendingCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#totalCount(long)}
   */
  @Test
  void testBuilderTotalCount() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.totalCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableAttestationRunRecipient.Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient#copyOf(AttestationRunRecipient)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationRunRecipient instance = mock(AttestationRunRecipient.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.userId()).thenReturn("42");
    when(instance.completedCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableAttestationRunRecipient actualCopyOfResult = ImmutableAttestationRunRecipient.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).completedCount();
    verify(instance).pendingCount();
    verify(instance).totalCount();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(3L, actualCopyOfResult.completedCount());
    assertEquals(3L, actualCopyOfResult.pendingCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient#copyOf(AttestationRunRecipient)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AttestationRunRecipient instance = mock(AttestationRunRecipient.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.userId()).thenReturn("42");
    when(instance.completedCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.totalCount()).thenReturn(3L);

    // Act
    ImmutableAttestationRunRecipient actualCopyOfResult = ImmutableAttestationRunRecipient.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).completedCount();
    verify(instance).pendingCount();
    verify(instance).totalCount();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(3L, actualCopyOfResult.completedCount());
    assertEquals(3L, actualCopyOfResult.pendingCount());
    assertEquals(3L, actualCopyOfResult.totalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Json#completedCount()}
   */
  @Test
  void testJsonCompletedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunRecipient.Json()).completedCount());
  }

  /**
   * Method under test: {@link ImmutableAttestationRunRecipient.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRunRecipient.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttestationRunRecipient.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttestationRunRecipient.Json actualJson = new ImmutableAttestationRunRecipient.Json();

    // Assert
    assertNull(actualJson.userId);
    assertEquals(0L, actualJson.completedCount);
    assertEquals(0L, actualJson.pendingCount);
    assertEquals(0L, actualJson.totalCount);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.completedCountIsSet);
    assertFalse(actualJson.pendingCountIsSet);
    assertFalse(actualJson.totalCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Json#pendingCount()}
   */
  @Test
  void testJsonPendingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunRecipient.Json()).pendingCount());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Json#setCompletedCount(long)}
   */
  @Test
  void testJsonSetCompletedCount() {
    // Arrange
    ImmutableAttestationRunRecipient.Json json = new ImmutableAttestationRunRecipient.Json();

    // Act
    json.setCompletedCount(3L);

    // Assert
    assertEquals(3L, json.completedCount);
    assertTrue(json.completedCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Json#setPendingCount(long)}
   */
  @Test
  void testJsonSetPendingCount() {
    // Arrange
    ImmutableAttestationRunRecipient.Json json = new ImmutableAttestationRunRecipient.Json();

    // Act
    json.setPendingCount(3L);

    // Assert
    assertEquals(3L, json.pendingCount);
    assertTrue(json.pendingCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunRecipient.Json#setTotalCount(long)}
   */
  @Test
  void testJsonSetTotalCount() {
    // Arrange
    ImmutableAttestationRunRecipient.Json json = new ImmutableAttestationRunRecipient.Json();

    // Act
    json.setTotalCount(3L);

    // Assert
    assertEquals(3L, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableAttestationRunRecipient.Json#totalCount()}
   */
  @Test
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRunRecipient.Json()).totalCount());
  }

  /**
   * Method under test: {@link ImmutableAttestationRunRecipient.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRunRecipient.Json()).userId());
  }
}
