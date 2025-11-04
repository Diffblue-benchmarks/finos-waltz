package org.finos.waltz.model.legal_entity;

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

class ImmutableLegalEntityRelationshipViewAssessmentDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Builder#addAllRatingIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingIds() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Builder#addAllRatingIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingIds2() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment
        .builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Builder#addRatingIds(long)}
   */
  @Test
  void testBuilderAddRatingIds() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Builder#addRatingIds(long[])}
   */
  @Test
  void testBuilderAddRatingIds2() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Builder#assessmentDefinitionId(Long)}
   */
  @Test
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment
        .builder();

    // Act
    ImmutableLegalEntityRelationshipViewAssessment.Builder actualAssessmentDefinitionIdResult = builderResult
        .assessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualAssessmentDefinitionIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Builder#from(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment
        .builder();
    LegalEntityRelationshipViewAssessment instance = mock(LegalEntityRelationshipViewAssessment.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableLegalEntityRelationshipViewAssessment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).ratingIds();
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Builder#from(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment
        .builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    LegalEntityRelationshipViewAssessment instance = mock(LegalEntityRelationshipViewAssessment.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(resultLongSet);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).ratingIds();
    ImmutableLegalEntityRelationshipViewAssessment buildResult = builderResult.build();
    Set<Long> ratingIdsResult = buildResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertEquals(1L, buildResult.assessmentDefinitionId().longValue());
    assertTrue(ratingIdsResult.contains(-2L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Builder#ratingIds(Iterable)}
   */
  @Test
  void testBuilderRatingIds() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Builder#ratingIds(Iterable)}
   */
  @Test
  void testBuilderRatingIds2() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment
        .builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment#copyOf(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LegalEntityRelationshipViewAssessment instance = mock(LegalEntityRelationshipViewAssessment.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualCopyOfResult = ImmutableLegalEntityRelationshipViewAssessment
        .copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).ratingIds();
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId().longValue());
    assertTrue(actualCopyOfResult.ratingIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment#copyOf(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    LegalEntityRelationshipViewAssessment instance = mock(LegalEntityRelationshipViewAssessment.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(resultLongSet);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualCopyOfResult = ImmutableLegalEntityRelationshipViewAssessment
        .copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).ratingIds();
    Set<Long> ratingIdsResult = actualCopyOfResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId().longValue());
    assertTrue(ratingIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment#copyOf(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    resultLongSet.add(1L);
    LegalEntityRelationshipViewAssessment instance = mock(LegalEntityRelationshipViewAssessment.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(resultLongSet);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualCopyOfResult = ImmutableLegalEntityRelationshipViewAssessment
        .copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).ratingIds();
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId().longValue());
    assertEquals(resultLongSet, actualCopyOfResult.ratingIds());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(ImmutableLegalEntityRelationshipViewAssessment.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment.Json json = new ImmutableLegalEntityRelationshipViewAssessment.Json();
    json.setAssessmentDefinitionId(1L);
    json.setRatingIds(null);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualFromJsonResult = ImmutableLegalEntityRelationshipViewAssessment
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.assessmentDefinitionId().longValue());
    assertTrue(actualFromJsonResult.ratingIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(ImmutableLegalEntityRelationshipViewAssessment.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<Long> ratingIds = new LinkedHashSet<>();
    ratingIds.add(1L);

    ImmutableLegalEntityRelationshipViewAssessment.Json json = new ImmutableLegalEntityRelationshipViewAssessment.Json();
    json.setAssessmentDefinitionId(1L);
    json.setRatingIds(ratingIds);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualFromJsonResult = ImmutableLegalEntityRelationshipViewAssessment
        .fromJson(json);

    // Assert
    Set<Long> ratingIdsResult = actualFromJsonResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertEquals(1L, actualFromJsonResult.assessmentDefinitionId().longValue());
    assertTrue(ratingIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(ImmutableLegalEntityRelationshipViewAssessment.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Long> ratingIds = new LinkedHashSet<>();
    ratingIds.add(-1L);
    ratingIds.add(1L);

    ImmutableLegalEntityRelationshipViewAssessment.Json json = new ImmutableLegalEntityRelationshipViewAssessment.Json();
    json.setAssessmentDefinitionId(1L);
    json.setRatingIds(ratingIds);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualFromJsonResult = ImmutableLegalEntityRelationshipViewAssessment
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.assessmentDefinitionId().longValue());
    assertEquals(ratingIds, actualFromJsonResult.ratingIds());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Json#assessmentDefinitionId()}
   */
  @Test
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipViewAssessment.Json()).assessmentDefinitionId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipViewAssessment.Json actualJson = new ImmutableLegalEntityRelationshipViewAssessment.Json();

    // Assert
    assertNull(actualJson.assessmentDefinitionId);
    assertTrue(actualJson.ratingIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewAssessment.Json#ratingIds()}
   */
  @Test
  void testJsonRatingIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipViewAssessment.Json()).ratingIds());
  }
}
