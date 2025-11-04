package org.finos.waltz.service.bulk_upload.column_parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentHeaderCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCell;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class GenericRatingColumnParserDiffblueTest {
  /**
   * Method under test:
   * {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  void testApply() {
    // Arrange
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(assessmentDefinition.id()).thenReturn(ofResult);
    Optional<AssessmentDefinition> ofResult2 = Optional.of(assessmentDefinition);
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    when(headerCell.columnId()).thenReturn(1);
    when(headerCell.ratingLookupMap()).thenReturn(new HashMap<>());
    when(headerCell.resolvedAssessmentDefinition()).thenReturn(ofResult2);
    GenericRatingColumnParser genericRatingColumnParser = new GenericRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply("42", new ArrayList<>());

    // Assert
    verify(assessmentDefinition).id();
    verify(headerCell).columnId();
    verify(headerCell).ratingLookupMap();
    verify(headerCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Method under test:
   * {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  void testApply2() {
    // Arrange
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(assessmentDefinition.id()).thenReturn(ofResult);
    Optional<AssessmentDefinition> ofResult2 = Optional.of(assessmentDefinition);
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    when(headerCell.columnId()).thenReturn(1);
    when(headerCell.resolvedAssessmentDefinition()).thenReturn(ofResult2);
    GenericRatingColumnParser genericRatingColumnParser = new GenericRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply(";", new ArrayList<>());

    // Assert
    verify(assessmentDefinition).id();
    verify(headerCell).columnId();
    verify(headerCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals(";", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(actualApplyResult.ratings().isEmpty());
    assertTrue(actualApplyResult.statuses().isEmpty());
  }

  /**
   * Method under test:
   * {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  void testApply3() {
    // Arrange
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(assessmentDefinition.id()).thenReturn(ofResult);
    Optional<AssessmentDefinition> ofResult2 = Optional.of(assessmentDefinition);
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    when(headerCell.columnId()).thenReturn(1);
    when(headerCell.resolvedAssessmentDefinition()).thenReturn(ofResult2);
    GenericRatingColumnParser genericRatingColumnParser = new GenericRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply("", new ArrayList<>());

    // Assert
    verify(assessmentDefinition).id();
    verify(headerCell).columnId();
    verify(headerCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(actualApplyResult.ratings().isEmpty());
    assertTrue(actualApplyResult.statuses().isEmpty());
  }

  /**
   * Method under test:
   * {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  void testApply4() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(ratingSchemeItem.id()).thenReturn(ofResult);

    HashMap<String, RatingSchemeItem> stringRatingSchemeItemMap = new HashMap<>();
    stringRatingSchemeItemMap.put("42", ratingSchemeItem);
    stringRatingSchemeItemMap.put("itemTransformer cannot be null", mock(RatingSchemeItem.class));
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(assessmentDefinition.id()).thenReturn(ofResult2);
    Optional<AssessmentDefinition> ofResult3 = Optional.of(assessmentDefinition);
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    when(headerCell.columnId()).thenReturn(1);
    when(headerCell.ratingLookupMap()).thenReturn(stringRatingSchemeItemMap);
    when(headerCell.resolvedAssessmentDefinition()).thenReturn(ofResult3);
    GenericRatingColumnParser genericRatingColumnParser = new GenericRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply("42", new ArrayList<>());

    // Assert
    verify(assessmentDefinition).id();
    verify(ratingSchemeItem).id();
    verify(headerCell).columnId();
    verify(headerCell).ratingLookupMap();
    verify(headerCell).resolvedAssessmentDefinition();
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
   * {@link GenericRatingColumnParser#GenericRatingColumnParser(AssessmentHeaderCell)}
   *   <li>{@link GenericRatingColumnParser#getHeader()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new GenericRatingColumnParser(null)).getHeader());
  }
}
