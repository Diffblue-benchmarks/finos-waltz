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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppCostWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppCostWidgetParameters;
import org.finos.waltz.web.json.ImmutableOverlayDiagramAppCostWidgetInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAppCostWidgetInfoDiffblueTest {
  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo.Builder ImmutableOverlayDiagramAppCostWidgetInfo.Builder.addAllAssessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAddAllAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder
        actualAddAllAssessmentBasedSelectionFiltersResult =
            builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   * with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo.Builder ImmutableOverlayDiagramAppCostWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElement_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo.Builder ImmutableOverlayDiagramAppCostWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElements_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo.Builder ImmutableOverlayDiagramAppCostWidgetInfo.Builder.assessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder actualAssessmentBasedSelectionFiltersResult =
        builderResult.assessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo ImmutableOverlayDiagramAppCostWidgetInfo.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder actualBuilderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();
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
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder actualIdSelectionOptionsResult =
        actualBuilderResult.idSelectionOptions(idSelectionOptions);
    ImmutableAppCostWidgetParameters overlayParameters =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();
    ImmutableOverlayDiagramAppCostWidgetInfo actualImmutableOverlayDiagramAppCostWidgetInfo =
        actualIdSelectionOptionsResult.overlayParameters(overlayParameters).build();

    // Assert
    assertTrue(
        actualImmutableOverlayDiagramAppCostWidgetInfo.assessmentBasedSelectionFilters().isEmpty());
    assertSame(
        idSelectionOptions, actualImmutableOverlayDiagramAppCostWidgetInfo.idSelectionOptions());
    assertSame(
        overlayParameters, actualImmutableOverlayDiagramAppCostWidgetInfo.overlayParameters());
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#from(OverlayDiagramAppCostWidgetInfo)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#from(OverlayDiagramAppCostWidgetInfo)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramAppCostWidgetInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo.Builder ImmutableOverlayDiagramAppCostWidgetInfo.Builder.from(OverlayDiagramAppCostWidgetInfo)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAppCostWidgetInfo actualImmutableOverlayDiagramAppCostWidgetInfo =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAppCostWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#from(OverlayDiagramAppCostWidgetInfo)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#from(OverlayDiagramAppCostWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramAppCostWidgetInfo); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo.Builder ImmutableOverlayDiagramAppCostWidgetInfo.Builder.from(OverlayDiagramAppCostWidgetInfo)"
  })
  void testBuilderFrom_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();
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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAppCostWidgetInfo actualImmutableOverlayDiagramAppCostWidgetInfo =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAppCostWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo.Builder ImmutableOverlayDiagramAppCostWidgetInfo.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#overlayParameters(AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>When {@link AppCostWidgetParameters}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo.Builder#overlayParameters(AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder overlayParameters(AppCostWidgetParameters); when AppCostWidgetParameters; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo.Builder ImmutableOverlayDiagramAppCostWidgetInfo.Builder.overlayParameters(AppCostWidgetParameters)"
  })
  void testBuilderOverlayParameters_whenAppCostWidgetParameters_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder actualOverlayParametersResult =
        builderResult.overlayParameters(mock(AppCostWidgetParameters.class));

    // Assert
    assertSame(builderResult, actualOverlayParametersResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#copyOf(OverlayDiagramAppCostWidgetInfo)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo#copyOf(OverlayDiagramAppCostWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OverlayDiagramAppCostWidgetInfo); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo ImmutableOverlayDiagramAppCostWidgetInfo.copyOf(OverlayDiagramAppCostWidgetInfo)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualCopyOfResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 = actualCopyOfResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AppCostWidgetParameters overlayParametersResult = actualCopyOfResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppCostWidgetParameters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, overlayParametersResult.allocationSchemeId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult2.scope());
    assertTrue(idSelectionOptionsResult2.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    Set<AssessmentBasedSelectionFilter> assessmentBasedSelectionFiltersResult =
        actualCopyOfResult.assessmentBasedSelectionFilters();
    assertTrue(assessmentBasedSelectionFiltersResult.isEmpty());
    assertSame(assessmentBasedSelectionFiltersResult, overlayParametersResult.costKindIds());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAppCostWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCostWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo2 =
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAppCostWidgetInfo, immutableOverlayDiagramAppCostWidgetInfo2);
    assertEquals(
        immutableOverlayDiagramAppCostWidgetInfo.hashCode(),
        immutableOverlayDiagramAppCostWidgetInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAppCostWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCostWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAppCostWidgetInfo, immutableOverlayDiagramAppCostWidgetInfo);
    int expectedHashCodeResult = immutableOverlayDiagramAppCostWidgetInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableOverlayDiagramAppCostWidgetInfo.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCostWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();
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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAppCostWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCostWidgetInfo.hashCode()"
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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder()
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build());
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAppCostWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCostWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult =
        ImmutableAppCostWidgetParameters.builder();
    builderResult.addCostKindIds(1L);
    ImmutableAppCostWidgetParameters overlayParameters =
        builderResult.allocationSchemeId(1L).build();

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo =
        builderResult2
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .overlayParameters(overlayParameters)
            .build();

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult4 =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult4.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAppCostWidgetInfo,
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCostWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCostWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build(),
        "Different type to ImmutableOverlayDiagramAppCostWidgetInfo");
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AssessmentBasedSelectionFilters is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AssessmentBasedSelectionFilters is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo ImmutableOverlayDiagramAppCostWidgetInfo.fromJson(Json)"
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
    json.setOverlayParameters(
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo ImmutableOverlayDiagramAppCostWidgetInfo.fromJson(Json)"
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
    json.setOverlayParameters(
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return assessmentBasedSelectionFilters is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo ImmutableOverlayDiagramAppCostWidgetInfo.fromJson(Json)"
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
    json.setOverlayParameters(
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.fromJson(json);

    // Assert
    AppCostWidgetParameters overlayParametersResult = actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppCostWidgetParameters);
    assertTrue(overlayParametersResult.costKindIds().isEmpty());
    assertEquals(
        assessmentBasedSelectionFilters, actualFromJsonResult.assessmentBasedSelectionFilters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo ImmutableOverlayDiagramAppCostWidgetInfo.fromJson(Json)"
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
    json.setOverlayParameters(
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.fromJson(json);

    // Assert
    AppCostWidgetParameters overlayParametersResult = actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppCostWidgetParameters);
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    assertTrue(overlayParametersResult.costKindIds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAppCostWidgetInfo#toString()}
   *   <li>{@link ImmutableOverlayDiagramAppCostWidgetInfo#assessmentBasedSelectionFilters()}
   *   <li>{@link ImmutableOverlayDiagramAppCostWidgetInfo#idSelectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableOverlayDiagramAppCostWidgetInfo.assessmentBasedSelectionFilters()",
    "IdSelectionOptions ImmutableOverlayDiagramAppCostWidgetInfo.idSelectionOptions()",
    "String ImmutableOverlayDiagramAppCostWidgetInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    // Act
    String actualToStringResult = immutableOverlayDiagramAppCostWidgetInfo.toString();
    Set<AssessmentBasedSelectionFilter> actualAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAppCostWidgetInfo.assessmentBasedSelectionFilters();

    // Assert
    assertTrue(
        immutableOverlayDiagramAppCostWidgetInfo.idSelectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "OverlayDiagramAppCostWidgetInfo{idSelectionOptions=IdSelectionOptions{entityReference=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses"
            + "=[], filters=SelectionFilters{omitApplicationKinds=[]}}, assessmentBasedSelectionFilters=[],"
            + " overlayParameters=AppCostWidgetParameters{allocationSchemeId=1, costKindIds=[]}}",
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
  @MethodsUnderTest({"AppCostWidgetParameters Json.overlayParameters()"})
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCostWidgetInfo#overlayParameters()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCostWidgetInfo#overlayParameters()}
   */
  @Test
  @DisplayName("Test overlayParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppCostWidgetParameters ImmutableOverlayDiagramAppCostWidgetInfo.overlayParameters()"
  })
  void testOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act
    AppCostWidgetParameters actualOverlayParametersResult =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build()
            .overlayParameters();

    // Assert
    assertTrue(actualOverlayParametersResult instanceof ImmutableAppCostWidgetParameters);
    assertEquals(1L, actualOverlayParametersResult.allocationSchemeId().longValue());
    assertTrue(actualOverlayParametersResult.costKindIds().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code AssessmentBasedSelectionFilter[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'AssessmentBasedSelectionFilter[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo ImmutableOverlayDiagramAppCostWidgetInfo.withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testWithAssessmentBasedSelectionFiltersWithAssessmentBasedSelectionFilter() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualWithAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAppCostWidgetInfo.withAssessmentBasedSelectionFilters(
            ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 =
        actualWithAssessmentBasedSelectionFiltersResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AppCostWidgetParameters overlayParametersResult =
        actualWithAssessmentBasedSelectionFiltersResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppCostWidgetParameters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        1,
        actualWithAssessmentBasedSelectionFiltersResult.assessmentBasedSelectionFilters().size());
    assertEquals(1L, overlayParametersResult.allocationSchemeId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult2.scope());
    assertTrue(idSelectionOptionsResult2.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(overlayParametersResult.costKindIds().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo ImmutableOverlayDiagramAppCostWidgetInfo.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
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
    ImmutableOverlayDiagramAppCostWidgetInfo actualWithIdSelectionOptionsResult =
        immutableOverlayDiagramAppCostWidgetInfo.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableOverlayDiagramAppCostWidgetInfo, actualWithIdSelectionOptionsResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo#withOverlayParameters(AppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCostWidgetInfo#withOverlayParameters(AppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test withOverlayParameters(AppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCostWidgetInfo ImmutableOverlayDiagramAppCostWidgetInfo.withOverlayParameters(AppCostWidgetParameters)"
  })
  void testWithOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCostWidgetInfo immutableOverlayDiagramAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualWithOverlayParametersResult =
        immutableOverlayDiagramAppCostWidgetInfo.withOverlayParameters(
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    assertEquals(immutableOverlayDiagramAppCostWidgetInfo, actualWithOverlayParametersResult);
  }
}
