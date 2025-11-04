package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.AssessmentBasedSelectionFilter;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AggregatedEntitiesWidgetParameters;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAggregatedEntitiesWidgetInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters2() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .builder();
    OverlayDiagramAggregatedEntitiesWidgetInfo instance = mock(OverlayDiagramAggregatedEntitiesWidgetInfo.class);
    when(instance.assessmentBasedSelectionFilters()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#from(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .builder();
    OverlayDiagramAggregatedEntitiesWidgetInfo instance = mock(OverlayDiagramAggregatedEntitiesWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AggregatedEntitiesWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder#overlayParameters(AggregatedEntitiesWidgetParameters)}
   */
  @Test
  void testBuilderOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayParameters(mock(AggregatedEntitiesWidgetParameters.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#copyOf(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OverlayDiagramAggregatedEntitiesWidgetInfo instance = mock(OverlayDiagramAggregatedEntitiesWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AggregatedEntitiesWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertTrue(actualCopyOfResult.assessmentBasedSelectionFilters().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#copyOf(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramAggregatedEntitiesWidgetInfo instance = mock(OverlayDiagramAggregatedEntitiesWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AggregatedEntitiesWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(1, actualCopyOfResult.assessmentBasedSelectionFilters().size());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#copyOf(OverlayDiagramAggregatedEntitiesWidgetInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramAggregatedEntitiesWidgetInfo instance = mock(OverlayDiagramAggregatedEntitiesWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AggregatedEntitiesWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(assessmentBasedSelectionFilterSet, actualCopyOfResult.assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json json = new ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json();
    json.setOverlayParameters(mock(AggregatedEntitiesWidgetParameters.class));
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .fromJson(json);

    // Assert
    Set<AssessmentBasedSelectionFilter> assessmentBasedSelectionFiltersResult = actualFromJsonResult
        .assessmentBasedSelectionFilters();
    assertTrue(assessmentBasedSelectionFiltersResult.isEmpty());
    assertSame(json.assessmentBasedSelectionFilters, assessmentBasedSelectionFiltersResult);
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AggregatedEntitiesWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo#fromJson(ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new LinkedHashSet<>();
    assessmentBasedSelectionFilters.add(mock(AssessmentBasedSelectionFilter.class));

    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json json = new ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));
    json.setAssessmentBasedSelectionFilters(assessmentBasedSelectionFilters);
    json.setOverlayParameters(mock(AggregatedEntitiesWidgetParameters.class));

    // Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AggregatedEntitiesWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json#assessmentBasedSelectionFilters()}
   */
  @Test
  void testJsonAssessmentBasedSelectionFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json()).assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json#idSelectionOptions()}
   */
  @Test
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json()).idSelectionOptions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json actualJson = new ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json();

    // Assert
    assertNull(actualJson.idSelectionOptions);
    assertNull(actualJson.overlayParameters);
    assertTrue(actualJson.assessmentBasedSelectionFilters.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json#overlayParameters()}
   */
  @Test
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramAggregatedEntitiesWidgetInfo.Json()).overlayParameters());
  }
}
