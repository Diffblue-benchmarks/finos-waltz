package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class AssessmentHeaderCellDiffblueTest {
  /**
   * Method under test:
   * {@link AssessmentHeaderCell#mkHeader(String, Optional, Optional, ResolvedAssessmentHeaderStatus, Set, int)}
   */
  @Test
  void testMkHeader() {
    // Arrange
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    when(assessmentDefinition.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    Optional<AssessmentDefinition> defn = Optional.of(assessmentDefinition);
    Optional<RatingSchemeItem> rating = Optional.of(mock(RatingSchemeItem.class));

    // Act
    AssessmentHeaderCell actualMkHeaderResult = AssessmentHeaderCell.mkHeader("Input String", defn, rating,
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, new HashSet<>(), 1);

    // Assert
    verify(assessmentDefinition).cardinality();
    assertTrue(actualMkHeaderResult instanceof ImmutableAssessmentHeaderCell);
    assertEquals("Input String", actualMkHeaderResult.inputString());
    assertEquals(1, actualMkHeaderResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualMkHeaderResult.status());
    assertTrue(actualMkHeaderResult.ratingLookupMap().isEmpty());
    assertTrue(actualMkHeaderResult.isSingleValued());
  }

  /**
   * Method under test:
   * {@link AssessmentHeaderCell#mkHeader(String, Optional, Optional, ResolvedAssessmentHeaderStatus, Set, int)}
   */
  @Test
  void testMkHeader2() {
    // Arrange
    Optional<AssessmentDefinition> defn = Optional.empty();
    Optional<RatingSchemeItem> rating = Optional.of(mock(RatingSchemeItem.class));

    // Act
    AssessmentHeaderCell actualMkHeaderResult = AssessmentHeaderCell.mkHeader("Input String", defn, rating,
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, new HashSet<>(), 1);

    // Assert
    assertTrue(actualMkHeaderResult instanceof ImmutableAssessmentHeaderCell);
    assertEquals("Input String", actualMkHeaderResult.inputString());
    assertEquals(1, actualMkHeaderResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualMkHeaderResult.status());
    assertFalse(actualMkHeaderResult.isSingleValued());
    assertTrue(actualMkHeaderResult.ratingLookupMap().isEmpty());
  }
}
