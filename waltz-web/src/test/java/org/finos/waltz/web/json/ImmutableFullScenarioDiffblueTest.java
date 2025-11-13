package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.AxisOrientation;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.roadmap.ImmutableRoadmap;
import org.finos.waltz.model.roadmap.Roadmap;
import org.finos.waltz.model.scenario.ImmutableScenario;
import org.finos.waltz.model.scenario.ImmutableScenarioAxisItem;
import org.finos.waltz.model.scenario.ImmutableScenarioRatingItem;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.model.scenario.ScenarioAxisItem;
import org.finos.waltz.model.scenario.ScenarioRatingItem;
import org.finos.waltz.model.scenario.ScenarioType;
import org.finos.waltz.web.json.ImmutableFullScenario.Builder;
import org.finos.waltz.web.json.ImmutableFullScenario.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class ImmutableFullScenarioDiffblueTest {
  /**
   * Test Builder {@link Builder#axisDefinitions(Collection)}.
   *
   * <p>Method under test: {@link Builder#axisDefinitions(Collection)}
   */
  @Test
  @DisplayName("Test Builder axisDefinitions(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.axisDefinitions(Collection)"})
  void testBuilderAxisDefinitions() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();

    ImmutableScenarioAxisItem.Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    axisDefinitions.add(
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build());

    // Act
    Builder actualAxisDefinitionsResult = builderResult.axisDefinitions(axisDefinitions);

    // Assert
    assertSame(builderResult, actualAxisDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#axisDefinitions(Collection)}.
   *
   * <p>Method under test: {@link Builder#axisDefinitions(Collection)}
   */
  @Test
  @DisplayName("Test Builder axisDefinitions(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.axisDefinitions(Collection)"})
  void testBuilderAxisDefinitions2() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();

    ImmutableScenarioAxisItem.Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    axisDefinitions.add(
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build());

    ImmutableScenarioAxisItem.Builder axisOrientationResult2 =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    axisDefinitions.add(
        axisOrientationResult2
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build());

    // Act
    Builder actualAxisDefinitionsResult = builderResult.axisDefinitions(axisDefinitions);

    // Assert
    assertSame(builderResult, actualAxisDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#axisDefinitions(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#axisDefinitions(Collection)}
   */
  @Test
  @DisplayName("Test Builder axisDefinitions(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.axisDefinitions(Collection)"})
  void testBuilderAxisDefinitions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    // Act
    Builder actualAxisDefinitionsResult = builderResult.axisDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAxisDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFullScenario Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableFullScenario.builder();
    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();
    Builder actualAxisDefinitionsResult = actualBuilderResult.axisDefinitions(axisDefinitions);
    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();
    Builder actualRatingsResult = actualAxisDefinitionsResult.ratings(ratings);
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmap roadmap =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Builder actualRoadmapResult = actualRatingsResult.roadmap(roadmap);
    ImmutableScenario scenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();
    ImmutableFullScenario actualImmutableFullScenario =
        actualRoadmapResult.scenario(scenario).build();

    // Assert
    Collection<ScenarioAxisItem> axisDefinitionsResult =
        actualImmutableFullScenario.axisDefinitions();
    assertTrue(axisDefinitionsResult instanceof List);
    Collection<ScenarioRatingItem> ratingsResult = actualImmutableFullScenario.ratings();
    assertTrue(ratingsResult instanceof List);
    assertSame(axisDefinitions, axisDefinitionsResult);
    assertSame(ratings, ratingsResult);
    assertSame(roadmap, actualImmutableFullScenario.roadmap());
    assertSame(scenario, actualImmutableFullScenario.scenario());
  }

  /**
   * Test Builder {@link Builder#from(FullScenario)}.
   *
   * <p>Method under test: {@link Builder#from(FullScenario)}
   */
  @Test
  @DisplayName("Test Builder from(FullScenario)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FullScenario)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    Builder builderResult2 = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult2.axisDefinitions(new ArrayList<>());

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult3 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult3
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario instance =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFullScenario actualImmutableFullScenario = builderResult.build();
    assertEquals(instance, actualImmutableFullScenario);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratings(Collection)}.
   *
   * <p>Method under test: {@link Builder#ratings(Collection)}
   */
  @Test
  @DisplayName("Test Builder ratings(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratings(Collection)"})
  void testBuilderRatings() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();

    ImmutableScenarioRatingItem.Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    ImmutableScenarioRatingItem.Builder descriptionResult =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    ImmutableScenarioRatingItem.Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ratings.add(
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());

    // Act
    Builder actualRatingsResult = builderResult.ratings(ratings);

    // Assert
    assertSame(builderResult, actualRatingsResult);
  }

  /**
   * Test Builder {@link Builder#ratings(Collection)}.
   *
   * <p>Method under test: {@link Builder#ratings(Collection)}
   */
  @Test
  @DisplayName("Test Builder ratings(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratings(Collection)"})
  void testBuilderRatings2() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();

    ImmutableScenarioRatingItem.Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    ImmutableScenarioRatingItem.Builder descriptionResult =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    ImmutableScenarioRatingItem.Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ratings.add(
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());

    ImmutableScenarioRatingItem.Builder builderResult3 = ImmutableScenarioRatingItem.builder();

    ImmutableScenarioRatingItem.Builder descriptionResult2 =
        builderResult3
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    ImmutableScenarioRatingItem.Builder ratingResult2 =
        descriptionResult2
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ratings.add(
        ratingResult2
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());

    // Act
    Builder actualRatingsResult = builderResult.ratings(ratings);

    // Assert
    assertSame(builderResult, actualRatingsResult);
  }

  /**
   * Test Builder {@link Builder#ratings(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratings(Collection)}
   */
  @Test
  @DisplayName("Test Builder ratings(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratings(Collection)"})
  void testBuilderRatings_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    // Act
    Builder actualRatingsResult = builderResult.ratings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingsResult);
  }

  /**
   * Test Builder {@link Builder#roadmap(Roadmap)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#roadmap(Roadmap)}
   */
  @Test
  @DisplayName("Test Builder roadmap(Roadmap); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.roadmap(Roadmap)"})
  void testBuilderRoadmap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    // Act
    Builder actualRoadmapResult =
        builderResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Assert
    assertSame(builderResult, actualRoadmapResult);
  }

  /**
   * Test Builder {@link Builder#scenario(Scenario)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#scenario(Scenario)}
   */
  @Test
  @DisplayName("Test Builder scenario(Scenario); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenario(Scenario)"})
  void testBuilderScenario_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    // Act
    Builder actualScenarioResult =
        builderResult.scenario(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    // Assert
    assertSame(builderResult, actualScenarioResult);
  }

  /**
   * Test {@link ImmutableFullScenario#copyOf(FullScenario)}.
   *
   * <ul>
   *   <li>Then axisDefinitions return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFullScenario#copyOf(FullScenario)}
   */
  @Test
  @DisplayName("Test copyOf(FullScenario); then axisDefinitions return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFullScenario ImmutableFullScenario.copyOf(FullScenario)"})
  void testCopyOf_thenAxisDefinitionsReturnList() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();
    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(axisDefinitions);
    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();

    Builder ratingsResult = axisDefinitionsResult.ratings(ratings);

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario instance =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    // Act
    ImmutableFullScenario actualCopyOfResult = ImmutableFullScenario.copyOf(instance);

    // Assert
    Collection<ScenarioAxisItem> axisDefinitionsResult2 = actualCopyOfResult.axisDefinitions();
    assertTrue(axisDefinitionsResult2 instanceof List);
    Collection<ScenarioRatingItem> ratingsResult2 = actualCopyOfResult.ratings();
    assertTrue(ratingsResult2 instanceof List);
    assertTrue(actualCopyOfResult.roadmap() instanceof ImmutableRoadmap);
    assertTrue(actualCopyOfResult.scenario() instanceof ImmutableScenario);
    assertTrue(axisDefinitionsResult2.isEmpty());
    assertTrue(ratingsResult2.isEmpty());
    assertSame(axisDefinitions, axisDefinitionsResult2);
    assertSame(ratings, ratingsResult2);
  }

  /**
   * Test {@link ImmutableFullScenario#equals(Object)}, and {@link
   * ImmutableFullScenario#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFullScenario#equals(Object)}
   *   <li>{@link ImmutableFullScenario#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFullScenario.equals(Object)",
    "int ImmutableFullScenario.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(new ArrayList<>());

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    Builder builderResult3 = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult2 = builderResult3.axisDefinitions(new ArrayList<>());

    Builder ratingsResult2 = axisDefinitionsResult2.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult4 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult2 =
        builderResult4
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult2 =
        ratingsResult2.roadmap(
            ratingSchemeIdResult2
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario2 =
        roadmapResult2
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableFullScenario, immutableFullScenario2);
    assertEquals(immutableFullScenario.hashCode(), immutableFullScenario2.hashCode());
  }

  /**
   * Test {@link ImmutableFullScenario#equals(Object)}, and {@link
   * ImmutableFullScenario#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFullScenario#equals(Object)}
   *   <li>{@link ImmutableFullScenario#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFullScenario.equals(Object)",
    "int ImmutableFullScenario.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(new ArrayList<>());

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableFullScenario, immutableFullScenario);
    int expectedHashCodeResult = immutableFullScenario.hashCode();
    assertEquals(expectedHashCodeResult, immutableFullScenario.hashCode());
  }

  /**
   * Test {@link ImmutableFullScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFullScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFullScenario.equals(Object)",
    "int ImmutableFullScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();

    ImmutableScenarioAxisItem.Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    axisDefinitions.add(
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build());

    Builder axisDefinitionsResult =
        ImmutableFullScenario.builder().axisDefinitions(axisDefinitions);

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    Builder builderResult2 = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult2 = builderResult2.axisDefinitions(new ArrayList<>());

    Builder ratingsResult2 = axisDefinitionsResult2.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult3 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult2 =
        builderResult3
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult2 =
        ratingsResult2.roadmap(
            ratingSchemeIdResult2
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Act and Assert
    assertNotEquals(
        immutableFullScenario,
        roadmapResult2
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableFullScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFullScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFullScenario.equals(Object)",
    "int ImmutableFullScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();

    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();

    ImmutableScenarioRatingItem.Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    ImmutableScenarioRatingItem.Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ratings.add(
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());

    Builder builderResult2 = ImmutableFullScenario.builder();

    Builder ratingsResult = builderResult2.axisDefinitions(new ArrayList<>()).ratings(ratings);

    ImmutableRoadmap.Builder builderResult3 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult3
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    Builder builderResult4 = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult4.axisDefinitions(new ArrayList<>());

    Builder ratingsResult2 = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult5 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult2 =
        builderResult5
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult2 =
        ratingsResult2.roadmap(
            ratingSchemeIdResult2
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Act and Assert
    assertNotEquals(
        immutableFullScenario,
        roadmapResult2
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableFullScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFullScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFullScenario.equals(Object)",
    "int ImmutableFullScenario.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(new ArrayList<>());

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Act and Assert
    assertNotEquals(
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFullScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFullScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFullScenario.equals(Object)",
    "int ImmutableFullScenario.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(new ArrayList<>());

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Act and Assert
    assertNotEquals(
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build(),
        "Different type to ImmutableFullScenario");
  }

  /**
   * Test {@link ImmutableFullScenario#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then axisDefinitions return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFullScenario#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then axisDefinitions return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFullScenario ImmutableFullScenario.fromJson(Json)"})
  void testFromJson_thenAxisDefinitionsReturnList() {
    // Arrange
    Json json = new Json();

    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    json.setRoadmap(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    json.setScenario(
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
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
    Roadmap roadmapResult = actualFromJsonResult.roadmap();
    assertTrue(roadmapResult instanceof ImmutableRoadmap);
    Scenario scenarioResult = actualFromJsonResult.scenario();
    assertTrue(scenarioResult instanceof ImmutableScenario);
    assertTrue(axisDefinitionsResult.isEmpty());
    assertTrue(ratingsResult.isEmpty());
    assertSame(axisDefinitions, axisDefinitionsResult);
    assertSame(ratings, ratingsResult);
    assertSame(json.roadmap, roadmapResult);
    assertSame(json.scenario, scenarioResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFullScenario#toString()}
   *   <li>{@link ImmutableFullScenario#axisDefinitions()}
   *   <li>{@link ImmutableFullScenario#ratings()}
   *   <li>{@link ImmutableFullScenario#roadmap()}
   *   <li>{@link ImmutableFullScenario#scenario()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ImmutableFullScenario.axisDefinitions()",
    "Collection ImmutableFullScenario.ratings()",
    "Roadmap ImmutableFullScenario.roadmap()",
    "Scenario ImmutableFullScenario.scenario()",
    "java.lang.String ImmutableFullScenario.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();
    ArrayList<ScenarioAxisItem> axisDefinitions = new ArrayList<>();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(axisDefinitions);
    ArrayList<ScenarioRatingItem> ratings = new ArrayList<>();

    Builder ratingsResult = axisDefinitionsResult.ratings(ratings);

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    // Act
    immutableFullScenario.toString();
    Collection<ScenarioAxisItem> actualAxisDefinitionsResult =
        immutableFullScenario.axisDefinitions();
    Collection<ScenarioRatingItem> actualRatingsResult = immutableFullScenario.ratings();
    Roadmap actualRoadmapResult = immutableFullScenario.roadmap();

    // Assert
    assertTrue(actualAxisDefinitionsResult instanceof List);
    assertTrue(actualRatingsResult instanceof List);
    assertTrue(actualRoadmapResult instanceof ImmutableRoadmap);
    assertTrue(immutableFullScenario.scenario() instanceof ImmutableScenario);
    assertSame(axisDefinitions, actualAxisDefinitionsResult);
    assertSame(ratings, actualRatingsResult);
  }

  /**
   * Test Json {@link Json#axisDefinitions()}.
   *
   * <p>Method under test: {@link Json#axisDefinitions()}
   */
  @Test
  @DisplayName("Test Json axisDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Json.axisDefinitions()"})
  void testJsonAxisDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().axisDefinitions());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAxisDefinitions(Collection)",
    "void Json.setRatings(Collection)",
    "void Json.setRoadmap(Roadmap)",
    "void Json.setScenario(Scenario)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAxisDefinitions(new ArrayList<>());
    actualJson.setRatings(new ArrayList<>());
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    actualJson.setRoadmap(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    actualJson.setScenario(
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());

    // Assert
    Collection<ScenarioAxisItem> collection = actualJson.axisDefinitions;
    assertTrue(collection instanceof List);
    Collection<ScenarioRatingItem> collection2 = actualJson.ratings;
    assertTrue(collection2 instanceof List);
    Roadmap roadmap = actualJson.roadmap;
    EntityReference columnTypeResult = roadmap.columnType();
    assertTrue(columnTypeResult instanceof ImmutableEntityReference);
    EntityReference rowTypeResult = roadmap.rowType();
    assertTrue(rowTypeResult instanceof ImmutableEntityReference);
    assertTrue(roadmap instanceof ImmutableRoadmap);
    Scenario scenario = actualJson.scenario;
    assertTrue(scenario instanceof ImmutableScenario);
    LocalDateTime lastUpdatedAtResult = roadmap.lastUpdatedAt();
    LocalTime toLocalTimeResult = lastUpdatedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult2 = scenario.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult2.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate effectiveDateResult = scenario.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", roadmap.lastUpdatedBy());
    assertEquals("2020-03-01", scenario.lastUpdatedBy());
    assertEquals("Name", roadmap.name());
    assertEquals("Name", scenario.name());
    assertEquals("The characteristics of someone or something", columnTypeResult.description());
    assertEquals("The characteristics of someone or something", roadmap.description());
    assertEquals("The characteristics of someone or something", scenario.description());
    assertEquals(0, scenario.position());
    assertEquals(1L, columnTypeResult.id());
    assertEquals(1L, roadmap.ratingSchemeId());
    assertEquals(1L, scenario.roadmapId());
    assertEquals(EntityKind.ALL, columnTypeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, roadmap.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, scenario.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnTypeResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, scenario.releaseStatus());
    assertEquals(ScenarioType.TARGET, scenario.scenarioType());
    assertTrue(collection.isEmpty());
    assertTrue(collection2.isEmpty());
    assertEquals(columnTypeResult, rowTypeResult);
    assertSame(toLocalTimeResult, lastUpdatedAtResult2.toLocalTime());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test Json {@link Json#ratings()}.
   *
   * <p>Method under test: {@link Json#ratings()}
   */
  @Test
  @DisplayName("Test Json ratings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Json.ratings()"})
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratings());
  }

  /**
   * Test Json {@link Json#roadmap()}.
   *
   * <p>Method under test: {@link Json#roadmap()}
   */
  @Test
  @DisplayName("Test Json roadmap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Roadmap Json.roadmap()"})
  void testJsonRoadmap() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().roadmap());
  }

  /**
   * Test Json {@link Json#scenario()}.
   *
   * <p>Method under test: {@link Json#scenario()}
   */
  @Test
  @DisplayName("Test Json scenario()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scenario Json.scenario()"})
  void testJsonScenario() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().scenario());
  }

  /**
   * Test {@link ImmutableFullScenario#withAxisDefinitions(Collection)}.
   *
   * <p>Method under test: {@link ImmutableFullScenario#withAxisDefinitions(Collection)}
   */
  @Test
  @DisplayName("Test withAxisDefinitions(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFullScenario ImmutableFullScenario.withAxisDefinitions(Collection)"})
  void testWithAxisDefinitions() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(new ArrayList<>());

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    // Act
    ImmutableFullScenario actualWithAxisDefinitionsResult =
        immutableFullScenario.withAxisDefinitions(new ArrayList<>());

    // Assert
    assertEquals(immutableFullScenario, actualWithAxisDefinitionsResult);
  }

  /**
   * Test {@link ImmutableFullScenario#withRatings(Collection)}.
   *
   * <p>Method under test: {@link ImmutableFullScenario#withRatings(Collection)}
   */
  @Test
  @DisplayName("Test withRatings(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFullScenario ImmutableFullScenario.withRatings(Collection)"})
  void testWithRatings() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(new ArrayList<>());

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    // Act
    ImmutableFullScenario actualWithRatingsResult =
        immutableFullScenario.withRatings(new ArrayList<>());

    // Assert
    assertEquals(immutableFullScenario, actualWithRatingsResult);
  }

  /**
   * Test {@link ImmutableFullScenario#withRoadmap(Roadmap)}.
   *
   * <p>Method under test: {@link ImmutableFullScenario#withRoadmap(Roadmap)}
   */
  @Test
  @DisplayName("Test withRoadmap(Roadmap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFullScenario ImmutableFullScenario.withRoadmap(Roadmap)"})
  void testWithRoadmap() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(new ArrayList<>());

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    ImmutableRoadmap.Builder builderResult3 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult2 =
        builderResult3
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    // Act
    ImmutableFullScenario actualWithRoadmapResult =
        immutableFullScenario.withRoadmap(
            ratingSchemeIdResult2
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Assert
    assertEquals(immutableFullScenario, actualWithRoadmapResult);
  }

  /**
   * Test {@link ImmutableFullScenario#withScenario(Scenario)}.
   *
   * <p>Method under test: {@link ImmutableFullScenario#withScenario(Scenario)}
   */
  @Test
  @DisplayName("Test withScenario(Scenario)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFullScenario ImmutableFullScenario.withScenario(Scenario)"})
  void testWithScenario() {
    // Arrange
    Builder builderResult = ImmutableFullScenario.builder();

    Builder axisDefinitionsResult = builderResult.axisDefinitions(new ArrayList<>());

    Builder ratingsResult = axisDefinitionsResult.ratings(new ArrayList<>());

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
        ratingsResult.roadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    ImmutableFullScenario immutableFullScenario =
        roadmapResult
            .scenario(
                ImmutableScenario.builder()
                    .description("The characteristics of someone or something")
                    .effectiveDate(LocalDate.of(1970, 1, 1))
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                    .roadmapId(1L)
                    .scenarioType(ScenarioType.TARGET)
                    .build())
            .build();

    // Act
    ImmutableFullScenario actualWithScenarioResult =
        immutableFullScenario.withScenario(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    // Assert
    assertEquals(immutableFullScenario, actualWithScenarioResult);
  }
}
