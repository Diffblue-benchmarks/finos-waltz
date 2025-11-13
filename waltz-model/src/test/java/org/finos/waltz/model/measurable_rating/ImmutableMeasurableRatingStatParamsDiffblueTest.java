package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingStatParams.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingStatParamsDiffblueTest {
  /**
   * Test Builder {@link ImmutableMeasurableRatingStatParams.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingStatParams.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingStatParams ImmutableMeasurableRatingStatParams.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableMeasurableRatingStatParams.Builder actualBuilderResult =
        ImmutableMeasurableRatingStatParams.builder();
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
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableMeasurableRatingStatParams actualImmutableMeasurableRatingStatParams =
        actualBuilderResult.options(options).build();

    // Assert
    assertFalse(actualImmutableMeasurableRatingStatParams.showPrimaryOnly());
    assertSame(options, actualImmutableMeasurableRatingStatParams.options());
  }

  /**
   * Test Builder {@link
   * ImmutableMeasurableRatingStatParams.Builder#from(MeasurableRatingStatParams)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingStatParams.Builder#from(MeasurableRatingStatParams)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingStatParams)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingStatParams.Builder ImmutableMeasurableRatingStatParams.Builder.from(MeasurableRatingStatParams)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

    ImmutableMeasurableRatingStatParams.Builder builderResult2 =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableMeasurableRatingStatParams instance =
        builderResult2
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingStatParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRatingStatParams actualImmutableMeasurableRatingStatParams =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingStatParams);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link ImmutableMeasurableRatingStatParams.Builder#options(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then not builder build showPrimaryOnly.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingStatParams.Builder#options(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder options(IdSelectionOptions); then not builder build showPrimaryOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingStatParams.Builder ImmutableMeasurableRatingStatParams.Builder.options(IdSelectionOptions)"
  })
  void testBuilderOptions_thenNotBuilderBuildShowPrimaryOnly() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableMeasurableRatingStatParams.Builder actualOptionsResult =
        builderResult.options(options);

    // Assert
    ImmutableMeasurableRatingStatParams immutableMeasurableRatingStatParams = builderResult.build();
    assertFalse(immutableMeasurableRatingStatParams.showPrimaryOnly());
    assertSame(options, immutableMeasurableRatingStatParams.options());
    assertSame(builderResult, actualOptionsResult);
  }

  /**
   * Test Builder {@link ImmutableMeasurableRatingStatParams.Builder#showPrimaryOnly(boolean)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingStatParams.Builder#showPrimaryOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder showPrimaryOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingStatParams.Builder ImmutableMeasurableRatingStatParams.Builder.showPrimaryOnly(boolean)"
  })
  void testBuilderShowPrimaryOnly() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

    // Act
    ImmutableMeasurableRatingStatParams.Builder actualShowPrimaryOnlyResult =
        builderResult.showPrimaryOnly(true);

    // Assert
    assertSame(builderResult, actualShowPrimaryOnlyResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#copyOf(MeasurableRatingStatParams)}.
   *
   * <ul>
   *   <li>Then options entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingStatParams#copyOf(MeasurableRatingStatParams)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRatingStatParams); then options entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingStatParams ImmutableMeasurableRatingStatParams.copyOf(MeasurableRatingStatParams)"
  })
  void testCopyOf_thenOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableMeasurableRatingStatParams instance =
        builderResult
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingStatParams actualCopyOfResult =
        ImmutableMeasurableRatingStatParams.copyOf(instance);

    // Assert
    IdSelectionOptions optionsResult = actualCopyOfResult.options();
    EntityReference entityReferenceResult = optionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(optionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = optionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, optionsResult.scope());
    assertFalse(actualCopyOfResult.showPrimaryOnly());
    assertTrue(optionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#equals(Object)}, and {@link
   * ImmutableMeasurableRatingStatParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingStatParams#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingStatParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingStatParams.equals(Object)",
    "int ImmutableMeasurableRatingStatParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableMeasurableRatingStatParams immutableMeasurableRatingStatParams =
        builderResult
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableMeasurableRatingStatParams.Builder builderResult3 =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableMeasurableRatingStatParams immutableMeasurableRatingStatParams2 =
        builderResult3
            .options(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingStatParams, immutableMeasurableRatingStatParams2);
    assertEquals(
        immutableMeasurableRatingStatParams.hashCode(),
        immutableMeasurableRatingStatParams2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#equals(Object)}, and {@link
   * ImmutableMeasurableRatingStatParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingStatParams#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingStatParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingStatParams.equals(Object)",
    "int ImmutableMeasurableRatingStatParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableMeasurableRatingStatParams immutableMeasurableRatingStatParams =
        builderResult
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingStatParams, immutableMeasurableRatingStatParams);
    int expectedHashCodeResult = immutableMeasurableRatingStatParams.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingStatParams.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingStatParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingStatParams.equals(Object)",
    "int ImmutableMeasurableRatingStatParams.hashCode()"
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
    ImmutableMeasurableRatingStatParams immutableMeasurableRatingStatParams =
        ImmutableMeasurableRatingStatParams.builder()
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableMeasurableRatingStatParams.Builder builderResult2 =
        ImmutableMeasurableRatingStatParams.builder();

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
        immutableMeasurableRatingStatParams,
        builderResult2
            .options(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingStatParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingStatParams.equals(Object)",
    "int ImmutableMeasurableRatingStatParams.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingStatParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingStatParams.equals(Object)",
    "int ImmutableMeasurableRatingStatParams.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        "Different type to ImmutableMeasurableRatingStatParams");
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return not showPrimaryOnly.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingStatParams#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return not showPrimaryOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingStatParams ImmutableMeasurableRatingStatParams.fromJson(Json)"
  })
  void testFromJson_thenReturnNotShowPrimaryOnly() {
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
    json.setOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    // Act
    ImmutableMeasurableRatingStatParams actualFromJsonResult =
        ImmutableMeasurableRatingStatParams.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.showPrimaryOnly());
    IdSelectionOptions expectedOptionsResult = json.options;
    assertSame(expectedOptionsResult, actualFromJsonResult.options());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingStatParams#toString()}
   *   <li>{@link ImmutableMeasurableRatingStatParams#options()}
   *   <li>{@link ImmutableMeasurableRatingStatParams#showPrimaryOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdSelectionOptions ImmutableMeasurableRatingStatParams.options()",
    "boolean ImmutableMeasurableRatingStatParams.showPrimaryOnly()",
    "String ImmutableMeasurableRatingStatParams.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableMeasurableRatingStatParams immutableMeasurableRatingStatParams =
        builderResult
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableMeasurableRatingStatParams.toString();
    IdSelectionOptions actualOptionsResult = immutableMeasurableRatingStatParams.options();

    // Assert
    assertTrue(actualOptionsResult instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "MeasurableRatingStatParams{options=IdSelectionOptions{entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses=[],"
            + " filters=SelectionFilters{omitApplicationKinds=[]}}, showPrimaryOnly=false}",
        actualToStringResult);
    assertFalse(immutableMeasurableRatingStatParams.showPrimaryOnly());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setOptions(IdSelectionOptions)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setOptions(IdSelectionOptions)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
    actualJson.setOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    // Assert
    IdSelectionOptions idSelectionOptions = actualJson.options;
    EntityReference entityReferenceResult = idSelectionOptions.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptions instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptions.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptions.scope());
    assertFalse(actualJson.showPrimaryOnly);
    assertFalse(actualJson.showPrimaryOnlyIsSet);
    assertTrue(idSelectionOptions.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test Json {@link Json#options()}.
   *
   * <p>Method under test: {@link Json#options()}
   */
  @Test
  @DisplayName("Test Json options()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions Json.options()"})
  void testJsonOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().options());
  }

  /**
   * Test Json {@link Json#setShowPrimaryOnly(boolean)}.
   *
   * <p>Method under test: {@link Json#setShowPrimaryOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setShowPrimaryOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setShowPrimaryOnly(boolean)"})
  void testJsonSetShowPrimaryOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setShowPrimaryOnly(true);

    // Assert
    assertTrue(json.showPrimaryOnly);
    assertTrue(json.showPrimaryOnlyIsSet);
  }

  /**
   * Test Json {@link Json#showPrimaryOnly()}.
   *
   * <p>Method under test: {@link Json#showPrimaryOnly()}
   */
  @Test
  @DisplayName("Test Json showPrimaryOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.showPrimaryOnly()"})
  void testJsonShowPrimaryOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().showPrimaryOnly());
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#withOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingStatParams#withOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingStatParams ImmutableMeasurableRatingStatParams.withOptions(IdSelectionOptions)"
  })
  void testWithOptions() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableMeasurableRatingStatParams immutableMeasurableRatingStatParams =
        builderResult
            .options(
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
    ImmutableMeasurableRatingStatParams actualWithOptionsResult =
        immutableMeasurableRatingStatParams.withOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingStatParams, actualWithOptionsResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#withShowPrimaryOnly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingStatParams#withShowPrimaryOnly(boolean)}
   */
  @Test
  @DisplayName("Test withShowPrimaryOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingStatParams ImmutableMeasurableRatingStatParams.withShowPrimaryOnly(boolean)"
  })
  void testWithShowPrimaryOnly() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableMeasurableRatingStatParams immutableMeasurableRatingStatParams =
        builderResult
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingStatParams actualWithShowPrimaryOnlyResult =
        immutableMeasurableRatingStatParams.withShowPrimaryOnly(false);

    // Assert
    assertSame(immutableMeasurableRatingStatParams, actualWithShowPrimaryOnlyResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingStatParams#withShowPrimaryOnly(boolean)}.
   *
   * <ul>
   *   <li>Then options entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingStatParams#withShowPrimaryOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test withShowPrimaryOnly(boolean); then options entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingStatParams ImmutableMeasurableRatingStatParams.withShowPrimaryOnly(boolean)"
  })
  void testWithShowPrimaryOnly_thenOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult =
        ImmutableMeasurableRatingStatParams.builder();

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
    ImmutableMeasurableRatingStatParams actualWithShowPrimaryOnlyResult =
        builderResult
            .options(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build()
            .withShowPrimaryOnly(true);

    // Assert
    IdSelectionOptions optionsResult = actualWithShowPrimaryOnlyResult.options();
    EntityReference entityReferenceResult = optionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(optionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = optionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, optionsResult.scope());
    assertTrue(optionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualWithShowPrimaryOnlyResult.showPrimaryOnly());
  }
}
