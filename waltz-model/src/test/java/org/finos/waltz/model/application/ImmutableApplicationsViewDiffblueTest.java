package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableApplicationsViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplicationsView.Builder#addAllApplications(Iterable)}
   */
  @Test
  void testBuilderAddAllApplications() {
    // Arrange
    ImmutableApplicationsView.Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView.Builder#addApplications(Application)}
   */
  @Test
  void testBuilderAddApplications() {
    // Arrange
    ImmutableApplicationsView.Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplications(new ImmutableApplication.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView.Builder#addApplications(Application[])}
   */
  @Test
  void testBuilderAddApplications2() {
    // Arrange
    ImmutableApplicationsView.Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplications(new ImmutableApplication.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView.Builder#applications(Iterable)}
   */
  @Test
  void testBuilderApplications() {
    // Arrange
    ImmutableApplicationsView.Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView.Builder#from(ApplicationsView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationsView.Builder builderResult = ImmutableApplicationsView.builder();
    ApplicationsView instance = mock(ApplicationsView.class);
    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();
    when(instance.primaryRatings()).thenReturn(json);
    when(instance.applications()).thenReturn(new HashSet<>());
    ImmutableAssessmentsView.Json json2 = new ImmutableAssessmentsView.Json();
    when(instance.primaryAssessments()).thenReturn(json2);

    // Act
    ImmutableApplicationsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applications();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
    ImmutableApplicationsView buildResult = builderResult.build();
    assertSame(json2, buildResult.primaryAssessments());
    assertSame(json, buildResult.primaryRatings());
    assertSame(builderResult, actualFromResult);
    Set<RatingSchemeItem> expectedApplicationsResult = json2.ratingSchemeItems;
    assertSame(expectedApplicationsResult, buildResult.applications());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView.Builder#from(ApplicationsView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationsView.Builder builderResult = ImmutableApplicationsView.builder();
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
   * Method under test:
   * {@link ImmutableApplicationsView.Builder#from(ApplicationsView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableApplicationsView.Builder builderResult = ImmutableApplicationsView.builder();

    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(new ImmutableApplication.Json());
    ApplicationsView instance = mock(ApplicationsView.class);
    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();
    when(instance.primaryRatings()).thenReturn(json);
    when(instance.applications()).thenReturn(applicationSet);
    ImmutableAssessmentsView.Json json2 = new ImmutableAssessmentsView.Json();
    when(instance.primaryAssessments()).thenReturn(json2);

    // Act
    ImmutableApplicationsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applications();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
    ImmutableApplicationsView buildResult = builderResult.build();
    assertEquals(1, buildResult.applications().size());
    assertSame(json2, buildResult.primaryAssessments());
    assertSame(json, buildResult.primaryRatings());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView.Builder#primaryAssessments(AssessmentsView)}
   */
  @Test
  void testBuilderPrimaryAssessments() {
    // Arrange
    ImmutableApplicationsView.Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryAssessments(new ImmutableAssessmentsView.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView.Builder#primaryRatings(MeasurableRatingsView)}
   */
  @Test
  void testBuilderPrimaryRatings() {
    // Arrange
    ImmutableApplicationsView.Builder builderResult = ImmutableApplicationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryRatings(new ImmutableMeasurableRatingsView.Json()));
  }

  /**
   * Method under test: {@link ImmutableApplicationsView#copyOf(ApplicationsView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationsView instance = mock(ApplicationsView.class);
    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();
    when(instance.primaryRatings()).thenReturn(json);
    when(instance.applications()).thenReturn(new HashSet<>());
    ImmutableAssessmentsView.Json json2 = new ImmutableAssessmentsView.Json();
    when(instance.primaryAssessments()).thenReturn(json2);

    // Act
    ImmutableApplicationsView actualCopyOfResult = ImmutableApplicationsView.copyOf(instance);

    // Assert
    verify(instance).applications();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(json2, actualCopyOfResult.primaryAssessments());
    assertSame(json, actualCopyOfResult.primaryRatings());
    assertSame(json2.ratingSchemeItems, applicationsResult);
  }

  /**
   * Method under test: {@link ImmutableApplicationsView#copyOf(ApplicationsView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(new ImmutableApplication.Json());
    ApplicationsView instance = mock(ApplicationsView.class);
    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();
    when(instance.primaryRatings()).thenReturn(json);
    when(instance.applications()).thenReturn(applicationSet);
    ImmutableAssessmentsView.Json json2 = new ImmutableAssessmentsView.Json();
    when(instance.primaryAssessments()).thenReturn(json2);

    // Act
    ImmutableApplicationsView actualCopyOfResult = ImmutableApplicationsView.copyOf(instance);

    // Assert
    verify(instance).applications();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
    assertEquals(1, actualCopyOfResult.applications().size());
    assertSame(json2, actualCopyOfResult.primaryAssessments());
    assertSame(json, actualCopyOfResult.primaryRatings());
  }

  /**
   * Method under test: {@link ImmutableApplicationsView#copyOf(ApplicationsView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Application> applicationSet = new HashSet<>();
    applicationSet.add(new ImmutableApplication.Json());
    applicationSet.add(new ImmutableApplication.Json());
    ApplicationsView instance = mock(ApplicationsView.class);
    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();
    when(instance.primaryRatings()).thenReturn(json);
    when(instance.applications()).thenReturn(applicationSet);
    ImmutableAssessmentsView.Json json2 = new ImmutableAssessmentsView.Json();
    when(instance.primaryAssessments()).thenReturn(json2);

    // Act
    ImmutableApplicationsView actualCopyOfResult = ImmutableApplicationsView.copyOf(instance);

    // Assert
    verify(instance).applications();
    verify(instance).primaryAssessments();
    verify(instance).primaryRatings();
    assertEquals(applicationSet, actualCopyOfResult.applications());
    assertSame(json2, actualCopyOfResult.primaryAssessments());
    assertSame(json, actualCopyOfResult.primaryRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView#fromJson(ImmutableApplicationsView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationsView.Json json = new ImmutableApplicationsView.Json();
    json.setApplications(null);
    ImmutableAssessmentsView.Json primaryAssessments = new ImmutableAssessmentsView.Json();
    json.setPrimaryAssessments(primaryAssessments);
    ImmutableMeasurableRatingsView.Json primaryRatings = new ImmutableMeasurableRatingsView.Json();
    json.setPrimaryRatings(primaryRatings);

    // Act
    ImmutableApplicationsView actualFromJsonResult = ImmutableApplicationsView.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(primaryAssessments, actualFromJsonResult.primaryAssessments());
    assertSame(primaryRatings, actualFromJsonResult.primaryRatings());
    assertSame(primaryRatings.ratingSchemeItems, applicationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView#fromJson(ImmutableApplicationsView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();
    applications.add(new ImmutableApplication.Json());

    ImmutableApplicationsView.Json json = new ImmutableApplicationsView.Json();
    json.setApplications(applications);
    ImmutableAssessmentsView.Json primaryAssessments = new ImmutableAssessmentsView.Json();
    json.setPrimaryAssessments(primaryAssessments);
    ImmutableMeasurableRatingsView.Json primaryRatings = new ImmutableMeasurableRatingsView.Json();
    json.setPrimaryRatings(primaryRatings);

    // Act
    ImmutableApplicationsView actualFromJsonResult = ImmutableApplicationsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applications().size());
    assertSame(primaryAssessments, actualFromJsonResult.primaryAssessments());
    assertSame(primaryRatings, actualFromJsonResult.primaryRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView#fromJson(ImmutableApplicationsView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();
    applications.add(new ImmutableApplication.Json());
    applications.add(new ImmutableApplication.Json());

    ImmutableApplicationsView.Json json = new ImmutableApplicationsView.Json();
    json.setApplications(applications);
    ImmutableAssessmentsView.Json primaryAssessments = new ImmutableAssessmentsView.Json();
    json.setPrimaryAssessments(primaryAssessments);
    ImmutableMeasurableRatingsView.Json primaryRatings = new ImmutableMeasurableRatingsView.Json();
    json.setPrimaryRatings(primaryRatings);

    // Act
    ImmutableApplicationsView actualFromJsonResult = ImmutableApplicationsView.fromJson(json);

    // Assert
    assertEquals(applications, actualFromJsonResult.applications());
    assertSame(primaryAssessments, actualFromJsonResult.primaryAssessments());
    assertSame(primaryRatings, actualFromJsonResult.primaryRatings());
  }

  /**
   * Method under test: {@link ImmutableApplicationsView.Json#applications()}
   */
  @Test
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationsView.Json()).applications());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableApplicationsView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableApplicationsView.Json actualJson = new ImmutableApplicationsView.Json();

    // Assert
    assertNull(actualJson.primaryAssessments);
    assertNull(actualJson.primaryRatings);
    assertTrue(actualJson.applications.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationsView.Json#primaryAssessments()}
   */
  @Test
  void testJsonPrimaryAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationsView.Json()).primaryAssessments());
  }

  /**
   * Method under test: {@link ImmutableApplicationsView.Json#primaryRatings()}
   */
  @Test
  void testJsonPrimaryRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationsView.Json()).primaryRatings());
  }
}
