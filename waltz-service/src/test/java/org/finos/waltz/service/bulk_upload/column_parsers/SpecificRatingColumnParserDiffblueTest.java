package org.finos.waltz.service.bulk_upload.column_parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentHeaderCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCell;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class SpecificRatingColumnParserDiffblueTest {
  /**
   * Method under test:
   * {@link SpecificRatingColumnParser#apply(String, Collection)}
   */
  @Test
  void testApply() {
    // Arrange
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(assessmentDefinition.id()).thenReturn(ofResult);
    Optional<AssessmentDefinition> ofResult2 = Optional.of(assessmentDefinition);
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult3);
    Optional<RatingSchemeItem> ofResult4 = Optional.of(ratingSchemeItem);
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    when(headerCell.columnId()).thenReturn(1);
    when(headerCell.resolvedAssessmentDefinition()).thenReturn(ofResult2);
    when(headerCell.resolvedRating()).thenReturn(ofResult4);
    SpecificRatingColumnParser specificRatingColumnParser = new SpecificRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = specificRatingColumnParser.apply("42", new ArrayList<>());

    // Assert
    verify(assessmentDefinition).id();
    verify(ratingSchemeItem).id();
    verify(headerCell).columnId();
    verify(headerCell).resolvedAssessmentDefinition();
    verify(headerCell, atLeast(1)).resolvedRating();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SpecificRatingColumnParser#SpecificRatingColumnParser(AssessmentHeaderCell)}
   *   <li>{@link SpecificRatingColumnParser#getHeader()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new SpecificRatingColumnParser(null)).getHeader());
  }
}
