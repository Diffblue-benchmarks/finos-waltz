package org.finos.waltz.data.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

class PhysicalSpecDefnIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link PhysicalSpecDefnIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalSpecDefnIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalSpecDefnIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions() {
    // Arrange
    PhysicalSpecDefnIdSelectorFactory physicalSpecDefnIdSelectorFactory =
        new PhysicalSpecDefnIdSelectorFactory();

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
            physicalSpecDefnIdSelectorFactory.apply(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link PhysicalSpecDefnIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalSpecDefnIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalSpecDefnIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions2() {
    // Arrange
    PhysicalSpecDefnIdSelectorFactory physicalSpecDefnIdSelectorFactory =
        new PhysicalSpecDefnIdSelectorFactory();

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
        () -> physicalSpecDefnIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link PhysicalSpecDefnIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefnIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalSpecDefnIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenUnsupportedOperationException() {
    // Arrange
    PhysicalSpecDefnIdSelectorFactory physicalSpecDefnIdSelectorFactory =
        new PhysicalSpecDefnIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecDefnIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }
}
