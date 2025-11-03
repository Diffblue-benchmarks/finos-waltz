package org.finos.waltz.model.roadmap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.model.roadmap.ImmutableRoadmapAndScenarioOverview.Builder;
import org.finos.waltz.model.roadmap.ImmutableRoadmapAndScenarioOverview.Json;
import org.finos.waltz.model.scenario.Scenario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRoadmapAndScenarioOverviewDiffblueTest {
  /**
   * Test Builder {@link Builder#from(RoadmapAndScenarioOverview)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build scenarios is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RoadmapAndScenarioOverview)}
   */
  @Test
  @DisplayName("Test Builder from(RoadmapAndScenarioOverview); given ArrayList(); then builder build scenarios is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RoadmapAndScenarioOverview)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildScenariosIsArrayList() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();
    RoadmapAndScenarioOverview instance = mock(RoadmapAndScenarioOverview.class);
    ArrayList<Scenario> scenarioList = new ArrayList<>();
    when(instance.scenarios()).thenReturn(scenarioList);
    ImmutableRoadmap.Json json = new ImmutableRoadmap.Json();
    when(instance.roadmap()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).roadmap();
    verify(instance).scenarios();
    ImmutableRoadmapAndScenarioOverview buildResult = builderResult.build();
    assertSame(scenarioList, buildResult.scenarios());
    assertSame(json, buildResult.roadmap());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RoadmapAndScenarioOverview)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RoadmapAndScenarioOverview)}
   */
  @Test
  @DisplayName("Test Builder from(RoadmapAndScenarioOverview); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RoadmapAndScenarioOverview)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();
    RoadmapAndScenarioOverview instance = mock(RoadmapAndScenarioOverview.class);
    when(instance.scenarios()).thenThrow(new IllegalStateException("instance"));
    when(instance.roadmap()).thenReturn(new ImmutableRoadmap.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).roadmap();
    verify(instance).scenarios();
  }

  /**
   * Test Builder {@link Builder#roadmap(Roadmap)}.
   * <ul>
   *   <li>When {@link ImmutableRoadmap.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#roadmap(Roadmap)}
   */
  @Test
  @DisplayName("Test Builder roadmap(Roadmap); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.roadmap(Roadmap)"})
  void testBuilderRoadmap_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roadmap(new ImmutableRoadmap.Json()));
  }

  /**
   * Test Builder {@link Builder#scenarios(Collection)}.
   * <p>
   * Method under test: {@link Builder#scenarios(Collection)}
   */
  @Test
  @DisplayName("Test Builder scenarios(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.scenarios(Collection)"})
  void testBuilderScenarios() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarios(new ArrayList<>()));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRoadmap(Roadmap)}
   *   <li>{@link Json#setScenarios(Collection)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRoadmap(Roadmap)", "void Json.setScenarios(Collection)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRoadmap(new ImmutableRoadmap.Json());
    actualJson.setScenarios(new ArrayList<>());

    // Assert
    assertFalse(((ImmutableRoadmap.Json) actualJson.roadmap).id.isPresent());
  }

  /**
   * Test Json {@link Json#roadmap()}.
   * <p>
   * Method under test: {@link Json#roadmap()}
   */
  @Test
  @DisplayName("Test Json roadmap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Roadmap Json.roadmap()"})
  void testJsonRoadmap() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).roadmap());
  }

  /**
   * Test Json {@link Json#scenarios()}.
   * <p>
   * Method under test: {@link Json#scenarios()}
   */
  @Test
  @DisplayName("Test Json scenarios()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection Json.scenarios()"})
  void testJsonScenarios() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).scenarios());
  }
}
