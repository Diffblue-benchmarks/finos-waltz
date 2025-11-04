package org.finos.waltz.model.change_initiative;

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
import java.util.Set;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableChangeInitiativeViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addAllAssessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentDefinitions() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addAllChangeInitiatives(Iterable)}
   */
  @Test
  void testBuilderAddAllChangeInitiatives() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangeInitiatives(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addAllChangeInitiatives(Iterable)}
   */
  @Test
  void testBuilderAddAllChangeInitiatives2() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();
    builderResult.addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangeInitiatives(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingSchemeItems() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addAllRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllRatings() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  void testBuilderAddAssessmentDefinitions() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    ImmutableChangeInitiativeView.Builder actualAddAssessmentDefinitionsResult = builderResult
        .addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  void testBuilderAddAssessmentDefinitions2() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    ImmutableChangeInitiativeView.Builder actualAddAssessmentDefinitionsResult = builderResult
        .addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualAddAssessmentDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addChangeInitiatives(ChangeInitiative)}
   */
  @Test
  void testBuilderAddChangeInitiatives() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    ImmutableChangeInitiativeView.Builder actualAddChangeInitiativesResult = builderResult
        .addChangeInitiatives(new ImmutableChangeInitiative.Json());

    // Assert
    assertEquals(1, builderResult.build().changeInitiatives().size());
    assertSame(builderResult, actualAddChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addChangeInitiatives(ChangeInitiative)}
   */
  @Test
  void testBuilderAddChangeInitiatives2() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();
    builderResult.addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Act
    ImmutableChangeInitiativeView.Builder actualAddChangeInitiativesResult = builderResult
        .addChangeInitiatives(new ImmutableChangeInitiative.Json());

    // Assert
    assertEquals(1, builderResult.build().changeInitiatives().size());
    assertSame(builderResult, actualAddChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addChangeInitiatives(ChangeInitiative[])}
   */
  @Test
  void testBuilderAddChangeInitiatives3() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    ImmutableChangeInitiativeView.Builder actualAddChangeInitiativesResult = builderResult
        .addChangeInitiatives(new ImmutableChangeInitiative.Json());

    // Assert
    assertEquals(1, builderResult.build().changeInitiatives().size());
    assertSame(builderResult, actualAddChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addChangeInitiatives(ChangeInitiative[])}
   */
  @Test
  void testBuilderAddChangeInitiatives4() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();
    builderResult.addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Act
    ImmutableChangeInitiativeView.Builder actualAddChangeInitiativesResult = builderResult
        .addChangeInitiatives(new ImmutableChangeInitiative.Json());

    // Assert
    assertEquals(1, builderResult.build().changeInitiatives().size());
    assertSame(builderResult, actualAddChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  void testBuilderAddRatingSchemeItems() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    ImmutableChangeInitiativeView.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  void testBuilderAddRatingSchemeItems2() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    ImmutableChangeInitiativeView.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addRatings(AssessmentRating)}
   */
  @Test
  void testBuilderAddRatings() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    ImmutableChangeInitiativeView.Builder actualAddRatingsResult = builderResult
        .addRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().ratings().size());
    assertSame(builderResult, actualAddRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#addRatings(AssessmentRating[])}
   */
  @Test
  void testBuilderAddRatings2() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act
    ImmutableChangeInitiativeView.Builder actualAddRatingsResult = builderResult
        .addRatings(mock(AssessmentRating.class));

    // Assert
    assertEquals(1, builderResult.build().ratings().size());
    assertSame(builderResult, actualAddRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#assessmentDefinitions(Iterable)}
   */
  @Test
  void testBuilderAssessmentDefinitions() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiativeView.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableChangeInitiativeView.builder().build().assessmentDefinitions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#changeInitiatives(Iterable)}
   */
  @Test
  void testBuilderChangeInitiatives() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiatives(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#changeInitiatives(Iterable)}
   */
  @Test
  void testBuilderChangeInitiatives2() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();
    builderResult.addAssessmentDefinitions(mock(AssessmentDefinition.class));

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiatives(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#from(ChangeInitiativeView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.changeInitiatives()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());

    // Act
    ImmutableChangeInitiativeView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#from(ChangeInitiativeView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.changeInitiatives()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());

    // Act
    ImmutableChangeInitiativeView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    assertEquals(1, builderResult.build().assessmentDefinitions().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#from(ChangeInitiativeView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    HashSet<ChangeInitiative> changeInitiativeSet = new HashSet<>();
    changeInitiativeSet.add(new ImmutableChangeInitiative.Json());
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.changeInitiatives()).thenReturn(changeInitiativeSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());

    // Act
    ImmutableChangeInitiativeView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    assertEquals(1, builderResult.build().changeInitiatives().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#from(ChangeInitiativeView)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.changeInitiatives()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);
    when(instance.ratings()).thenReturn(new HashSet<>());

    // Act
    ImmutableChangeInitiativeView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#from(ChangeInitiativeView)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.changeInitiatives()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(assessmentRatingSet);

    // Act
    ImmutableChangeInitiativeView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    assertEquals(1, builderResult.build().ratings().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderRatingSchemeItems() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Builder#ratings(Iterable)}
   */
  @Test
  void testBuilderRatings() {
    // Arrange
    ImmutableChangeInitiativeView.Builder builderResult = ImmutableChangeInitiativeView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.changeInitiatives()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());

    // Act
    ImmutableChangeInitiativeView actualCopyOfResult = ImmutableChangeInitiativeView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.changeInitiatives()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());

    // Act
    ImmutableChangeInitiativeView actualCopyOfResult = ImmutableChangeInitiativeView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    assertEquals(1, actualCopyOfResult.assessmentDefinitions().size());
    Set<ChangeInitiative> changeInitiativesResult = actualCopyOfResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualCopyOfResult.ratingSchemeItems());
    assertSame(changeInitiativesResult, actualCopyOfResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    assessmentDefinitionSet.add(mock(AssessmentDefinition.class));
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(assessmentDefinitionSet);
    when(instance.changeInitiatives()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());

    // Act
    ImmutableChangeInitiativeView actualCopyOfResult = ImmutableChangeInitiativeView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    Set<ChangeInitiative> changeInitiativesResult = actualCopyOfResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertEquals(assessmentDefinitionSet, actualCopyOfResult.assessmentDefinitions());
    assertSame(changeInitiativesResult, actualCopyOfResult.ratingSchemeItems());
    assertSame(changeInitiativesResult, actualCopyOfResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<ChangeInitiative> changeInitiativeSet = new HashSet<>();
    changeInitiativeSet.add(new ImmutableChangeInitiative.Json());
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.changeInitiatives()).thenReturn(changeInitiativeSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());

    // Act
    ImmutableChangeInitiativeView actualCopyOfResult = ImmutableChangeInitiativeView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    assertEquals(1, actualCopyOfResult.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.changeInitiatives()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);
    when(instance.ratings()).thenReturn(new HashSet<>());

    // Act
    ImmutableChangeInitiativeView actualCopyOfResult = ImmutableChangeInitiativeView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    assertEquals(1, actualCopyOfResult.ratingSchemeItems().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#copyOf(ChangeInitiativeView)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();
    assessmentRatingSet.add(mock(AssessmentRating.class));
    ChangeInitiativeView instance = mock(ChangeInitiativeView.class);
    when(instance.assessmentDefinitions()).thenReturn(new HashSet<>());
    when(instance.changeInitiatives()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(assessmentRatingSet);

    // Act
    ImmutableChangeInitiativeView actualCopyOfResult = ImmutableChangeInitiativeView.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitions();
    verify(instance).changeInitiatives();
    verify(instance).ratingSchemeItems();
    verify(instance).ratings();
    assertEquals(1, actualCopyOfResult.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualCopyOfResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#fromJson(ImmutableChangeInitiativeView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableChangeInitiativeView.Json json = new ImmutableChangeInitiativeView.Json();

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    Set<AssessmentRating> assessmentRatingSet = json.ratings;
    assertSame(assessmentRatingSet, assessmentDefinitionsResult);
    assertSame(assessmentRatingSet, actualFromJsonResult.changeInitiatives());
    assertSame(assessmentRatingSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(assessmentRatingSet, actualFromJsonResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#fromJson(ImmutableChangeInitiativeView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableChangeInitiativeView.Json json = new ImmutableChangeInitiativeView.Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setRatings(null);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#fromJson(ImmutableChangeInitiativeView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AssessmentRating> ratings = new LinkedHashSet<>();
    ratings.add(mock(AssessmentRating.class));

    ImmutableChangeInitiativeView.Json json = new ImmutableChangeInitiativeView.Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(null);
    json.setRatingSchemeItems(null);
    json.setRatings(ratings);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#fromJson(ImmutableChangeInitiativeView.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(mock(RatingSchemeItem.class));

    ImmutableChangeInitiativeView.Json json = new ImmutableChangeInitiativeView.Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setRatings(null);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualFromJsonResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#fromJson(ImmutableChangeInitiativeView.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<AssessmentDefinition> assessmentDefinitions = new LinkedHashSet<>();
    assessmentDefinitions.add(mock(AssessmentDefinition.class));

    ImmutableChangeInitiativeView.Json json = new ImmutableChangeInitiativeView.Json();
    json.setChangeInitiatives(null);
    json.setAssessmentDefinitions(assessmentDefinitions);
    json.setRatingSchemeItems(null);
    json.setRatings(null);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentDefinitions().size());
    Set<ChangeInitiative> changeInitiativesResult = actualFromJsonResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualFromJsonResult.ratingSchemeItems());
    assertSame(changeInitiativesResult, actualFromJsonResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#fromJson(ImmutableChangeInitiativeView.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    HashSet<ChangeInitiative> changeInitiatives = new HashSet<>();
    changeInitiatives.add(new ImmutableChangeInitiative.Json());

    ImmutableChangeInitiativeView.Json json = new ImmutableChangeInitiativeView.Json();
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    Set<AssessmentRating> assessmentRatingSet = json.ratings;
    assertSame(assessmentRatingSet, assessmentDefinitionsResult);
    assertSame(assessmentRatingSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(assessmentRatingSet, actualFromJsonResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView#fromJson(ImmutableChangeInitiativeView.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    HashSet<ChangeInitiative> changeInitiatives = new HashSet<>();
    changeInitiatives.add(new ImmutableChangeInitiative.Json());
    changeInitiatives.add(new ImmutableChangeInitiative.Json());

    ImmutableChangeInitiativeView.Json json = new ImmutableChangeInitiativeView.Json();
    json.setChangeInitiatives(changeInitiatives);

    // Act
    ImmutableChangeInitiativeView actualFromJsonResult = ImmutableChangeInitiativeView.fromJson(json);

    // Assert
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualFromJsonResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertEquals(changeInitiatives, actualFromJsonResult.changeInitiatives());
    Set<AssessmentRating> assessmentRatingSet = json.ratings;
    assertSame(assessmentRatingSet, assessmentDefinitionsResult);
    assertSame(assessmentRatingSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(assessmentRatingSet, actualFromJsonResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Json#assessmentDefinitions()}
   */
  @Test
  void testJsonAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableChangeInitiativeView.Json()).assessmentDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Json#changeInitiatives()}
   */
  @Test
  void testJsonChangeInitiatives() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableChangeInitiativeView.Json()).changeInitiatives());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableChangeInitiativeView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableChangeInitiativeView.Json actualJson = new ImmutableChangeInitiativeView.Json();

    // Assert
    assertTrue(actualJson.assessmentDefinitions.isEmpty());
    assertTrue(actualJson.changeInitiatives.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
    assertTrue(actualJson.ratings.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiativeView.Json#ratingSchemeItems()}
   */
  @Test
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableChangeInitiativeView.Json()).ratingSchemeItems());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiativeView.Json#ratings()}
   */
  @Test
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiativeView.Json()).ratings());
  }
}
