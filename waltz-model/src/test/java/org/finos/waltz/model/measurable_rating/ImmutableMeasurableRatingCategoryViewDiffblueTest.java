package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.application.ImmutableAssessmentsView;
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView;
import org.finos.waltz.model.application.MeasurableRatingsView;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingCategoryView.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingCategoryView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingCategoryViewDiffblueTest {
  /**
   * Test Builder {@link Builder#allocations(AllocationsView)}.
   *
   * <ul>
   *   <li>When {@link ImmutableAllocationsView.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#allocations(AllocationsView)}
   */
  @Test
  @DisplayName(
      "Test Builder allocations(AllocationsView); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allocations(AllocationsView)"})
  void testBuilderAllocations_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act
    Builder actualAllocationsResult =
        builderResult.allocations(new ImmutableAllocationsView.Json());

    // Assert
    assertSame(builderResult, actualAllocationsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingCategoryView Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    ImmutableAllocationsView allocations = ImmutableAllocationsView.builder().build();
    ImmutableDecommissionsView decommissions = ImmutableDecommissionsView.builder().build();
    ImmutableMeasurableRatingsView measurableRatings =
        ImmutableMeasurableRatingsView.builder().build();
    ImmutableAssessmentsView primaryAssessments = ImmutableAssessmentsView.builder().build();
    ImmutableMeasurableRatingsView primaryRatings =
        ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingCategoryView actualImmutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(allocations)
            .decommissions(decommissions)
            .measurableRatings(measurableRatings)
            .primaryAssessments(primaryAssessments)
            .primaryRatings(primaryRatings)
            .build();

    // Assert
    assertSame(
        primaryAssessments, actualImmutableMeasurableRatingCategoryView.primaryAssessments());
    assertSame(measurableRatings, actualImmutableMeasurableRatingCategoryView.measurableRatings());
    assertSame(primaryRatings, actualImmutableMeasurableRatingCategoryView.primaryRatings());
    assertSame(allocations, actualImmutableMeasurableRatingCategoryView.allocations());
    assertSame(decommissions, actualImmutableMeasurableRatingCategoryView.decommissions());
  }

  /**
   * Test Builder {@link Builder#decommissions(DecommissionsView)}.
   *
   * <ul>
   *   <li>When {@link ImmutableDecommissionsView.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#decommissions(DecommissionsView)}
   */
  @Test
  @DisplayName(
      "Test Builder decommissions(DecommissionsView); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.decommissions(DecommissionsView)"})
  void testBuilderDecommissions_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act
    Builder actualDecommissionsResult =
        builderResult.decommissions(new ImmutableDecommissionsView.Json());

    // Assert
    assertSame(builderResult, actualDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingCategoryView)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingCategoryView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingCategoryView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCategoryView)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();
    ImmutableMeasurableRatingCategoryView instance =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRatingCategoryView actualImmutableMeasurableRatingCategoryView =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingCategoryView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableRatings(MeasurableRatingsView)}.
   *
   * <p>Method under test: {@link Builder#measurableRatings(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder measurableRatings(MeasurableRatingsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableRatings(MeasurableRatingsView)"})
  void testBuilderMeasurableRatings() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act
    Builder actualMeasurableRatingsResult =
        builderResult.measurableRatings(mock(MeasurableRatingsView.class));

    // Assert
    assertSame(builderResult, actualMeasurableRatingsResult);
  }

  /**
   * Test Builder {@link Builder#primaryAssessments(AssessmentsView)}.
   *
   * <p>Method under test: {@link Builder#primaryAssessments(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder primaryAssessments(AssessmentsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.primaryAssessments(AssessmentsView)"})
  void testBuilderPrimaryAssessments() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act
    Builder actualPrimaryAssessmentsResult =
        builderResult.primaryAssessments(mock(AssessmentsView.class));

    // Assert
    assertSame(builderResult, actualPrimaryAssessmentsResult);
  }

  /**
   * Test Builder {@link Builder#primaryRatings(MeasurableRatingsView)}.
   *
   * <p>Method under test: {@link Builder#primaryRatings(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder primaryRatings(MeasurableRatingsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.primaryRatings(MeasurableRatingsView)"})
  void testBuilderPrimaryRatings() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingCategoryView.builder();

    // Act
    Builder actualPrimaryRatingsResult =
        builderResult.primaryRatings(mock(MeasurableRatingsView.class));

    // Assert
    assertSame(builderResult, actualPrimaryRatingsResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#copyOf(MeasurableRatingCategoryView)}.
   *
   * <ul>
   *   <li>Then primaryAssessments return {@link ImmutableAssessmentsView}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingCategoryView#copyOf(MeasurableRatingCategoryView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRatingCategoryView); then primaryAssessments return ImmutableAssessmentsView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingCategoryView ImmutableMeasurableRatingCategoryView.copyOf(MeasurableRatingCategoryView)"
  })
  void testCopyOf_thenPrimaryAssessmentsReturnImmutableAssessmentsView() {
    // Arrange
    ImmutableMeasurableRatingCategoryView instance =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    ImmutableMeasurableRatingCategoryView actualCopyOfResult =
        ImmutableMeasurableRatingCategoryView.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.primaryAssessments() instanceof ImmutableAssessmentsView);
    MeasurableRatingsView measurableRatingsResult = actualCopyOfResult.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    MeasurableRatingsView primaryRatingsResult = actualCopyOfResult.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(actualCopyOfResult.allocations() instanceof ImmutableAllocationsView);
    assertTrue(actualCopyOfResult.decommissions() instanceof ImmutableDecommissionsView);
    assertEquals(measurableRatingsResult, primaryRatingsResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#equals(Object)}, and {@link
   * ImmutableMeasurableRatingCategoryView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingCategoryView#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingCategoryView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingCategoryView.equals(Object)",
    "int ImmutableMeasurableRatingCategoryView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView2 =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingCategoryView, immutableMeasurableRatingCategoryView2);
    assertEquals(
        immutableMeasurableRatingCategoryView.hashCode(),
        immutableMeasurableRatingCategoryView2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#equals(Object)}, and {@link
   * ImmutableMeasurableRatingCategoryView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingCategoryView#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingCategoryView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingCategoryView.equals(Object)",
    "int ImmutableMeasurableRatingCategoryView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingCategoryView, immutableMeasurableRatingCategoryView);
    int expectedHashCodeResult = immutableMeasurableRatingCategoryView.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingCategoryView.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingCategoryView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingCategoryView.equals(Object)",
    "int ImmutableMeasurableRatingCategoryView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAllocationsView.Builder builderResult = ImmutableAllocationsView.builder();
    builderResult.addAllocationSchemes(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(builderResult.build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingCategoryView,
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingCategoryView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingCategoryView.equals(Object)",
    "int ImmutableMeasurableRatingCategoryView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingCategoryView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingCategoryView.equals(Object)",
    "int ImmutableMeasurableRatingCategoryView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build(),
        "Different type to ImmutableMeasurableRatingCategoryView");
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return allocations is {@link ImmutableAllocationsView.Json} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingCategoryView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocations is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingCategoryView ImmutableMeasurableRatingCategoryView.fromJson(Json)"
  })
  void testFromJson_thenReturnAllocationsIsJson() {
    // Arrange
    Json json = new Json();
    ImmutableAllocationsView.Json allocations = new ImmutableAllocationsView.Json();
    json.setAllocations(allocations);
    json.setPrimaryAssessments(mock(AssessmentsView.class));
    ImmutableDecommissionsView.Json decommissions = new ImmutableDecommissionsView.Json();
    json.setDecommissions(decommissions);
    json.setMeasurableRatings(mock(MeasurableRatingsView.class));
    json.setPrimaryRatings(mock(MeasurableRatingsView.class));

    // Act
    ImmutableMeasurableRatingCategoryView actualFromJsonResult =
        ImmutableMeasurableRatingCategoryView.fromJson(json);

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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingCategoryView#toString()}
   *   <li>{@link ImmutableMeasurableRatingCategoryView#allocations()}
   *   <li>{@link ImmutableMeasurableRatingCategoryView#decommissions()}
   *   <li>{@link ImmutableMeasurableRatingCategoryView#measurableRatings()}
   *   <li>{@link ImmutableMeasurableRatingCategoryView#primaryAssessments()}
   *   <li>{@link ImmutableMeasurableRatingCategoryView#primaryRatings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AllocationsView ImmutableMeasurableRatingCategoryView.allocations()",
    "DecommissionsView ImmutableMeasurableRatingCategoryView.decommissions()",
    "MeasurableRatingsView ImmutableMeasurableRatingCategoryView.measurableRatings()",
    "AssessmentsView ImmutableMeasurableRatingCategoryView.primaryAssessments()",
    "MeasurableRatingsView ImmutableMeasurableRatingCategoryView.primaryRatings()",
    "String ImmutableMeasurableRatingCategoryView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    String actualToStringResult = immutableMeasurableRatingCategoryView.toString();
    AllocationsView actualAllocationsResult = immutableMeasurableRatingCategoryView.allocations();
    DecommissionsView actualDecommissionsResult =
        immutableMeasurableRatingCategoryView.decommissions();
    MeasurableRatingsView actualMeasurableRatingsResult =
        immutableMeasurableRatingCategoryView.measurableRatings();
    AssessmentsView actualPrimaryAssessmentsResult =
        immutableMeasurableRatingCategoryView.primaryAssessments();
    MeasurableRatingsView actualPrimaryRatingsResult =
        immutableMeasurableRatingCategoryView.primaryRatings();

    // Assert
    assertTrue(actualPrimaryAssessmentsResult instanceof ImmutableAssessmentsView);
    assertTrue(actualMeasurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(actualPrimaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(actualAllocationsResult instanceof ImmutableAllocationsView);
    assertTrue(actualDecommissionsResult instanceof ImmutableDecommissionsView);
    assertEquals(
        "MeasurableRatingCategoryView{allocations=AllocationsView{allocationSchemes=[], allocations=[]},"
            + " primaryAssessments=AssessmentsView{assessmentRatings=[], ratingSchemeItems=[], assessmentDefinitions=[],"
            + " ratingSchemeItemsById={}}, decommissions=DecommissionsView{plannedDecommissions=[], replacingDecommissions"
            + "=[], plannedReplacements=[]}, measurableRatings=MeasurableRatingsView{measurableCategories=[],"
            + " measurables=[], measurableRatings=[], ratingSchemeItems=[], measurableHierarchy=[]}, primaryRatings"
            + "=MeasurableRatingsView{measurableCategories=[], measurables=[], measurableRatings=[], ratingSchemeItems=[],"
            + " measurableHierarchy=[]}}",
        actualToStringResult);
    assertEquals(actualMeasurableRatingsResult, actualPrimaryRatingsResult);
  }

  /**
   * Test Json {@link Json#allocations()}.
   *
   * <p>Method under test: {@link Json#allocations()}
   */
  @Test
  @DisplayName("Test Json allocations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AllocationsView Json.allocations()"})
  void testJsonAllocations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocations());
  }

  /**
   * Test Json {@link Json#decommissions()}.
   *
   * <p>Method under test: {@link Json#decommissions()}
   */
  @Test
  @DisplayName("Test Json decommissions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DecommissionsView Json.decommissions()"})
  void testJsonDecommissions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().decommissions());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAllocations(AllocationsView)",
    "void Json.setDecommissions(DecommissionsView)",
    "void Json.setMeasurableRatings(MeasurableRatingsView)",
    "void Json.setPrimaryAssessments(AssessmentsView)",
    "void Json.setPrimaryRatings(MeasurableRatingsView)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAllocations(ImmutableAllocationsView.builder().build());
    actualJson.setDecommissions(ImmutableDecommissionsView.builder().build());
    ImmutableMeasurableRatingsView measurableRatings =
        ImmutableMeasurableRatingsView.builder().build();
    actualJson.setMeasurableRatings(measurableRatings);
    actualJson.setPrimaryAssessments(ImmutableAssessmentsView.builder().build());
    actualJson.setPrimaryRatings(ImmutableMeasurableRatingsView.builder().build());

    // Assert
    AssessmentsView assessmentsView = actualJson.primaryAssessments;
    assertTrue(assessmentsView instanceof ImmutableAssessmentsView);
    MeasurableRatingsView measurableRatingsView = actualJson.measurableRatings;
    assertTrue(measurableRatingsView instanceof ImmutableMeasurableRatingsView);
    MeasurableRatingsView measurableRatingsView2 = actualJson.primaryRatings;
    assertTrue(measurableRatingsView2 instanceof ImmutableMeasurableRatingsView);
    AllocationsView allocationsView = actualJson.allocations;
    assertTrue(allocationsView instanceof ImmutableAllocationsView);
    DecommissionsView decommissionsView = actualJson.decommissions;
    assertTrue(decommissionsView instanceof ImmutableDecommissionsView);
    assertTrue(assessmentsView.ratingSchemeItemsById().isEmpty());
    Set<AllocationScheme> allocationSchemesResult = allocationsView.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    assertEquals(measurableRatings, measurableRatingsView2);
    assertSame(allocationSchemesResult, assessmentsView.assessmentDefinitions());
    assertSame(allocationSchemesResult, assessmentsView.assessmentRatings());
    assertSame(allocationSchemesResult, assessmentsView.ratingSchemeItems());
    assertSame(allocationSchemesResult, measurableRatingsView.measurableCategories());
    assertSame(allocationSchemesResult, measurableRatingsView.measurableHierarchy());
    assertSame(allocationSchemesResult, measurableRatingsView.measurableRatings());
    assertSame(allocationSchemesResult, measurableRatingsView.measurables());
    assertSame(allocationSchemesResult, measurableRatingsView.ratingSchemeItems());
    assertSame(allocationSchemesResult, allocationsView.allocations());
    assertSame(allocationSchemesResult, decommissionsView.plannedDecommissions());
    assertSame(allocationSchemesResult, decommissionsView.plannedReplacements());
    assertSame(allocationSchemesResult, decommissionsView.replacingDecommissions());
  }

  /**
   * Test Json {@link Json#measurableRatings()}.
   *
   * <p>Method under test: {@link Json#measurableRatings()}
   */
  @Test
  @DisplayName("Test Json measurableRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingsView Json.measurableRatings()"})
  void testJsonMeasurableRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableRatings());
  }

  /**
   * Test Json {@link Json#primaryAssessments()}.
   *
   * <p>Method under test: {@link Json#primaryAssessments()}
   */
  @Test
  @DisplayName("Test Json primaryAssessments()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentsView Json.primaryAssessments()"})
  void testJsonPrimaryAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().primaryAssessments());
  }

  /**
   * Test Json {@link Json#primaryRatings()}.
   *
   * <p>Method under test: {@link Json#primaryRatings()}
   */
  @Test
  @DisplayName("Test Json primaryRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingsView Json.primaryRatings()"})
  void testJsonPrimaryRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().primaryRatings());
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#withAllocations(AllocationsView)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingCategoryView#withAllocations(AllocationsView)}
   */
  @Test
  @DisplayName("Test withAllocations(AllocationsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingCategoryView ImmutableMeasurableRatingCategoryView.withAllocations(AllocationsView)"
  })
  void testWithAllocations() {
    // Arrange
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    ImmutableMeasurableRatingCategoryView actualWithAllocationsResult =
        immutableMeasurableRatingCategoryView.withAllocations(
            ImmutableAllocationsView.builder().build());

    // Assert
    assertEquals(immutableMeasurableRatingCategoryView, actualWithAllocationsResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#withDecommissions(DecommissionsView)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingCategoryView#withDecommissions(DecommissionsView)}
   */
  @Test
  @DisplayName("Test withDecommissions(DecommissionsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingCategoryView ImmutableMeasurableRatingCategoryView.withDecommissions(DecommissionsView)"
  })
  void testWithDecommissions() {
    // Arrange
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    ImmutableMeasurableRatingCategoryView actualWithDecommissionsResult =
        immutableMeasurableRatingCategoryView.withDecommissions(
            ImmutableDecommissionsView.builder().build());

    // Assert
    assertEquals(immutableMeasurableRatingCategoryView, actualWithDecommissionsResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingCategoryView#withMeasurableRatings(MeasurableRatingsView)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingCategoryView#withMeasurableRatings(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test withMeasurableRatings(MeasurableRatingsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingCategoryView ImmutableMeasurableRatingCategoryView.withMeasurableRatings(MeasurableRatingsView)"
  })
  void testWithMeasurableRatings() {
    // Arrange
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    ImmutableMeasurableRatingCategoryView actualWithMeasurableRatingsResult =
        immutableMeasurableRatingCategoryView.withMeasurableRatings(
            ImmutableMeasurableRatingsView.builder().build());

    // Assert
    assertEquals(immutableMeasurableRatingCategoryView, actualWithMeasurableRatingsResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#withPrimaryAssessments(AssessmentsView)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingCategoryView#withPrimaryAssessments(AssessmentsView)}
   */
  @Test
  @DisplayName("Test withPrimaryAssessments(AssessmentsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingCategoryView ImmutableMeasurableRatingCategoryView.withPrimaryAssessments(AssessmentsView)"
  })
  void testWithPrimaryAssessments() {
    // Arrange
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    ImmutableMeasurableRatingCategoryView actualWithPrimaryAssessmentsResult =
        immutableMeasurableRatingCategoryView.withPrimaryAssessments(
            ImmutableAssessmentsView.builder().build());

    // Assert
    assertEquals(immutableMeasurableRatingCategoryView, actualWithPrimaryAssessmentsResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingCategoryView#withPrimaryRatings(MeasurableRatingsView)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingCategoryView#withPrimaryRatings(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test withPrimaryRatings(MeasurableRatingsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingCategoryView ImmutableMeasurableRatingCategoryView.withPrimaryRatings(MeasurableRatingsView)"
  })
  void testWithPrimaryRatings() {
    // Arrange
    ImmutableMeasurableRatingCategoryView immutableMeasurableRatingCategoryView =
        ImmutableMeasurableRatingCategoryView.builder()
            .allocations(ImmutableAllocationsView.builder().build())
            .decommissions(ImmutableDecommissionsView.builder().build())
            .measurableRatings(ImmutableMeasurableRatingsView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    ImmutableMeasurableRatingCategoryView actualWithPrimaryRatingsResult =
        immutableMeasurableRatingCategoryView.withPrimaryRatings(
            ImmutableMeasurableRatingsView.builder().build());

    // Assert
    assertEquals(immutableMeasurableRatingCategoryView, actualWithPrimaryRatingsResult);
  }
}
