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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentHeaderCell.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentHeaderCell.Json;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentHeaderCellDiffblueTest {
  /**
   * Test Builder {@link Builder#columnId(int)}.
   * <p>
   * Method under test: {@link Builder#columnId(int)}
   */
  @Test
  @DisplayName("Test Builder columnId(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.columnId(int)"})
  void testBuilderColumnId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnId(1));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentHeaderCell)}.
   * <p>
   * Method under test: {@link Builder#from(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentHeaderCell)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentHeaderCell)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    AssessmentHeaderCell instance = mock(AssessmentHeaderCell.class);
    when(instance.columnId()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).columnId();
    verify(instance).inputString();
  }

  /**
   * Test Builder {@link Builder#from(AssessmentHeaderCell)}.
   * <p>
   * Method under test: {@link Builder#from(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentHeaderCell)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentHeaderCell)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
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
   * Test Builder {@link Builder#from(AssessmentHeaderCell)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link AssessmentHeaderCell} {@link AssessmentHeaderCell#resolvedRating()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentHeaderCell); given empty; when AssessmentHeaderCell resolvedRating() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentHeaderCell)"})
  void testBuilderFrom_givenEmpty_whenAssessmentHeaderCellResolvedRatingReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    ImmutableAssessmentHeaderCell buildResult = actualFromResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(1, buildResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, buildResult.status());
    assertTrue(buildResult.ratingLookupMap().isEmpty());
    assertTrue(buildResult.isSingleValued());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentHeaderCell)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return build inputString is {@code Input String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentHeaderCell); given HashMap(); then return build inputString is 'Input String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentHeaderCell)"})
  void testBuilderFrom_givenHashMap_thenReturnBuildInputStringIsInputString() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    ImmutableAssessmentHeaderCell buildResult = actualFromResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(1, buildResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, buildResult.status());
    assertTrue(buildResult.ratingLookupMap().isEmpty());
    assertTrue(buildResult.isSingleValued());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentHeaderCell)}.
   * <ul>
   *   <li>Then builder build inputString is {@code Input String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentHeaderCell); then builder build inputString is 'Input String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentHeaderCell)"})
  void testBuilderFrom_thenBuilderBuildInputStringIsInputString() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(AssessmentHeaderCell)}.
   * <ul>
   *   <li>When {@link AssessmentHeaderCell} {@link AssessmentHeaderCell#resolvedAssessmentDefinition()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentHeaderCell); when AssessmentHeaderCell resolvedAssessmentDefinition() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentHeaderCell)"})
  void testBuilderFrom_whenAssessmentHeaderCellResolvedAssessmentDefinitionReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).isSingleValued();
    verify(instance).ratingLookupMap();
    verify(instance).resolvedAssessmentDefinition();
    verify(instance).resolvedRating();
    verify(instance).status();
    ImmutableAssessmentHeaderCell buildResult = actualFromResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(1, buildResult.columnId());
    assertEquals(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, buildResult.status());
    assertTrue(buildResult.ratingLookupMap().isEmpty());
    assertTrue(buildResult.isSingleValued());
  }

  /**
   * Test Builder {@link Builder#inputString(String)}.
   * <p>
   * Method under test: {@link Builder#inputString(String)}
   */
  @Test
  @DisplayName("Test Builder inputString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inputString(String)"})
  void testBuilderInputString() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Test Builder {@link Builder#isSingleValued(boolean)}.
   * <p>
   * Method under test: {@link Builder#isSingleValued(boolean)}
   */
  @Test
  @DisplayName("Test Builder isSingleValued(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isSingleValued(boolean)"})
  void testBuilderIsSingleValued() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isSingleValued(true));
  }

  /**
   * Test Builder {@link Builder#putAllRatingLookupMap(Map)}.
   * <p>
   * Method under test: {@link Builder#putAllRatingLookupMap(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllRatingLookupMap(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putAllRatingLookupMap(Map)"})
  void testBuilderPutAllRatingLookupMap() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putAllRatingLookupMap(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#putRatingLookupMap(Entry)} with {@code entry}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putRatingLookupMap(Entry)}
   */
  @Test
  @DisplayName("Test Builder putRatingLookupMap(Entry) with 'entry'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putRatingLookupMap(Entry)"})
  void testBuilderPutRatingLookupMapWithEntry_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putRatingLookupMap(new SimpleEntry<>("foo", mock(RatingSchemeItem.class))));
  }

  /**
   * Test Builder {@link Builder#putRatingLookupMap(String, RatingSchemeItem)} with {@code key}, {@code value}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putRatingLookupMap(String, RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder putRatingLookupMap(String, RatingSchemeItem) with 'key', 'value'; when 'Key'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putRatingLookupMap(String, RatingSchemeItem)"})
  void testBuilderPutRatingLookupMapWithKeyValue_whenKey_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putRatingLookupMap("Key", mock(RatingSchemeItem.class)));
  }

  /**
   * Test Builder {@link Builder#ratingLookupMap(Map)}.
   * <p>
   * Method under test: {@link Builder#ratingLookupMap(Map)}
   */
  @Test
  @DisplayName("Test Builder ratingLookupMap(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingLookupMap(Map)"})
  void testBuilderRatingLookupMap() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingLookupMap(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#resolvedAssessmentDefinition(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#resolvedAssessmentDefinition(Optional)}
   */
  @Test
  @DisplayName("Test Builder resolvedAssessmentDefinition(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.resolvedAssessmentDefinition(Optional)"})
  void testBuilderResolvedAssessmentDefinitionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition = Optional
        .of(mock(AssessmentDefinition.class));

    // Act and Assert
    assertSame(builderResult, builderResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition));
  }

  /**
   * Test Builder {@link Builder#resolvedRating(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#resolvedRating(Optional)}
   */
  @Test
  @DisplayName("Test Builder resolvedRating(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.resolvedRating(Optional)"})
  void testBuilderResolvedRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.resolvedRating(resolvedRating));
  }

  /**
   * Test Builder {@link Builder#status(ResolvedAssessmentHeaderStatus)}.
   * <p>
   * Method under test: {@link Builder#status(ResolvedAssessmentHeaderStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ResolvedAssessmentHeaderStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.status(ResolvedAssessmentHeaderStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND));
  }

  /**
   * Test Json {@link Json#columnId()}.
   * <p>
   * Method under test: {@link Json#columnId()}
   */
  @Test
  @DisplayName("Test Json columnId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.columnId()"})
  void testJsonColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnId());
  }

  /**
   * Test Json {@link Json#inputString()}.
   * <p>
   * Method under test: {@link Json#inputString()}
   */
  @Test
  @DisplayName("Test Json inputString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.inputString()"})
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inputString());
  }

  /**
   * Test Json {@link Json#isSingleValued()}.
   * <p>
   * Method under test: {@link Json#isSingleValued()}
   */
  @Test
  @DisplayName("Test Json isSingleValued()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isSingleValued()"})
  void testJsonIsSingleValued() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isSingleValued());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

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
   * Test Json {@link Json#ratingLookupMap()}.
   * <p>
   * Method under test: {@link Json#ratingLookupMap()}
   */
  @Test
  @DisplayName("Test Json ratingLookupMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map Json.ratingLookupMap()"})
  void testJsonRatingLookupMap() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingLookupMap());
  }

  /**
   * Test Json {@link Json#resolvedAssessmentDefinition()}.
   * <p>
   * Method under test: {@link Json#resolvedAssessmentDefinition()}
   */
  @Test
  @DisplayName("Test Json resolvedAssessmentDefinition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.resolvedAssessmentDefinition()"})
  void testJsonResolvedAssessmentDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).resolvedAssessmentDefinition());
  }

  /**
   * Test Json {@link Json#resolvedRating()}.
   * <p>
   * Method under test: {@link Json#resolvedRating()}
   */
  @Test
  @DisplayName("Test Json resolvedRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.resolvedRating()"})
  void testJsonResolvedRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).resolvedRating());
  }

  /**
   * Test Json {@link Json#setColumnId(int)}.
   * <p>
   * Method under test: {@link Json#setColumnId(int)}
   */
  @Test
  @DisplayName("Test Json setColumnId(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setColumnId(int)"})
  void testJsonSetColumnId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setColumnId(1);

    // Assert
    assertEquals(1, json.columnId);
    assertTrue(json.columnIdIsSet);
  }

  /**
   * Test Json {@link Json#setIsSingleValued(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsSingleValued(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsSingleValued(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsSingleValued(boolean)"})
  void testJsonSetIsSingleValued() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsSingleValued(true);

    // Assert
    assertTrue(json.isSingleValued);
    assertTrue(json.isSingleValuedIsSet);
  }

  /**
   * Test Json {@link Json#status()}.
   * <p>
   * Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResolvedAssessmentHeaderStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).status());
  }
}
