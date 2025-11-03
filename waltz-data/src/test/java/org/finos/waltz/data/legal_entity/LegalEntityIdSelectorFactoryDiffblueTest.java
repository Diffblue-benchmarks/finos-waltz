package org.finos.waltz.data.legal_entity;

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

class LegalEntityIdSelectorFactoryDiffblueTest {
  /**
   * Test new {@link LegalEntityIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link LegalEntityIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new LegalEntityIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LegalEntityIdSelectorFactory.<init>()"})
  void testNewLegalEntityIdSelectorFactory_thenCallsId() {
    // Arrange and Act
    LegalEntityIdSelectorFactory actualLegalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    actualLegalEntityIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <p>
   * Method under test: {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LegalEntityIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("foo"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> legalEntityIdSelectorFactory.mkForOptions(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#id()} return one.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference id() return one; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LegalEntityIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceIdReturnOne_thenCallsId() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    legalEntityIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#id()} throw {@link UnsupportedOperationException#UnsupportedOperationException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference id() throw UnsupportedOperationException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LegalEntityIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceIdThrowUnsupportedOperationExceptionWithFoo() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("foo"));
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> legalEntityIdSelectorFactory.mkForOptions(options));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LegalEntityIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnAll() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> legalEntityIdSelectorFactory.mkForOptions(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }
}
