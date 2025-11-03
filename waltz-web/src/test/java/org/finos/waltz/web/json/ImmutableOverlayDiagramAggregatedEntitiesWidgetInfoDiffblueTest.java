package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.AssessmentBasedSelectionFilter;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AggregatedEntitiesWidgetParameters;
import org.finos.waltz.web.json.ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder;
import org.finos.waltz.web.json.ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAggregatedEntitiesWidgetInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentBasedSelectionFilters(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessmentBasedSelectionFilters(Iterable)"})
  void testBuilderAddAllAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)"})
  void testBuilderAddAssessmentBasedSelectionFiltersWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Test Builder {@link Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])"})
  void testBuilderAddAssessmentBasedSelectionFiltersWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Test Builder {@link Builder#assessmentBasedSelectionFilters(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentBasedSelectionFilters(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentBasedSelectionFilters(Iterable)"})
  void testBuilderAssessmentBasedSelectionFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}.
   * <ul>
   *   <li>Then return build assessmentBasedSelectionFilters Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramAggregatedEntitiesWidgetInfo); then return build assessmentBasedSelectionFilters Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramAggregatedEntitiesWidgetInfo)"})
  void testBuilderFrom_thenReturnBuildAssessmentBasedSelectionFiltersEmpty() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();
    OverlayDiagramAggregatedEntitiesWidgetInfo instance = mock(OverlayDiagramAggregatedEntitiesWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AggregatedEntitiesWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertTrue(actualFromResult.build().assessmentBasedSelectionFilters().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramAggregatedEntitiesWidgetInfo); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramAggregatedEntitiesWidgetInfo)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();
    OverlayDiagramAggregatedEntitiesWidgetInfo instance = mock(OverlayDiagramAggregatedEntitiesWidgetInfo.class);
    when(instance.assessmentBasedSelectionFilters()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
  }

  /**
   * Test Builder {@link Builder#idSelectionOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>When {@link IdSelectionOptions}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.idSelectionOptions(IdSelectionOptions)"})
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Test Builder {@link Builder#overlayParameters(AggregatedEntitiesWidgetParameters)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#overlayParameters(AggregatedEntitiesWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder overlayParameters(AggregatedEntitiesWidgetParameters); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.overlayParameters(AggregatedEntitiesWidgetParameters)"})
  void testBuilderOverlayParameters_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayParameters(mock(AggregatedEntitiesWidgetParameters.class)));
  }

  /**
   * Test Json {@link Json#assessmentBasedSelectionFilters()}.
   * <p>
   * Method under test: {@link Json#assessmentBasedSelectionFilters()}
   */
  @Test
  @DisplayName("Test Json assessmentBasedSelectionFilters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.assessmentBasedSelectionFilters()"})
  void testJsonAssessmentBasedSelectionFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentBasedSelectionFilters());
  }

  /**
   * Test Json {@link Json#idSelectionOptions()}.
   * <p>
   * Method under test: {@link Json#idSelectionOptions()}
   */
  @Test
  @DisplayName("Test Json idSelectionOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions Json.idSelectionOptions()"})
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).idSelectionOptions());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#overlayParameters()}
   */
  @Test
  @DisplayName("Test Json overlayParameters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregatedEntitiesWidgetParameters Json.overlayParameters()"})
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).overlayParameters());
  }
}
