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
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.roadmap.Roadmap;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.model.scenario.ScenarioAxisItem;
import org.finos.waltz.model.scenario.ScenarioRatingItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ImmutableFullScenario.Builder.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class ImmutableFullScenarioDiffblueTest {
  @Autowired
  private ImmutableFullScenario.Builder builder;

  @InjectMocks
  private ImmutableFullScenario immutableFullScenario;

  /**
   * Method under test:
   * {@link ImmutableFullScenario.Builder#axisDefinitions(Collection)}
   */
  @Test
  void testBuilderAxisDefinitions() {
    // Arrange, Act and Assert
    assertSame(builder, builder.axisDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableFullScenario.Builder#axisDefinitions(Collection)}
   */
  @Test
  void testBuilderAxisDefinitions2() {
    // Arrange
    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();
    axisDefinitions.add(mock(ScenarioAxisItem.class));

    // Act and Assert
    assertSame(builder, builder.axisDefinitions(axisDefinitions));
  }

  /**
   * Method under test:
   * {@link ImmutableFullScenario.Builder#axisDefinitions(Collection)}
   */
  @Test
  void testBuilderAxisDefinitions3() {
    // Arrange
    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();
    axisDefinitions.add(mock(ScenarioAxisItem.class));
    axisDefinitions.add(mock(ScenarioAxisItem.class));

    // Act and Assert
    assertSame(builder, builder.axisDefinitions(axisDefinitions));
  }

  /**
   * Method under test: {@link ImmutableFullScenario.Builder#from(FullScenario)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFullScenario.Builder builderResult = ImmutableFullScenario.builder();
    FullScenario instance = mock(FullScenario.class);
    when(instance.scenario()).thenThrow(new IllegalStateException("instance"));
    when(instance.roadmap()).thenReturn(mock(Roadmap.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).roadmap();
    verify(instance).scenario();
  }

  /**
   * Method under test: {@link ImmutableFullScenario.Builder#from(FullScenario)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFullScenario.Builder builderResult = ImmutableFullScenario.builder();
    FullScenario instance = mock(FullScenario.class);
    ArrayList<ScenarioAxisItem> scenarioAxisItemList = new ArrayList<>();
    when(instance.axisDefinitions()).thenReturn(scenarioAxisItemList);
    ArrayList<ScenarioRatingItem> scenarioRatingItemList = new ArrayList<>();
    when(instance.ratings()).thenReturn(scenarioRatingItemList);
    when(instance.scenario()).thenReturn(mock(Scenario.class));
    when(instance.roadmap()).thenReturn(mock(Roadmap.class));

    // Act
    ImmutableFullScenario.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableFullScenario.Builder#from(FullScenario)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFullScenario.Builder builderResult = ImmutableFullScenario.builder();
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
   * Method under test: {@link ImmutableFullScenario.Builder#ratings(Collection)}
   */
  @Test
  void testBuilderRatings() {
    // Arrange, Act and Assert
    assertSame(builder, builder.ratings(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableFullScenario.Builder#ratings(Collection)}
   */
  @Test
  void testBuilderRatings2() {
    // Arrange
    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();
    ratings.add(mock(ScenarioRatingItem.class));

    // Act and Assert
    assertSame(builder, builder.ratings(ratings));
  }

  /**
   * Method under test: {@link ImmutableFullScenario.Builder#ratings(Collection)}
   */
  @Test
  void testBuilderRatings3() {
    // Arrange
    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();
    ratings.add(mock(ScenarioRatingItem.class));
    ratings.add(mock(ScenarioRatingItem.class));

    // Act and Assert
    assertSame(builder, builder.ratings(ratings));
  }

  /**
   * Method under test: {@link ImmutableFullScenario.Builder#roadmap(Roadmap)}
   */
  @Test
  void testBuilderRoadmap() {
    // Arrange
    ImmutableFullScenario.Builder builderResult = ImmutableFullScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roadmap(mock(Roadmap.class)));
  }

  /**
   * Method under test: {@link ImmutableFullScenario.Builder#scenario(Scenario)}
   */
  @Test
  void testBuilderScenario() {
    // Arrange
    ImmutableFullScenario.Builder builderResult = ImmutableFullScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenario(mock(Scenario.class)));
  }

  /**
   * Method under test: {@link ImmutableFullScenario#copyOf(FullScenario)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FullScenario instance = mock(FullScenario.class);
    ArrayList<ScenarioAxisItem> scenarioAxisItemList = new ArrayList<>();
    when(instance.axisDefinitions()).thenReturn(scenarioAxisItemList);
    ArrayList<ScenarioRatingItem> scenarioRatingItemList = new ArrayList<>();
    when(instance.ratings()).thenReturn(scenarioRatingItemList);
    when(instance.scenario()).thenReturn(mock(Scenario.class));
    when(instance.roadmap()).thenReturn(mock(Roadmap.class));

    // Act
    ImmutableFullScenario actualCopyOfResult = ImmutableFullScenario.copyOf(instance);

    // Assert
    verify(instance).axisDefinitions();
    verify(instance).ratings();
    verify(instance).roadmap();
    verify(instance).scenario();
    Collection<ScenarioAxisItem> axisDefinitionsResult = actualCopyOfResult.axisDefinitions();
    assertTrue(axisDefinitionsResult instanceof List);
    Collection<ScenarioRatingItem> ratingsResult = actualCopyOfResult.ratings();
    assertTrue(ratingsResult instanceof List);
    assertTrue(axisDefinitionsResult.isEmpty());
    assertTrue(ratingsResult.isEmpty());
    assertSame(scenarioAxisItemList, axisDefinitionsResult);
    assertSame(scenarioRatingItemList, ratingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFullScenario#fromJson(ImmutableFullScenario.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableFullScenario.Json json = new ImmutableFullScenario.Json();
    json.setRoadmap(mock(Roadmap.class));
    json.setScenario(mock(Scenario.class));
    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();
    json.setAxisDefinitions(axisDefinitions);
    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();
    json.setRatings(ratings);

    // Act
    ImmutableFullScenario actualFromJsonResult = ImmutableFullScenario.fromJson(json);

    // Assert
    Collection<ScenarioAxisItem> axisDefinitionsResult = actualFromJsonResult.axisDefinitions();
    assertTrue(axisDefinitionsResult instanceof List);
    Collection<ScenarioRatingItem> ratingsResult = actualFromJsonResult.ratings();
    assertTrue(ratingsResult instanceof List);
    assertTrue(axisDefinitionsResult.isEmpty());
    assertTrue(ratingsResult.isEmpty());
    assertSame(axisDefinitions, axisDefinitionsResult);
    assertSame(ratings, ratingsResult);
    Roadmap expectedRoadmapResult = json.roadmap;
    assertSame(expectedRoadmapResult, actualFromJsonResult.roadmap());
    Scenario expectedScenarioResult = json.scenario;
    assertSame(expectedScenarioResult, actualFromJsonResult.scenario());
  }

  /**
   * Method under test: {@link ImmutableFullScenario.Json#axisDefinitions()}
   */
  @Test
  void testJsonAxisDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFullScenario.Json()).axisDefinitions());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableFullScenario.Json}
   *   <li>{@link ImmutableFullScenario.Json#setAxisDefinitions(Collection)}
   *   <li>{@link ImmutableFullScenario.Json#setRatings(Collection)}
   *   <li>{@link ImmutableFullScenario.Json#setRoadmap(Roadmap)}
   *   <li>{@link ImmutableFullScenario.Json#setScenario(Scenario)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableFullScenario.Json actualJson = new ImmutableFullScenario.Json();
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
   * Method under test: {@link ImmutableFullScenario.Json#ratings()}
   */
  @Test
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFullScenario.Json()).ratings());
  }

  /**
   * Method under test: {@link ImmutableFullScenario.Json#roadmap()}
   */
  @Test
  void testJsonRoadmap() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFullScenario.Json()).roadmap());
  }

  /**
   * Method under test: {@link ImmutableFullScenario.Json#scenario()}
   */
  @Test
  void testJsonScenario() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFullScenario.Json()).scenario());
  }

  /**
   * Method under test:
   * {@link ImmutableFullScenario#withAxisDefinitions(Collection)}
   */
  @Test
  void testWithAxisDefinitions() {
    // Arrange
    ArrayList<ScenarioAxisItem> value = new ArrayList<>();

    // Act
    ImmutableFullScenario actualWithAxisDefinitionsResult = immutableFullScenario.withAxisDefinitions(value);

    // Assert
    Collection<ScenarioAxisItem> axisDefinitionsResult = actualWithAxisDefinitionsResult.axisDefinitions();
    assertTrue(axisDefinitionsResult instanceof List);
    assertNull(actualWithAxisDefinitionsResult.ratings());
    assertNull(actualWithAxisDefinitionsResult.roadmap());
    assertNull(actualWithAxisDefinitionsResult.scenario());
    assertTrue(axisDefinitionsResult.isEmpty());
    assertSame(value, axisDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFullScenario#withAxisDefinitions(Collection)}
   */
  @Test
  void testWithAxisDefinitions2() {
    // Arrange
    ArrayList<ScenarioAxisItem> value = new ArrayList<>();
    value.add(mock(ScenarioAxisItem.class));

    // Act
    ImmutableFullScenario actualWithAxisDefinitionsResult = immutableFullScenario.withAxisDefinitions(value);

    // Assert
    Collection<ScenarioAxisItem> axisDefinitionsResult = actualWithAxisDefinitionsResult.axisDefinitions();
    assertEquals(1, axisDefinitionsResult.size());
    assertTrue(axisDefinitionsResult instanceof List);
    assertNull(actualWithAxisDefinitionsResult.ratings());
    assertNull(actualWithAxisDefinitionsResult.roadmap());
    assertNull(actualWithAxisDefinitionsResult.scenario());
    assertSame(value, axisDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFullScenario#withAxisDefinitions(Collection)}
   */
  @Test
  void testWithAxisDefinitions3() {
    // Arrange
    ArrayList<ScenarioAxisItem> value = new ArrayList<>();
    value.add(mock(ScenarioAxisItem.class));
    value.add(mock(ScenarioAxisItem.class));

    // Act
    ImmutableFullScenario actualWithAxisDefinitionsResult = immutableFullScenario.withAxisDefinitions(value);

    // Assert
    assertNull(actualWithAxisDefinitionsResult.ratings());
    assertNull(actualWithAxisDefinitionsResult.roadmap());
    assertNull(actualWithAxisDefinitionsResult.scenario());
    assertSame(value, actualWithAxisDefinitionsResult.axisDefinitions());
  }

  /**
   * Method under test: {@link ImmutableFullScenario#withRatings(Collection)}
   */
  @Test
  void testWithRatings() {
    // Arrange
    ArrayList<ScenarioRatingItem> value = new ArrayList<>();

    // Act
    ImmutableFullScenario actualWithRatingsResult = immutableFullScenario.withRatings(value);

    // Assert
    Collection<ScenarioRatingItem> ratingsResult = actualWithRatingsResult.ratings();
    assertTrue(ratingsResult instanceof List);
    assertNull(actualWithRatingsResult.axisDefinitions());
    assertNull(actualWithRatingsResult.roadmap());
    assertNull(actualWithRatingsResult.scenario());
    assertTrue(ratingsResult.isEmpty());
    assertSame(value, ratingsResult);
  }

  /**
   * Method under test: {@link ImmutableFullScenario#withRatings(Collection)}
   */
  @Test
  void testWithRatings2() {
    // Arrange
    ArrayList<ScenarioRatingItem> value = new ArrayList<>();
    value.add(mock(ScenarioRatingItem.class));

    // Act
    ImmutableFullScenario actualWithRatingsResult = immutableFullScenario.withRatings(value);

    // Assert
    Collection<ScenarioRatingItem> ratingsResult = actualWithRatingsResult.ratings();
    assertEquals(1, ratingsResult.size());
    assertTrue(ratingsResult instanceof List);
    assertNull(actualWithRatingsResult.axisDefinitions());
    assertNull(actualWithRatingsResult.roadmap());
    assertNull(actualWithRatingsResult.scenario());
    assertSame(value, ratingsResult);
  }

  /**
   * Method under test: {@link ImmutableFullScenario#withRatings(Collection)}
   */
  @Test
  void testWithRatings3() {
    // Arrange
    ArrayList<ScenarioRatingItem> value = new ArrayList<>();
    value.add(mock(ScenarioRatingItem.class));
    value.add(mock(ScenarioRatingItem.class));

    // Act
    ImmutableFullScenario actualWithRatingsResult = immutableFullScenario.withRatings(value);

    // Assert
    assertNull(actualWithRatingsResult.axisDefinitions());
    assertNull(actualWithRatingsResult.roadmap());
    assertNull(actualWithRatingsResult.scenario());
    assertSame(value, actualWithRatingsResult.ratings());
  }
}
