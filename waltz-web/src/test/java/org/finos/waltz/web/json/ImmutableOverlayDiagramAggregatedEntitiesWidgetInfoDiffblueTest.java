package org.finos.waltz.web.json;

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
import org.finos.waltz.model.AssessmentBasedSelectionFilter;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableAssessmentBasedSelectionFilter;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AggregatedEntitiesWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAggregatedEntitiesWidgetParameters;
import org.finos.waltz.web.json.ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAggregatedEntitiesWidgetInfoDiffblueTest {
  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder.addAllAssessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAddAllAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder
        actualAddAllAssessmentBasedSelectionFiltersResult =
            builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   * with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElement_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElements_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder.assessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder
        actualAssessmentBasedSelectionFiltersResult =
            builderResult.assessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#build()}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder actualBuilderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();
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
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableAggregatedEntitiesWidgetParameters overlayParameters =
        ImmutableAggregatedEntitiesWidgetParameters.builder().build();
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        actualImmutableOverlayDiagramAggregatedEntitiesWidgetInfo =
            actualBuilderResult
                .idSelectionOptions(idSelectionOptions)
                .overlayParameters(overlayParameters)
                .build();

    // Assert
    AggregatedEntitiesWidgetParameters overlayParametersResult =
        actualImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAggregatedEntitiesWidgetParameters);
    assertTrue(
        actualImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
            .assessmentBasedSelectionFilters()
            .isEmpty());
    assertSame(
        idSelectionOptions,
        actualImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.idSelectionOptions());
    assertSame(overlayParameters, overlayParametersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramAggregatedEntitiesWidgetInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder.from(OverlayDiagramAggregatedEntitiesWidgetInfo)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo instance =
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
            .build();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        actualImmutableOverlayDiagramAggregatedEntitiesWidgetInfo = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAggregatedEntitiesWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramAggregatedEntitiesWidgetInfo); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder.from(OverlayDiagramAggregatedEntitiesWidgetInfo)"
  })
  void testBuilderFrom_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();
    builderResult2.addAssessmentBasedSelectionFilters(
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo instance =
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
            .build();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        actualImmutableOverlayDiagramAggregatedEntitiesWidgetInfo = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAggregatedEntitiesWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder idSelectionOptions(IdSelectionOptions); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#overlayParameters(AggregatedEntitiesWidgetParameters)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#overlayParameters(AggregatedEntitiesWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder overlayParameters(AggregatedEntitiesWidgetParameters); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder.overlayParameters(AggregatedEntitiesWidgetParameters)"
  })
  void testBuilderOverlayParameters_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder actualOverlayParametersResult =
        builderResult.overlayParameters(
            ImmutableAggregatedEntitiesWidgetParameters.builder().build());

    // Assert
    assertSame(builderResult, actualOverlayParametersResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#copyOf(OverlayDiagramAggregatedEntitiesWidgetInfo)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#copyOf(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OverlayDiagramAggregatedEntitiesWidgetInfo); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.copyOf(OverlayDiagramAggregatedEntitiesWidgetInfo)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo instance =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
            .build();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualCopyOfResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult = actualCopyOfResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertTrue(
        actualCopyOfResult.overlayParameters()
            instanceof ImmutableAggregatedEntitiesWidgetParameters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualCopyOfResult.assessmentBasedSelectionFilters().isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo =
            builderResult
                .idSelectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
                .build();

    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo2 =
            builderResult3
                .idSelectionOptions(
                    joiningEntityKindResult2
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
                .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo,
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo2);
    assertEquals(
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo.hashCode(),
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo =
            builderResult
                .idSelectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
                .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo,
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo);
    int expectedHashCodeResult = immutableOverlayDiagramAggregatedEntitiesWidgetInfo.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableOverlayDiagramAggregatedEntitiesWidgetInfo.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();
    builderResult.addAssessmentBasedSelectionFilters(
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo =
            builderResult
                .idSelectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
                .build();

    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo,
        builderResult3
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.hashCode()"
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo =
            ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder()
                .idSelectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
                .build();

    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo,
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
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
            .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
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
            .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
            .build(),
        "Different type to ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo");
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AssessmentBasedSelectionFilters is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AssessmentBasedSelectionFilters is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAssessmentBasedSelectionFiltersIsHashSet() {
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setAssessmentBasedSelectionFilters(new HashSet<>());
    json.setOverlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build());

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.fromJson(json);

    // Assert
    AggregatedEntitiesWidgetParameters overlayParametersResult =
        actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAggregatedEntitiesWidgetParameters);
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    assertSame(json.overlayParameters, overlayParametersResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.fromJson(Json)"
  })
  void testFromJson_thenReturnAssessmentBasedSelectionFiltersEmpty() {
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setAssessmentBasedSelectionFilters(null);
    json.setOverlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build());

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.fromJson(json);

    // Assert
    AggregatedEntitiesWidgetParameters overlayParametersResult =
        actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAggregatedEntitiesWidgetParameters);
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    assertSame(json.overlayParameters, overlayParametersResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return assessmentBasedSelectionFilters is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.fromJson(Json)"
  })
  void testFromJson_thenReturnAssessmentBasedSelectionFiltersIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters =
        new LinkedHashSet<>();
    assessmentBasedSelectionFilters.add(
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(2L).build());
    assessmentBasedSelectionFilters.add(
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setAssessmentBasedSelectionFilters(assessmentBasedSelectionFilters);
    json.setOverlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build());

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.fromJson(json);

    // Assert
    AggregatedEntitiesWidgetParameters overlayParametersResult =
        actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAggregatedEntitiesWidgetParameters);
    assertEquals(
        assessmentBasedSelectionFilters, actualFromJsonResult.assessmentBasedSelectionFilters());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    assertSame(json.overlayParameters, overlayParametersResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.fromJson(Json)"
  })
  void testFromJson_thenReturnAssessmentBasedSelectionFiltersSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters =
        new LinkedHashSet<>();
    assessmentBasedSelectionFilters.add(
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setAssessmentBasedSelectionFilters(assessmentBasedSelectionFilters);
    json.setOverlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build());

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.fromJson(json);

    // Assert
    AggregatedEntitiesWidgetParameters overlayParametersResult =
        actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAggregatedEntitiesWidgetParameters);
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    assertSame(json.overlayParameters, overlayParametersResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#toString()}
   *   <li>{@link
   *       ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#assessmentBasedSelectionFilters()}
   *   <li>{@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#idSelectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.assessmentBasedSelectionFilters()",
    "IdSelectionOptions ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.idSelectionOptions()",
    "String ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo =
            builderResult
                .idSelectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
                .build();

    // Act
    String actualToStringResult = immutableOverlayDiagramAggregatedEntitiesWidgetInfo.toString();
    Set<AssessmentBasedSelectionFilter> actualAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo.assessmentBasedSelectionFilters();

    // Assert
    assertTrue(
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo.idSelectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "OverlayDiagramAggregatedEntitiesWidgetInfo{idSelectionOptions=IdSelectionOptions{entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL,"
            + " entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}}, assessmentBasedSele"
            + "ctionFilters=[], overlayParameters=AggregatedEntitiesWidgetParameters{}}",
        actualToStringResult);
    assertTrue(actualAssessmentBasedSelectionFiltersResult.isEmpty());
  }

  /**
   * Test Json {@link Json#assessmentBasedSelectionFilters()}.
   *
   * <p>Method under test: {@link Json#assessmentBasedSelectionFilters()}
   */
  @Test
  @DisplayName("Test Json assessmentBasedSelectionFilters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.assessmentBasedSelectionFilters()"})
  void testJsonAssessmentBasedSelectionFilters() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().assessmentBasedSelectionFilters());
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
    assertNull(actualJson.overlayParameters);
    assertTrue(actualJson.assessmentBasedSelectionFilters.isEmpty());
  }

  /**
   * Test Json {@link Json#overlayParameters()}.
   *
   * <p>Method under test: {@link Json#overlayParameters()}
   */
  @Test
  @DisplayName("Test Json overlayParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AggregatedEntitiesWidgetParameters Json.overlayParameters()"})
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#overlayParameters()}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#overlayParameters()}
   */
  @Test
  @DisplayName("Test overlayParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AggregatedEntitiesWidgetParameters ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.overlayParameters()"
  })
  void testOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
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
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
                .build()
                .overlayParameters()
            instanceof ImmutableAggregatedEntitiesWidgetParameters);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code AssessmentBasedSelectionFilter[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'AssessmentBasedSelectionFilter[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testWithAssessmentBasedSelectionFiltersWithAssessmentBasedSelectionFilter() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo =
            builderResult
                .idSelectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
                .build();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        actualWithAssessmentBasedSelectionFiltersResult =
            immutableOverlayDiagramAggregatedEntitiesWidgetInfo.withAssessmentBasedSelectionFilters(
                ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Assert
    IdSelectionOptions idSelectionOptionsResult =
        actualWithAssessmentBasedSelectionFiltersResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertTrue(
        actualWithAssessmentBasedSelectionFiltersResult.overlayParameters()
            instanceof ImmutableAggregatedEntitiesWidgetParameters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        1,
        actualWithAssessmentBasedSelectionFiltersResult.assessmentBasedSelectionFilters().size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo =
            builderResult
                .idSelectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualWithIdSelectionOptionsResult =
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo, actualWithIdSelectionOptionsResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#withOverlayParameters(AggregatedEntitiesWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#withOverlayParameters(AggregatedEntitiesWidgetParameters)}
   */
  @Test
  @DisplayName("Test withOverlayParameters(AggregatedEntitiesWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.withOverlayParameters(AggregatedEntitiesWidgetParameters)"
  })
  void testWithOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo =
            builderResult
                .idSelectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .overlayParameters(ImmutableAggregatedEntitiesWidgetParameters.builder().build())
                .build();

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualWithOverlayParametersResult =
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo.withOverlayParameters(
            ImmutableAggregatedEntitiesWidgetParameters.builder().build());

    // Assert
    assertEquals(
        immutableOverlayDiagramAggregatedEntitiesWidgetInfo, actualWithOverlayParametersResult);
  }
}
