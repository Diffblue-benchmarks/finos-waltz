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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.scenario.ImmutableChangeScenarioCommand.Builder;
import org.finos.waltz.model.scenario.ImmutableChangeScenarioCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeScenarioCommandDiffblueTest {
  /**
   * Test {@link ImmutableChangeScenarioCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeScenarioCommand#builder()}
   *   <li>{@link ImmutableChangeScenarioCommand#comment(String)}
   *   <li>{@link ImmutableChangeScenarioCommand#previousRating(String)}
   *   <li>{@link ImmutableChangeScenarioCommand#rating(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeScenarioCommand Builder.build()", "Builder Builder.comment(String)",
      "Builder Builder.previousRating(String)", "Builder Builder.rating(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualPreviousRatingResult = ImmutableChangeScenarioCommand.builder()
        .comment("Comment")
        .previousRating("Previous Rating");

    // Assert
    assertSame(actualPreviousRatingResult, actualPreviousRatingResult.rating("Rating"));
  }

  /**
   * Test Builder {@link Builder#appId(long)}.
   * <p>
   * Method under test: {@link Builder#appId(long)}
   */
  @Test
  @DisplayName("Test Builder appId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appId(long)"})
  void testBuilderAppId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appId(1L));
  }

  /**
   * Test Builder {@link Builder#columnId(long)}.
   * <p>
   * Method under test: {@link Builder#columnId(long)}
   */
  @Test
  @DisplayName("Test Builder columnId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.columnId(long)"})
  void testBuilderColumnId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnId(1L));
  }

  /**
   * Test Builder {@link Builder#from(ChangeScenarioCommand)}.
   * <ul>
   *   <li>Given {@code Comment}.</li>
   *   <li>Then builder build comment is {@code Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeScenarioCommand); given 'Comment'; then builder build comment is 'Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeScenarioCommand)"})
  void testBuilderFrom_givenComment_thenBuilderBuildCommentIsComment() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();
    ChangeScenarioCommand instance = mock(ChangeScenarioCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.previousRating()).thenReturn("Previous Rating");
    when(instance.rating()).thenReturn("Rating");
    when(instance.appId()).thenReturn(1L);
    when(instance.columnId()).thenReturn(1L);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.rowId()).thenReturn(1L);
    when(instance.scenarioId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).columnId();
    verify(instance).comment();
    verify(instance).previousRating();
    verify(instance).rating();
    verify(instance).ratingSchemeId();
    verify(instance).rowId();
    verify(instance).scenarioId();
    ImmutableChangeScenarioCommand buildResult = builderResult.build();
    assertEquals("Comment", buildResult.comment());
    assertEquals("Previous Rating", buildResult.previousRating());
    assertEquals("Rating", buildResult.rating());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.columnId());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(1L, buildResult.rowId());
    assertEquals(1L, buildResult.scenarioId());
    assertTrue(buildResult.hasRatingChanged());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeScenarioCommand)}.
   * <ul>
   *   <li>Then builder build comment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeScenarioCommand); then builder build comment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeScenarioCommand)"})
  void testBuilderFrom_thenBuilderBuildCommentIsNull() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();
    ChangeScenarioCommand instance = mock(ChangeScenarioCommand.class);
    when(instance.comment()).thenReturn(null);
    when(instance.previousRating()).thenReturn("Previous Rating");
    when(instance.rating()).thenReturn("Rating");
    when(instance.appId()).thenReturn(1L);
    when(instance.columnId()).thenReturn(1L);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.rowId()).thenReturn(1L);
    when(instance.scenarioId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).columnId();
    verify(instance).comment();
    verify(instance).previousRating();
    verify(instance).rating();
    verify(instance).ratingSchemeId();
    verify(instance).rowId();
    verify(instance).scenarioId();
    ImmutableChangeScenarioCommand buildResult = builderResult.build();
    assertEquals("Previous Rating", buildResult.previousRating());
    assertEquals("Rating", buildResult.rating());
    assertNull(buildResult.comment());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.columnId());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(1L, buildResult.rowId());
    assertEquals(1L, buildResult.scenarioId());
    assertTrue(buildResult.hasRatingChanged());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeScenarioCommand)}.
   * <ul>
   *   <li>Then builder build previousRating is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeScenarioCommand); then builder build previousRating is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeScenarioCommand)"})
  void testBuilderFrom_thenBuilderBuildPreviousRatingIsNull() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();
    ChangeScenarioCommand instance = mock(ChangeScenarioCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.previousRating()).thenReturn(null);
    when(instance.rating()).thenReturn("Rating");
    when(instance.appId()).thenReturn(1L);
    when(instance.columnId()).thenReturn(1L);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.rowId()).thenReturn(1L);
    when(instance.scenarioId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).columnId();
    verify(instance).comment();
    verify(instance).previousRating();
    verify(instance).rating();
    verify(instance).ratingSchemeId();
    verify(instance).rowId();
    verify(instance).scenarioId();
    ImmutableChangeScenarioCommand buildResult = builderResult.build();
    assertEquals("Comment", buildResult.comment());
    assertEquals("Rating", buildResult.rating());
    assertNull(buildResult.previousRating());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.columnId());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(1L, buildResult.rowId());
    assertEquals(1L, buildResult.scenarioId());
    assertTrue(buildResult.hasRatingChanged());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeScenarioCommand)}.
   * <ul>
   *   <li>Then builder build rating is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeScenarioCommand); then builder build rating is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeScenarioCommand)"})
  void testBuilderFrom_thenBuilderBuildRatingIsNull() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();
    ChangeScenarioCommand instance = mock(ChangeScenarioCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.previousRating()).thenReturn("Previous Rating");
    when(instance.rating()).thenReturn(null);
    when(instance.appId()).thenReturn(1L);
    when(instance.columnId()).thenReturn(1L);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.rowId()).thenReturn(1L);
    when(instance.scenarioId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).columnId();
    verify(instance).comment();
    verify(instance).previousRating();
    verify(instance).rating();
    verify(instance).ratingSchemeId();
    verify(instance).rowId();
    verify(instance).scenarioId();
    ImmutableChangeScenarioCommand buildResult = builderResult.build();
    assertEquals("Comment", buildResult.comment());
    assertEquals("Previous Rating", buildResult.previousRating());
    assertNull(buildResult.rating());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.columnId());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(1L, buildResult.rowId());
    assertEquals(1L, buildResult.scenarioId());
    assertTrue(buildResult.hasRatingChanged());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(long)}.
   * <p>
   * Method under test: {@link Builder#ratingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Test Builder {@link Builder#rowId(long)}.
   * <p>
   * Method under test: {@link Builder#rowId(long)}
   */
  @Test
  @DisplayName("Test Builder rowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rowId(long)"})
  void testBuilderRowId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowId(1L));
  }

  /**
   * Test Builder {@link Builder#scenarioId(long)}.
   * <p>
   * Method under test: {@link Builder#scenarioId(long)}
   */
  @Test
  @DisplayName("Test Builder scenarioId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.scenarioId(long)"})
  void testBuilderScenarioId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarioId(1L));
  }

  /**
   * Test Json {@link Json#appId()}.
   * <p>
   * Method under test: {@link Json#appId()}
   */
  @Test
  @DisplayName("Test Json appId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.appId()"})
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appId());
  }

  /**
   * Test Json {@link Json#columnId()}.
   * <p>
   * Method under test: {@link Json#columnId()}
   */
  @Test
  @DisplayName("Test Json columnId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.columnId()"})
  void testJsonColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnId());
  }

  /**
   * Test Json {@link Json#comment()}.
   * <p>
   * Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).comment());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComment(String)}
   *   <li>{@link Json#setPreviousRating(String)}
   *   <li>{@link Json#setRating(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setComment(String)", "void Json.setPreviousRating(String)",
      "void Json.setRating(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComment("Comment");
    actualJson.setPreviousRating("Previous Rating");
    actualJson.setRating("Rating");

    // Assert
    assertEquals("Comment", actualJson.comment);
    assertEquals("Previous Rating", actualJson.previousRating);
    assertEquals("Rating", actualJson.rating);
    assertEquals(0L, actualJson.appId);
    assertEquals(0L, actualJson.columnId);
    assertEquals(0L, actualJson.ratingSchemeId);
    assertEquals(0L, actualJson.rowId);
    assertEquals(0L, actualJson.scenarioId);
    assertFalse(actualJson.appIdIsSet);
    assertFalse(actualJson.columnIdIsSet);
    assertFalse(actualJson.ratingSchemeIdIsSet);
    assertFalse(actualJson.rowIdIsSet);
    assertFalse(actualJson.scenarioIdIsSet);
  }

  /**
   * Test Json {@link Json#hasRatingChanged()}.
   * <p>
   * Method under test: {@link Json#hasRatingChanged()}
   */
  @Test
  @DisplayName("Test Json hasRatingChanged()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.hasRatingChanged()"})
  void testJsonHasRatingChanged() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).hasRatingChanged());
  }

  /**
   * Test Json {@link Json#previousRating()}.
   * <p>
   * Method under test: {@link Json#previousRating()}
   */
  @Test
  @DisplayName("Test Json previousRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.previousRating()"})
  void testJsonPreviousRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).previousRating());
  }

  /**
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rating());
  }

  /**
   * Test Json {@link Json#ratingSchemeId()}.
   * <p>
   * Method under test: {@link Json#ratingSchemeId()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.ratingSchemeId()"})
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingSchemeId());
  }

  /**
   * Test Json {@link Json#rowId()}.
   * <p>
   * Method under test: {@link Json#rowId()}
   */
  @Test
  @DisplayName("Test Json rowId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.rowId()"})
  void testJsonRowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rowId());
  }

  /**
   * Test Json {@link Json#scenarioId()}.
   * <p>
   * Method under test: {@link Json#scenarioId()}
   */
  @Test
  @DisplayName("Test Json scenarioId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.scenarioId()"})
  void testJsonScenarioId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).scenarioId());
  }

  /**
   * Test Json {@link Json#setAppId(long)}.
   * <p>
   * Method under test: {@link Json#setAppId(long)}
   */
  @Test
  @DisplayName("Test Json setAppId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setAppId(long)"})
  void testJsonSetAppId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }

  /**
   * Test Json {@link Json#setColumnId(long)}.
   * <p>
   * Method under test: {@link Json#setColumnId(long)}
   */
  @Test
  @DisplayName("Test Json setColumnId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setColumnId(long)"})
  void testJsonSetColumnId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setColumnId(1L);

    // Assert
    assertEquals(1L, json.columnId);
    assertTrue(json.columnIdIsSet);
  }

  /**
   * Test Json {@link Json#setRatingSchemeId(long)}.
   * <p>
   * Method under test: {@link Json#setRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingSchemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRatingSchemeId(long)"})
  void testJsonSetRatingSchemeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Test Json {@link Json#setRowId(long)}.
   * <p>
   * Method under test: {@link Json#setRowId(long)}
   */
  @Test
  @DisplayName("Test Json setRowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRowId(long)"})
  void testJsonSetRowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRowId(1L);

    // Assert
    assertEquals(1L, json.rowId);
    assertTrue(json.rowIdIsSet);
  }

  /**
   * Test Json {@link Json#setScenarioId(long)}.
   * <p>
   * Method under test: {@link Json#setScenarioId(long)}
   */
  @Test
  @DisplayName("Test Json setScenarioId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setScenarioId(long)"})
  void testJsonSetScenarioId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }
}
