package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolveBulkUploadLegalEntityRelationshipResponse.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableResolveBulkUploadLegalEntityRelationshipResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentHeaders(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAssessmentHeaders(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentHeaders(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAssessmentHeaders(Iterable)"})
  void testBuilderAddAllAssessmentHeaders_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAddAllAssessmentHeadersResult =
        builderResult.addAllAssessmentHeaders(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentHeadersResult);
  }

  /**
   * Test Builder {@link Builder#addAllRows(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRows(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRows(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRows(Iterable)"})
  void testBuilderAddAllRows_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAddAllRowsResult = builderResult.addAllRows(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRowsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentHeaders(AssessmentHeaderCell)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addAssessmentHeaders(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentHeaders(AssessmentHeaderCell) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentHeaders(AssessmentHeaderCell)"})
  void testBuilderAddAssessmentHeadersWithElement() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAddAssessmentHeadersResult =
        builderResult.addAssessmentHeaders(new ImmutableAssessmentHeaderCell.Json());

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentHeaders(AssessmentHeaderCell[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addAssessmentHeaders(AssessmentHeaderCell[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentHeaders(AssessmentHeaderCell[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentHeaders(AssessmentHeaderCell[])"})
  void testBuilderAddAssessmentHeadersWithElements() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAddAssessmentHeadersResult =
        builderResult.addAssessmentHeaders(new ImmutableAssessmentHeaderCell.Json());

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Test Builder {@link Builder#addRows(ResolvedUploadRow)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRows(ResolvedUploadRow)}
   */
  @Test
  @DisplayName("Test Builder addRows(ResolvedUploadRow) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRows(ResolvedUploadRow)"})
  void testBuilderAddRowsWithElement() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAddRowsResult = builderResult.addRows(new ImmutableResolvedUploadRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Test Builder {@link Builder#addRows(ResolvedUploadRow[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRows(ResolvedUploadRow[])}
   */
  @Test
  @DisplayName("Test Builder addRows(ResolvedUploadRow[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRows(ResolvedUploadRow[])"})
  void testBuilderAddRowsWithElements() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAddRowsResult = builderResult.addRows(new ImmutableResolvedUploadRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentHeaders(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentHeaders(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentHeaders(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentHeaders(Iterable)"})
  void testBuilderAssessmentHeaders_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAssessmentHeadersResult = builderResult.assessmentHeaders(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentHeadersResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableResolveBulkUploadLegalEntityRelationshipResponse Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder()
            .build()
            .assessmentHeaders()
            .isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(ResolveBulkUploadLegalEntityRelationshipResponse)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ResolveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ResolveBulkUploadLegalEntityRelationshipResponse); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolveBulkUploadLegalEntityRelationshipResponse)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rows(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#rows(Iterable)}
   */
  @Test
  @DisplayName("Test Builder rows(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rows(Iterable)"})
  void testBuilderRows_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualRowsResult = builderResult.rows(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRowsResult);
  }

  /**
   * Test {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#copyOf(ResolveBulkUploadLegalEntityRelationshipResponse)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return assessmentHeaders Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#copyOf(ResolveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ResolveBulkUploadLegalEntityRelationshipResponse); when builder build; then return assessmentHeaders Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadLegalEntityRelationshipResponse ImmutableResolveBulkUploadLegalEntityRelationshipResponse.copyOf(ResolveBulkUploadLegalEntityRelationshipResponse)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnAssessmentHeadersEmpty() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse instance =
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build();

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualCopyOfResult =
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.copyOf(instance);

    // Assert
    Set<AssessmentHeaderCell> assessmentHeadersResult = actualCopyOfResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualCopyOfResult.rows());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}, and
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   *   <li>{@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableResolveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        immutableResolveBulkUploadLegalEntityRelationshipResponse =
            ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build();
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        immutableResolveBulkUploadLegalEntityRelationshipResponse2 =
            ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build();

    // Act and Assert
    assertEquals(
        immutableResolveBulkUploadLegalEntityRelationshipResponse,
        immutableResolveBulkUploadLegalEntityRelationshipResponse2);
    assertEquals(
        immutableResolveBulkUploadLegalEntityRelationshipResponse.hashCode(),
        immutableResolveBulkUploadLegalEntityRelationshipResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}, and
   * {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   *   <li>{@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableResolveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        immutableResolveBulkUploadLegalEntityRelationshipResponse =
            ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build();

    // Act and Assert
    assertEquals(
        immutableResolveBulkUploadLegalEntityRelationshipResponse,
        immutableResolveBulkUploadLegalEntityRelationshipResponse);
    int expectedHashCodeResult =
        immutableResolveBulkUploadLegalEntityRelationshipResponse.hashCode();
    assertEquals(
        expectedHashCodeResult,
        immutableResolveBulkUploadLegalEntityRelationshipResponse.hashCode());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableResolveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder();

    ImmutableAssessmentHeaderCell.Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    ImmutableAssessmentHeaderCell.Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
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
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    builderResult.addAssessmentHeaders(
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build());

    // Act and Assert
    assertNotEquals(
        builderResult.build(),
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableResolveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build(), null);
  }

  /**
   * Test {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableResolveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build(),
        "Different type to ImmutableResolveBulkUploadLegalEntityRelationshipResponse");
  }

  /**
   * Test {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableAssessmentHeaderCell.Json} (default constructor).
   *   <li>Then return assessmentHeaders size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return assessmentHeaders size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadLegalEntityRelationshipResponse ImmutableResolveBulkUploadLegalEntityRelationshipResponse.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnAssessmentHeadersSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentHeaderCell> assessmentHeaders = new LinkedHashSet<>();
    assessmentHeaders.add(new ImmutableAssessmentHeaderCell.Json());

    Json json = new Json();
    json.setRows(null);
    json.setAssessmentHeaders(assessmentHeaders);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult =
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentHeaders().size());
    assertTrue(actualFromJsonResult.rows().isEmpty());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableResolvedUploadRow.Json}
   *       (default constructor).
   *   <li>Then return rows size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return rows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadLegalEntityRelationshipResponse ImmutableResolveBulkUploadLegalEntityRelationshipResponse.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnRowsSizeIsOne() {
    // Arrange
    LinkedHashSet<ResolvedUploadRow> rows = new LinkedHashSet<>();
    rows.add(new ImmutableResolvedUploadRow.Json());

    Json json = new Json();
    json.setRows(rows);
    json.setAssessmentHeaders(null);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult =
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.rows().size());
    assertTrue(actualFromJsonResult.assessmentHeaders().isEmpty());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Rows is {@code null}.
   *   <li>Then return rows is assessmentHeaders.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Rows is 'null'; then return rows is assessmentHeaders")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadLegalEntityRelationshipResponse ImmutableResolveBulkUploadLegalEntityRelationshipResponse.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonRowsIsNull_thenReturnRowsIsAssessmentHeaders() {
    // Arrange
    Json json = new Json();
    json.setRows(null);
    json.setAssessmentHeaders(null);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult =
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.fromJson(json);

    // Assert
    Set<AssessmentHeaderCell> assessmentHeadersResult = actualFromJsonResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualFromJsonResult.rows());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return rows is {@link Json} (default constructor) {@link Json#rows}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return rows is Json (default constructor) rows")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadLegalEntityRelationshipResponse ImmutableResolveBulkUploadLegalEntityRelationshipResponse.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnRowsIsJsonRows() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult =
        ImmutableResolveBulkUploadLegalEntityRelationshipResponse.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentHeaders().isEmpty());
    Set<ResolvedUploadRow> expectedRowsResult = json.rows;
    assertSame(expectedRowsResult, actualFromJsonResult.rows());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#toString()}
   *   <li>{@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#assessmentHeaders()}
   *   <li>{@link ImmutableResolveBulkUploadLegalEntityRelationshipResponse#rows()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableResolveBulkUploadLegalEntityRelationshipResponse.assessmentHeaders()",
    "Set ImmutableResolveBulkUploadLegalEntityRelationshipResponse.rows()",
    "String ImmutableResolveBulkUploadLegalEntityRelationshipResponse.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        immutableResolveBulkUploadLegalEntityRelationshipResponse =
            ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build();

    // Act
    String actualToStringResult =
        immutableResolveBulkUploadLegalEntityRelationshipResponse.toString();
    Set<AssessmentHeaderCell> actualAssessmentHeadersResult =
        immutableResolveBulkUploadLegalEntityRelationshipResponse.assessmentHeaders();
    Set<ResolvedUploadRow> actualRowsResult =
        immutableResolveBulkUploadLegalEntityRelationshipResponse.rows();

    // Assert
    assertEquals(
        "ResolveBulkUploadLegalEntityRelationshipResponse{rows=[], assessmentHeaders=[]}",
        actualToStringResult);
    assertTrue(actualAssessmentHeadersResult.isEmpty());
    assertSame(actualAssessmentHeadersResult, actualRowsResult);
  }

  /**
   * Test Json {@link Json#assessmentHeaders()}.
   *
   * <p>Method under test: {@link Json#assessmentHeaders()}
   */
  @Test
  @DisplayName("Test Json assessmentHeaders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.assessmentHeaders()"})
  void testJsonAssessmentHeaders() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentHeaders());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertTrue(actualJson.assessmentHeaders.isEmpty());
    assertTrue(actualJson.rows.isEmpty());
  }

  /**
   * Test Json {@link Json#rows()}.
   *
   * <p>Method under test: {@link Json#rows()}
   */
  @Test
  @DisplayName("Test Json rows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.rows()"})
  void testJsonRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rows());
  }

  /**
   * Test {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#withAssessmentHeaders(AssessmentHeaderCell[])}
   * with {@code AssessmentHeaderCell[]}.
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadLegalEntityRelationshipResponse#withAssessmentHeaders(AssessmentHeaderCell[])}
   */
  @Test
  @DisplayName("Test withAssessmentHeaders(AssessmentHeaderCell[]) with 'AssessmentHeaderCell[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadLegalEntityRelationshipResponse ImmutableResolveBulkUploadLegalEntityRelationshipResponse.withAssessmentHeaders(AssessmentHeaderCell[])"
  })
  void testWithAssessmentHeadersWithAssessmentHeaderCell() {
    // Arrange
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse
        immutableResolveBulkUploadLegalEntityRelationshipResponse =
            ImmutableResolveBulkUploadLegalEntityRelationshipResponse.builder().build();

    ImmutableAssessmentHeaderCell.Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    ImmutableAssessmentHeaderCell.Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
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
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act
    ImmutableResolveBulkUploadLegalEntityRelationshipResponse actualWithAssessmentHeadersResult =
        immutableResolveBulkUploadLegalEntityRelationshipResponse.withAssessmentHeaders(
            resolvedAssessmentDefinitionResult
                .resolvedRating(resolvedRating)
                .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
                .build());

    // Assert
    assertEquals(1, actualWithAssessmentHeadersResult.assessmentHeaders().size());
    assertTrue(actualWithAssessmentHeadersResult.rows().isEmpty());
  }
}
