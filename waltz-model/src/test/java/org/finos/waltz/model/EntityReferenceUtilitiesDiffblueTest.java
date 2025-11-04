package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class EntityReferenceUtilitiesDiffblueTest {
  /**
   * Method under test: {@link EntityReferenceUtilities#pretty(EntityReference)}
   */
  @Test
  void testPretty() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(ref.name()).thenReturn(ofResult);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    String actualPrettyResult = EntityReferenceUtilities.pretty(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(ref).name();
    assertEquals("foo [ALL/1]", actualPrettyResult);
  }

  /**
   * Method under test: {@link EntityReferenceUtilities#safeName(EntityReference)}
   */
  @Test
  void testSafeName() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(ref.name()).thenReturn(ofResult);
    when(ref.id()).thenReturn(1L);

    // Act
    String actualSafeNameResult = EntityReferenceUtilities.safeName(ref);

    // Assert
    verify(ref).id();
    verify(ref).name();
    assertEquals("foo [1]", actualSafeNameResult);
  }

  /**
   * Method under test: {@link EntityReferenceUtilities#safeName(EntityReference)}
   */
  @Test
  void testSafeName2() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(ref.name()).thenReturn(emptyResult);
    when(ref.id()).thenReturn(1L);

    // Act
    String actualSafeNameResult = EntityReferenceUtilities.safeName(ref);

    // Assert
    verify(ref).id();
    verify(ref).name();
    assertEquals("[1]", actualSafeNameResult);
  }

  /**
   * Method under test:
   * {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  void testSameRef() {
    // Arrange
    Optional<EntityReference> refA = Optional.of(new ImmutableEntityReference.Json());

    // Act and Assert
    assertFalse(EntityReferenceUtilities.sameRef(refA, new ImmutableEntityReference.Json()));
  }

  /**
   * Method under test:
   * {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  void testSameRef2() {
    // Arrange
    Optional<EntityReference> refA = Optional.of(new ImmutableEntityReference.Json());

    // Act and Assert
    assertFalse(EntityReferenceUtilities.sameRef(refA, null));
  }

  /**
   * Method under test: {@link EntityReferenceUtilities#indexById(Collection)}
   */
  @Test
  void testIndexById() {
    // Arrange and Act
    Map<Long, EntityReference> actualIndexByIdResult = EntityReferenceUtilities.indexById(new ArrayList<>());

    // Assert
    assertTrue(actualIndexByIdResult.isEmpty());
  }
}
