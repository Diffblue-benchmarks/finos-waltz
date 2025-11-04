package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#addAllAssessmentHeaders(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentHeaders() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentHeaders(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#addAllRows(Iterable)}
   */
  @Test
  void testBuilderAddAllRows() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#addAllRows(Iterable)}
   */
  @Test
  void testBuilderAddAllRows2() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    builderResult.addAssessmentHeaders(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#addAssessmentHeaders(EntityReference)}
   */
  @Test
  void testBuilderAddAssessmentHeaders() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act
    ImmutableLegalEntityRelationshipView.Builder actualAddAssessmentHeadersResult = builderResult
        .addAssessmentHeaders(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#addAssessmentHeaders(EntityReference[])}
   */
  @Test
  void testBuilderAddAssessmentHeaders2() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act
    ImmutableLegalEntityRelationshipView.Builder actualAddAssessmentHeadersResult = builderResult
        .addAssessmentHeaders(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#addRows(LegalEntityRelationshipViewRow)}
   */
  @Test
  void testBuilderAddRows() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act
    ImmutableLegalEntityRelationshipView.Builder actualAddRowsResult = builderResult
        .addRows(new ImmutableLegalEntityRelationshipViewRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#addRows(LegalEntityRelationshipViewRow)}
   */
  @Test
  void testBuilderAddRows2() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    builderResult.addAssessmentHeaders(mock(EntityReference.class));

    // Act
    ImmutableLegalEntityRelationshipView.Builder actualAddRowsResult = builderResult
        .addRows(new ImmutableLegalEntityRelationshipViewRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#addRows(LegalEntityRelationshipViewRow[])}
   */
  @Test
  void testBuilderAddRows3() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act
    ImmutableLegalEntityRelationshipView.Builder actualAddRowsResult = builderResult
        .addRows(new ImmutableLegalEntityRelationshipViewRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#addRows(LegalEntityRelationshipViewRow[])}
   */
  @Test
  void testBuilderAddRows4() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    builderResult.addAssessmentHeaders(mock(EntityReference.class));

    // Act
    ImmutableLegalEntityRelationshipView.Builder actualAddRowsResult = builderResult
        .addRows(new ImmutableLegalEntityRelationshipViewRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#assessmentHeaders(Iterable)}
   */
  @Test
  void testBuilderAssessmentHeaders() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentHeaders(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableLegalEntityRelationshipView.builder().build().assessmentHeaders().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#from(LegalEntityRelationshipView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    LegalEntityRelationshipView instance = mock(LegalEntityRelationshipView.class);
    when(instance.assessmentHeaders()).thenReturn(new HashSet<>());
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableLegalEntityRelationshipView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#from(LegalEntityRelationshipView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    LegalEntityRelationshipView instance = mock(LegalEntityRelationshipView.class);
    when(instance.assessmentHeaders()).thenReturn(entityReferenceSet);
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableLegalEntityRelationshipView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#from(LegalEntityRelationshipView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    HashSet<LegalEntityRelationshipViewRow> legalEntityRelationshipViewRowSet = new HashSet<>();
    ImmutableLegalEntityRelationshipViewRow.Json json = new ImmutableLegalEntityRelationshipViewRow.Json();
    legalEntityRelationshipViewRowSet.add(json);
    LegalEntityRelationshipView instance = mock(LegalEntityRelationshipView.class);
    when(instance.assessmentHeaders()).thenReturn(new HashSet<>());
    when(instance.rows()).thenReturn(legalEntityRelationshipViewRowSet);

    // Act
    ImmutableLegalEntityRelationshipView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    ImmutableLegalEntityRelationshipView buildResult = builderResult.build();
    assertEquals(1, buildResult.rows().size());
    assertSame(builderResult, actualFromResult);
    Set<LegalEntityRelationshipViewAssessment> expectedAssessmentHeadersResult = json.assessments;
    assertSame(expectedAssessmentHeadersResult, buildResult.assessmentHeaders());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#rows(Iterable)}
   */
  @Test
  void testBuilderRows() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Builder#rows(Iterable)}
   */
  @Test
  void testBuilderRows2() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    builderResult.addAssessmentHeaders(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.rows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView#copyOf(LegalEntityRelationshipView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LegalEntityRelationshipView instance = mock(LegalEntityRelationshipView.class);
    when(instance.assessmentHeaders()).thenReturn(new HashSet<>());
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableLegalEntityRelationshipView actualCopyOfResult = ImmutableLegalEntityRelationshipView.copyOf(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    Set<EntityReference> assessmentHeadersResult = actualCopyOfResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualCopyOfResult.rows());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView#copyOf(LegalEntityRelationshipView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    LegalEntityRelationshipView instance = mock(LegalEntityRelationshipView.class);
    when(instance.assessmentHeaders()).thenReturn(entityReferenceSet);
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableLegalEntityRelationshipView actualCopyOfResult = ImmutableLegalEntityRelationshipView.copyOf(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertEquals(1, actualCopyOfResult.assessmentHeaders().size());
    assertTrue(actualCopyOfResult.rows().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView#copyOf(LegalEntityRelationshipView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    entityReferenceSet.add(mock(EntityReference.class));
    LegalEntityRelationshipView instance = mock(LegalEntityRelationshipView.class);
    when(instance.assessmentHeaders()).thenReturn(entityReferenceSet);
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableLegalEntityRelationshipView actualCopyOfResult = ImmutableLegalEntityRelationshipView.copyOf(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertTrue(actualCopyOfResult.rows().isEmpty());
    assertEquals(entityReferenceSet, actualCopyOfResult.assessmentHeaders());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView#copyOf(LegalEntityRelationshipView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<LegalEntityRelationshipViewRow> legalEntityRelationshipViewRowSet = new HashSet<>();
    ImmutableLegalEntityRelationshipViewRow.Json json = new ImmutableLegalEntityRelationshipViewRow.Json();
    legalEntityRelationshipViewRowSet.add(json);
    LegalEntityRelationshipView instance = mock(LegalEntityRelationshipView.class);
    when(instance.assessmentHeaders()).thenReturn(new HashSet<>());
    when(instance.rows()).thenReturn(legalEntityRelationshipViewRowSet);

    // Act
    ImmutableLegalEntityRelationshipView actualCopyOfResult = ImmutableLegalEntityRelationshipView.copyOf(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertEquals(1, actualCopyOfResult.rows().size());
    Set<EntityReference> assessmentHeadersResult = actualCopyOfResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(json.assessments, assessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView#fromJson(ImmutableLegalEntityRelationshipView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Json json = new ImmutableLegalEntityRelationshipView.Json();

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json);

    // Assert
    Set<EntityReference> assessmentHeadersResult = actualFromJsonResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    Set<LegalEntityRelationshipViewRow> legalEntityRelationshipViewRowSet = json.rows;
    assertSame(legalEntityRelationshipViewRowSet, assessmentHeadersResult);
    assertSame(legalEntityRelationshipViewRowSet, actualFromJsonResult.rows());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView#fromJson(ImmutableLegalEntityRelationshipView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableLegalEntityRelationshipView.Json json = new ImmutableLegalEntityRelationshipView.Json();
    json.setAssessmentHeaders(null);
    json.setRows(null);

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json);

    // Assert
    Set<EntityReference> assessmentHeadersResult = actualFromJsonResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualFromJsonResult.rows());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView#fromJson(ImmutableLegalEntityRelationshipView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipViewRow> rows = new LinkedHashSet<>();
    ImmutableLegalEntityRelationshipViewRow.Json json = new ImmutableLegalEntityRelationshipViewRow.Json();
    rows.add(json);

    ImmutableLegalEntityRelationshipView.Json json2 = new ImmutableLegalEntityRelationshipView.Json();
    json2.setAssessmentHeaders(null);
    json2.setRows(rows);

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.rows().size());
    Set<EntityReference> assessmentHeadersResult = actualFromJsonResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(json.assessments, assessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView#fromJson(ImmutableLegalEntityRelationshipView.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<EntityReference> assessmentHeaders = new LinkedHashSet<>();
    assessmentHeaders.add(mock(EntityReference.class));

    ImmutableLegalEntityRelationshipView.Json json = new ImmutableLegalEntityRelationshipView.Json();
    json.setAssessmentHeaders(assessmentHeaders);
    json.setRows(null);

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentHeaders().size());
    assertTrue(actualFromJsonResult.rows().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView#fromJson(ImmutableLegalEntityRelationshipView.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipViewRow> rows = new LinkedHashSet<>();
    rows.add(new ImmutableLegalEntityRelationshipViewRow.Json());
    ImmutableLegalEntityRelationshipViewRow.Json json = new ImmutableLegalEntityRelationshipViewRow.Json();
    rows.add(json);

    ImmutableLegalEntityRelationshipView.Json json2 = new ImmutableLegalEntityRelationshipView.Json();
    json2.setAssessmentHeaders(null);
    json2.setRows(rows);

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json2);

    // Assert
    Set<EntityReference> assessmentHeadersResult = actualFromJsonResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertEquals(rows, actualFromJsonResult.rows());
    assertSame(json.assessments, assessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipView.Json#assessmentHeaders()}
   */
  @Test
  void testJsonAssessmentHeaders() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipView.Json()).assessmentHeaders());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLegalEntityRelationshipView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipView.Json actualJson = new ImmutableLegalEntityRelationshipView.Json();

    // Assert
    assertTrue(actualJson.assessmentHeaders.isEmpty());
    assertTrue(actualJson.rows.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationshipView.Json#rows()}
   */
  @Test
  void testJsonRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelationshipView.Json()).rows());
  }
}
