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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.TargetAppCostWidgetParameters;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramTargetAppCostWidgetInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#addAllAssessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#addAssessmentBasedSelectionFilters(AssessmentBasedSelectionFilter[])}
   */
  @Test
  void testBuilderAddAssessmentBasedSelectionFilters2() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addAssessmentBasedSelectionFilters(mock(AssessmentBasedSelectionFilter.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#assessmentBasedSelectionFilters(Iterable)}
   */
  @Test
  void testBuilderAssessmentBasedSelectionFilters() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentBasedSelectionFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#from(OverlayDiagramTargetAppCostWidgetInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .builder();
    OverlayDiagramTargetAppCostWidgetInfo instance = mock(OverlayDiagramTargetAppCostWidgetInfo.class);
    when(instance.assessmentBasedSelectionFilters()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#from(OverlayDiagramTargetAppCostWidgetInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .builder();
    OverlayDiagramTargetAppCostWidgetInfo instance = mock(OverlayDiagramTargetAppCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(TargetAppCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder#overlayParameters(TargetAppCostWidgetParameters)}
   */
  @Test
  void testBuilderOverlayParameters() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Builder builderResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overlayParameters(mock(TargetAppCostWidgetParameters.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#copyOf(OverlayDiagramTargetAppCostWidgetInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OverlayDiagramTargetAppCostWidgetInfo instance = mock(OverlayDiagramTargetAppCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(TargetAppCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertTrue(actualCopyOfResult.assessmentBasedSelectionFilters().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#copyOf(OverlayDiagramTargetAppCostWidgetInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramTargetAppCostWidgetInfo instance = mock(OverlayDiagramTargetAppCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(TargetAppCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(1, actualCopyOfResult.assessmentBasedSelectionFilters().size());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#copyOf(OverlayDiagramTargetAppCostWidgetInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilterSet = new HashSet<>();
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    assessmentBasedSelectionFilterSet.add(mock(AssessmentBasedSelectionFilter.class));
    OverlayDiagramTargetAppCostWidgetInfo instance = mock(OverlayDiagramTargetAppCostWidgetInfo.class);
    when(instance.overlayParameters()).thenReturn(mock(TargetAppCostWidgetParameters.class));
    when(instance.assessmentBasedSelectionFilters()).thenReturn(assessmentBasedSelectionFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualCopyOfResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .copyOf(instance);

    // Assert
    verify(instance).assessmentBasedSelectionFilters();
    verify(instance).idSelectionOptions();
    verify(instance).overlayParameters();
    assertEquals(assessmentBasedSelectionFilterSet, actualCopyOfResult.assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json json = new ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json();
    json.setOverlayParameters(mock(TargetAppCostWidgetParameters.class));
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .fromJson(json);

    // Assert
    Set<AssessmentBasedSelectionFilter> assessmentBasedSelectionFiltersResult = actualFromJsonResult
        .assessmentBasedSelectionFilters();
    assertTrue(assessmentBasedSelectionFiltersResult.isEmpty());
    assertSame(json.assessmentBasedSelectionFilters, assessmentBasedSelectionFiltersResult);
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    TargetAppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo#fromJson(ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new LinkedHashSet<>();
    assessmentBasedSelectionFilters.add(mock(AssessmentBasedSelectionFilter.class));

    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json json = new ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));
    json.setAssessmentBasedSelectionFilters(assessmentBasedSelectionFilters);
    json.setOverlayParameters(mock(TargetAppCostWidgetParameters.class));

    // Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo actualFromJsonResult = ImmutableOverlayDiagramTargetAppCostWidgetInfo
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentBasedSelectionFilters().size());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
    TargetAppCostWidgetParameters expectedOverlayParametersResult = json.overlayParameters;
    assertSame(expectedOverlayParametersResult, actualFromJsonResult.overlayParameters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json#assessmentBasedSelectionFilters()}
   */
  @Test
  void testJsonAssessmentBasedSelectionFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json()).assessmentBasedSelectionFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json#idSelectionOptions()}
   */
  @Test
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json()).idSelectionOptions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json actualJson = new ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json();

    // Assert
    assertNull(actualJson.idSelectionOptions);
    assertNull(actualJson.overlayParameters);
    assertTrue(actualJson.assessmentBasedSelectionFilters.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json#overlayParameters()}
   */
  @Test
  void testJsonOverlayParameters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramTargetAppCostWidgetInfo.Json()).overlayParameters());
  }
}
