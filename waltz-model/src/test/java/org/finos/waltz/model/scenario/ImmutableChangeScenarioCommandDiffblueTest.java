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
import org.junit.jupiter.api.Test;

class ImmutableChangeScenarioCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeScenarioCommand#builder()}
   *   <li>{@link ImmutableChangeScenarioCommand#comment(String)}
   *   <li>{@link ImmutableChangeScenarioCommand#previousRating(String)}
   *   <li>{@link ImmutableChangeScenarioCommand#rating(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableChangeScenarioCommand.Builder actualPreviousRatingResult = ImmutableChangeScenarioCommand.builder()
        .comment("Comment")
        .previousRating("Previous Rating");

    // Assert
    assertSame(actualPreviousRatingResult, actualPreviousRatingResult.rating("Rating"));
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Builder#appId(long)}
   */
  @Test
  void testBuilderAppId() {
    // Arrange
    ImmutableChangeScenarioCommand.Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Builder#columnId(long)}
   */
  @Test
  void testBuilderColumnId() {
    // Arrange
    ImmutableChangeScenarioCommand.Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Builder#from(ChangeScenarioCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableChangeScenarioCommand.Builder builderResult = ImmutableChangeScenarioCommand.builder();
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
    ImmutableChangeScenarioCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Builder#from(ChangeScenarioCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableChangeScenarioCommand.Builder builderResult = ImmutableChangeScenarioCommand.builder();
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
    ImmutableChangeScenarioCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Builder#from(ChangeScenarioCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableChangeScenarioCommand.Builder builderResult = ImmutableChangeScenarioCommand.builder();
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
    ImmutableChangeScenarioCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Builder#from(ChangeScenarioCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableChangeScenarioCommand.Builder builderResult = ImmutableChangeScenarioCommand.builder();
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
    ImmutableChangeScenarioCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Builder#ratingSchemeId(long)}
   */
  @Test
  void testBuilderRatingSchemeId() {
    // Arrange
    ImmutableChangeScenarioCommand.Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Builder#rowId(long)}
   */
  @Test
  void testBuilderRowId() {
    // Arrange
    ImmutableChangeScenarioCommand.Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Builder#scenarioId(long)}
   */
  @Test
  void testBuilderScenarioId() {
    // Arrange
    ImmutableChangeScenarioCommand.Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarioId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand#copyOf(ChangeScenarioCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableChangeScenarioCommand actualCopyOfResult = ImmutableChangeScenarioCommand.copyOf(instance);

    // Assert
    verify(instance).appId();
    verify(instance).columnId();
    verify(instance).comment();
    verify(instance).previousRating();
    verify(instance).rating();
    verify(instance).ratingSchemeId();
    verify(instance).rowId();
    verify(instance).scenarioId();
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Previous Rating", actualCopyOfResult.previousRating());
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.columnId());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(1L, actualCopyOfResult.rowId());
    assertEquals(1L, actualCopyOfResult.scenarioId());
    assertTrue(actualCopyOfResult.hasRatingChanged());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand#copyOf(ChangeScenarioCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ChangeScenarioCommand instance = mock(ChangeScenarioCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.previousRating()).thenReturn("foo");
    when(instance.rating()).thenReturn("foo");
    when(instance.appId()).thenReturn(1L);
    when(instance.columnId()).thenReturn(1L);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.rowId()).thenReturn(1L);
    when(instance.scenarioId()).thenReturn(1L);

    // Act
    ImmutableChangeScenarioCommand actualCopyOfResult = ImmutableChangeScenarioCommand.copyOf(instance);

    // Assert
    verify(instance).appId();
    verify(instance).columnId();
    verify(instance).comment();
    verify(instance).previousRating();
    verify(instance).rating();
    verify(instance).ratingSchemeId();
    verify(instance).rowId();
    verify(instance).scenarioId();
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("foo", actualCopyOfResult.previousRating());
    assertEquals("foo", actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.columnId());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(1L, actualCopyOfResult.rowId());
    assertEquals(1L, actualCopyOfResult.scenarioId());
    assertFalse(actualCopyOfResult.hasRatingChanged());
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Json#appId()}
   */
  @Test
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeScenarioCommand.Json()).appId());
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Json#columnId()}
   */
  @Test
  void testJsonColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeScenarioCommand.Json()).columnId());
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeScenarioCommand.Json()).comment());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableChangeScenarioCommand.Json}
   *   <li>{@link ImmutableChangeScenarioCommand.Json#setComment(String)}
   *   <li>{@link ImmutableChangeScenarioCommand.Json#setPreviousRating(String)}
   *   <li>{@link ImmutableChangeScenarioCommand.Json#setRating(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableChangeScenarioCommand.Json actualJson = new ImmutableChangeScenarioCommand.Json();
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
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Json#hasRatingChanged()}
   */
  @Test
  void testJsonHasRatingChanged() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableChangeScenarioCommand.Json()).hasRatingChanged());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Json#previousRating()}
   */
  @Test
  void testJsonPreviousRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableChangeScenarioCommand.Json()).previousRating());
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeScenarioCommand.Json()).rating());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Json#ratingSchemeId()}
   */
  @Test
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableChangeScenarioCommand.Json()).ratingSchemeId());
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Json#rowId()}
   */
  @Test
  void testJsonRowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeScenarioCommand.Json()).rowId());
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Json#scenarioId()}
   */
  @Test
  void testJsonScenarioId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeScenarioCommand.Json()).scenarioId());
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Json#setAppId(long)}
   */
  @Test
  void testJsonSetAppId() {
    // Arrange
    ImmutableChangeScenarioCommand.Json json = new ImmutableChangeScenarioCommand.Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Json#setColumnId(long)}
   */
  @Test
  void testJsonSetColumnId() {
    // Arrange
    ImmutableChangeScenarioCommand.Json json = new ImmutableChangeScenarioCommand.Json();

    // Act
    json.setColumnId(1L);

    // Assert
    assertEquals(1L, json.columnId);
    assertTrue(json.columnIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Json#setRatingSchemeId(long)}
   */
  @Test
  void testJsonSetRatingSchemeId() {
    // Arrange
    ImmutableChangeScenarioCommand.Json json = new ImmutableChangeScenarioCommand.Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableChangeScenarioCommand.Json#setRowId(long)}
   */
  @Test
  void testJsonSetRowId() {
    // Arrange
    ImmutableChangeScenarioCommand.Json json = new ImmutableChangeScenarioCommand.Json();

    // Act
    json.setRowId(1L);

    // Assert
    assertEquals(1L, json.rowId);
    assertTrue(json.rowIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeScenarioCommand.Json#setScenarioId(long)}
   */
  @Test
  void testJsonSetScenarioId() {
    // Arrange
    ImmutableChangeScenarioCommand.Json json = new ImmutableChangeScenarioCommand.Json();

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }
}
