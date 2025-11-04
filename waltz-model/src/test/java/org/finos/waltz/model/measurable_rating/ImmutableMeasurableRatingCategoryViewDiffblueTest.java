package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.application.MeasurableRatingsView;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingCategoryViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Builder#allocations(AllocationsView)}
   */
  @Test
  void testBuilderAllocations() {
    // Arrange
    ImmutableMeasurableRatingCategoryView.Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocations(new ImmutableAllocationsView.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Builder#decommissions(DecommissionsView)}
   */
  @Test
  void testBuilderDecommissions() {
    // Arrange
    ImmutableMeasurableRatingCategoryView.Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.decommissions(new ImmutableDecommissionsView.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Builder#from(MeasurableRatingCategoryView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingCategoryView.Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();
    MeasurableRatingCategoryView instance = mock(MeasurableRatingCategoryView.class);
    when(instance.primaryRatings()).thenReturn(mock(MeasurableRatingsView.class));
    when(instance.measurableRatings()).thenReturn(mock(MeasurableRatingsView.class));
    ImmutableDecommissionsView.Json json = new ImmutableDecommissionsView.Json();
    when(instance.decommissions()).thenReturn(json);
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));
    ImmutableAllocationsView.Json json2 = new ImmutableAllocationsView.Json();
    when(instance.allocations()).thenReturn(json2);

    // Act
    ImmutableMeasurableRatingCategoryView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocations();
    verify(instance).decommissions();
    verify(instance).measurableRatings();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
    ImmutableMeasurableRatingCategoryView buildResult = builderResult.build();
    assertSame(json2, buildResult.allocations());
    assertSame(json, buildResult.decommissions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Builder#from(MeasurableRatingCategoryView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRatingCategoryView.Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();
    MeasurableRatingCategoryView instance = mock(MeasurableRatingCategoryView.class);
    when(instance.primaryRatings()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableRatings()).thenReturn(mock(MeasurableRatingsView.class));
    when(instance.decommissions()).thenReturn(new ImmutableDecommissionsView.Json());
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));
    when(instance.allocations()).thenReturn(new ImmutableAllocationsView.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).allocations();
    verify(instance).decommissions();
    verify(instance).measurableRatings();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Builder#measurableRatings(MeasurableRatingsView)}
   */
  @Test
  void testBuilderMeasurableRatings() {
    // Arrange
    ImmutableMeasurableRatingCategoryView.Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatings(mock(MeasurableRatingsView.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Builder#primaryAssessments(AssessmentsView)}
   */
  @Test
  void testBuilderPrimaryAssessments() {
    // Arrange
    ImmutableMeasurableRatingCategoryView.Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryAssessments(mock(AssessmentsView.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Builder#primaryRatings(MeasurableRatingsView)}
   */
  @Test
  void testBuilderPrimaryRatings() {
    // Arrange
    ImmutableMeasurableRatingCategoryView.Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryRatings(mock(MeasurableRatingsView.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView#copyOf(MeasurableRatingCategoryView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingCategoryView instance = mock(MeasurableRatingCategoryView.class);
    when(instance.primaryRatings()).thenReturn(mock(MeasurableRatingsView.class));
    when(instance.measurableRatings()).thenReturn(mock(MeasurableRatingsView.class));
    ImmutableDecommissionsView.Json json = new ImmutableDecommissionsView.Json();
    when(instance.decommissions()).thenReturn(json);
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));
    ImmutableAllocationsView.Json json2 = new ImmutableAllocationsView.Json();
    when(instance.allocations()).thenReturn(json2);

    // Act
    ImmutableMeasurableRatingCategoryView actualCopyOfResult = ImmutableMeasurableRatingCategoryView.copyOf(instance);

    // Assert
    verify(instance).allocations();
    verify(instance).decommissions();
    verify(instance).measurableRatings();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
    assertSame(json2, actualCopyOfResult.allocations());
    assertSame(json, actualCopyOfResult.decommissions());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView#fromJson(ImmutableMeasurableRatingCategoryView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableRatingCategoryView.Json json = new ImmutableMeasurableRatingCategoryView.Json();
    ImmutableAllocationsView.Json allocations = new ImmutableAllocationsView.Json();
    json.setAllocations(allocations);
    json.setPrimaryAssessments(mock(AssessmentsView.class));
    ImmutableDecommissionsView.Json decommissions = new ImmutableDecommissionsView.Json();
    json.setDecommissions(decommissions);
    json.setMeasurableRatings(mock(MeasurableRatingsView.class));
    json.setPrimaryRatings(mock(MeasurableRatingsView.class));

    // Act
    ImmutableMeasurableRatingCategoryView actualFromJsonResult = ImmutableMeasurableRatingCategoryView.fromJson(json);

    // Assert
    assertSame(allocations, actualFromJsonResult.allocations());
    assertSame(decommissions, actualFromJsonResult.decommissions());
    MeasurableRatingsView expectedMeasurableRatingsResult = json.measurableRatings;
    assertSame(expectedMeasurableRatingsResult, actualFromJsonResult.measurableRatings());
    AssessmentsView expectedPrimaryAssessmentsResult = json.primaryAssessments;
    assertSame(expectedPrimaryAssessmentsResult, actualFromJsonResult.primaryAssessments());
    MeasurableRatingsView expectedPrimaryRatingsResult = json.primaryRatings;
    assertSame(expectedPrimaryRatingsResult, actualFromJsonResult.primaryRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Json#allocations()}
   */
  @Test
  void testJsonAllocations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingCategoryView.Json()).allocations());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Json#decommissions()}
   */
  @Test
  void testJsonDecommissions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingCategoryView.Json()).decommissions());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableRatingCategoryView.Json}
   *   <li>
   * {@link ImmutableMeasurableRatingCategoryView.Json#setAllocations(AllocationsView)}
   *   <li>
   * {@link ImmutableMeasurableRatingCategoryView.Json#setDecommissions(DecommissionsView)}
   *   <li>
   * {@link ImmutableMeasurableRatingCategoryView.Json#setMeasurableRatings(MeasurableRatingsView)}
   *   <li>
   * {@link ImmutableMeasurableRatingCategoryView.Json#setPrimaryAssessments(AssessmentsView)}
   *   <li>
   * {@link ImmutableMeasurableRatingCategoryView.Json#setPrimaryRatings(MeasurableRatingsView)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableRatingCategoryView.Json actualJson = new ImmutableMeasurableRatingCategoryView.Json();
    actualJson.setAllocations(new ImmutableAllocationsView.Json());
    actualJson.setDecommissions(new ImmutableDecommissionsView.Json());
    actualJson.setMeasurableRatings(mock(MeasurableRatingsView.class));
    actualJson.setPrimaryAssessments(mock(AssessmentsView.class));
    actualJson.setPrimaryRatings(mock(MeasurableRatingsView.class));

    // Assert
    assertTrue(((ImmutableAllocationsView.Json) actualJson.allocations).allocationSchemes.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Json#measurableRatings()}
   */
  @Test
  void testJsonMeasurableRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingCategoryView.Json()).measurableRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Json#primaryAssessments()}
   */
  @Test
  void testJsonPrimaryAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingCategoryView.Json()).primaryAssessments());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingCategoryView.Json#primaryRatings()}
   */
  @Test
  void testJsonPrimaryRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingCategoryView.Json()).primaryRatings());
  }
}
