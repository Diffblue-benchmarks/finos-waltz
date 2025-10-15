package org.finos.waltz.data.change_set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableSelectionFilters.Builder;
import org.finos.waltz.model.application.ApplicationKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChangeSetIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select ChangeSetIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions() {
    // Arrange
    ChangeSetIdSelectorFactory changeSetIdSelectorFactory = new ChangeSetIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> changeSetIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select ChangeSetIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions2() {
    // Arrange
    ChangeSetIdSelectorFactory changeSetIdSelectorFactory = new ChangeSetIdSelectorFactory();

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> changeSetIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select ChangeSetIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions3() {
    // Arrange
    ChangeSetIdSelectorFactory changeSetIdSelectorFactory = new ChangeSetIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.CHANGE_INITIATIVE)
                .name("Name")
                .build());

    // Act
    changeSetIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select ChangeSetIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    ChangeSetIdSelectorFactory changeSetIdSelectorFactory = new ChangeSetIdSelectorFactory();

    Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
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
    changeSetIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
  }

  /**
   * Test {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given 'EXACT'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select ChangeSetIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenExact_thenCallsScope() {
    // Arrange
    ChangeSetIdSelectorFactory changeSetIdSelectorFactory = new ChangeSetIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    changeSetIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given 'EXACT'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select ChangeSetIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenExact_thenCallsScope2() {
    // Arrange
    ChangeSetIdSelectorFactory changeSetIdSelectorFactory = new ChangeSetIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    changeSetIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select ChangeSetIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddActive() {
    // Arrange
    ChangeSetIdSelectorFactory changeSetIdSelectorFactory = new ChangeSetIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    changeSetIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select ChangeSetIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddPending() {
    // Arrange
    ChangeSetIdSelectorFactory changeSetIdSelectorFactory = new ChangeSetIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    changeSetIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select ChangeSetIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_thenCallsEntityLifecycleStatuses() {
    // Arrange
    ChangeSetIdSelectorFactory changeSetIdSelectorFactory = new ChangeSetIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    changeSetIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }
}
