package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NameHelperDiffblueTest {
  /**
   * Test {@link NameHelper#toName(EntityReference)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link EntityReference} {@link EntityReference#name()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  @DisplayName("Test toName(EntityReference); given empty; when EntityReference name() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NameHelper.toName(EntityReference)"})
  void testToName_givenEmpty_whenEntityReferenceNameReturnEmpty() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(ref.name()).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> NameHelper.toName(ref));
    verify(ref).name();
  }

  /**
   * Test {@link NameHelper#toName(EntityReference)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with {@code Reference %s, has no name!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  @DisplayName("Test toName(EntityReference); given IllegalStateException(String) with 'Reference %s, has no name!'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NameHelper.toName(EntityReference)"})
  void testToName_givenIllegalStateExceptionWithReferenceSHasNoName() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.name()).thenThrow(new IllegalStateException("Reference %s, has no name!"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> NameHelper.toName(ref));
    verify(ref).name();
  }

  /**
   * Test {@link NameHelper#toName(EntityReference)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  @DisplayName("Test toName(EntityReference); given Optional with 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NameHelper.toName(EntityReference)"})
  void testToName_givenOptionalWithFoo_thenReturnFoo() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(ref.name()).thenReturn(ofResult);

    // Act
    String actualToNameResult = NameHelper.toName(ref);

    // Assert
    verify(ref).name();
    assertEquals("foo", actualToNameResult);
  }
}
