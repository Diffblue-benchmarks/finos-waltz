package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.data_flow_decorator.ImmutableDecoratorRatingSummary.Builder;
import org.finos.waltz.model.data_flow_decorator.ImmutableDecoratorRatingSummary.Json;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDecoratorRatingSummaryDiffblueTest {
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
    Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Test Builder {@link Builder#decoratorEntityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#decoratorEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder decoratorEntityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.decoratorEntityReference(EntityReference)"})
  void testBuilderDecoratorEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.decoratorEntityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(DecoratorRatingSummary)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build count is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DecoratorRatingSummary)}
   */
  @Test
  @DisplayName("Test Builder from(DecoratorRatingSummary); given three; then builder build count is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DecoratorRatingSummary)"})
  void testBuilderFrom_givenThree_thenBuilderBuildCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableDecoratorRatingSummary.builder();
    DecoratorRatingSummary instance = mock(DecoratorRatingSummary.class);
    when(instance.count()).thenReturn(3);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.rating()).thenReturn(ofResult);
    when(instance.decoratorEntityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).decoratorEntityReference();
    verify(instance).rating();
    ImmutableDecoratorRatingSummary buildResult = builderResult.build();
    assertEquals(3, buildResult.count());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult, buildResult.rating());
  }

  /**
   * Test Builder {@link Builder#from(DecoratorRatingSummary)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DecoratorRatingSummary)}
   */
  @Test
  @DisplayName("Test Builder from(DecoratorRatingSummary); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DecoratorRatingSummary)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDecoratorRatingSummary.builder();
    DecoratorRatingSummary instance = mock(DecoratorRatingSummary.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.rating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.decoratorEntityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).decoratorEntityReference();
    verify(instance).rating();
  }

  /**
   * Test Builder {@link Builder#rating(AuthoritativenessRatingValue)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#rating(AuthoritativenessRatingValue)}
   */
  @Test
  @DisplayName("Test Builder rating(AuthoritativenessRatingValue); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rating(AuthoritativenessRatingValue)"})
  void testBuilderRating_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating(AuthoritativenessRatingValue.of("42")));
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
   * Test Json {@link Json#decoratorEntityReference()}.
   * <p>
   * Method under test: {@link Json#decoratorEntityReference()}
   */
  @Test
  @DisplayName("Test Json decoratorEntityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.decoratorEntityReference()"})
  void testJsonDecoratorEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).decoratorEntityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDecoratorEntityReference(EntityReference)}
   *   <li>{@link Json#setRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDecoratorEntityReference(EntityReference)",
      "void Json.setRating(AuthoritativenessRatingValue)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDecoratorEntityReference(null);
    actualJson.setRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals("42", actualJson.rating.value());
  }

  /**
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuthoritativenessRatingValue Json.rating()"})
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
