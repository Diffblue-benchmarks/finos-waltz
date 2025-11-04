package org.finos.waltz.model.assessment_rating;

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
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentGroupedEntitiesDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Builder#addAllRatingEntityLists(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingEntityLists() {
    // Arrange
    ImmutableAssessmentGroupedEntities.Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingEntityLists(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Builder#addRatingEntityLists(RatingEntityList)}
   */
  @Test
  void testBuilderAddRatingEntityLists() {
    // Arrange
    ImmutableAssessmentGroupedEntities.Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingEntityLists(new ImmutableRatingEntityList.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Builder#addRatingEntityLists(RatingEntityList[])}
   */
  @Test
  void testBuilderAddRatingEntityLists2() {
    // Arrange
    ImmutableAssessmentGroupedEntities.Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingEntityLists(new ImmutableRatingEntityList.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Builder#assessmentDefinition(AssessmentDefinition)}
   */
  @Test
  void testBuilderAssessmentDefinition() {
    // Arrange
    ImmutableAssessmentGroupedEntities.Builder builderResult = ImmutableAssessmentGroupedEntities.builder();
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinition(assessmentDefinition));
    assertSame(assessmentDefinition, builderResult.build().assessmentDefinition());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Builder#from(AssessmentGroupedEntities)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentGroupedEntities.Builder builderResult = ImmutableAssessmentGroupedEntities.builder();
    AssessmentGroupedEntities instance = mock(AssessmentGroupedEntities.class);
    when(instance.ratingEntityLists()).thenReturn(new HashSet<>());
    when(instance.assessmentDefinition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    ImmutableAssessmentGroupedEntities.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).ratingEntityLists();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Builder#from(AssessmentGroupedEntities)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentGroupedEntities.Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    HashSet<RatingEntityList> ratingEntityListSet = new HashSet<>();
    ratingEntityListSet.add(new ImmutableRatingEntityList.Json());
    AssessmentGroupedEntities instance = mock(AssessmentGroupedEntities.class);
    when(instance.ratingEntityLists()).thenReturn(ratingEntityListSet);
    when(instance.assessmentDefinition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    ImmutableAssessmentGroupedEntities.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).ratingEntityLists();
    assertEquals(1, builderResult.build().ratingEntityLists().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Builder#from(AssessmentGroupedEntities)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentGroupedEntities.Builder builderResult = ImmutableAssessmentGroupedEntities.builder();
    AssessmentGroupedEntities instance = mock(AssessmentGroupedEntities.class);
    when(instance.ratingEntityLists()).thenThrow(new IllegalStateException("instance"));
    when(instance.assessmentDefinition()).thenReturn(mock(AssessmentDefinition.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentDefinition();
    verify(instance).ratingEntityLists();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Builder#ratingEntityLists(Iterable)}
   */
  @Test
  void testBuilderRatingEntityLists() {
    // Arrange
    ImmutableAssessmentGroupedEntities.Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingEntityLists(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities#copyOf(AssessmentGroupedEntities)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentGroupedEntities instance = mock(AssessmentGroupedEntities.class);
    when(instance.ratingEntityLists()).thenReturn(new HashSet<>());
    when(instance.assessmentDefinition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    ImmutableAssessmentGroupedEntities actualCopyOfResult = ImmutableAssessmentGroupedEntities.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).ratingEntityLists();
    assertTrue(actualCopyOfResult.ratingEntityLists().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities#copyOf(AssessmentGroupedEntities)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<RatingEntityList> ratingEntityListSet = new HashSet<>();
    ratingEntityListSet.add(new ImmutableRatingEntityList.Json());
    AssessmentGroupedEntities instance = mock(AssessmentGroupedEntities.class);
    when(instance.ratingEntityLists()).thenReturn(ratingEntityListSet);
    when(instance.assessmentDefinition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    ImmutableAssessmentGroupedEntities actualCopyOfResult = ImmutableAssessmentGroupedEntities.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).ratingEntityLists();
    assertEquals(1, actualCopyOfResult.ratingEntityLists().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities#copyOf(AssessmentGroupedEntities)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<RatingEntityList> ratingEntityListSet = new HashSet<>();
    ratingEntityListSet.add(new ImmutableRatingEntityList.Json());
    ratingEntityListSet.add(new ImmutableRatingEntityList.Json());
    AssessmentGroupedEntities instance = mock(AssessmentGroupedEntities.class);
    when(instance.ratingEntityLists()).thenReturn(ratingEntityListSet);
    when(instance.assessmentDefinition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    ImmutableAssessmentGroupedEntities actualCopyOfResult = ImmutableAssessmentGroupedEntities.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).ratingEntityLists();
    assertEquals(ratingEntityListSet, actualCopyOfResult.ratingEntityLists());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities#fromJson(ImmutableAssessmentGroupedEntities.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentGroupedEntities.Json json = new ImmutableAssessmentGroupedEntities.Json();
    json.setAssessmentDefinition(mock(AssessmentDefinition.class));

    // Act
    ImmutableAssessmentGroupedEntities actualFromJsonResult = ImmutableAssessmentGroupedEntities.fromJson(json);

    // Assert
    Set<RatingEntityList> ratingEntityListsResult = actualFromJsonResult.ratingEntityLists();
    assertTrue(ratingEntityListsResult.isEmpty());
    AssessmentDefinition expectedAssessmentDefinitionResult = json.assessmentDefinition;
    assertSame(expectedAssessmentDefinitionResult, actualFromJsonResult.assessmentDefinition());
    assertSame(json.ratingEntityLists, ratingEntityListsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities#fromJson(ImmutableAssessmentGroupedEntities.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<RatingEntityList> ratingEntityLists = new LinkedHashSet<>();
    ratingEntityLists.add(new ImmutableRatingEntityList.Json());

    ImmutableAssessmentGroupedEntities.Json json = new ImmutableAssessmentGroupedEntities.Json();
    json.setAssessmentDefinition(mock(AssessmentDefinition.class));
    json.setRatingEntityLists(ratingEntityLists);

    // Act
    ImmutableAssessmentGroupedEntities actualFromJsonResult = ImmutableAssessmentGroupedEntities.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratingEntityLists().size());
    AssessmentDefinition expectedAssessmentDefinitionResult = json.assessmentDefinition;
    assertSame(expectedAssessmentDefinitionResult, actualFromJsonResult.assessmentDefinition());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities#fromJson(ImmutableAssessmentGroupedEntities.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<RatingEntityList> ratingEntityLists = new LinkedHashSet<>();
    ratingEntityLists.add(new ImmutableRatingEntityList.Json());
    ratingEntityLists.add(new ImmutableRatingEntityList.Json());

    ImmutableAssessmentGroupedEntities.Json json = new ImmutableAssessmentGroupedEntities.Json();
    json.setAssessmentDefinition(mock(AssessmentDefinition.class));
    json.setRatingEntityLists(ratingEntityLists);

    // Act
    ImmutableAssessmentGroupedEntities actualFromJsonResult = ImmutableAssessmentGroupedEntities.fromJson(json);

    // Assert
    assertEquals(ratingEntityLists, actualFromJsonResult.ratingEntityLists());
    AssessmentDefinition expectedAssessmentDefinitionResult = json.assessmentDefinition;
    assertSame(expectedAssessmentDefinitionResult, actualFromJsonResult.assessmentDefinition());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Json#assessmentDefinition()}
   */
  @Test
  void testJsonAssessmentDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentGroupedEntities.Json()).assessmentDefinition());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentGroupedEntities.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentGroupedEntities.Json actualJson = new ImmutableAssessmentGroupedEntities.Json();

    // Assert
    assertNull(actualJson.assessmentDefinition);
    assertTrue(actualJson.ratingEntityLists.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentGroupedEntities.Json#ratingEntityLists()}
   */
  @Test
  void testJsonRatingEntityLists() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentGroupedEntities.Json()).ratingEntityLists());
  }
}
