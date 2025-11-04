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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.junit.jupiter.api.Test;

class ImmutableSaveMeasurableRatingCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#builder()}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#description(String)}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSaveMeasurableRatingCommand.Builder actualPreviousRatingResult = ImmutableSaveMeasurableRatingCommand
        .builder()
        .description("The characteristics of someone or something")
        .previousRating('A');
    Optional<Character> previousRating = Optional.of('A');
    ImmutableSaveMeasurableRatingCommand.Builder actualPreviousRatingResult2 = actualPreviousRatingResult
        .previousRating(previousRating);

    // Assert
    assertSame(actualPreviousRatingResult2, actualPreviousRatingResult2.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSaveMeasurableRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSaveMeasurableRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSaveMeasurableRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(MeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
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
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(MeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    MeasurableRatingCommand instance = mock(MeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableSaveMeasurableRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
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
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
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
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
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
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
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
    ImmutableSaveMeasurableRatingCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
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
    ImmutableSaveMeasurableRatingCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
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
    ImmutableSaveMeasurableRatingCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
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
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#lastUpdate(UserTimestamp)}
   */
  @Test
  void testBuilderLastUpdate() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdate(mock(UserTimestamp.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#measurableId(long)}
   */
  @Test
  void testBuilderMeasurableId() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#previousRating(char)}
   */
  @Test
  void testBuilderPreviousRating() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.previousRating('A'));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#previousRating(Optional)}
   */
  @Test
  void testBuilderPreviousRating2() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    Optional<Character> previousRating = Optional.of('A');

    // Act and Assert
    assertSame(builderResult, builderResult.previousRating(previousRating));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Builder#rating(char)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating('A'));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand#copyOf(SaveMeasurableRatingCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableSaveMeasurableRatingCommand actualCopyOfResult = ImmutableSaveMeasurableRatingCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    verify(instance).isPrimary();
    verify(instance).previousRating();
    verify(instance).rating();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertTrue(actualCopyOfResult.isPrimary());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand#copyOf(SaveMeasurableRatingCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    ImmutableSaveMeasurableRatingCommand actualCopyOfResult = ImmutableSaveMeasurableRatingCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    verify(instance).isPrimary();
    verify(instance).previousRating();
    verify(instance).rating();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertNull(actualCopyOfResult.isPrimary());
    assertEquals(1L, actualCopyOfResult.measurableId());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand#copyOf(SaveMeasurableRatingCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
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
    ImmutableSaveMeasurableRatingCommand actualCopyOfResult = ImmutableSaveMeasurableRatingCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    verify(instance).isPrimary();
    verify(instance).previousRating();
    verify(instance).rating();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertTrue(actualCopyOfResult.isPrimary());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand#copyOf(SaveMeasurableRatingCommand)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SaveMeasurableRatingCommand instance = mock(SaveMeasurableRatingCommand.class);
    when(instance.rating()).thenReturn('A');
    when(instance.isPrimary()).thenReturn(true);
    Optional<Character> ofResult = Optional.of('A');
    when(instance.previousRating()).thenReturn(ofResult);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSaveMeasurableRatingCommand actualCopyOfResult = ImmutableSaveMeasurableRatingCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    verify(instance).isPrimary();
    verify(instance).previousRating();
    verify(instance).rating();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals('A', actualCopyOfResult.rating());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertTrue(actualCopyOfResult.isPrimary());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveMeasurableRatingCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveMeasurableRatingCommand.Json()).entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#isPrimary()}
   */
  @Test
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveMeasurableRatingCommand.Json()).isPrimary());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#lastUpdate()}
   */
  @Test
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveMeasurableRatingCommand.Json()).lastUpdate());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#measurableId()}
   */
  @Test
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveMeasurableRatingCommand.Json()).measurableId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSaveMeasurableRatingCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSaveMeasurableRatingCommand.Json actualJson = new ImmutableSaveMeasurableRatingCommand.Json();

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
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#previousRating()}
   */
  @Test
  void testJsonPreviousRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveMeasurableRatingCommand.Json()).previousRating());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveMeasurableRatingCommand.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableSaveMeasurableRatingCommand.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSaveMeasurableRatingCommand.Json()).rating());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#setMeasurableId(long)}
   */
  @Test
  void testJsonSetMeasurableId() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Json json = new ImmutableSaveMeasurableRatingCommand.Json();

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#setMeasurableId(long)}
   */
  @Test
  void testJsonSetMeasurableId2() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Json json = new ImmutableSaveMeasurableRatingCommand.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#setRating(char)}
   */
  @Test
  void testJsonSetRating() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Json json = new ImmutableSaveMeasurableRatingCommand.Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveMeasurableRatingCommand.Json#setRating(char)}
   */
  @Test
  void testJsonSetRating2() {
    // Arrange
    ImmutableSaveMeasurableRatingCommand.Json json = new ImmutableSaveMeasurableRatingCommand.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }
}
