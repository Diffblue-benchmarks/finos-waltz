package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipViewRowDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Builder#addAllAssessments(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessments() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessments(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Builder#addAssessments(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  void testBuilderAddAssessments() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessments(new ImmutableLegalEntityRelationshipViewAssessment.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Builder#addAssessments(LegalEntityRelationshipViewAssessment[])}
   */
  @Test
  void testBuilderAddAssessments2() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessments(new ImmutableLegalEntityRelationshipViewAssessment.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Builder#assessments(Iterable)}
   */
  @Test
  void testBuilderAssessments() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessments(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Builder#from(LegalEntityRelationshipViewRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();
    LegalEntityRelationshipViewRow instance = mock(LegalEntityRelationshipViewRow.class);
    when(instance.assessments()).thenReturn(new HashSet<>());
    ImmutableLegalEntityRelationship.Json json = new ImmutableLegalEntityRelationship.Json();
    when(instance.relationship()).thenReturn(json);

    // Act
    ImmutableLegalEntityRelationshipViewRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).relationship();
    assertSame(json, builderResult.build().relationship());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Builder#from(LegalEntityRelationshipViewRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();
    LegalEntityRelationshipViewRow instance = mock(LegalEntityRelationshipViewRow.class);
    when(instance.assessments()).thenThrow(new IllegalStateException("instance"));
    when(instance.relationship()).thenReturn(new ImmutableLegalEntityRelationship.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessments();
    verify(instance).relationship();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Builder#from(LegalEntityRelationshipViewRow)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    HashSet<LegalEntityRelationshipViewAssessment> legalEntityRelationshipViewAssessmentSet = new HashSet<>();
    legalEntityRelationshipViewAssessmentSet.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());
    LegalEntityRelationshipViewRow instance = mock(LegalEntityRelationshipViewRow.class);
    when(instance.assessments()).thenReturn(legalEntityRelationshipViewAssessmentSet);
    ImmutableLegalEntityRelationship.Json json = new ImmutableLegalEntityRelationship.Json();
    when(instance.relationship()).thenReturn(json);

    // Act
    ImmutableLegalEntityRelationshipViewRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).relationship();
    ImmutableLegalEntityRelationshipViewRow buildResult = builderResult.build();
    assertEquals(1, buildResult.assessments().size());
    assertSame(json, buildResult.relationship());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Builder#relationship(LegalEntityRelationship)}
   */
  @Test
  void testBuilderRelationship() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();
    ImmutableLegalEntityRelationship.Json relationship = new ImmutableLegalEntityRelationship.Json();

    // Act
    ImmutableLegalEntityRelationshipViewRow.Builder actualRelationshipResult = builderResult.relationship(relationship);

    // Assert
    assertSame(relationship, builderResult.build().relationship());
    assertSame(builderResult, actualRelationshipResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Builder#relationship(LegalEntityRelationship)}
   */
  @Test
  void testBuilderRelationship2() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Json relationship = new ImmutableLegalEntityRelationship.Json();
    relationship.setLegalEntityReference(mock(EntityReference.class));

    // Act
    ImmutableLegalEntityRelationshipViewRow.Builder actualRelationshipResult = builderResult.relationship(relationship);

    // Assert
    assertSame(relationship, builderResult.build().relationship());
    assertSame(builderResult, actualRelationshipResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow#copyOf(LegalEntityRelationshipViewRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LegalEntityRelationshipViewRow instance = mock(LegalEntityRelationshipViewRow.class);
    when(instance.assessments()).thenReturn(new HashSet<>());
    ImmutableLegalEntityRelationship.Json json = new ImmutableLegalEntityRelationship.Json();
    when(instance.relationship()).thenReturn(json);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualCopyOfResult = ImmutableLegalEntityRelationshipViewRow
        .copyOf(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).relationship();
    assertTrue(actualCopyOfResult.assessments().isEmpty());
    assertSame(json, actualCopyOfResult.relationship());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow#copyOf(LegalEntityRelationshipViewRow)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<LegalEntityRelationshipViewAssessment> legalEntityRelationshipViewAssessmentSet = new HashSet<>();
    legalEntityRelationshipViewAssessmentSet.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());
    LegalEntityRelationshipViewRow instance = mock(LegalEntityRelationshipViewRow.class);
    when(instance.assessments()).thenReturn(legalEntityRelationshipViewAssessmentSet);
    ImmutableLegalEntityRelationship.Json json = new ImmutableLegalEntityRelationship.Json();
    when(instance.relationship()).thenReturn(json);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualCopyOfResult = ImmutableLegalEntityRelationshipViewRow
        .copyOf(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).relationship();
    assertEquals(1, actualCopyOfResult.assessments().size());
    assertSame(json, actualCopyOfResult.relationship());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow#copyOf(LegalEntityRelationshipViewRow)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<LegalEntityRelationshipViewAssessment> legalEntityRelationshipViewAssessmentSet = new HashSet<>();
    legalEntityRelationshipViewAssessmentSet.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());
    legalEntityRelationshipViewAssessmentSet.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());
    LegalEntityRelationshipViewRow instance = mock(LegalEntityRelationshipViewRow.class);
    when(instance.assessments()).thenReturn(legalEntityRelationshipViewAssessmentSet);
    ImmutableLegalEntityRelationship.Json json = new ImmutableLegalEntityRelationship.Json();
    when(instance.relationship()).thenReturn(json);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualCopyOfResult = ImmutableLegalEntityRelationshipViewRow
        .copyOf(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).relationship();
    assertEquals(legalEntityRelationshipViewAssessmentSet, actualCopyOfResult.assessments());
    assertSame(json, actualCopyOfResult.relationship());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow#fromJson(ImmutableLegalEntityRelationshipViewRow.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLegalEntityRelationshipViewRow.Json json = new ImmutableLegalEntityRelationshipViewRow.Json();
    ImmutableLegalEntityRelationship.Json relationship = new ImmutableLegalEntityRelationship.Json();
    json.setRelationship(relationship);
    json.setAssessments(null);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualFromJsonResult = ImmutableLegalEntityRelationshipViewRow
        .fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessments().isEmpty());
    assertSame(relationship, actualFromJsonResult.relationship());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow#fromJson(ImmutableLegalEntityRelationshipViewRow.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipViewAssessment> assessments = new LinkedHashSet<>();
    assessments.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());

    ImmutableLegalEntityRelationshipViewRow.Json json = new ImmutableLegalEntityRelationshipViewRow.Json();
    ImmutableLegalEntityRelationship.Json relationship = new ImmutableLegalEntityRelationship.Json();
    json.setRelationship(relationship);
    json.setAssessments(assessments);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualFromJsonResult = ImmutableLegalEntityRelationshipViewRow
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessments().size());
    assertSame(relationship, actualFromJsonResult.relationship());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow#fromJson(ImmutableLegalEntityRelationshipViewRow.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableLegalEntityRelationship.Json relationship = new ImmutableLegalEntityRelationship.Json();
    relationship.setLegalEntityReference(mock(EntityReference.class));

    ImmutableLegalEntityRelationshipViewRow.Json json = new ImmutableLegalEntityRelationshipViewRow.Json();
    json.setRelationship(relationship);
    json.setAssessments(null);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualFromJsonResult = ImmutableLegalEntityRelationshipViewRow
        .fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessments().isEmpty());
    assertSame(relationship, actualFromJsonResult.relationship());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow#fromJson(ImmutableLegalEntityRelationshipViewRow.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipViewAssessment> assessments = new LinkedHashSet<>();
    assessments.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());
    assessments.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());

    ImmutableLegalEntityRelationshipViewRow.Json json = new ImmutableLegalEntityRelationshipViewRow.Json();
    ImmutableLegalEntityRelationship.Json relationship = new ImmutableLegalEntityRelationship.Json();
    json.setRelationship(relationship);
    json.setAssessments(assessments);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualFromJsonResult = ImmutableLegalEntityRelationshipViewRow
        .fromJson(json);

    // Assert
    assertEquals(assessments, actualFromJsonResult.assessments());
    assertSame(relationship, actualFromJsonResult.relationship());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Json#assessments()}
   */
  @Test
  void testJsonAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipViewRow.Json()).assessments());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLegalEntityRelationshipViewRow.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipViewRow.Json actualJson = new ImmutableLegalEntityRelationshipViewRow.Json();

    // Assert
    assertNull(actualJson.relationship);
    assertTrue(actualJson.assessments.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipViewRow.Json#relationship()}
   */
  @Test
  void testJsonRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipViewRow.Json()).relationship());
  }
}
