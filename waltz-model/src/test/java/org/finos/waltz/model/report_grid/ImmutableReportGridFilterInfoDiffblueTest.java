package org.finos.waltz.model.report_grid;

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
import java.util.Set;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class ImmutableReportGridFilterInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#addAllGridFilters(Iterable)}
   */
  @Test
  void testBuilderAddAllGridFilters() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllGridFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#addGridFilters(GridFilter)}
   */
  @Test
  void testBuilderAddGridFilters() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addGridFilters(new ImmutableGridFilter.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#addGridFilters(GridFilter[])}
   */
  @Test
  void testBuilderAddGridFilters2() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addGridFilters(new ImmutableGridFilter.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#appGroupId(Long)}
   */
  @Test
  void testBuilderAppGroupId() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appGroupId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#from(ReportGridFilterInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();
    ReportGridFilterInfo instance = mock(ReportGridFilterInfo.class);
    when(instance.idSelectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.appGroupId()).thenReturn(1L);
    when(instance.gridDefinition()).thenReturn(new ImmutableReportGridDefinition.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appGroupId();
    verify(instance).gridDefinition();
    verify(instance).idSelectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#from(ReportGridFilterInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();
    ReportGridFilterInfo instance = mock(ReportGridFilterInfo.class);
    when(instance.gridFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.appGroupId()).thenReturn(1L);
    ImmutableReportGridDefinition.Json json = new ImmutableReportGridDefinition.Json();
    when(instance.gridDefinition()).thenReturn(json);

    // Act
    ImmutableReportGridFilterInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroupId();
    verify(instance).gridDefinition();
    verify(instance).gridFilters();
    verify(instance).idSelectionOptions();
    ImmutableReportGridFilterInfo buildResult = builderResult.build();
    assertEquals(1L, buildResult.appGroupId().longValue());
    assertSame(json, buildResult.gridDefinition());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#from(ReportGridFilterInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();

    HashSet<GridFilter> gridFilterSet = new HashSet<>();
    gridFilterSet.add(new ImmutableGridFilter.Json());
    ReportGridFilterInfo instance = mock(ReportGridFilterInfo.class);
    when(instance.gridFilters()).thenReturn(gridFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.appGroupId()).thenReturn(1L);
    ImmutableReportGridDefinition.Json json = new ImmutableReportGridDefinition.Json();
    when(instance.gridDefinition()).thenReturn(json);

    // Act
    ImmutableReportGridFilterInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroupId();
    verify(instance).gridDefinition();
    verify(instance).gridFilters();
    verify(instance).idSelectionOptions();
    ImmutableReportGridFilterInfo buildResult = builderResult.build();
    assertEquals(1, buildResult.gridFilters().size());
    assertEquals(1L, buildResult.appGroupId().longValue());
    assertSame(json, buildResult.gridDefinition());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#from(ReportGridFilterInfo)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();
    ReportGridFilterInfo instance = mock(ReportGridFilterInfo.class);
    when(instance.gridFilters()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.appGroupId()).thenReturn(1L);
    when(instance.gridDefinition()).thenReturn(new ImmutableReportGridDefinition.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appGroupId();
    verify(instance).gridDefinition();
    verify(instance).gridFilters();
    verify(instance).idSelectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#gridDefinition(ReportGridDefinition)}
   */
  @Test
  void testBuilderGridDefinition() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridDefinition(new ImmutableReportGridDefinition.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#gridFilters(Iterable)}
   */
  @Test
  void testBuilderGridFilters() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridFilters(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableReportGridFilterInfo.Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo#copyOf(ReportGridFilterInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridFilterInfo instance = mock(ReportGridFilterInfo.class);
    when(instance.gridFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.appGroupId()).thenReturn(1L);
    ImmutableReportGridDefinition.Json json = new ImmutableReportGridDefinition.Json();
    when(instance.gridDefinition()).thenReturn(json);

    // Act
    ImmutableReportGridFilterInfo actualCopyOfResult = ImmutableReportGridFilterInfo.copyOf(instance);

    // Assert
    verify(instance).appGroupId();
    verify(instance).gridDefinition();
    verify(instance).gridFilters();
    verify(instance).idSelectionOptions();
    assertEquals(1L, actualCopyOfResult.appGroupId().longValue());
    assertTrue(actualCopyOfResult.gridFilters().isEmpty());
    assertSame(json, actualCopyOfResult.gridDefinition());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo#copyOf(ReportGridFilterInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<GridFilter> gridFilterSet = new HashSet<>();
    gridFilterSet.add(new ImmutableGridFilter.Json());
    ReportGridFilterInfo instance = mock(ReportGridFilterInfo.class);
    when(instance.gridFilters()).thenReturn(gridFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.appGroupId()).thenReturn(1L);
    ImmutableReportGridDefinition.Json json = new ImmutableReportGridDefinition.Json();
    when(instance.gridDefinition()).thenReturn(json);

    // Act
    ImmutableReportGridFilterInfo actualCopyOfResult = ImmutableReportGridFilterInfo.copyOf(instance);

    // Assert
    verify(instance).appGroupId();
    verify(instance).gridDefinition();
    verify(instance).gridFilters();
    verify(instance).idSelectionOptions();
    assertEquals(1, actualCopyOfResult.gridFilters().size());
    assertEquals(1L, actualCopyOfResult.appGroupId().longValue());
    assertSame(json, actualCopyOfResult.gridDefinition());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo#copyOf(ReportGridFilterInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<GridFilter> gridFilterSet = new HashSet<>();
    gridFilterSet.add(new ImmutableGridFilter.Json());
    gridFilterSet.add(new ImmutableGridFilter.Json());
    ReportGridFilterInfo instance = mock(ReportGridFilterInfo.class);
    when(instance.gridFilters()).thenReturn(gridFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.appGroupId()).thenReturn(1L);
    ImmutableReportGridDefinition.Json json = new ImmutableReportGridDefinition.Json();
    when(instance.gridDefinition()).thenReturn(json);

    // Act
    ImmutableReportGridFilterInfo actualCopyOfResult = ImmutableReportGridFilterInfo.copyOf(instance);

    // Assert
    verify(instance).appGroupId();
    verify(instance).gridDefinition();
    verify(instance).gridFilters();
    verify(instance).idSelectionOptions();
    assertEquals(1L, actualCopyOfResult.appGroupId().longValue());
    assertEquals(gridFilterSet, actualCopyOfResult.gridFilters());
    assertSame(json, actualCopyOfResult.gridDefinition());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo#fromJson(ImmutableReportGridFilterInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGridFilterInfo.Json json = new ImmutableReportGridFilterInfo.Json();
    ImmutableReportGridDefinition.Json gridDefinition = new ImmutableReportGridDefinition.Json();
    json.setGridDefinition(gridDefinition);
    json.setAppGroupId(1L);
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));

    // Act
    ImmutableReportGridFilterInfo actualFromJsonResult = ImmutableReportGridFilterInfo.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.appGroupId().longValue());
    Set<GridFilter> gridFiltersResult = actualFromJsonResult.gridFilters();
    assertTrue(gridFiltersResult.isEmpty());
    assertSame(gridDefinition, actualFromJsonResult.gridDefinition());
    assertSame(json.gridFilters, gridFiltersResult);
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Method under test: {@link ImmutableReportGridFilterInfo.Json#appGroupId()}
   */
  @Test
  void testJsonAppGroupId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridFilterInfo.Json()).appGroupId());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Json#gridDefinition()}
   */
  @Test
  void testJsonGridDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFilterInfo.Json()).gridDefinition());
  }

  /**
   * Method under test: {@link ImmutableReportGridFilterInfo.Json#gridFilters()}
   */
  @Test
  void testJsonGridFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridFilterInfo.Json()).gridFilters());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFilterInfo.Json#idSelectionOptions()}
   */
  @Test
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFilterInfo.Json()).idSelectionOptions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridFilterInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridFilterInfo.Json actualJson = new ImmutableReportGridFilterInfo.Json();

    // Assert
    assertNull(actualJson.appGroupId);
    assertNull(actualJson.idSelectionOptions);
    assertNull(actualJson.gridDefinition);
    assertTrue(actualJson.gridFilters.isEmpty());
  }
}
