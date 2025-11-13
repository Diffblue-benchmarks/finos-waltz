package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.assessment_rating.ImmutableSummaryCountRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSummaryCountRequestDiffblueTest {
  /**
   * Test Builder {@link ImmutableSummaryCountRequest.Builder#addAllDefinitionIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSummaryCountRequest.Builder#addAllDefinitionIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllDefinitionIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest.Builder ImmutableSummaryCountRequest.Builder.addAllDefinitionIds(Iterable)"
  })
  void testBuilderAddAllDefinitionIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSummaryCountRequest.Builder actualAddAllDefinitionIdsResult =
        builderResult.addAllDefinitionIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllDefinitionIdsResult);
  }

  /**
   * Test Builder {@link ImmutableSummaryCountRequest.Builder#addAllDefinitionIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSummaryCountRequest.Builder#addAllDefinitionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDefinitionIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest.Builder ImmutableSummaryCountRequest.Builder.addAllDefinitionIds(Iterable)"
  })
  void testBuilderAddAllDefinitionIds_whenArrayList() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act
    ImmutableSummaryCountRequest.Builder actualAddAllDefinitionIdsResult =
        builderResult.addAllDefinitionIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDefinitionIdsResult);
  }

  /**
   * Test Builder {@link ImmutableSummaryCountRequest.Builder#addDefinitionIds(long)} with {@code
   * element}.
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest.Builder#addDefinitionIds(long)}
   */
  @Test
  @DisplayName("Test Builder addDefinitionIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest.Builder ImmutableSummaryCountRequest.Builder.addDefinitionIds(long)"
  })
  void testBuilderAddDefinitionIdsWithElement() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act
    ImmutableSummaryCountRequest.Builder actualAddDefinitionIdsResult =
        builderResult.addDefinitionIds(1L);

    // Assert
    assertSame(builderResult, actualAddDefinitionIdsResult);
  }

  /**
   * Test Builder {@link ImmutableSummaryCountRequest.Builder#addDefinitionIds(long[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest.Builder#addDefinitionIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addDefinitionIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest.Builder ImmutableSummaryCountRequest.Builder.addDefinitionIds(long[])"
  })
  void testBuilderAddDefinitionIdsWithElements() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act
    ImmutableSummaryCountRequest.Builder actualAddDefinitionIdsResult =
        builderResult.addDefinitionIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddDefinitionIdsResult);
  }

  /**
   * Test Builder {@link ImmutableSummaryCountRequest.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSummaryCountRequest ImmutableSummaryCountRequest.Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSummaryCountRequest.Builder actualBuilderResult =
        ImmutableSummaryCountRequest.builder();
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableSummaryCountRequest actualImmutableSummaryCountRequest =
        actualBuilderResult.idSelectionOptions(idSelectionOptions).build();

    // Assert
    assertTrue(actualImmutableSummaryCountRequest.definitionIds().isEmpty());
    assertSame(idSelectionOptions, actualImmutableSummaryCountRequest.idSelectionOptions());
  }

  /**
   * Test Builder {@link ImmutableSummaryCountRequest.Builder#definitionIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest.Builder#definitionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder definitionIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest.Builder ImmutableSummaryCountRequest.Builder.definitionIds(Iterable)"
  })
  void testBuilderDefinitionIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSummaryCountRequest.Builder actualDefinitionIdsResult =
        builderResult.definitionIds(elements);

    // Assert
    assertSame(builderResult, actualDefinitionIdsResult);
  }

  /**
   * Test Builder {@link ImmutableSummaryCountRequest.Builder#definitionIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest.Builder#definitionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder definitionIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest.Builder ImmutableSummaryCountRequest.Builder.definitionIds(Iterable)"
  })
  void testBuilderDefinitionIds_whenArrayList() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act
    ImmutableSummaryCountRequest.Builder actualDefinitionIdsResult =
        builderResult.definitionIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDefinitionIdsResult);
  }

  /**
   * Test Builder {@link ImmutableSummaryCountRequest.Builder#from(SummaryCountRequest)}.
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest.Builder#from(SummaryCountRequest)}
   */
  @Test
  @DisplayName("Test Builder from(SummaryCountRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest.Builder ImmutableSummaryCountRequest.Builder.from(SummaryCountRequest)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    ImmutableSummaryCountRequest.Builder builderResult2 = ImmutableSummaryCountRequest.builder();

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    ImmutableSummaryCountRequest immutableSummaryCountRequest =
        builderResult
            .from(
                builderResult2
                    .idSelectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build())
            .build();
    IdSelectionOptions idSelectionOptionsResult = immutableSummaryCountRequest.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(immutableSummaryCountRequest.definitionIds().isEmpty());
  }

  /**
   * Test Builder {@link ImmutableSummaryCountRequest.Builder#from(SummaryCountRequest)}.
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest.Builder#from(SummaryCountRequest)}
   */
  @Test
  @DisplayName("Test Builder from(SummaryCountRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest.Builder ImmutableSummaryCountRequest.Builder.from(SummaryCountRequest)"
  })
  void testBuilderFrom2() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    ImmutableSummaryCountRequest.Builder builderResult2 = ImmutableSummaryCountRequest.builder();
    builderResult2.addDefinitionIds(-2L);

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSummaryCountRequest instance =
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableSummaryCountRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSummaryCountRequest actualImmutableSummaryCountRequest = builderResult.build();
    assertEquals(instance, actualImmutableSummaryCountRequest);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableSummaryCountRequest.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableSummaryCountRequest.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder idSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest.Builder ImmutableSummaryCountRequest.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableSummaryCountRequest.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(idSelectionOptions);

    // Assert
    assertSame(idSelectionOptions, builderResult.build().idSelectionOptions());
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#copyOf(SummaryCountRequest)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#copyOf(SummaryCountRequest)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SummaryCountRequest); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest ImmutableSummaryCountRequest.copyOf(SummaryCountRequest)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSummaryCountRequest instance =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableSummaryCountRequest actualCopyOfResult = ImmutableSummaryCountRequest.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult = actualCopyOfResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualCopyOfResult.definitionIds().isEmpty());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#equals(Object)}, and {@link
   * ImmutableSummaryCountRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSummaryCountRequest#equals(Object)}
   *   <li>{@link ImmutableSummaryCountRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSummaryCountRequest.equals(Object)",
    "int ImmutableSummaryCountRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSummaryCountRequest immutableSummaryCountRequest =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableSummaryCountRequest.Builder builderResult3 = ImmutableSummaryCountRequest.builder();

    Builder builderResult4 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult4
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);
    ImmutableSummaryCountRequest immutableSummaryCountRequest2 =
        builderResult3
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSummaryCountRequest, immutableSummaryCountRequest2);
    assertEquals(immutableSummaryCountRequest.hashCode(), immutableSummaryCountRequest2.hashCode());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#equals(Object)}, and {@link
   * ImmutableSummaryCountRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSummaryCountRequest#equals(Object)}
   *   <li>{@link ImmutableSummaryCountRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSummaryCountRequest.equals(Object)",
    "int ImmutableSummaryCountRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSummaryCountRequest immutableSummaryCountRequest =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSummaryCountRequest, immutableSummaryCountRequest);
    int expectedHashCodeResult = immutableSummaryCountRequest.hashCode();
    assertEquals(expectedHashCodeResult, immutableSummaryCountRequest.hashCode());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSummaryCountRequest.equals(Object)",
    "int ImmutableSummaryCountRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();
    builderResult.addDefinitionIds(1L);

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSummaryCountRequest immutableSummaryCountRequest =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableSummaryCountRequest.Builder builderResult3 = ImmutableSummaryCountRequest.builder();

    Builder builderResult4 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult4
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableSummaryCountRequest,
        builderResult3
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSummaryCountRequest.equals(Object)",
    "int ImmutableSummaryCountRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSummaryCountRequest immutableSummaryCountRequest =
        ImmutableSummaryCountRequest.builder()
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableSummaryCountRequest.Builder builderResult2 = ImmutableSummaryCountRequest.builder();

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableSummaryCountRequest,
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSummaryCountRequest.equals(Object)",
    "int ImmutableSummaryCountRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSummaryCountRequest.equals(Object)",
    "int ImmutableSummaryCountRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        "Different type to ImmutableSummaryCountRequest");
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) DefinitionIds is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) DefinitionIds is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSummaryCountRequest ImmutableSummaryCountRequest.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonDefinitionIdsIsHashSet() {
    // Arrange
    Json json = new Json();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setDefinitionIds(new HashSet<>());

    // Act
    ImmutableSummaryCountRequest actualFromJsonResult = ImmutableSummaryCountRequest.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.definitionIds().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add one.
   *   <li>Then return definitionIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add one; then return definitionIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSummaryCountRequest ImmutableSummaryCountRequest.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddOne_thenReturnDefinitionIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> definitionIds = new LinkedHashSet<>();
    definitionIds.add(1L);

    Json json = new Json();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setDefinitionIds(definitionIds);

    // Act
    ImmutableSummaryCountRequest actualFromJsonResult = ImmutableSummaryCountRequest.fromJson(json);

    // Assert
    Set<Long> definitionIdsResult = actualFromJsonResult.definitionIds();
    assertEquals(1, definitionIdsResult.size());
    assertTrue(definitionIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return definitionIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return definitionIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSummaryCountRequest ImmutableSummaryCountRequest.fromJson(Json)"})
  void testFromJson_thenReturnDefinitionIdsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Long> definitionIds = new LinkedHashSet<>();
    definitionIds.add(-1L);
    definitionIds.add(1L);

    Json json = new Json();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setDefinitionIds(definitionIds);

    // Act
    ImmutableSummaryCountRequest actualFromJsonResult = ImmutableSummaryCountRequest.fromJson(json);

    // Assert
    assertEquals(definitionIds, actualFromJsonResult.definitionIds());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) DefinitionIds is {@code null}.
   *   <li>Then return definitionIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) DefinitionIds is 'null'; then return definitionIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSummaryCountRequest ImmutableSummaryCountRequest.fromJson(Json)"})
  void testFromJson_whenJsonDefinitionIdsIsNull_thenReturnDefinitionIdsEmpty() {
    // Arrange
    Json json = new Json();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setDefinitionIds(null);

    // Act
    ImmutableSummaryCountRequest actualFromJsonResult = ImmutableSummaryCountRequest.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.definitionIds().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSummaryCountRequest#toString()}
   *   <li>{@link ImmutableSummaryCountRequest#definitionIds()}
   *   <li>{@link ImmutableSummaryCountRequest#idSelectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableSummaryCountRequest.definitionIds()",
    "IdSelectionOptions ImmutableSummaryCountRequest.idSelectionOptions()",
    "String ImmutableSummaryCountRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSummaryCountRequest immutableSummaryCountRequest =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableSummaryCountRequest.toString();
    Set<Long> actualDefinitionIdsResult = immutableSummaryCountRequest.definitionIds();

    // Assert
    assertTrue(
        immutableSummaryCountRequest.idSelectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "SummaryCountRequest{idSelectionOptions=IdSelectionOptions{entityReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses=[],"
            + " filters=SelectionFilters{omitApplicationKinds=[]}}, definitionIds=[]}",
        actualToStringResult);
    assertTrue(actualDefinitionIdsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#definitionIds()}.
   *
   * <p>Method under test: {@link Json#definitionIds()}
   */
  @Test
  @DisplayName("Test Json definitionIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.definitionIds()"})
  void testJsonDefinitionIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().definitionIds());
  }

  /**
   * Test Json {@link Json#idSelectionOptions()}.
   *
   * <p>Method under test: {@link Json#idSelectionOptions()}
   */
  @Test
  @DisplayName("Test Json idSelectionOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions Json.idSelectionOptions()"})
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().idSelectionOptions());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.idSelectionOptions);
    assertTrue(actualJson.definitionIds.isEmpty());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#withDefinitionIds(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#withDefinitionIds(Iterable)}
   */
  @Test
  @DisplayName("Test withDefinitionIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest ImmutableSummaryCountRequest.withDefinitionIds(Iterable)"
  })
  void testWithDefinitionIdsWithIterable() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSummaryCountRequest immutableSummaryCountRequest =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSummaryCountRequest actualWithDefinitionIdsResult =
        immutableSummaryCountRequest.withDefinitionIds(elements);

    // Assert
    IdSelectionOptions idSelectionOptionsResult =
        actualWithDefinitionIdsResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertEquals(elements, actualWithDefinitionIdsResult.definitionIds());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#withDefinitionIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableSummaryCountRequest#withDefinitionIds(long[])}
   */
  @Test
  @DisplayName("Test withDefinitionIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest ImmutableSummaryCountRequest.withDefinitionIds(long[])"
  })
  void testWithDefinitionIdsWithLong() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableSummaryCountRequest actualWithDefinitionIdsResult =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build()
            .withDefinitionIds(1L, -1L, 1L, -1L);

    // Assert
    IdSelectionOptions idSelectionOptionsResult =
        actualWithDefinitionIdsResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    Set<Long> definitionIdsResult = actualWithDefinitionIdsResult.definitionIds();
    assertEquals(2, definitionIdsResult.size());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertTrue(definitionIdsResult.contains(-1L));
    assertTrue(definitionIdsResult.contains(1L));
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableSummaryCountRequest#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableSummaryCountRequest#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSummaryCountRequest ImmutableSummaryCountRequest.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableSummaryCountRequest immutableSummaryCountRequest =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    ImmutableSummaryCountRequest actualWithIdSelectionOptionsResult =
        immutableSummaryCountRequest.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableSummaryCountRequest, actualWithIdSelectionOptionsResult);
  }
}
