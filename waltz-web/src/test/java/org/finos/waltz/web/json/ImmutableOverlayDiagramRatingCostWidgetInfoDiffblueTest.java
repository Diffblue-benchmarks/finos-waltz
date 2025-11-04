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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.RatingCostWidgetParameters;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramRatingCostWidgetInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramRatingCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramRatingCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters2() {
    // Arrange
    ImmutableOverlayDiagramRatingCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramRatingCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Builder#from(OverlayDiagramRatingCostWidgetInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramRatingCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .builder();
    OverlayDiagramRatingCostWidgetInfo instance = mock(OverlayDiagramRatingCostWidgetInfo.class);
    when(instance.assessmentBasedSelectionFilters()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Builder#from(OverlayDiagramRatingCostWidgetInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOverlayDiagramRatingCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .builder();
    OverlayDiagramRatingCostWidgetInfo instance = mock(OverlayDiagramRatingCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(RatingCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramRatingCostWidgetInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramRatingCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Builder#overlayParameters(RatingCostWidgetParameters)}
   */
  @Test
  void testBuilderOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramRatingCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayParameters(mock(RatingCostWidgetParameters.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo#copyOf(OverlayDiagramRatingCostWidgetInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OverlayDiagramRatingCostWidgetInfo instance = mock(OverlayDiagramRatingCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(RatingCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramRatingCostWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertTrue(actualCopyOfResult.assessmentBasedSelectionFilters().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo#copyOf(OverlayDiagramRatingCostWidgetInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramRatingCostWidgetInfo instance = mock(OverlayDiagramRatingCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(RatingCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramRatingCostWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(1, actualCopyOfResult.assessmentBasedSelectionFilters().size());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo#copyOf(OverlayDiagramRatingCostWidgetInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramRatingCostWidgetInfo instance = mock(OverlayDiagramRatingCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(RatingCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramRatingCostWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(assessmentBasedSelectionFilterSet, actualCopyOfResult.assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo#fromJson(ImmutableOverlayDiagramRatingCostWidgetInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOverlayDiagramRatingCostWidgetInfo.Json json = new ImmutableOverlayDiagramRatingCostWidgetInfo.Json();
    json.setOverlayParameters(mock(RatingCostWidgetParameters.class));
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramRatingCostWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .fromJson(json);

    // Assert
    Set<AssessmentBasedSelectionFilter> assessmentBasedSelectionFiltersResult = actualFromJsonResult
        .assessmentBasedSelectionFilters();
    assertTrue(assessmentBasedSelectionFiltersResult.isEmpty());
    assertSame(json.assessmentBasedSelectionFilters, assessmentBasedSelectionFiltersResult);
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    RatingCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo#fromJson(ImmutableOverlayDiagramRatingCostWidgetInfo.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new LinkedHashSet<>();
    assessmentBasedSelectionFilters.add(mock(AssessmentBasedSelectionFilter.class));

    ImmutableOverlayDiagramRatingCostWidgetInfo.Json json = new ImmutableOverlayDiagramRatingCostWidgetInfo.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));
    json.setAssessmentBasedSelectionFilters(assessmentBasedSelectionFilters);
    json.setOverlayParameters(mock(RatingCostWidgetParameters.class));

    // Act
    ImmutableOverlayDiagramRatingCostWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramRatingCostWidgetInfo
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    RatingCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Json#assessmentBasedSelectionFilters()}
   */
  @Test
  void testJsonAssessmentBasedSelectionFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramRatingCostWidgetInfo.Json()).assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Json#idSelectionOptions()}
   */
  @Test
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramRatingCostWidgetInfo.Json()).idSelectionOptions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableOverlayDiagramRatingCostWidgetInfo.Json actualJson = new ImmutableOverlayDiagramRatingCostWidgetInfo.Json();

    // Assert
    assertNull(actualJson.idSelectionOptions);
    assertNull(actualJson.overlayParameters);
    assertTrue(actualJson.assessmentBasedSelectionFilters.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramRatingCostWidgetInfo.Json#overlayParameters()}
   */
  @Test
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramRatingCostWidgetInfo.Json()).overlayParameters());
  }
}
