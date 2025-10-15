package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.finos.waltz.model.cost.ImmutableAssetCostQueryOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssetCostQueryOptionsDiffblueTest {
  /**
   * Test Builder {@link ImmutableAssetCostQueryOptions.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableAssetCostQueryOptions.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssetCostQueryOptions ImmutableAssetCostQueryOptions.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssetCostQueryOptions.Builder actualBuilderResult =
        ImmutableAssetCostQueryOptions.builder();
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
    ImmutableAssetCostQueryOptions actualImmutableAssetCostQueryOptions =
        actualBuilderResult.idSelectionOptions(idSelectionOptions).year(1).build();

    // Assert
    assertEquals(1, actualImmutableAssetCostQueryOptions.year());
    assertSame(idSelectionOptions, actualImmutableAssetCostQueryOptions.idSelectionOptions());
  }

  /**
   * Test Builder {@link ImmutableAssetCostQueryOptions.Builder#from(AssetCostQueryOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssetCostQueryOptions.Builder#from(AssetCostQueryOptions)}
   */
  @Test
  @DisplayName("Test Builder from(AssetCostQueryOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssetCostQueryOptions.Builder ImmutableAssetCostQueryOptions.Builder.from(AssetCostQueryOptions)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

    ImmutableAssetCostQueryOptions.Builder builderResult2 =
        ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions instance =
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build();

    // Act
    ImmutableAssetCostQueryOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssetCostQueryOptions actualImmutableAssetCostQueryOptions = builderResult.build();
    assertEquals(instance, actualImmutableAssetCostQueryOptions);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableAssetCostQueryOptions.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssetCostQueryOptions.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssetCostQueryOptions.Builder ImmutableAssetCostQueryOptions.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

    // Act
    ImmutableAssetCostQueryOptions.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test Builder {@link ImmutableAssetCostQueryOptions.Builder#year(int)}.
   *
   * <p>Method under test: {@link ImmutableAssetCostQueryOptions.Builder#year(int)}
   */
  @Test
  @DisplayName("Test Builder year(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssetCostQueryOptions.Builder ImmutableAssetCostQueryOptions.Builder.year(int)"
  })
  void testBuilderYear() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

    // Act
    ImmutableAssetCostQueryOptions.Builder actualYearResult = builderResult.year(1);

    // Assert
    assertSame(builderResult, actualYearResult);
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#copyOf(AssetCostQueryOptions)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCostQueryOptions#copyOf(AssetCostQueryOptions)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssetCostQueryOptions); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssetCostQueryOptions ImmutableAssetCostQueryOptions.copyOf(AssetCostQueryOptions)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions instance =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build();

    // Act
    ImmutableAssetCostQueryOptions actualCopyOfResult =
        ImmutableAssetCostQueryOptions.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult = actualCopyOfResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#equals(Object)}, and {@link
   * ImmutableAssetCostQueryOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssetCostQueryOptions#equals(Object)}
   *   <li>{@link ImmutableAssetCostQueryOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCostQueryOptions.equals(Object)",
    "int ImmutableAssetCostQueryOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions immutableAssetCostQueryOptions =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build();

    ImmutableAssetCostQueryOptions.Builder builderResult3 =
        ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions immutableAssetCostQueryOptions2 =
        builderResult3
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build();

    // Act and Assert
    assertEquals(immutableAssetCostQueryOptions, immutableAssetCostQueryOptions2);
    assertEquals(
        immutableAssetCostQueryOptions.hashCode(), immutableAssetCostQueryOptions2.hashCode());
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#equals(Object)}, and {@link
   * ImmutableAssetCostQueryOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssetCostQueryOptions#equals(Object)}
   *   <li>{@link ImmutableAssetCostQueryOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCostQueryOptions.equals(Object)",
    "int ImmutableAssetCostQueryOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions immutableAssetCostQueryOptions =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build();

    // Act and Assert
    assertEquals(immutableAssetCostQueryOptions, immutableAssetCostQueryOptions);
    int expectedHashCodeResult = immutableAssetCostQueryOptions.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssetCostQueryOptions.hashCode());
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCostQueryOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCostQueryOptions.equals(Object)",
    "int ImmutableAssetCostQueryOptions.hashCode()"
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
    ImmutableAssetCostQueryOptions immutableAssetCostQueryOptions =
        ImmutableAssetCostQueryOptions.builder()
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build();

    ImmutableAssetCostQueryOptions.Builder builderResult2 =
        ImmutableAssetCostQueryOptions.builder();

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
        immutableAssetCostQueryOptions,
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCostQueryOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCostQueryOptions.equals(Object)",
    "int ImmutableAssetCostQueryOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions immutableAssetCostQueryOptions =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(0)
            .build();

    ImmutableAssetCostQueryOptions.Builder builderResult3 =
        ImmutableAssetCostQueryOptions.builder();

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
        immutableAssetCostQueryOptions,
        builderResult3
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCostQueryOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCostQueryOptions.equals(Object)",
    "int ImmutableAssetCostQueryOptions.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
            .year(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCostQueryOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCostQueryOptions.equals(Object)",
    "int ImmutableAssetCostQueryOptions.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
            .year(1)
            .build(),
        "Different type to ImmutableAssetCostQueryOptions");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssetCostQueryOptions#toString()}
   *   <li>{@link ImmutableAssetCostQueryOptions#idSelectionOptions()}
   *   <li>{@link ImmutableAssetCostQueryOptions#year()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdSelectionOptions ImmutableAssetCostQueryOptions.idSelectionOptions()",
    "String ImmutableAssetCostQueryOptions.toString()",
    "int ImmutableAssetCostQueryOptions.year()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions immutableAssetCostQueryOptions =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build();

    // Act
    String actualToStringResult = immutableAssetCostQueryOptions.toString();
    IdSelectionOptions actualIdSelectionOptionsResult =
        immutableAssetCostQueryOptions.idSelectionOptions();

    // Assert
    assertTrue(actualIdSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "AssetCostQueryOptions{year=1, idSelectionOptions=IdSelectionOptions{entityReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses=[],"
            + " filters=SelectionFilters{omitApplicationKinds=[]}}}",
        actualToStringResult);
    assertEquals(1, immutableAssetCostQueryOptions.year());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setIdSelectionOptions(IdSelectionOptions)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setIdSelectionOptions(IdSelectionOptions)"})
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
    actualJson.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    // Assert
    IdSelectionOptions idSelectionOptions = actualJson.idSelectionOptions;
    EntityReference entityReferenceResult = idSelectionOptions.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptions instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptions.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(0, actualJson.year);
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptions.scope());
    assertFalse(actualJson.yearIsSet);
    assertTrue(idSelectionOptions.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
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
   * Test Json {@link Json#setYear(int)}.
   *
   * <p>Method under test: {@link Json#setYear(int)}
   */
  @Test
  @DisplayName("Test Json setYear(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setYear(int)"})
  void testJsonSetYear() {
    // Arrange
    Json json = new Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Test Json {@link Json#year()}.
   *
   * <p>Method under test: {@link Json#year()}
   */
  @Test
  @DisplayName("Test Json year()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.year()"})
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().year());
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssetCostQueryOptions#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssetCostQueryOptions ImmutableAssetCostQueryOptions.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions immutableAssetCostQueryOptions =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
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
    ImmutableAssetCostQueryOptions actualWithIdSelectionOptionsResult =
        immutableAssetCostQueryOptions.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableAssetCostQueryOptions, actualWithIdSelectionOptionsResult);
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#withYear(int)}.
   *
   * <p>Method under test: {@link ImmutableAssetCostQueryOptions#withYear(int)}
   */
  @Test
  @DisplayName("Test withYear(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCostQueryOptions ImmutableAssetCostQueryOptions.withYear(int)"})
  void testWithYear() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions immutableAssetCostQueryOptions =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(42)
            .build();

    // Act
    ImmutableAssetCostQueryOptions actualWithYearResult =
        immutableAssetCostQueryOptions.withYear(42);

    // Assert
    assertSame(immutableAssetCostQueryOptions, actualWithYearResult);
  }

  /**
   * Test {@link ImmutableAssetCostQueryOptions#withYear(int)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCostQueryOptions#withYear(int)}
   */
  @Test
  @DisplayName(
      "Test withYear(int); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCostQueryOptions ImmutableAssetCostQueryOptions.withYear(int)"})
  void testWithYear_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

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
    ImmutableAssetCostQueryOptions actualWithYearResult =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .year(1)
            .build()
            .withYear(42);

    // Assert
    IdSelectionOptions idSelectionOptionsResult = actualWithYearResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42, actualWithYearResult.year());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }
}
