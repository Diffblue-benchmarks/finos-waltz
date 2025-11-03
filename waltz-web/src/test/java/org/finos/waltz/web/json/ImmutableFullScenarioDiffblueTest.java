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
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.roadmap.Roadmap;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.model.scenario.ScenarioAxisItem;
import org.finos.waltz.model.scenario.ScenarioRatingItem;
import org.finos.waltz.web.json.ImmutableFullScenario.Builder;
import org.finos.waltz.web.json.ImmutableFullScenario.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFullScenarioDiffblueTest {
  /**
   * Test Builder {@link Builder#axisDefinitions(Collection)}.
   * <ul>
   *   <li>Given {@link ScenarioAxisItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#axisDefinitions(Collection)}
   */
  @Test
  @DisplayName("Test Builder axisDefinitions(Collection); given ScenarioAxisItem")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.axisDefinitions(Collection)"})
  void testBuilderAxisDefinitions_givenScenarioAxisItem() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();
    axisDefinitions.add(mock(ScenarioAxisItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.axisDefinitions(axisDefinitions));
  }

  /**
   * Test Builder {@link Builder#axisDefinitions(Collection)}.
   * <ul>
   *   <li>Given {@link ScenarioAxisItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#axisDefinitions(Collection)}
   */
  @Test
  @DisplayName("Test Builder axisDefinitions(Collection); given ScenarioAxisItem")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.axisDefinitions(Collection)"})
  void testBuilderAxisDefinitions_givenScenarioAxisItem2() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();
    axisDefinitions.add(mock(ScenarioAxisItem.class));
    axisDefinitions.add(mock(ScenarioAxisItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.axisDefinitions(axisDefinitions));
  }

  /**
   * Test Builder {@link Builder#axisDefinitions(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#axisDefinitions(Collection)}
   */
  @Test
  @DisplayName("Test Builder axisDefinitions(Collection); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.axisDefinitions(Collection)"})
  void testBuilderAxisDefinitions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.axisDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(FullScenario)}.
   * <p>
   * Method under test: {@link Builder#from(FullScenario)}
   */
  @Test
  @DisplayName("Test Builder from(FullScenario)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FullScenario)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();
    FullScenario instance = mock(FullScenario.class);
    when(instance.axisDefinitions()).thenThrow(new IllegalStateException("instance"));
    when(instance.scenario()).thenReturn(mock(Scenario.class));
    when(instance.roadmap()).thenReturn(mock(Roadmap.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).axisDefinitions();
    verify(instance).roadmap();
    verify(instance).scenario();
  }

  /**
   * Test Builder {@link Builder#from(FullScenario)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build axisDefinitions is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FullScenario)}
   */
  @Test
  @DisplayName("Test Builder from(FullScenario); given ArrayList(); then builder build axisDefinitions is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FullScenario)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildAxisDefinitionsIsArrayList() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();
    FullScenario instance = mock(FullScenario.class);
    ArrayList<ScenarioAxisItem> scenarioAxisItemList = new ArrayList<>();
    when(instance.axisDefinitions()).thenReturn(scenarioAxisItemList);
    ArrayList<ScenarioRatingItem> scenarioRatingItemList = new ArrayList<>();
    when(instance.ratings()).thenReturn(scenarioRatingItemList);
    when(instance.scenario()).thenReturn(mock(Scenario.class));
    when(instance.roadmap()).thenReturn(mock(Roadmap.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).axisDefinitions();
    verify(instance).ratings();
    verify(instance).roadmap();
    verify(instance).scenario();
    ImmutableFullScenario buildResult = builderResult.build();
    assertSame(scenarioAxisItemList, buildResult.axisDefinitions());
    assertSame(scenarioRatingItemList, buildResult.ratings());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FullScenario)}.
   * <ul>
   *   <li>When {@link FullScenario} {@link FullScenario#scenario()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FullScenario)}
   */
  @Test
  @DisplayName("Test Builder from(FullScenario); when FullScenario scenario() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FullScenario)"})
  void testBuilderFrom_whenFullScenarioScenarioThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();
    FullScenario instance = mock(FullScenario.class);
    when(instance.scenario()).thenThrow(new IllegalStateException("instance"));
    when(instance.roadmap()).thenReturn(mock(Roadmap.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).roadmap();
    verify(instance).scenario();
  }

  /**
   * Test Builder {@link Builder#ratings(Collection)}.
   * <ul>
   *   <li>Given {@link ScenarioRatingItem}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ScenarioRatingItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratings(Collection)}
   */
  @Test
  @DisplayName("Test Builder ratings(Collection); given ScenarioRatingItem; when ArrayList() add ScenarioRatingItem")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratings(Collection)"})
  void testBuilderRatings_givenScenarioRatingItem_whenArrayListAddScenarioRatingItem() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();
    ratings.add(mock(ScenarioRatingItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(ratings));
  }

  /**
   * Test Builder {@link Builder#ratings(Collection)}.
   * <ul>
   *   <li>Given {@link ScenarioRatingItem}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ScenarioRatingItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratings(Collection)}
   */
  @Test
  @DisplayName("Test Builder ratings(Collection); given ScenarioRatingItem; when ArrayList() add ScenarioRatingItem")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratings(Collection)"})
  void testBuilderRatings_givenScenarioRatingItem_whenArrayListAddScenarioRatingItem2() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();
    ratings.add(mock(ScenarioRatingItem.class));
    ratings.add(mock(ScenarioRatingItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(ratings));
  }

  /**
   * Test Builder {@link Builder#ratings(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratings(Collection)}
   */
  @Test
  @DisplayName("Test Builder ratings(Collection); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratings(Collection)"})
  void testBuilderRatings_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#roadmap(Roadmap)}.
   * <ul>
   *   <li>When {@link Roadmap}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#roadmap(Roadmap)}
   */
  @Test
  @DisplayName("Test Builder roadmap(Roadmap); when Roadmap; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.roadmap(Roadmap)"})
  void testBuilderRoadmap_whenRoadmap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roadmap(mock(Roadmap.class)));
  }

  /**
   * Test Builder {@link Builder#scenario(Scenario)}.
   * <ul>
   *   <li>When {@link Scenario}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#scenario(Scenario)}
   */
  @Test
  @DisplayName("Test Builder scenario(Scenario); when Scenario; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.scenario(Scenario)"})
  void testBuilderScenario_whenScenario_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenario(mock(Scenario.class)));
  }

  /**
   * Test Json {@link Json#axisDefinitions()}.
   * <p>
   * Method under test: {@link Json#axisDefinitions()}
   */
  @Test
  @DisplayName("Test Json axisDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection Json.axisDefinitions()"})
  void testJsonAxisDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).axisDefinitions());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAxisDefinitions(Collection)}
   *   <li>{@link Json#setRatings(Collection)}
   *   <li>{@link Json#setRoadmap(Roadmap)}
   *   <li>{@link Json#setScenario(Scenario)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAxisDefinitions(Collection)",
      "void Json.setRatings(Collection)", "void Json.setRoadmap(Roadmap)", "void Json.setScenario(Scenario)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAxisDefinitions(new ArrayList<>());
    actualJson.setRatings(new ArrayList<>());
    actualJson.setRoadmap(null);
    actualJson.setScenario(null);

    // Assert
    Collection<ScenarioAxisItem> collection = actualJson.axisDefinitions;
    assertTrue(collection instanceof List);
    Collection<ScenarioRatingItem> collection2 = actualJson.ratings;
    assertTrue(collection2 instanceof List);
    assertNull(actualJson.roadmap);
    assertNull(actualJson.scenario);
    assertTrue(collection.isEmpty());
    assertTrue(collection2.isEmpty());
  }

  /**
   * Test Json {@link Json#ratings()}.
   * <p>
   * Method under test: {@link Json#ratings()}
   */
  @Test
  @DisplayName("Test Json ratings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection Json.ratings()"})
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratings());
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
   * Test Json {@link Json#scenario()}.
   * <p>
   * Method under test: {@link Json#scenario()}
   */
  @Test
  @DisplayName("Test Json scenario()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Scenario Json.scenario()"})
  void testJsonScenario() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).scenario());
  }
}
