package org.finos.waltz.data.person;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PersonIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link PersonIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <p>
   * Method under test: {@link PersonIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PersonIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions() {
    // Arrange
    PersonIdSelectorFactory personIdSelectorFactory = new PersonIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("foo"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> personIdSelectorFactory.mkForOptions(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link PersonIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   *   <li>Then calls {@link EntityReference#kind()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'ALL'; then calls kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PersonIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnAll_thenCallsKind() {
    // Arrange
    PersonIdSelectorFactory personIdSelectorFactory = new PersonIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> personIdSelectorFactory.mkForOptions(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link PersonIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given UnsupportedOperationException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PersonIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenUnsupportedOperationExceptionWithFoo() {
    // Arrange
    PersonIdSelectorFactory personIdSelectorFactory = new PersonIdSelectorFactory();
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> personIdSelectorFactory.mkForOptions(options));
    verify(options).entityReference();
  }
}
