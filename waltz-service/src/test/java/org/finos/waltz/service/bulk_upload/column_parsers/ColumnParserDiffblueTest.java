package org.finos.waltz.service.bulk_upload.column_parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentHeaderCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.BulkUploadError;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ColumnParserDiffblueTest {
  /**
   * Test {@link ColumnParser#mkColumnParser(AssessmentHeaderCell)}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return {@link GenericRatingColumnParser}.
   * </ul>
   *
   * <p>Method under test: {@link ColumnParser#mkColumnParser(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName(
      "Test mkColumnParser(AssessmentHeaderCell); given empty; then return GenericRatingColumnParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ColumnParser ColumnParser.mkColumnParser(AssessmentHeaderCell)"})
  void testMkColumnParser_givenEmpty_thenReturnGenericRatingColumnParser() {
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
   * Test {@link ColumnParser#mkColumnParser(AssessmentHeaderCell)}.
   *
   * <ul>
   *   <li>Then return {@link AlwaysFailingColumnParser}.
   * </ul>
   *
   * <p>Method under test: {@link ColumnParser#mkColumnParser(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test mkColumnParser(AssessmentHeaderCell); then return AlwaysFailingColumnParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ColumnParser ColumnParser.mkColumnParser(AssessmentHeaderCell)"})
  void testMkColumnParser_thenReturnAlwaysFailingColumnParser() {
    // Arrange
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    when(headerCell.status())
        .thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);

    // Act
    ColumnParser actualMkColumnParserResult = ColumnParser.mkColumnParser(headerCell);

    // Assert
    verify(headerCell, atLeast(1)).status();
    assertTrue(actualMkColumnParserResult instanceof AlwaysFailingColumnParser);
    assertSame(headerCell, actualMkColumnParserResult.getHeader());
  }

  /**
   * Test {@link ColumnParser#mkColumnParser(AssessmentHeaderCell)}.
   *
   * <ul>
   *   <li>Then return {@link SpecificRatingColumnParser}.
   * </ul>
   *
   * <p>Method under test: {@link ColumnParser#mkColumnParser(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test mkColumnParser(AssessmentHeaderCell); then return SpecificRatingColumnParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ColumnParser ColumnParser.mkColumnParser(AssessmentHeaderCell)"})
  void testMkColumnParser_thenReturnSpecificRatingColumnParser() {
    // Arrange
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<RatingSchemeItem> ofResult = Optional.of(immutableRatingSchemeItem);
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
   * Test {@link ColumnParser#determineResolutionStatus(boolean, Set)}.
   *
   * <ul>
   *   <li>Given {@link BulkUploadError}.
   *   <li>Then return {@code ERROR}.
   * </ul>
   *
   * <p>Method under test: {@link ColumnParser#determineResolutionStatus(boolean, Set)}
   */
  @Test
  @DisplayName(
      "Test determineResolutionStatus(boolean, Set); given BulkUploadError; then return 'ERROR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolutionStatus ColumnParser.determineResolutionStatus(boolean, Set)"})
  void testDetermineResolutionStatus_givenBulkUploadError_thenReturnError() {
    // Arrange
    HashSet<BulkUploadError> errors = new HashSet<>();
    errors.add(mock(BulkUploadError.class));

    // Act and Assert
    assertEquals(ResolutionStatus.ERROR, ColumnParser.determineResolutionStatus(true, errors));
  }

  /**
   * Test {@link ColumnParser#determineResolutionStatus(boolean, Set)}.
   *
   * <ul>
   *   <li>Given {@link BulkUploadError}.
   *   <li>Then return {@code ERROR}.
   * </ul>
   *
   * <p>Method under test: {@link ColumnParser#determineResolutionStatus(boolean, Set)}
   */
  @Test
  @DisplayName(
      "Test determineResolutionStatus(boolean, Set); given BulkUploadError; then return 'ERROR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolutionStatus ColumnParser.determineResolutionStatus(boolean, Set)"})
  void testDetermineResolutionStatus_givenBulkUploadError_thenReturnError2() {
    // Arrange
    HashSet<BulkUploadError> errors = new HashSet<>();
    errors.add(mock(BulkUploadError.class));
    errors.add(mock(BulkUploadError.class));

    // Act and Assert
    assertEquals(ResolutionStatus.ERROR, ColumnParser.determineResolutionStatus(true, errors));
  }

  /**
   * Test {@link ColumnParser#determineResolutionStatus(boolean, Set)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ColumnParser#determineResolutionStatus(boolean, Set)}
   */
  @Test
  @DisplayName("Test determineResolutionStatus(boolean, Set); when 'false'; then return 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolutionStatus ColumnParser.determineResolutionStatus(boolean, Set)"})
  void testDetermineResolutionStatus_whenFalse_thenReturnNew() {
    // Arrange, Act and Assert
    assertEquals(ResolutionStatus.NEW, ColumnParser.determineResolutionStatus(false, null));
  }

  /**
   * Test {@link ColumnParser#determineResolutionStatus(boolean, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code EXISTING}.
   * </ul>
   *
   * <p>Method under test: {@link ColumnParser#determineResolutionStatus(boolean, Set)}
   */
  @Test
  @DisplayName(
      "Test determineResolutionStatus(boolean, Set); when HashSet(); then return 'EXISTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolutionStatus ColumnParser.determineResolutionStatus(boolean, Set)"})
  void testDetermineResolutionStatus_whenHashSet_thenReturnExisting() {
    // Arrange, Act and Assert
    assertEquals(
        ResolutionStatus.EXISTING, ColumnParser.determineResolutionStatus(true, new HashSet<>()));
  }

  /**
   * Test {@link ColumnParser#sanitize(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ColumnParser#sanitize(String)}
   */
  @Test
  @DisplayName("Test sanitize(String); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ColumnParser.sanitize(String)"})
  void testSanitize_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ColumnParser.sanitize(null));
  }

  /**
   * Test {@link ColumnParser#sanitize(String)}.
   *
   * <ul>
   *   <li>When {@code Rating String}.
   *   <li>Then return {@code rating string}.
   * </ul>
   *
   * <p>Method under test: {@link ColumnParser#sanitize(String)}
   */
  @Test
  @DisplayName("Test sanitize(String); when 'Rating String'; then return 'rating string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ColumnParser.sanitize(String)"})
  void testSanitize_whenRatingString_thenReturnRatingString() {
    // Arrange, Act and Assert
    assertEquals("rating string", ColumnParser.sanitize("Rating String"));
  }
}
