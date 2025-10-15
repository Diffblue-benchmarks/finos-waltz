package org.finos.waltz.data.orgunit;

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

class OrganisationalUnitIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory =
        new OrganisationalUnitIdSelectorFactory();

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
            organisationalUnitIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions2() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory =
        new OrganisationalUnitIdSelectorFactory();

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
        () -> organisationalUnitIdSelectorFactory.mkForOptions(options));
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions3() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory =
        new OrganisationalUnitIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> organisationalUnitIdSelectorFactory.mkForOptions(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code
   *       CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given 'CHILDREN'; when IdSelectionOptions scope() return 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions_givenChildren_whenIdSelectionOptionsScopeReturnChildren() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory =
        new OrganisationalUnitIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    organisationalUnitIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given 'EXACT'; when IdSelectionOptions scope() return 'EXACT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions_givenExact_whenIdSelectionOptionsScopeReturnExact() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory =
        new OrganisationalUnitIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    organisationalUnitIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PARENTS}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code
   *       PARENTS}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given 'PARENTS'; when IdSelectionOptions scope() return 'PARENTS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions_givenParents_whenIdSelectionOptionsScopeReturnParents() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory =
        new OrganisationalUnitIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    organisationalUnitIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Test {@link OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrganisationalUnitIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); when IdSelectionOptions scope() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select OrganisationalUnitIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions_whenIdSelectionOptionsScopeThrowUnsupportedOperationException() {
    // Arrange
    OrganisationalUnitIdSelectorFactory organisationalUnitIdSelectorFactory =
        new OrganisationalUnitIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenThrow(new UnsupportedOperationException());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> organisationalUnitIdSelectorFactory.mkForOptions(options));
    verify(options).entityReference();
    verify(options).scope();
  }
}
