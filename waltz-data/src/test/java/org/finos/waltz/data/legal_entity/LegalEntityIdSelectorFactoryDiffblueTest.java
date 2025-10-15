package org.finos.waltz.data.legal_entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LegalEntityIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            legalEntityIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions2() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> legalEntityIdSelectorFactory.mkForOptions(options));
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions3() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    legalEntityIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions_givenUnsupportedOperationException() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> legalEntityIdSelectorFactory.mkForOptions(options));
    verify(options).entityReference();
  }
}
