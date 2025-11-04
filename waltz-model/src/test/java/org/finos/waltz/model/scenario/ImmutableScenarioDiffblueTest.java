package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.PositionProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.junit.jupiter.api.Test;

class ImmutableScenarioDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableScenario#builder()}
   *   <li>{@link ImmutableScenario#description(String)}
   *   <li>{@link ImmutableScenario#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link ImmutableScenario#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableScenario.Builder actualIdResult = ImmutableScenario.builder()
        .description("The characteristics of someone or something")
        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableScenario.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#effectiveDate(LocalDate)}
   */
  @Test
  void testBuilderEffectiveDate() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.effectiveDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableScenario.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenario.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenario.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableScenario.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenario.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableScenario.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenario.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenReturn(1);

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).position();
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(Scenario)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    Scenario instance = mock(Scenario.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.effectiveDate()).thenReturn(ofResult);
    when(instance.roadmapId()).thenReturn(1L);
    when(instance.releaseStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.scenarioType()).thenReturn(ScenarioType.TARGET);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).effectiveDate();
    verify(instance).releaseStatus();
    verify(instance).roadmapId();
    verify(instance).scenarioType();
    ImmutableScenario buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, buildResult.scenarioType());
    assertSame(ofResult, buildResult.effectiveDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(Scenario)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    Scenario instance = mock(Scenario.class);
    when(instance.roadmapId()).thenThrow(new IllegalStateException("instance"));
    when(instance.releaseStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.scenarioType()).thenReturn(ScenarioType.TARGET);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).releaseStatus();
    verify(instance).roadmapId();
    verify(instance).scenarioType();
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(Scenario)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    Scenario instance = mock(Scenario.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.effectiveDate()).thenReturn(ofResult);
    when(instance.roadmapId()).thenReturn(1L);
    when(instance.releaseStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.scenarioType()).thenReturn(ScenarioType.TARGET);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).effectiveDate();
    verify(instance).releaseStatus();
    verify(instance).roadmapId();
    verify(instance).scenarioType();
    ImmutableScenario buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, buildResult.scenarioType());
    assertSame(ofResult, buildResult.effectiveDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#from(Scenario)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    Scenario instance = mock(Scenario.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.effectiveDate()).thenReturn(ofResult);
    when(instance.roadmapId()).thenReturn(1L);
    when(instance.releaseStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.scenarioType()).thenReturn(ScenarioType.TARGET);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableScenario.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).effectiveDate();
    verify(instance).releaseStatus();
    verify(instance).roadmapId();
    verify(instance).scenarioType();
    ImmutableScenario buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, buildResult.scenarioType());
    assertSame(ofResult, buildResult.effectiveDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableScenario.Builder#releaseStatus(ReleaseLifecycleStatus)}
   */
  @Test
  void testBuilderReleaseStatus() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.releaseStatus(ReleaseLifecycleStatus.DRAFT));
  }

  /**
   * Method under test: {@link ImmutableScenario.Builder#roadmapId(long)}
   */
  @Test
  void testBuilderRoadmapId() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roadmapId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableScenario.Builder#scenarioType(ScenarioType)}
   */
  @Test
  void testBuilderScenarioType() {
    // Arrange
    ImmutableScenario.Builder builderResult = ImmutableScenario.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarioType(ScenarioType.TARGET));
  }

  /**
   * Method under test: {@link ImmutableScenario#copyOf(Scenario)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Scenario instance = mock(Scenario.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.effectiveDate()).thenReturn(ofResult);
    when(instance.roadmapId()).thenReturn(1L);
    when(instance.releaseStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.scenarioType()).thenReturn(ScenarioType.TARGET);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableScenario actualCopyOfResult = ImmutableScenario.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).effectiveDate();
    verify(instance).releaseStatus();
    verify(instance).roadmapId();
    verify(instance).scenarioType();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate effectiveDateResult = actualCopyOfResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualCopyOfResult.scenarioType());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult, effectiveDateResult);
  }

  /**
   * Method under test: {@link ImmutableScenario#copyOf(Scenario)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Scenario instance = mock(Scenario.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.effectiveDate()).thenReturn(ofResult);
    when(instance.roadmapId()).thenReturn(1L);
    when(instance.releaseStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.scenarioType()).thenReturn(ScenarioType.TARGET);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableScenario actualCopyOfResult = ImmutableScenario.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).effectiveDate();
    verify(instance).releaseStatus();
    verify(instance).roadmapId();
    verify(instance).scenarioType();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate effectiveDateResult = actualCopyOfResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualCopyOfResult.scenarioType());
    assertSame(ofResult2, toLocalDateResult);
    assertSame(ofResult, effectiveDateResult);
  }

  /**
   * Method under test: {@link ImmutableScenario#copyOf(Scenario)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Scenario instance = mock(Scenario.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.effectiveDate()).thenReturn(ofResult);
    when(instance.roadmapId()).thenReturn(1L);
    when(instance.releaseStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.scenarioType()).thenReturn(ScenarioType.TARGET);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableScenario actualCopyOfResult = ImmutableScenario.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).effectiveDate();
    verify(instance).releaseStatus();
    verify(instance).roadmapId();
    verify(instance).scenarioType();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate effectiveDateResult = actualCopyOfResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualCopyOfResult.scenarioType());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult, effectiveDateResult);
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#effectiveDate()}
   */
  @Test
  void testJsonEffectiveDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).effectiveDate());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableScenario.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableScenario.Json actualJson = new ImmutableScenario.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.effectiveDate);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.releaseStatus);
    assertNull(actualJson.scenarioType);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.roadmapId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.roadmapIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).position());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#releaseStatus()}
   */
  @Test
  void testJsonReleaseStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).releaseStatus());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#roadmapId()}
   */
  @Test
  void testJsonRoadmapId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).roadmapId());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#scenarioType()}
   */
  @Test
  void testJsonScenarioType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenario.Json()).scenarioType());
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableScenario.Json json = new ImmutableScenario.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableScenario.Json#setRoadmapId(long)}
   */
  @Test
  void testJsonSetRoadmapId() {
    // Arrange
    ImmutableScenario.Json json = new ImmutableScenario.Json();

    // Act
    json.setRoadmapId(1L);

    // Assert
    assertEquals(1L, json.roadmapId);
    assertTrue(json.roadmapIdIsSet);
  }
}
