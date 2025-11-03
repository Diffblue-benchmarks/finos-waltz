package org.finos.waltz.model.measurable_rating;

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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.measurable_rating.ImmutableSaveMeasurableRatingCommand.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableSaveMeasurableRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveMeasurableRatingCommandDiffblueTest {
  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#builder()}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#description(String)}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSaveMeasurableRatingCommand Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.isPrimary(java.lang.Boolean)", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualPreviousRatingResult = ImmutableSaveMeasurableRatingCommand.builder()
        .description("The characteristics of someone or something")
        .previousRating('A');
    Optional<Character> previousRating = Optional.of('A');
    Builder actualPreviousRatingResult2 = actualPreviousRatingResult.previousRating(previousRating);

    // Assert
    assertSame(actualPreviousRatingResult2, actualPreviousRatingResult2.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
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
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
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
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingCommand)} with {@code MeasurableRatingCommand}.
   * <ul>
   *   <li>Given {@link UserTimestamp}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingCommand) with 'MeasurableRatingCommand'; given UserTimestamp; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCommand)"})
  void testBuilderFromWithMeasurableRatingCommand_givenUserTimestamp_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    MeasurableRatingCommand instance = mock(MeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingCommand)} with {@code MeasurableRatingCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingCommand) with 'MeasurableRatingCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCommand)"})
  void testBuilderFromWithMeasurableRatingCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    MeasurableRatingCommand instance = mock(MeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code SaveMeasurableRatingCommand}.
   * <p>
   * Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    SaveMeasurableRatingCommand instance = mock(SaveMeasurableRatingCommand.class);
    when(instance.measurableId()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).measurableId();
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code SaveMeasurableRatingCommand}.
   * <p>
   * Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand2() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    SaveMeasurableRatingCommand instance = mock(SaveMeasurableRatingCommand.class);
    when(instance.measurableId()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).measurableId();
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code SaveMeasurableRatingCommand}.
   * <p>
   * Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand3() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    SaveMeasurableRatingCommand instance = mock(SaveMeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code SaveMeasurableRatingCommand}.
   * <p>
   * Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand4() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    SaveMeasurableRatingCommand instance = mock(SaveMeasurableRatingCommand.class);
    when(instance.isPrimary()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    verify(instance).isPrimary();
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code SaveMeasurableRatingCommand}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    SaveMeasurableRatingCommand instance = mock(SaveMeasurableRatingCommand.class);
    when(instance.rating()).thenReturn('A');
    when(instance.isPrimary()).thenReturn(true);
    Optional<Character> emptyResult = Optional.empty();
    when(instance.previousRating()).thenReturn(emptyResult);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    verify(instance).isPrimary();
    verify(instance).previousRating();
    verify(instance).rating();
    ImmutableSaveMeasurableRatingCommand buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals('A', buildResult.rating());
    assertEquals(1L, buildResult.measurableId());
    assertTrue(buildResult.isPrimary());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code SaveMeasurableRatingCommand}.
   * <ul>
   *   <li>Then builder build Primary.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'; then builder build Primary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand_thenBuilderBuildPrimary() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    SaveMeasurableRatingCommand instance = mock(SaveMeasurableRatingCommand.class);
    when(instance.rating()).thenReturn('A');
    when(instance.isPrimary()).thenReturn(true);
    Optional<Character> ofResult = Optional.of('A');
    when(instance.previousRating()).thenReturn(ofResult);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    verify(instance).isPrimary();
    verify(instance).previousRating();
    verify(instance).rating();
    ImmutableSaveMeasurableRatingCommand buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals('A', buildResult.rating());
    assertEquals(1L, buildResult.measurableId());
    assertTrue(buildResult.isPrimary());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code SaveMeasurableRatingCommand}.
   * <ul>
   *   <li>Then builder build Primary is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'; then builder build Primary is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand_thenBuilderBuildPrimaryIsNull() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    SaveMeasurableRatingCommand instance = mock(SaveMeasurableRatingCommand.class);
    when(instance.rating()).thenReturn('A');
    when(instance.isPrimary()).thenReturn(null);
    Optional<Character> ofResult = Optional.of('A');
    when(instance.previousRating()).thenReturn(ofResult);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    verify(instance).isPrimary();
    verify(instance).previousRating();
    verify(instance).rating();
    ImmutableSaveMeasurableRatingCommand buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals('A', buildResult.rating());
    assertNull(buildResult.isPrimary());
    assertEquals(1L, buildResult.measurableId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdate(UserTimestamp)}.
   * <ul>
   *   <li>When {@link UserTimestamp}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#lastUpdate(UserTimestamp)}
   */
  @Test
  @DisplayName("Test Builder lastUpdate(UserTimestamp); when UserTimestamp; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdate(UserTimestamp)"})
  void testBuilderLastUpdate_whenUserTimestamp_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdate(mock(UserTimestamp.class)));
  }

  /**
   * Test Builder {@link Builder#measurableId(long)}.
   * <p>
   * Method under test: {@link Builder#measurableId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableId(long)"})
  void testBuilderMeasurableId() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableId(1L));
  }

  /**
   * Test Builder {@link Builder#previousRating(char)} with {@code char}.
   * <p>
   * Method under test: {@link Builder#previousRating(char)}
   */
  @Test
  @DisplayName("Test Builder previousRating(char) with 'char'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.previousRating(char)"})
  void testBuilderPreviousRatingWithChar() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.previousRating('A'));
  }

  /**
   * Test Builder {@link Builder#previousRating(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#previousRating(Optional)}
   */
  @Test
  @DisplayName("Test Builder previousRating(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.previousRating(Optional)"})
  void testBuilderPreviousRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    Optional<Character> previousRating = Optional.of('A');

    // Act and Assert
    assertSame(builderResult, builderResult.previousRating(previousRating));
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
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating('A'));
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
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json {@link Json#isPrimary()}.
   * <p>
   * Method under test: {@link Json#isPrimary()}
   */
  @Test
  @DisplayName("Test Json isPrimary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean Json.isPrimary()"})
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isPrimary());
  }

  /**
   * Test Json {@link Json#lastUpdate()}.
   * <p>
   * Method under test: {@link Json#lastUpdate()}
   */
  @Test
  @DisplayName("Test Json lastUpdate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserTimestamp Json.lastUpdate()"})
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdate());
  }

  /**
   * Test Json {@link Json#measurableId()}.
   * <p>
   * Method under test: {@link Json#measurableId()}
   */
  @Test
  @DisplayName("Test Json measurableId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.measurableId()"})
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableId());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertEquals('\u0000', actualJson.rating);
    assertNull(actualJson.isPrimary);
    assertNull(actualJson.description);
    assertNull(actualJson.provenance);
    assertNull(actualJson.entityReference);
    assertNull(actualJson.lastUpdate);
    assertEquals(0L, actualJson.measurableId);
    assertFalse(actualJson.previousRating.isPresent());
    assertFalse(actualJson.measurableIdIsSet);
    assertFalse(actualJson.ratingIsSet);
  }

  /**
   * Test Json {@link Json#previousRating()}.
   * <p>
   * Method under test: {@link Json#previousRating()}
   */
  @Test
  @DisplayName("Test Json previousRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.previousRating()"})
  void testJsonPreviousRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).previousRating());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
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
   * Test Json {@link Json#setMeasurableId(long)}.
   * <p>
   * Method under test: {@link Json#setMeasurableId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setMeasurableId(long)"})
  void testJsonSetMeasurableId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
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
}
