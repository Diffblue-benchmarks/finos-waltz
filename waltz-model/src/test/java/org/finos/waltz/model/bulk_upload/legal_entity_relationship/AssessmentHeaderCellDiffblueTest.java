package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentHeaderCell.Builder;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentHeaderCellDiffblueTest {
  /**
   * Test {@link AssessmentHeaderCell#isSingleValued()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentHeaderCell#isSingleValued()}
   */
  @Test
  @DisplayName("Test isSingleValued(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentHeaderCell.isSingleValued()"})
  void testIsSingleValued_thenReturnFalse() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition = Optional.empty();

    Builder resolvedAssessmentDefinitionResult =
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

    // Act and Assert
    assertFalse(
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build()
            .isSingleValued());
  }

  /**
   * Test {@link AssessmentHeaderCell#isSingleValued()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentHeaderCell#isSingleValued()}
   */
  @Test
  @DisplayName("Test isSingleValued(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentHeaderCell.isSingleValued()"})
  void testIsSingleValued_thenReturnTrue() {
    // Arrange
    Builder inputStringResult =
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

    Builder resolvedAssessmentDefinitionResult =
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

    // Act and Assert
    assertTrue(
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build()
            .isSingleValued());
  }

  /**
   * Test {@link AssessmentHeaderCell#mkHeader(String, Optional, Optional,
   * ResolvedAssessmentHeaderStatus, Set, int)}.
   *
   * <ul>
   *   <li>Then return ratingLookupMap size is four.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentHeaderCell#mkHeader(String, Optional, Optional,
   * ResolvedAssessmentHeaderStatus, Set, int)}
   */
  @Test
  @DisplayName(
      "Test mkHeader(String, Optional, Optional, ResolvedAssessmentHeaderStatus, Set, int); then return ratingLookupMap size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentHeaderCell AssessmentHeaderCell.mkHeader(String, Optional, Optional, ResolvedAssessmentHeaderStatus, Set, int)"
  })
  void testMkHeader_thenReturnRatingLookupMapSizeIsFour() {
    // Arrange
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
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> defn = Optional.of(immutableAssessmentDefinition);
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
    Optional<RatingSchemeItem> rating = Optional.of(immutableRatingSchemeItem);

    HashSet<RatingSchemeItem> ratingSchemeItems = new HashSet<>();
    ratingSchemeItems.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("External Id")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    ratingSchemeItems.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    // Act
    AssessmentHeaderCell actualMkHeaderResult =
        AssessmentHeaderCell.mkHeader(
            "Input String",
            defn,
            rating,
            ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
            ratingSchemeItems,
            1);

    // Assert
    assertTrue(actualMkHeaderResult instanceof ImmutableAssessmentHeaderCell);
    Map<String, RatingSchemeItem> ratingLookupMapResult = actualMkHeaderResult.ratingLookupMap();
    assertEquals(4, ratingLookupMapResult.size());
    RatingSchemeItem getResult = ratingLookupMapResult.get("external id");
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(ratingLookupMapResult.containsKey("42"));
    assertTrue(ratingLookupMapResult.containsKey("name"));
    assertTrue(ratingLookupMapResult.containsKey("rating"));
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test {@link AssessmentHeaderCell#mkHeader(String, Optional, Optional,
   * ResolvedAssessmentHeaderStatus, Set, int)}.
   *
   * <ul>
   *   <li>Then return ratingLookupMap size is three.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentHeaderCell#mkHeader(String, Optional, Optional,
   * ResolvedAssessmentHeaderStatus, Set, int)}
   */
  @Test
  @DisplayName(
      "Test mkHeader(String, Optional, Optional, ResolvedAssessmentHeaderStatus, Set, int); then return ratingLookupMap size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentHeaderCell AssessmentHeaderCell.mkHeader(String, Optional, Optional, ResolvedAssessmentHeaderStatus, Set, int)"
  })
  void testMkHeader_thenReturnRatingLookupMapSizeIsThree() {
    // Arrange
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
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> defn = Optional.of(immutableAssessmentDefinition);
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
    Optional<RatingSchemeItem> rating = Optional.of(immutableRatingSchemeItem);

    HashSet<RatingSchemeItem> ratingSchemeItems = new HashSet<>();
    ratingSchemeItems.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    // Act
    AssessmentHeaderCell actualMkHeaderResult =
        AssessmentHeaderCell.mkHeader(
            "Input String",
            defn,
            rating,
            ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
            ratingSchemeItems,
            1);

    // Assert
    assertTrue(actualMkHeaderResult instanceof ImmutableAssessmentHeaderCell);
    Map<String, RatingSchemeItem> ratingLookupMapResult = actualMkHeaderResult.ratingLookupMap();
    assertEquals(3, ratingLookupMapResult.size());
    RatingSchemeItem getResult = ratingLookupMapResult.get("name");
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
    assertSame(getResult, ratingLookupMapResult.get("42"));
    assertSame(getResult, ratingLookupMapResult.get("rating"));
  }

  /**
   * Test {@link AssessmentHeaderCell#mkHeader(String, Optional, Optional,
   * ResolvedAssessmentHeaderStatus, Set, int)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentHeaderCell#mkHeader(String, Optional, Optional,
   * ResolvedAssessmentHeaderStatus, Set, int)}
   */
  @Test
  @DisplayName(
      "Test mkHeader(String, Optional, Optional, ResolvedAssessmentHeaderStatus, Set, int); when HashSet(); then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentHeaderCell AssessmentHeaderCell.mkHeader(String, Optional, Optional, ResolvedAssessmentHeaderStatus, Set, int)"
  })
  void testMkHeader_whenHashSet_thenReturnInputString() {
    // Arrange
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
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> defn = Optional.of(immutableAssessmentDefinition);
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
    Optional<RatingSchemeItem> rating = Optional.of(immutableRatingSchemeItem);

    // Act
    AssessmentHeaderCell actualMkHeaderResult =
        AssessmentHeaderCell.mkHeader(
            "Input String",
            defn,
            rating,
            ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
            new HashSet<>(),
            1);

    // Assert
    assertTrue(actualMkHeaderResult instanceof ImmutableAssessmentHeaderCell);
    assertEquals("Input String", actualMkHeaderResult.inputString());
    assertEquals(1, actualMkHeaderResult.columnId());
    assertEquals(
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualMkHeaderResult.status());
    assertTrue(actualMkHeaderResult.ratingLookupMap().isEmpty());
    assertTrue(actualMkHeaderResult.isSingleValued());
  }
}
