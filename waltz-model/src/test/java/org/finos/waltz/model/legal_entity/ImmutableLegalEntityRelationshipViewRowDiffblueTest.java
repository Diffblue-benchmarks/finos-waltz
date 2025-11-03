package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipViewRow.Builder;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipViewRow.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipViewRowDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessments(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessments(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessments(Iterable)"})
  void testBuilderAddAllAssessments_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessments(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAssessments(LegalEntityRelationshipViewAssessment)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipViewAssessment.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessments(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  @DisplayName("Test Builder addAssessments(LegalEntityRelationshipViewAssessment) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessments(LegalEntityRelationshipViewAssessment)"})
  void testBuilderAddAssessmentsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessments(new ImmutableLegalEntityRelationshipViewAssessment.Json()));
  }

  /**
   * Test Builder {@link Builder#addAssessments(LegalEntityRelationshipViewAssessment[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipViewAssessment.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessments(LegalEntityRelationshipViewAssessment[])}
   */
  @Test
  @DisplayName("Test Builder addAssessments(LegalEntityRelationshipViewAssessment[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessments(LegalEntityRelationshipViewAssessment[])"})
  void testBuilderAddAssessmentsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessments(new ImmutableLegalEntityRelationshipViewAssessment.Json()));
  }

  /**
   * Test Builder {@link Builder#assessments(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessments(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessments(Iterable)"})
  void testBuilderAssessments_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessments(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipViewRow)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableLegalEntityRelationshipViewAssessment.Json} (default constructor).</li>
   *   <li>Then return build assessments size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipViewRow)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipViewRow); given HashSet() add Json (default constructor); then return build assessments size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipViewRow)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildAssessmentsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    HashSet<LegalEntityRelationshipViewAssessment> legalEntityRelationshipViewAssessmentSet = new HashSet<>();
    legalEntityRelationshipViewAssessmentSet.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());
    LegalEntityRelationshipViewRow instance = mock(LegalEntityRelationshipViewRow.class);
    when(instance.assessments()).thenReturn(legalEntityRelationshipViewAssessmentSet);
    when(instance.relationship()).thenReturn(new ImmutableLegalEntityRelationship.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).relationship();
    assertEquals(1, actualFromResult.build().assessments().size());
    assertEquals(1, builderResult.build().assessments().size());
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipViewRow)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build relationship is {@link ImmutableLegalEntityRelationship.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipViewRow)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipViewRow); given HashSet(); then builder build relationship is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipViewRow)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildRelationshipIsJson() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();
    LegalEntityRelationshipViewRow instance = mock(LegalEntityRelationshipViewRow.class);
    when(instance.assessments()).thenReturn(new HashSet<>());
    ImmutableLegalEntityRelationship.Json json = new ImmutableLegalEntityRelationship.Json();
    when(instance.relationship()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).relationship();
    assertSame(json, builderResult.build().relationship());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipViewRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipViewRow)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipViewRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipViewRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();
    LegalEntityRelationshipViewRow instance = mock(LegalEntityRelationshipViewRow.class);
    when(instance.assessments()).thenThrow(new IllegalStateException("instance"));
    when(instance.relationship()).thenReturn(new ImmutableLegalEntityRelationship.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessments();
    verify(instance).relationship();
  }

  /**
   * Test Builder {@link Builder#relationship(LegalEntityRelationship)}.
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationship.Json} (default constructor).</li>
   *   <li>Then builder build relationship is {@link ImmutableLegalEntityRelationship.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#relationship(LegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder relationship(LegalEntityRelationship); when Json (default constructor); then builder build relationship is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relationship(LegalEntityRelationship)"})
  void testBuilderRelationship_whenJson_thenBuilderBuildRelationshipIsJson() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();
    ImmutableLegalEntityRelationship.Json relationship = new ImmutableLegalEntityRelationship.Json();

    // Act
    Builder actualRelationshipResult = builderResult.relationship(relationship);

    // Assert
    assertSame(relationship, builderResult.build().relationship());
    assertSame(builderResult, actualRelationshipResult);
  }

  /**
   * Test Json {@link Json#assessments()}.
   * <p>
   * Method under test: {@link Json#assessments()}
   */
  @Test
  @DisplayName("Test Json assessments()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.assessments()"})
  void testJsonAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessments());
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
    assertNull(actualJson.relationship);
    assertTrue(actualJson.assessments.isEmpty());
  }

  /**
   * Test Json {@link Json#relationship()}.
   * <p>
   * Method under test: {@link Json#relationship()}
   */
  @Test
  @DisplayName("Test Json relationship()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LegalEntityRelationship Json.relationship()"})
  void testJsonRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relationship());
  }
}
