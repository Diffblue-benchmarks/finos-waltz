package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.ImmutableApplicationsView.Builder;
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView.Json;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplications(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplications(Iterable)"})
  void testBuilderAddAllApplications_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act
    Builder actualAddAllApplicationsResult = builderResult.addAllApplications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addApplications(Application)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableApplication.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addApplications(Application)}
   */
  @Test
  @DisplayName(
      "Test Builder addApplications(Application) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplications(Application)"})
  void testBuilderAddApplicationsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act
    Builder actualAddApplicationsResult =
        builderResult.addApplications(new ImmutableApplication.Json());

    // Assert
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addApplications(Application[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableApplication.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addApplications(Application[])}
   */
  @Test
  @DisplayName(
      "Test Builder addApplications(Application[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplications(Application[])"})
  void testBuilderAddApplicationsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act
    Builder actualAddApplicationsResult =
        builderResult.addApplications(new ImmutableApplication.Json());

    // Assert
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#applications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applications(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applications(Iterable)"})
  void testBuilderApplications_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act
    Builder actualApplicationsResult = builderResult.applications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualApplicationsResult);
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
  @MethodsUnderTest({"ImmutableApplicationsView Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    ImmutableAssessmentsView primaryAssessments = ImmutableAssessmentsView.builder().build();
    ImmutableMeasurableRatingsView primaryRatings =
        ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableApplicationsView actualImmutableApplicationsView =
        ImmutableApplicationsView.builder()
            .primaryAssessments(primaryAssessments)
            .primaryRatings(primaryRatings)
            .build();

    // Assert
    assertTrue(actualImmutableApplicationsView.applications().isEmpty());
    assertSame(primaryAssessments, actualImmutableApplicationsView.primaryAssessments());
    assertSame(primaryRatings, actualImmutableApplicationsView.primaryRatings());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationsView)}.
   *
   * <ul>
   *   <li>Then return build applications Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationsView)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationsView); then return build applications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationsView)"})
  void testBuilderFrom_thenReturnBuildApplicationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    ImmutableApplicationsView immutableApplicationsView =
        builderResult
            .from(
                ImmutableApplicationsView.builder()
                    .primaryAssessments(ImmutableAssessmentsView.builder().build())
                    .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
                    .build())
            .build();
    AssessmentsView primaryAssessmentsResult = immutableApplicationsView.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = immutableApplicationsView.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    Set<Application> applicationsResult = immutableApplicationsView.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(applicationsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(applicationsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(applicationsResult, primaryRatingsResult.measurableCategories());
    assertSame(applicationsResult, primaryRatingsResult.measurableHierarchy());
    assertSame(applicationsResult, primaryRatingsResult.measurableRatings());
    assertSame(applicationsResult, primaryRatingsResult.measurables());
    assertSame(applicationsResult, primaryRatingsResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationsView)}.
   *
   * <ul>
   *   <li>Then return build applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ApplicationsView)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationsView); then return build applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationsView)"})
  void testBuilderFrom_thenReturnBuildApplicationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    Builder builderResult2 = ImmutableApplicationsView.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    builderResult2.addApplications(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    // Act and Assert
    ImmutableApplicationsView immutableApplicationsView =
        builderResult
            .from(
                builderResult2
                    .primaryAssessments(ImmutableAssessmentsView.builder().build())
                    .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
                    .build())
            .build();
    AssessmentsView primaryAssessmentsResult = immutableApplicationsView.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = immutableApplicationsView.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, immutableApplicationsView.applications().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        primaryAssessmentsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableCategories());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableHierarchy());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableRatings());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurables());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#primaryAssessments(AssessmentsView)}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentsView.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#primaryAssessments(AssessmentsView)}
   */
  @Test
  @DisplayName(
      "Test Builder primaryAssessments(AssessmentsView); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.primaryAssessments(AssessmentsView)"})
  void testBuilderPrimaryAssessments_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act
    Builder actualPrimaryAssessmentsResult =
        builderResult.primaryAssessments(new ImmutableAssessmentsView.Json());

    // Assert
    assertSame(builderResult, actualPrimaryAssessmentsResult);
  }

  /**
   * Test Builder {@link Builder#primaryRatings(MeasurableRatingsView)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#primaryRatings(MeasurableRatingsView)}
   */
  @Test
  @DisplayName(
      "Test Builder primaryRatings(MeasurableRatingsView); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.primaryRatings(MeasurableRatingsView)"})
  void testBuilderPrimaryRatings_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act
    Builder actualPrimaryRatingsResult = builderResult.primaryRatings(new Json());

    // Assert
    assertSame(builderResult, actualPrimaryRatingsResult);
  }

  /**
   * Test {@link ImmutableApplicationsView#copyOf(ApplicationsView)}.
   *
   * <ul>
   *   <li>Then primaryAssessments return {@link ImmutableAssessmentsView}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationsView#copyOf(ApplicationsView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ApplicationsView); then primaryAssessments return ImmutableAssessmentsView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationsView ImmutableApplicationsView.copyOf(ApplicationsView)"
  })
  void testCopyOf_thenPrimaryAssessmentsReturnImmutableAssessmentsView() {
    // Arrange
    ImmutableApplicationsView instance =
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    ImmutableApplicationsView actualCopyOfResult = ImmutableApplicationsView.copyOf(instance);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualCopyOfResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = actualCopyOfResult.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(applicationsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(applicationsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(applicationsResult, primaryRatingsResult.measurableCategories());
    assertSame(applicationsResult, primaryRatingsResult.measurableHierarchy());
    assertSame(applicationsResult, primaryRatingsResult.measurableRatings());
    assertSame(applicationsResult, primaryRatingsResult.measurables());
    assertSame(applicationsResult, primaryRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableApplicationsView#equals(Object)}, and {@link
   * ImmutableApplicationsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationsView#equals(Object)}
   *   <li>{@link ImmutableApplicationsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationsView.equals(Object)",
    "int ImmutableApplicationsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableApplicationsView immutableApplicationsView =
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();
    ImmutableApplicationsView immutableApplicationsView2 =
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act and Assert
    assertEquals(immutableApplicationsView, immutableApplicationsView2);
    assertEquals(immutableApplicationsView.hashCode(), immutableApplicationsView2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationsView#equals(Object)}, and {@link
   * ImmutableApplicationsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationsView#equals(Object)}
   *   <li>{@link ImmutableApplicationsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationsView.equals(Object)",
    "int ImmutableApplicationsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableApplicationsView immutableApplicationsView =
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act and Assert
    assertEquals(immutableApplicationsView, immutableApplicationsView);
    int expectedHashCodeResult = immutableApplicationsView.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationsView.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationsView.equals(Object)",
    "int ImmutableApplicationsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    builderResult.addApplications(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    ImmutableApplicationsView immutableApplicationsView =
        builderResult
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationsView,
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableApplicationsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationsView.equals(Object)",
    "int ImmutableApplicationsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    builderResult.addAssessmentRatings(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    ImmutableApplicationsView immutableApplicationsView =
        ImmutableApplicationsView.builder()
            .primaryAssessments(builderResult.build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationsView,
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableApplicationsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationsView.equals(Object)",
    "int ImmutableApplicationsView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableApplicationsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationsView.equals(Object)",
    "int ImmutableApplicationsView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build(),
        "Different type to ImmutableApplicationsView");
  }

  /**
   * Test {@link ImmutableApplicationsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link ImmutableApplicationsView.Json} (default constructor) Applications is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationsView#fromJson(ImmutableApplicationsView.Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Applications is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationsView ImmutableApplicationsView.fromJson(ImmutableApplicationsView.Json)"
  })
  void testFromJson_givenHashSet_whenJsonApplicationsIsHashSet() {
    // Arrange
    ImmutableApplicationsView.Json json = new ImmutableApplicationsView.Json();
    json.setApplications(new HashSet<>());
    json.setPrimaryAssessments(new ImmutableAssessmentsView.Json());
    Json primaryRatings = new Json();
    json.setPrimaryRatings(primaryRatings);

    // Act
    ImmutableApplicationsView actualFromJsonResult = ImmutableApplicationsView.fromJson(json);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualFromJsonResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView.Json);
    MeasurableRatingsView primaryRatingsResult = actualFromJsonResult.primaryRatings();
    assertTrue(primaryRatingsResult instanceof Json);
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(
        applicationsResult,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentRatings);
    assertSame(
        applicationsResult,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).ratingSchemeItems);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurableCategories);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurableHierarchy);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurableRatings);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurables);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).ratingSchemeItems);
    assertSame(
        primaryRatings.ratingSchemeItems,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentDefinitions);
  }

  /**
   * Test {@link ImmutableApplicationsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableApplication.Json}
   *       (default constructor).
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationsView#fromJson(ImmutableApplicationsView.Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationsView ImmutableApplicationsView.fromJson(ImmutableApplicationsView.Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnApplicationsSizeIsOne() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();
    applications.add(new ImmutableApplication.Json());

    ImmutableApplicationsView.Json json = new ImmutableApplicationsView.Json();
    json.setApplications(applications);
    json.setPrimaryAssessments(new ImmutableAssessmentsView.Json());
    json.setPrimaryRatings(new Json());

    // Act
    ImmutableApplicationsView actualFromJsonResult = ImmutableApplicationsView.fromJson(json);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualFromJsonResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView.Json);
    MeasurableRatingsView primaryRatingsResult = actualFromJsonResult.primaryRatings();
    assertTrue(primaryRatingsResult instanceof Json);
    assertEquals(1, actualFromJsonResult.applications().size());
    Set<AssessmentDefinition> assessmentDefinitionSet =
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentDefinitions;
    assertTrue(assessmentDefinitionSet.isEmpty());
    assertSame(
        assessmentDefinitionSet,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentRatings);
    assertSame(
        assessmentDefinitionSet,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).ratingSchemeItems);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurableCategories);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurableHierarchy);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurableRatings);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurables);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).ratingSchemeItems);
  }

  /**
   * Test {@link ImmutableApplicationsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ImmutableApplicationsView.Json} (default constructor) Applications is {@code
   *       null}.
   *   <li>Then return applications Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationsView#fromJson(ImmutableApplicationsView.Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Applications is 'null'; then return applications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationsView ImmutableApplicationsView.fromJson(ImmutableApplicationsView.Json)"
  })
  void testFromJson_givenNull_whenJsonApplicationsIsNull_thenReturnApplicationsEmpty() {
    // Arrange
    ImmutableApplicationsView.Json json = new ImmutableApplicationsView.Json();
    json.setApplications(null);
    json.setPrimaryAssessments(new ImmutableAssessmentsView.Json());
    Json primaryRatings = new Json();
    json.setPrimaryRatings(primaryRatings);

    // Act
    ImmutableApplicationsView actualFromJsonResult = ImmutableApplicationsView.fromJson(json);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualFromJsonResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView.Json);
    MeasurableRatingsView primaryRatingsResult = actualFromJsonResult.primaryRatings();
    assertTrue(primaryRatingsResult instanceof Json);
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(
        applicationsResult,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentRatings);
    assertSame(
        applicationsResult,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).ratingSchemeItems);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurableCategories);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurableHierarchy);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurableRatings);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurables);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).ratingSchemeItems);
    assertSame(
        primaryRatings.ratingSchemeItems,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentDefinitions);
  }

  /**
   * Test {@link ImmutableApplicationsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return applications is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationsView#fromJson(ImmutableApplicationsView.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return applications is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationsView ImmutableApplicationsView.fromJson(ImmutableApplicationsView.Json)"
  })
  void testFromJson_thenReturnApplicationsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applications.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    applications.add(new ImmutableApplication.Json());

    ImmutableApplicationsView.Json json = new ImmutableApplicationsView.Json();
    json.setApplications(applications);
    json.setPrimaryAssessments(new ImmutableAssessmentsView.Json());
    json.setPrimaryRatings(new Json());

    // Act
    ImmutableApplicationsView actualFromJsonResult = ImmutableApplicationsView.fromJson(json);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualFromJsonResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView.Json);
    MeasurableRatingsView primaryRatingsResult = actualFromJsonResult.primaryRatings();
    assertTrue(primaryRatingsResult instanceof Json);
    Set<AssessmentDefinition> assessmentDefinitionSet =
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentDefinitions;
    assertTrue(assessmentDefinitionSet.isEmpty());
    assertEquals(applications, actualFromJsonResult.applications());
    assertSame(
        assessmentDefinitionSet,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentRatings);
    assertSame(
        assessmentDefinitionSet,
        ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).ratingSchemeItems);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurableCategories);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurableHierarchy);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurableRatings);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurables);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).ratingSchemeItems);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationsView#toString()}
   *   <li>{@link ImmutableApplicationsView#applications()}
   *   <li>{@link ImmutableApplicationsView#primaryAssessments()}
   *   <li>{@link ImmutableApplicationsView#primaryRatings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableApplicationsView.applications()",
    "AssessmentsView ImmutableApplicationsView.primaryAssessments()",
    "MeasurableRatingsView ImmutableApplicationsView.primaryRatings()",
    "String ImmutableApplicationsView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableApplicationsView immutableApplicationsView =
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    String actualToStringResult = immutableApplicationsView.toString();
    Set<Application> actualApplicationsResult = immutableApplicationsView.applications();
    AssessmentsView actualPrimaryAssessmentsResult = immutableApplicationsView.primaryAssessments();

    // Assert
    assertTrue(actualPrimaryAssessmentsResult instanceof ImmutableAssessmentsView);
    assertTrue(
        immutableApplicationsView.primaryRatings() instanceof ImmutableMeasurableRatingsView);
    assertEquals(
        "ApplicationsView{applications=[], primaryAssessments=AssessmentsView{assessmentRatings=[], ratingSchemeItems"
            + "=[], assessmentDefinitions=[], ratingSchemeItemsById={}}, primaryRatings=MeasurableRatingsView"
            + "{measurableCategories=[], measurables=[], measurableRatings=[], ratingSchemeItems=[], measurableHierarchy"
            + "=[]}}",
        actualToStringResult);
    assertTrue(actualApplicationsResult.isEmpty());
  }

  /**
   * Test Json {@link ImmutableApplicationsView.Json#applications()}.
   *
   * <p>Method under test: {@link ImmutableApplicationsView.Json#applications()}
   */
  @Test
  @DisplayName("Test Json applications()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ImmutableApplicationsView.Json.applications()"})
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new ImmutableApplicationsView.Json().applications());
  }

  /**
   * Test Json new {@link ImmutableApplicationsView.Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ImmutableApplicationsView.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImmutableApplicationsView.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableApplicationsView.Json actualJson = new ImmutableApplicationsView.Json();

    // Assert
    assertNull(actualJson.primaryAssessments);
    assertNull(actualJson.primaryRatings);
    assertTrue(actualJson.applications.isEmpty());
  }

  /**
   * Test Json {@link ImmutableApplicationsView.Json#primaryAssessments()}.
   *
   * <p>Method under test: {@link ImmutableApplicationsView.Json#primaryAssessments()}
   */
  @Test
  @DisplayName("Test Json primaryAssessments()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentsView ImmutableApplicationsView.Json.primaryAssessments()"})
  void testJsonPrimaryAssessments() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new ImmutableApplicationsView.Json().primaryAssessments());
  }

  /**
   * Test Json {@link ImmutableApplicationsView.Json#primaryRatings()}.
   *
   * <p>Method under test: {@link ImmutableApplicationsView.Json#primaryRatings()}
   */
  @Test
  @DisplayName("Test Json primaryRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingsView ImmutableApplicationsView.Json.primaryRatings()"})
  void testJsonPrimaryRatings() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new ImmutableApplicationsView.Json().primaryRatings());
  }

  /**
   * Test {@link ImmutableApplicationsView#withApplications(Application[])} with {@code
   * Application[]}.
   *
   * <p>Method under test: {@link ImmutableApplicationsView#withApplications(Application[])}
   */
  @Test
  @DisplayName("Test withApplications(Application[]) with 'Application[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationsView ImmutableApplicationsView.withApplications(Application[])"
  })
  void testWithApplicationsWithApplication() {
    // Arrange
    ImmutableApplicationsView immutableApplicationsView =
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableApplicationsView actualWithApplicationsResult =
        immutableApplicationsView.withApplications(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    AssessmentsView primaryAssessmentsResult = actualWithApplicationsResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = actualWithApplicationsResult.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, actualWithApplicationsResult.applications().size());
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        primaryAssessmentsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableCategories());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableHierarchy());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableRatings());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurables());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableApplicationsView#withPrimaryAssessments(AssessmentsView)}.
   *
   * <p>Method under test: {@link ImmutableApplicationsView#withPrimaryAssessments(AssessmentsView)}
   */
  @Test
  @DisplayName("Test withPrimaryAssessments(AssessmentsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationsView ImmutableApplicationsView.withPrimaryAssessments(AssessmentsView)"
  })
  void testWithPrimaryAssessments() {
    // Arrange
    ImmutableApplicationsView immutableApplicationsView =
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    ImmutableApplicationsView actualWithPrimaryAssessmentsResult =
        immutableApplicationsView.withPrimaryAssessments(
            ImmutableAssessmentsView.builder().build());

    // Assert
    assertEquals(immutableApplicationsView, actualWithPrimaryAssessmentsResult);
  }

  /**
   * Test {@link ImmutableApplicationsView#withPrimaryRatings(MeasurableRatingsView)}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationsView#withPrimaryRatings(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test withPrimaryRatings(MeasurableRatingsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationsView ImmutableApplicationsView.withPrimaryRatings(MeasurableRatingsView)"
  })
  void testWithPrimaryRatings() {
    // Arrange
    ImmutableApplicationsView immutableApplicationsView =
        ImmutableApplicationsView.builder()
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .primaryRatings(ImmutableMeasurableRatingsView.builder().build())
            .build();

    // Act
    ImmutableApplicationsView actualWithPrimaryRatingsResult =
        immutableApplicationsView.withPrimaryRatings(
            ImmutableMeasurableRatingsView.builder().build());

    // Assert
    assertEquals(immutableApplicationsView, actualWithPrimaryRatingsResult);
  }
}
