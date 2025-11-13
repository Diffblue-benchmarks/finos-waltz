package org.finos.waltz.model.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.roadmap.ImmutableRoadmapAndScenarioOverview.Builder;
import org.finos.waltz.model.roadmap.ImmutableRoadmapAndScenarioOverview.Json;
import org.finos.waltz.model.scenario.ImmutableScenario;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.model.scenario.ScenarioType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRoadmapAndScenarioOverviewDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRoadmapAndScenarioOverview Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableRoadmapAndScenarioOverview.builder();
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
    Builder actualRoadmapResult = actualBuilderResult.roadmap(roadmap);
    ArrayList<Scenario> scenarios = new ArrayList<>();
    ImmutableRoadmapAndScenarioOverview actualImmutableRoadmapAndScenarioOverview =
        actualRoadmapResult.scenarios(scenarios).build();

    // Assert
    Collection<Scenario> scenariosResult = actualImmutableRoadmapAndScenarioOverview.scenarios();
    assertTrue(scenariosResult instanceof List);
    assertSame(scenarios, scenariosResult);
    assertSame(roadmap, actualImmutableRoadmapAndScenarioOverview.roadmap());
  }

  /**
   * Test Builder {@link Builder#from(RoadmapAndScenarioOverview)}.
   *
   * <p>Method under test: {@link Builder#from(RoadmapAndScenarioOverview)}
   */
  @Test
  @DisplayName("Test Builder from(RoadmapAndScenarioOverview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RoadmapAndScenarioOverview)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    Builder builderResult2 = ImmutableRoadmapAndScenarioOverview.builder();

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
        builderResult2.roadmap(
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
    ImmutableRoadmapAndScenarioOverview instance =
        roadmapResult.scenarios(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRoadmapAndScenarioOverview actualImmutableRoadmapAndScenarioOverview =
        builderResult.build();
    assertEquals(instance, actualImmutableRoadmapAndScenarioOverview);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#roadmap(Roadmap)}.
   *
   * <ul>
   *   <li>When {@link ImmutableRoadmap.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#roadmap(Roadmap)}
   */
  @Test
  @DisplayName(
      "Test Builder roadmap(Roadmap); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.roadmap(Roadmap)"})
  void testBuilderRoadmap_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    // Act
    Builder actualRoadmapResult = builderResult.roadmap(new ImmutableRoadmap.Json());

    // Assert
    assertSame(builderResult, actualRoadmapResult);
  }

  /**
   * Test Builder {@link Builder#scenarios(Collection)}.
   *
   * <p>Method under test: {@link Builder#scenarios(Collection)}
   */
  @Test
  @DisplayName("Test Builder scenarios(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenarios(Collection)"})
  void testBuilderScenarios() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    ArrayList<Scenario> scenarios = new ArrayList<>();
    scenarios.add(
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

    // Act
    Builder actualScenariosResult = builderResult.scenarios(scenarios);

    // Assert
    assertSame(builderResult, actualScenariosResult);
  }

  /**
   * Test Builder {@link Builder#scenarios(Collection)}.
   *
   * <p>Method under test: {@link Builder#scenarios(Collection)}
   */
  @Test
  @DisplayName("Test Builder scenarios(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenarios(Collection)"})
  void testBuilderScenarios2() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    ArrayList<Scenario> scenarios = new ArrayList<>();
    scenarios.add(
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
    scenarios.add(
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

    // Act
    Builder actualScenariosResult = builderResult.scenarios(scenarios);

    // Assert
    assertSame(builderResult, actualScenariosResult);
  }

  /**
   * Test Builder {@link Builder#scenarios(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#scenarios(Collection)}
   */
  @Test
  @DisplayName("Test Builder scenarios(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenarios(Collection)"})
  void testBuilderScenarios_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    // Act
    Builder actualScenariosResult = builderResult.scenarios(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualScenariosResult);
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#copyOf(RoadmapAndScenarioOverview)}.
   *
   * <ul>
   *   <li>Then scenarios return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRoadmapAndScenarioOverview#copyOf(RoadmapAndScenarioOverview)}
   */
  @Test
  @DisplayName("Test copyOf(RoadmapAndScenarioOverview); then scenarios return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapAndScenarioOverview ImmutableRoadmapAndScenarioOverview.copyOf(RoadmapAndScenarioOverview)"
  })
  void testCopyOf_thenScenariosReturnList() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    Builder roadmapResult =
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
    ArrayList<Scenario> scenarios = new ArrayList<>();
    ImmutableRoadmapAndScenarioOverview instance = roadmapResult.scenarios(scenarios).build();

    // Act
    ImmutableRoadmapAndScenarioOverview actualCopyOfResult =
        ImmutableRoadmapAndScenarioOverview.copyOf(instance);

    // Assert
    Collection<Scenario> scenariosResult = actualCopyOfResult.scenarios();
    assertTrue(scenariosResult instanceof List);
    Roadmap roadmapResult2 = actualCopyOfResult.roadmap();
    EntityReference columnTypeResult = roadmapResult2.columnType();
    assertTrue(columnTypeResult instanceof ImmutableEntityReference);
    EntityReference rowTypeResult = roadmapResult2.rowType();
    assertTrue(rowTypeResult instanceof ImmutableEntityReference);
    assertTrue(roadmapResult2 instanceof ImmutableRoadmap);
    assertEquals("2020-03-01", roadmapResult2.lastUpdatedBy());
    assertEquals("Name", roadmapResult2.name());
    assertEquals("The characteristics of someone or something", roadmapResult2.description());
    assertEquals("The characteristics of someone or something", columnTypeResult.description());
    assertEquals(1L, columnTypeResult.id());
    assertEquals(1L, roadmapResult2.ratingSchemeId());
    assertEquals(EntityKind.ALL, columnTypeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, roadmapResult2.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnTypeResult.entityLifecycleStatus());
    assertTrue(scenariosResult.isEmpty());
    assertEquals(columnTypeResult, rowTypeResult);
    assertSame(scenarios, scenariosResult);
    assertSame(ofResult, roadmapResult2.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}, and {@link
   * ImmutableRoadmapAndScenarioOverview#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRoadmapAndScenarioOverview#equals(Object)}
   *   <li>{@link ImmutableRoadmapAndScenarioOverview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapAndScenarioOverview.equals(Object)",
    "int ImmutableRoadmapAndScenarioOverview.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

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
    ImmutableRoadmapAndScenarioOverview immutableRoadmapAndScenarioOverview =
        roadmapResult.scenarios(new ArrayList<>()).build();

    Builder builderResult3 = ImmutableRoadmapAndScenarioOverview.builder();

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
        builderResult3.roadmap(
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
    ImmutableRoadmapAndScenarioOverview immutableRoadmapAndScenarioOverview2 =
        roadmapResult2.scenarios(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableRoadmapAndScenarioOverview, immutableRoadmapAndScenarioOverview2);
    assertEquals(
        immutableRoadmapAndScenarioOverview.hashCode(),
        immutableRoadmapAndScenarioOverview2.hashCode());
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}, and {@link
   * ImmutableRoadmapAndScenarioOverview#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRoadmapAndScenarioOverview#equals(Object)}
   *   <li>{@link ImmutableRoadmapAndScenarioOverview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapAndScenarioOverview.equals(Object)",
    "int ImmutableRoadmapAndScenarioOverview.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

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
    ImmutableRoadmapAndScenarioOverview immutableRoadmapAndScenarioOverview =
        roadmapResult.scenarios(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableRoadmapAndScenarioOverview, immutableRoadmapAndScenarioOverview);
    int expectedHashCodeResult = immutableRoadmapAndScenarioOverview.hashCode();
    assertEquals(expectedHashCodeResult, immutableRoadmapAndScenarioOverview.hashCode());
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapAndScenarioOverview.equals(Object)",
    "int ImmutableRoadmapAndScenarioOverview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Scenario> scenarios = new ArrayList<>();
    scenarios.add(
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

    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

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
    ImmutableRoadmapAndScenarioOverview immutableRoadmapAndScenarioOverview =
        builderResult
            .roadmap(
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
                    .build())
            .scenarios(scenarios)
            .build();

    Builder builderResult3 = ImmutableRoadmapAndScenarioOverview.builder();

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

    Builder roadmapResult =
        builderResult3.roadmap(
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
        immutableRoadmapAndScenarioOverview, roadmapResult.scenarios(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapAndScenarioOverview.equals(Object)",
    "int ImmutableRoadmapAndScenarioOverview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
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
    ImmutableRoadmapAndScenarioOverview immutableRoadmapAndScenarioOverview =
        roadmapResult.scenarios(new ArrayList<>()).build();

    Builder builderResult3 = ImmutableRoadmapAndScenarioOverview.builder();

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
        builderResult3.roadmap(
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
        immutableRoadmapAndScenarioOverview, roadmapResult2.scenarios(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapAndScenarioOverview.equals(Object)",
    "int ImmutableRoadmapAndScenarioOverview.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

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

    // Act and Assert
    assertNotEquals(roadmapResult.scenarios(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapAndScenarioOverview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapAndScenarioOverview.equals(Object)",
    "int ImmutableRoadmapAndScenarioOverview.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

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

    // Act and Assert
    assertNotEquals(
        roadmapResult.scenarios(new ArrayList<>()).build(),
        "Different type to ImmutableRoadmapAndScenarioOverview");
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableRoadmap.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Roadmap is {@link ImmutableRoadmap.Json} (default
   *       constructor).
   *   <li>Then scenarios return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapAndScenarioOverview#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Roadmap is Json (default constructor); then scenarios return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapAndScenarioOverview ImmutableRoadmapAndScenarioOverview.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonRoadmapIsJson_thenScenariosReturnList() {
    // Arrange
    Json json = new Json();
    ImmutableRoadmap.Json roadmap = new ImmutableRoadmap.Json();
    json.setRoadmap(roadmap);
    ArrayList<Scenario> scenarios = new ArrayList<>();
    json.setScenarios(scenarios);

    // Act
    ImmutableRoadmapAndScenarioOverview actualFromJsonResult =
        ImmutableRoadmapAndScenarioOverview.fromJson(json);

    // Assert
    Collection<Scenario> scenariosResult = actualFromJsonResult.scenarios();
    assertTrue(scenariosResult instanceof List);
    assertTrue(scenariosResult.isEmpty());
    assertSame(scenarios, scenariosResult);
    assertSame(roadmap, actualFromJsonResult.roadmap());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRoadmapAndScenarioOverview#toString()}
   *   <li>{@link ImmutableRoadmapAndScenarioOverview#roadmap()}
   *   <li>{@link ImmutableRoadmapAndScenarioOverview#scenarios()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Roadmap ImmutableRoadmapAndScenarioOverview.roadmap()",
    "Collection ImmutableRoadmapAndScenarioOverview.scenarios()",
    "String ImmutableRoadmapAndScenarioOverview.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

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
    ArrayList<Scenario> scenarios = new ArrayList<>();
    ImmutableRoadmapAndScenarioOverview immutableRoadmapAndScenarioOverview =
        roadmapResult.scenarios(scenarios).build();

    // Act
    String actualToStringResult = immutableRoadmapAndScenarioOverview.toString();
    Roadmap actualRoadmapResult = immutableRoadmapAndScenarioOverview.roadmap();
    Collection<Scenario> actualScenariosResult = immutableRoadmapAndScenarioOverview.scenarios();

    // Assert
    assertTrue(actualScenariosResult instanceof List);
    assertTrue(actualRoadmapResult instanceof ImmutableRoadmap);
    assertEquals(
        "RoadmapAndScenarioOverview{roadmap=Roadmap{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00,"
            + " lastUpdatedBy=2020-03-01, entityLifecycleStatus=ACTIVE, ratingSchemeId=1, rowType=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, columnType=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}}, scenarios=[]}",
        actualToStringResult);
    assertSame(scenarios, actualScenariosResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRoadmap(Roadmap)}
   *   <li>{@link Json#setScenarios(Collection)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setRoadmap(Roadmap)",
    "void Json.setScenarios(Collection)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
    actualJson.setScenarios(new ArrayList<>());

    // Assert
    Collection<Scenario> collection = actualJson.scenarios;
    assertTrue(collection instanceof List);
    Roadmap roadmap = actualJson.roadmap;
    EntityReference columnTypeResult = roadmap.columnType();
    assertTrue(columnTypeResult instanceof ImmutableEntityReference);
    EntityReference rowTypeResult = roadmap.rowType();
    assertTrue(rowTypeResult instanceof ImmutableEntityReference);
    assertTrue(roadmap instanceof ImmutableRoadmap);
    LocalDateTime lastUpdatedAtResult = roadmap.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", roadmap.lastUpdatedBy());
    assertEquals("Name", roadmap.name());
    assertEquals("The characteristics of someone or something", columnTypeResult.description());
    assertEquals("The characteristics of someone or something", roadmap.description());
    assertEquals(1L, columnTypeResult.id());
    assertEquals(1L, roadmap.ratingSchemeId());
    assertEquals(EntityKind.ALL, columnTypeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, roadmap.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnTypeResult.entityLifecycleStatus());
    assertTrue(collection.isEmpty());
    assertEquals(columnTypeResult, rowTypeResult);
    assertSame(ofResult, toLocalDateResult);
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
   * Test Json {@link Json#scenarios()}.
   *
   * <p>Method under test: {@link Json#scenarios()}
   */
  @Test
  @DisplayName("Test Json scenarios()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Json.scenarios()"})
  void testJsonScenarios() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().scenarios());
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#withRoadmap(Roadmap)}.
   *
   * <p>Method under test: {@link ImmutableRoadmapAndScenarioOverview#withRoadmap(Roadmap)}
   */
  @Test
  @DisplayName("Test withRoadmap(Roadmap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapAndScenarioOverview ImmutableRoadmapAndScenarioOverview.withRoadmap(Roadmap)"
  })
  void testWithRoadmap() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

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
    ImmutableRoadmapAndScenarioOverview immutableRoadmapAndScenarioOverview =
        roadmapResult.scenarios(new ArrayList<>()).build();

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
    ImmutableRoadmapAndScenarioOverview actualWithRoadmapResult =
        immutableRoadmapAndScenarioOverview.withRoadmap(
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
    assertEquals(immutableRoadmapAndScenarioOverview, actualWithRoadmapResult);
  }

  /**
   * Test {@link ImmutableRoadmapAndScenarioOverview#withScenarios(Collection)}.
   *
   * <p>Method under test: {@link ImmutableRoadmapAndScenarioOverview#withScenarios(Collection)}
   */
  @Test
  @DisplayName("Test withScenarios(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapAndScenarioOverview ImmutableRoadmapAndScenarioOverview.withScenarios(Collection)"
  })
  void testWithScenarios() {
    // Arrange
    Builder builderResult = ImmutableRoadmapAndScenarioOverview.builder();

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
    ImmutableRoadmapAndScenarioOverview immutableRoadmapAndScenarioOverview =
        roadmapResult.scenarios(new ArrayList<>()).build();

    // Act
    ImmutableRoadmapAndScenarioOverview actualWithScenariosResult =
        immutableRoadmapAndScenarioOverview.withScenarios(new ArrayList<>());

    // Assert
    assertEquals(immutableRoadmapAndScenarioOverview, actualWithScenariosResult);
  }
}
