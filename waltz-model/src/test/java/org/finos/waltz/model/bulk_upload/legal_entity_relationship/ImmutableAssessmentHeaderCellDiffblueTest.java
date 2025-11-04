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
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentHeaderCellDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#columnId(int)}
   */
  @Test
  void testBuilderColumnId() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnId(1));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#columnId(int)}
   */
  @Test
  void testBuilderColumnId2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    builderResult.putRatingLookupMap(new AbstractMap.SimpleEntry<>("foo", mock(RatingSchemeItem.class)));

    // Act and Assert
    assertSame(builderResult, builderResult.columnId(1));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#from(AssessmentHeaderCell)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.columnId()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).columnId();
    verify(instance).inputString();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#from(AssessmentHeaderCell)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(new HashMap<>());
    when(instance.isSingleValued()).thenReturn(true);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.resolvedAssessmentDefinition()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    ImmutableAssessmentHeaderCell buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(1, buildResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, buildResult.status());
    assertTrue(buildResult.isSingleValued());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#from(AssessmentHeaderCell)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    HashMap<String, RatingSchemeItem> stringRatingSchemeItemMap = new HashMap<>();
    stringRatingSchemeItemMap.put("instance", mock(RatingSchemeItem.class));
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(stringRatingSchemeItemMap);
    when(instance.isSingleValued()).thenReturn(true);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.resolvedAssessmentDefinition()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    ImmutableAssessmentHeaderCell buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    Map<String, RatingSchemeItem> ratingLookupMapResult = buildResult.ratingLookupMap();
    assertEquals(1, ratingLookupMapResult.size());
    assertEquals(1, buildResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, buildResult.status());
    assertTrue(ratingLookupMapResult.containsKey("instance"));
    assertTrue(buildResult.isSingleValued());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#from(AssessmentHeaderCell)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(new HashMap<>());
    when(instance.isSingleValued()).thenReturn(true);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> emptyResult = Optional.empty();
    when(instance.resolvedAssessmentDefinition()).thenReturn(emptyResult);
    Optional<RatingSchemeItem> ofResult = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    ImmutableAssessmentHeaderCell buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(1, buildResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, buildResult.status());
    assertTrue(buildResult.isSingleValued());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#from(AssessmentHeaderCell)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(new HashMap<>());
    when(instance.isSingleValued()).thenReturn(true);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.resolvedAssessmentDefinition()).thenReturn(ofResult);
    Optional<RatingSchemeItem> emptyResult = Optional.empty();
    when(instance.resolvedRating()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    ImmutableAssessmentHeaderCell buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(1, buildResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, buildResult.status());
    assertTrue(buildResult.isSingleValued());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#from(AssessmentHeaderCell)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenThrow(new IllegalStateException("instance"));
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.resolvedAssessmentDefinition()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    builderResult.putRatingLookupMap(new AbstractMap.SimpleEntry<>("inputString", mock(RatingSchemeItem.class)));

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#isSingleValued(boolean)}
   */
  @Test
  void testBuilderIsSingleValued() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isSingleValued(true));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#isSingleValued(boolean)}
   */
  @Test
  void testBuilderIsSingleValued2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    builderResult.putRatingLookupMap(new AbstractMap.SimpleEntry<>("foo", mock(RatingSchemeItem.class)));

    // Act and Assert
    assertSame(builderResult, builderResult.isSingleValued(true));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#putAllRatingLookupMap(Map)}
   */
  @Test
  void testBuilderPutAllRatingLookupMap() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putAllRatingLookupMap(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#putAllRatingLookupMap(Map)}
   */
  @Test
  void testBuilderPutAllRatingLookupMap2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    builderResult.putRatingLookupMap(new AbstractMap.SimpleEntry<>("foo", mock(RatingSchemeItem.class)));

    // Act and Assert
    assertSame(builderResult, builderResult.putAllRatingLookupMap(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#putRatingLookupMap(String, RatingSchemeItem)}
   */
  @Test
  void testBuilderPutRatingLookupMap() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putRatingLookupMap("Key", mock(RatingSchemeItem.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#putRatingLookupMap(Map.Entry)}
   */
  @Test
  void testBuilderPutRatingLookupMap2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.putRatingLookupMap(new AbstractMap.SimpleEntry<>("foo", mock(RatingSchemeItem.class))));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#ratingLookupMap(Map)}
   */
  @Test
  void testBuilderRatingLookupMap() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingLookupMap(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#ratingLookupMap(Map)}
   */
  @Test
  void testBuilderRatingLookupMap2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    builderResult.putRatingLookupMap(new AbstractMap.SimpleEntry<>("foo", mock(RatingSchemeItem.class)));

    // Act and Assert
    assertSame(builderResult, builderResult.ratingLookupMap(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#status(ResolvedAssessmentHeaderStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Builder#status(ResolvedAssessmentHeaderStatus)}
   */
  @Test
  void testBuilderStatus2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    builderResult.putRatingLookupMap(new AbstractMap.SimpleEntry<>("status", mock(RatingSchemeItem.class)));

    // Act and Assert
    assertSame(builderResult, builderResult.status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell#copyOf(AssessmentHeaderCell)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(new HashMap<>());
    when(instance.isSingleValued()).thenReturn(true);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.resolvedAssessmentDefinition()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell actualCopyOfResult = ImmutableAssessmentHeaderCell.copyOf(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1, actualCopyOfResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.ratingLookupMap().isEmpty());
    assertTrue(actualCopyOfResult.isSingleValued());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell#copyOf(AssessmentHeaderCell)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashMap<String, RatingSchemeItem> stringRatingSchemeItemMap = new HashMap<>();
    stringRatingSchemeItemMap.put("instance", mock(RatingSchemeItem.class));
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(stringRatingSchemeItemMap);
    when(instance.isSingleValued()).thenReturn(true);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.resolvedAssessmentDefinition()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell actualCopyOfResult = ImmutableAssessmentHeaderCell.copyOf(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals("Input String", actualCopyOfResult.inputString());
    Map<String, RatingSchemeItem> ratingLookupMapResult = actualCopyOfResult.ratingLookupMap();
    assertEquals(1, ratingLookupMapResult.size());
    assertEquals(1, actualCopyOfResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualCopyOfResult.status());
    assertTrue(ratingLookupMapResult.containsKey("instance"));
    assertTrue(actualCopyOfResult.isSingleValued());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell#copyOf(AssessmentHeaderCell)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashMap<String, RatingSchemeItem> stringRatingSchemeItemMap = new HashMap<>();
    stringRatingSchemeItemMap.put("inputString", mock(RatingSchemeItem.class));
    stringRatingSchemeItemMap.put("instance", mock(RatingSchemeItem.class));
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(stringRatingSchemeItemMap);
    when(instance.isSingleValued()).thenReturn(true);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.resolvedAssessmentDefinition()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell actualCopyOfResult = ImmutableAssessmentHeaderCell.copyOf(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1, actualCopyOfResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.isSingleValued());
    assertEquals(stringRatingSchemeItemMap, actualCopyOfResult.ratingLookupMap());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell#copyOf(AssessmentHeaderCell)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(new HashMap<>());
    when(instance.isSingleValued()).thenReturn(false);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.resolvedAssessmentDefinition()).thenReturn(ofResult);
    Optional<RatingSchemeItem> ofResult2 = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult2);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell actualCopyOfResult = ImmutableAssessmentHeaderCell.copyOf(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1, actualCopyOfResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualCopyOfResult.status());
    assertFalse(actualCopyOfResult.isSingleValued());
    assertTrue(actualCopyOfResult.ratingLookupMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell#copyOf(AssessmentHeaderCell)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(new HashMap<>());
    when(instance.isSingleValued()).thenReturn(true);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> emptyResult = Optional.empty();
    when(instance.resolvedAssessmentDefinition()).thenReturn(emptyResult);
    Optional<RatingSchemeItem> ofResult = Optional.of(mock(RatingSchemeItem.class));
    when(instance.resolvedRating()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell actualCopyOfResult = ImmutableAssessmentHeaderCell.copyOf(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1, actualCopyOfResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.ratingLookupMap().isEmpty());
    assertTrue(actualCopyOfResult.isSingleValued());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell#copyOf(AssessmentHeaderCell)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.ratingLookupMap()).thenReturn(new HashMap<>());
    when(instance.isSingleValued()).thenReturn(true);
    when(instance.columnId()).thenReturn(1);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.resolvedAssessmentDefinition()).thenReturn(ofResult);
    Optional<RatingSchemeItem> emptyResult = Optional.empty();
    when(instance.resolvedRating()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentHeaderCell actualCopyOfResult = ImmutableAssessmentHeaderCell.copyOf(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1, actualCopyOfResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.ratingLookupMap().isEmpty());
    assertTrue(actualCopyOfResult.isSingleValued());
  }

  /**
   * Method under test: {@link ImmutableAssessmentHeaderCell.Json#columnId()}
   */
  @Test
  void testJsonColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentHeaderCell.Json()).columnId());
  }

  /**
   * Method under test: {@link ImmutableAssessmentHeaderCell.Json#inputString()}
   */
  @Test
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentHeaderCell.Json()).inputString());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Json#isSingleValued()}
   */
  @Test
  void testJsonIsSingleValued() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentHeaderCell.Json()).isSingleValued());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentHeaderCell.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentHeaderCell.Json actualJson = new ImmutableAssessmentHeaderCell.Json();

    // Assert
    assertNull(actualJson.inputString);
    assertNull(actualJson.status);
    assertEquals(0, actualJson.columnId);
    assertFalse(actualJson.resolvedAssessmentDefinition.isPresent());
    assertFalse(actualJson.resolvedRating.isPresent());
    assertFalse(actualJson.columnIdIsSet);
    assertFalse(actualJson.isSingleValued);
    assertFalse(actualJson.isSingleValuedIsSet);
    assertTrue(actualJson.ratingLookupMap.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Json#ratingLookupMap()}
   */
  @Test
  void testJsonRatingLookupMap() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentHeaderCell.Json()).ratingLookupMap());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Json#resolvedAssessmentDefinition()}
   */
  @Test
  void testJsonResolvedAssessmentDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentHeaderCell.Json()).resolvedAssessmentDefinition());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Json#resolvedRating()}
   */
  @Test
  void testJsonResolvedRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentHeaderCell.Json()).resolvedRating());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Json#setColumnId(int)}
   */
  @Test
  void testJsonSetColumnId() {
    // Arrange
    ImmutableAssessmentHeaderCell.Json json = new ImmutableAssessmentHeaderCell.Json();

    // Act
    json.setColumnId(1);

    // Assert
    assertEquals(1, json.columnId);
    assertTrue(json.columnIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Json#setColumnId(int)}
   */
  @Test
  void testJsonSetColumnId2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Json json = new ImmutableAssessmentHeaderCell.Json();
    Optional<AssessmentDefinition> resolvedAssessmentDefinition = Optional.of(mock(AssessmentDefinition.class));
    json.setResolvedAssessmentDefinition(resolvedAssessmentDefinition);

    // Act
    json.setColumnId(1);

    // Assert
    assertEquals(1, json.columnId);
    assertTrue(json.columnIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Json#setIsSingleValued(boolean)}
   */
  @Test
  void testJsonSetIsSingleValued() {
    // Arrange
    ImmutableAssessmentHeaderCell.Json json = new ImmutableAssessmentHeaderCell.Json();

    // Act
    json.setIsSingleValued(true);

    // Assert
    assertTrue(json.isSingleValued);
    assertTrue(json.isSingleValuedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentHeaderCell.Json#setIsSingleValued(boolean)}
   */
  @Test
  void testJsonSetIsSingleValued2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Json json = new ImmutableAssessmentHeaderCell.Json();
    Optional<AssessmentDefinition> resolvedAssessmentDefinition = Optional.of(mock(AssessmentDefinition.class));
    json.setResolvedAssessmentDefinition(resolvedAssessmentDefinition);

    // Act
    json.setIsSingleValued(true);

    // Assert
    assertTrue(json.isSingleValued);
    assertTrue(json.isSingleValuedIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssessmentHeaderCell.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentHeaderCell.Json()).status());
  }
}
