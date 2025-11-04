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
import org.junit.jupiter.api.Test;

class ImmutableAssessmentDefinitionRatingOperationsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#addAllRatingOperations(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingOperations() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualAddAllRatingOperationsResult = builderResult
        .addAllRatingOperations(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllRatingOperationsResult.build().ratingOperations().isEmpty());
    assertSame(builderResult, actualAddAllRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#addRatingOperations(AssessmentRatingOperations)}
   */
  @Test
  void testBuilderAddRatingOperations() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualAddRatingOperationsResult = builderResult
        .addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    assertEquals(1, actualAddRatingOperationsResult.build().ratingOperations().size());
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#addRatingOperations(AssessmentRatingOperations)}
   */
  @Test
  void testBuilderAddRatingOperations2() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();
    builderResult.ratingOperations(new ArrayList<>());

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualAddRatingOperationsResult = builderResult
        .addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    assertEquals(1, actualAddRatingOperationsResult.build().ratingOperations().size());
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#addRatingOperations(AssessmentRatingOperations)}
   */
  @Test
  void testBuilderAddRatingOperations3() {
    // Arrange
    Iterable<AssessmentRatingOperations> elements = mock(Iterable.class);

    ArrayList<AssessmentRatingOperations> assessmentRatingOperationsList = new ArrayList<>();
    when(elements.iterator()).thenReturn(assessmentRatingOperationsList.iterator());
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();
    builderResult.ratingOperations(elements);

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualAddRatingOperationsResult = builderResult
        .addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    verify(elements).iterator();
    assertEquals(1, actualAddRatingOperationsResult.build().ratingOperations().size());
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#addRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  void testBuilderAddRatingOperations4() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualAddRatingOperationsResult = builderResult
        .addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    assertEquals(1, actualAddRatingOperationsResult.build().ratingOperations().size());
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#addRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  void testBuilderAddRatingOperations5() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();
    builderResult.ratingOperations(new ArrayList<>());

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualAddRatingOperationsResult = builderResult
        .addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    assertEquals(1, actualAddRatingOperationsResult.build().ratingOperations().size());
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#addRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  void testBuilderAddRatingOperations6() {
    // Arrange
    Iterable<AssessmentRatingOperations> elements = mock(Iterable.class);

    ArrayList<AssessmentRatingOperations> assessmentRatingOperationsList = new ArrayList<>();
    when(elements.iterator()).thenReturn(assessmentRatingOperationsList.iterator());
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();
    builderResult.ratingOperations(elements);

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualAddRatingOperationsResult = builderResult
        .addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    verify(elements).iterator();
    assertEquals(1, actualAddRatingOperationsResult.build().ratingOperations().size());
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();

    // Act and Assert
    assertTrue(builderResult.ratingOperations(new ArrayList<>()).build().ratingOperations().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#from(AssessmentDefinitionRatingOperations)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();
    AssessmentDefinitionRatingOperations instance = mock(AssessmentDefinitionRatingOperations.class);
    when(instance.ratingOperations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ratingOperations();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#from(AssessmentDefinitionRatingOperations)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();
    builderResult.addRatingOperations(new ImmutableAssessmentRatingOperations.Json());
    AssessmentDefinitionRatingOperations instance = mock(AssessmentDefinitionRatingOperations.class);
    when(instance.ratingOperations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ratingOperations();
    assertEquals(1, actualFromResult.build().ratingOperations().size());
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#from(AssessmentDefinitionRatingOperations)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();

    HashSet<AssessmentRatingOperations> assessmentRatingOperationsSet = new HashSet<>();
    assessmentRatingOperationsSet.add(new ImmutableAssessmentRatingOperations.Json());
    AssessmentDefinitionRatingOperations instance = mock(AssessmentDefinitionRatingOperations.class);
    when(instance.ratingOperations()).thenReturn(assessmentRatingOperationsSet);

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ratingOperations();
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#ratingOperations(Iterable)}
   */
  @Test
  void testBuilderRatingOperations() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualRatingOperationsResult = builderResult
        .ratingOperations(new ArrayList<>());

    // Assert
    assertTrue(actualRatingOperationsResult.build().ratingOperations().isEmpty());
    assertSame(builderResult, actualRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#ratingOperations(Iterable)}
   */
  @Test
  void testBuilderRatingOperations2() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();
    builderResult.ratingOperations(null);

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualRatingOperationsResult = builderResult
        .ratingOperations(null);

    // Assert
    assertNull(actualRatingOperationsResult.build().ratingOperations());
    assertNull(builderResult.build().ratingOperations());
    assertSame(builderResult, actualRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Builder#ratingOperations(Iterable)}
   */
  @Test
  void testBuilderRatingOperations3() {
    // Arrange
    Iterable<AssessmentRatingOperations> elements = mock(Iterable.class);

    ArrayList<AssessmentRatingOperations> assessmentRatingOperationsList = new ArrayList<>();
    when(elements.iterator()).thenReturn(assessmentRatingOperationsList.iterator());
    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult = ImmutableAssessmentDefinitionRatingOperations
        .builder();
    builderResult.ratingOperations(elements);

    // Act
    ImmutableAssessmentDefinitionRatingOperations.Builder actualRatingOperationsResult = builderResult
        .ratingOperations(null);

    // Assert
    verify(elements).iterator();
    assertNull(actualRatingOperationsResult.build().ratingOperations());
    assertNull(builderResult.build().ratingOperations());
    assertSame(builderResult, actualRatingOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations#copyOf(AssessmentDefinitionRatingOperations)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentDefinitionRatingOperations instance = mock(AssessmentDefinitionRatingOperations.class);
    when(instance.ratingOperations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualCopyOfResult = ImmutableAssessmentDefinitionRatingOperations
        .copyOf(instance);

    // Assert
    verify(instance).ratingOperations();
    assertTrue(actualCopyOfResult.ratingOperations().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations#copyOf(AssessmentDefinitionRatingOperations)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentRatingOperations> assessmentRatingOperationsSet = new HashSet<>();
    assessmentRatingOperationsSet.add(new ImmutableAssessmentRatingOperations.Json());
    AssessmentDefinitionRatingOperations instance = mock(AssessmentDefinitionRatingOperations.class);
    when(instance.ratingOperations()).thenReturn(assessmentRatingOperationsSet);

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualCopyOfResult = ImmutableAssessmentDefinitionRatingOperations
        .copyOf(instance);

    // Assert
    verify(instance).ratingOperations();
    assertEquals(1, actualCopyOfResult.ratingOperations().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations#copyOf(AssessmentDefinitionRatingOperations)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentRatingOperations> assessmentRatingOperationsSet = new HashSet<>();
    assessmentRatingOperationsSet.add(new ImmutableAssessmentRatingOperations.Json());
    assessmentRatingOperationsSet.add(new ImmutableAssessmentRatingOperations.Json());
    AssessmentDefinitionRatingOperations instance = mock(AssessmentDefinitionRatingOperations.class);
    when(instance.ratingOperations()).thenReturn(assessmentRatingOperationsSet);

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualCopyOfResult = ImmutableAssessmentDefinitionRatingOperations
        .copyOf(instance);

    // Assert
    verify(instance).ratingOperations();
    assertEquals(assessmentRatingOperationsSet, actualCopyOfResult.ratingOperations());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange, Act and Assert
    assertNull(
        ImmutableAssessmentDefinitionRatingOperations.fromJson(new ImmutableAssessmentDefinitionRatingOperations.Json())
            .ratingOperations());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Json json = new ImmutableAssessmentDefinitionRatingOperations.Json();
    json.setRatingOperations(new HashSet<>());

    // Act and Assert
    assertTrue(ImmutableAssessmentDefinitionRatingOperations.fromJson(json).ratingOperations().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AssessmentRatingOperations> ratingOperations = new LinkedHashSet<>();
    ratingOperations.add(new ImmutableAssessmentRatingOperations.Json());

    ImmutableAssessmentDefinitionRatingOperations.Json json = new ImmutableAssessmentDefinitionRatingOperations.Json();
    json.setRatingOperations(ratingOperations);

    // Act and Assert
    assertEquals(1, ImmutableAssessmentDefinitionRatingOperations.fromJson(json).ratingOperations().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<AssessmentRatingOperations> ratingOperations = new LinkedHashSet<>();
    ratingOperations.add(new ImmutableAssessmentRatingOperations.Json());
    ratingOperations.add(new ImmutableAssessmentRatingOperations.Json());

    ImmutableAssessmentDefinitionRatingOperations.Json json = new ImmutableAssessmentDefinitionRatingOperations.Json();
    json.setRatingOperations(ratingOperations);

    // Act and Assert
    assertEquals(ratingOperations, ImmutableAssessmentDefinitionRatingOperations.fromJson(json).ratingOperations());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAssessmentDefinitionRatingOperations.Json}
   *   <li>
   * {@link ImmutableAssessmentDefinitionRatingOperations.Json#setRatingOperations(Set)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAssessmentDefinitionRatingOperations.Json actualJson = new ImmutableAssessmentDefinitionRatingOperations.Json();
    actualJson.setRatingOperations(new HashSet<>());

    // Assert
    assertTrue(actualJson.ratingOperations.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinitionRatingOperations.Json#ratingOperations()}
   */
  @Test
  void testJsonRatingOperations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentDefinitionRatingOperations.Json()).ratingOperations());
  }
}
