package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

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
import org.finos.waltz.model.BulkChangeStatistics;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.junit.jupiter.api.Test;

class ImmutableSaveBulkUploadLegalEntityRelationshipResponseDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#addAllAssessmentStats(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentStats() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentStats(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#addAssessmentStats(SaveBulkUploadAssessmentStats)}
   */
  @Test
  void testBuilderAddAssessmentStats() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentStats(new ImmutableSaveBulkUploadAssessmentStats.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#addAssessmentStats(SaveBulkUploadAssessmentStats)}
   */
  @Test
  void testBuilderAddAssessmentStats2() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();

    ImmutableSaveBulkUploadAssessmentStats.Json element = new ImmutableSaveBulkUploadAssessmentStats.Json();
    element.setDefinition(mock(AssessmentDefinition.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentStats(element));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#addAssessmentStats(SaveBulkUploadAssessmentStats[])}
   */
  @Test
  void testBuilderAddAssessmentStats3() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentStats(new ImmutableSaveBulkUploadAssessmentStats.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#addAssessmentStats(SaveBulkUploadAssessmentStats[])}
   */
  @Test
  void testBuilderAddAssessmentStats4() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();

    ImmutableSaveBulkUploadAssessmentStats.Json json = new ImmutableSaveBulkUploadAssessmentStats.Json();
    json.setDefinition(mock(AssessmentDefinition.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentStats(json));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#assessmentStats(Iterable)}
   */
  @Test
  void testBuilderAssessmentStats() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentStats(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();
    SaveBulkUploadLegalEntityRelationshipResponse instance = mock(SaveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentStats()).thenReturn(new HashSet<>());
    when(instance.relationshipStats()).thenReturn(mock(BulkChangeStatistics.class));

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentStats();
    verify(instance).relationshipStats();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();

    HashSet<SaveBulkUploadAssessmentStats> saveBulkUploadAssessmentStatsSet = new HashSet<>();
    saveBulkUploadAssessmentStatsSet.add(new ImmutableSaveBulkUploadAssessmentStats.Json());
    SaveBulkUploadLegalEntityRelationshipResponse instance = mock(SaveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentStats()).thenReturn(saveBulkUploadAssessmentStatsSet);
    when(instance.relationshipStats()).thenReturn(mock(BulkChangeStatistics.class));

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentStats();
    verify(instance).relationshipStats();
    assertEquals(1, builderResult.build().assessmentStats().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();
    SaveBulkUploadLegalEntityRelationshipResponse instance = mock(SaveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentStats()).thenThrow(new IllegalStateException("instance"));
    when(instance.relationshipStats()).thenReturn(mock(BulkChangeStatistics.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentStats();
    verify(instance).relationshipStats();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder#relationshipStats(BulkChangeStatistics)}
   */
  @Test
  void testBuilderRelationshipStats() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .builder();
    BulkChangeStatistics relationshipStats = mock(BulkChangeStatistics.class);

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipStats(relationshipStats));
    assertSame(relationshipStats, builderResult.build().relationshipStats());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#copyOf(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SaveBulkUploadLegalEntityRelationshipResponse instance = mock(SaveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentStats()).thenReturn(new HashSet<>());
    when(instance.relationshipStats()).thenReturn(mock(BulkChangeStatistics.class));

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualCopyOfResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .copyOf(instance);

    // Assert
    verify(instance).assessmentStats();
    verify(instance).relationshipStats();
    assertTrue(actualCopyOfResult.assessmentStats().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#copyOf(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<SaveBulkUploadAssessmentStats> saveBulkUploadAssessmentStatsSet = new HashSet<>();
    saveBulkUploadAssessmentStatsSet.add(new ImmutableSaveBulkUploadAssessmentStats.Json());
    SaveBulkUploadLegalEntityRelationshipResponse instance = mock(SaveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentStats()).thenReturn(saveBulkUploadAssessmentStatsSet);
    when(instance.relationshipStats()).thenReturn(mock(BulkChangeStatistics.class));

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualCopyOfResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .copyOf(instance);

    // Assert
    verify(instance).assessmentStats();
    verify(instance).relationshipStats();
    assertEquals(1, actualCopyOfResult.assessmentStats().size());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#copyOf(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<SaveBulkUploadAssessmentStats> saveBulkUploadAssessmentStatsSet = new HashSet<>();
    saveBulkUploadAssessmentStatsSet.add(new ImmutableSaveBulkUploadAssessmentStats.Json());
    saveBulkUploadAssessmentStatsSet.add(new ImmutableSaveBulkUploadAssessmentStats.Json());
    SaveBulkUploadLegalEntityRelationshipResponse instance = mock(SaveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentStats()).thenReturn(saveBulkUploadAssessmentStatsSet);
    when(instance.relationshipStats()).thenReturn(mock(BulkChangeStatistics.class));

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualCopyOfResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .copyOf(instance);

    // Assert
    verify(instance).assessmentStats();
    verify(instance).relationshipStats();
    assertEquals(saveBulkUploadAssessmentStatsSet, actualCopyOfResult.assessmentStats());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json json = new ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json();
    json.setRelationshipStats(mock(BulkChangeStatistics.class));

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .fromJson(json);

    // Assert
    Set<SaveBulkUploadAssessmentStats> assessmentStatsResult = actualFromJsonResult.assessmentStats();
    assertTrue(assessmentStatsResult.isEmpty());
    assertSame(json.assessmentStats, assessmentStatsResult);
    BulkChangeStatistics expectedRelationshipStatsResult = json.relationshipStats;
    assertSame(expectedRelationshipStatsResult, actualFromJsonResult.relationshipStats());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<SaveBulkUploadAssessmentStats> assessmentStats = new LinkedHashSet<>();
    assessmentStats.add(new ImmutableSaveBulkUploadAssessmentStats.Json());

    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json json = new ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json();
    json.setRelationshipStats(mock(BulkChangeStatistics.class));
    json.setAssessmentStats(assessmentStats);

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentStats().size());
    BulkChangeStatistics expectedRelationshipStatsResult = json.relationshipStats;
    assertSame(expectedRelationshipStatsResult, actualFromJsonResult.relationshipStats());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<SaveBulkUploadAssessmentStats> assessmentStats = new LinkedHashSet<>();
    assessmentStats.add(new ImmutableSaveBulkUploadAssessmentStats.Json());
    assessmentStats.add(new ImmutableSaveBulkUploadAssessmentStats.Json());

    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json json = new ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json();
    json.setRelationshipStats(mock(BulkChangeStatistics.class));
    json.setAssessmentStats(assessmentStats);

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        .fromJson(json);

    // Assert
    assertEquals(assessmentStats, actualFromJsonResult.assessmentStats());
    BulkChangeStatistics expectedRelationshipStatsResult = json.relationshipStats;
    assertSame(expectedRelationshipStatsResult, actualFromJsonResult.relationshipStats());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json#assessmentStats()}
   */
  @Test
  void testJsonAssessmentStats() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json()).assessmentStats());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json actualJson = new ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json();

    // Assert
    assertNull(actualJson.relationshipStats);
    assertTrue(actualJson.assessmentStats.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json#relationshipStats()}
   */
  @Test
  void testJsonRelationshipStats() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json()).relationshipStats());
  }
}
