package org.finos.waltz.service.bulk_upload.column_parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentHeaderCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.BulkUploadError;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ColumnParserDiffblueTest {
  /**
   * Method under test: {@link ColumnParser#mkColumnParser(AssessmentHeaderCell)}
   */
  @Test
  void testMkColumnParser() {
    // Arrange
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    when(headerCell.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);

    // Act
    ColumnParser actualMkColumnParserResult = ColumnParser.mkColumnParser(headerCell);

    // Assert
    verify(headerCell, atLeast(1)).status();
    assertTrue(actualMkColumnParserResult instanceof AlwaysFailingColumnParser);
    assertSame(headerCell, actualMkColumnParserResult.getHeader());
  }

  /**
   * Method under test: {@link ColumnParser#mkColumnParser(AssessmentHeaderCell)}
   */
  @Test
  void testMkColumnParser2() {
    // Arrange
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    Optional<RatingSchemeItem> ofResult = Optional.of(mock(RatingSchemeItem.class));
    when(headerCell.resolvedRating()).thenReturn(ofResult);
    when(headerCell.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_FOUND);

    // Act
    ColumnParser actualMkColumnParserResult = ColumnParser.mkColumnParser(headerCell);

    // Assert
    verify(headerCell).resolvedRating();
    verify(headerCell).status();
    assertTrue(actualMkColumnParserResult instanceof SpecificRatingColumnParser);
    assertSame(headerCell, actualMkColumnParserResult.getHeader());
  }

  /**
   * Method under test: {@link ColumnParser#mkColumnParser(AssessmentHeaderCell)}
   */
  @Test
  void testMkColumnParser3() {
    // Arrange
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    Optional<RatingSchemeItem> emptyResult = Optional.empty();
    when(headerCell.resolvedRating()).thenReturn(emptyResult);
    when(headerCell.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_FOUND);

    // Act
    ColumnParser actualMkColumnParserResult = ColumnParser.mkColumnParser(headerCell);

    // Assert
    verify(headerCell, atLeast(1)).resolvedRating();
    verify(headerCell, atLeast(1)).status();
    assertTrue(actualMkColumnParserResult instanceof GenericRatingColumnParser);
    assertSame(headerCell, actualMkColumnParserResult.getHeader());
  }

  /**
   * Method under test:
   * {@link ColumnParser#determineResolutionStatus(boolean, Set)}
   */
  @Test
  void testDetermineResolutionStatus() {
    // Arrange, Act and Assert
    assertEquals(ResolutionStatus.EXISTING, ColumnParser.determineResolutionStatus(true, new HashSet<>()));
    assertEquals(ResolutionStatus.NEW, ColumnParser.determineResolutionStatus(false, new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link ColumnParser#determineResolutionStatus(boolean, Set)}
   */
  @Test
  void testDetermineResolutionStatus2() {
    // Arrange
    HashSet<BulkUploadError> errors = new HashSet<>();
    errors.add(mock(BulkUploadError.class));

    // Act and Assert
    assertEquals(ResolutionStatus.ERROR, ColumnParser.determineResolutionStatus(true, errors));
  }

  /**
   * Method under test:
   * {@link ColumnParser#determineResolutionStatus(boolean, Set)}
   */
  @Test
  void testDetermineResolutionStatus3() {
    // Arrange
    HashSet<BulkUploadError> errors = new HashSet<>();
    errors.add(mock(BulkUploadError.class));
    errors.add(mock(BulkUploadError.class));

    // Act and Assert
    assertEquals(ResolutionStatus.ERROR, ColumnParser.determineResolutionStatus(true, errors));
  }

  /**
   * Method under test: {@link ColumnParser#sanitize(String)}
   */
  @Test
  void testSanitize() {
    // Arrange, Act and Assert
    assertEquals("rating string", ColumnParser.sanitize("Rating String"));
    assertEquals("", ColumnParser.sanitize(null));
  }
}
