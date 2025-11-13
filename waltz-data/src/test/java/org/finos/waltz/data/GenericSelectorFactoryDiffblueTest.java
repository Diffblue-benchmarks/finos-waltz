package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GenericSelectorFactoryDiffblueTest {
  /**
   * Test {@link GenericSelectorFactory#apply(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.apply(IdSelectionOptions)"})
  void testApply() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyResult =
        genericSelectorFactory.apply(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.ALL, actualApplyResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#apply(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.apply(IdSelectionOptions)"})
  void testApply2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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

    // Act
    GenericSelector actualApplyResult =
        genericSelectorFactory.apply(
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.ALL, actualApplyResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#apply(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.apply(IdSelectionOptions)"})
  void testApply_thenThrowUnsupportedOperationException() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            genericSelectorFactory.apply(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.PARENTS)
                    .build()));
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return kind is {@code APPLICATION}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); then return kind is 'APPLICATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_thenReturnKindIsApplication() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'ALL'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenAll_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new GenericSelectorFactory().applyForKind(EntityKind.ALL, null));
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code APPLICATION}.
   *   <li>Then return kind is {@code APPLICATION}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'APPLICATION'; then return kind is 'APPLICATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenApplication_thenReturnKindIsApplication() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code APPLICATION}.
   *   <li>Then return kind is {@code APPLICATION}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'APPLICATION'; then return kind is 'APPLICATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenApplication_thenReturnKindIsApplication2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   *   <li>Then return kind is {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'; then return kind is 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenChangeInitiative_thenReturnKindIsChangeInitiative() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.CHANGE_INITIATIVE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   *   <li>Then return kind is {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'; then return kind is 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenChangeInitiative_thenReturnKindIsChangeInitiative2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.CHANGE_INITIATIVE,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   *   <li>Then return kind is {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'; then return kind is 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenChangeInitiative_thenReturnKindIsChangeInitiative3() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.CHANGE_INITIATIVE,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   *   <li>Then return kind is {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'; then return kind is 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenChangeUnit_thenReturnKindIsChangeUnit() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.CHANGE_UNIT,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_UNIT, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   *   <li>Then return kind is {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'; then return kind is 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenChangeUnit_thenReturnKindIsChangeUnit2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.CHANGE_UNIT,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_UNIT, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   *   <li>Then return kind is {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'; then return kind is 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenChangeUnit_thenReturnKindIsChangeUnit3() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.CHANGE_UNIT,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_UNIT, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code FLOW_DIAGRAM}.
   *   <li>Then return kind is {@code FLOW_DIAGRAM}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'FLOW_DIAGRAM'; then return kind is 'FLOW_DIAGRAM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenFlowDiagram_thenReturnKindIsFlowDiagram() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.FLOW_DIAGRAM,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.FLOW_DIAGRAM, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code LICENCE}.
   *   <li>Then return kind is {@code LICENCE}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'LICENCE'; then return kind is 'LICENCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenLicence_thenReturnKindIsLicence() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.LICENCE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.LICENCE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code LOGICAL_DATA_FLOW}.
   *   <li>Then return kind is {@code LOGICAL_DATA_FLOW}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'LOGICAL_DATA_FLOW'; then return kind is 'LOGICAL_DATA_FLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenLogicalDataFlow_thenReturnKindIsLogicalDataFlow() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.LOGICAL_DATA_FLOW,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.LOGICAL_DATA_FLOW, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code LOGICAL_DATA_FLOW}.
   *   <li>Then return kind is {@code LOGICAL_DATA_FLOW}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'LOGICAL_DATA_FLOW'; then return kind is 'LOGICAL_DATA_FLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenLogicalDataFlow_thenReturnKindIsLogicalDataFlow2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.LOGICAL_DATA_FLOW,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.LOGICAL_DATA_FLOW, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code LOGICAL_DATA_FLOW}.
   *   <li>Then return kind is {@code LOGICAL_DATA_FLOW}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); when 'LOGICAL_DATA_FLOW'; then return kind is 'LOGICAL_DATA_FLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_whenLogicalDataFlow_thenReturnKindIsLogicalDataFlow3() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(
            EntityKind.LOGICAL_DATA_FLOW,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.LOGICAL_DATA_FLOW, actualApplyForKindResult.kind());
  }
}
