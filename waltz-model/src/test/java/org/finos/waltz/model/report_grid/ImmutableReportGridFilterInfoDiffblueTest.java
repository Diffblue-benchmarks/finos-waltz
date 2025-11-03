package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.report_grid.ImmutableReportGridFilterInfo.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridFilterInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridFilterInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllGridFilters(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllGridFilters(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllGridFilters(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllGridFilters(Iterable)"})
  void testBuilderAddAllGridFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllGridFilters(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addGridFilters(GridFilter)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableGridFilter.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addGridFilters(GridFilter)}
   */
  @Test
  @DisplayName("Test Builder addGridFilters(GridFilter) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addGridFilters(GridFilter)"})
  void testBuilderAddGridFiltersWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addGridFilters(new ImmutableGridFilter.Json()));
  }

  /**
   * Test Builder {@link Builder#addGridFilters(GridFilter[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableGridFilter.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addGridFilters(GridFilter[])}
   */
  @Test
  @DisplayName("Test Builder addGridFilters(GridFilter[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addGridFilters(GridFilter[])"})
  void testBuilderAddGridFiltersWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addGridFilters(new ImmutableGridFilter.Json()));
  }

  /**
   * Test Builder {@link Builder#appGroupId(Long)}.
   * <p>
   * Method under test: {@link Builder#appGroupId(Long)}
   */
  @Test
  @DisplayName("Test Builder appGroupId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appGroupId(Long)"})
  void testBuilderAppGroupId() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appGroupId(1L));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFilterInfo)}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFilterInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFilterInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFilterInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();
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
   * Test Builder {@link Builder#from(ReportGridFilterInfo)}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFilterInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFilterInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFilterInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();
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
   * Test Builder {@link Builder#from(ReportGridFilterInfo)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableGridFilter.Json} (default constructor).</li>
   *   <li>Then return build gridFilters size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridFilterInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFilterInfo); given HashSet() add Json (default constructor); then return build gridFilters size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFilterInfo)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildGridFiltersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    HashSet<GridFilter> gridFilterSet = new HashSet<>();
    gridFilterSet.add(new ImmutableGridFilter.Json());
    ReportGridFilterInfo instance = mock(ReportGridFilterInfo.class);
    when(instance.gridFilters()).thenReturn(gridFilterSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.appGroupId()).thenReturn(1L);
    when(instance.gridDefinition()).thenReturn(new ImmutableReportGridDefinition.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroupId();
    verify(instance).gridDefinition();
    verify(instance).gridFilters();
    verify(instance).idSelectionOptions();
    assertEquals(1, actualFromResult.build().gridFilters().size());
    assertEquals(1, builderResult.build().gridFilters().size());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFilterInfo)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build appGroupId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridFilterInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFilterInfo); given HashSet(); then builder build appGroupId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFilterInfo)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildAppGroupIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();
    ReportGridFilterInfo instance = mock(ReportGridFilterInfo.class);
    when(instance.gridFilters()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.appGroupId()).thenReturn(1L);
    ImmutableReportGridDefinition.Json json = new ImmutableReportGridDefinition.Json();
    when(instance.gridDefinition()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#gridDefinition(ReportGridDefinition)}.
   * <ul>
   *   <li>When {@link ImmutableReportGridDefinition.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#gridDefinition(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder gridDefinition(ReportGridDefinition); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.gridDefinition(ReportGridDefinition)"})
  void testBuilderGridDefinition_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridDefinition(new ImmutableReportGridDefinition.Json()));
  }

  /**
   * Test Builder {@link Builder#gridFilters(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#gridFilters(Iterable)}
   */
  @Test
  @DisplayName("Test Builder gridFilters(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.gridFilters(Iterable)"})
  void testBuilderGridFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridFilters(new ArrayList<>()));
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
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Test Json {@link Json#appGroupId()}.
   * <p>
   * Method under test: {@link Json#appGroupId()}
   */
  @Test
  @DisplayName("Test Json appGroupId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.appGroupId()"})
  void testJsonAppGroupId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appGroupId());
  }

  /**
   * Test Json {@link Json#gridDefinition()}.
   * <p>
   * Method under test: {@link Json#gridDefinition()}
   */
  @Test
  @DisplayName("Test Json gridDefinition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReportGridDefinition Json.gridDefinition()"})
  void testJsonGridDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).gridDefinition());
  }

  /**
   * Test Json {@link Json#gridFilters()}.
   * <p>
   * Method under test: {@link Json#gridFilters()}
   */
  @Test
  @DisplayName("Test Json gridFilters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.gridFilters()"})
  void testJsonGridFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).gridFilters());
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
    assertNull(actualJson.appGroupId);
    assertNull(actualJson.idSelectionOptions);
    assertNull(actualJson.gridDefinition);
    assertTrue(actualJson.gridFilters.isEmpty());
  }
}
