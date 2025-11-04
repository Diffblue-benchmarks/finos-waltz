package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ImmutableRatingSchemeItemUsageCountDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Builder#count(int)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount.Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Builder#from(RatingSchemeItemUsageCount)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount.Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();
    RatingSchemeItemUsageCount instance = mock(RatingSchemeItemUsageCount.class);
    when(instance.count()).thenReturn(3);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.usageKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableRatingSchemeItemUsageCount.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).ratingId();
    verify(instance).schemeId();
    verify(instance).usageKind();
    ImmutableRatingSchemeItemUsageCount buildResult = builderResult.build();
    assertEquals(1L, buildResult.ratingId());
    assertEquals(1L, buildResult.schemeId());
    assertEquals(3, buildResult.count());
    assertEquals(EntityKind.ALL, buildResult.usageKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Builder#from(RatingSchemeItemUsageCount)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount.Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();
    RatingSchemeItemUsageCount instance = mock(RatingSchemeItemUsageCount.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.ratingId()).thenReturn(1L);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.usageKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).ratingId();
    verify(instance).schemeId();
    verify(instance).usageKind();
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Builder#ratingId(long)}
   */
  @Test
  void testBuilderRatingId() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount.Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Builder#schemeId(long)}
   */
  @Test
  void testBuilderSchemeId() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount.Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.schemeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Builder#usageKind(EntityKind)}
   */
  @Test
  void testBuilderUsageKind() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount.Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usageKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount#copyOf(RatingSchemeItemUsageCount)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RatingSchemeItemUsageCount instance = mock(RatingSchemeItemUsageCount.class);
    when(instance.count()).thenReturn(3);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.usageKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableRatingSchemeItemUsageCount actualCopyOfResult = ImmutableRatingSchemeItemUsageCount.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).ratingId();
    verify(instance).schemeId();
    verify(instance).usageKind();
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertEquals(1L, actualCopyOfResult.schemeId());
    assertEquals(3, actualCopyOfResult.count());
    assertEquals(EntityKind.ALL, actualCopyOfResult.usageKind());
  }

  /**
   * Method under test: {@link ImmutableRatingSchemeItemUsageCount.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingSchemeItemUsageCount.Json()).count());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableRatingSchemeItemUsageCount.Json}
   *   <li>{@link ImmutableRatingSchemeItemUsageCount.Json#setUsageKind(EntityKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableRatingSchemeItemUsageCount.Json actualJson = new ImmutableRatingSchemeItemUsageCount.Json();
    actualJson.setUsageKind(EntityKind.ALL);

    // Assert
    assertEquals(0, actualJson.count);
    assertEquals(0L, actualJson.ratingId);
    assertEquals(0L, actualJson.schemeId);
    assertEquals(EntityKind.ALL, actualJson.usageKind);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.ratingIdIsSet);
    assertFalse(actualJson.schemeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Json#ratingId()}
   */
  @Test
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRatingSchemeItemUsageCount.Json()).ratingId());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Json#schemeId()}
   */
  @Test
  void testJsonSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRatingSchemeItemUsageCount.Json()).schemeId());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Json#setCount(int)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount.Json json = new ImmutableRatingSchemeItemUsageCount.Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Json#setRatingId(long)}
   */
  @Test
  void testJsonSetRatingId() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount.Json json = new ImmutableRatingSchemeItemUsageCount.Json();

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Json#setSchemeId(long)}
   */
  @Test
  void testJsonSetSchemeId() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount.Json json = new ImmutableRatingSchemeItemUsageCount.Json();

    // Act
    json.setSchemeId(1L);

    // Assert
    assertEquals(1L, json.schemeId);
    assertTrue(json.schemeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingSchemeItemUsageCount.Json#usageKind()}
   */
  @Test
  void testJsonUsageKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRatingSchemeItemUsageCount.Json()).usageKind());
  }
}
