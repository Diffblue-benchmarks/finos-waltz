package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.scenario.ImmutableScenarioRatingItem.Builder;
import org.finos.waltz.model.scenario.ImmutableScenarioRatingItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableScenarioRatingItemDiffblueTest {
  /**
   * Test {@link ImmutableScenarioRatingItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableScenarioRatingItem#builder()}
   *   <li>{@link ImmutableScenarioRatingItem#description(String)}
   *   <li>{@link ImmutableScenarioRatingItem#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableScenarioRatingItem Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDescriptionResult = ImmutableScenarioRatingItem.builder()
        .description("The characteristics of someone or something");

    // Assert
    assertSame(actualDescriptionResult, actualDescriptionResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#column(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#column(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder column(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.column(EntityReference)"})
  void testBuilderColumn_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.column(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(ScenarioRatingItem)} with {@code ScenarioRatingItem}.
   * <p>
   * Method under test: {@link Builder#from(ScenarioRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingItem) with 'ScenarioRatingItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingItem)"})
  void testBuilderFromWithScenarioRatingItem() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
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
   * Test Builder {@link Builder#from(ScenarioRatingItem)} with {@code ScenarioRatingItem}.
   * <p>
   * Method under test: {@link Builder#from(ScenarioRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingItem) with 'ScenarioRatingItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingItem)"})
  void testBuilderFromWithScenarioRatingItem2() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
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
   * Test Builder {@link Builder#from(ScenarioRatingItem)} with {@code ScenarioRatingItem}.
   * <p>
   * Method under test: {@link Builder#from(ScenarioRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingItem) with 'ScenarioRatingItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingItem)"})
  void testBuilderFromWithScenarioRatingItem3() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
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
   * Test Builder {@link Builder#from(ScenarioRatingItem)} with {@code ScenarioRatingItem}.
   * <p>
   * Method under test: {@link Builder#from(ScenarioRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingItem) with 'ScenarioRatingItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingItem)"})
  void testBuilderFromWithScenarioRatingItem4() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
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
   * Test Builder {@link Builder#from(ScenarioRatingItem)} with {@code ScenarioRatingItem}.
   * <p>
   * Method under test: {@link Builder#from(ScenarioRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingItem) with 'ScenarioRatingItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingItem)"})
  void testBuilderFromWithScenarioRatingItem5() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
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
   * Test Builder {@link Builder#from(ScenarioRatingItem)} with {@code ScenarioRatingItem}.
   * <ul>
   *   <li>Then builder build lastUpdatedBy is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ScenarioRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingItem) with 'ScenarioRatingItem'; then builder build lastUpdatedBy is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingItem)"})
  void testBuilderFromWithScenarioRatingItem_thenBuilderBuildLastUpdatedByIs20200301() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#item(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#item(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder item(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.item(EntityReference)"})
  void testBuilderItem_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.item(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#rating(char)}.
   * <p>
   * Method under test: {@link Builder#rating(char)}
   */
  @Test
  @DisplayName("Test Builder rating(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rating(char)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating('A'));
  }

  /**
   * Test Builder {@link Builder#row(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#row(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder row(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.row(EntityReference)"})
  void testBuilderRow_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.row(mock(EntityReference.class)));
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
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarioId(1L));
  }

  /**
   * Test Json {@link Json#column()}.
   * <p>
   * Method under test: {@link Json#column()}
   */
  @Test
  @DisplayName("Test Json column()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.column()"})
  void testJsonColumn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).column());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setColumn(EntityReference)}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setItem(EntityReference)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setRow(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setColumn(EntityReference)", "void Json.setDescription(String)",
      "void Json.setItem(EntityReference)", "void Json.setLastUpdatedAt(LocalDateTime)",
      "void Json.setLastUpdatedBy(String)", "void Json.setRow(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#item()}.
   * <p>
   * Method under test: {@link Json#item()}
   */
  @Test
  @DisplayName("Test Json item()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.item()"})
  void testJsonItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).item());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rating());
  }

  /**
   * Test Json {@link Json#row()}.
   * <p>
   * Method under test: {@link Json#row()}
   */
  @Test
  @DisplayName("Test Json row()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.row()"})
  void testJsonRow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).row());
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
   * Test Json {@link Json#setRating(char)}.
   * <p>
   * Method under test: {@link Json#setRating(char)}
   */
  @Test
  @DisplayName("Test Json setRating(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRating(char)"})
  void testJsonSetRating() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
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
