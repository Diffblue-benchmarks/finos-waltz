package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItemUsageCount.Builder;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItemUsageCount.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingSchemeItemUsageCountDiffblueTest {
  /**
   * Test Builder {@link Builder#count(int)}.
   * <p>
   * Method under test: {@link Builder#count(int)}
   */
  @Test
  @DisplayName("Test Builder count(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.count(int)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Test Builder {@link Builder#from(RatingSchemeItemUsageCount)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build ratingId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingSchemeItemUsageCount)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItemUsageCount); given three; then builder build ratingId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItemUsageCount)"})
  void testBuilderFrom_givenThree_thenBuilderBuildRatingIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();
    RatingSchemeItemUsageCount instance = mock(RatingSchemeItemUsageCount.class);
    when(instance.count()).thenReturn(3);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.schemeId()).thenReturn(1L);
    when(instance.usageKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(RatingSchemeItemUsageCount)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingSchemeItemUsageCount)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItemUsageCount); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItemUsageCount)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();
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
   * Test Builder {@link Builder#ratingId(long)}.
   * <p>
   * Method under test: {@link Builder#ratingId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingId(long)"})
  void testBuilderRatingId() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }

  /**
   * Test Builder {@link Builder#schemeId(long)}.
   * <p>
   * Method under test: {@link Builder#schemeId(long)}
   */
  @Test
  @DisplayName("Test Builder schemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.schemeId(long)"})
  void testBuilderSchemeId() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.schemeId(1L));
  }

  /**
   * Test Builder {@link Builder#usageKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#usageKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder usageKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.usageKind(EntityKind)"})
  void testBuilderUsageKind() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usageKind(EntityKind.ALL));
  }

  /**
   * Test Json {@link Json#count()}.
   * <p>
   * Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).count());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setUsageKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setUsageKind(EntityKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#ratingId()}.
   * <p>
   * Method under test: {@link Json#ratingId()}
   */
  @Test
  @DisplayName("Test Json ratingId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.ratingId()"})
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingId());
  }

  /**
   * Test Json {@link Json#schemeId()}.
   * <p>
   * Method under test: {@link Json#schemeId()}
   */
  @Test
  @DisplayName("Test Json schemeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.schemeId()"})
  void testJsonSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).schemeId());
  }

  /**
   * Test Json {@link Json#setCount(int)}.
   * <p>
   * Method under test: {@link Json#setCount(int)}
   */
  @Test
  @DisplayName("Test Json setCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCount(int)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test Json {@link Json#setRatingId(long)}.
   * <p>
   * Method under test: {@link Json#setRatingId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRatingId(long)"})
  void testJsonSetRatingId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }

  /**
   * Test Json {@link Json#setSchemeId(long)}.
   * <p>
   * Method under test: {@link Json#setSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setSchemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSchemeId(long)"})
  void testJsonSetSchemeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSchemeId(1L);

    // Assert
    assertEquals(1L, json.schemeId);
    assertTrue(json.schemeIdIsSet);
  }

  /**
   * Test Json {@link Json#usageKind()}.
   * <p>
   * Method under test: {@link Json#usageKind()}
   */
  @Test
  @DisplayName("Test Json usageKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.usageKind()"})
  void testJsonUsageKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).usageKind());
  }
}
