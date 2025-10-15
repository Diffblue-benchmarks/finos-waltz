package org.finos.waltz.data.attestation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttestationIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select AttestationIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions() {
    // Arrange
    AttestationIdSelectorFactory attestationIdSelectorFactory = new AttestationIdSelectorFactory();

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
        IllegalArgumentException.class,
        () ->
            attestationIdSelectorFactory.apply(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select AttestationIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions2() {
    // Arrange
    AttestationIdSelectorFactory attestationIdSelectorFactory = new AttestationIdSelectorFactory();

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
    assertThrows(IllegalArgumentException.class, () -> attestationIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select AttestationIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    AttestationIdSelectorFactory attestationIdSelectorFactory = new AttestationIdSelectorFactory();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
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
    attestationIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
  }

  /**
   * Test {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select AttestationIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddActive() {
    // Arrange
    AttestationIdSelectorFactory attestationIdSelectorFactory = new AttestationIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    attestationIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select AttestationIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddPending() {
    // Arrange
    AttestationIdSelectorFactory attestationIdSelectorFactory = new AttestationIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    attestationIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet(); then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select AttestationIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSet_thenCallsEntityLifecycleStatuses() {
    // Arrange
    AttestationIdSelectorFactory attestationIdSelectorFactory = new AttestationIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    attestationIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }
}
