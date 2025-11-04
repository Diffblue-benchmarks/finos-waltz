package org.finos.waltz.model.checkpoint;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.Quarter;
import org.junit.jupiter.api.Test;

class ImmutableCheckpointDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCheckpoint#builder()}
   *   <li>{@link ImmutableCheckpoint#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableCheckpoint.Builder actualIdResult = ImmutableCheckpoint.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableCheckpoint.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableCheckpoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCheckpoint.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableCheckpoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCheckpoint.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableCheckpoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableCheckpoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCheckpoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#from(Checkpoint)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    Checkpoint instance = mock(Checkpoint.class);
    when(instance.year()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.quarter()).thenReturn(Quarter.Q1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCheckpoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).quarter();
    verify(instance).year();
    ImmutableCheckpoint buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.year());
    assertEquals(Quarter.Q1, buildResult.quarter());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#from(Checkpoint)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    Checkpoint instance = mock(Checkpoint.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#from(Checkpoint)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    Checkpoint instance = mock(Checkpoint.class);
    when(instance.year()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.quarter()).thenReturn(Quarter.Q1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCheckpoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).quarter();
    verify(instance).year();
    ImmutableCheckpoint buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.year());
    assertEquals(Quarter.Q1, buildResult.quarter());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#from(Checkpoint)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    Checkpoint instance = mock(Checkpoint.class);
    when(instance.year()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.quarter()).thenReturn(Quarter.Q1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCheckpoint.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).quarter();
    verify(instance).year();
    ImmutableCheckpoint buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.year());
    assertEquals(Quarter.Q1, buildResult.quarter());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#quarter(Quarter)}
   */
  @Test
  void testBuilderQuarter() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.quarter(Quarter.Q1));
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Builder#year(int)}
   */
  @Test
  void testBuilderYear() {
    // Arrange
    ImmutableCheckpoint.Builder builderResult = ImmutableCheckpoint.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
  }

  /**
   * Method under test: {@link ImmutableCheckpoint#copyOf(Checkpoint)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Checkpoint instance = mock(Checkpoint.class);
    when(instance.year()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.quarter()).thenReturn(Quarter.Q1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCheckpoint actualCopyOfResult = ImmutableCheckpoint.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).quarter();
    verify(instance).year();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(Quarter.Q1, actualCopyOfResult.quarter());
  }

  /**
   * Method under test: {@link ImmutableCheckpoint#copyOf(Checkpoint)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Checkpoint instance = mock(Checkpoint.class);
    when(instance.year()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.quarter()).thenReturn(Quarter.Q1);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCheckpoint actualCopyOfResult = ImmutableCheckpoint.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).quarter();
    verify(instance).year();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(Quarter.Q1, actualCopyOfResult.quarter());
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCheckpoint.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCheckpoint.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCheckpoint.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCheckpoint.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableCheckpoint.Json actualJson = new ImmutableCheckpoint.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.quarter);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Json#quarter()}
   */
  @Test
  void testJsonQuarter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCheckpoint.Json()).quarter());
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Json#setYear(int)}
   */
  @Test
  void testJsonSetYear() {
    // Arrange
    ImmutableCheckpoint.Json json = new ImmutableCheckpoint.Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableCheckpoint.Json#year()}
   */
  @Test
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCheckpoint.Json()).year());
  }
}
