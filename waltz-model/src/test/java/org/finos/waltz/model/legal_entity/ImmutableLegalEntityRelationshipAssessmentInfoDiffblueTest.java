package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipAssessmentInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipAssessmentInfo.Builder#definitionRef(EntityReference)}
   */
  @Test
  void testBuilderDefinitionRef() {
    // Arrange
    ImmutableLegalEntityRelationshipAssessmentInfo.Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definitionRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipAssessmentInfo.Builder#from(LegalEntityRelationshipAssessmentInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLegalEntityRelationshipAssessmentInfo.Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo
        .builder();
    LegalEntityRelationshipAssessmentInfo instance = mock(LegalEntityRelationshipAssessmentInfo.class);
    when(instance.relationshipId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).relationshipId();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipAssessmentInfo.Builder#from(LegalEntityRelationshipAssessmentInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLegalEntityRelationshipAssessmentInfo.Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo
        .builder();
    LegalEntityRelationshipAssessmentInfo instance = mock(LegalEntityRelationshipAssessmentInfo.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.relationshipId()).thenReturn(1L);
    when(instance.definitionRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableLegalEntityRelationshipAssessmentInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionRef();
    verify(instance).ratingId();
    verify(instance).relationshipId();
    ImmutableLegalEntityRelationshipAssessmentInfo buildResult = builderResult.build();
    assertEquals(1L, buildResult.ratingId().longValue());
    assertEquals(1L, buildResult.relationshipId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipAssessmentInfo.Builder#from(LegalEntityRelationshipAssessmentInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLegalEntityRelationshipAssessmentInfo.Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo
        .builder();
    LegalEntityRelationshipAssessmentInfo instance = mock(LegalEntityRelationshipAssessmentInfo.class);
    when(instance.ratingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.relationshipId()).thenReturn(1L);
    when(instance.definitionRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).definitionRef();
    verify(instance).ratingId();
    verify(instance).relationshipId();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipAssessmentInfo.Builder#ratingId(Long)}
   */
  @Test
  void testBuilderRatingId() {
    // Arrange
    ImmutableLegalEntityRelationshipAssessmentInfo.Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipAssessmentInfo.Builder#relationshipId(Long)}
   */
  @Test
  void testBuilderRelationshipId() {
    // Arrange
    ImmutableLegalEntityRelationshipAssessmentInfo.Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipAssessmentInfo#copyOf(LegalEntityRelationshipAssessmentInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LegalEntityRelationshipAssessmentInfo instance = mock(LegalEntityRelationshipAssessmentInfo.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.relationshipId()).thenReturn(1L);
    when(instance.definitionRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableLegalEntityRelationshipAssessmentInfo actualCopyOfResult = ImmutableLegalEntityRelationshipAssessmentInfo
        .copyOf(instance);

    // Assert
    verify(instance).definitionRef();
    verify(instance).ratingId();
    verify(instance).relationshipId();
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertEquals(1L, actualCopyOfResult.relationshipId().longValue());
  }
}
