package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
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
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingViewParams.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingViewParamsDiffblueTest {
  /**
   * Test Builder {@link ImmutableMeasurableRatingViewParams.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams ImmutableMeasurableRatingViewParams.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableMeasurableRatingViewParams.Builder actualBuilderResult =
        ImmutableMeasurableRatingViewParams.builder();
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
    ImmutableMeasurableRatingViewParams.Builder actualParentMeasurableIdResult =
        actualBuilderResult.idSelectionOptions(idSelectionOptions).parentMeasurableId(1L);
    Optional<Long> parentMeasurableId = Optional.of(42L);

    // Assert
    assertSame(
        idSelectionOptions,
        actualParentMeasurableIdResult
            .parentMeasurableId(parentMeasurableId)
            .build()
            .idSelectionOptions());
  }

  /**
   * Test Builder {@link
   * ImmutableMeasurableRatingViewParams.Builder#from(MeasurableRatingViewParams)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingViewParams.Builder#from(MeasurableRatingViewParams)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingViewParams)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams.Builder ImmutableMeasurableRatingViewParams.Builder.from(MeasurableRatingViewParams)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

    ImmutableMeasurableRatingViewParams.Builder builderResult2 =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams instance =
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build();

    // Act
    ImmutableMeasurableRatingViewParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRatingViewParams actualImmutableMeasurableRatingViewParams =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingViewParams);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableMeasurableRatingViewParams.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingViewParams.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder idSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams.Builder ImmutableMeasurableRatingViewParams.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(idSelectionOptions);

    // Assert
    assertSame(idSelectionOptions, builderResult.build().idSelectionOptions());
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test Builder {@link ImmutableMeasurableRatingViewParams.Builder#parentMeasurableId(long)} with
   * {@code long}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingViewParams.Builder#parentMeasurableId(long)}
   */
  @Test
  @DisplayName("Test Builder parentMeasurableId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams.Builder ImmutableMeasurableRatingViewParams.Builder.parentMeasurableId(long)"
  })
  void testBuilderParentMeasurableIdWithLong() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

    // Act
    ImmutableMeasurableRatingViewParams.Builder actualParentMeasurableIdResult =
        builderResult.parentMeasurableId(1L);

    // Assert
    assertSame(builderResult, actualParentMeasurableIdResult);
  }

  /**
   * Test Builder {@link ImmutableMeasurableRatingViewParams.Builder#parentMeasurableId(Optional)}
   * with {@code Optional}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingViewParams.Builder#parentMeasurableId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentMeasurableId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams.Builder ImmutableMeasurableRatingViewParams.Builder.parentMeasurableId(Optional)"
  })
  void testBuilderParentMeasurableIdWithOptional() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();
    Optional<Long> parentMeasurableId = Optional.of(42L);

    // Act
    ImmutableMeasurableRatingViewParams.Builder actualParentMeasurableIdResult =
        builderResult.parentMeasurableId(parentMeasurableId);

    // Assert
    assertSame(builderResult, actualParentMeasurableIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#copyOf(MeasurableRatingViewParams)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingViewParams#copyOf(MeasurableRatingViewParams)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRatingViewParams); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams ImmutableMeasurableRatingViewParams.copyOf(MeasurableRatingViewParams)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams instance =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build();

    // Act and Assert
    IdSelectionOptions idSelectionOptionsResult =
        ImmutableMeasurableRatingViewParams.copyOf(instance).idSelectionOptions();
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
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#equals(Object)}, and {@link
   * ImmutableMeasurableRatingViewParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingViewParams#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingViewParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingViewParams.equals(Object)",
    "int ImmutableMeasurableRatingViewParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams immutableMeasurableRatingViewParams =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build();

    ImmutableMeasurableRatingViewParams.Builder builderResult3 =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams immutableMeasurableRatingViewParams2 =
        builderResult3
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingViewParams, immutableMeasurableRatingViewParams2);
    assertEquals(
        immutableMeasurableRatingViewParams.hashCode(),
        immutableMeasurableRatingViewParams2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#equals(Object)}, and {@link
   * ImmutableMeasurableRatingViewParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingViewParams#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingViewParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingViewParams.equals(Object)",
    "int ImmutableMeasurableRatingViewParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams immutableMeasurableRatingViewParams =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingViewParams, immutableMeasurableRatingViewParams);
    int expectedHashCodeResult = immutableMeasurableRatingViewParams.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingViewParams.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingViewParams.equals(Object)",
    "int ImmutableMeasurableRatingViewParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    ImmutableMeasurableRatingViewParams immutableMeasurableRatingViewParams =
        ImmutableMeasurableRatingViewParams.builder()
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build();

    ImmutableMeasurableRatingViewParams.Builder builderResult2 =
        ImmutableMeasurableRatingViewParams.builder();

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
        immutableMeasurableRatingViewParams,
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingViewParams.equals(Object)",
    "int ImmutableMeasurableRatingViewParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams immutableMeasurableRatingViewParams =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(2L)
            .build();

    ImmutableMeasurableRatingViewParams.Builder builderResult3 =
        ImmutableMeasurableRatingViewParams.builder();

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
        immutableMeasurableRatingViewParams,
        builderResult3
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingViewParams.equals(Object)",
    "int ImmutableMeasurableRatingViewParams.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
            .parentMeasurableId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingViewParams.equals(Object)",
    "int ImmutableMeasurableRatingViewParams.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
            .parentMeasurableId(1L)
            .build(),
        "Different type to ImmutableMeasurableRatingViewParams");
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) ParentMeasurableId is of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) ParentMeasurableId is of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams ImmutableMeasurableRatingViewParams.fromJson(Json)"
  })
  void testFromJson_givenOfFortyTwo_whenJsonParentMeasurableIdIsOfFortyTwo() {
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
    Optional<Long> parentMeasurableId = Optional.of(42L);
    json.setParentMeasurableId(parentMeasurableId);

    // Act
    ImmutableMeasurableRatingViewParams actualFromJsonResult =
        ImmutableMeasurableRatingViewParams.fromJson(json);

    // Assert
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return idSelectionOptions is {@link Json} (default constructor) {@link
   *       Json#idSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return idSelectionOptions is Json (default constructor) idSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams ImmutableMeasurableRatingViewParams.fromJson(Json)"
  })
  void testFromJson_thenReturnIdSelectionOptionsIsJsonIdSelectionOptions() {
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
    json.setParentMeasurableId(null);

    // Act
    ImmutableMeasurableRatingViewParams actualFromJsonResult =
        ImmutableMeasurableRatingViewParams.fromJson(json);

    // Assert
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#idSelectionOptions()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#idSelectionOptions()}
   */
  @Test
  @DisplayName("Test idSelectionOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions ImmutableMeasurableRatingViewParams.idSelectionOptions()"})
  void testIdSelectionOptions() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    assertTrue(
        builderResult
                .idSelectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .parentMeasurableId(1L)
                .build()
                .idSelectionOptions()
            instanceof ImmutableIdSelectionOptions);
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
    assertFalse(actualJson.parentMeasurableId.isPresent());
  }

  /**
   * Test Json {@link Json#parentMeasurableId()}.
   *
   * <p>Method under test: {@link Json#parentMeasurableId()}
   */
  @Test
  @DisplayName("Test Json parentMeasurableId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentMeasurableId()"})
  void testJsonParentMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentMeasurableId());
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#parentMeasurableId()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#parentMeasurableId()}
   */
  @Test
  @DisplayName("Test parentMeasurableId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMeasurableRatingViewParams.parentMeasurableId()"})
  void testParentMeasurableId() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    Optional<Long> actualParentMeasurableIdResult =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build()
            .parentMeasurableId();

    // Assert
    assertEquals(1L, actualParentMeasurableIdResult.get().longValue());
    assertTrue(actualParentMeasurableIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#toString()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableMeasurableRatingViewParams.toString()"})
  void testToString() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    assertEquals(
        "MeasurableRatingViewParams{idSelectionOptions=IdSelectionOptions{entityReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses=[],"
            + " filters=SelectionFilters{omitApplicationKinds=[]}}, parentMeasurableId=1}",
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingViewParams#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams ImmutableMeasurableRatingViewParams.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams immutableMeasurableRatingViewParams =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
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
    ImmutableMeasurableRatingViewParams actualWithIdSelectionOptionsResult =
        immutableMeasurableRatingViewParams.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingViewParams, actualWithIdSelectionOptionsResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#withParentMeasurableId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingViewParams#withParentMeasurableId(Optional)}
   */
  @Test
  @DisplayName("Test withParentMeasurableId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams ImmutableMeasurableRatingViewParams.withParentMeasurableId(Optional)"
  })
  void testWithParentMeasurableIdWithOptional() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams immutableMeasurableRatingViewParams =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act and Assert
    IdSelectionOptions idSelectionOptionsResult =
        immutableMeasurableRatingViewParams.withParentMeasurableId(optional).idSelectionOptions();
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
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#withParentMeasurableId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingViewParams#withParentMeasurableId(Optional)}
   */
  @Test
  @DisplayName("Test withParentMeasurableId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams ImmutableMeasurableRatingViewParams.withParentMeasurableId(Optional)"
  })
  void testWithParentMeasurableIdWithOptional2() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams immutableMeasurableRatingViewParams =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMeasurableRatingViewParams actualWithParentMeasurableIdResult =
        immutableMeasurableRatingViewParams.withParentMeasurableId(optional);

    // Assert
    assertSame(immutableMeasurableRatingViewParams, actualWithParentMeasurableIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#withParentMeasurableId(long)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#withParentMeasurableId(long)}
   */
  @Test
  @DisplayName("Test withParentMeasurableId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams ImmutableMeasurableRatingViewParams.withParentMeasurableId(long)"
  })
  void testWithParentMeasurableIdWithValue() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    IdSelectionOptions idSelectionOptionsResult =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build()
            .withParentMeasurableId(42L)
            .idSelectionOptions();
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
  }

  /**
   * Test {@link ImmutableMeasurableRatingViewParams#withParentMeasurableId(long)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingViewParams#withParentMeasurableId(long)}
   */
  @Test
  @DisplayName("Test withParentMeasurableId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingViewParams ImmutableMeasurableRatingViewParams.withParentMeasurableId(long)"
  })
  void testWithParentMeasurableIdWithValue2() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult =
        ImmutableMeasurableRatingViewParams.builder();

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
    ImmutableMeasurableRatingViewParams immutableMeasurableRatingViewParams =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .parentMeasurableId(1L)
            .build();

    // Act
    ImmutableMeasurableRatingViewParams actualWithParentMeasurableIdResult =
        immutableMeasurableRatingViewParams.withParentMeasurableId(1L);

    // Assert
    assertSame(immutableMeasurableRatingViewParams, actualWithParentMeasurableIdResult);
  }
}
