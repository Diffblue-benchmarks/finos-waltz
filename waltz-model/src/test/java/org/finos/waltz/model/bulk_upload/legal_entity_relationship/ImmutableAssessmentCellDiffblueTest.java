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
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCell.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCell.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentCellDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRatings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatings(Iterable)"})
  void testBuilderAddAllRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatings(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRatings(AssessmentCellRating)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentCellRating.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatings(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test Builder addRatings(AssessmentCellRating) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatings(AssessmentCellRating)"})
  void testBuilderAddRatingsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(new ImmutableAssessmentCellRating.Json()));
  }

  /**
   * Test Builder {@link Builder#addRatings(AssessmentCellRating[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentCellRating.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatings(AssessmentCellRating[])}
   */
  @Test
  @DisplayName("Test Builder addRatings(AssessmentCellRating[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatings(AssessmentCellRating[])"})
  void testBuilderAddRatingsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(new ImmutableAssessmentCellRating.Json()));
  }

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
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnId(1));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCell)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableAssessmentCellRating.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCell); given HashSet() add Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentCell)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    HashSet<AssessmentCellRating> assessmentCellRatingSet = new HashSet<>();
    assessmentCellRatingSet.add(new ImmutableAssessmentCellRating.Json());
    AssessmentCell instance = mock(AssessmentCell.class);
    when(instance.columnId()).thenReturn(1);
    when(instance.ratings()).thenReturn(assessmentCellRatingSet);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).ratings();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCell)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build inputString is {@code Input String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCell); given HashSet(); then return build inputString is 'Input String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentCell)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildInputStringIsInputString() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();
    AssessmentCell instance = mock(AssessmentCell.class);
    when(instance.columnId()).thenReturn(1);
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.inputString()).thenReturn("Input String");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).ratings();
    ImmutableAssessmentCell buildResult = actualFromResult.build();
    assertEquals("Input String", buildResult.inputString());
    ImmutableAssessmentCell buildResult2 = builderResult.build();
    assertEquals("Input String", buildResult2.inputString());
    assertEquals(1, buildResult.columnId());
    assertEquals(1, buildResult2.columnId());
    assertTrue(buildResult.ratings().isEmpty());
    assertTrue(buildResult.statuses().isEmpty());
    assertTrue(buildResult2.statuses().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCell)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCell); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentCell)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();
    AssessmentCell instance = mock(AssessmentCell.class);
    when(instance.columnId()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).columnId();
    verify(instance).inputString();
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
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Test Builder {@link Builder#ratings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratings(Iterable)"})
  void testBuilderRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(new ArrayList<>()));
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
    assertEquals(0, actualJson.columnId);
    assertFalse(actualJson.columnIdIsSet);
    assertTrue(actualJson.ratings.isEmpty());
  }

  /**
   * Test Json {@link Json#ratings()}.
   * <p>
   * Method under test: {@link Json#ratings()}
   */
  @Test
  @DisplayName("Test Json ratings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.ratings()"})
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratings());
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
   * Test Json {@link Json#statuses()}.
   * <p>
   * Method under test: {@link Json#statuses()}
   */
  @Test
  @DisplayName("Test Json statuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.statuses()"})
  void testJsonStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).statuses());
  }
}
