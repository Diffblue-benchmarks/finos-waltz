package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

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
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.junit.jupiter.api.Test;

class ImmutableResolveBulkUploadLegalEntityRelationshipResponseDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addAllAssessmentHeaders(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessmentHeaders() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentHeaders(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addAllRows(Iterable)}
   */
  @Test
  void testBuilderAddAllRows() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addAllRows(Iterable)}
   */
  @Test
  void testBuilderAddAllRows2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Json element = new ImmutableAssessmentHeaderCell.Json();
    Optional<AssessmentDefinition> resolvedAssessmentDefinition = Optional.of(mock(AssessmentDefinition.class));
    element.setResolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();
    builderResult.addAssessmentHeaders(element);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addAssessmentHeaders(AssessmentHeaderCell)}
   */
  @Test
  void testBuilderAddAssessmentHeaders() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualAddAssessmentHeadersResult = builderResult
        .addAssessmentHeaders(new ImmutableAssessmentHeaderCell.Json());

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addAssessmentHeaders(AssessmentHeaderCell)}
   */
  @Test
  void testBuilderAddAssessmentHeaders2() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    ImmutableAssessmentHeaderCell.Json element = new ImmutableAssessmentHeaderCell.Json();
    Optional<AssessmentDefinition> resolvedAssessmentDefinition = Optional.of(mock(AssessmentDefinition.class));
    element.setResolvedAssessmentDefinition(resolvedAssessmentDefinition);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualAddAssessmentHeadersResult = builderResult
        .addAssessmentHeaders(element);

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addAssessmentHeaders(AssessmentHeaderCell[])}
   */
  @Test
  void testBuilderAddAssessmentHeaders3() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualAddAssessmentHeadersResult = builderResult
        .addAssessmentHeaders(new ImmutableAssessmentHeaderCell.Json());

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addAssessmentHeaders(AssessmentHeaderCell[])}
   */
  @Test
  void testBuilderAddAssessmentHeaders4() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    ImmutableAssessmentHeaderCell.Json json = new ImmutableAssessmentHeaderCell.Json();
    Optional<AssessmentDefinition> resolvedAssessmentDefinition = Optional.of(mock(AssessmentDefinition.class));
    json.setResolvedAssessmentDefinition(resolvedAssessmentDefinition);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualAddAssessmentHeadersResult = builderResult
        .addAssessmentHeaders(json);

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addRows(ResolvedUploadRow)}
   */
  @Test
  void testBuilderAddRows() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualAddRowsResult = builderResult
        .addRows(new ImmutableResolvedUploadRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addRows(ResolvedUploadRow)}
   */
  @Test
  void testBuilderAddRows2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Json element = new ImmutableAssessmentHeaderCell.Json();
    Optional<AssessmentDefinition> resolvedAssessmentDefinition = Optional.of(mock(AssessmentDefinition.class));
    element.setResolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();
    builderResult.addAssessmentHeaders(element);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualAddRowsResult = builderResult
        .addRows(new ImmutableResolvedUploadRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addRows(ResolvedUploadRow[])}
   */
  @Test
  void testBuilderAddRows3() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualAddRowsResult = builderResult
        .addRows(new ImmutableResolvedUploadRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#addRows(ResolvedUploadRow[])}
   */
  @Test
  void testBuilderAddRows4() {
    // Arrange
    ImmutableAssessmentHeaderCell.Json element = new ImmutableAssessmentHeaderCell.Json();
    Optional<AssessmentDefinition> resolvedAssessmentDefinition = Optional.of(mock(AssessmentDefinition.class));
    element.setResolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();
    builderResult.addAssessmentHeaders(element);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualAddRowsResult = builderResult
        .addRows(new ImmutableResolvedUploadRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#assessmentHeaders(Iterable)}
   */
  @Test
  void testBuilderAssessmentHeaders() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentHeaders(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build().assessmentHeaders().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#from(ResolveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();
    ResolveBulkUploadLegalEntityRelationshipResponse instance = mock(
        ResolveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentHeaders()).thenReturn(new HashSet<>());
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#from(ResolveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    HashSet<AssessmentHeaderCell> assessmentHeaderCellSet = new HashSet<>();
    assessmentHeaderCellSet.add(new ImmutableAssessmentHeaderCell.Json());
    ResolveBulkUploadLegalEntityRelationshipResponse instance = mock(
        ResolveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentHeaders()).thenReturn(assessmentHeaderCellSet);
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#from(ResolveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    HashSet<ResolvedUploadRow> resolvedUploadRowSet = new HashSet<>();
    ImmutableResolvedUploadRow.Json json = new ImmutableResolvedUploadRow.Json();
    resolvedUploadRowSet.add(json);
    ResolveBulkUploadLegalEntityRelationshipResponse instance = mock(
        ResolveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentHeaders()).thenReturn(new HashSet<>());
    when(instance.rows()).thenReturn(resolvedUploadRowSet);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse buildResult = builderResult.build();
    assertEquals(1, buildResult.rows().size());
    assertSame(builderResult, actualFromResult);
    Set<AssessmentCell> expectedAssessmentHeadersResult = json.assessmentRatings;
    assertSame(expectedAssessmentHeadersResult, buildResult.assessmentHeaders());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#rows(Iterable)}
   */
  @Test
  void testBuilderRows() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder#rows(Iterable)}
   */
  @Test
  void testBuilderRows2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Json element = new ImmutableAssessmentHeaderCell.Json();
    Optional<AssessmentDefinition> resolvedAssessmentDefinition = Optional.of(mock(AssessmentDefinition.class));
    element.setResolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .builder();
    builderResult.addAssessmentHeaders(element);

    // Act and Assert
    assertSame(builderResult, builderResult.rows(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#copyOf(ResolveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ResolveBulkUploadLegalEntityRelationshipResponse instance = mock(
        ResolveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentHeaders()).thenReturn(new HashSet<>());
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualCopyOfResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .copyOf(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    Set<AssessmentHeaderCell> assessmentHeadersResult = actualCopyOfResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualCopyOfResult.rows());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#copyOf(ResolveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentHeaderCell> assessmentHeaderCellSet = new HashSet<>();
    assessmentHeaderCellSet.add(new ImmutableAssessmentHeaderCell.Json());
    ResolveBulkUploadLegalEntityRelationshipResponse instance = mock(
        ResolveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentHeaders()).thenReturn(assessmentHeaderCellSet);
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualCopyOfResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .copyOf(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertEquals(1, actualCopyOfResult.assessmentHeaders().size());
    assertTrue(actualCopyOfResult.rows().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#copyOf(ResolveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentHeaderCell> assessmentHeaderCellSet = new HashSet<>();
    assessmentHeaderCellSet.add(new ImmutableAssessmentHeaderCell.Json());
    assessmentHeaderCellSet.add(new ImmutableAssessmentHeaderCell.Json());
    ResolveBulkUploadLegalEntityRelationshipResponse instance = mock(
        ResolveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentHeaders()).thenReturn(assessmentHeaderCellSet);
    when(instance.rows()).thenReturn(new HashSet<>());

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualCopyOfResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .copyOf(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertTrue(actualCopyOfResult.rows().isEmpty());
    assertEquals(assessmentHeaderCellSet, actualCopyOfResult.assessmentHeaders());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#copyOf(ResolveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<ResolvedUploadRow> resolvedUploadRowSet = new HashSet<>();
    ImmutableResolvedUploadRow.Json json = new ImmutableResolvedUploadRow.Json();
    resolvedUploadRowSet.add(json);
    ResolveBulkUploadLegalEntityRelationshipResponse instance = mock(
        ResolveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentHeaders()).thenReturn(new HashSet<>());
    when(instance.rows()).thenReturn(resolvedUploadRowSet);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualCopyOfResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .copyOf(instance);

    // Assert
    verify(instance).assessmentHeaders();
    verify(instance).rows();
    assertEquals(1, actualCopyOfResult.rows().size());
    Set<AssessmentHeaderCell> assessmentHeadersResult = actualCopyOfResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(json.assessmentRatings, assessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json json = new ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json();

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .fromJson(json);

    // Assert
    Set<AssessmentHeaderCell> assessmentHeadersResult = actualFromJsonResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    Set<ResolvedUploadRow> resolvedUploadRowSet = json.rows;
    assertSame(resolvedUploadRowSet, assessmentHeadersResult);
    assertSame(resolvedUploadRowSet, actualFromJsonResult.rows());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json json = new ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json();
    json.setRows(null);
    json.setAssessmentHeaders(null);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .fromJson(json);

    // Assert
    Set<AssessmentHeaderCell> assessmentHeadersResult = actualFromJsonResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualFromJsonResult.rows());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AssessmentHeaderCell> assessmentHeaders = new LinkedHashSet<>();
    assessmentHeaders.add(new ImmutableAssessmentHeaderCell.Json());

    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json json = new ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json();
    json.setRows(null);
    json.setAssessmentHeaders(assessmentHeaders);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentHeaders().size());
    assertTrue(actualFromJsonResult.rows().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<ResolvedUploadRow> rows = new LinkedHashSet<>();
    ImmutableResolvedUploadRow.Json json = new ImmutableResolvedUploadRow.Json();
    rows.add(json);

    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json json2 = new ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json();
    json2.setRows(rows);
    json2.setAssessmentHeaders(null);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.rows().size());
    Set<AssessmentHeaderCell> assessmentHeadersResult = actualFromJsonResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(json.assessmentRatings, assessmentHeadersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<AssessmentHeaderCell> assessmentHeaders = new LinkedHashSet<>();
    assessmentHeaders.add(new ImmutableAssessmentHeaderCell.Json());
    assessmentHeaders.add(new ImmutableAssessmentHeaderCell.Json());

    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json json = new ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json();
    json.setRows(null);
    json.setAssessmentHeaders(assessmentHeaders);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.rows().isEmpty());
    assertEquals(assessmentHeaders, actualFromJsonResult.assessmentHeaders());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    ImmutableAssessmentHeaderCell.Json json = new ImmutableAssessmentHeaderCell.Json();
    Optional<AssessmentDefinition> resolvedAssessmentDefinition = Optional.of(mock(AssessmentDefinition.class));
    json.setResolvedAssessmentDefinition(resolvedAssessmentDefinition);

    LinkedHashSet<AssessmentHeaderCell> assessmentHeaders = new LinkedHashSet<>();
    assessmentHeaders.add(json);

    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json json2 = new ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json();
    json2.setRows(null);
    json2.setAssessmentHeaders(assessmentHeaders);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        .fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentHeaders().size());
    assertTrue(actualFromJsonResult.rows().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json#assessmentHeaders()}
   */
  @Test
  void testJsonAssessmentHeaders() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json()).assessmentHeaders());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json actualJson = new ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json();

    // Assert
    assertTrue(actualJson.assessmentHeaders.isEmpty());
    assertTrue(actualJson.rows.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json#rows()}
   */
  @Test
  void testJsonRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json()).rows());
  }
}
