package org.finos.waltz.model.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IdUtilitiesDiffblueTest {
  /**
   * Test {@link IdUtilities#toIds(Collection)}.
   * <ul>
   *   <li>Given {@link IdProvider} {@link IdProvider#id()} return {@link Optional} with one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#toIds(Collection)}
   */
  @Test
  @DisplayName("Test toIds(Collection); given IdProvider id() return Optional with one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set IdUtilities.toIds(Collection)"})
  void testToIds_givenIdProviderIdReturnOptionalWithOne_thenReturnSizeIsOne() {
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
   * Test {@link IdUtilities#toIds(Collection)}.
   * <ul>
   *   <li>Given {@link IdProvider} {@link IdProvider#id()} return {@link Optional} with one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#toIds(Collection)}
   */
  @Test
  @DisplayName("Test toIds(Collection); given IdProvider id() return Optional with one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set IdUtilities.toIds(Collection)"})
  void testToIds_givenIdProviderIdReturnOptionalWithOne_thenReturnSizeIsOne2() {
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
   * Test {@link IdUtilities#toIds(Collection)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#toIds(Collection)}
   */
  @Test
  @DisplayName("Test toIds(Collection); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set IdUtilities.toIds(Collection)"})
  void testToIds_thenThrowIllegalArgumentException() {
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
   * Test {@link IdUtilities#toIds(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#toIds(Collection)}
   */
  @Test
  @DisplayName("Test toIds(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set IdUtilities.toIds(Collection)"})
  void testToIds_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Set<Long> actualToIdsResult = IdUtilities.toIds(new ArrayList<>());

    // Assert
    assertTrue(actualToIdsResult.isEmpty());
  }

  /**
   * Test {@link IdUtilities#ensureHasId(IdProvider, String)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#ensureHasId(IdProvider, String)}
   */
  @Test
  @DisplayName("Test ensureHasId(IdProvider, String); given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long IdUtilities.ensureHasId(IdProvider, String)"})
  void testEnsureHasId_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(idProvider.id()).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IdUtilities.ensureHasId(idProvider, "Exception Message"));
    verify(idProvider).id();
  }

  /**
   * Test {@link IdUtilities#ensureHasId(IdProvider, String)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#ensureHasId(IdProvider, String)}
   */
  @Test
  @DisplayName("Test ensureHasId(IdProvider, String); given IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long IdUtilities.ensureHasId(IdProvider, String)"})
  void testEnsureHasId_givenIllegalArgumentExceptionWithFoo() {
    // Arrange
    IdProvider idProvider = mock(IdProvider.class);
    when(idProvider.id()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IdUtilities.ensureHasId(idProvider, "Exception Message"));
    verify(idProvider).id();
  }

  /**
   * Test {@link IdUtilities#ensureHasId(IdProvider, String)}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#ensureHasId(IdProvider, String)}
   */
  @Test
  @DisplayName("Test ensureHasId(IdProvider, String); given Optional with one; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long IdUtilities.ensureHasId(IdProvider, String)"})
  void testEnsureHasId_givenOptionalWithOne_thenReturnLongValueIsOne() {
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
   * Test {@link IdUtilities#indexByOptionalId(Collection)}.
   * <ul>
   *   <li>Given {@link IdProvider} {@link IdProvider#id()} return {@link Optional} with one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#indexByOptionalId(Collection)}
   */
  @Test
  @DisplayName("Test indexByOptionalId(Collection); given IdProvider id() return Optional with one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map IdUtilities.indexByOptionalId(Collection)"})
  void testIndexByOptionalId_givenIdProviderIdReturnOptionalWithOne_thenReturnSizeIsOne() {
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
   * Test {@link IdUtilities#indexByOptionalId(Collection)}.
   * <ul>
   *   <li>Given {@link IdProvider} {@link IdProvider#id()} return {@link Optional} with one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#indexByOptionalId(Collection)}
   */
  @Test
  @DisplayName("Test indexByOptionalId(Collection); given IdProvider id() return Optional with one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map IdUtilities.indexByOptionalId(Collection)"})
  void testIndexByOptionalId_givenIdProviderIdReturnOptionalWithOne_thenReturnSizeIsOne2() {
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
   * Test {@link IdUtilities#indexByOptionalId(Collection)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#indexByOptionalId(Collection)}
   */
  @Test
  @DisplayName("Test indexByOptionalId(Collection); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map IdUtilities.indexByOptionalId(Collection)"})
  void testIndexByOptionalId_thenThrowIllegalArgumentException() {
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
   * Test {@link IdUtilities#indexByOptionalId(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#indexByOptionalId(Collection)}
   */
  @Test
  @DisplayName("Test indexByOptionalId(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map IdUtilities.indexByOptionalId(Collection)"})
  void testIndexByOptionalId_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Map<Long, IdProvider> actualIndexByOptionalIdResult = IdUtilities.indexByOptionalId(new ArrayList<>());

    // Assert
    assertTrue(actualIndexByOptionalIdResult.isEmpty());
  }

  /**
   * Test {@link IdUtilities#indexById(Collection)}.
   * <ul>
   *   <li>Given {@link IdProvider} {@link IdProvider#id()} return {@link Optional} with one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#indexById(Collection)}
   */
  @Test
  @DisplayName("Test indexById(Collection); given IdProvider id() return Optional with one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map IdUtilities.indexById(Collection)"})
  void testIndexById_givenIdProviderIdReturnOptionalWithOne_thenReturnSizeIsOne() {
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
   * Test {@link IdUtilities#indexById(Collection)}.
   * <ul>
   *   <li>Given {@link IdProvider} {@link IdProvider#id()} return {@link Optional} with one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#indexById(Collection)}
   */
  @Test
  @DisplayName("Test indexById(Collection); given IdProvider id() return Optional with one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map IdUtilities.indexById(Collection)"})
  void testIndexById_givenIdProviderIdReturnOptionalWithOne_thenReturnSizeIsOne2() {
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
   * Test {@link IdUtilities#indexById(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#indexById(Collection)}
   */
  @Test
  @DisplayName("Test indexById(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map IdUtilities.indexById(Collection)"})
  void testIndexById_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Map<Long, IdProvider> actualIndexByIdResult = IdUtilities.indexById(new ArrayList<>());

    // Assert
    assertTrue(actualIndexByIdResult.isEmpty());
  }

  /**
   * Test {@link IdUtilities#getIdOrDefault(IdProvider, Long)}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#getIdOrDefault(IdProvider, Long)}
   */
  @Test
  @DisplayName("Test getIdOrDefault(IdProvider, Long); given Optional with one; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long IdUtilities.getIdOrDefault(IdProvider, Long)"})
  void testGetIdOrDefault_givenOptionalWithOne_thenReturnLongValueIsOne() {
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
   * Test {@link IdUtilities#getIdOrDefault(IdProvider, Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#getIdOrDefault(IdProvider, Long)}
   */
  @Test
  @DisplayName("Test getIdOrDefault(IdProvider, Long); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long IdUtilities.getIdOrDefault(IdProvider, Long)"})
  void testGetIdOrDefault_thenThrowIllegalArgumentException() {
    // Arrange
    IdProvider d = mock(IdProvider.class);
    when(d.id()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IdUtilities.getIdOrDefault(d, 42L));
    verify(d).id();
  }

  /**
   * Test {@link IdUtilities#getIdOrDefault(IdProvider, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdUtilities#getIdOrDefault(IdProvider, Long)}
   */
  @Test
  @DisplayName("Test getIdOrDefault(IdProvider, Long); when 'null'; then return longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long IdUtilities.getIdOrDefault(IdProvider, Long)"})
  void testGetIdOrDefault_whenNull_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, IdUtilities.getIdOrDefault(null, 42L).longValue());
  }
}
