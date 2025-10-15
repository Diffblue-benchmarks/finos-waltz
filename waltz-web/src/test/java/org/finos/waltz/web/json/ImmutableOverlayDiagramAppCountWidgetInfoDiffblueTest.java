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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppCountWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppCountWidgetParameters;
import org.finos.waltz.web.json.ImmutableOverlayDiagramAppCountWidgetInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAppCountWidgetInfoDiffblueTest {
  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo.Builder ImmutableOverlayDiagramAppCountWidgetInfo.Builder.addAllAssessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAddAllAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder
        actualAddAllAssessmentBasedSelectionFiltersResult =
            builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   * with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo.Builder ImmutableOverlayDiagramAppCountWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElement_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo.Builder ImmutableOverlayDiagramAppCountWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElements_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo.Builder ImmutableOverlayDiagramAppCountWidgetInfo.Builder.assessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder actualAssessmentBasedSelectionFiltersResult =
        builderResult.assessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link ImmutableOverlayDiagramAppCountWidgetInfo.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo ImmutableOverlayDiagramAppCountWidgetInfo.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder actualBuilderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();
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
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder actualIdSelectionOptionsResult =
        actualBuilderResult.idSelectionOptions(idSelectionOptions);
    ImmutableAppCountWidgetParameters overlayParameters =
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();
    ImmutableOverlayDiagramAppCountWidgetInfo actualImmutableOverlayDiagramAppCountWidgetInfo =
        actualIdSelectionOptionsResult.overlayParameters(overlayParameters).build();

    // Assert
    assertTrue(
        actualImmutableOverlayDiagramAppCountWidgetInfo
            .assessmentBasedSelectionFilters()
            .isEmpty());
    assertSame(
        idSelectionOptions, actualImmutableOverlayDiagramAppCountWidgetInfo.idSelectionOptions());
    assertSame(
        overlayParameters, actualImmutableOverlayDiagramAppCountWidgetInfo.overlayParameters());
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#from(OverlayDiagramAppCountWidgetInfo)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#from(OverlayDiagramAppCountWidgetInfo)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramAppCountWidgetInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo.Builder ImmutableOverlayDiagramAppCountWidgetInfo.Builder.from(OverlayDiagramAppCountWidgetInfo)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAppCountWidgetInfo actualImmutableOverlayDiagramAppCountWidgetInfo =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAppCountWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#from(OverlayDiagramAppCountWidgetInfo)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#from(OverlayDiagramAppCountWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramAppCountWidgetInfo); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo.Builder ImmutableOverlayDiagramAppCountWidgetInfo.Builder.from(OverlayDiagramAppCountWidgetInfo)"
  })
  void testBuilderFrom_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();
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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAppCountWidgetInfo actualImmutableOverlayDiagramAppCountWidgetInfo =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAppCountWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo.Builder ImmutableOverlayDiagramAppCountWidgetInfo.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#overlayParameters(AppCountWidgetParameters)}.
   *
   * <ul>
   *   <li>When {@link AppCountWidgetParameters}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo.Builder#overlayParameters(AppCountWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder overlayParameters(AppCountWidgetParameters); when AppCountWidgetParameters; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo.Builder ImmutableOverlayDiagramAppCountWidgetInfo.Builder.overlayParameters(AppCountWidgetParameters)"
  })
  void testBuilderOverlayParameters_whenAppCountWidgetParameters_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder actualOverlayParametersResult =
        builderResult.overlayParameters(mock(AppCountWidgetParameters.class));

    // Assert
    assertSame(builderResult, actualOverlayParametersResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo#copyOf(OverlayDiagramAppCountWidgetInfo)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo#copyOf(OverlayDiagramAppCountWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OverlayDiagramAppCountWidgetInfo); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo ImmutableOverlayDiagramAppCountWidgetInfo.copyOf(OverlayDiagramAppCountWidgetInfo)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableOverlayDiagramAppCountWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder().targetDate(targetDate).build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo actualCopyOfResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 = actualCopyOfResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AppCountWidgetParameters overlayParametersResult = actualCopyOfResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppCountWidgetParameters);
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
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAppCountWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCountWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCountWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo2 =
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAppCountWidgetInfo, immutableOverlayDiagramAppCountWidgetInfo2);
    assertEquals(
        immutableOverlayDiagramAppCountWidgetInfo.hashCode(),
        immutableOverlayDiagramAppCountWidgetInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAppCountWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCountWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCountWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAppCountWidgetInfo, immutableOverlayDiagramAppCountWidgetInfo);
    int expectedHashCodeResult = immutableOverlayDiagramAppCountWidgetInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableOverlayDiagramAppCountWidgetInfo.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCountWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCountWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();
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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAppCountWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCountWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCountWidgetInfo.hashCode()"
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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder()
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build());
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAppCountWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCountWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCountWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.now()).build())
            .build();

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAppCountWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCountWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCountWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAppCountWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAppCountWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build(),
        "Different type to ImmutableOverlayDiagramAppCountWidgetInfo");
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AssessmentBasedSelectionFilters is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AssessmentBasedSelectionFilters is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo ImmutableOverlayDiagramAppCountWidgetInfo.fromJson(Json)"
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
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build());

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppCountWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo ImmutableOverlayDiagramAppCountWidgetInfo.fromJson(Json)"
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
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build());

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppCountWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return assessmentBasedSelectionFilters is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo ImmutableOverlayDiagramAppCountWidgetInfo.fromJson(Json)"
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
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build());

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.fromJson(json);

    // Assert
    assertEquals(
        assessmentBasedSelectionFilters, actualFromJsonResult.assessmentBasedSelectionFilters());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppCountWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo ImmutableOverlayDiagramAppCountWidgetInfo.fromJson(Json)"
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
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build());

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppCountWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAppCountWidgetInfo#toString()}
   *   <li>{@link ImmutableOverlayDiagramAppCountWidgetInfo#assessmentBasedSelectionFilters()}
   *   <li>{@link ImmutableOverlayDiagramAppCountWidgetInfo#idSelectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableOverlayDiagramAppCountWidgetInfo.assessmentBasedSelectionFilters()",
    "IdSelectionOptions ImmutableOverlayDiagramAppCountWidgetInfo.idSelectionOptions()",
    "String ImmutableOverlayDiagramAppCountWidgetInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableOverlayDiagramAppCountWidgetInfo.toString();
    Set<AssessmentBasedSelectionFilter> actualAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAppCountWidgetInfo.assessmentBasedSelectionFilters();

    // Assert
    assertTrue(
        immutableOverlayDiagramAppCountWidgetInfo.idSelectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "OverlayDiagramAppCountWidgetInfo{idSelectionOptions=IdSelectionOptions{entityReference=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses"
            + "=[], filters=SelectionFilters{omitApplicationKinds=[]}}, assessmentBasedSelectionFilters=[],"
            + " overlayParameters=AppCountWidgetParameters{targetDate=1970-01-01}}",
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
  @MethodsUnderTest({"AppCountWidgetParameters Json.overlayParameters()"})
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAppCountWidgetInfo#overlayParameters()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAppCountWidgetInfo#overlayParameters()}
   */
  @Test
  @DisplayName("Test overlayParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppCountWidgetParameters ImmutableOverlayDiagramAppCountWidgetInfo.overlayParameters()"
  })
  void testOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    AppCountWidgetParameters actualOverlayParametersResult =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder().targetDate(targetDate).build())
            .build()
            .overlayParameters();

    // Assert
    assertTrue(actualOverlayParametersResult instanceof ImmutableAppCountWidgetParameters);
    LocalDate targetDateResult = actualOverlayParametersResult.targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code AssessmentBasedSelectionFilter[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'AssessmentBasedSelectionFilter[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo ImmutableOverlayDiagramAppCountWidgetInfo.withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testWithAssessmentBasedSelectionFiltersWithAssessmentBasedSelectionFilter() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder().targetDate(targetDate).build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo actualWithAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAppCountWidgetInfo.withAssessmentBasedSelectionFilters(
            ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 =
        actualWithAssessmentBasedSelectionFiltersResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AppCountWidgetParameters overlayParametersResult =
        actualWithAssessmentBasedSelectionFiltersResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAppCountWidgetParameters);
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
   * ImmutableOverlayDiagramAppCountWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo ImmutableOverlayDiagramAppCountWidgetInfo.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
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
    ImmutableOverlayDiagramAppCountWidgetInfo actualWithIdSelectionOptionsResult =
        immutableOverlayDiagramAppCountWidgetInfo.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableOverlayDiagramAppCountWidgetInfo, actualWithIdSelectionOptionsResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo#withOverlayParameters(AppCountWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAppCountWidgetInfo#withOverlayParameters(AppCountWidgetParameters)}
   */
  @Test
  @DisplayName("Test withOverlayParameters(AppCountWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAppCountWidgetInfo ImmutableOverlayDiagramAppCountWidgetInfo.withOverlayParameters(AppCountWidgetParameters)"
  })
  void testWithOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAppCountWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAppCountWidgetInfo.builder();

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

    ImmutableOverlayDiagramAppCountWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAppCountWidgetInfo immutableOverlayDiagramAppCountWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAppCountWidgetParameters.builder()
                    .targetDate(LocalDate.of(1970, 1, 1))
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAppCountWidgetInfo actualWithOverlayParametersResult =
        immutableOverlayDiagramAppCountWidgetInfo.withOverlayParameters(
            ImmutableAppCountWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    assertEquals(immutableOverlayDiagramAppCountWidgetInfo, actualWithOverlayParametersResult);
  }
}
