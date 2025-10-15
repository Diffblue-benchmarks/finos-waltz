package org.finos.waltz.data.change_initiative;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChangeInitiativeIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory =
        new ChangeInitiativeIdSelectorFactory();

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

    // Act
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions2() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory =
        new ChangeInitiativeIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> changeInitiativeIdSelectorFactory.mkForOptions(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions3() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory =
        new ChangeInitiativeIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions4() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory =
        new ChangeInitiativeIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.AGGREGATE_OVERLAY_DIAGRAM)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> changeInitiativeIdSelectorFactory.mkForOptions(options));
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code
   *       CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given 'CHILDREN'; when IdSelectionOptions scope() return 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions_givenChildren_whenIdSelectionOptionsScopeReturnChildren() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory =
        new ChangeInitiativeIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#joiningEntityKind()} return
   *       empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given empty; when IdSelectionOptions joiningEntityKind() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions_givenEmpty_whenIdSelectionOptionsJoiningEntityKindReturnEmpty() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory =
        new ChangeInitiativeIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions_givenHashSetAddActive() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory =
        new ChangeInitiativeIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#joiningEntityKind()} return of
   *       {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given of 'ALL'; when IdSelectionOptions joiningEntityKind() return of 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"
  })
  void testMkForOptions_givenOfAll_whenIdSelectionOptionsJoiningEntityKindReturnOfAll() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory =
        new ChangeInitiativeIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }
}
