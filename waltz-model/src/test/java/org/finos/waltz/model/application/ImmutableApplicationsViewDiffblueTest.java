package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.application.ImmutableApplicationsView.Builder;
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView.Json;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplications(Iterable)"})
  void testBuilderAddAllApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addApplications(Application)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableApplication.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addApplications(Application)}
   */
  @Test
  @DisplayName("Test Builder addApplications(Application) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplications(Application)"})
  void testBuilderAddApplicationsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplications(new ImmutableApplication.Json()));
  }

  /**
   * Test Builder {@link Builder#addApplications(Application[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableApplication.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addApplications(Application[])}
   */
  @Test
  @DisplayName("Test Builder addApplications(Application[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplications(Application[])"})
  void testBuilderAddApplicationsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplications(new ImmutableApplication.Json()));
  }

  /**
   * Test Builder {@link Builder#applications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applications(Iterable)"})
  void testBuilderApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationsView)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableApplication.Json} (default constructor).</li>
   *   <li>Then return build applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationsView)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationsView); given HashSet() add Json (default constructor); then return build applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationsView)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildApplicationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(new ImmutableApplication.Json());
    ApplicationsView instance = mock(ApplicationsView.class);
    when(instance.primaryRatings()).thenReturn(new Json());
    when(instance.applications()).thenReturn(applicationSet);
    when(instance.primaryAssessments()).thenReturn(new ImmutableAssessmentsView.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applications();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
    ImmutableApplicationsView buildResult = actualFromResult.build();
    AssessmentsView primaryAssessmentsResult = buildResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView.Json);
    MeasurableRatingsView primaryRatingsResult = buildResult.primaryRatings();
    assertTrue(primaryRatingsResult instanceof Json);
    assertEquals(1, buildResult.applications().size());
    assertEquals(1, builderResult.build().applications().size());
    Set<AssessmentDefinition> assessmentDefinitionSet = ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentDefinitions;
    assertTrue(assessmentDefinitionSet.isEmpty());
    assertSame(assessmentDefinitionSet, ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentRatings);
    assertSame(assessmentDefinitionSet, ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).ratingSchemeItems);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurableCategories);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurableHierarchy);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurableRatings);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).measurables);
    assertSame(assessmentDefinitionSet, ((Json) primaryRatingsResult).ratingSchemeItems);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationsView)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>Then return build applications Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationsView)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationsView); given Json (default constructor); then return build applications Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationsView)"})
  void testBuilderFrom_givenJson_thenReturnBuildApplicationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();
    ApplicationsView instance = mock(ApplicationsView.class);
    when(instance.primaryRatings()).thenReturn(new Json());
    when(instance.applications()).thenReturn(new HashSet<>());
    ImmutableAssessmentsView.Json json = new ImmutableAssessmentsView.Json();
    when(instance.primaryAssessments()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applications();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
    ImmutableApplicationsView buildResult = actualFromResult.build();
    AssessmentsView primaryAssessmentsResult = buildResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView.Json);
    MeasurableRatingsView primaryRatingsResult = buildResult.primaryRatings();
    assertTrue(primaryRatingsResult instanceof Json);
    Set<Application> applicationsResult = buildResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentRatings);
    assertSame(applicationsResult, ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).ratingSchemeItems);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurableCategories);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurableHierarchy);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurableRatings);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).measurables);
    assertSame(applicationsResult, ((Json) primaryRatingsResult).ratingSchemeItems);
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, builderResult.build().applications());
    assertSame(ratingSchemeItemSet, ((ImmutableAssessmentsView.Json) primaryAssessmentsResult).assessmentDefinitions);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationsView)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationsView)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationsView); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationsView)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();
    ApplicationsView instance = mock(ApplicationsView.class);
    when(instance.primaryRatings()).thenThrow(new IllegalStateException("instance"));
    when(instance.applications()).thenReturn(new HashSet<>());
    when(instance.primaryAssessments()).thenReturn(new ImmutableAssessmentsView.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applications();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
  }

  /**
   * Test Builder {@link Builder#primaryAssessments(AssessmentsView)}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentsView.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#primaryAssessments(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder primaryAssessments(AssessmentsView); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.primaryAssessments(AssessmentsView)"})
  void testBuilderPrimaryAssessments_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryAssessments(new ImmutableAssessmentsView.Json()));
  }

  /**
   * Test Builder {@link Builder#primaryRatings(MeasurableRatingsView)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#primaryRatings(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder primaryRatings(MeasurableRatingsView); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.primaryRatings(MeasurableRatingsView)"})
  void testBuilderPrimaryRatings_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryRatings(new Json()));
  }

  /**
   * Test Json {@link ImmutableApplicationsView.Json#applications()}.
   * <p>
   * Method under test: {@link ImmutableApplicationsView.Json#applications()}
   */
  @Test
  @DisplayName("Test Json applications()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableApplicationsView.Json.applications()"})
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationsView.Json()).applications());
  }

  /**
   * Test Json new {@link ImmutableApplicationsView.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableApplicationsView.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link ImmutableApplicationsView.Json#primaryAssessments()}
   */
  @Test
  @DisplayName("Test Json primaryAssessments()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentsView ImmutableApplicationsView.Json.primaryAssessments()"})
  void testJsonPrimaryAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationsView.Json()).primaryAssessments());
  }

  /**
   * Test Json {@link ImmutableApplicationsView.Json#primaryRatings()}.
   * <p>
   * Method under test: {@link ImmutableApplicationsView.Json#primaryRatings()}
   */
  @Test
  @DisplayName("Test Json primaryRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableRatingsView ImmutableApplicationsView.Json.primaryRatings()"})
  void testJsonPrimaryRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationsView.Json()).primaryRatings());
  }
}
