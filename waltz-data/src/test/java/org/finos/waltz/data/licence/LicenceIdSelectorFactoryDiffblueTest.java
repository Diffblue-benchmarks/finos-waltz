package org.finos.waltz.data.licence;

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

class LicenceIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions2() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EXACT; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenExact_thenCallsScope() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EXACT; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenExact_thenCallsScope2() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenHashSetAddActive() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenHashSetAddPending() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_thenThrowUnsupportedOperationException() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
        UnsupportedOperationException.class, () -> licenceIdSelectorFactory.mkForOptions(options));
    verify(options, atLeast(1)).entityReference();
  }
}
