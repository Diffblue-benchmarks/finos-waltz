package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.BulkChangeStatistics;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableSaveBulkUploadAssessmentStats.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableSaveBulkUploadAssessmentStats.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveBulkUploadAssessmentStatsDiffblueTest {
  /**
   * Test Builder {@link Builder#assessmentStatistics(BulkChangeStatistics)}.
   * <ul>
   *   <li>When {@link BulkChangeStatistics}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentStatistics(BulkChangeStatistics)}
   */
  @Test
  @DisplayName("Test Builder assessmentStatistics(BulkChangeStatistics); when BulkChangeStatistics; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentStatistics(BulkChangeStatistics)"})
  void testBuilderAssessmentStatistics_whenBulkChangeStatistics_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentStatistics(mock(BulkChangeStatistics.class)));
  }

  /**
   * Test Builder {@link Builder#definition(AssessmentDefinition)}.
   * <ul>
   *   <li>When {@link AssessmentDefinition}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#definition(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder definition(AssessmentDefinition); when AssessmentDefinition; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.definition(AssessmentDefinition)"})
  void testBuilderDefinition_whenAssessmentDefinition_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definition(mock(AssessmentDefinition.class)));
  }

  /**
   * Test Builder {@link Builder#from(SaveBulkUploadAssessmentStats)}.
   * <ul>
   *   <li>Given {@link BulkChangeStatistics}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveBulkUploadAssessmentStats)}
   */
  @Test
  @DisplayName("Test Builder from(SaveBulkUploadAssessmentStats); given BulkChangeStatistics; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveBulkUploadAssessmentStats)"})
  void testBuilderFrom_givenBulkChangeStatistics_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();
    SaveBulkUploadAssessmentStats instance = mock(SaveBulkUploadAssessmentStats.class);
    when(instance.assessmentStatistics()).thenReturn(mock(BulkChangeStatistics.class));
    when(instance.definition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentStatistics();
    verify(instance).definition();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveBulkUploadAssessmentStats)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveBulkUploadAssessmentStats)}
   */
  @Test
  @DisplayName("Test Builder from(SaveBulkUploadAssessmentStats); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveBulkUploadAssessmentStats)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();
    SaveBulkUploadAssessmentStats instance = mock(SaveBulkUploadAssessmentStats.class);
    when(instance.assessmentStatistics()).thenThrow(new IllegalStateException("instance"));
    when(instance.definition()).thenReturn(mock(AssessmentDefinition.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentStatistics();
    verify(instance).definition();
  }

  /**
   * Test Json {@link Json#assessmentStatistics()}.
   * <p>
   * Method under test: {@link Json#assessmentStatistics()}
   */
  @Test
  @DisplayName("Test Json assessmentStatistics()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkChangeStatistics Json.assessmentStatistics()"})
  void testJsonAssessmentStatistics() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentStatistics());
  }

  /**
   * Test Json {@link Json#definition()}.
   * <p>
   * Method under test: {@link Json#definition()}
   */
  @Test
  @DisplayName("Test Json definition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentDefinition Json.definition()"})
  void testJsonDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).definition());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAssessmentStatistics(BulkChangeStatistics)}
   *   <li>{@link Json#setDefinition(AssessmentDefinition)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAssessmentStatistics(BulkChangeStatistics)",
      "void Json.setDefinition(AssessmentDefinition)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAssessmentStatistics(null);
    actualJson.setDefinition(null);

    // Assert
    assertNull(actualJson.assessmentStatistics);
    assertNull(actualJson.definition);
  }
}
