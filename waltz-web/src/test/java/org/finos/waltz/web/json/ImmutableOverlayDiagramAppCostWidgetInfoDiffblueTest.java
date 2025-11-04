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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppCostWidgetParameters;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramAppCostWidgetInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters2() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#from(OverlayDiagramAppCostWidgetInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppCostWidgetInfo.builder();
    OverlayDiagramAppCostWidgetInfo instance = mock(OverlayDiagramAppCostWidgetInfo.class);
    when(instance.assessmentBasedSelectionFilters()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#from(OverlayDiagramAppCostWidgetInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppCostWidgetInfo.builder();
    OverlayDiagramAppCostWidgetInfo instance = mock(OverlayDiagramAppCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AppCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Builder#overlayParameters(AppCostWidgetParameters)}
   */
  @Test
  void testBuilderOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramAppCostWidgetInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayParameters(mock(AppCostWidgetParameters.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo#copyOf(OverlayDiagramAppCostWidgetInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OverlayDiagramAppCostWidgetInfo instance = mock(OverlayDiagramAppCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AppCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramAppCostWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertTrue(actualCopyOfResult.assessmentBasedSelectionFilters().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo#copyOf(OverlayDiagramAppCostWidgetInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramAppCostWidgetInfo instance = mock(OverlayDiagramAppCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AppCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramAppCostWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(1, actualCopyOfResult.assessmentBasedSelectionFilters().size());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo#copyOf(OverlayDiagramAppCostWidgetInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramAppCostWidgetInfo instance = mock(OverlayDiagramAppCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(AppCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramAppCostWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(assessmentBasedSelectionFilterSet, actualCopyOfResult.assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(ImmutableOverlayDiagramAppCostWidgetInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOverlayDiagramAppCostWidgetInfo.Json json = new ImmutableOverlayDiagramAppCostWidgetInfo.Json();
    json.setOverlayParameters(mock(AppCostWidgetParameters.class));
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramAppCostWidgetInfo
        .fromJson(json);

    // Assert
    Set<AssessmentBasedSelectionFilter> assessmentBasedSelectionFiltersResult = actualFromJsonResult
        .assessmentBasedSelectionFilters();
    assertTrue(assessmentBasedSelectionFiltersResult.isEmpty());
    assertSame(json.assessmentBasedSelectionFilters, assessmentBasedSelectionFiltersResult);
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo#fromJson(ImmutableOverlayDiagramAppCostWidgetInfo.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new LinkedHashSet<>();
    assessmentBasedSelectionFilters.add(mock(AssessmentBasedSelectionFilter.class));

    ImmutableOverlayDiagramAppCostWidgetInfo.Json json = new ImmutableOverlayDiagramAppCostWidgetInfo.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));
    json.setAssessmentBasedSelectionFilters(assessmentBasedSelectionFilters);
    json.setOverlayParameters(mock(AppCostWidgetParameters.class));

    // Act
    ImmutableOverlayDiagramAppCostWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramAppCostWidgetInfo
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    AppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Json#assessmentBasedSelectionFilters()}
   */
  @Test
  void testJsonAssessmentBasedSelectionFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramAppCostWidgetInfo.Json()).assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Json#idSelectionOptions()}
   */
  @Test
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramAppCostWidgetInfo.Json()).idSelectionOptions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableOverlayDiagramAppCostWidgetInfo.Json actualJson = new ImmutableOverlayDiagramAppCostWidgetInfo.Json();

    // Assert
    assertNull(actualJson.idSelectionOptions);
    assertNull(actualJson.overlayParameters);
    assertTrue(actualJson.assessmentBasedSelectionFilters.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramAppCostWidgetInfo.Json#overlayParameters()}
   */
  @Test
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramAppCostWidgetInfo.Json()).overlayParameters());
  }
}
