package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentsViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#addAllAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentDefinitions() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#addAllAssessmentRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentRatings() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingSchemeItems() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    ImmutableAssessmentsView.Builder actualAddAllRatingSchemeItemsResult = builderResult
        .addAllRatingSchemeItems(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().ratingSchemeItemsById().isEmpty());
    assertSame(builderResult, actualAddAllRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#addAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  void testBuilderAddAssessmentDefinitions() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    ImmutableAssessmentsView.Builder actualAddAssessmentDefinitionsResult = builderResult
        .addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#addAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  void testBuilderAddAssessmentDefinitions2() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    ImmutableAssessmentsView.Builder actualAddAssessmentDefinitionsResult = builderResult
        .addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#addAssessmentRatings(AssessmentRating)}
   */
  @Test
  void testBuilderAddAssessmentRatings() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    ImmutableAssessmentsView.Builder actualAddAssessmentRatingsResult = builderResult
        .addAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#addAssessmentRatings(AssessmentRating[])}
   */
  @Test
  void testBuilderAddAssessmentRatings2() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    ImmutableAssessmentsView.Builder actualAddAssessmentRatingsResult = builderResult
        .addAssessmentRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  void testBuilderAddRatingSchemeItems() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();
    RatingSchemeItem element = mock(RatingSchemeItem.class);

    // Act
    ImmutableAssessmentsView.Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(element);

    // Assert
    ImmutableAssessmentsView buildResult = builderResult.build();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = buildResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, buildResult.ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
    assertSame(element, ratingSchemeItemsByIdResult.get(null));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  void testBuilderAddRatingSchemeItems2() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    ImmutableAssessmentsView.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    ImmutableAssessmentsView buildResult = builderResult.build();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = buildResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, buildResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(null));
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#assessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderAssessmentDefinitions() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#assessmentRatings(Iterable)}
   */
  @Test
  void testBuilderAssessmentRatings() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentRatings(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableAssessmentsView.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentsView actualBuildResult = ImmutableAssessmentsView.builder().build();

    // Assert
    assertTrue(actualBuildResult.ratingSchemeItemsById().isEmpty());
    assertTrue(actualBuildResult.assessmentDefinitions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#from(AssessmentsView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    assertTrue(builderResult.build().ratingSchemeItemsById().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#from(AssessmentsView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    ImmutableAssessmentsView buildResult = builderResult.build();
    assertEquals(1, buildResult.assessmentDefinitions().size());
    assertTrue(buildResult.ratingSchemeItemsById().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#from(AssessmentsView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.assessmentRatings()).thenReturn(assessmentRatingSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    ImmutableAssessmentsView buildResult = builderResult.build();
    assertEquals(1, buildResult.assessmentRatings().size());
    assertTrue(buildResult.ratingSchemeItemsById().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#from(AssessmentsView)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);

    // Act
    ImmutableAssessmentsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    ImmutableAssessmentsView buildResult = builderResult.build();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = buildResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, buildResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(null));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderRatingSchemeItems() {
    // Arrange
    ImmutableAssessmentsView.Builder builderResult = ImmutableAssessmentsView.builder();

    // Act
    ImmutableAssessmentsView.Builder actualRatingSchemeItemsResult = builderResult.ratingSchemeItems(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().ratingSchemeItemsById().isEmpty());
    assertSame(builderResult, actualRatingSchemeItemsResult);
  }

  /**
   * Method under test: {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentsView actualCopyOfResult = ImmutableAssessmentsView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    assertTrue(actualCopyOfResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentsView actualCopyOfResult = ImmutableAssessmentsView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.assessmentDefinitions().size());
    assertTrue(actualCopyOfResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentsView actualCopyOfResult = ImmutableAssessmentsView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    assertTrue(actualCopyOfResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertEquals(assessmentDefinitionSet, actualCopyOfResult.assessmentDefinitions());
    assertSame(assessmentRatingsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.assessmentRatings()).thenReturn(assessmentRatingSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentsView actualCopyOfResult = ImmutableAssessmentsView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.assessmentRatings().size());
    assertTrue(actualCopyOfResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(ratingSchemeItem);
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);

    // Act
    ImmutableAssessmentsView actualCopyOfResult = ImmutableAssessmentsView.copyOf(instance);

    // Assert
    verify(ratingSchemeItem).id();
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = actualCopyOfResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, actualCopyOfResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.assessmentRatings());
  }

  /**
   * Method under test: {@link ImmutableAssessmentsView#copyOf(AssessmentsView)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);
    RatingSchemeItem ratingSchemeItem2 = mock(RatingSchemeItem.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(ratingSchemeItem2.id()).thenReturn(ofResult2);

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(ratingSchemeItem2);
    ratingSchemeItemSet.add(ratingSchemeItem);
    AssessmentsView instance = mock(AssessmentsView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);

    // Act
    ImmutableAssessmentsView actualCopyOfResult = ImmutableAssessmentsView.copyOf(instance);

    // Assert
    verify(ratingSchemeItem2).id();
    verify(ratingSchemeItem).id();
    verify(instance).assessmentDefinitions();
    verify(instance).assessmentRatings();
    verify(instance).ratingSchemeItems();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = actualCopyOfResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertEquals(ratingSchemeItemSet, actualCopyOfResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.assessmentRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView#fromJson(ImmutableAssessmentsView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentsView.Json json = new ImmutableAssessmentsView.Json();

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, assessmentDefinitionsResult);
    assertSame(ratingSchemeItemSet, actualFromJsonResult.assessmentRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView#fromJson(ImmutableAssessmentsView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAssessmentsView.Json json = new ImmutableAssessmentsView.Json();
    json.setAssessmentRatings(null);
    json.setRatingSchemeItems(null);
    json.setAssessmentDefinitions(null);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView#fromJson(ImmutableAssessmentsView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AssessmentDefinition> assessmentDefinitions = new LinkedHashSet<>();
    assessmentDefinitions.add(mock(AssessmentDefinition.class));

    ImmutableAssessmentsView.Json json = new ImmutableAssessmentsView.Json();
    json.setAssessmentRatings(null);
    json.setRatingSchemeItems(null);
    json.setAssessmentDefinitions(assessmentDefinitions);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentDefinitions().size());
    assertTrue(actualFromJsonResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentRating> assessmentRatingsResult = actualFromJsonResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView#fromJson(ImmutableAssessmentsView.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<AssessmentRating> assessmentRatings = new LinkedHashSet<>();
    assessmentRatings.add(mock(AssessmentRating.class));

    ImmutableAssessmentsView.Json json = new ImmutableAssessmentsView.Json();
    json.setAssessmentRatings(assessmentRatings);
    json.setRatingSchemeItems(null);
    json.setAssessmentDefinitions(null);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentRatings().size());
    assertTrue(actualFromJsonResult.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView#fromJson(ImmutableAssessmentsView.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(ratingSchemeItem);

    ImmutableAssessmentsView.Json json = new ImmutableAssessmentsView.Json();
    json.setAssessmentRatings(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setAssessmentDefinitions(null);

    // Act
    ImmutableAssessmentsView actualFromJsonResult = ImmutableAssessmentsView.fromJson(json);

    // Assert
    verify(ratingSchemeItem).id();
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult = actualFromJsonResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertTrue(ratingSchemeItemsByIdResult.containsKey(1L));
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.assessmentRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Json#assessmentDefinitions()}
   */
  @Test
  void testJsonAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentsView.Json()).assessmentDefinitions());
  }

  /**
   * Method under test: {@link ImmutableAssessmentsView.Json#assessmentRatings()}
   */
  @Test
  void testJsonAssessmentRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentsView.Json()).assessmentRatings());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentsView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentsView.Json actualJson = new ImmutableAssessmentsView.Json();

    // Assert
    assertTrue(actualJson.assessmentDefinitions.isEmpty());
    assertTrue(actualJson.assessmentRatings.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableAssessmentsView.Json#ratingSchemeItems()}
   */
  @Test
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentsView.Json()).ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentsView.Json#ratingSchemeItemsById()}
   */
  @Test
  void testJsonRatingSchemeItemsById() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentsView.Json()).ratingSchemeItemsById());
  }
}
