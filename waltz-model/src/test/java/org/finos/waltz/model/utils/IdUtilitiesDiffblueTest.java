package org.finos.waltz.model.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class IdUtilitiesDiffblueTest {
  /**
   * Method under test: {@link IdUtilities#toIds(Collection)}
   */
  @Test
  void testToIds() {
    // Arrange and Act
    Set<Long> actualToIdsResult = IdUtilities.toIds(new ArrayList<>());

    // Assert
    assertTrue(actualToIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link IdUtilities#toIds(Collection)}
   */
  @Test
  void testToIds2() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(idProvider.id()).thenReturn(ofResult);

    ArrayList<IdProvider> xs = new ArrayList<>();
    xs.add(idProvider);

    // Act
    Set<Long> actualToIdsResult = IdUtilities.toIds(xs);

    // Assert
    verify(idProvider).id();
    assertEquals(1, actualToIdsResult.size());
    assertTrue(actualToIdsResult.contains(1L));
  }

  /**
   * Method under test: {@link IdUtilities#toIds(Collection)}
   */
  @Test
  void testToIds3() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(idProvider.id()).thenReturn(ofResult);
    IdProvider idProvider2 = mock(IdProvider.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(idProvider2.id()).thenReturn(ofResult2);

    ArrayList<IdProvider> xs = new ArrayList<>();
    xs.add(idProvider2);
    xs.add(idProvider);

    // Act
    Set<Long> actualToIdsResult = IdUtilities.toIds(xs);

    // Assert
    verify(idProvider2).id();
    verify(idProvider).id();
    assertEquals(1, actualToIdsResult.size());
    assertTrue(actualToIdsResult.contains(1L));
  }

  /**
   * Method under test: {@link IdUtilities#toIds(Collection)}
   */
  @Test
  void testToIds4() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(idProvider.id()).thenReturn(ofResult);
    IdProvider idProvider2 = mock(IdProvider.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(idProvider2.id()).thenReturn(ofResult2);
    IdProvider idProvider3 = mock(IdProvider.class);
    when(idProvider3.id()).thenThrow(new IllegalArgumentException("Cannot convert a null collection to a set of ids"));

    ArrayList<IdProvider> xs = new ArrayList<>();
    xs.add(idProvider3);
    xs.add(idProvider2);
    xs.add(idProvider);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IdUtilities.toIds(xs));
    verify(idProvider3).id();
  }

  /**
   * Method under test: {@link IdUtilities#ensureHasId(IdProvider, String)}
   */
  @Test
  void testEnsureHasId() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(idProvider.id()).thenReturn(ofResult);

    // Act
    Long actualEnsureHasIdResult = IdUtilities.ensureHasId(idProvider, "Exception Message");

    // Assert
    verify(idProvider).id();
    assertEquals(1L, actualEnsureHasIdResult.longValue());
  }

  /**
   * Method under test: {@link IdUtilities#ensureHasId(IdProvider, String)}
   */
  @Test
  void testEnsureHasId2() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(idProvider.id()).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IdUtilities.ensureHasId(idProvider, "Exception Message"));
    verify(idProvider).id();
  }

  /**
   * Method under test: {@link IdUtilities#ensureHasId(IdProvider, String)}
   */
  @Test
  void testEnsureHasId3() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    when(idProvider.id()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IdUtilities.ensureHasId(idProvider, "Exception Message"));
    verify(idProvider).id();
  }

  /**
   * Method under test: {@link IdUtilities#indexByOptionalId(Collection)}
   */
  @Test
  void testIndexByOptionalId() {
    // Arrange and Act
    Map<Long, IdProvider> actualIndexByOptionalIdResult = IdUtilities.indexByOptionalId(new ArrayList<>());

    // Assert
    assertTrue(actualIndexByOptionalIdResult.isEmpty());
  }

  /**
   * Method under test: {@link IdUtilities#indexByOptionalId(Collection)}
   */
  @Test
  void testIndexByOptionalId2() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(idProvider.id()).thenReturn(ofResult);

    ArrayList<IdProvider> ts = new ArrayList<>();
    ts.add(idProvider);

    // Act
    Map<Long, IdProvider> actualIndexByOptionalIdResult = IdUtilities.indexByOptionalId(ts);

    // Assert
    verify(idProvider).id();
    assertEquals(1, actualIndexByOptionalIdResult.size());
    assertTrue(actualIndexByOptionalIdResult.containsKey(1L));
  }

  /**
   * Method under test: {@link IdUtilities#indexByOptionalId(Collection)}
   */
  @Test
  void testIndexByOptionalId3() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(idProvider.id()).thenReturn(ofResult);
    IdProvider idProvider2 = mock(IdProvider.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(idProvider2.id()).thenReturn(ofResult2);

    ArrayList<IdProvider> ts = new ArrayList<>();
    ts.add(idProvider2);
    ts.add(idProvider);

    // Act
    Map<Long, IdProvider> actualIndexByOptionalIdResult = IdUtilities.indexByOptionalId(ts);

    // Assert
    verify(idProvider2).id();
    verify(idProvider).id();
    assertEquals(1, actualIndexByOptionalIdResult.size());
    assertTrue(actualIndexByOptionalIdResult.containsKey(1L));
  }

  /**
   * Method under test: {@link IdUtilities#indexByOptionalId(Collection)}
   */
  @Test
  void testIndexByOptionalId4() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(idProvider.id()).thenReturn(ofResult);
    IdProvider idProvider2 = mock(IdProvider.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(idProvider2.id()).thenReturn(ofResult2);
    IdProvider idProvider3 = mock(IdProvider.class);
    when(idProvider3.id()).thenThrow(new IllegalArgumentException("xs cannot be null"));

    ArrayList<IdProvider> ts = new ArrayList<>();
    ts.add(idProvider3);
    ts.add(idProvider2);
    ts.add(idProvider);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IdUtilities.indexByOptionalId(ts));
    verify(idProvider3).id();
  }

  /**
   * Method under test: {@link IdUtilities#indexById(Collection)}
   */
  @Test
  void testIndexById() {
    // Arrange and Act
    Map<Long, IdProvider> actualIndexByIdResult = IdUtilities.indexById(new ArrayList<>());

    // Assert
    assertTrue(actualIndexByIdResult.isEmpty());
  }

  /**
   * Method under test: {@link IdUtilities#indexById(Collection)}
   */
  @Test
  void testIndexById2() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(idProvider.id()).thenReturn(ofResult);

    ArrayList<IdProvider> ts = new ArrayList<>();
    ts.add(idProvider);

    // Act
    Map<Long, IdProvider> actualIndexByIdResult = IdUtilities.indexById(ts);

    // Assert
    verify(idProvider).id();
    assertEquals(1, actualIndexByIdResult.size());
    assertTrue(actualIndexByIdResult.containsKey(1L));
  }

  /**
   * Method under test: {@link IdUtilities#indexById(Collection)}
   */
  @Test
  void testIndexById3() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(idProvider.id()).thenReturn(ofResult);
    IdProvider idProvider2 = mock(IdProvider.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(idProvider2.id()).thenReturn(ofResult2);

    ArrayList<IdProvider> ts = new ArrayList<>();
    ts.add(idProvider2);
    ts.add(idProvider);

    // Act
    Map<Long, IdProvider> actualIndexByIdResult = IdUtilities.indexById(ts);

    // Assert
    verify(idProvider2).id();
    verify(idProvider).id();
    assertEquals(1, actualIndexByIdResult.size());
    assertTrue(actualIndexByIdResult.containsKey(1L));
  }

  /**
   * Method under test: {@link IdUtilities#getIdOrDefault(IdProvider, Long)}
   */
  @Test
  void testGetIdOrDefault() {
    // Arrange, Act and Assert
    assertEquals(42L, IdUtilities.getIdOrDefault(null, 42L).longValue());
  }

  /**
   * Method under test: {@link IdUtilities#getIdOrDefault(IdProvider, Long)}
   */
  @Test
  void testGetIdOrDefault2() {
    // Arrange
    IdProvider d = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(d.id()).thenReturn(ofResult);

    // Act
    Long actualIdOrDefault = IdUtilities.getIdOrDefault(d, 42L);

    // Assert
    verify(d).id();
    assertEquals(1L, actualIdOrDefault.longValue());
  }

  /**
   * Method under test: {@link IdUtilities#getIdOrDefault(IdProvider, Long)}
   */
  @Test
  void testGetIdOrDefault3() {
    // Arrange
    IdProvider d = mock(IdProvider.class);
    when(d.id()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IdUtilities.getIdOrDefault(d, 42L));
    verify(d).id();
  }
}
