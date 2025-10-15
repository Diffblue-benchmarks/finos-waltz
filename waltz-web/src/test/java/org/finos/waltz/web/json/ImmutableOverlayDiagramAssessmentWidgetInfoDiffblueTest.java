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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AssessmentWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAssessmentWidgetParameters;
import org.finos.waltz.web.json.ImmutableOverlayDiagramAssessmentWidgetInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAssessmentWidgetInfoDiffblueTest {
  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo.Builder ImmutableOverlayDiagramAssessmentWidgetInfo.Builder.addAllAssessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAddAllAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder
        actualAddAllAssessmentBasedSelectionFiltersResult =
            builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   * with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo.Builder ImmutableOverlayDiagramAssessmentWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElement_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo.Builder ImmutableOverlayDiagramAssessmentWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElements_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo.Builder ImmutableOverlayDiagramAssessmentWidgetInfo.Builder.assessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder
        actualAssessmentBasedSelectionFiltersResult =
            builderResult.assessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo ImmutableOverlayDiagramAssessmentWidgetInfo.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder actualBuilderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();
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
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder actualIdSelectionOptionsResult =
        actualBuilderResult.idSelectionOptions(idSelectionOptions);
    ImmutableAssessmentWidgetParameters overlayParameters =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();
    ImmutableOverlayDiagramAssessmentWidgetInfo actualImmutableOverlayDiagramAssessmentWidgetInfo =
        actualIdSelectionOptionsResult.overlayParameters(overlayParameters).build();

    // Assert
    AssessmentWidgetParameters overlayParametersResult =
        actualImmutableOverlayDiagramAssessmentWidgetInfo.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAssessmentWidgetParameters);
    assertTrue(
        actualImmutableOverlayDiagramAssessmentWidgetInfo
            .assessmentBasedSelectionFilters()
            .isEmpty());
    assertSame(
        idSelectionOptions, actualImmutableOverlayDiagramAssessmentWidgetInfo.idSelectionOptions());
    assertSame(overlayParameters, overlayParametersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#from(OverlayDiagramAssessmentWidgetInfo)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#from(OverlayDiagramAssessmentWidgetInfo)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramAssessmentWidgetInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo.Builder ImmutableOverlayDiagramAssessmentWidgetInfo.Builder.from(OverlayDiagramAssessmentWidgetInfo)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAssessmentWidgetInfo actualImmutableOverlayDiagramAssessmentWidgetInfo =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAssessmentWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#from(OverlayDiagramAssessmentWidgetInfo)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#from(OverlayDiagramAssessmentWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramAssessmentWidgetInfo); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo.Builder ImmutableOverlayDiagramAssessmentWidgetInfo.Builder.from(OverlayDiagramAssessmentWidgetInfo)"
  })
  void testBuilderFrom_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();
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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAssessmentWidgetInfo actualImmutableOverlayDiagramAssessmentWidgetInfo =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAssessmentWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo.Builder ImmutableOverlayDiagramAssessmentWidgetInfo.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#overlayParameters(AssessmentWidgetParameters)}.
   *
   * <ul>
   *   <li>When {@link AssessmentWidgetParameters}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo.Builder#overlayParameters(AssessmentWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder overlayParameters(AssessmentWidgetParameters); when AssessmentWidgetParameters; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo.Builder ImmutableOverlayDiagramAssessmentWidgetInfo.Builder.overlayParameters(AssessmentWidgetParameters)"
  })
  void testBuilderOverlayParameters_whenAssessmentWidgetParameters_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder actualOverlayParametersResult =
        builderResult.overlayParameters(mock(AssessmentWidgetParameters.class));

    // Assert
    assertSame(builderResult, actualOverlayParametersResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#copyOf(OverlayDiagramAssessmentWidgetInfo)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#copyOf(OverlayDiagramAssessmentWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OverlayDiagramAssessmentWidgetInfo); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo ImmutableOverlayDiagramAssessmentWidgetInfo.copyOf(OverlayDiagramAssessmentWidgetInfo)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo actualCopyOfResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 = actualCopyOfResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AssessmentWidgetParameters overlayParametersResult = actualCopyOfResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAssessmentWidgetParameters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, overlayParametersResult.assessmentDefinitionId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult2.scope());
    assertTrue(idSelectionOptionsResult2.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualCopyOfResult.assessmentBasedSelectionFilters().isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAssessmentWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAssessmentWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAssessmentWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo2 =
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAssessmentWidgetInfo, immutableOverlayDiagramAssessmentWidgetInfo2);
    assertEquals(
        immutableOverlayDiagramAssessmentWidgetInfo.hashCode(),
        immutableOverlayDiagramAssessmentWidgetInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAssessmentWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAssessmentWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAssessmentWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAssessmentWidgetInfo, immutableOverlayDiagramAssessmentWidgetInfo);
    int expectedHashCodeResult = immutableOverlayDiagramAssessmentWidgetInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableOverlayDiagramAssessmentWidgetInfo.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAssessmentWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAssessmentWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();
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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAssessmentWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAssessmentWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAssessmentWidgetInfo.hashCode()"
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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder()
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAssessmentWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAssessmentWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAssessmentWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(2L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAssessmentWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAssessmentWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAssessmentWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAssessmentWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAssessmentWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build(),
        "Different type to ImmutableOverlayDiagramAssessmentWidgetInfo");
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AssessmentBasedSelectionFilters is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AssessmentBasedSelectionFilters is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo ImmutableOverlayDiagramAssessmentWidgetInfo.fromJson(Json)"
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
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.fromJson(json);

    // Assert
    AssessmentWidgetParameters overlayParametersResult = actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAssessmentWidgetParameters);
    assertEquals(1L, overlayParametersResult.assessmentDefinitionId().longValue());
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    assertSame(json.overlayParameters, overlayParametersResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo ImmutableOverlayDiagramAssessmentWidgetInfo.fromJson(Json)"
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
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.fromJson(json);

    // Assert
    AssessmentWidgetParameters overlayParametersResult = actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAssessmentWidgetParameters);
    assertEquals(1L, overlayParametersResult.assessmentDefinitionId().longValue());
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    assertSame(json.overlayParameters, overlayParametersResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return assessmentBasedSelectionFilters is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo ImmutableOverlayDiagramAssessmentWidgetInfo.fromJson(Json)"
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
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.fromJson(json);

    // Assert
    AssessmentWidgetParameters overlayParametersResult = actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAssessmentWidgetParameters);
    assertEquals(1L, overlayParametersResult.assessmentDefinitionId().longValue());
    assertEquals(
        assessmentBasedSelectionFilters, actualFromJsonResult.assessmentBasedSelectionFilters());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    assertSame(json.overlayParameters, overlayParametersResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo ImmutableOverlayDiagramAssessmentWidgetInfo.fromJson(Json)"
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
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.fromJson(json);

    // Assert
    AssessmentWidgetParameters overlayParametersResult = actualFromJsonResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAssessmentWidgetParameters);
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    assertEquals(1L, overlayParametersResult.assessmentDefinitionId().longValue());
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
   *   <li>{@link ImmutableOverlayDiagramAssessmentWidgetInfo#toString()}
   *   <li>{@link ImmutableOverlayDiagramAssessmentWidgetInfo#assessmentBasedSelectionFilters()}
   *   <li>{@link ImmutableOverlayDiagramAssessmentWidgetInfo#idSelectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableOverlayDiagramAssessmentWidgetInfo.assessmentBasedSelectionFilters()",
    "IdSelectionOptions ImmutableOverlayDiagramAssessmentWidgetInfo.idSelectionOptions()",
    "String ImmutableOverlayDiagramAssessmentWidgetInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableOverlayDiagramAssessmentWidgetInfo.toString();
    Set<AssessmentBasedSelectionFilter> actualAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAssessmentWidgetInfo.assessmentBasedSelectionFilters();

    // Assert
    assertTrue(
        immutableOverlayDiagramAssessmentWidgetInfo.idSelectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "OverlayDiagramAssessmentWidgetInfo{idSelectionOptions=IdSelectionOptions{entityReference=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses"
            + "=[], filters=SelectionFilters{omitApplicationKinds=[]}}, assessmentBasedSelectionFilters=[],"
            + " overlayParameters=AssessmentWidgetParameters{assessmentDefinitionId=1, targetDate=1970-01-01}}",
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
  @MethodsUnderTest({"AssessmentWidgetParameters Json.overlayParameters()"})
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAssessmentWidgetInfo#overlayParameters()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAssessmentWidgetInfo#overlayParameters()}
   */
  @Test
  @DisplayName("Test overlayParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentWidgetParameters ImmutableOverlayDiagramAssessmentWidgetInfo.overlayParameters()"
  })
  void testOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act
    AssessmentWidgetParameters actualOverlayParametersResult =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build()
            .overlayParameters();

    // Assert
    assertTrue(actualOverlayParametersResult instanceof ImmutableAssessmentWidgetParameters);
    assertEquals(1L, actualOverlayParametersResult.assessmentDefinitionId().longValue());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code AssessmentBasedSelectionFilter[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'AssessmentBasedSelectionFilter[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo ImmutableOverlayDiagramAssessmentWidgetInfo.withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testWithAssessmentBasedSelectionFiltersWithAssessmentBasedSelectionFilter() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo actualWithAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAssessmentWidgetInfo.withAssessmentBasedSelectionFilters(
            ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 =
        actualWithAssessmentBasedSelectionFiltersResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AssessmentWidgetParameters overlayParametersResult =
        actualWithAssessmentBasedSelectionFiltersResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAssessmentWidgetParameters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        1,
        actualWithAssessmentBasedSelectionFiltersResult.assessmentBasedSelectionFilters().size());
    assertEquals(1L, overlayParametersResult.assessmentDefinitionId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult2.scope());
    assertTrue(idSelectionOptionsResult2.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo ImmutableOverlayDiagramAssessmentWidgetInfo.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
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
    ImmutableOverlayDiagramAssessmentWidgetInfo actualWithIdSelectionOptionsResult =
        immutableOverlayDiagramAssessmentWidgetInfo.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableOverlayDiagramAssessmentWidgetInfo, actualWithIdSelectionOptionsResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#withOverlayParameters(AssessmentWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAssessmentWidgetInfo#withOverlayParameters(AssessmentWidgetParameters)}
   */
  @Test
  @DisplayName("Test withOverlayParameters(AssessmentWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAssessmentWidgetInfo ImmutableOverlayDiagramAssessmentWidgetInfo.withOverlayParameters(AssessmentWidgetParameters)"
  })
  void testWithOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAssessmentWidgetInfo.builder();

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

    ImmutableOverlayDiagramAssessmentWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAssessmentWidgetInfo immutableOverlayDiagramAssessmentWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAssessmentWidgetParameters.builder()
                    .assessmentDefinitionId(1L)
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAssessmentWidgetInfo actualWithOverlayParametersResult =
        immutableOverlayDiagramAssessmentWidgetInfo.withOverlayParameters(
            ImmutableAssessmentWidgetParameters.builder()
                .assessmentDefinitionId(1L)
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    assertEquals(immutableOverlayDiagramAssessmentWidgetInfo, actualWithOverlayParametersResult);
  }
}
