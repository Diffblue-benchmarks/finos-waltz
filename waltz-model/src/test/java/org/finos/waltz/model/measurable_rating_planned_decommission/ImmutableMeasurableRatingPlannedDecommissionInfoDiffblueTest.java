package org.finos.waltz.model.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission.Json;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommissionInfo.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingPlannedDecommissionInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#decommission(MeasurableRatingPlannedDecommission)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#decommission(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName("Test Builder decommission(MeasurableRatingPlannedDecommission); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.decommission(MeasurableRatingPlannedDecommission)"})
  void testBuilderDecommission_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.decommission(new Json()));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingPlannedDecommissionInfo)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>Then builder build decommission is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingPlannedDecommissionInfo); given Json (default constructor); then builder build decommission is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPlannedDecommissionInfo)"})
  void testBuilderFrom_givenJson_thenBuilderBuildDecommissionIsJson() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();
    MeasurableRatingPlannedDecommissionInfo instance = mock(MeasurableRatingPlannedDecommissionInfo.class);
    Json json = new Json();
    when(instance.decommission()).thenReturn(json);
    when(instance.measurableRating()).thenReturn(mock(MeasurableRating.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).decommission();
    verify(instance).measurableRating();
    assertSame(json, builderResult.build().decommission());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingPlannedDecommissionInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingPlannedDecommissionInfo); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPlannedDecommissionInfo)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();
    MeasurableRatingPlannedDecommissionInfo instance = mock(MeasurableRatingPlannedDecommissionInfo.class);
    when(instance.decommission()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableRating()).thenReturn(mock(MeasurableRating.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).decommission();
    verify(instance).measurableRating();
  }

  /**
   * Test Builder {@link Builder#measurableRating(MeasurableRating)}.
   * <ul>
   *   <li>When {@link MeasurableRating}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurableRating(MeasurableRating)}
   */
  @Test
  @DisplayName("Test Builder measurableRating(MeasurableRating); when MeasurableRating; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableRating(MeasurableRating)"})
  void testBuilderMeasurableRating_whenMeasurableRating_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRating(mock(MeasurableRating.class)));
  }

  /**
   * Test Json {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#decommission()}.
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#decommission()}
   */
  @Test
  @DisplayName("Test Json decommission()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommissionInfo.Json.decommission()"})
  void testJsonDecommission() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommissionInfo.Json()).decommission());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#setDecommission(MeasurableRatingPlannedDecommission)}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#setMeasurableRating(MeasurableRating)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableMeasurableRatingPlannedDecommissionInfo.Json.<init>()",
      "void ImmutableMeasurableRatingPlannedDecommissionInfo.Json.setDecommission(MeasurableRatingPlannedDecommission)",
      "void ImmutableMeasurableRatingPlannedDecommissionInfo.Json.setMeasurableRating(MeasurableRating)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableRatingPlannedDecommissionInfo.Json actualJson = new ImmutableMeasurableRatingPlannedDecommissionInfo.Json();
    actualJson.setDecommission(new Json());
    actualJson.setMeasurableRating(null);

    // Assert
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = actualJson.decommission;
    assertTrue(measurableRatingPlannedDecommission instanceof Json);
    assertNull(((Json) measurableRatingPlannedDecommission).id);
    assertNull(((Json) measurableRatingPlannedDecommission).measurableRatingId);
    assertNull(((Json) measurableRatingPlannedDecommission).createdBy);
    assertNull(((Json) measurableRatingPlannedDecommission).lastUpdatedBy);
    assertNull(((Json) measurableRatingPlannedDecommission).plannedDecommissionDate);
    assertNull(((Json) measurableRatingPlannedDecommission).subjectDecommissionDate);
    assertNull(((Json) measurableRatingPlannedDecommission).createdAt);
    assertNull(((Json) measurableRatingPlannedDecommission).lastUpdatedAt);
    assertNull(actualJson.measurableRating);
  }

  /**
   * Test Json {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#measurableRating()}.
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#measurableRating()}
   */
  @Test
  @DisplayName("Test Json measurableRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableRating ImmutableMeasurableRatingPlannedDecommissionInfo.Json.measurableRating()"})
  void testJsonMeasurableRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommissionInfo.Json()).measurableRating());
  }
}
