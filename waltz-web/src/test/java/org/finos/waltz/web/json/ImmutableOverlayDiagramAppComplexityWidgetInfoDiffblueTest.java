package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppComplexityWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppComplexityWidgetParameters;
import org.finos.waltz.web.json.ImmutableOverlayDiagramAppComplexityWidgetInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAppComplexityWidgetInfoDiffblueTest {
  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder.addAllAssessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAddAllAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder
        actualAddAllAssessmentBasedSelectionFiltersResult =
            builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   * with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElement_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElements_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder.assessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder
        actualAssessmentBasedSelectionFiltersResult =
            builderResult.assessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder actualBuilderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();
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
    ImmutableAppComplexityWidgetParameters overlayParameters =
        ImmutableAppComplexityWidgetParameters.builder().build();
    ImmutableOverlayDiagramAppComplexityWidgetInfo
        actualImmutableOverlayDiagramAppComplexityWidgetInfo =
            actualBuilderResult
                .idSelectionOptions(idSelectionOptions)
                .overlayParameters(overlayParameters)
                .build();

    // Assert
    assertTrue(
        actualImmutableOverlayDiagramAppComplexityWidgetInfo
            .assessmentBasedSelectionFilters()
            .isEmpty());
    assertSame(
        idSelectionOptions,
        actualImmutableOverlayDiagramAppComplexityWidgetInfo.idSelectionOptions());
    assertSame(
        overlayParameters,
        actualImmutableOverlayDiagramAppComplexityWidgetInfo.overlayParameters());
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#from(OverlayDiagramAppComplexityWidgetInfo)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#from(OverlayDiagramAppComplexityWidgetInfo)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramAppComplexityWidgetInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder.from(OverlayDiagramAppComplexityWidgetInfo)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo instance =
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAppComplexityWidgetInfo
        actualImmutableOverlayDiagramAppComplexityWidgetInfo = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAppComplexityWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#from(OverlayDiagramAppComplexityWidgetInfo)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#from(OverlayDiagramAppComplexityWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramAppComplexityWidgetInfo); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder.from(OverlayDiagramAppComplexityWidgetInfo)"
  })
  void testBuilderFrom_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();
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
    ImmutableOverlayDiagramAppComplexityWidgetInfo instance =
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAppComplexityWidgetInfo
        actualImmutableOverlayDiagramAppComplexityWidgetInfo = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAppComplexityWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#overlayParameters(AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>When {@link AppComplexityWidgetParameters}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#overlayParameters(AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder overlayParameters(AppComplexityWidgetParameters); when AppComplexityWidgetParameters; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder.overlayParameters(AppComplexityWidgetParameters)"
  })
  void testBuilderOverlayParameters_whenAppComplexityWidgetParameters_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder actualOverlayParametersResult =
        builderResult.overlayParameters(mock(AppComplexityWidgetParameters.class));

    // Assert
    assertSame(builderResult, actualOverlayParametersResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#copyOf(OverlayDiagramAppComplexityWidgetInfo)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#copyOf(OverlayDiagramAppComplexityWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OverlayDiagramAppComplexityWidgetInfo); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo ImmutableOverlayDiagramAppComplexityWidgetInfo.copyOf(OverlayDiagramAppComplexityWidgetInfo)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo instance =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualCopyOfResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult = actualCopyOfResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AppComplexityWidgetParameters overlayParametersResult = actualCopyOfResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppComplexityWidgetParameters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    Set<AssessmentBasedSelectionFilter> assessmentBasedSelectionFiltersResult =
        actualCopyOfResult.assessmentBasedSelectionFilters();
    assertTrue(assessmentBasedSelectionFiltersResult.isEmpty());
    assertSame(assessmentBasedSelectionFiltersResult, overlayParametersResult.complexityKindIds());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAppComplexityWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppComplexityWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppComplexityWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo2 =
        builderResult3
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAppComplexityWidgetInfo,
        immutableOverlayDiagramAppComplexityWidgetInfo2);
    assertEquals(
        immutableOverlayDiagramAppComplexityWidgetInfo.hashCode(),
        immutableOverlayDiagramAppComplexityWidgetInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAppComplexityWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppComplexityWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppComplexityWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAppComplexityWidgetInfo,
        immutableOverlayDiagramAppComplexityWidgetInfo);
    int expectedHashCodeResult = immutableOverlayDiagramAppComplexityWidgetInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableOverlayDiagramAppComplexityWidgetInfo.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppComplexityWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppComplexityWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();
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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
        immutableOverlayDiagramAppComplexityWidgetInfo,
        builderResult3
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppComplexityWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppComplexityWidgetInfo.hashCode()"
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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder()
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
        immutableOverlayDiagramAppComplexityWidgetInfo,
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppComplexityWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppComplexityWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Builder builderResult =
        ImmutableAppComplexityWidgetParameters.builder();
    builderResult.addComplexityKindIds(1L);
    ImmutableAppComplexityWidgetParameters overlayParameters = builderResult.build();

    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo =
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(overlayParameters)
            .build();

    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult4 =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

    Builder builderResult5 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult5
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
        immutableOverlayDiagramAppComplexityWidgetInfo,
        builderResult4
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppComplexityWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppComplexityWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppComplexityWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppComplexityWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build(),
        "Different type to ImmutableOverlayDiagramAppComplexityWidgetInfo");
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AssessmentBasedSelectionFilters is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AssessmentBasedSelectionFilters is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo ImmutableOverlayDiagramAppComplexityWidgetInfo.fromJson(Json)"
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
    json.setOverlayParameters(ImmutableAppComplexityWidgetParameters.builder().build());

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.fromJson(json);

    // Assert
    AppComplexityWidgetParameters overlayParametersResult =
        actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppComplexityWidgetParameters);
    Set<AssessmentBasedSelectionFilter> assessmentBasedSelectionFiltersResult =
        actualFromJsonResult.assessmentBasedSelectionFilters();
    assertTrue(assessmentBasedSelectionFiltersResult.isEmpty());
    assertSame(assessmentBasedSelectionFiltersResult, overlayParametersResult.complexityKindIds());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    assertSame(json.overlayParameters, overlayParametersResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo ImmutableOverlayDiagramAppComplexityWidgetInfo.fromJson(Json)"
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
    json.setOverlayParameters(ImmutableAppComplexityWidgetParameters.builder().build());

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.fromJson(json);

    // Assert
    AppComplexityWidgetParameters overlayParametersResult =
        actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppComplexityWidgetParameters);
    Set<AssessmentBasedSelectionFilter> assessmentBasedSelectionFiltersResult =
        actualFromJsonResult.assessmentBasedSelectionFilters();
    assertTrue(assessmentBasedSelectionFiltersResult.isEmpty());
    assertSame(assessmentBasedSelectionFiltersResult, overlayParametersResult.complexityKindIds());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    assertSame(json.overlayParameters, overlayParametersResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return assessmentBasedSelectionFilters is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo ImmutableOverlayDiagramAppComplexityWidgetInfo.fromJson(Json)"
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
    json.setOverlayParameters(ImmutableAppComplexityWidgetParameters.builder().build());

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.fromJson(json);

    // Assert
    AppComplexityWidgetParameters overlayParametersResult =
        actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppComplexityWidgetParameters);
    assertTrue(overlayParametersResult.complexityKindIds().isEmpty());
    assertEquals(
        assessmentBasedSelectionFilters, actualFromJsonResult.assessmentBasedSelectionFilters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo ImmutableOverlayDiagramAppComplexityWidgetInfo.fromJson(Json)"
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
    json.setOverlayParameters(ImmutableAppComplexityWidgetParameters.builder().build());

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.fromJson(json);

    // Assert
    AppComplexityWidgetParameters overlayParametersResult =
        actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppComplexityWidgetParameters);
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    assertTrue(overlayParametersResult.complexityKindIds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAppComplexityWidgetInfo#toString()}
   *   <li>{@link ImmutableOverlayDiagramAppComplexityWidgetInfo#assessmentBasedSelectionFilters()}
   *   <li>{@link ImmutableOverlayDiagramAppComplexityWidgetInfo#idSelectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableOverlayDiagramAppComplexityWidgetInfo.assessmentBasedSelectionFilters()",
    "IdSelectionOptions ImmutableOverlayDiagramAppComplexityWidgetInfo.idSelectionOptions()",
    "String ImmutableOverlayDiagramAppComplexityWidgetInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    // Act
    String actualToStringResult = immutableOverlayDiagramAppComplexityWidgetInfo.toString();
    Set<AssessmentBasedSelectionFilter> actualAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAppComplexityWidgetInfo.assessmentBasedSelectionFilters();

    // Assert
    assertTrue(
        immutableOverlayDiagramAppComplexityWidgetInfo.idSelectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "OverlayDiagramAppComplexityWidgetInfo{idSelectionOptions=IdSelectionOptions{entityReference=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses"
            + "=[], filters=SelectionFilters{omitApplicationKinds=[]}}, assessmentBasedSelectionFilters=[],"
            + " overlayParameters=AppComplexityWidgetParameters{complexityKindIds=[]}}",
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
  @MethodsUnderTest({"AppComplexityWidgetParameters Json.overlayParameters()"})
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#overlayParameters()}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#overlayParameters()}
   */
  @Test
  @DisplayName("Test overlayParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppComplexityWidgetParameters ImmutableOverlayDiagramAppComplexityWidgetInfo.overlayParameters()"
  })
  void testOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    AppComplexityWidgetParameters actualOverlayParametersResult =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build()
            .overlayParameters();

    // Assert
    assertTrue(actualOverlayParametersResult instanceof ImmutableAppComplexityWidgetParameters);
    assertTrue(actualOverlayParametersResult.complexityKindIds().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code AssessmentBasedSelectionFilter[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'AssessmentBasedSelectionFilter[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo ImmutableOverlayDiagramAppComplexityWidgetInfo.withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testWithAssessmentBasedSelectionFiltersWithAssessmentBasedSelectionFilter() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualWithAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAppComplexityWidgetInfo.withAssessmentBasedSelectionFilters(
            ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Assert
    IdSelectionOptions idSelectionOptionsResult =
        actualWithAssessmentBasedSelectionFiltersResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AppComplexityWidgetParameters overlayParametersResult =
        actualWithAssessmentBasedSelectionFiltersResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppComplexityWidgetParameters);
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
    assertTrue(overlayParametersResult.complexityKindIds().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo ImmutableOverlayDiagramAppComplexityWidgetInfo.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
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
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualWithIdSelectionOptionsResult =
        immutableOverlayDiagramAppComplexityWidgetInfo.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(
        immutableOverlayDiagramAppComplexityWidgetInfo, actualWithIdSelectionOptionsResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#withOverlayParameters(AppComplexityWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppComplexityWidgetInfo#withOverlayParameters(AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName("Test withOverlayParameters(AppComplexityWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppComplexityWidgetInfo ImmutableOverlayDiagramAppComplexityWidgetInfo.withOverlayParameters(AppComplexityWidgetParameters)"
  })
  void testWithOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppComplexityWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppComplexityWidgetInfo immutableOverlayDiagramAppComplexityWidgetInfo =
        builderResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(ImmutableAppComplexityWidgetParameters.builder().build())
            .build();

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualWithOverlayParametersResult =
        immutableOverlayDiagramAppComplexityWidgetInfo.withOverlayParameters(
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    assertEquals(immutableOverlayDiagramAppComplexityWidgetInfo, actualWithOverlayParametersResult);
  }
}
