package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.measurable_rating.ImmutablePrimaryRatingViewItem.Builder;
import org.finos.waltz.model.measurable_rating.ImmutablePrimaryRatingViewItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePrimaryRatingViewItemDiffblueTest {
  /**
   * Test Builder {@link Builder#from(PrimaryRatingViewItem)}.
   * <p>
   * Method under test: {@link Builder#from(PrimaryRatingViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PrimaryRatingViewItem)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PrimaryRatingViewItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();
    PrimaryRatingViewItem instance = mock(PrimaryRatingViewItem.class);
    when(instance.measurable()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableCategory()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).measurable();
    verify(instance).measurableCategory();
  }

  /**
   * Test Builder {@link Builder#from(PrimaryRatingViewItem)}.
   * <p>
   * Method under test: {@link Builder#from(PrimaryRatingViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PrimaryRatingViewItem)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PrimaryRatingViewItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();
    PrimaryRatingViewItem instance = mock(PrimaryRatingViewItem.class);
    when(instance.ratingColor()).thenThrow(new IllegalStateException("instance"));
    when(instance.ratingDescription()).thenReturn("Rating Description");
    when(instance.ratingName()).thenReturn("Rating Name");
    when(instance.measurable()).thenReturn(mock(EntityReference.class));
    when(instance.measurableCategory()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).measurable();
    verify(instance).measurableCategory();
    verify(instance).ratingColor();
    verify(instance).ratingDescription();
    verify(instance).ratingName();
  }

  /**
   * Test Builder {@link Builder#from(PrimaryRatingViewItem)}.
   * <ul>
   *   <li>Given {@code Rating Color}.</li>
   *   <li>Then builder build ratingColor is {@code Rating Color}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PrimaryRatingViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PrimaryRatingViewItem); given 'Rating Color'; then builder build ratingColor is 'Rating Color'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PrimaryRatingViewItem)"})
  void testBuilderFrom_givenRatingColor_thenBuilderBuildRatingColorIsRatingColor() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();
    PrimaryRatingViewItem instance = mock(PrimaryRatingViewItem.class);
    when(instance.ratingColor()).thenReturn("Rating Color");
    when(instance.ratingDescription()).thenReturn("Rating Description");
    when(instance.ratingName()).thenReturn("Rating Name");
    when(instance.measurable()).thenReturn(mock(EntityReference.class));
    when(instance.measurableCategory()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurable();
    verify(instance).measurableCategory();
    verify(instance).ratingColor();
    verify(instance).ratingDescription();
    verify(instance).ratingName();
    ImmutablePrimaryRatingViewItem buildResult = builderResult.build();
    assertEquals("Rating Color", buildResult.ratingColor());
    assertEquals("Rating Description", buildResult.ratingDescription());
    assertEquals("Rating Name", buildResult.ratingName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableCategory(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurableCategory(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder measurableCategory(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableCategory(EntityReference)"})
  void testBuilderMeasurableCategory_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCategory(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#measurable(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurable(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder measurable(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurable(EntityReference)"})
  void testBuilderMeasurable_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurable(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#ratingColor(String)}.
   * <p>
   * Method under test: {@link Builder#ratingColor(String)}
   */
  @Test
  @DisplayName("Test Builder ratingColor(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingColor(String)"})
  void testBuilderRatingColor() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingColor("Rating Color"));
  }

  /**
   * Test Builder {@link Builder#ratingDescription(String)}.
   * <p>
   * Method under test: {@link Builder#ratingDescription(String)}
   */
  @Test
  @DisplayName("Test Builder ratingDescription(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingDescription(String)"})
  void testBuilderRatingDescription() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingDescription("Rating Description"));
  }

  /**
   * Test Builder {@link Builder#ratingName(String)}.
   * <p>
   * Method under test: {@link Builder#ratingName(String)}
   */
  @Test
  @DisplayName("Test Builder ratingName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingName(String)"})
  void testBuilderRatingName() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingName("Rating Name"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setMeasurable(EntityReference)}
   *   <li>{@link Json#setMeasurableCategory(EntityReference)}
   *   <li>{@link Json#setRatingColor(String)}
   *   <li>{@link Json#setRatingDescription(String)}
   *   <li>{@link Json#setRatingName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setMeasurable(EntityReference)",
      "void Json.setMeasurableCategory(EntityReference)", "void Json.setRatingColor(String)",
      "void Json.setRatingDescription(String)", "void Json.setRatingName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setMeasurable(null);
    actualJson.setMeasurableCategory(null);
    actualJson.setRatingColor("Rating Color");
    actualJson.setRatingDescription("Rating Description");
    actualJson.setRatingName("Rating Name");

    // Assert
    assertEquals("Rating Color", actualJson.ratingColor);
    assertEquals("Rating Description", actualJson.ratingDescription);
    assertEquals("Rating Name", actualJson.ratingName);
    assertNull(actualJson.measurable);
    assertNull(actualJson.measurableCategory);
  }

  /**
   * Test Json {@link Json#measurable()}.
   * <p>
   * Method under test: {@link Json#measurable()}
   */
  @Test
  @DisplayName("Test Json measurable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.measurable()"})
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurable());
  }

  /**
   * Test Json {@link Json#measurableCategory()}.
   * <p>
   * Method under test: {@link Json#measurableCategory()}
   */
  @Test
  @DisplayName("Test Json measurableCategory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.measurableCategory()"})
  void testJsonMeasurableCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableCategory());
  }

  /**
   * Test Json {@link Json#ratingColor()}.
   * <p>
   * Method under test: {@link Json#ratingColor()}
   */
  @Test
  @DisplayName("Test Json ratingColor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.ratingColor()"})
  void testJsonRatingColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingColor());
  }

  /**
   * Test Json {@link Json#ratingDescription()}.
   * <p>
   * Method under test: {@link Json#ratingDescription()}
   */
  @Test
  @DisplayName("Test Json ratingDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.ratingDescription()"})
  void testJsonRatingDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingDescription());
  }

  /**
   * Test Json {@link Json#ratingName()}.
   * <p>
   * Method under test: {@link Json#ratingName()}
   */
  @Test
  @DisplayName("Test Json ratingName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.ratingName()"})
  void testJsonRatingName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingName());
  }
}
