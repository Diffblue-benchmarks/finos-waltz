package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.junit.jupiter.api.Test;

class ImmutableScenarioRatingItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableScenarioRatingItem#builder()}
   *   <li>{@link ImmutableScenarioRatingItem#description(String)}
   *   <li>{@link ImmutableScenarioRatingItem#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableScenarioRatingItem.Builder actualDescriptionResult = ImmutableScenarioRatingItem.builder()
        .description("The characteristics of someone or something");

    // Assert
    assertSame(actualDescriptionResult, actualDescriptionResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#column(EntityReference)}
   */
  @Test
  void testBuilderColumn() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.column(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableScenarioRatingItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableScenarioRatingItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableScenarioRatingItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(ScenarioRatingItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    ScenarioRatingItem instance = mock(ScenarioRatingItem.class);
    when(instance.item()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).item();
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(ScenarioRatingItem)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    ScenarioRatingItem instance = mock(ScenarioRatingItem.class);
    when(instance.item()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).item();
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(ScenarioRatingItem)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    ScenarioRatingItem instance = mock(ScenarioRatingItem.class);
    when(instance.rating()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.item()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).item();
    verify(instance).rating();
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(ScenarioRatingItem)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    ScenarioRatingItem instance = mock(ScenarioRatingItem.class);
    when(instance.row()).thenThrow(new IllegalStateException("instance"));
    when(instance.rating()).thenReturn('A');
    when(instance.column()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.item()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).column();
    verify(instance).item();
    verify(instance).rating();
    verify(instance).row();
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(ScenarioRatingItem)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    ScenarioRatingItem instance = mock(ScenarioRatingItem.class);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.row()).thenReturn(mock(EntityReference.class));
    when(instance.rating()).thenReturn('A');
    when(instance.column()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.item()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableScenarioRatingItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).column();
    verify(instance).item();
    verify(instance).rating();
    verify(instance).row();
    verify(instance).scenarioId();
    ImmutableScenarioRatingItem buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals('A', buildResult.rating());
    assertEquals(1L, buildResult.scenarioId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#from(ScenarioRatingItem)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();
    ScenarioRatingItem instance = mock(ScenarioRatingItem.class);
    when(instance.scenarioId()).thenThrow(new IllegalStateException("instance"));
    when(instance.row()).thenReturn(mock(EntityReference.class));
    when(instance.rating()).thenReturn('A');
    when(instance.column()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.item()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).column();
    verify(instance).item();
    verify(instance).rating();
    verify(instance).row();
    verify(instance).scenarioId();
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#item(EntityReference)}
   */
  @Test
  void testBuilderItem() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.item(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Builder#rating(char)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating('A'));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#row(EntityReference)}
   */
  @Test
  void testBuilderRow() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.row(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Builder#scenarioId(long)}
   */
  @Test
  void testBuilderScenarioId() {
    // Arrange
    ImmutableScenarioRatingItem.Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarioId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem#copyOf(ScenarioRatingItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ScenarioRatingItem instance = mock(ScenarioRatingItem.class);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.row()).thenReturn(mock(EntityReference.class));
    when(instance.rating()).thenReturn('A');
    when(instance.column()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.item()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableScenarioRatingItem actualCopyOfResult = ImmutableScenarioRatingItem.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).column();
    verify(instance).item();
    verify(instance).rating();
    verify(instance).row();
    verify(instance).scenarioId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.scenarioId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem#copyOf(ScenarioRatingItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ScenarioRatingItem instance = mock(ScenarioRatingItem.class);
    when(instance.scenarioId()).thenReturn(1L);
    when(instance.row()).thenReturn(mock(EntityReference.class));
    when(instance.rating()).thenReturn('A');
    when(instance.column()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.item()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableScenarioRatingItem actualCopyOfResult = ImmutableScenarioRatingItem.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).column();
    verify(instance).item();
    verify(instance).rating();
    verify(instance).row();
    verify(instance).scenarioId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals('A', actualCopyOfResult.rating());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.scenarioId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#column()}
   */
  @Test
  void testJsonColumn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioRatingItem.Json()).column());
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioRatingItem.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableScenarioRatingItem.Json}
   *   <li>{@link ImmutableScenarioRatingItem.Json#setColumn(EntityReference)}
   *   <li>{@link ImmutableScenarioRatingItem.Json#setDescription(String)}
   *   <li>{@link ImmutableScenarioRatingItem.Json#setItem(EntityReference)}
   *   <li>{@link ImmutableScenarioRatingItem.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableScenarioRatingItem.Json#setLastUpdatedBy(String)}
   *   <li>{@link ImmutableScenarioRatingItem.Json#setRow(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableScenarioRatingItem.Json actualJson = new ImmutableScenarioRatingItem.Json();
    actualJson.setColumn(null);
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setItem(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setRow(null);

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#item()}
   */
  @Test
  void testJsonItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioRatingItem.Json()).item());
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioRatingItem.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioRatingItem.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioRatingItem.Json()).rating());
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#row()}
   */
  @Test
  void testJsonRow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioRatingItem.Json()).row());
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#scenarioId()}
   */
  @Test
  void testJsonScenarioId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableScenarioRatingItem.Json()).scenarioId());
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#setRating(char)}
   */
  @Test
  void testJsonSetRating() {
    // Arrange
    ImmutableScenarioRatingItem.Json json = new ImmutableScenarioRatingItem.Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }

  /**
   * Method under test: {@link ImmutableScenarioRatingItem.Json#setRating(char)}
   */
  @Test
  void testJsonSetRating2() {
    // Arrange
    ImmutableScenarioRatingItem.Json json = new ImmutableScenarioRatingItem.Json();
    json.setItem(mock(EntityReference.class));

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Json#setScenarioId(long)}
   */
  @Test
  void testJsonSetScenarioId() {
    // Arrange
    ImmutableScenarioRatingItem.Json json = new ImmutableScenarioRatingItem.Json();

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableScenarioRatingItem.Json#setScenarioId(long)}
   */
  @Test
  void testJsonSetScenarioId2() {
    // Arrange
    ImmutableScenarioRatingItem.Json json = new ImmutableScenarioRatingItem.Json();
    json.setItem(mock(EntityReference.class));

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }
}
