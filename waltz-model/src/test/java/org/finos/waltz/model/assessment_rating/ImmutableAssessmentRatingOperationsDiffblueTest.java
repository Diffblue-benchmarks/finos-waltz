package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.finos.waltz.model.Operation;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingOperationsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Builder#addAllOperations(Iterable)}
   */
  @Test
  void testBuilderAddAllOperations() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    // Act
    ImmutableAssessmentRatingOperations.Builder actualAddAllOperationsResult = builderResult
        .addAllOperations(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().operations().isEmpty());
    assertSame(builderResult, actualAddAllOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Builder#addAllOperations(Iterable)}
   */
  @Test
  void testBuilderAddAllOperations2() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act
    ImmutableAssessmentRatingOperations.Builder actualAddAllOperationsResult = builderResult.addAllOperations(elements);

    // Assert
    Set<Operation> operationsResult = builderResult.build().operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
    assertSame(builderResult, actualAddAllOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Builder#addOperations(Operation)}
   */
  @Test
  void testBuilderAddOperations() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    // Act
    ImmutableAssessmentRatingOperations.Builder actualAddOperationsResult = builderResult.addOperations(Operation.ADD);

    // Assert
    Set<Operation> operationsResult = builderResult.build().operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
    assertSame(builderResult, actualAddOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Builder#addOperations(Operation[])}
   */
  @Test
  void testBuilderAddOperations2() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    // Act
    ImmutableAssessmentRatingOperations.Builder actualAddOperationsResult = builderResult.addOperations(Operation.ADD);

    // Assert
    Set<Operation> operationsResult = builderResult.build().operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
    assertSame(builderResult, actualAddOperationsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingOperations.Builder#build()}
   *   <li>{@link ImmutableAssessmentRatingOperations.Builder#ratingId(Long)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentRatingOperations actualBuildResult = ImmutableAssessmentRatingOperations.builder()
        .ratingId(1L)
        .build();

    // Assert
    assertEquals(1L, actualBuildResult.ratingId().longValue());
    assertFalse(actualBuildResult.isDefault());
    assertTrue(actualBuildResult.operations().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Builder#from(AssessmentRatingOperations)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult = ImmutableAssessmentRatingOperations.builder();
    AssessmentRatingOperations instance = mock(AssessmentRatingOperations.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.operations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentRatingOperations.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operations();
    verify(instance).ratingId();
    ImmutableAssessmentRatingOperations buildResult = builderResult.build();
    assertEquals(1L, buildResult.ratingId().longValue());
    assertFalse(buildResult.isDefault());
    assertTrue(buildResult.operations().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Builder#from(AssessmentRatingOperations)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult = ImmutableAssessmentRatingOperations.builder();
    AssessmentRatingOperations instance = mock(AssessmentRatingOperations.class);
    when(instance.ratingId()).thenReturn(null);
    when(instance.operations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentRatingOperations.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operations();
    verify(instance).ratingId();
    ImmutableAssessmentRatingOperations buildResult = builderResult.build();
    assertNull(buildResult.ratingId());
    assertTrue(buildResult.operations().isEmpty());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Builder#from(AssessmentRatingOperations)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    HashSet<Operation> operationSet = new HashSet<>();
    operationSet.add(Operation.ADD);
    AssessmentRatingOperations instance = mock(AssessmentRatingOperations.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.operations()).thenReturn(operationSet);

    // Act
    ImmutableAssessmentRatingOperations.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operations();
    verify(instance).ratingId();
    ImmutableAssessmentRatingOperations buildResult = builderResult.build();
    Set<Operation> operationsResult = buildResult.operations();
    assertEquals(1, operationsResult.size());
    assertEquals(1L, buildResult.ratingId().longValue());
    assertFalse(buildResult.isDefault());
    assertTrue(operationsResult.contains(Operation.ADD));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Builder#operations(Iterable)}
   */
  @Test
  void testBuilderOperations() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    // Act
    ImmutableAssessmentRatingOperations.Builder actualOperationsResult = builderResult.operations(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().operations().isEmpty());
    assertSame(builderResult, actualOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Builder#operations(Iterable)}
   */
  @Test
  void testBuilderOperations2() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act
    ImmutableAssessmentRatingOperations.Builder actualOperationsResult = builderResult.operations(elements);

    // Assert
    Set<Operation> operationsResult = builderResult.build().operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
    assertSame(builderResult, actualOperationsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations#copyOf(AssessmentRatingOperations)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingOperations instance = mock(AssessmentRatingOperations.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.operations()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentRatingOperations actualCopyOfResult = ImmutableAssessmentRatingOperations.copyOf(instance);

    // Assert
    verify(instance).operations();
    verify(instance).ratingId();
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertFalse(actualCopyOfResult.isDefault());
    assertTrue(actualCopyOfResult.operations().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations#copyOf(AssessmentRatingOperations)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Operation> operationSet = new HashSet<>();
    operationSet.add(Operation.ADD);
    AssessmentRatingOperations instance = mock(AssessmentRatingOperations.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.operations()).thenReturn(operationSet);

    // Act
    ImmutableAssessmentRatingOperations actualCopyOfResult = ImmutableAssessmentRatingOperations.copyOf(instance);

    // Assert
    verify(instance).operations();
    verify(instance).ratingId();
    Set<Operation> operationsResult = actualCopyOfResult.operations();
    assertEquals(1, operationsResult.size());
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertFalse(actualCopyOfResult.isDefault());
    assertTrue(operationsResult.contains(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations#fromJson(ImmutableAssessmentRatingOperations.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange and Act
    ImmutableAssessmentRatingOperations actualFromJsonResult = ImmutableAssessmentRatingOperations
        .fromJson(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    assertNull(actualFromJsonResult.ratingId());
    assertTrue(actualFromJsonResult.operations().isEmpty());
    assertTrue(actualFromJsonResult.isDefault());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations#fromJson(ImmutableAssessmentRatingOperations.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAssessmentRatingOperations.Json json = new ImmutableAssessmentRatingOperations.Json();
    json.setRatingId(null);
    json.setOperations(null);

    // Act
    ImmutableAssessmentRatingOperations actualFromJsonResult = ImmutableAssessmentRatingOperations.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.ratingId());
    assertTrue(actualFromJsonResult.operations().isEmpty());
    assertTrue(actualFromJsonResult.isDefault());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations#fromJson(ImmutableAssessmentRatingOperations.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Operation> operations = new LinkedHashSet<>();
    operations.add(Operation.ADD);

    ImmutableAssessmentRatingOperations.Json json = new ImmutableAssessmentRatingOperations.Json();
    json.setRatingId(null);
    json.setOperations(operations);

    // Act
    ImmutableAssessmentRatingOperations actualFromJsonResult = ImmutableAssessmentRatingOperations.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.ratingId());
    Set<Operation> operationsResult = actualFromJsonResult.operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
    assertTrue(actualFromJsonResult.isDefault());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations#fromJson(ImmutableAssessmentRatingOperations.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableAssessmentRatingOperations.Json json = new ImmutableAssessmentRatingOperations.Json();
    json.setRatingId(1L);
    json.setOperations(null);

    // Act
    ImmutableAssessmentRatingOperations actualFromJsonResult = ImmutableAssessmentRatingOperations.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.ratingId().longValue());
    assertFalse(actualFromJsonResult.isDefault());
    assertTrue(actualFromJsonResult.operations().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Json#isDefault()}
   */
  @Test
  void testJsonIsDefault() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingOperations.Json()).isDefault());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRatingOperations.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRatingOperations.Json actualJson = new ImmutableAssessmentRatingOperations.Json();

    // Assert
    assertNull(actualJson.ratingId);
    assertTrue(actualJson.operations.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Json#operations()}
   */
  @Test
  void testJsonOperations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingOperations.Json()).operations());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingOperations.Json#ratingId()}
   */
  @Test
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingOperations.Json()).ratingId());
  }
}
