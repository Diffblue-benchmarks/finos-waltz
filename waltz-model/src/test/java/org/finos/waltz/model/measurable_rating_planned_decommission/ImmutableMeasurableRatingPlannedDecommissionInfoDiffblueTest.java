package org.finos.waltz.model.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingPlannedDecommissionInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Builder#decommission(MeasurableRatingPlannedDecommission)}
   */
  @Test
  void testBuilderDecommission() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.decommission(new ImmutableMeasurableRatingPlannedDecommission.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Builder#from(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo
        .builder();
    MeasurableRatingPlannedDecommissionInfo instance = mock(MeasurableRatingPlannedDecommissionInfo.class);
    ImmutableMeasurableRatingPlannedDecommission.Json json = new ImmutableMeasurableRatingPlannedDecommission.Json();
    when(instance.decommission()).thenReturn(json);
    when(instance.measurableRating()).thenReturn(mock(MeasurableRating.class));

    // Act
    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).decommission();
    verify(instance).measurableRating();
    assertSame(json, builderResult.build().decommission());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Builder#from(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo
        .builder();
    MeasurableRatingPlannedDecommissionInfo instance = mock(MeasurableRatingPlannedDecommissionInfo.class);
    when(instance.decommission()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableRating()).thenReturn(mock(MeasurableRating.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).decommission();
    verify(instance).measurableRating();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Builder#measurableRating(MeasurableRating)}
   */
  @Test
  void testBuilderMeasurableRating() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRating(mock(MeasurableRating.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo#copyOf(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingPlannedDecommissionInfo instance = mock(MeasurableRatingPlannedDecommissionInfo.class);
    ImmutableMeasurableRatingPlannedDecommission.Json json = new ImmutableMeasurableRatingPlannedDecommission.Json();
    when(instance.decommission()).thenReturn(json);
    when(instance.measurableRating()).thenReturn(mock(MeasurableRating.class));

    // Act
    ImmutableMeasurableRatingPlannedDecommissionInfo actualCopyOfResult = ImmutableMeasurableRatingPlannedDecommissionInfo
        .copyOf(instance);

    // Assert
    verify(instance).decommission();
    verify(instance).measurableRating();
    assertSame(json, actualCopyOfResult.decommission());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo#fromJson(ImmutableMeasurableRatingPlannedDecommissionInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommissionInfo.Json json = new ImmutableMeasurableRatingPlannedDecommissionInfo.Json();
    json.setMeasurableRating(mock(MeasurableRating.class));
    ImmutableMeasurableRatingPlannedDecommission.Json decommission = new ImmutableMeasurableRatingPlannedDecommission.Json();
    json.setDecommission(decommission);

    // Act
    ImmutableMeasurableRatingPlannedDecommissionInfo actualFromJsonResult = ImmutableMeasurableRatingPlannedDecommissionInfo
        .fromJson(json);

    // Assert
    assertSame(decommission, actualFromJsonResult.decommission());
    MeasurableRating expectedMeasurableRatingResult = json.measurableRating;
    assertSame(expectedMeasurableRatingResult, actualFromJsonResult.measurableRating());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#decommission()}
   */
  @Test
  void testJsonDecommission() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommissionInfo.Json()).decommission());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#setDecommission(MeasurableRatingPlannedDecommission)}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#setMeasurableRating(MeasurableRating)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableRatingPlannedDecommissionInfo.Json actualJson = new ImmutableMeasurableRatingPlannedDecommissionInfo.Json();
    actualJson.setDecommission(new ImmutableMeasurableRatingPlannedDecommission.Json());
    actualJson.setMeasurableRating(null);

    // Assert
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = actualJson.decommission;
    assertTrue(measurableRatingPlannedDecommission instanceof ImmutableMeasurableRatingPlannedDecommission.Json);
    assertNull(((ImmutableMeasurableRatingPlannedDecommission.Json) measurableRatingPlannedDecommission).id);
    assertNull(
        ((ImmutableMeasurableRatingPlannedDecommission.Json) measurableRatingPlannedDecommission).measurableRatingId);
    assertNull(((ImmutableMeasurableRatingPlannedDecommission.Json) measurableRatingPlannedDecommission).createdBy);
    assertNull(((ImmutableMeasurableRatingPlannedDecommission.Json) measurableRatingPlannedDecommission).lastUpdatedBy);
    assertNull(
        ((ImmutableMeasurableRatingPlannedDecommission.Json) measurableRatingPlannedDecommission).plannedDecommissionDate);
    assertNull(
        ((ImmutableMeasurableRatingPlannedDecommission.Json) measurableRatingPlannedDecommission).subjectDecommissionDate);
    assertNull(((ImmutableMeasurableRatingPlannedDecommission.Json) measurableRatingPlannedDecommission).createdAt);
    assertNull(((ImmutableMeasurableRatingPlannedDecommission.Json) measurableRatingPlannedDecommission).lastUpdatedAt);
    assertNull(actualJson.measurableRating);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommissionInfo.Json#measurableRating()}
   */
  @Test
  void testJsonMeasurableRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommissionInfo.Json()).measurableRating());
  }
}
