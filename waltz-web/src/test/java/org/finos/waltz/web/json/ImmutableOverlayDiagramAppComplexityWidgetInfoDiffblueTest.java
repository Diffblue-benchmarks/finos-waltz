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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppComplexityWidgetParameters;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAppComplexityWidgetInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters2() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#from(OverlayDiagramAppComplexityWidgetInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .builder();
    OverlayDiagramAppComplexityWidgetInfo instance = mock(OverlayDiagramAppComplexityWidgetInfo.class);
    when(instance.assessmentBasedSelectionFilters()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#from(OverlayDiagramAppComplexityWidgetInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .builder();
    OverlayDiagramAppComplexityWidgetInfo instance = mock(OverlayDiagramAppComplexityWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AppComplexityWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder#overlayParameters(AppComplexityWidgetParameters)}
   */
  @Test
  void testBuilderOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayParameters(mock(AppComplexityWidgetParameters.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#copyOf(OverlayDiagramAppComplexityWidgetInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OverlayDiagramAppComplexityWidgetInfo instance = mock(OverlayDiagramAppComplexityWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AppComplexityWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertTrue(actualCopyOfResult.assessmentBasedSelectionFilters().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#copyOf(OverlayDiagramAppComplexityWidgetInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramAppComplexityWidgetInfo instance = mock(OverlayDiagramAppComplexityWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AppComplexityWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(1, actualCopyOfResult.assessmentBasedSelectionFilters().size());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#copyOf(OverlayDiagramAppComplexityWidgetInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramAppComplexityWidgetInfo instance = mock(OverlayDiagramAppComplexityWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AppComplexityWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(assessmentBasedSelectionFilterSet, actualCopyOfResult.assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(ImmutableOverlayDiagramAppComplexityWidgetInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Json json = new ImmutableOverlayDiagramAppComplexityWidgetInfo.Json();
    json.setOverlayParameters(mock(AppComplexityWidgetParameters.class));
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .fromJson(json);

    // Assert
    Set<AssessmentBasedSelectionFilter> assessmentBasedSelectionFiltersResult = actualFromJsonResult
        .assessmentBasedSelectionFilters();
    assertTrue(assessmentBasedSelectionFiltersResult.isEmpty());
    assertSame(json.assessmentBasedSelectionFilters, assessmentBasedSelectionFiltersResult);
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppComplexityWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo#fromJson(ImmutableOverlayDiagramAppComplexityWidgetInfo.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new LinkedHashSet<>();
    assessmentBasedSelectionFilters.add(mock(AssessmentBasedSelectionFilter.class));

    ImmutableOverlayDiagramAppComplexityWidgetInfo.Json json = new ImmutableOverlayDiagramAppComplexityWidgetInfo.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));
    json.setAssessmentBasedSelectionFilters(assessmentBasedSelectionFilters);
    json.setOverlayParameters(mock(AppComplexityWidgetParameters.class));

    // Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramAppComplexityWidgetInfo
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppComplexityWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Json#assessmentBasedSelectionFilters()}
   */
  @Test
  void testJsonAssessmentBasedSelectionFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramAppComplexityWidgetInfo.Json()).assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Json#idSelectionOptions()}
   */
  @Test
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramAppComplexityWidgetInfo.Json()).idSelectionOptions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableOverlayDiagramAppComplexityWidgetInfo.Json actualJson = new ImmutableOverlayDiagramAppComplexityWidgetInfo.Json();

    // Assert
    assertNull(actualJson.idSelectionOptions);
    assertNull(actualJson.overlayParameters);
    assertTrue(actualJson.assessmentBasedSelectionFilters.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppComplexityWidgetInfo.Json#overlayParameters()}
   */
  @Test
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramAppComplexityWidgetInfo.Json()).overlayParameters());
  }
}
