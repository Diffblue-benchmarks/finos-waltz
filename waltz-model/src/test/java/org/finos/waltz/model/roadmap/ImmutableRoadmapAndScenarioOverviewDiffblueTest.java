package org.finos.waltz.model.roadmap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.scenario.Scenario;
import org.junit.jupiter.api.Test;

class ImmutableRoadmapAndScenarioOverviewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableRoadmapAndScenarioOverview.Builder#from(RoadmapAndScenarioOverview)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRoadmapAndScenarioOverview.Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();
    RoadmapAndScenarioOverview instance = mock(RoadmapAndScenarioOverview.class);
    ArrayList<Scenario> scenarioList = new ArrayList<>();
    when(instance.scenarios()).thenReturn(scenarioList);
    ImmutableRoadmap.Json json = new ImmutableRoadmap.Json();
    when(instance.roadmap()).thenReturn(json);

    // Act
    ImmutableRoadmapAndScenarioOverview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).roadmap();
    verify(instance).scenarios();
    ImmutableRoadmapAndScenarioOverview buildResult = builderResult.build();
    assertSame(scenarioList, buildResult.scenarios());
    assertSame(json, buildResult.roadmap());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapAndScenarioOverview.Builder#from(RoadmapAndScenarioOverview)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRoadmapAndScenarioOverview.Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();
    RoadmapAndScenarioOverview instance = mock(RoadmapAndScenarioOverview.class);
    when(instance.scenarios()).thenThrow(new IllegalStateException("instance"));
    when(instance.roadmap()).thenReturn(new ImmutableRoadmap.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).roadmap();
    verify(instance).scenarios();
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapAndScenarioOverview.Builder#roadmap(Roadmap)}
   */
  @Test
  void testBuilderRoadmap() {
    // Arrange
    ImmutableRoadmapAndScenarioOverview.Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roadmap(new ImmutableRoadmap.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapAndScenarioOverview.Builder#roadmap(Roadmap)}
   */
  @Test
  void testBuilderRoadmap2() {
    // Arrange
    ImmutableRoadmapAndScenarioOverview.Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    ImmutableRoadmap.Json roadmap = new ImmutableRoadmap.Json();
    roadmap.setRowType(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.roadmap(roadmap));
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapAndScenarioOverview.Builder#scenarios(Collection)}
   */
  @Test
  void testBuilderScenarios() {
    // Arrange
    ImmutableRoadmapAndScenarioOverview.Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarios(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapAndScenarioOverview#copyOf(RoadmapAndScenarioOverview)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RoadmapAndScenarioOverview instance = mock(RoadmapAndScenarioOverview.class);
    ArrayList<Scenario> scenarioList = new ArrayList<>();
    when(instance.scenarios()).thenReturn(scenarioList);
    ImmutableRoadmap.Json json = new ImmutableRoadmap.Json();
    when(instance.roadmap()).thenReturn(json);

    // Act
    ImmutableRoadmapAndScenarioOverview actualCopyOfResult = ImmutableRoadmapAndScenarioOverview.copyOf(instance);

    // Assert
    verify(instance).roadmap();
    verify(instance).scenarios();
    Collection<Scenario> scenariosResult = actualCopyOfResult.scenarios();
    assertTrue(scenariosResult instanceof List);
    assertTrue(scenariosResult.isEmpty());
    assertSame(scenarioList, scenariosResult);
    assertSame(json, actualCopyOfResult.roadmap());
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapAndScenarioOverview#fromJson(ImmutableRoadmapAndScenarioOverview.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableRoadmapAndScenarioOverview.Json json = new ImmutableRoadmapAndScenarioOverview.Json();
    ImmutableRoadmap.Json roadmap = new ImmutableRoadmap.Json();
    json.setRoadmap(roadmap);
    ArrayList<Scenario> scenarios = new ArrayList<>();
    json.setScenarios(scenarios);

    // Act
    ImmutableRoadmapAndScenarioOverview actualFromJsonResult = ImmutableRoadmapAndScenarioOverview.fromJson(json);

    // Assert
    Collection<Scenario> scenariosResult = actualFromJsonResult.scenarios();
    assertTrue(scenariosResult instanceof List);
    assertTrue(scenariosResult.isEmpty());
    assertSame(scenarios, scenariosResult);
    assertSame(roadmap, actualFromJsonResult.roadmap());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableRoadmapAndScenarioOverview.Json}
   *   <li>{@link ImmutableRoadmapAndScenarioOverview.Json#setRoadmap(Roadmap)}
   *   <li>{@link ImmutableRoadmapAndScenarioOverview.Json#setScenarios(Collection)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableRoadmapAndScenarioOverview.Json actualJson = new ImmutableRoadmapAndScenarioOverview.Json();
    actualJson.setRoadmap(new ImmutableRoadmap.Json());
    actualJson.setScenarios(new ArrayList<>());

    // Assert
    assertFalse(((ImmutableRoadmap.Json) actualJson.roadmap).id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableRoadmapAndScenarioOverview.Json#roadmap()}
   */
  @Test
  void testJsonRoadmap() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoadmapAndScenarioOverview.Json()).roadmap());
  }

  /**
   * Method under test:
   * {@link ImmutableRoadmapAndScenarioOverview.Json#scenarios()}
   */
  @Test
  void testJsonScenarios() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRoadmapAndScenarioOverview.Json()).scenarios());
  }
}
