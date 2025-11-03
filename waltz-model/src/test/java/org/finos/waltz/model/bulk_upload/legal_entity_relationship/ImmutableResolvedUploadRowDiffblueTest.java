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
import java.util.Set;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedUploadRow.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedUploadRow.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableResolvedUploadRowDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentRatings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessmentRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentRatings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessmentRatings(Iterable)"})
  void testBuilderAddAllAssessmentRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentRatings(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentCell)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentCell.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessmentRatings(AssessmentCell)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentRatings(AssessmentCell) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentCell)"})
  void testBuilderAddAssessmentRatingsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentRatings(new ImmutableAssessmentCell.Json()));
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentCell[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentCell.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessmentRatings(AssessmentCell[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentRatings(AssessmentCell[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentCell[])"})
  void testBuilderAddAssessmentRatingsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentRatings(new ImmutableAssessmentCell.Json()));
  }

  /**
   * Test Builder {@link Builder#assessmentRatings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentRatings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentRatings(Iterable)"})
  void testBuilderAssessmentRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentRatings(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ResolvedUploadRow)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableAssessmentCell.Json} (default constructor).</li>
   *   <li>Then return build assessmentRatings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedUploadRow)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedUploadRow); given HashSet() add Json (default constructor); then return build assessmentRatings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedUploadRow)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildAssessmentRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    HashSet<AssessmentCell> assessmentCellSet = new HashSet<>();
    assessmentCellSet.add(new ImmutableAssessmentCell.Json());
    ResolvedUploadRow instance = mock(ResolvedUploadRow.class);
    when(instance.assessmentRatings()).thenReturn(assessmentCellSet);
    when(instance.rowNumber()).thenReturn(1L);
    when(instance.legalEntityRelationship()).thenReturn(new ImmutableResolvedLegalEntityRelationship.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).legalEntityRelationship();
    verify(instance).rowNumber();
    ImmutableResolvedUploadRow buildResult = actualFromResult.build();
    ResolvedLegalEntityRelationship legalEntityRelationshipResult = buildResult.legalEntityRelationship();
    assertTrue(legalEntityRelationshipResult instanceof ImmutableResolvedLegalEntityRelationship.Json);
    assertEquals(1, buildResult.assessmentRatings().size());
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertTrue(((ImmutableResolvedLegalEntityRelationship.Json) legalEntityRelationshipResult).errors.isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(ResolvedUploadRow)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build assessmentRatings Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedUploadRow)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedUploadRow); given HashSet(); then return build assessmentRatings Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedUploadRow)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildAssessmentRatingsEmpty() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();
    ResolvedUploadRow instance = mock(ResolvedUploadRow.class);
    when(instance.assessmentRatings()).thenReturn(new HashSet<>());
    when(instance.rowNumber()).thenReturn(1L);
    ImmutableResolvedLegalEntityRelationship.Json json = new ImmutableResolvedLegalEntityRelationship.Json();
    when(instance.legalEntityRelationship()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentRatings();
    verify(instance).legalEntityRelationship();
    verify(instance).rowNumber();
    ImmutableResolvedUploadRow buildResult = actualFromResult.build();
    ResolvedLegalEntityRelationship legalEntityRelationshipResult = buildResult.legalEntityRelationship();
    assertTrue(legalEntityRelationshipResult instanceof ImmutableResolvedLegalEntityRelationship.Json);
    assertTrue(buildResult.assessmentRatings().isEmpty());
    Set<LegalEntityRelationshipResolutionError> legalEntityRelationshipResolutionErrorSet = json.errors;
    assertSame(legalEntityRelationshipResolutionErrorSet, builderResult.build().assessmentRatings());
    assertSame(legalEntityRelationshipResolutionErrorSet,
        ((ImmutableResolvedLegalEntityRelationship.Json) legalEntityRelationshipResult).errors);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedUploadRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolvedUploadRow)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedUploadRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolvedUploadRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();
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
   * Test Builder {@link Builder#legalEntityRelationship(ResolvedLegalEntityRelationship)}.
   * <ul>
   *   <li>When {@link ImmutableResolvedLegalEntityRelationship.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#legalEntityRelationship(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder legalEntityRelationship(ResolvedLegalEntityRelationship); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.legalEntityRelationship(ResolvedLegalEntityRelationship)"})
  void testBuilderLegalEntityRelationship_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.legalEntityRelationship(new ImmutableResolvedLegalEntityRelationship.Json()));
  }

  /**
   * Test Builder {@link Builder#rowNumber(long)}.
   * <p>
   * Method under test: {@link Builder#rowNumber(long)}
   */
  @Test
  @DisplayName("Test Builder rowNumber(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rowNumber(long)"})
  void testBuilderRowNumber() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowNumber(1L));
  }

  /**
   * Test Json {@link Json#assessmentRatings()}.
   * <p>
   * Method under test: {@link Json#assessmentRatings()}
   */
  @Test
  @DisplayName("Test Json assessmentRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.assessmentRatings()"})
  void testJsonAssessmentRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentRatings());
  }

  /**
   * Test Json {@link Json#legalEntityRelationship()}.
   * <p>
   * Method under test: {@link Json#legalEntityRelationship()}
   */
  @Test
  @DisplayName("Test Json legalEntityRelationship()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResolvedLegalEntityRelationship Json.legalEntityRelationship()"})
  void testJsonLegalEntityRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).legalEntityRelationship());
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
    assertNull(actualJson.legalEntityRelationship);
    assertEquals(0L, actualJson.rowNumber);
    assertFalse(actualJson.rowNumberIsSet);
    assertTrue(actualJson.assessmentRatings.isEmpty());
  }

  /**
   * Test Json {@link Json#rowNumber()}.
   * <p>
   * Method under test: {@link Json#rowNumber()}
   */
  @Test
  @DisplayName("Test Json rowNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.rowNumber()"})
  void testJsonRowNumber() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rowNumber());
  }

  /**
   * Test Json {@link Json#setRowNumber(long)}.
   * <p>
   * Method under test: {@link Json#setRowNumber(long)}
   */
  @Test
  @DisplayName("Test Json setRowNumber(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRowNumber(long)"})
  void testJsonSetRowNumber() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRowNumber(1L);

    // Assert
    assertEquals(1L, json.rowNumber);
    assertTrue(json.rowNumberIsSet);
  }
}
