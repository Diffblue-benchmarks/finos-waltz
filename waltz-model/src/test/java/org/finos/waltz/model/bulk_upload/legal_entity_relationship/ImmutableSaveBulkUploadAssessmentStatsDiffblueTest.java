package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.BulkChangeStatistics;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.junit.jupiter.api.Test;

class ImmutableSaveBulkUploadAssessmentStatsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadAssessmentStats.Builder#assessmentStatistics(BulkChangeStatistics)}
   */
  @Test
  void testBuilderAssessmentStatistics() {
    // Arrange
    ImmutableSaveBulkUploadAssessmentStats.Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentStatistics(mock(BulkChangeStatistics.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadAssessmentStats.Builder#definition(AssessmentDefinition)}
   */
  @Test
  void testBuilderDefinition() {
    // Arrange
    ImmutableSaveBulkUploadAssessmentStats.Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definition(mock(AssessmentDefinition.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadAssessmentStats.Builder#from(SaveBulkUploadAssessmentStats)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSaveBulkUploadAssessmentStats.Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();
    SaveBulkUploadAssessmentStats instance = mock(SaveBulkUploadAssessmentStats.class);
    when(instance.assessmentStatistics()).thenThrow(new IllegalStateException("instance"));
    when(instance.definition()).thenReturn(mock(AssessmentDefinition.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentStatistics();
    verify(instance).definition();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadAssessmentStats.Builder#from(SaveBulkUploadAssessmentStats)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSaveBulkUploadAssessmentStats.Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();
    SaveBulkUploadAssessmentStats instance = mock(SaveBulkUploadAssessmentStats.class);
    when(instance.assessmentStatistics()).thenReturn(mock(BulkChangeStatistics.class));
    when(instance.definition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    ImmutableSaveBulkUploadAssessmentStats.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentStatistics();
    verify(instance).definition();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadAssessmentStats#copyOf(SaveBulkUploadAssessmentStats)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SaveBulkUploadAssessmentStats instance = mock(SaveBulkUploadAssessmentStats.class);
    when(instance.assessmentStatistics()).thenReturn(mock(BulkChangeStatistics.class));
    when(instance.definition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    ImmutableSaveBulkUploadAssessmentStats.copyOf(instance);

    // Assert
    verify(instance).assessmentStatistics();
    verify(instance).definition();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadAssessmentStats#fromJson(ImmutableSaveBulkUploadAssessmentStats.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSaveBulkUploadAssessmentStats.Json json = new ImmutableSaveBulkUploadAssessmentStats.Json();
    json.setAssessmentStatistics(mock(BulkChangeStatistics.class));
    json.setDefinition(mock(AssessmentDefinition.class));

    // Act
    ImmutableSaveBulkUploadAssessmentStats actualFromJsonResult = ImmutableSaveBulkUploadAssessmentStats.fromJson(json);

    // Assert
    BulkChangeStatistics expectedAssessmentStatisticsResult = json.assessmentStatistics;
    assertSame(expectedAssessmentStatisticsResult, actualFromJsonResult.assessmentStatistics());
    AssessmentDefinition expectedDefinitionResult = json.definition;
    assertSame(expectedDefinitionResult, actualFromJsonResult.definition());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadAssessmentStats.Json#assessmentStatistics()}
   */
  @Test
  void testJsonAssessmentStatistics() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveBulkUploadAssessmentStats.Json()).assessmentStatistics());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveBulkUploadAssessmentStats.Json#definition()}
   */
  @Test
  void testJsonDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveBulkUploadAssessmentStats.Json()).definition());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSaveBulkUploadAssessmentStats.Json}
   *   <li>
   * {@link ImmutableSaveBulkUploadAssessmentStats.Json#setAssessmentStatistics(BulkChangeStatistics)}
   *   <li>
   * {@link ImmutableSaveBulkUploadAssessmentStats.Json#setDefinition(AssessmentDefinition)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSaveBulkUploadAssessmentStats.Json actualJson = new ImmutableSaveBulkUploadAssessmentStats.Json();
    actualJson.setAssessmentStatistics(null);
    actualJson.setDefinition(null);

    // Assert
    assertNull(actualJson.assessmentStatistics);
    assertNull(actualJson.definition);
  }
}
