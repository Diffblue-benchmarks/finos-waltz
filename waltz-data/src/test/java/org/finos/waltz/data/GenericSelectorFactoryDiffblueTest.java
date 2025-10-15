package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@link
   *       HierarchyQueryScope#EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions); given EXACT; when IdSelectionOptions scope() return EXACT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.apply(IdSelectionOptions)"})
  void testApply_givenExact_whenIdSelectionOptionsScopeReturnExact() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyResult = genericSelectorFactory.apply(selectionOptions);

    // Assert
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualApplyResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.ALL, actualApplyResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#apply(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PARENTS}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions); given 'PARENTS'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.apply(IdSelectionOptions)"})
  void testApply_givenParents_thenThrowUnsupportedOperationException() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference())
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
        UnsupportedOperationException.class, () -> genericSelectorFactory.apply(selectionOptions));
    verify(selectionOptions).entityReference();
    verify(selectionOptions).scope();
  }

  /**
   * Test {@link GenericSelectorFactory#apply(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions); given UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.apply(IdSelectionOptions)"})
  void testApply_givenUnsupportedOperationException() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenThrow(new UnsupportedOperationException());
    when(selectionOptions.entityReference())
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
        UnsupportedOperationException.class, () -> genericSelectorFactory.apply(selectionOptions));
    verify(selectionOptions).entityReference();
    verify(selectionOptions).scope();
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind3() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind4() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind5() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind6() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(immutableSelectionFilters);
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code
   *       CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); given 'CHILDREN'; when IdSelectionOptions scope() return 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_givenChildren_whenIdSelectionOptionsScopeReturnChildren() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#joiningEntityKind()} return
   *       empty.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); given empty; when IdSelectionOptions joiningEntityKind() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_givenEmpty_whenIdSelectionOptionsJoiningEntityKindReturnEmpty() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(selectionOptions.joiningEntityKind()).thenReturn(emptyResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_givenHashSetAddActive() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_givenHashSetAddActive2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#joiningEntityKind()} return of
   *       {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); given of 'ALL'; when IdSelectionOptions joiningEntityKind() return of 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_givenOfAll_whenIdSelectionOptionsJoiningEntityKindReturnOfAll() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return kind is {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); then return kind is 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_thenReturnKindIsChangeUnit() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_UNIT, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return kind is {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test applyForKind(EntityKind, IdSelectionOptions); then return kind is 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"
  })
  void testApplyForKind_thenReturnKindIsChangeUnit2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
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
    GenericSelector actualApplyForKindResult =
        genericSelectorFactory.applyForKind(EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_UNIT, actualApplyForKindResult.kind());
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
        () ->
            new GenericSelectorFactory()
                .applyForKind(EntityKind.ALL, mock(IdSelectionOptions.class)));
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
}
