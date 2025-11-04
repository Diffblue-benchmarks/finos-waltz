package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableScenarioRatingRowDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableScenarioRatingRow#builder()}
   *   <li>{@link ImmutableScenarioRatingRow#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableScenarioRatingRow.Builder actualBuilderResult = ImmutableScenarioRatingRow.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingRow.Builder#assetCode(String)}
   */
  @Test
  void testBuilderAssetCode() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assetCode("Asset Code"));
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingRow.Builder#column(String)}
   */
  @Test
  void testBuilderColumn() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.column("Column"));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingRow.Builder#from(ScenarioRatingRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();
    ScenarioRatingRow instance = mock(ScenarioRatingRow.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.providedBy()).thenReturn("Provided By");
    when(instance.rating()).thenReturn("Rating");
    when(instance.assetCode()).thenReturn("Asset Code");
    when(instance.row()).thenReturn("Row");
    when(instance.column()).thenReturn("Column");
    when(instance.scenario()).thenReturn("Scenario");
    when(instance.roadmap()).thenReturn("Roadmap");

    // Act
    ImmutableScenarioRatingRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assetCode();
    verify(instance).column();
    verify(instance).description();
    verify(instance).providedBy();
    verify(instance).rating();
    verify(instance).roadmap();
    verify(instance).row();
    verify(instance).scenario();
    ImmutableScenarioRatingRow buildResult = builderResult.build();
    assertEquals("Asset Code", buildResult.assetCode());
    assertEquals("Column", buildResult.column());
    assertEquals("Provided By", buildResult.providedBy());
    assertEquals("Rating", buildResult.rating());
    assertEquals("Roadmap", buildResult.roadmap());
    assertEquals("Row", buildResult.row());
    assertEquals("Scenario", buildResult.scenario());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingRow.Builder#from(ScenarioRatingRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();
    ScenarioRatingRow instance = mock(ScenarioRatingRow.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.rating()).thenReturn("Rating");
    when(instance.assetCode()).thenReturn("Asset Code");
    when(instance.row()).thenReturn("Row");
    when(instance.column()).thenReturn("Column");
    when(instance.scenario()).thenReturn("Scenario");
    when(instance.roadmap()).thenReturn("Roadmap");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assetCode();
    verify(instance).column();
    verify(instance).description();
    verify(instance).rating();
    verify(instance).roadmap();
    verify(instance).row();
    verify(instance).scenario();
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingRow.Builder#from(ScenarioRatingRow)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();
    ScenarioRatingRow instance = mock(ScenarioRatingRow.class);
    when(instance.description()).thenReturn(null);
    when(instance.providedBy()).thenReturn("Provided By");
    when(instance.rating()).thenReturn("Rating");
    when(instance.assetCode()).thenReturn("Asset Code");
    when(instance.row()).thenReturn("Row");
    when(instance.column()).thenReturn("Column");
    when(instance.scenario()).thenReturn("Scenario");
    when(instance.roadmap()).thenReturn("Roadmap");

    // Act
    ImmutableScenarioRatingRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assetCode();
    verify(instance).column();
    verify(instance).description();
    verify(instance).providedBy();
    verify(instance).rating();
    verify(instance).roadmap();
    verify(instance).row();
    verify(instance).scenario();
    ImmutableScenarioRatingRow buildResult = builderResult.build();
    assertEquals("Asset Code", buildResult.assetCode());
    assertEquals("Column", buildResult.column());
    assertEquals("Provided By", buildResult.providedBy());
    assertEquals("Rating", buildResult.rating());
    assertEquals("Roadmap", buildResult.roadmap());
    assertEquals("Row", buildResult.row());
    assertEquals("Scenario", buildResult.scenario());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingRow.Builder#providedBy(String)}
   */
  @Test
  void testBuilderProvidedBy() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.providedBy("Provided By"));
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingRow.Builder#rating(String)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating("Rating"));
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingRow.Builder#roadmap(String)}
   */
  @Test
  void testBuilderRoadmap() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roadmap("Roadmap"));
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingRow.Builder#row(String)}
   */
  @Test
  void testBuilderRow() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.row("Row"));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingRow.Builder#scenario(String)}
   */
  @Test
  void testBuilderScenario() {
    // Arrange
    ImmutableScenarioRatingRow.Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenario("Scenario"));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingRow#copyOf(ScenarioRatingRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ScenarioRatingRow instance = mock(ScenarioRatingRow.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.providedBy()).thenReturn("Provided By");
    when(instance.rating()).thenReturn("Rating");
    when(instance.assetCode()).thenReturn("Asset Code");
    when(instance.row()).thenReturn("Row");
    when(instance.column()).thenReturn("Column");
    when(instance.scenario()).thenReturn("Scenario");
    when(instance.roadmap()).thenReturn("Roadmap");

    // Act
    ImmutableScenarioRatingRow actualCopyOfResult = ImmutableScenarioRatingRow.copyOf(instance);

    // Assert
    verify(instance).assetCode();
    verify(instance).column();
    verify(instance).description();
    verify(instance).providedBy();
    verify(instance).rating();
    verify(instance).roadmap();
    verify(instance).row();
    verify(instance).scenario();
    assertEquals("Asset Code", actualCopyOfResult.assetCode());
    assertEquals("Column", actualCopyOfResult.column());
    assertEquals("Provided By", actualCopyOfResult.providedBy());
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals("Roadmap", actualCopyOfResult.roadmap());
    assertEquals("Row", actualCopyOfResult.row());
    assertEquals("Scenario", actualCopyOfResult.scenario());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }
}
