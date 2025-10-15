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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AttestationWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAttestationWidgetParameters;
import org.finos.waltz.web.json.ImmutableOverlayDiagramAttestationWidgetInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAttestationWidgetInfoDiffblueTest {
  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo.Builder ImmutableOverlayDiagramAttestationWidgetInfo.Builder.addAllAssessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAddAllAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder
        actualAddAllAssessmentBasedSelectionFiltersResult =
            builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   * with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo.Builder ImmutableOverlayDiagramAttestationWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElement_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo.Builder ImmutableOverlayDiagramAttestationWidgetInfo.Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testBuilderAddAssessmentBasedSelectionFiltersWithElements_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder
        actualAddAssessmentBasedSelectionFiltersResult =
            builderResult.addAssessmentBasedSelectionFilters(
                mock(AssessmentBasedSelectionFilter.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo.Builder ImmutableOverlayDiagramAttestationWidgetInfo.Builder.assessmentBasedSelectionFilters(Iterable)"
  })
  void testBuilderAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder
        actualAssessmentBasedSelectionFiltersResult =
            builderResult.assessmentBasedSelectionFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentBasedSelectionFiltersResult);
  }

  /**
   * Test Builder {@link ImmutableOverlayDiagramAttestationWidgetInfo.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo ImmutableOverlayDiagramAttestationWidgetInfo.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder actualBuilderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();
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
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder actualIdSelectionOptionsResult =
        actualBuilderResult.idSelectionOptions(idSelectionOptions);
    ImmutableAttestationWidgetParameters overlayParameters =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();
    ImmutableOverlayDiagramAttestationWidgetInfo
        actualImmutableOverlayDiagramAttestationWidgetInfo =
            actualIdSelectionOptionsResult.overlayParameters(overlayParameters).build();

    // Assert
    assertTrue(
        actualImmutableOverlayDiagramAttestationWidgetInfo
            .assessmentBasedSelectionFilters()
            .isEmpty());
    assertSame(
        idSelectionOptions,
        actualImmutableOverlayDiagramAttestationWidgetInfo.idSelectionOptions());
    assertSame(
        overlayParameters, actualImmutableOverlayDiagramAttestationWidgetInfo.overlayParameters());
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#from(OverlayDiagramAttestationWidgetInfo)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#from(OverlayDiagramAttestationWidgetInfo)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramAttestationWidgetInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo.Builder ImmutableOverlayDiagramAttestationWidgetInfo.Builder.from(OverlayDiagramAttestationWidgetInfo)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAttestationWidgetInfo
        actualImmutableOverlayDiagramAttestationWidgetInfo = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAttestationWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#from(OverlayDiagramAttestationWidgetInfo)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#from(OverlayDiagramAttestationWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramAttestationWidgetInfo); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo.Builder ImmutableOverlayDiagramAttestationWidgetInfo.Builder.from(OverlayDiagramAttestationWidgetInfo)"
  })
  void testBuilderFrom_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();
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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramAttestationWidgetInfo
        actualImmutableOverlayDiagramAttestationWidgetInfo = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramAttestationWidgetInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo.Builder ImmutableOverlayDiagramAttestationWidgetInfo.Builder.idSelectionOptions(IdSelectionOptions)"
  })
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test Builder {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#overlayParameters(AttestationWidgetParameters)}.
   *
   * <ul>
   *   <li>When {@link AttestationWidgetParameters}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo.Builder#overlayParameters(AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder overlayParameters(AttestationWidgetParameters); when AttestationWidgetParameters; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo.Builder ImmutableOverlayDiagramAttestationWidgetInfo.Builder.overlayParameters(AttestationWidgetParameters)"
  })
  void testBuilderOverlayParameters_whenAttestationWidgetParameters_thenReturnBuilder() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder actualOverlayParametersResult =
        builderResult.overlayParameters(mock(AttestationWidgetParameters.class));

    // Assert
    assertSame(builderResult, actualOverlayParametersResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#copyOf(OverlayDiagramAttestationWidgetInfo)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#copyOf(OverlayDiagramAttestationWidgetInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OverlayDiagramAttestationWidgetInfo); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo ImmutableOverlayDiagramAttestationWidgetInfo.copyOf(OverlayDiagramAttestationWidgetInfo)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo instance =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo actualCopyOfResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 = actualCopyOfResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AttestationWidgetParameters overlayParametersResult = actualCopyOfResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAttestationWidgetParameters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, overlayParametersResult.attestedEntityId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, overlayParametersResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult2.scope());
    assertTrue(idSelectionOptionsResult2.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualCopyOfResult.assessmentBasedSelectionFilters().isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAttestationWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAttestationWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAttestationWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo2 =
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAttestationWidgetInfo,
        immutableOverlayDiagramAttestationWidgetInfo2);
    assertEquals(
        immutableOverlayDiagramAttestationWidgetInfo.hashCode(),
        immutableOverlayDiagramAttestationWidgetInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}, and {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramAttestationWidgetInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAttestationWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAttestationWidgetInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramAttestationWidgetInfo, immutableOverlayDiagramAttestationWidgetInfo);
    int expectedHashCodeResult = immutableOverlayDiagramAttestationWidgetInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableOverlayDiagramAttestationWidgetInfo.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAttestationWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAttestationWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();
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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAttestationWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAttestationWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAttestationWidgetInfo.hashCode()"
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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder()
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult2 =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult2.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAttestationWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAttestationWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAttestationWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(2L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult3 =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult2 =
        builderResult3.idSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramAttestationWidgetInfo,
        idSelectionOptionsResult2
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAttestationWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAttestationWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramAttestationWidgetInfo.equals(Object)",
    "int ImmutableOverlayDiagramAttestationWidgetInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act and Assert
    assertNotEquals(
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build(),
        "Different type to ImmutableOverlayDiagramAttestationWidgetInfo");
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AssessmentBasedSelectionFilters is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AssessmentBasedSelectionFilters is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo ImmutableOverlayDiagramAttestationWidgetInfo.fromJson(Json)"
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
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build());

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AttestationWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo ImmutableOverlayDiagramAttestationWidgetInfo.fromJson(Json)"
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
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build());

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentBasedSelectionFilters().isEmpty());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AttestationWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return assessmentBasedSelectionFilters is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo ImmutableOverlayDiagramAttestationWidgetInfo.fromJson(Json)"
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
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build());

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.fromJson(json);

    // Assert
    assertEquals(
        assessmentBasedSelectionFilters, actualFromJsonResult.assessmentBasedSelectionFilters());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AttestationWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentBasedSelectionFilters size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentBasedSelectionFilters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo ImmutableOverlayDiagramAttestationWidgetInfo.fromJson(Json)"
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
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build());

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo actualFromJsonResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AttestationWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramAttestationWidgetInfo#toString()}
   *   <li>{@link ImmutableOverlayDiagramAttestationWidgetInfo#assessmentBasedSelectionFilters()}
   *   <li>{@link ImmutableOverlayDiagramAttestationWidgetInfo#idSelectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableOverlayDiagramAttestationWidgetInfo.assessmentBasedSelectionFilters()",
    "IdSelectionOptions ImmutableOverlayDiagramAttestationWidgetInfo.idSelectionOptions()",
    "String ImmutableOverlayDiagramAttestationWidgetInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableOverlayDiagramAttestationWidgetInfo.toString();
    Set<AssessmentBasedSelectionFilter> actualAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAttestationWidgetInfo.assessmentBasedSelectionFilters();

    // Assert
    assertTrue(
        immutableOverlayDiagramAttestationWidgetInfo.idSelectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "OverlayDiagramAttestationWidgetInfo{idSelectionOptions=IdSelectionOptions{entityReference=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses"
            + "=[], filters=SelectionFilters{omitApplicationKinds=[]}}, assessmentBasedSelectionFilters=[],"
            + " overlayParameters=AttestationWidgetParameters{attestedEntityId=1, attestedEntityKind=ALL}}",
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
  @MethodsUnderTest({"AttestationWidgetParameters Json.overlayParameters()"})
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayParameters());
  }

  /**
   * Test {@link ImmutableOverlayDiagramAttestationWidgetInfo#overlayParameters()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramAttestationWidgetInfo#overlayParameters()}
   */
  @Test
  @DisplayName("Test overlayParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetParameters ImmutableOverlayDiagramAttestationWidgetInfo.overlayParameters()"
  })
  void testOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act
    AttestationWidgetParameters actualOverlayParametersResult =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build()
            .overlayParameters();

    // Assert
    assertTrue(actualOverlayParametersResult instanceof ImmutableAttestationWidgetParameters);
    assertEquals(1L, actualOverlayParametersResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualOverlayParametersResult.attestedEntityKind());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   * with {@code AssessmentBasedSelectionFilter[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'AssessmentBasedSelectionFilter[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo ImmutableOverlayDiagramAttestationWidgetInfo.withAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"
  })
  void testWithAssessmentBasedSelectionFiltersWithAssessmentBasedSelectionFilter() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo actualWithAssessmentBasedSelectionFiltersResult =
        immutableOverlayDiagramAttestationWidgetInfo.withAssessmentBasedSelectionFilters(
            ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Assert
    IdSelectionOptions idSelectionOptionsResult2 =
        actualWithAssessmentBasedSelectionFiltersResult.idSelectionOptions();
    EntityReference entityReferenceResult = idSelectionOptionsResult2.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult2 instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptionsResult2.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    AttestationWidgetParameters overlayParametersResult =
        actualWithAssessmentBasedSelectionFiltersResult.overlayParameters();
    assertTrue(overlayParametersResult instanceof ImmutableAttestationWidgetParameters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        1,
        actualWithAssessmentBasedSelectionFiltersResult.assessmentBasedSelectionFilters().size());
    assertEquals(1L, overlayParametersResult.attestedEntityId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, overlayParametersResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult2.scope());
    assertTrue(idSelectionOptionsResult2.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo ImmutableOverlayDiagramAttestationWidgetInfo.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
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
    ImmutableOverlayDiagramAttestationWidgetInfo actualWithIdSelectionOptionsResult =
        immutableOverlayDiagramAttestationWidgetInfo.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableOverlayDiagramAttestationWidgetInfo, actualWithIdSelectionOptionsResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#withOverlayParameters(AttestationWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramAttestationWidgetInfo#withOverlayParameters(AttestationWidgetParameters)}
   */
  @Test
  @DisplayName("Test withOverlayParameters(AttestationWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramAttestationWidgetInfo ImmutableOverlayDiagramAttestationWidgetInfo.withOverlayParameters(AttestationWidgetParameters)"
  })
  void testWithOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAttestationWidgetInfo.Builder builderResult =
        ImmutableOverlayDiagramAttestationWidgetInfo.builder();

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

    ImmutableOverlayDiagramAttestationWidgetInfo.Builder idSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());
    ImmutableOverlayDiagramAttestationWidgetInfo immutableOverlayDiagramAttestationWidgetInfo =
        idSelectionOptionsResult
            .overlayParameters(
                ImmutableAttestationWidgetParameters.builder()
                    .attestedEntityId(1L)
                    .attestedEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableOverlayDiagramAttestationWidgetInfo actualWithOverlayParametersResult =
        immutableOverlayDiagramAttestationWidgetInfo.withOverlayParameters(
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(immutableOverlayDiagramAttestationWidgetInfo, actualWithOverlayParametersResult);
  }
}
