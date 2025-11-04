package org.finos.waltz.model;

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

class ImmutableAssessmentBasedSelectionFilterDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Builder#addAllRatingIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingIds() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Builder#addAllRatingIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingIds2() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Builder#addRatingIds(long)}
   */
  @Test
  void testBuilderAddRatingIds() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Builder#addRatingIds(long[])}
   */
  @Test
  void testBuilderAddRatingIds2() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Builder#definitionId(Long)}
   */
  @Test
  void testBuilderDefinitionId() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act
    ImmutableAssessmentBasedSelectionFilter.Builder actualDefinitionIdResult = builderResult.definitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().definitionId().longValue());
    assertSame(builderResult, actualDefinitionIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Builder#from(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();
    AssessmentBasedSelectionFilter instance = mock(AssessmentBasedSelectionFilter.class);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentBasedSelectionFilter.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingIds();
    assertEquals(1L, builderResult.build().definitionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Builder#from(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    AssessmentBasedSelectionFilter instance = mock(AssessmentBasedSelectionFilter.class);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(resultLongSet);

    // Act
    ImmutableAssessmentBasedSelectionFilter.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingIds();
    ImmutableAssessmentBasedSelectionFilter buildResult = builderResult.build();
    Set<Long> ratingIdsResult = buildResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertEquals(1L, buildResult.definitionId().longValue());
    assertTrue(ratingIdsResult.contains(-2L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Builder#ratingIds(Iterable)}
   */
  @Test
  void testBuilderRatingIds() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Builder#ratingIds(Iterable)}
   */
  @Test
  void testBuilderRatingIds2() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter#copyOf(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentBasedSelectionFilter instance = mock(AssessmentBasedSelectionFilter.class);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableAssessmentBasedSelectionFilter actualCopyOfResult = ImmutableAssessmentBasedSelectionFilter
        .copyOf(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingIds();
    assertEquals(1L, actualCopyOfResult.definitionId().longValue());
    assertTrue(actualCopyOfResult.ratingIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter#copyOf(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    AssessmentBasedSelectionFilter instance = mock(AssessmentBasedSelectionFilter.class);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(resultLongSet);

    // Act
    ImmutableAssessmentBasedSelectionFilter actualCopyOfResult = ImmutableAssessmentBasedSelectionFilter
        .copyOf(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingIds();
    Set<Long> ratingIdsResult = actualCopyOfResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertEquals(1L, actualCopyOfResult.definitionId().longValue());
    assertTrue(ratingIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter#copyOf(AssessmentBasedSelectionFilter)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    resultLongSet.add(1L);
    AssessmentBasedSelectionFilter instance = mock(AssessmentBasedSelectionFilter.class);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(resultLongSet);

    // Act
    ImmutableAssessmentBasedSelectionFilter actualCopyOfResult = ImmutableAssessmentBasedSelectionFilter
        .copyOf(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingIds();
    assertEquals(1L, actualCopyOfResult.definitionId().longValue());
    assertEquals(resultLongSet, actualCopyOfResult.ratingIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter#fromJson(ImmutableAssessmentBasedSelectionFilter.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter.Json json = new ImmutableAssessmentBasedSelectionFilter.Json();
    json.setDefinitionId(1L);
    json.setRatingIds(null);

    // Act
    ImmutableAssessmentBasedSelectionFilter actualFromJsonResult = ImmutableAssessmentBasedSelectionFilter
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.definitionId().longValue());
    assertTrue(actualFromJsonResult.ratingIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter#fromJson(ImmutableAssessmentBasedSelectionFilter.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<Long> ratingIds = new LinkedHashSet<>();
    ratingIds.add(1L);

    ImmutableAssessmentBasedSelectionFilter.Json json = new ImmutableAssessmentBasedSelectionFilter.Json();
    json.setDefinitionId(1L);
    json.setRatingIds(ratingIds);

    // Act
    ImmutableAssessmentBasedSelectionFilter actualFromJsonResult = ImmutableAssessmentBasedSelectionFilter
        .fromJson(json);

    // Assert
    Set<Long> ratingIdsResult = actualFromJsonResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertEquals(1L, actualFromJsonResult.definitionId().longValue());
    assertTrue(ratingIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter#fromJson(ImmutableAssessmentBasedSelectionFilter.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Long> ratingIds = new LinkedHashSet<>();
    ratingIds.add(-1L);
    ratingIds.add(1L);

    ImmutableAssessmentBasedSelectionFilter.Json json = new ImmutableAssessmentBasedSelectionFilter.Json();
    json.setDefinitionId(1L);
    json.setRatingIds(ratingIds);

    // Act
    ImmutableAssessmentBasedSelectionFilter actualFromJsonResult = ImmutableAssessmentBasedSelectionFilter
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.definitionId().longValue());
    assertEquals(ratingIds, actualFromJsonResult.ratingIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Json#definitionId()}
   */
  @Test
  void testJsonDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentBasedSelectionFilter.Json()).definitionId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentBasedSelectionFilter.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentBasedSelectionFilter.Json actualJson = new ImmutableAssessmentBasedSelectionFilter.Json();

    // Assert
    assertNull(actualJson.definitionId);
    assertTrue(actualJson.ratingIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentBasedSelectionFilter.Json#ratingIds()}
   */
  @Test
  void testJsonRatingIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentBasedSelectionFilter.Json()).ratingIds());
  }
}
