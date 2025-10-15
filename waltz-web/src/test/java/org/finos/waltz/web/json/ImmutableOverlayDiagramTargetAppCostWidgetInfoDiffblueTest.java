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
import java.time.LocalDate;
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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableTargetAppCostWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.TargetAppCostWidgetParameters;
import org.finos.waltz.web.json.ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramTargetAppCostWidgetInfoDiffblueTest {
  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder.addAllAssessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAddAllAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder
        actualAddAllAssessmentBasedSelectionFiltersResult =
            builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   * with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElement_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElements_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder.assessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder
        actualAssessmentBasedSelectionFiltersResult =
            builderResult.assessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder actualBuilderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();
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
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder actualIdSelectionOptionsResult =
        actualBuilderResult.idSelectionOptions(idSelectionOptions);
    ImmutableTargetAppCostWidgetParameters overlayParameters =
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();
    ImmutableOverlayDiagramTargetAppCostWidgetInfo
        actualImmutableOverlayDiagramTargetAppCostWidgetInfo =
            actualIdSelectionOptionsResult.overlayParameters(overlayParameters).build();

    // Assert
    assertTrue(
        actualImmutableOverlayDiagramTargetAppCostWidgetInfo
            .assessmentBasedSelectionFilters()
            .isEmpty());
    assertSame(
        idSelectionOptions,
        actualImmutableOverlayDiagramTargetAppCostWidgetInfo.idSelectionOptions());
    assertSame(
        overlayParameters,
        actualImmutableOverlayDiagramTargetAppCostWidgetInfo.overlayParameters());
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#from(OverlayDiagramTargetAppCostWidgetInfo)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#from(OverlayDiagramTargetAppCostWidgetInfo)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramTargetAppCostWidgetInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder.from(OverlayDiagramTargetAppCostWidgetInfo)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramTargetAppCostWidgetInfo
        actualImmutableOverlayDiagramTargetAppCostWidgetInfo = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramTargetAppCostWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#from(OverlayDiagramTargetAppCostWidgetInfo)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#from(OverlayDiagramTargetAppCostWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramTargetAppCostWidgetInfo); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder.from(OverlayDiagramTargetAppCostWidgetInfo)"
  })
  void testBuilderFrom_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();
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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramTargetAppCostWidgetInfo
        actualImmutableOverlayDiagramTargetAppCostWidgetInfo = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramTargetAppCostWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#overlayParameters(TargetAppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>When {@link TargetAppCostWidgetParameters}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#overlayParameters(TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder overlayParameters(TargetAppCostWidgetParameters); when TargetAppCostWidgetParameters; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder.overlayParameters(TargetAppCostWidgetParameters)"
  })
  void testBuilderOverlayParameters_whenTargetAppCostWidgetParameters_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder actualOverlayParametersResult =
        builderResult.overlayParameters(mock(TargetAppCostWidgetParameters.class));

    // Assert
    assertSame(builderResult, actualOverlayParametersResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#copyOf(OverlayDiagramTargetAppCostWidgetInfo)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#copyOf(OverlayDiagramTargetAppCostWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OverlayDiagramTargetAppCostWidgetInfo); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo ImmutableOverlayDiagramTargetAppCostWidgetInfo.copyOf(OverlayDiagramTargetAppCostWidgetInfo)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableOverlayDiagramTargetAppCostWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder().targetDate(targetDate).build())
            .build();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualCopyOfResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 = actualCopyOfResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    TargetAppCostWidgetParameters overlayParametersResult = actualCopyOfResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableTargetAppCostWidgetParameters);
    LocalDate targetDateResult = overlayParametersResult.targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult2.scope());
    assertTrue(idSelectionOptionsResult2.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualCopyOfResult.assessmentBasedSelectionFilters().isEmpty());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramTargetAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramTargetAppCostWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo2 =
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramTargetAppCostWidgetInfo,
        immutableOverlayDiagramTargetAppCostWidgetInfo2);
    assertEquals(
        immutableOverlayDiagramTargetAppCostWidgetInfo.hashCode(),
        immutableOverlayDiagramTargetAppCostWidgetInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramTargetAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramTargetAppCostWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramTargetAppCostWidgetInfo,
        immutableOverlayDiagramTargetAppCostWidgetInfo);
    int expectedHashCodeResult = immutableOverlayDiagramTargetAppCostWidgetInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableOverlayDiagramTargetAppCostWidgetInfo.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramTargetAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramTargetAppCostWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();
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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramTargetAppCostWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramTargetAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramTargetAppCostWidgetInfo.hashCode()"
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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder()
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramTargetAppCostWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramTargetAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramTargetAppCostWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.now())
                    .build())
            .build();

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramTargetAppCostWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramTargetAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramTargetAppCostWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramTargetAppCostWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramTargetAppCostWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build(),
        "Different type to ImmutableOverlayDiagramTargetAppCostWidgetInfo");
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AssessmentBasedSelectionFilters is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AssessmentBasedSelectionFilters is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo ImmutableOverlayDiagramTargetAppCostWidgetInfo.fromJson(Json)"
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
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    TargetAppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo ImmutableOverlayDiagramTargetAppCostWidgetInfo.fromJson(Json)"
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
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    TargetAppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return assessmentBasedSelectionFilters is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo ImmutableOverlayDiagramTargetAppCostWidgetInfo.fromJson(Json)"
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
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.fromJson(json);

    // Assert
    assertEquals(
        assessmentBasedSelectionFilters, actualFromJsonResult.assessmentBasedSelectionFilters());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    TargetAppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo ImmutableOverlayDiagramTargetAppCostWidgetInfo.fromJson(Json)"
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
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    TargetAppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#toString()}
   *   <li>{@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#assessmentBasedSelectionFilters()}
   *   <li>{@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#idSelectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableOverlayDiagramTargetAppCostWidgetInfo.assessmentBasedSelectionFilters()",
    "IdSelectionOptions ImmutableOverlayDiagramTargetAppCostWidgetInfo.idSelectionOptions()",
    "String ImmutableOverlayDiagramTargetAppCostWidgetInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableOverlayDiagramTargetAppCostWidgetInfo.toString();
    Set<AssessmentBasedSelectionFilter> actualAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramTargetAppCostWidgetInfo.assessmentBasedSelectionFilters();

    // Assert
    assertTrue(
        immutableOverlayDiagramTargetAppCostWidgetInfo.idSelectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "OverlayDiagramTargetAppCostWidgetInfo{idSelectionOptions=IdSelectionOptions{entityReference=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses"
            + "=[], filters=SelectionFilters{omitApplicationKinds=[]}}, assessmentBasedSelectionFilters=[],"
            + " overlayParameters=TargetAppCostWidgetParameters{targetDate=1970-01-01}}",
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
  @MethodsUnderTest({"TargetAppCostWidgetParameters Json.overlayParameters()"})
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#overlayParameters()}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#overlayParameters()}
   */
  @Test
  @DisplayName("Test overlayParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TargetAppCostWidgetParameters ImmutableOverlayDiagramTargetAppCostWidgetInfo.overlayParameters()"
  })
  void testOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    TargetAppCostWidgetParameters actualOverlayParametersResult =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder().targetDate(targetDate).build())
            .build()
            .overlayParameters();

    // Assert
    assertTrue(actualOverlayParametersResult instanceof ImmutableTargetAppCostWidgetParameters);
    LocalDate targetDateResult = actualOverlayParametersResult.targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code AssessmentBasedSelectionFilter[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'AssessmentBasedSelectionFilter[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo ImmutableOverlayDiagramTargetAppCostWidgetInfo.withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testWithAssessmentBasedSelectionFiltersWithAssessmentBasedSelectionFilter() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder().targetDate(targetDate).build())
            .build();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualWithAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramTargetAppCostWidgetInfo.withAssessmentBasedSelectionFilters(
            ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 =
        actualWithAssessmentBasedSelectionFiltersResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    TargetAppCostWidgetParameters overlayParametersResult =
        actualWithAssessmentBasedSelectionFiltersResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableTargetAppCostWidgetParameters);
    LocalDate targetDateResult = overlayParametersResult.targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        1,
        actualWithAssessmentBasedSelectionFiltersResult.assessmentBasedSelectionFilters().size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult2.scope());
    assertTrue(idSelectionOptionsResult2.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo ImmutableOverlayDiagramTargetAppCostWidgetInfo.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualWithIdSelectionOptionsResult =
        immutableOverlayDiagramTargetAppCostWidgetInfo.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(
        immutableOverlayDiagramTargetAppCostWidgetInfo, actualWithIdSelectionOptionsResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#withOverlayParameters(TargetAppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramTargetAppCostWidgetInfo#withOverlayParameters(TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test withOverlayParameters(TargetAppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramTargetAppCostWidgetInfo ImmutableOverlayDiagramTargetAppCostWidgetInfo.withOverlayParameters(TargetAppCostWidgetParameters)"
  })
  void testWithOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramTargetAppCostWidgetInfo.builder();

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

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramTargetAppCostWidgetInfo immutableOverlayDiagramTargetAppCostWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableTargetAppCostWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualWithOverlayParametersResult =
        immutableOverlayDiagramTargetAppCostWidgetInfo.withOverlayParameters(
            ImmutableTargetAppCostWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    assertEquals(immutableOverlayDiagramTargetAppCostWidgetInfo, actualWithOverlayParametersResult);
  }
}
