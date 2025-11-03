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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingCount.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingCount.Json;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingCountDiffblueTest {
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
    Builder builderResult = ImmutableAssessmentRatingCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingCount)}.
   * <ul>
   *   <li>Given {@link RatingSchemeItem}.</li>
   *   <li>Then builder build count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingCount)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingCount); given RatingSchemeItem; then builder build count is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingCount)"})
  void testBuilderFrom_givenRatingSchemeItem_thenBuilderBuildCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingCount.builder();
    AssessmentRatingCount instance = mock(AssessmentRatingCount.class);
    when(instance.count()).thenReturn(3);
    when(instance.rating()).thenReturn(mock(RatingSchemeItem.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).rating();
    assertEquals(3, builderResult.build().count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rating(RatingSchemeItem)}.
   * <ul>
   *   <li>When {@link RatingSchemeItem}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#rating(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder rating(RatingSchemeItem); when RatingSchemeItem; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rating(RatingSchemeItem)"})
  void testBuilderRating_whenRatingSchemeItem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating(mock(RatingSchemeItem.class)));
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
   *   <li>{@link Json#setRating(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRating(RatingSchemeItem)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRating(null);

    // Assert
    assertNull(actualJson.rating);
    assertEquals(0, actualJson.count);
    assertFalse(actualJson.countIsSet);
  }

  /**
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RatingSchemeItem Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rating());
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
}
