package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ImmutableComplexityEntryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableComplexityEntry#builder()}
   *   <li>{@link ImmutableComplexityEntry#complexityScore(BigDecimal)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableComplexityEntry.Builder actualBuilderResult = ImmutableComplexityEntry.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.complexityScore(new BigDecimal("2.3")));
  }

  /**
   * Method under test: {@link ImmutableComplexityEntry.Builder#appId(long)}
   */
  @Test
  void testBuilderAppId() {
    // Arrange
    ImmutableComplexityEntry.Builder builderResult = ImmutableComplexityEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityEntry.Builder#complexityKindId(long)}
   */
  @Test
  void testBuilderComplexityKindId() {
    // Arrange
    ImmutableComplexityEntry.Builder builderResult = ImmutableComplexityEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKindId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityEntry.Builder#from(ComplexityEntry)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableComplexityEntry.Builder builderResult = ImmutableComplexityEntry.builder();
    ComplexityEntry instance = mock(ComplexityEntry.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.complexityScore()).thenReturn(bigDecimal);
    when(instance.appId()).thenReturn(1L);
    when(instance.complexityKindId()).thenReturn(1L);

    // Act
    ImmutableComplexityEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).complexityKindId();
    verify(instance).complexityScore();
    ImmutableComplexityEntry buildResult = builderResult.build();
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.complexityKindId());
    assertSame(bigDecimal, buildResult.complexityScore());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityEntry.Builder#from(ComplexityEntry)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableComplexityEntry.Builder builderResult = ImmutableComplexityEntry.builder();
    ComplexityEntry instance = mock(ComplexityEntry.class);
    when(instance.complexityScore()).thenReturn(null);
    when(instance.appId()).thenReturn(1L);
    when(instance.complexityKindId()).thenReturn(1L);

    // Act
    ImmutableComplexityEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).complexityKindId();
    verify(instance).complexityScore();
    ImmutableComplexityEntry buildResult = builderResult.build();
    assertNull(buildResult.complexityScore());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.complexityKindId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableComplexityEntry#copyOf(ComplexityEntry)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ComplexityEntry instance = mock(ComplexityEntry.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.complexityScore()).thenReturn(bigDecimal);
    when(instance.appId()).thenReturn(1L);
    when(instance.complexityKindId()).thenReturn(1L);

    // Act
    ImmutableComplexityEntry actualCopyOfResult = ImmutableComplexityEntry.copyOf(instance);

    // Assert
    verify(instance).appId();
    verify(instance).complexityKindId();
    verify(instance).complexityScore();
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.complexityKindId());
    BigDecimal expectedComplexityScoreResult = new BigDecimal("2.3");
    BigDecimal complexityScoreResult = actualCopyOfResult.complexityScore();
    assertEquals(expectedComplexityScoreResult, complexityScoreResult);
    assertSame(bigDecimal, complexityScoreResult);
  }

  /**
   * Method under test: {@link ImmutableComplexityEntry#copyOf(ComplexityEntry)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ComplexityEntry instance = mock(ComplexityEntry.class);
    when(instance.complexityScore()).thenReturn(null);
    when(instance.appId()).thenReturn(1L);
    when(instance.complexityKindId()).thenReturn(1L);

    // Act
    ImmutableComplexityEntry actualCopyOfResult = ImmutableComplexityEntry.copyOf(instance);

    // Assert
    verify(instance).appId();
    verify(instance).complexityKindId();
    verify(instance).complexityScore();
    assertNull(actualCopyOfResult.complexityScore());
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.complexityKindId());
  }

  /**
   * Method under test: {@link ImmutableComplexityEntry.Json#appId()}
   */
  @Test
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityEntry.Json()).appId());
  }

  /**
   * Method under test: {@link ImmutableComplexityEntry.Json#complexityKindId()}
   */
  @Test
  void testJsonComplexityKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityEntry.Json()).complexityKindId());
  }

  /**
   * Method under test: {@link ImmutableComplexityEntry.Json#complexityScore()}
   */
  @Test
  void testJsonComplexityScore() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityEntry.Json()).complexityScore());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableComplexityEntry.Json}
   *   <li>{@link ImmutableComplexityEntry.Json#setComplexityScore(BigDecimal)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableComplexityEntry.Json actualJson = new ImmutableComplexityEntry.Json();
    actualJson.setComplexityScore(new BigDecimal("2.3"));

    // Assert
    assertEquals(0L, actualJson.appId);
    assertEquals(0L, actualJson.complexityKindId);
    assertFalse(actualJson.appIdIsSet);
    assertFalse(actualJson.complexityKindIdIsSet);
    assertEquals(new BigDecimal("2.3"), actualJson.complexityScore);
  }

  /**
   * Method under test: {@link ImmutableComplexityEntry.Json#setAppId(long)}
   */
  @Test
  void testJsonSetAppId() {
    // Arrange
    ImmutableComplexityEntry.Json json = new ImmutableComplexityEntry.Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityEntry.Json#setComplexityKindId(long)}
   */
  @Test
  void testJsonSetComplexityKindId() {
    // Arrange
    ImmutableComplexityEntry.Json json = new ImmutableComplexityEntry.Json();

    // Act
    json.setComplexityKindId(1L);

    // Assert
    assertEquals(1L, json.complexityKindId);
    assertTrue(json.complexityKindIdIsSet);
  }
}
