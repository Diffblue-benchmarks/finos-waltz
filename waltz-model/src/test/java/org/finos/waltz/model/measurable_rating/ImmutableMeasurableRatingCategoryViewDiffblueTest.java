package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.application.MeasurableRatingsView;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingCategoryView.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingCategoryView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingCategoryViewDiffblueTest {
  /**
   * Test Builder {@link Builder#allocations(AllocationsView)}.
   * <ul>
   *   <li>When {@link ImmutableAllocationsView.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#allocations(AllocationsView)}
   */
  @Test
  @DisplayName("Test Builder allocations(AllocationsView); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocations(AllocationsView)"})
  void testBuilderAllocations_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocations(new ImmutableAllocationsView.Json()));
  }

  /**
   * Test Builder {@link Builder#decommissions(DecommissionsView)}.
   * <ul>
   *   <li>When {@link ImmutableDecommissionsView.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#decommissions(DecommissionsView)}
   */
  @Test
  @DisplayName("Test Builder decommissions(DecommissionsView); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.decommissions(DecommissionsView)"})
  void testBuilderDecommissions_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.decommissions(new ImmutableDecommissionsView.Json()));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingCategoryView)}.
   * <ul>
   *   <li>Given {@link ImmutableDecommissionsView.Json} (default constructor).</li>
   *   <li>Then builder build allocations is {@link ImmutableAllocationsView.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingCategoryView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingCategoryView); given Json (default constructor); then builder build allocations is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCategoryView)"})
  void testBuilderFrom_givenJson_thenBuilderBuildAllocationsIsJson() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();
    MeasurableRatingCategoryView instance = mock(MeasurableRatingCategoryView.class);
    when(instance.primaryRatings()).thenReturn(mock(MeasurableRatingsView.class));
    when(instance.measurableRatings()).thenReturn(mock(MeasurableRatingsView.class));
    ImmutableDecommissionsView.Json json = new ImmutableDecommissionsView.Json();
    when(instance.decommissions()).thenReturn(json);
    when(instance.primaryAssessments()).thenReturn(mock(AssessmentsView.class));
    ImmutableAllocationsView.Json json2 = new ImmutableAllocationsView.Json();
    when(instance.allocations()).thenReturn(json2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(MeasurableRatingCategoryView)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingCategoryView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingCategoryView); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCategoryView)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();
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
   * Test Builder {@link Builder#measurableRatings(MeasurableRatingsView)}.
   * <p>
   * Method under test: {@link Builder#measurableRatings(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder measurableRatings(MeasurableRatingsView)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableRatings(MeasurableRatingsView)"})
  void testBuilderMeasurableRatings() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatings(mock(MeasurableRatingsView.class)));
  }

  /**
   * Test Builder {@link Builder#primaryAssessments(AssessmentsView)}.
   * <p>
   * Method under test: {@link Builder#primaryAssessments(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder primaryAssessments(AssessmentsView)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.primaryAssessments(AssessmentsView)"})
  void testBuilderPrimaryAssessments() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryAssessments(mock(AssessmentsView.class)));
  }

  /**
   * Test Builder {@link Builder#primaryRatings(MeasurableRatingsView)}.
   * <p>
   * Method under test: {@link Builder#primaryRatings(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder primaryRatings(MeasurableRatingsView)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.primaryRatings(MeasurableRatingsView)"})
  void testBuilderPrimaryRatings() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryRatings(mock(MeasurableRatingsView.class)));
  }

  /**
   * Test Json {@link Json#allocations()}.
   * <p>
   * Method under test: {@link Json#allocations()}
   */
  @Test
  @DisplayName("Test Json allocations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AllocationsView Json.allocations()"})
  void testJsonAllocations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocations());
  }

  /**
   * Test Json {@link Json#decommissions()}.
   * <p>
   * Method under test: {@link Json#decommissions()}
   */
  @Test
  @DisplayName("Test Json decommissions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DecommissionsView Json.decommissions()"})
  void testJsonDecommissions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).decommissions());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAllocations(AllocationsView)}
   *   <li>{@link Json#setDecommissions(DecommissionsView)}
   *   <li>{@link Json#setMeasurableRatings(MeasurableRatingsView)}
   *   <li>{@link Json#setPrimaryAssessments(AssessmentsView)}
   *   <li>{@link Json#setPrimaryRatings(MeasurableRatingsView)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAllocations(AllocationsView)",
      "void Json.setDecommissions(DecommissionsView)", "void Json.setMeasurableRatings(MeasurableRatingsView)",
      "void Json.setPrimaryAssessments(AssessmentsView)", "void Json.setPrimaryRatings(MeasurableRatingsView)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAllocations(new ImmutableAllocationsView.Json());
    actualJson.setDecommissions(new ImmutableDecommissionsView.Json());
    actualJson.setMeasurableRatings(mock(MeasurableRatingsView.class));
    actualJson.setPrimaryAssessments(mock(AssessmentsView.class));
    actualJson.setPrimaryRatings(mock(MeasurableRatingsView.class));

    // Assert
    assertTrue(((ImmutableAllocationsView.Json) actualJson.allocations).allocationSchemes.isEmpty());
  }

  /**
   * Test Json {@link Json#measurableRatings()}.
   * <p>
   * Method under test: {@link Json#measurableRatings()}
   */
  @Test
  @DisplayName("Test Json measurableRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableRatingsView Json.measurableRatings()"})
  void testJsonMeasurableRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableRatings());
  }

  /**
   * Test Json {@link Json#primaryAssessments()}.
   * <p>
   * Method under test: {@link Json#primaryAssessments()}
   */
  @Test
  @DisplayName("Test Json primaryAssessments()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentsView Json.primaryAssessments()"})
  void testJsonPrimaryAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).primaryAssessments());
  }

  /**
   * Test Json {@link Json#primaryRatings()}.
   * <p>
   * Method under test: {@link Json#primaryRatings()}
   */
  @Test
  @DisplayName("Test Json primaryRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableRatingsView Json.primaryRatings()"})
  void testJsonPrimaryRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).primaryRatings());
  }
}
