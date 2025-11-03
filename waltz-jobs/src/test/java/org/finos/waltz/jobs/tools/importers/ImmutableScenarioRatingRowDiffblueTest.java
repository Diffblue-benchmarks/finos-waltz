package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.ImmutableScenarioRatingRow.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableScenarioRatingRowDiffblueTest {
  /**
   * Test {@link ImmutableScenarioRatingRow#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableScenarioRatingRow#builder()}
   *   <li>{@link ImmutableScenarioRatingRow#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableScenarioRatingRow Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableScenarioRatingRow.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#assetCode(String)}.
   * <p>
   * Method under test: {@link Builder#assetCode(String)}
   */
  @Test
  @DisplayName("Test Builder assetCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assetCode(String)"})
  void testBuilderAssetCode() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assetCode("Asset Code"));
  }

  /**
   * Test Builder {@link Builder#column(String)}.
   * <p>
   * Method under test: {@link Builder#column(String)}
   */
  @Test
  @DisplayName("Test Builder column(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.column(String)"})
  void testBuilderColumn() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.column("Column"));
  }

  /**
   * Test Builder {@link Builder#from(ScenarioRatingRow)}.
   * <p>
   * Method under test: {@link Builder#from(ScenarioRatingRow)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingRow)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ScenarioRatingRow)}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ScenarioRatingRow)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingRow); then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingRow)"})
  void testBuilderFrom_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ScenarioRatingRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ScenarioRatingRow)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();
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
   * Test Builder {@link Builder#providedBy(String)}.
   * <p>
   * Method under test: {@link Builder#providedBy(String)}
   */
  @Test
  @DisplayName("Test Builder providedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.providedBy(String)"})
  void testBuilderProvidedBy() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.providedBy("Provided By"));
  }

  /**
   * Test Builder {@link Builder#rating(String)}.
   * <p>
   * Method under test: {@link Builder#rating(String)}
   */
  @Test
  @DisplayName("Test Builder rating(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rating(String)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating("Rating"));
  }

  /**
   * Test Builder {@link Builder#roadmap(String)}.
   * <p>
   * Method under test: {@link Builder#roadmap(String)}
   */
  @Test
  @DisplayName("Test Builder roadmap(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.roadmap(String)"})
  void testBuilderRoadmap() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roadmap("Roadmap"));
  }

  /**
   * Test Builder {@link Builder#row(String)}.
   * <p>
   * Method under test: {@link Builder#row(String)}
   */
  @Test
  @DisplayName("Test Builder row(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.row(String)"})
  void testBuilderRow() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.row("Row"));
  }

  /**
   * Test Builder {@link Builder#scenario(String)}.
   * <p>
   * Method under test: {@link Builder#scenario(String)}
   */
  @Test
  @DisplayName("Test Builder scenario(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.scenario(String)"})
  void testBuilderScenario() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenario("Scenario"));
  }
}
