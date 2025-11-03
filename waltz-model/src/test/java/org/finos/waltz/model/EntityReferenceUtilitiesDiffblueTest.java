package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.model.ImmutableEntityReference.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityReferenceUtilitiesDiffblueTest {
  /**
   * Test {@link EntityReferenceUtilities#pretty(EntityReference)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link EntityReference} {@link EntityReference#id()} return one.</li>
   *   <li>Then return {@code foo [ALL/1]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityReferenceUtilities#pretty(EntityReference)}
   */
  @Test
  @DisplayName("Test pretty(EntityReference); given one; when EntityReference id() return one; then return 'foo [ALL/1]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityReferenceUtilities.pretty(EntityReference)"})
  void testPretty_givenOne_whenEntityReferenceIdReturnOne_thenReturnFooAll1() {
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
   * Test {@link EntityReferenceUtilities#safeName(EntityReference)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link EntityReference} {@link EntityReference#name()} return empty.</li>
   *   <li>Then return {@code [1]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityReferenceUtilities#safeName(EntityReference)}
   */
  @Test
  @DisplayName("Test safeName(EntityReference); given empty; when EntityReference name() return empty; then return '[1]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityReferenceUtilities.safeName(EntityReference)"})
  void testSafeName_givenEmpty_whenEntityReferenceNameReturnEmpty_thenReturn1() {
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
   * Test {@link EntityReferenceUtilities#safeName(EntityReference)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then return {@code foo [1]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityReferenceUtilities#safeName(EntityReference)}
   */
  @Test
  @DisplayName("Test safeName(EntityReference); given Optional with 'foo'; then return 'foo [1]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityReferenceUtilities.safeName(EntityReference)"})
  void testSafeName_givenOptionalWithFoo_thenReturnFoo1() {
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
   * Test {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}.
   * <ul>
   *   <li>When {@link Optional} with {@link Json} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  @DisplayName("Test sameRef(Optional, EntityReference); when Optional with Json (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityReferenceUtilities.sameRef(Optional, EntityReference)"})
  void testSameRef_whenOptionalWithJson_thenReturnFalse() {
    // Arrange
    Optional<EntityReference> refA = Optional.of(new Json());

    // Act and Assert
    assertFalse(EntityReferenceUtilities.sameRef(refA, new Json()));
  }

  /**
   * Test {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}.
   * <ul>
   *   <li>When {@link Optional} with {@link Json} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityReferenceUtilities#sameRef(Optional, EntityReference)}
   */
  @Test
  @DisplayName("Test sameRef(Optional, EntityReference); when Optional with Json (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityReferenceUtilities.sameRef(Optional, EntityReference)"})
  void testSameRef_whenOptionalWithJson_thenReturnFalse2() {
    // Arrange
    Optional<EntityReference> refA = Optional.of(new Json());

    // Act and Assert
    assertFalse(EntityReferenceUtilities.sameRef(refA, null));
  }

  /**
   * Test {@link EntityReferenceUtilities#indexById(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityReferenceUtilities#indexById(Collection)}
   */
  @Test
  @DisplayName("Test indexById(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map EntityReferenceUtilities.indexById(Collection)"})
  void testIndexById_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Map<Long, EntityReference> actualIndexByIdResult = EntityReferenceUtilities.indexById(new ArrayList<>());

    // Assert
    assertTrue(actualIndexByIdResult.isEmpty());
  }
}
