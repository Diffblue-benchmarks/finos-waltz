package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NameHelperDiffblueTest {
  /**
   * Test {@link NameHelper#toName(EntityReference)}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link EntityReference} {@link EntityReference#name()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test toName(EntityReference); given empty; when EntityReference name() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  @DisplayName("Test toName(EntityReference); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NameHelper.toName(EntityReference)"})
  void testToName_givenIllegalStateException() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> NameHelper.toName(ref));
    verify(ref).name();
  }

  /**
   * Test {@link NameHelper#toName(EntityReference)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link EntityReference} {@link EntityReference#name()} return of {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test toName(EntityReference); given of 'foo'; when EntityReference name() return of 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NameHelper.toName(EntityReference)"})
  void testToName_givenOfFoo_whenEntityReferenceNameReturnOfFoo_thenReturnFoo() {
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

  /**
   * Test {@link NameHelper#toName(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  @DisplayName("Test toName(EntityReference); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NameHelper.toName(EntityReference)"})
  void testToName_thenReturnName() {
    // Arrange
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals("Name", NameHelper.toName(ref));
  }
}
