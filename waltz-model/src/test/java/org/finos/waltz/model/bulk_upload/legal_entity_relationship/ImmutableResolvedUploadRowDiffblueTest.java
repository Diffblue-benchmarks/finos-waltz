package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

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
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableResolvedUploadRowDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Builder#addAllAssessmentRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentRatings() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Builder#addAssessmentRatings(AssessmentCell)}
   */
  @Test
  void testBuilderAddAssessmentRatings() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentRatings(new ImmutableAssessmentCell.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Builder#addAssessmentRatings(AssessmentCell[])}
   */
  @Test
  void testBuilderAddAssessmentRatings2() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentRatings(new ImmutableAssessmentCell.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Builder#assessmentRatings(Iterable)}
   */
  @Test
  void testBuilderAssessmentRatings() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Builder#from(ResolvedUploadRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();
    ResolvedUploadRow instance = mock(ResolvedUploadRow.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.rowNumber()).thenReturn(1L);
    ImmutableResolvedLegalEntityRelationship.Json json = new ImmutableResolvedLegalEntityRelationship.Json();
    when(instance.legalEntityRelationship()).thenReturn(json);

    // Act
    ImmutableResolvedUploadRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).legalEntityRelationship();
    verify(instance).rowNumber();
    ImmutableResolvedUploadRow buildResult = builderResult.build();
    assertEquals(1L, buildResult.rowNumber());
    assertSame(json, buildResult.legalEntityRelationship());
    assertSame(builderResult, actualFromResult);
    Set<LegalEntityRelationshipResolutionError> expectedAssessmentRatingsResult = json.errors;
    assertSame(expectedAssessmentRatingsResult, buildResult.assessmentRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Builder#from(ResolvedUploadRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();
    ResolvedUploadRow instance = mock(ResolvedUploadRow.class);
    when(instance.assessmentRatings()).thenThrow(new IllegalStateException("instance"));
    when(instance.rowNumber()).thenReturn(1L);
    when(instance.legalEntityRelationship()).thenReturn(new ImmutableResolvedLegalEntityRelationship.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentRatings();
    verify(instance).legalEntityRelationship();
    verify(instance).rowNumber();
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Builder#from(ResolvedUploadRow)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();

    HashSet<AssessmentCell> assessmentCellSet = new HashSet<>();
    assessmentCellSet.add(new ImmutableAssessmentCell.Json());
    ResolvedUploadRow instance = mock(ResolvedUploadRow.class);
    when(instance.assessmentRatings()).thenReturn(assessmentCellSet);
    when(instance.rowNumber()).thenReturn(1L);
    ImmutableResolvedLegalEntityRelationship.Json json = new ImmutableResolvedLegalEntityRelationship.Json();
    when(instance.legalEntityRelationship()).thenReturn(json);

    // Act
    ImmutableResolvedUploadRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).legalEntityRelationship();
    verify(instance).rowNumber();
    ImmutableResolvedUploadRow buildResult = builderResult.build();
    assertEquals(1, buildResult.assessmentRatings().size());
    assertEquals(1L, buildResult.rowNumber());
    assertSame(json, buildResult.legalEntityRelationship());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Builder#legalEntityRelationship(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testBuilderLegalEntityRelationship() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.legalEntityRelationship(new ImmutableResolvedLegalEntityRelationship.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Builder#legalEntityRelationship(ResolvedLegalEntityRelationship)}
   */
  @Test
  void testBuilderLegalEntityRelationship2() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Json legalEntityRelationship = new ImmutableResolvedLegalEntityRelationship.Json();
    Optional<EntityReference> existingRelationshipReference = Optional.of(mock(EntityReference.class));
    legalEntityRelationship.setExistingRelationshipReference(existingRelationshipReference);

    // Act and Assert
    assertSame(builderResult, builderResult.legalEntityRelationship(legalEntityRelationship));
  }

  /**
   * Method under test: {@link ImmutableResolvedUploadRow.Builder#rowNumber(long)}
   */
  @Test
  void testBuilderRowNumber() {
    // Arrange
    ImmutableResolvedUploadRow.Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowNumber(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow#copyOf(ResolvedUploadRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ResolvedUploadRow instance = mock(ResolvedUploadRow.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.rowNumber()).thenReturn(1L);
    ImmutableResolvedLegalEntityRelationship.Json json = new ImmutableResolvedLegalEntityRelationship.Json();
    when(instance.legalEntityRelationship()).thenReturn(json);

    // Act
    ImmutableResolvedUploadRow actualCopyOfResult = ImmutableResolvedUploadRow.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).legalEntityRelationship();
    verify(instance).rowNumber();
    assertEquals(1L, actualCopyOfResult.rowNumber());
    Set<AssessmentCell> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(json, actualCopyOfResult.legalEntityRelationship());
    assertSame(json.errors, assessmentRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow#copyOf(ResolvedUploadRow)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentCell> assessmentCellSet = new HashSet<>();
    assessmentCellSet.add(new ImmutableAssessmentCell.Json());
    ResolvedUploadRow instance = mock(ResolvedUploadRow.class);
    when(instance.assessmentRatings()).thenReturn(assessmentCellSet);
    when(instance.rowNumber()).thenReturn(1L);
    ImmutableResolvedLegalEntityRelationship.Json json = new ImmutableResolvedLegalEntityRelationship.Json();
    when(instance.legalEntityRelationship()).thenReturn(json);

    // Act
    ImmutableResolvedUploadRow actualCopyOfResult = ImmutableResolvedUploadRow.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).legalEntityRelationship();
    verify(instance).rowNumber();
    assertEquals(1, actualCopyOfResult.assessmentRatings().size());
    assertEquals(1L, actualCopyOfResult.rowNumber());
    assertSame(json, actualCopyOfResult.legalEntityRelationship());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow#copyOf(ResolvedUploadRow)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentCell> assessmentCellSet = new HashSet<>();
    assessmentCellSet.add(new ImmutableAssessmentCell.Json());
    assessmentCellSet.add(new ImmutableAssessmentCell.Json());
    ResolvedUploadRow instance = mock(ResolvedUploadRow.class);
    when(instance.assessmentRatings()).thenReturn(assessmentCellSet);
    when(instance.rowNumber()).thenReturn(1L);
    ImmutableResolvedLegalEntityRelationship.Json json = new ImmutableResolvedLegalEntityRelationship.Json();
    when(instance.legalEntityRelationship()).thenReturn(json);

    // Act
    ImmutableResolvedUploadRow actualCopyOfResult = ImmutableResolvedUploadRow.copyOf(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).legalEntityRelationship();
    verify(instance).rowNumber();
    assertEquals(1L, actualCopyOfResult.rowNumber());
    assertEquals(assessmentCellSet, actualCopyOfResult.assessmentRatings());
    assertSame(json, actualCopyOfResult.legalEntityRelationship());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Json#assessmentRatings()}
   */
  @Test
  void testJsonAssessmentRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolvedUploadRow.Json()).assessmentRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableResolvedUploadRow.Json#legalEntityRelationship()}
   */
  @Test
  void testJsonLegalEntityRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolvedUploadRow.Json()).legalEntityRelationship());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableResolvedUploadRow.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableResolvedUploadRow.Json actualJson = new ImmutableResolvedUploadRow.Json();

    // Assert
    assertNull(actualJson.legalEntityRelationship);
    assertEquals(0L, actualJson.rowNumber);
    assertFalse(actualJson.rowNumberIsSet);
    assertTrue(actualJson.assessmentRatings.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableResolvedUploadRow.Json#rowNumber()}
   */
  @Test
  void testJsonRowNumber() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableResolvedUploadRow.Json()).rowNumber());
  }

  /**
   * Method under test: {@link ImmutableResolvedUploadRow.Json#setRowNumber(long)}
   */
  @Test
  void testJsonSetRowNumber() {
    // Arrange
    ImmutableResolvedUploadRow.Json json = new ImmutableResolvedUploadRow.Json();

    // Act
    json.setRowNumber(1L);

    // Assert
    assertEquals(1L, json.rowNumber);
    assertTrue(json.rowNumberIsSet);
  }

  /**
   * Method under test: {@link ImmutableResolvedUploadRow.Json#setRowNumber(long)}
   */
  @Test
  void testJsonSetRowNumber2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Json legalEntityRelationship = new ImmutableResolvedLegalEntityRelationship.Json();
    Optional<EntityReference> existingRelationshipReference = Optional.of(mock(EntityReference.class));
    legalEntityRelationship.setExistingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedUploadRow.Json json = new ImmutableResolvedUploadRow.Json();
    json.setLegalEntityRelationship(legalEntityRelationship);

    // Act
    json.setRowNumber(1L);

    // Assert
    assertEquals(1L, json.rowNumber);
    assertTrue(json.rowNumberIsSet);
  }
}
